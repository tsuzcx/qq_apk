package com.tencent.hippy.qq.update.tool;

import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEntry;
import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipOutputStream;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;

class QARChannel$ZipStreamWriter
  extends Thread
{
  WritableByteChannel channel;
  
  QARChannel$ZipStreamWriter(WritableByteChannel paramWritableByteChannel)
  {
    this.channel = paramWritableByteChannel;
  }
  
  public void run()
  {
    try
    {
      ZipOutputStream localZipOutputStream = new ZipOutputStream(Channels.newOutputStream(this.channel));
      try
      {
        localZipOutputStream.putNextEntry(new ZipEntry("test.txt"));
        localZipOutputStream.write("This is test file content".getBytes());
        localZipOutputStream.closeEntry();
        return;
      }
      finally
      {
        localZipOutputStream.close();
        this.channel.close();
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.tool.QARChannel.ZipStreamWriter
 * JD-Core Version:    0.7.0.1
 */