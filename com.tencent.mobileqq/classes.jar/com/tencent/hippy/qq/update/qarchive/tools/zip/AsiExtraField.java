package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.zip.CRC32;
import java.util.zip.ZipException;

public class AsiExtraField
  implements UnixStat, ZipExtraField, Cloneable
{
  private static final ZipShort HEADER_ID = new ZipShort(30062);
  private static final int WORD = 4;
  private CRC32 crc = new CRC32();
  private boolean dirFlag = false;
  private int gid = 0;
  private String link = "";
  private int mode = 0;
  private int uid = 0;
  
  public Object clone()
  {
    try
    {
      AsiExtraField localAsiExtraField = (AsiExtraField)super.clone();
      localAsiExtraField.crc = new CRC32();
      return localAsiExtraField;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  public byte[] getCentralDirectoryData()
  {
    return getLocalFileDataData();
  }
  
  public ZipShort getCentralDirectoryLength()
  {
    return getLocalFileDataLength();
  }
  
  public int getGroupId()
  {
    return this.gid;
  }
  
  public ZipShort getHeaderId()
  {
    return HEADER_ID;
  }
  
  public String getLinkedFile()
  {
    return this.link;
  }
  
  public byte[] getLocalFileDataData()
  {
    byte[] arrayOfByte1 = new byte[getLocalFileDataLength().getValue() - 4];
    System.arraycopy(ZipShort.getBytes(getMode()), 0, arrayOfByte1, 0, 2);
    byte[] arrayOfByte2 = getLinkedFile().getBytes();
    System.arraycopy(ZipLong.getBytes(arrayOfByte2.length), 0, arrayOfByte1, 2, 4);
    System.arraycopy(ZipShort.getBytes(getUserId()), 0, arrayOfByte1, 6, 2);
    System.arraycopy(ZipShort.getBytes(getGroupId()), 0, arrayOfByte1, 8, 2);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 10, arrayOfByte2.length);
    this.crc.reset();
    this.crc.update(arrayOfByte1);
    long l = this.crc.getValue();
    arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    System.arraycopy(ZipLong.getBytes(l), 0, arrayOfByte2, 0, 4);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
    return arrayOfByte2;
  }
  
  public ZipShort getLocalFileDataLength()
  {
    return new ZipShort(getLinkedFile().getBytes().length + 14);
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  protected int getMode(int paramInt)
  {
    int i;
    if (isLink()) {
      i = 40960;
    } else if (isDirectory()) {
      i = 16384;
    } else {
      i = 32768;
    }
    return paramInt & 0xFFF | i;
  }
  
  public int getUserId()
  {
    return this.uid;
  }
  
  public boolean isDirectory()
  {
    return (this.dirFlag) && (!isLink());
  }
  
  public boolean isLink()
  {
    return getLinkedFile().length() != 0;
  }
  
  public void parseFromLocalFileData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = ZipLong.getValue(paramArrayOfByte, paramInt1);
    paramInt2 -= 4;
    byte[] arrayOfByte = new byte[paramInt2];
    boolean bool = false;
    System.arraycopy(paramArrayOfByte, paramInt1 + 4, arrayOfByte, 0, paramInt2);
    this.crc.reset();
    this.crc.update(arrayOfByte);
    long l2 = this.crc.getValue();
    if (l1 == l2)
    {
      paramInt1 = ZipShort.getValue(arrayOfByte, 0);
      paramArrayOfByte = new byte[(int)ZipLong.getValue(arrayOfByte, 2)];
      this.uid = ZipShort.getValue(arrayOfByte, 6);
      this.gid = ZipShort.getValue(arrayOfByte, 8);
      if (paramArrayOfByte.length == 0)
      {
        this.link = "";
      }
      else
      {
        System.arraycopy(arrayOfByte, 10, paramArrayOfByte, 0, paramArrayOfByte.length);
        this.link = new String(paramArrayOfByte);
      }
      if ((paramInt1 & 0x4000) != 0) {
        bool = true;
      }
      setDirectory(bool);
      setMode(paramInt1);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("bad CRC checksum ");
    paramArrayOfByte.append(Long.toHexString(l1));
    paramArrayOfByte.append(" instead of ");
    paramArrayOfByte.append(Long.toHexString(l2));
    throw new ZipException(paramArrayOfByte.toString());
  }
  
  public void setDirectory(boolean paramBoolean)
  {
    this.dirFlag = paramBoolean;
    this.mode = getMode(this.mode);
  }
  
  public void setGroupId(int paramInt)
  {
    this.gid = paramInt;
  }
  
  public void setLinkedFile(String paramString)
  {
    this.link = paramString;
    this.mode = getMode(this.mode);
  }
  
  public void setMode(int paramInt)
  {
    this.mode = getMode(paramInt);
  }
  
  public void setUserId(int paramInt)
  {
    this.uid = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.AsiExtraField
 * JD-Core Version:    0.7.0.1
 */