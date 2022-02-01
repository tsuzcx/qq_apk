package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

public abstract class AbstractUnicodeExtraField
  implements ZipExtraField
{
  private byte[] data;
  private long nameCRC32;
  private byte[] unicodeName;
  
  protected AbstractUnicodeExtraField() {}
  
  protected AbstractUnicodeExtraField(String paramString, byte[] paramArrayOfByte)
  {
    this(paramString, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  protected AbstractUnicodeExtraField(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    CRC32 localCRC32 = new CRC32();
    localCRC32.update(paramArrayOfByte, paramInt1, paramInt2);
    this.nameCRC32 = localCRC32.getValue();
    try
    {
      this.unicodeName = paramString.getBytes("UTF-8");
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("FATAL: UTF-8 encoding not supported.", paramString);
    }
  }
  
  private void assembleData()
  {
    byte[] arrayOfByte = this.unicodeName;
    if (arrayOfByte == null) {
      return;
    }
    this.data = new byte[arrayOfByte.length + 5];
    this.data[0] = 1;
    System.arraycopy(ZipLong.getBytes(this.nameCRC32), 0, this.data, 1, 4);
    arrayOfByte = this.unicodeName;
    System.arraycopy(arrayOfByte, 0, this.data, 5, arrayOfByte.length);
  }
  
  public byte[] getCentralDirectoryData()
  {
    if (this.data == null) {
      assembleData();
    }
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = this.data;
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = new byte[arrayOfByte2.length];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte1.length);
    }
    return arrayOfByte1;
  }
  
  public ZipShort getCentralDirectoryLength()
  {
    if (this.data == null) {
      assembleData();
    }
    return new ZipShort(this.data.length);
  }
  
  public byte[] getLocalFileDataData()
  {
    return getCentralDirectoryData();
  }
  
  public ZipShort getLocalFileDataLength()
  {
    return getCentralDirectoryLength();
  }
  
  public long getNameCRC32()
  {
    return this.nameCRC32;
  }
  
  public byte[] getUnicodeName()
  {
    byte[] arrayOfByte1 = this.unicodeName;
    if (arrayOfByte1 != null)
    {
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
      return arrayOfByte2;
    }
    return null;
  }
  
  public void parseFromLocalFileData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 5)
    {
      int i = paramArrayOfByte[paramInt1];
      if (i == 1)
      {
        this.nameCRC32 = ZipLong.getValue(paramArrayOfByte, paramInt1 + 1);
        paramInt2 -= 5;
        this.unicodeName = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte, paramInt1 + 5, this.unicodeName, 0, paramInt2);
        this.data = null;
        return;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Unsupported version [");
      paramArrayOfByte.append(i);
      paramArrayOfByte.append("] for UniCode path extra data.");
      throw new ZipException(paramArrayOfByte.toString());
    }
    throw new ZipException("UniCode path extra data must have at least 5 bytes.");
  }
  
  public void setNameCRC32(long paramLong)
  {
    this.nameCRC32 = paramLong;
    this.data = null;
  }
  
  public void setUnicodeName(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.unicodeName = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.unicodeName, 0, paramArrayOfByte.length);
    }
    else
    {
      this.unicodeName = null;
    }
    this.data = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.AbstractUnicodeExtraField
 * JD-Core Version:    0.7.0.1
 */