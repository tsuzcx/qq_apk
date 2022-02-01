package com.tencent.liteav.audio.impl.Record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Vector;

public class b
  extends Thread
{
  private MediaCodec.BufferInfo a;
  private MediaCodecInfo b;
  private MediaFormat c;
  private MediaCodec d;
  private Vector<byte[]> e;
  private WeakReference<e> f;
  private volatile boolean g = false;
  private volatile boolean h = false;
  private final Object i = new Object();
  private long j = 0L;
  private int k = 48000;
  private int l = 1;
  private int m = 16;
  private byte[] n;
  
  static
  {
    f.f();
  }
  
  @TargetApi(16)
  public b()
  {
    super("TXAudioRecordThread");
  }
  
  private static final MediaCodecInfo a(String paramString)
  {
    TXCLog.v("AudioCenter:TXCAudioHWEncoder", "selectAudioCodec:");
    int i3 = MediaCodecList.getCodecCount();
    int i1 = 0;
    while (i1 < i3)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i1);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int i2 = 0;
        while (i2 < arrayOfString.length)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("supportedType:");
          localStringBuilder.append(localMediaCodecInfo.getName());
          localStringBuilder.append(",MIME=");
          localStringBuilder.append(arrayOfString[i2]);
          TXCLog.i("AudioCenter:TXCAudioHWEncoder", localStringBuilder.toString());
          if (arrayOfString[i2].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          i2 += 1;
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    if (this.h) {
      return;
    }
    Object localObject = this.d.getInputBuffers();
    int i1 = this.d.dequeueInputBuffer(10000L);
    if (i1 >= 0)
    {
      localObject = localObject[i1];
      ((ByteBuffer)localObject).clear();
      if (paramByteBuffer != null) {
        ((ByteBuffer)localObject).put(paramByteBuffer);
      }
      if (paramInt <= 0)
      {
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "send BUFFER_FLAG_END_OF_STREAM");
        this.d.queueInputBuffer(i1, 0, 0, paramLong, 4);
      }
      else
      {
        this.d.queueInputBuffer(i1, 0, paramInt, paramLong, 0);
      }
    }
    paramByteBuffer = this.d.getOutputBuffers();
    do
    {
      paramInt = this.d.dequeueOutputBuffer(this.a, 10000L);
      if (paramInt != -1) {
        if (paramInt == -3)
        {
          paramByteBuffer = this.d.getOutputBuffers();
        }
        else if (paramInt == -2)
        {
          this.d.getOutputFormat();
        }
        else if (paramInt >= 0)
        {
          localObject = paramByteBuffer[paramInt];
          if ((this.a.flags & 0x2) != 0)
          {
            TXCLog.d("AudioCenter:TXCAudioHWEncoder", "drain:BUFFER_FLAG_CODEC_CONFIG");
            this.a.size = 0;
          }
          if (this.a.size != 0)
          {
            this.a.presentationTimeUs = f();
            this.n = new byte[((ByteBuffer)localObject).limit()];
            ((ByteBuffer)localObject).get(this.n);
            b(this.n, this.a.presentationTimeUs);
            this.j = this.a.presentationTimeUs;
          }
          this.d.releaseOutputBuffer(paramInt, false);
        }
      }
    } while (paramInt >= 0);
  }
  
  private void b()
  {
    this.b = a("audio/mp4a-latm");
    if (this.b == null)
    {
      TXCLog.e("AudioCenter:TXCAudioHWEncoder", "Unable to find an appropriate codec for audio/mp4a-latm");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("selected codec: ");
    localStringBuilder.append(this.b.getName());
    TXCLog.i("AudioCenter:TXCAudioHWEncoder", localStringBuilder.toString());
    int i2 = this.k;
    int i1 = 32000;
    if (i2 >= 32000) {
      i1 = 64000;
    }
    this.c = MediaFormat.createAudioFormat("audio/mp4a-latm", this.k, this.l);
    this.c.setInteger("bitrate", i1);
    this.c.setInteger("channel-count", this.l);
    this.c.setInteger("sample-rate", this.k);
    this.c.setInteger("aac-profile", 2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("format: ");
    localStringBuilder.append(this.c);
    TXCLog.i("AudioCenter:TXCAudioHWEncoder", localStringBuilder.toString());
    try
    {
      d();
    }
    catch (Exception localException)
    {
      TXCLog.e("AudioCenter:TXCAudioHWEncoder", "start media codec failed.", localException);
    }
    start();
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (e)((WeakReference)localObject).get();
      if (localObject != null) {
        ((e)localObject).onRecordEncData(paramArrayOfByte, paramLong, this.k, this.l, this.m);
      }
    }
  }
  
  private void c()
  {
    this.h = true;
  }
  
  @TargetApi(16)
  private void d()
  {
    if (this.d != null) {
      return;
    }
    this.d = MediaCodec.createEncoderByType("audio/mp4a-latm");
    this.d.configure(this.c, null, null, 1);
    this.d.start();
    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "prepare finishing");
    this.g = true;
  }
  
  private void e()
  {
    MediaCodec localMediaCodec = this.d;
    if (localMediaCodec != null)
    {
      localMediaCodec.stop();
      this.d.release();
      this.d = null;
    }
    this.g = false;
  }
  
  private long f()
  {
    long l2 = TXCTimeUtil.getTimeTick();
    long l3 = this.j;
    long l1 = l2;
    if (l2 < l3) {
      l1 = l2 + (l3 - l2);
    }
    return l1;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, WeakReference<e> paramWeakReference)
  {
    this.f = paramWeakReference;
    this.a = new MediaCodec.BufferInfo();
    this.e = new Vector();
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramInt4;
    b();
  }
  
  public void a(byte[] arg1, long paramLong)
  {
    Vector localVector = this.e;
    if ((localVector != null) && (??? != null)) {
      try
      {
        if (this.e == null) {
          return;
        }
        this.e.add(???);
      }
      finally {}
    }
    synchronized (this.i)
    {
      this.i.notify();
      return;
    }
  }
  
  public void run()
  {
    Object localObject1 = ByteBuffer.allocateDirect(1024);
    while (!this.h)
    {
      if (this.g) {
        synchronized (this.e)
        {
          boolean bool = this.e.isEmpty();
          if (bool) {}
          try
          {
            Thread.sleep(10L);
          }
          catch (InterruptedException localInterruptedException1)
          {
            label51:
            break label51;
          }
          continue;
          synchronized (this.e)
          {
            byte[] arrayOfByte = (byte[])this.e.remove(0);
            if (arrayOfByte == null) {
              continue;
            }
            Object localObject7 = localObject1;
            try
            {
              ((ByteBuffer)localObject1).clear();
              ??? = localObject1;
              localObject7 = localObject1;
              if (arrayOfByte.length > ((ByteBuffer)localObject1).capacity())
              {
                localObject7 = localObject1;
                ??? = ByteBuffer.allocateDirect(arrayOfByte.length);
              }
              localObject7 = ???;
              ((ByteBuffer)???).clear();
              localObject7 = ???;
              ((ByteBuffer)???).put(arrayOfByte);
              localObject7 = ???;
              ((ByteBuffer)???).flip();
              localObject7 = ???;
              a((ByteBuffer)???, arrayOfByte.length, f());
              localObject1 = ???;
            }
            catch (Exception localException)
            {
              TXCLog.e("AudioCenter:TXCAudioHWEncoder", "encode frame failed.", localException);
              Object localObject2 = localObject7;
            }
          }
        }
      }
      try
      {
        synchronized (this.i)
        {
          this.i.wait();
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        label207:
        break label207;
      }
      continue;
      throw localObject5;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.b
 * JD-Core Version:    0.7.0.1
 */