package com.tencent.hippy.qq.update.qarchive.tools.zip;

public abstract interface ZipExtraField
{
  public abstract byte[] getCentralDirectoryData();
  
  public abstract ZipShort getCentralDirectoryLength();
  
  public abstract ZipShort getHeaderId();
  
  public abstract byte[] getLocalFileDataData();
  
  public abstract ZipShort getLocalFileDataLength();
  
  public abstract void parseFromLocalFileData(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
 * JD-Core Version:    0.7.0.1
 */