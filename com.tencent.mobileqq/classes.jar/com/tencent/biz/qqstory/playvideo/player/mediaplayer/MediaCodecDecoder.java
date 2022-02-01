package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
abstract class MediaCodecDecoder
{
  protected String a = MediaCodecDecoder.class.getSimpleName();
  private MediaExtractor b;
  private int c;
  private MediaFormat d;
  private MediaCodec e;
  private ByteBuffer[] f;
  private ByteBuffer[] g;
  private MediaCodec.BufferInfo h;
  private boolean i;
  private boolean j;
  private List<MediaCodecDecoder.FrameInfo> k;
  private boolean l;
  private boolean m;
  private MediaCodecDecoder.OnDecoderEventListener n;
  private boolean o;
  private long p;
  private MediaCodecDecoder.FrameInfo q;
  
  public MediaCodecDecoder(MediaExtractor paramMediaExtractor, boolean paramBoolean, int paramInt, MediaCodecDecoder.OnDecoderEventListener paramOnDecoderEventListener)
  {
    if ((paramMediaExtractor != null) && (paramInt != -1))
    {
      this.b = paramMediaExtractor;
      this.o = paramBoolean;
      this.c = paramInt;
      this.d = paramMediaExtractor.a(this.c);
      this.n = paramOnDecoderEventListener;
      this.e = MediaCodec.createDecoderByType(this.d.getString("mime"));
      this.p = -9223372036854775808L;
      return;
    }
    throw new IllegalArgumentException("no track specified");
  }
  
  protected MediaCodecDecoder.FrameInfo a(MediaPlayer.SeekMode paramSeekMode, long paramLong, MediaExtractor paramMediaExtractor, MediaCodec paramMediaCodec)
  {
    if (this.o)
    {
      this.i = false;
      this.j = false;
      paramMediaCodec.flush();
      return null;
    }
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seeking to:                 ");
    localStringBuilder.append(paramLong);
    Log.d((String)localObject, localStringBuilder.toString());
    localObject = this.a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("extractor current position: ");
    localStringBuilder.append(paramMediaExtractor.f());
    Log.d((String)localObject, localStringBuilder.toString());
    paramMediaExtractor.a(paramLong, paramSeekMode.a());
    paramSeekMode = this.a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("extractor new position:     ");
    ((StringBuilder)localObject).append(paramMediaExtractor.f());
    Log.d(paramSeekMode, ((StringBuilder)localObject).toString());
    this.i = false;
    this.j = false;
    paramMediaCodec.flush();
    if (paramMediaExtractor.i())
    {
      f();
      this.m = true;
    }
    return a(true, true);
  }
  
  public final MediaCodecDecoder.FrameInfo a(boolean paramBoolean1, boolean paramBoolean2)
  {
    while (!this.j)
    {
      MediaCodecDecoder.FrameInfo localFrameInfo = h();
      while (a(paramBoolean1)) {}
      if (localFrameInfo != null) {
        return localFrameInfo;
      }
      if (!paramBoolean2) {
        return null;
      }
    }
    Log.d(this.a, "EOS NULL");
    return null;
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec.configure(paramMediaFormat, null, null, 0);
  }
  
  protected void a(MediaFormat paramMediaFormat) {}
  
  public void a(MediaCodecDecoder.FrameInfo paramFrameInfo)
  {
    b(paramFrameInfo);
  }
  
  public void a(MediaCodecDecoder.FrameInfo paramFrameInfo, long paramLong)
  {
    b(paramFrameInfo);
  }
  
