package com.tencent.biz.authorize;

import java.io.File;
import java.nio.ByteBuffer;
import mnt;

public class FlatBuffersConfig$2
  implements Runnable
{
  public FlatBuffersConfig$2(mnt parammnt, ByteBuffer paramByteBuffer, File paramFile, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if ((i >= 3) || (this.this$0.a(this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Boolean))) {
        return;
      }
      try
      {
        Thread.sleep(100L);
        label36:
        i += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label36;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.authorize.FlatBuffersConfig.2
 * JD-Core Version:    0.7.0.1
 */