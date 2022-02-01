package com.tencent.luggage.wxa.mn;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

class c$c
  extends FilterInputStream
{
  private long a = 0L;
  
  c$c(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  /* Error */
  public void mark(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 22	com/tencent/luggage/wxa/mn/c$c:in	Ljava/io/InputStream;
    //   7: checkcast 24	java/io/FileInputStream
    //   10: invokevirtual 28	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: invokevirtual 34	java/nio/channels/FileChannel:position	()J
    //   16: putfield 13	com/tencent/luggage/wxa/mn/c$c:a	J
    //   19: goto +23 -> 42
    //   22: astore_2
    //   23: goto +22 -> 45
    //   26: astore_2
    //   27: ldc 36
    //   29: aload_2
    //   30: ldc 38
    //   32: invokestatic 43	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   35: aload_0
    //   36: ldc2_w 44
    //   39: putfield 13	com/tencent/luggage/wxa/mn/c$c:a	J
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	c
    //   0	49	1	paramInt	int
    //   22	1	2	localObject	Object
    //   26	22	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	19	22	finally
    //   27	42	22	finally
    //   2	19	26	java/io/IOException
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public void reset()
  {
    try
    {
      if (this.a >= 0L)
      {
        ((FileInputStream)this.in).getChannel().position(this.a);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Illegal marked position: ");
      localStringBuilder.append(this.a);
      throw new IOException(localStringBuilder.toString());
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mn.c.c
 * JD-Core Version:    0.7.0.1
 */