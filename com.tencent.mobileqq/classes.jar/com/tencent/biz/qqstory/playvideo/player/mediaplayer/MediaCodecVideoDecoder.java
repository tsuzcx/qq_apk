package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;

@TargetApi(16)
class MediaCodecVideoDecoder
  extends MediaCodecDecoder
{
  private Surface b;
  private boolean c;
  
  public MediaCodecVideoDecoder(MediaExtractor paramMediaExtractor, boolean paramBoolean1, int paramInt, MediaCodecDecoder.OnDecoderEventListener paramOnDecoderEventListener, Surface paramSurface, boolean paramBoolean2)
  {
    super(paramMediaExtractor, paramBoolean1, paramInt, paramOnDecoderEventListener);
    this.b = paramSurface;
    this.c = paramBoolean2;
    f();
  }
  
  @TargetApi(16)
  private long a(long paramLong, MediaExtractor paramMediaExtractor, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.flush();
    paramMediaExtractor.a(paramLong, 0);
    if (paramMediaExtractor.f() == paramLong)
    {
      Log.d(this.a, "skip fastseek, already there");
      return paramLong;
    }
    g();
    a(false);
    paramMediaExtractor.a(paramLong, 0);
    long l1 = 9223372036854775807L;
    long l3 = 0L;
    int i = 0;
    while ((paramMediaExtractor.d()) && (i < 20))
    {
      long l5 = paramLong - paramMediaExtractor.f();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l1)
        {
          l4 = paramMediaExtractor.f();
          l2 = l5;
        }
      }
      l3 = l4;
      l1 = l2;
      if (l5 < 0L)
      {
        i += 1;
        l3 = l4;
        l1 = l2;
      }
    }
    paramMediaExtractor.a(l3, 0);
    while (paramMediaExtractor.f() != l3) {
      paramMediaExtractor.d();
    }
    paramMediaCodec = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exact fastseek match:       ");
    localStringBuilder.append(paramMediaExtractor.f());
    Log.d(paramMediaCodec, localStringBuilder.toString());
    return l3;
  }
  
  protected MediaCodecDecoder.FrameInfo a(MediaPlayer.SeekMode paramSeekMode, long paramLong, MediaExtractor paramMediaExtractor, MediaCodec paramMediaCodec)
  {
    long l2 = paramLong / 1000L;
    MediaCodecDecoder.FrameInfo localFrameInfo = super.a(paramSeekMode, paramLong, paramMediaExtractor, paramMediaCodec);
    if (localFrameInfo == null) {
      return null;
    }
    int i = paramSeekMode.b();
    long l5 = -1L;
    long l4;
    Object localObject;
    if ((i != 3) && (paramSeekMode.b() != 2) && (paramSeekMode.b() != 0) && (paramSeekMode.b() != 1))
    {
      if (paramSeekMode.b() == 6)
      {
        a(localFrameInfo, false);
        a(paramLong, paramMediaExtractor, paramMediaCodec);
        paramSeekMode = a(true, true);
        if (paramSeekMode == null) {
          return null;
        }
        paramMediaExtractor = this.a;
        paramMediaCodec = new StringBuilder();
        paramMediaCodec.append("fast_exact seek to ");
        paramMediaCodec.append(paramLong);
        paramMediaCodec.append(" arrived at ");
        paramMediaCodec.append(paramSeekMode.c);
        Log.d(paramMediaExtractor, paramMediaCodec.toString());
        if (paramSeekMode.c < paramLong) {
          Log.d(this.a, "presentation is behind...");
        }
        return paramSeekMode;
      }
      if (paramSeekMode.b() != 4)
      {
        l4 = l2;
        localObject = localFrameInfo;
        if (paramSeekMode.b() != 5) {}
      }
      else
      {
        long l1 = localFrameInfo.c / 1000L;
        long l3 = -1L;
        i = 0;
        paramLong = l2;
        while (l1 < paramLong)
        {
          if (i == 0) {
            Log.d(this.a, "skipping frames...");
          }
          i += 1;
          if (d()) {
            paramLong = localFrameInfo.c / 1000L;
          }
          if (localFrameInfo.d)
          {
            Log.d(this.a, "end of stream reached, seeking to last frame");
            a(localFrameInfo, false);
            return a(paramSeekMode, l3, paramMediaExtractor, paramMediaCodec);
          }
          l3 = localFrameInfo.c;
          a(localFrameInfo, false);
          localFrameInfo = a(true, true);
          if (localFrameInfo == null) {
            return null;
          }
          l1 = localFrameInfo.c / 1000L;
        }
        localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("frame new position:         ");
        localStringBuilder.append(localFrameInfo.c);
        Log.d((String)localObject, localStringBuilder.toString());
        localObject = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("seeking finished, skipped ");
        localStringBuilder.append(i);
        localStringBuilder.append(" frames");
        Log.d((String)localObject, localStringBuilder.toString());
        l4 = paramLong;
        localObject = localFrameInfo;
        l5 = l1;
        if (paramSeekMode.b() == 5)
        {
          l4 = paramLong;
          localObject = localFrameInfo;
          l5 = l1;
          if (l1 > paramLong) {
            if (i == 0)
            {
              Log.w(this.a, "this should never happen");
              l4 = paramLong;
              localObject = localFrameInfo;
              l5 = l1;
            }
            else
            {
              localObject = this.a;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("exact seek: repeat seek for previous frame at ");
              localStringBuilder.append(l3);
              Log.d((String)localObject, localStringBuilder.toString());
              a(localFrameInfo, false);
              return a(paramSeekMode, l3, paramMediaExtractor, paramMediaCodec);
            }
          }
        }
      }
    }
    else
    {
      paramSeekMode = this.a;
      paramMediaExtractor = new StringBuilder();
      paramMediaExtractor.append("fast seek to ");
      paramMediaExtractor.append(paramLong);
      paramMediaExtractor.append(" arrived at ");
      paramMediaExtractor.append(localFrameInfo.c);
      Log.d(paramSeekMode, paramMediaExtractor.toString());
      localObject = localFrameInfo;
      l4 = l2;
    }
    if (l5 == l4) {
      Log.d(this.a, "exact seek match!");
    }
    return localObject;
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec.configure(paramMediaFormat, this.b, null, 0);
  }
  
  public void a(Surface paramSurface)
  {
    if (paramSurface != null)
    {
      this.b = paramSurface;
      f();
      return;
    }
    throw new RuntimeException("surface must not be null");
  }
  
  @SuppressLint({"NewApi"})
  public void a(MediaCodecDecoder.FrameInfo paramFrameInfo, long paramLong)
  {
    a(paramFrameInfo, true);
  }
  
  public void a(MediaCodecDecoder.FrameInfo paramFrameInfo, boolean paramBoolean)
  {
    c().releaseOutputBuffer(paramFrameInfo.a, paramBoolean);
    c(paramFrameInfo);
  }
  
  public int o()
  {
    MediaFormat localMediaFormat = b();
    if (localMediaFormat != null) {
      return (int)(localMediaFormat.getInteger("height") * localMediaFormat.getFloat("mpx-dar"));
    }
    return 0;
  }
  
  public int p()
  {
    MediaFormat localMediaFormat = b();
    if (localMediaFormat != null) {
      return localMediaFormat.getInteger("height");
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaCodecVideoDecoder
 * JD-Core Version:    0.7.0.1
 */