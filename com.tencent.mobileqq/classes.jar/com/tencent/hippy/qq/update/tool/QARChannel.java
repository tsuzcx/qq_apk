package com.tencent.hippy.qq.update.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class QARChannel
{
  public static long forTransfer(File paramFile1, File paramFile2)
  {
    long l1 = System.currentTimeMillis();
    paramFile1 = new FileInputStream(paramFile1);
    paramFile2 = new FileOutputStream(paramFile2);
    paramFile1 = paramFile1.getChannel();
    paramFile2 = paramFile2.getChannel();
    for (;;)
    {
      if (paramFile1.position() == paramFile1.size())
      {
        paramFile1.close();
        paramFile2.close();
        return System.currentTimeMillis() - l1;
      }
      int i;
      if (paramFile1.size() - paramFile1.position() < 20971520L) {
        i = (int)(paramFile1.size() - paramFile1.position());
      } else {
        i = 20971520;
      }
      long l2 = paramFile1.position();
      long l3 = i;
      paramFile1.transferTo(l2, l3, paramFile2);
      paramFile1.position(paramFile1.position() + l3);
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = new FileOutputStream("C:\\tmp\\1.zip");
    try
    {
      Object localObject2 = Pipe.open();
      WritableByteChannel localWritableByteChannel = Channels.newChannel(paramArrayOfString);
      new QARChannel.ZipStreamWriter(((Pipe)localObject2).sink()).start();
      localObject2 = ((Pipe)localObject2).source();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(8192);
      while (((ReadableByteChannel)localObject2).read(localByteBuffer) >= 0)
      {
        localByteBuffer.flip();
        localWritableByteChannel.write(localByteBuffer);
        localByteBuffer.clear();
      }
      paramArrayOfString.close();
      return;
    }
    finally
    {
      paramArrayOfString.close();
    }
    for (;;)
    {
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.tool.QARChannel
 * JD-Core Version:    0.7.0.1
 */