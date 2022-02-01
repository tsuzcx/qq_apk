package com.tencent.hippy.qq.update.qarchive.tools.zip;

public class UnrecognizedExtraField
  implements CentralDirectoryParsingZipExtraField
{
  private byte[] centralData;
  private ZipShort headerId;
  private byte[] localData;
  
  public byte[] getCentralDirectoryData()
  {
    byte[] arrayOfByte = this.centralData;
    if (arrayOfByte != null) {
      return ZipUtil.copy(arrayOfByte);
    }
    return getLocalFileDataData();
  }
  
  public ZipShort getCentralDirectoryLength()
  {
    byte[] arrayOfByte = this.centralData;
    if (arrayOfByte != null) {
      return new ZipShort(arrayOfByte.length);
    }
    return getLocalFileDataLength();
  }
  
  public ZipShort getHeaderId()
  {
    return this.headerId;
  }
  
  public byte[] getLocalFileDataData()
  {
    return ZipUtil.copy(this.localData);
  }
  
  public ZipShort getLocalFileDataLength()
  {
    return new ZipShort(this.localData.length);
  }
  
  public void parseFromCentralDirectoryData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    setCentralDirectoryData(arrayOfByte);
    if (this.localData == null) {
      setLocalFileDataData(arrayOfByte);
    }
  }
  
  public void parseFromLocalFileData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    setLocalFileDataData(arrayOfByte);
  }
  
  public void setCentralDirectoryData(byte[] paramArrayOfByte)
  {
    this.centralData = ZipUtil.copy(paramArrayOfByte);
  }
  
  public void setHeaderId(ZipShort paramZipShort)
  {
    this.headerId = paramZipShort;
  }
  
  public void setLocalFileDataData(byte[] paramArrayOfByte)
  {
    this.localData = ZipUtil.copy(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.UnrecognizedExtraField
 * JD-Core Version:    0.7.0.1
 */