package com.tencent.hippy.qq.update.qarchive.tools.zip;

public final class UnparseableExtraFieldData
  implements CentralDirectoryParsingZipExtraField
{
  private static final ZipShort HEADER_ID = new ZipShort(44225);
  private byte[] centralDirectoryData;
  private byte[] localFileData;
  
  public byte[] getCentralDirectoryData()
  {
    byte[] arrayOfByte = this.centralDirectoryData;
    if (arrayOfByte == null) {
      return getLocalFileDataData();
    }
    return ZipUtil.copy(arrayOfByte);
  }
  
  public ZipShort getCentralDirectoryLength()
  {
    byte[] arrayOfByte = this.centralDirectoryData;
    if (arrayOfByte == null) {
      return getLocalFileDataLength();
    }
    return new ZipShort(arrayOfByte.length);
  }
  
  public ZipShort getHeaderId()
  {
    return HEADER_ID;
  }
  
  public byte[] getLocalFileDataData()
  {
    return ZipUtil.copy(this.localFileData);
  }
  
  public ZipShort getLocalFileDataLength()
  {
    byte[] arrayOfByte = this.localFileData;
    int i;
    if (arrayOfByte == null) {
      i = 0;
    } else {
      i = arrayOfByte.length;
    }
    return new ZipShort(i);
  }
  
  public void parseFromCentralDirectoryData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.centralDirectoryData = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.centralDirectoryData, 0, paramInt2);
    if (this.localFileData == null) {
      parseFromLocalFileData(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void parseFromLocalFileData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.localFileData = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.localFileData, 0, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.UnparseableExtraFieldData
 * JD-Core Version:    0.7.0.1
 */