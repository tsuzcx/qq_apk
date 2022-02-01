package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.zip.ZipException;

public class ZipEntry
  extends java.util.zip.ZipEntry
  implements Cloneable
{
  private static final byte[] EMPTY = new byte[0];
  public static final int PLATFORM_FAT = 0;
  public static final int PLATFORM_UNIX = 3;
  private static final int SHORT_MASK = 65535;
  private static final int SHORT_SHIFT = 16;
  private long externalAttributes = 0L;
  private LinkedHashMap<ZipShort, ZipExtraField> extraFields = null;
  private GeneralPurposeBit gpb = new GeneralPurposeBit();
  private int internalAttributes = 0;
  private int method = -1;
  private String name = null;
  private int platform = 0;
  private byte[] rawName = null;
  private long size = -1L;
  private UnparseableExtraFieldData unparseableExtra = null;
  
  protected ZipEntry()
  {
    this("");
  }
  
  public ZipEntry(ZipEntry paramZipEntry)
  {
    this(paramZipEntry);
    setInternalAttributes(paramZipEntry.getInternalAttributes());
    setExternalAttributes(paramZipEntry.getExternalAttributes());
    setExtraFields(paramZipEntry.getExtraFields(true));
  }
  
  public ZipEntry(File paramFile, String paramString)
  {
    this((String)localObject);
    if (paramFile.isFile()) {
      setSize(paramFile.length());
    }
    setTime(paramFile.lastModified());
  }
  
  public ZipEntry(String paramString)
  {
    super(paramString);
    setName(paramString);
  }
  
  public ZipEntry(java.util.zip.ZipEntry paramZipEntry)
  {
    super(paramZipEntry);
    setName(safeGetName(paramZipEntry));
    byte[] arrayOfByte = paramZipEntry.getExtra();
    if (arrayOfByte != null) {
      setExtraFields(ExtraFieldUtils.parse(arrayOfByte, true, ExtraFieldUtils.UnparseableExtraField.READ));
    } else {
      setExtra();
    }
    setMethod(paramZipEntry.getMethod());
    this.size = paramZipEntry.getSize();
  }
  
  private void mergeExtraFields(ZipExtraField[] paramArrayOfZipExtraField, boolean paramBoolean)
  {
    if (this.extraFields == null)
    {
      setExtraFields(paramArrayOfZipExtraField);
      return;
    }
    int j = paramArrayOfZipExtraField.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramArrayOfZipExtraField[i];
      Object localObject1;
      if ((localObject2 instanceof UnparseableExtraFieldData)) {
        localObject1 = this.unparseableExtra;
      } else {
        localObject1 = getExtraField(((ZipExtraField)localObject2).getHeaderId());
      }
      if (localObject1 == null)
      {
        addExtraField((ZipExtraField)localObject2);
      }
      else if ((!paramBoolean) && ((localObject1 instanceof CentralDirectoryParsingZipExtraField)))
      {
        localObject2 = ((ZipExtraField)localObject2).getCentralDirectoryData();
        ((CentralDirectoryParsingZipExtraField)localObject1).parseFromCentralDirectoryData((byte[])localObject2, 0, localObject2.length);
      }
      else
      {
        localObject2 = ((ZipExtraField)localObject2).getLocalFileDataData();
        ((ZipExtraField)localObject1).parseFromLocalFileData((byte[])localObject2, 0, localObject2.length);
      }
      i += 1;
    }
    setExtra();
  }
  
  static String safeGetName(java.util.zip.ZipEntry paramZipEntry)
  {
    String str = paramZipEntry.getName();
    paramZipEntry = str;
    if (str.contains("../")) {
      paramZipEntry = null;
    }
    return paramZipEntry;
  }
  
  public void addAsFirstExtraField(ZipExtraField paramZipExtraField)
  {
    if ((paramZipExtraField instanceof UnparseableExtraFieldData))
    {
      this.unparseableExtra = ((UnparseableExtraFieldData)paramZipExtraField);
    }
    else
    {
      LinkedHashMap localLinkedHashMap = this.extraFields;
      this.extraFields = new LinkedHashMap();
      this.extraFields.put(paramZipExtraField.getHeaderId(), paramZipExtraField);
      if (localLinkedHashMap != null)
      {
        localLinkedHashMap.remove(paramZipExtraField.getHeaderId());
        this.extraFields.putAll(localLinkedHashMap);
      }
    }
    setExtra();
  }
  
  public void addExtraField(ZipExtraField paramZipExtraField)
  {
    if ((paramZipExtraField instanceof UnparseableExtraFieldData))
    {
      this.unparseableExtra = ((UnparseableExtraFieldData)paramZipExtraField);
    }
    else
    {
      if (this.extraFields == null) {
        this.extraFields = new LinkedHashMap();
      }
      this.extraFields.put(paramZipExtraField.getHeaderId(), paramZipExtraField);
    }
    setExtra();
  }
  
  public Object clone()
  {
    ZipEntry localZipEntry = (ZipEntry)super.clone();
    localZipEntry.setInternalAttributes(getInternalAttributes());
    localZipEntry.setExternalAttributes(getExternalAttributes());
    localZipEntry.setExtraFields(getExtraFields(true));
    return localZipEntry;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      ZipEntry localZipEntry = (ZipEntry)paramObject;
      paramObject = getName();
      Object localObject = safeGetName(localZipEntry);
      if (paramObject == null)
      {
        if (localObject != null) {
          return false;
        }
      }
      else if (!paramObject.equals(localObject)) {
        return false;
      }
      localObject = getComment();
      String str = localZipEntry.getComment();
      paramObject = localObject;
      if (localObject == null) {
        paramObject = "";
      }
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      return (getTime() == localZipEntry.getTime()) && (paramObject.equals(localObject)) && (getInternalAttributes() == localZipEntry.getInternalAttributes()) && (getPlatform() == localZipEntry.getPlatform()) && (getExternalAttributes() == localZipEntry.getExternalAttributes()) && (getMethod() == localZipEntry.getMethod()) && (getSize() == localZipEntry.getSize()) && (getCrc() == localZipEntry.getCrc()) && (getCompressedSize() == localZipEntry.getCompressedSize()) && (Arrays.equals(getCentralDirectoryExtra(), localZipEntry.getCentralDirectoryExtra())) && (Arrays.equals(getLocalFileDataExtra(), localZipEntry.getLocalFileDataExtra())) && (this.gpb.equals(localZipEntry.gpb));
    }
    return false;
  }
  
  public byte[] getCentralDirectoryExtra()
  {
    return ExtraFieldUtils.mergeCentralDirectoryData(getExtraFields(true));
  }
  
  public long getExternalAttributes()
  {
    return this.externalAttributes;
  }
  
  public ZipExtraField getExtraField(ZipShort paramZipShort)
  {
    LinkedHashMap localLinkedHashMap = this.extraFields;
    if (localLinkedHashMap != null) {
      return (ZipExtraField)localLinkedHashMap.get(paramZipShort);
    }
    return null;
  }
  
  public ZipExtraField[] getExtraFields()
  {
    return getExtraFields(false);
  }
  
  public ZipExtraField[] getExtraFields(boolean paramBoolean)
  {
    Object localObject = this.extraFields;
    if (localObject == null)
    {
      if (paramBoolean)
      {
        localObject = this.unparseableExtra;
        if (localObject != null) {
          return new ZipExtraField[] { localObject };
        }
      }
      return new ZipExtraField[0];
    }
    localObject = new ArrayList(((LinkedHashMap)localObject).values());
    if (paramBoolean)
    {
      UnparseableExtraFieldData localUnparseableExtraFieldData = this.unparseableExtra;
      if (localUnparseableExtraFieldData != null) {
        ((List)localObject).add(localUnparseableExtraFieldData);
      }
    }
    return (ZipExtraField[])((List)localObject).toArray(new ZipExtraField[0]);
  }
  
  public GeneralPurposeBit getGeneralPurposeBit()
  {
    return this.gpb;
  }
  
  public int getInternalAttributes()
  {
    return this.internalAttributes;
  }
  
  public Date getLastModifiedDate()
  {
    return new Date(getTime());
  }
  
  public byte[] getLocalFileDataExtra()
  {
    byte[] arrayOfByte = getExtra();
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    return EMPTY;
  }
  
  public int getMethod()
  {
    return this.method;
  }
  
  public String getName()
  {
    String str2 = this.name;
    String str1 = str2;
    if (str2 == null)
    {
      str2 = super.getName();
      str1 = str2;
      if (str2.contains("../")) {
        str1 = null;
      }
    }
    return str1;
  }
  
  public int getPlatform()
  {
    return this.platform;
  }
  
  public byte[] getRawName()
  {
    byte[] arrayOfByte1 = this.rawName;
    if (arrayOfByte1 != null)
    {
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
      return arrayOfByte2;
    }
    return null;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public int getUnixMode()
  {
    if (this.platform != 3) {
      return 0;
    }
    return (int)(getExternalAttributes() >> 16 & 0xFFFF);
  }
  
  public UnparseableExtraFieldData getUnparseableExtraFieldData()
  {
    return this.unparseableExtra;
  }
  
  public int hashCode()
  {
    return getName().hashCode();
  }
  
  public boolean isDirectory()
  {
    return getName().endsWith("/");
  }
  
  public void removeExtraField(ZipShort paramZipShort)
  {
    LinkedHashMap localLinkedHashMap = this.extraFields;
    if (localLinkedHashMap != null)
    {
      if (localLinkedHashMap.remove(paramZipShort) != null)
      {
        setExtra();
        return;
      }
      throw new NoSuchElementException();
    }
    throw new NoSuchElementException();
  }
  
  public void removeUnparseableExtraFieldData()
  {
    if (this.unparseableExtra != null)
    {
      this.unparseableExtra = null;
      setExtra();
      return;
    }
    throw new NoSuchElementException();
  }
  
  public void setCentralDirectoryExtra(byte[] paramArrayOfByte)
  {
    try
    {
      mergeExtraFields(ExtraFieldUtils.parse(paramArrayOfByte, false, ExtraFieldUtils.UnparseableExtraField.READ), false);
      return;
    }
    catch (ZipException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte.getMessage(), paramArrayOfByte);
    }
  }
  
  public void setComprSize(long paramLong)
  {
    setCompressedSize(paramLong);
  }
  
  public void setExternalAttributes(long paramLong)
  {
    this.externalAttributes = paramLong;
  }
  
  protected void setExtra()
  {
    super.setExtra(ExtraFieldUtils.mergeLocalFileDataData(getExtraFields(true)));
  }
  
  public void setExtra(byte[] paramArrayOfByte)
  {
    try
    {
      mergeExtraFields(ExtraFieldUtils.parse(paramArrayOfByte, true, ExtraFieldUtils.UnparseableExtraField.READ), true);
      return;
    }
    catch (ZipException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error parsing extra fields for entry: ");
      localStringBuilder.append(getName());
      localStringBuilder.append(" - ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new RuntimeException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  public void setExtraFields(ZipExtraField[] paramArrayOfZipExtraField)
  {
    this.extraFields = new LinkedHashMap();
    int j = paramArrayOfZipExtraField.length;
    int i = 0;
    while (i < j)
    {
      ZipExtraField localZipExtraField = paramArrayOfZipExtraField[i];
      if ((localZipExtraField instanceof UnparseableExtraFieldData)) {
        this.unparseableExtra = ((UnparseableExtraFieldData)localZipExtraField);
      } else {
        this.extraFields.put(localZipExtraField.getHeaderId(), localZipExtraField);
      }
      i += 1;
    }
    setExtra();
  }
  
  public void setGeneralPurposeBit(GeneralPurposeBit paramGeneralPurposeBit)
  {
    this.gpb = paramGeneralPurposeBit;
  }
  
  public void setInternalAttributes(int paramInt)
  {
    this.internalAttributes = paramInt;
  }
  
  public void setMethod(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.method = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZIP compression method can not be negative: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setName(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (getPlatform() == 0)
      {
        str = paramString;
        if (paramString.indexOf("/") == -1) {
          str = paramString.replace('\\', '/');
        }
      }
    }
    this.name = str;
  }
  
  protected void setName(String paramString, byte[] paramArrayOfByte)
  {
    setName(paramString);
    this.rawName = paramArrayOfByte;
  }
  
  protected void setPlatform(int paramInt)
  {
    this.platform = paramInt;
  }
  
  public void setSize(long paramLong)
  {
    if (paramLong >= 0L)
    {
      this.size = paramLong;
      return;
    }
    throw new IllegalArgumentException("invalid entry size");
  }
  
  public void setUnixMode(int paramInt)
  {
    int j = 0;
    int i;
    if ((paramInt & 0x80) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (isDirectory()) {
      j = 16;
    }
    setExternalAttributes(i | paramInt << 16 | j);
    this.platform = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEntry
 * JD-Core Version:    0.7.0.1
 */