  public final void a(MediaPlayer.SeekMode paramSeekMode, long paramLong)
  {
    this.p = -9223372036854775808L;
    this.q = a(paramSeekMode, paramLong, this.b, this.e);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public final boolean a(boolean paramBoolean)
  {
    if (!this.i)
    {
      if (!a()) {
        return false;
      }
      if ((this.b.e() != -1) && (this.b.e() != this.c))
      {
        if (paramBoolean) {
          return this.b.d();
        }
        return false;
      }
      int i3 = this.e.dequeueInputBuffer(0L);
      if (i3 >= 0)
      {
        Object localObject = this.f[i3];
        if (this.b.i())
        {
          this.l = true;
          this.e.queueInputBuffer(i3, 0, 0, 0L, 4);
          if (this.b.g() > -1L)
          {
            localObject = this.n;
            if (localObject != null) {
              ((MediaCodecDecoder.OnDecoderEventListener)localObject).a(this);
            }
          }
        }
        else
        {
          if (this.b.g() > -1L)
          {
            MediaCodecDecoder.OnDecoderEventListener localOnDecoderEventListener = this.n;
            if (localOnDecoderEventListener != null) {
              localOnDecoderEventListener.a(this);
            }
          }
          int i1 = this.b.a((ByteBuffer)localObject, 0);
          long l1;
          if (i1 < 0)
          {
            Log.d(this.a, "EOS input");
            this.i = true;
            l1 = 0L;
            paramBoolean = false;
            i1 = 0;
          }
          else
          {
            l1 = this.b.f();
            paramBoolean = true;
          }
          localObject = this.e;
          int i2;
          if (this.i) {
            i2 = 4;
          } else {
            i2 = 0;
          }
          ((MediaCodec)localObject).queueInputBuffer(i3, 0, i1, l1, i2);
          bool = paramBoolean;
          if (this.i) {
            break label282;
          }
          this.b.d();
          return paramBoolean;
        }
      }
      boolean bool = false;
      label282:
      return bool;
    }
    return false;
  }
  
  protected final MediaFormat b()
  {
    return this.d;
  }
  
  public void b(MediaCodecDecoder.FrameInfo paramFrameInfo)
  {
    this.e.releaseOutputBuffer(paramFrameInfo.a, false);
    c(paramFrameInfo);
  }
  
  protected final MediaCodec c()
  {
    return this.e;
  }
  
  protected final void c(MediaCodecDecoder.FrameInfo paramFrameInfo)
  {
    paramFrameInfo.a();
    this.k.add(paramFrameInfo);
  }
  
  protected final boolean d()
  {
    return this.j;
  }
  
  protected final boolean e()
  {
    return this.o;
  }
  
  protected final void f()
  {
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      this.d = this.b.a(this.c);
      this.e.stop();
      a(this.e, this.d);
      this.e.start();
      this.f = this.e.getInputBuffers();
      this.g = this.e.getOutputBuffers();
      this.h = new MediaCodec.BufferInfo();
      int i1 = 0;
      this.i = false;
      this.j = false;
      this.k = new ArrayList();
      while (i1 < this.g.length)
      {
        this.k.add(new MediaCodecDecoder.FrameInfo());
        i1 += 1;
      }
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reinitCodec ");
      localStringBuilder.append(SystemClock.elapsedRealtime() - l1);
      localStringBuilder.append("ms");
      Log.d(str, localStringBuilder.toString());
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.e.release();
      Log.e(this.a, "reinitCodec: illegal state");
      throw localIllegalStateException;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.e.release();
      Log.e(this.a, "reinitCodec: invalid surface or format");
    }
    for (;;)
    {
      throw localIllegalArgumentException;
    }
  }
  
  public final void g()
  {
    if (this.o) {
      return;
    }
    for (;;)
    {
      int i1 = this.b.e();
      if ((i1 == -1) || (i1 == this.c) || (this.i)) {
        break;
      }
      this.b.d();
    }
  }
  
  public final MediaCodecDecoder.FrameInfo h()
  {
    if (this.j) {
      return null;
    }
    int i1 = this.e.dequeueOutputBuffer(this.h, 0L);
    boolean bool;
    if ((i1 >= 0) && ((this.h.flags & 0x4) != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.j = bool;
    if ((this.j) && (this.l))
    {
      f();
      this.j = false;
      this.l = false;
      this.m = true;
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (i1 >= 0)
    {
      localObject1 = this.g[i1];
      if ((localObject1 != null) && (this.h.size != 0))
      {
        ((ByteBuffer)localObject1).position(this.h.offset);
        ((ByteBuffer)localObject1).limit(this.h.offset + this.h.size);
      }
      localObject2 = (MediaCodecDecoder.FrameInfo)this.k.get(0);
      ((MediaCodecDecoder.FrameInfo)localObject2).a = i1;
      ((MediaCodecDecoder.FrameInfo)localObject2).b = ((ByteBuffer)localObject1);
      ((MediaCodecDecoder.FrameInfo)localObject2).c = this.h.presentationTimeUs;
      ((MediaCodecDecoder.FrameInfo)localObject2).d = this.j;
      if (this.m)
      {
        this.m = false;
        ((MediaCodecDecoder.FrameInfo)localObject2).e = true;
      }
      if (((MediaCodecDecoder.FrameInfo)localObject2).d)
      {
        Log.d(this.a, "EOS output");
        return localObject2;
      }
      this.p = ((MediaCodecDecoder.FrameInfo)localObject2).c;
      return localObject2;
    }
    if (i1 == -3)
    {
      this.g = this.e.getOutputBuffers();
      Log.d(this.a, "output buffers have changed.");
      return null;
    }
    if (i1 == -2)
    {
      localObject1 = this.e.getOutputFormat();
      localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("output format has changed to ");
      localStringBuilder.append(localObject1);
      Log.d((String)localObject2, localStringBuilder.toString());
      a((MediaFormat)localObject1);
    }
    return null;
  }
  
  public long i()
  {
    return this.p;
  }
  
  public long j()
  {
    return this.b.g();
  }
  
  public boolean k()
  {
    return this.b.h();
  }
  
  public void l()
  {
    MediaCodecDecoder.FrameInfo localFrameInfo = this.q;
    if (localFrameInfo != null) {
      a(localFrameInfo, 0L);
    }
  }
  
  public void m()
  {
    MediaCodecDecoder.FrameInfo localFrameInfo = this.q;
    if (localFrameInfo != null) {
      a(localFrameInfo);
    }
  }
  
  public void n()
  {
    this.e.stop();
    this.e.release();
    Log.d(this.a, "decoder released");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */