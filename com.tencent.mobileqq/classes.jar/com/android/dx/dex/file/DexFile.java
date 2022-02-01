package com.android.dx.dex.file;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.dex.DexOptions;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstBaseMethodRef;
import com.android.dx.rop.cst.CstEnumRef;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import java.io.OutputStream;
import java.io.Writer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.zip.Adler32;

public final class DexFile
{
  private final MixedItemSection byteData;
  private final MixedItemSection classData;
  private final ClassDefsSection classDefs;
  private DexOptions dexOptions;
  private int dumpWidth;
  private final FieldIdsSection fieldIds;
  private int fileSize;
  private final HeaderSection header;
  private final MixedItemSection map;
  private final MethodIdsSection methodIds;
  private final ProtoIdsSection protoIds;
  private final Section[] sections;
  private final MixedItemSection stringData;
  private final StringIdsSection stringIds;
  private final TypeIdsSection typeIds;
  private final MixedItemSection typeLists;
  private final MixedItemSection wordData;
  
  public DexFile(DexOptions paramDexOptions)
  {
    this.dexOptions = paramDexOptions;
    this.header = new HeaderSection(this);
    this.typeLists = new MixedItemSection(null, this, 4, MixedItemSection.SortType.NONE);
    this.wordData = new MixedItemSection("word_data", this, 4, MixedItemSection.SortType.TYPE);
    this.stringData = new MixedItemSection("string_data", this, 1, MixedItemSection.SortType.INSTANCE);
    this.classData = new MixedItemSection(null, this, 1, MixedItemSection.SortType.NONE);
    this.byteData = new MixedItemSection("byte_data", this, 1, MixedItemSection.SortType.TYPE);
    this.stringIds = new StringIdsSection(this);
    this.typeIds = new TypeIdsSection(this);
    this.protoIds = new ProtoIdsSection(this);
    this.fieldIds = new FieldIdsSection(this);
    this.methodIds = new MethodIdsSection(this);
    this.classDefs = new ClassDefsSection(this);
    this.map = new MixedItemSection("map", this, 4, MixedItemSection.SortType.NONE);
    this.sections = new Section[] { this.header, this.stringIds, this.typeIds, this.protoIds, this.fieldIds, this.methodIds, this.classDefs, this.wordData, this.typeLists, this.stringData, this.byteData, this.classData, this.map };
    this.fileSize = -1;
    this.dumpWidth = 79;
  }
  
  private static void calcChecksum(byte[] paramArrayOfByte)
  {
    Adler32 localAdler32 = new Adler32();
    localAdler32.update(paramArrayOfByte, 12, paramArrayOfByte.length - 12);
    int i = (int)localAdler32.getValue();
    paramArrayOfByte[8] = ((byte)i);
    paramArrayOfByte[9] = ((byte)(i >> 8));
    paramArrayOfByte[10] = ((byte)(i >> 16));
    paramArrayOfByte[11] = ((byte)(i >> 24));
  }
  
  private static void calcSignature(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramArrayOfByte, 32, paramArrayOfByte.length - 32);
      try
      {
        int i = localMessageDigest.digest(paramArrayOfByte, 12, 20);
        if (i != 20) {
          throw new RuntimeException("unexpected digest write: " + i + " bytes");
        }
      }
      catch (DigestException paramArrayOfByte)
      {
        throw new RuntimeException(paramArrayOfByte);
      }
      return;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  private ByteArrayAnnotatedOutput toDex0(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    this.classDefs.prepare();
    this.classData.prepare();
    this.wordData.prepare();
    this.byteData.prepare();
    this.methodIds.prepare();
    this.fieldIds.prepare();
    this.protoIds.prepare();
    this.typeLists.prepare();
    this.typeIds.prepare();
    this.stringIds.prepare();
    this.stringData.prepare();
    this.header.prepare();
    int m = this.sections.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Section localSection1 = this.sections[i];
      int n = localSection1.setFileOffset(j);
      if (n < j) {
        throw new RuntimeException("bogus placement for section " + i);
      }
      try
      {
        if (localSection1 == this.map)
        {
          MapItem.addMap(this.sections, this.map);
          this.map.prepare();
        }
        if ((localSection1 instanceof MixedItemSection)) {
          ((MixedItemSection)localSection1).placeItems();
        }
        j = localSection1.writeSize();
        i += 1;
        j = n + j;
      }
      catch (RuntimeException localRuntimeException1)
      {
        throw ExceptionWithContext.withContext(localRuntimeException1, "...while writing section " + i);
      }
    }
    this.fileSize = j;
    byte[] arrayOfByte = new byte[this.fileSize];
    ByteArrayAnnotatedOutput localByteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(arrayOfByte);
    i = k;
    if (paramBoolean1)
    {
      localByteArrayAnnotatedOutput.enableAnnotations(this.dumpWidth, paramBoolean2);
      i = k;
    }
    ExceptionWithContext localExceptionWithContext;
    if (i < m)
    {
      Section localSection2;
      try
      {
        localSection2 = this.sections[i];
        j = localSection2.getFileOffset() - localByteArrayAnnotatedOutput.getCursor();
        if (j < 0) {
          throw new ExceptionWithContext("excess write of " + -j);
        }
      }
      catch (RuntimeException localRuntimeException2)
      {
        if (!(localRuntimeException2 instanceof ExceptionWithContext)) {}
      }
      for (localExceptionWithContext = (ExceptionWithContext)localRuntimeException2;; localExceptionWithContext = new ExceptionWithContext(localExceptionWithContext))
      {
        localExceptionWithContext.addContext("...while writing section " + i);
        throw localExceptionWithContext;
        localByteArrayAnnotatedOutput.writeZeroes(localSection2.getFileOffset() - localByteArrayAnnotatedOutput.getCursor());
        localSection2.writeTo(localByteArrayAnnotatedOutput);
        i += 1;
        break;
      }
    }
    if (localByteArrayAnnotatedOutput.getCursor() != this.fileSize) {
      throw new RuntimeException("foreshortened write");
    }
    calcSignature(localExceptionWithContext);
    calcChecksum(localExceptionWithContext);
    if (paramBoolean1)
    {
      this.wordData.writeIndexAnnotation(localByteArrayAnnotatedOutput, ItemType.TYPE_CODE_ITEM, "\nmethod code index:\n\n");
      getStatistics().writeAnnotation(localByteArrayAnnotatedOutput);
      localByteArrayAnnotatedOutput.finishAnnotating();
    }
    return localByteArrayAnnotatedOutput;
  }
  
  public void add(ClassDefItem paramClassDefItem)
  {
    this.classDefs.add(paramClassDefItem);
  }
  
  IndexedItem findItemOrNull(Constant paramConstant)
  {
    if ((paramConstant instanceof CstString)) {
      return this.stringIds.get(paramConstant);
    }
    if ((paramConstant instanceof CstType)) {
      return this.typeIds.get(paramConstant);
    }
    if ((paramConstant instanceof CstBaseMethodRef)) {
      return this.methodIds.get(paramConstant);
    }
    if ((paramConstant instanceof CstFieldRef)) {
      return this.fieldIds.get(paramConstant);
    }
    return null;
  }
  
  MixedItemSection getByteData()
  {
    return this.byteData;
  }
  
  MixedItemSection getClassData()
  {
    return this.classData;
  }
  
  public ClassDefsSection getClassDefs()
  {
    return this.classDefs;
  }
  
  public ClassDefItem getClassOrNull(String paramString)
  {
    try
    {
      paramString = Type.internClassName(paramString);
      paramString = (ClassDefItem)this.classDefs.get(new CstType(paramString));
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
  
  public DexOptions getDexOptions()
  {
    return this.dexOptions;
  }
  
  public FieldIdsSection getFieldIds()
  {
    return this.fieldIds;
  }
  
  public int getFileSize()
  {
    if (this.fileSize < 0) {
      throw new RuntimeException("file size not yet known");
    }
    return this.fileSize;
  }
  
  Section getFirstDataSection()
  {
    return this.wordData;
  }
  
  Section getLastDataSection()
  {
    return this.map;
  }
  
  MixedItemSection getMap()
  {
    return this.map;
  }
  
  public MethodIdsSection getMethodIds()
  {
    return this.methodIds;
  }
  
  ProtoIdsSection getProtoIds()
  {
    return this.protoIds;
  }
  
  public Statistics getStatistics()
  {
    Statistics localStatistics = new Statistics();
    Section[] arrayOfSection = this.sections;
    int j = arrayOfSection.length;
    int i = 0;
    while (i < j)
    {
      localStatistics.addAll(arrayOfSection[i]);
      i += 1;
    }
    return localStatistics;
  }
  
  MixedItemSection getStringData()
  {
    return this.stringData;
  }
  
  StringIdsSection getStringIds()
  {
    return this.stringIds;
  }
  
  public TypeIdsSection getTypeIds()
  {
    return this.typeIds;
  }
  
  MixedItemSection getTypeLists()
  {
    return this.typeLists;
  }
  
  MixedItemSection getWordData()
  {
    return this.wordData;
  }
  
  void internIfAppropriate(Constant paramConstant)
  {
    if ((paramConstant instanceof CstString)) {
      this.stringIds.intern((CstString)paramConstant);
    }
    do
    {
      return;
      if ((paramConstant instanceof CstType))
      {
        this.typeIds.intern((CstType)paramConstant);
        return;
      }
      if ((paramConstant instanceof CstBaseMethodRef))
      {
        this.methodIds.intern((CstBaseMethodRef)paramConstant);
        return;
      }
      if ((paramConstant instanceof CstFieldRef))
      {
        this.fieldIds.intern((CstFieldRef)paramConstant);
        return;
      }
      if ((paramConstant instanceof CstEnumRef))
      {
        this.fieldIds.intern(((CstEnumRef)paramConstant).getFieldRef());
        return;
      }
    } while (paramConstant != null);
    throw new NullPointerException("cst == null");
  }
  
  public boolean isEmpty()
  {
    return this.classDefs.items().isEmpty();
  }
  
  public void setDumpWidth(int paramInt)
  {
    if (paramInt < 40) {
      throw new IllegalArgumentException("dumpWidth < 40");
    }
    this.dumpWidth = paramInt;
  }
  
  public byte[] toDex(Writer paramWriter, boolean paramBoolean)
  {
    if (paramWriter != null) {}
    for (boolean bool = true;; bool = false)
    {
      ByteArrayAnnotatedOutput localByteArrayAnnotatedOutput = toDex0(bool, paramBoolean);
      if (bool) {
        localByteArrayAnnotatedOutput.writeAnnotationsTo(paramWriter);
      }
      return localByteArrayAnnotatedOutput.getArray();
    }
  }
  
  public void writeTo(OutputStream paramOutputStream, Writer paramWriter, boolean paramBoolean)
  {
    if (paramWriter != null) {}
    for (boolean bool = true;; bool = false)
    {
      ByteArrayAnnotatedOutput localByteArrayAnnotatedOutput = toDex0(bool, paramBoolean);
      if (paramOutputStream != null) {
        paramOutputStream.write(localByteArrayAnnotatedOutput.getArray());
      }
      if (bool) {
        localByteArrayAnnotatedOutput.writeAnnotationsTo(paramWriter);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.DexFile
 * JD-Core Version:    0.7.0.1
 */