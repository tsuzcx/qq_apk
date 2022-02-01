package com.android.dex;

import com.android.dex.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class Dex
{
  private static final int CHECKSUM_OFFSET = 8;
  private static final int CHECKSUM_SIZE = 4;
  static final short[] EMPTY_SHORT_ARRAY = new short[0];
  private static final int SIGNATURE_OFFSET = 12;
  private static final int SIGNATURE_SIZE = 20;
  private ByteBuffer data;
  private final Dex.FieldIdTable fieldIds = new Dex.FieldIdTable(this, null);
  private final Dex.MethodIdTable methodIds = new Dex.MethodIdTable(this, null);
  private int nextSectionStart = 0;
  private final Dex.ProtoIdTable protoIds = new Dex.ProtoIdTable(this, null);
  private final Dex.StringTable strings = new Dex.StringTable(this, null);
  private final TableOfContents tableOfContents = new TableOfContents();
  private final Dex.TypeIndexToDescriptorIndexTable typeIds = new Dex.TypeIndexToDescriptorIndexTable(this, null);
  private final Dex.TypeIndexToDescriptorTable typeNames = new Dex.TypeIndexToDescriptorTable(this, null);
  
  public Dex(int paramInt)
  {
    this.data = ByteBuffer.wrap(new byte[paramInt]);
    this.data.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  public Dex(File paramFile)
  {
    if (FileUtils.hasArchiveSuffix(paramFile.getName()))
    {
      ZipFile localZipFile = new ZipFile(paramFile);
      ZipEntry localZipEntry = localZipFile.getEntry("classes.dex");
      if (localZipEntry != null)
      {
        loadFrom(localZipFile.getInputStream(localZipEntry));
        localZipFile.close();
        return;
      }
      throw new DexException("Expected classes.dex in " + paramFile);
    }
    if (paramFile.getName().endsWith(".dex"))
    {
      loadFrom(new FileInputStream(paramFile));
      return;
    }
    throw new DexException("unknown output extension: " + paramFile);
  }
  
  public Dex(InputStream paramInputStream)
  {
    loadFrom(paramInputStream);
  }
  
  private Dex(ByteBuffer paramByteBuffer)
  {
    this.data = paramByteBuffer;
    this.data.order(ByteOrder.LITTLE_ENDIAN);
    this.tableOfContents.readFrom(this);
  }
  
  public Dex(byte[] paramArrayOfByte)
  {
    this(ByteBuffer.wrap(paramArrayOfByte));
  }
  
  private static void checkBounds(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2)) {
      throw new IndexOutOfBoundsException("index:" + paramInt1 + ", length=" + paramInt2);
    }
  }
  
  public static Dex create(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    ByteBuffer localByteBuffer = paramByteBuffer;
    if (paramByteBuffer.get(0) == 100)
    {
      localByteBuffer = paramByteBuffer;
      if (paramByteBuffer.get(1) == 101)
      {
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer.get(2) == 121)
        {
          localByteBuffer = paramByteBuffer;
          if (paramByteBuffer.get(3) == 10)
          {
            paramByteBuffer.position(8);
            int i = paramByteBuffer.getInt();
            int j = paramByteBuffer.getInt();
            paramByteBuffer.position(i);
            paramByteBuffer.limit(i + j);
            localByteBuffer = paramByteBuffer.slice();
          }
        }
      }
    }
    return new Dex(localByteBuffer);
  }
  
  private void loadFrom(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream.close();
    this.data = ByteBuffer.wrap(localByteArrayOutputStream.toByteArray());
    this.data.order(ByteOrder.LITTLE_ENDIAN);
    this.tableOfContents.readFrom(this);
  }
  
  public int annotationDirectoryOffsetFromClassDefIndex(int paramInt)
  {
    checkBounds(paramInt, this.tableOfContents.classDefs.size);
    int i = this.tableOfContents.classDefs.off;
    return this.data.getInt(i + paramInt * 32 + 4 + 4 + 4 + 4 + 4);
  }
  
  public Dex.Section appendSection(int paramInt, String paramString)
  {
    if ((paramInt & 0x3) != 0) {
      throw new IllegalStateException("Not four byte aligned!");
    }
    paramInt = this.nextSectionStart + paramInt;
    ByteBuffer localByteBuffer = this.data.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(this.nextSectionStart);
    localByteBuffer.limit(paramInt);
    paramString = new Dex.Section(this, paramString, localByteBuffer, null);
    this.nextSectionStart = paramInt;
    return paramString;
  }
  
  public Iterable<ClassDef> classDefs()
  {
    return new Dex.ClassDefIterable(this, null);
  }
  
  public int computeChecksum()
  {
    Adler32 localAdler32 = new Adler32();
    byte[] arrayOfByte = new byte[8192];
    ByteBuffer localByteBuffer = this.data.duplicate();
    localByteBuffer.limit(localByteBuffer.capacity());
    localByteBuffer.position(12);
    while (localByteBuffer.hasRemaining())
    {
      int i = Math.min(arrayOfByte.length, localByteBuffer.remaining());
      localByteBuffer.get(arrayOfByte, 0, i);
      localAdler32.update(arrayOfByte, 0, i);
    }
    return (int)localAdler32.getValue();
  }
  
  public byte[] computeSignature()
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte = new byte[8192];
      ByteBuffer localByteBuffer = this.data.duplicate();
      localByteBuffer.limit(localByteBuffer.capacity());
      localByteBuffer.position(32);
      while (localByteBuffer.hasRemaining())
      {
        int i = Math.min(arrayOfByte.length, localByteBuffer.remaining());
        localByteBuffer.get(arrayOfByte, 0, i);
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      return localNoSuchAlgorithmException.digest();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError();
    }
  }
  
  public int declaringClassIndexFromMethodIndex(int paramInt)
  {
    checkBounds(paramInt, this.tableOfContents.methodIds.size);
    int i = this.tableOfContents.methodIds.off;
    return this.data.getShort(i + paramInt * 8) & 0xFFFF;
  }
  
  public int descriptorIndexFromTypeIndex(int paramInt)
  {
    checkBounds(paramInt, this.tableOfContents.typeIds.size);
    int i = this.tableOfContents.typeIds.off;
    return this.data.getInt(i + paramInt * 4);
  }
  
  public List<FieldId> fieldIds()
  {
    return this.fieldIds;
  }
  
  public int findClassDefIndexFromTypeIndex(int paramInt)
  {
    checkBounds(paramInt, this.tableOfContents.typeIds.size);
    int j;
    if (!this.tableOfContents.classDefs.exists())
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.tableOfContents.classDefs.size) {
        break label65;
      }
      j = i;
      if (typeIndexFromClassDefIndex(i) == paramInt) {
        break;
      }
      i += 1;
    }
    label65:
    return -1;
  }
  
  public int findFieldIndex(FieldId paramFieldId)
  {
    return Collections.binarySearch(this.fieldIds, paramFieldId);
  }
  
  public int findMethodIndex(MethodId paramMethodId)
  {
    return Collections.binarySearch(this.methodIds, paramMethodId);
  }
  
  public int findStringIndex(String paramString)
  {
    return Collections.binarySearch(this.strings, paramString);
  }
  
  public int findTypeIndex(String paramString)
  {
    return Collections.binarySearch(this.typeNames, paramString);
  }
  
  public byte[] getBytes()
  {
    ByteBuffer localByteBuffer = this.data.duplicate();
    byte[] arrayOfByte = new byte[localByteBuffer.capacity()];
    localByteBuffer.position(0);
    localByteBuffer.get(arrayOfByte);
    return arrayOfByte;
  }
  
  public int getLength()
  {
    return this.data.capacity();
  }
  
  public int getNextSectionStart()
  {
    return this.nextSectionStart;
  }
  
  public TableOfContents getTableOfContents()
  {
    return this.tableOfContents;
  }
  
  public short[] interfaceTypeIndicesFromClassDefIndex(int paramInt)
  {
    checkBounds(paramInt, this.tableOfContents.classDefs.size);
    int i = this.tableOfContents.classDefs.off;
    paramInt = this.data.getInt(i + paramInt * 32 + 4 + 4 + 4);
    Object localObject;
    if (paramInt == 0)
    {
      localObject = EMPTY_SHORT_ARRAY;
      return localObject;
    }
    int j = this.data.getInt(paramInt);
    if (j <= 0) {
      throw new AssertionError("Unexpected interfaces list size: " + j);
    }
    i = paramInt + 4;
    short[] arrayOfShort = new short[j];
    paramInt = 0;
    for (;;)
    {
      localObject = arrayOfShort;
      if (paramInt >= j) {
        break;
      }
      arrayOfShort[paramInt] = this.data.getShort(i);
      i += 2;
      paramInt += 1;
    }
  }
  
  public List<MethodId> methodIds()
  {
    return this.methodIds;
  }
  
  public int nameIndexFromFieldIndex(int paramInt)
  {
    checkBounds(paramInt, this.tableOfContents.fieldIds.size);
    int i = this.tableOfContents.fieldIds.off;
    return this.data.getInt(i + paramInt * 8 + 2 + 2);
  }
  
  public int nameIndexFromMethodIndex(int paramInt)
  {
    checkBounds(paramInt, this.tableOfContents.methodIds.size);
    int i = this.tableOfContents.methodIds.off;
    return this.data.getInt(i + paramInt * 8 + 2 + 2);
  }
  
  public Dex.Section open(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.data.capacity())) {
      throw new IllegalArgumentException("position=" + paramInt + " length=" + this.data.capacity());
    }
    ByteBuffer localByteBuffer = this.data.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(paramInt);
    localByteBuffer.limit(this.data.capacity());
    return new Dex.Section(this, "section", localByteBuffer, null);
  }
  
  public short[] parameterTypeIndicesFromMethodIndex(int paramInt)
  {
    checkBounds(paramInt, this.tableOfContents.methodIds.size);
    int i = this.tableOfContents.methodIds.off;
    paramInt = this.data.getShort(i + paramInt * 8 + 2) & 0xFFFF;
    checkBounds(paramInt, this.tableOfContents.protoIds.size);
    i = this.tableOfContents.protoIds.off;
    paramInt = this.data.getInt(paramInt * 12 + i + 4 + 4);
    Object localObject;
    if (paramInt == 0)
    {
      localObject = EMPTY_SHORT_ARRAY;
      return localObject;
    }
    int j = this.data.getInt(paramInt);
    if (j <= 0) {
      throw new AssertionError("Unexpected parameter type list size: " + j);
    }
    i = paramInt + 4;
    short[] arrayOfShort = new short[j];
    paramInt = 0;
    for (;;)
    {
      localObject = arrayOfShort;
      if (paramInt >= j) {
        break;
      }
      arrayOfShort[paramInt] = this.data.getShort(i);
      i += 2;
      paramInt += 1;
    }
  }
  
  public List<ProtoId> protoIds()
  {
    return this.protoIds;
  }
  
  public ClassData readClassData(ClassDef paramClassDef)
  {
    int i = paramClassDef.getClassDataOffset();
    if (i == 0) {
      throw new IllegalArgumentException("offset == 0");
    }
    return Dex.Section.access$800(open(i));
  }
  
  public Code readCode(ClassData.Method paramMethod)
  {
    int i = paramMethod.getCodeOffset();
    if (i == 0) {
      throw new IllegalArgumentException("offset == 0");
    }
    return Dex.Section.access$900(open(i));
  }
  
  public TypeList readTypeList(int paramInt)
  {
    if (paramInt == 0) {
      return TypeList.EMPTY;
    }
    return open(paramInt).readTypeList();
  }
  
  public int returnTypeIndexFromMethodIndex(int paramInt)
  {
    checkBounds(paramInt, this.tableOfContents.methodIds.size);
    int i = this.tableOfContents.methodIds.off;
    paramInt = this.data.getShort(i + paramInt * 8 + 2) & 0xFFFF;
    checkBounds(paramInt, this.tableOfContents.protoIds.size);
    i = this.tableOfContents.protoIds.off;
    return this.data.getInt(paramInt * 12 + i + 4);
  }
  
  public List<String> strings()
  {
    return this.strings;
  }
  
  public List<Integer> typeIds()
  {
    return this.typeIds;
  }
  
  public int typeIndexFromClassDefIndex(int paramInt)
  {
    checkBounds(paramInt, this.tableOfContents.classDefs.size);
    int i = this.tableOfContents.classDefs.off;
    return this.data.getInt(i + paramInt * 32);
  }
  
  public int typeIndexFromFieldIndex(int paramInt)
  {
    checkBounds(paramInt, this.tableOfContents.fieldIds.size);
    int i = this.tableOfContents.fieldIds.off;
    return this.data.getShort(i + paramInt * 8 + 2) & 0xFFFF;
  }
  
  public List<String> typeNames()
  {
    return this.typeNames;
  }
  
  public void writeHashes()
  {
    open(12).write(computeSignature());
    open(8).writeInt(computeChecksum());
  }
  
  public void writeTo(File paramFile)
  {
    paramFile = new FileOutputStream(paramFile);
    writeTo(paramFile);
    paramFile.close();
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[8192];
    ByteBuffer localByteBuffer = this.data.duplicate();
    localByteBuffer.clear();
    while (localByteBuffer.hasRemaining())
    {
      int i = Math.min(arrayOfByte.length, localByteBuffer.remaining());
      localByteBuffer.get(arrayOfByte, 0, i);
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Dex
 * JD-Core Version:    0.7.0.1
 */