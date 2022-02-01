package com.tencent.biz.authorize;

import java.io.File;
import java.nio.ByteBuffer;

class FlatBuffersConfig$2
  implements Runnable
{
  FlatBuffersConfig$2(FlatBuffersConfig paramFlatBuffersConfig, ByteBuffer paramByteBuffer, File paramFile, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < 3) {
        if (this.this$0.a(this.a, this.b, this.c)) {
          return;
        }
      }
      try
      {
        Thread.sleep(100L);
        label36:
        i += 1;
        continue;
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label36;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.authorize.FlatBuffersConfig.2
 * JD-Core Version:    0.7.0.1
 */