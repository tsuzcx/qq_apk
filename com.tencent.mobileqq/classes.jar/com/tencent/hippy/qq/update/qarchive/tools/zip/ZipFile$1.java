package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

class ZipFile$1
  extends InflaterInputStream
{
  ZipFile$1(ZipFile paramZipFile, InputStream paramInputStream, Inflater paramInflater1, Inflater paramInflater2)
  {
    super(paramInputStream, paramInflater1);
  }
  
  public void close()
  {
    super.close();
    this.val$inflater.end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipFile.1
 * JD-Core Version:    0.7.0.1
 */