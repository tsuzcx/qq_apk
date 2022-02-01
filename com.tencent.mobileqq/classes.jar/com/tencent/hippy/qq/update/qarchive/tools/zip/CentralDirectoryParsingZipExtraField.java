package com.tencent.hippy.qq.update.qarchive.tools.zip;

public abstract interface CentralDirectoryParsingZipExtraField
  extends ZipExtraField
{
  public abstract void parseFromCentralDirectoryData(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.CentralDirectoryParsingZipExtraField
 * JD-Core Version:    0.7.0.1
 */