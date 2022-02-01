package com.tencent.luggage.wxa.qo;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.nio.ByteBuffer;

public class a
  implements IDataSource
{
  private ByteBuffer a;
  private long b;
  private Object c = new Object();
  
  public a(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer;
  }
  
  public void close()
  {
    synchronized (this.c)
    {
      this.a = null;
      return;
    }
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    if (this.a == null) {
      return AudioFormat.AudioType.UNSUPPORT;
    }
    return FormatDetector.getAudioFormat(this, false);
  }
  
  public long getSize()
  {
    synchronized (this.c)
    {
      if (this.a != null)
      {
        long l = this.a.limit();
        return l;
      }
      return -1L;
    }
  }
  
  public void open()
  {
    synchronized (this.c)
    {
      if (this.a != null) {
        this.a.rewind();
      }
      return;
    }
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.a == null)
    {
      o.b("MicroMsg.Audio.InputStreamByteBufferDataSource", "buffer is null");
      return -1;
    }
    if (getSize() <= 0L)
    {
      o.b("MicroMsg.Audio.InputStreamByteBufferDataSource", "getSize <= 0");
      return -1;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      if ((paramLong >= 0L) && (paramInt1 >= 0) && (paramInt2 > 0))
      {
        if ((paramArrayOfByte != null) && (paramInt1 + paramInt2 > paramArrayOfByte.length))
        {
          o.b("MicroMsg.Audio.InputStreamByteBufferDataSource", "offset:%d, size:%d, bytes.length:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
          return -1;
        }
        if (paramInt2 + paramLong > getSize()) {
          o.b("MicroMsg.Audio.InputStreamByteBufferDataSource", "position:%d, size:%d, getSize():%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Long.valueOf(getSize()) });
        }
        if (this.b == 0L) {
          this.b = getSize();
        }
        long l = this.b;
        if ((l > 0L) && (paramLong > l) && (paramInt2 > 0)) {
          return -1;
        }
      }
    }
    for (;;)
    {
      synchronized (this.c)
      {
        if (this.a == null) {
          break label348;
        }
        this.a.position((int)paramLong);
        if (!this.a.hasRemaining())
        {
          o.b("MicroMsg.Audio.InputStreamByteBufferDataSource", "no remaining");
          return -1;
        }
        paramInt2 = Math.min(paramInt2, this.a.remaining());
        this.a.get(paramArrayOfByte, paramInt1, paramInt2);
        paramInt1 = paramInt2;
        return paramInt1;
      }
      o.b("MicroMsg.Audio.InputStreamByteBufferDataSource", "position:%d, offset:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return -1;
      o.b("MicroMsg.Audio.InputStreamByteBufferDataSource", "bytes is null");
      return -1;
      label348:
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qo.a
 * JD-Core Version:    0.7.0.1
 */