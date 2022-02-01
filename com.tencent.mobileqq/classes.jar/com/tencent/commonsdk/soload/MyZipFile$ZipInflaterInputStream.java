package com.tencent.commonsdk.soload;

import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

class MyZipFile$ZipInflaterInputStream
  extends InflaterInputStream
{
  long bytesRead = 0L;
  MyZipEntry entry;
  
  public MyZipFile$ZipInflaterInputStream(InputStream paramInputStream, Inflater paramInflater, int paramInt, MyZipEntry paramMyZipEntry)
  {
    super(paramInputStream, paramInflater, paramInt);
    this.entry = paramMyZipEntry;
  }
  
  public int available()
  {
    if (super.available() == 0) {
      return 0;
    }
    return (int)(this.entry.getSize() - this.bytesRead);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      this.bytesRead += paramInt1;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.soload.MyZipFile.ZipInflaterInputStream
 * JD-Core Version:    0.7.0.1
 */