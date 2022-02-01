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
  private Surface jdField_a_of_type_AndroidViewSurface;
  private boolean jdField_a_of_type_Boolean;
  
  public MediaCodecVideoDecoder(MediaExtractor paramMediaExtractor, boolean paramBoolean1, int paramInt, MediaCodecDecoder.OnDecoderEventListener paramOnDecoderEventListener, Surface paramSurface, boolean paramBoolean2)
  {
    super(paramMediaExtractor, paramBoolean1, paramInt, paramOnDecoderEventListener);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a();
  }
  
  @TargetApi(16)
  private long a(long paramLong, MediaExtractor paramMediaExtractor, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.flush();
    paramMediaExtractor.a(paramLong, 0);
    if (paramMediaExtractor.a() == paramLong)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "skip fastseek, already there");
      return paramLong;
    }
    b();
    a(false);
    paramMediaExtractor.a(paramLong, 0);
    long l1 = 9223372036854775807L;
    long l3 = 0L;
    int i = 0;
    while ((paramMediaExtractor.a()) && (i < 20))
    {
      long l5 = paramLong - paramMediaExtractor.a();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l1)
        {
          l4 = paramMediaExtractor.a();
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
    while (paramMediaExtractor.a() != l3) {
      paramMediaExtractor.a();
    }
    paramMediaCodec = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exact fastseek match:       ");
    localStringBuilder.append(paramMediaExtractor.a());
    Log.d(paramMediaCodec, localStringBuilder.toString());
    return l3;
  }
  
  public int a()
  {
    MediaFormat localMediaFormat = a();
    if (localMediaFormat != null) {
      return (int)(localMediaFormat.getInteger("height") * localMediaFormat.getFloat("mpx-dar"));
    }
    return 0;
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
        paramMediaExtractor = this.jdField_a_of_type_JavaLangString;
        paramMediaCodec = new StringBuilder();
        paramMediaCodec.append("fast_exact seek to ");
        paramMediaCodec.append(paramLong);
        paramMediaCodec.append(" arrived at ");
        paramMediaCodec.append(paramSeekMode.jdField_a_of_type_Long);
        Log.d(paramMediaExtractor, paramMediaCodec.toString());
        if (paramSeekMode.jdField_a_of_type_Long < paramLong) {
          Log.d(this.jdField_a_of_type_JavaLangString, "presentation is behind...");
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
        long l1 = localFrameInfo.jdField_a_of_type_Long / 1000L;
        long l3 = -1L;
        i = 0;
        paramLong = l2;
        while (l1 < paramLong)
        {
          if (i == 0) {
            Log.d(this.jdField_a_of_type_JavaLangString, "skipping frames...");
          }
          i += 1;
          if (b()) {
            paramLong = localFrameInfo.jdField_a_of_type_Long / 1000L;
          }
          if (localFrameInfo.jdField_a_of_type_Boolean)
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "end of stream reached, seeking to last frame");
            a(localFrameInfo, false);
            return a(paramSeekMode, l3, paramMediaExtractor, paramMediaCodec);
          }
          l3 = localFrameInfo.jdField_a_of_type_Long;
          a(localFrameInfo, false);
          localFrameInfo = a(true, true);
          if (localFrameInfo == null) {
            return null;
          }
          l1 = localFrameInfo.jdField_a_of_type_Long / 1000L;
        }
        localObject = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("frame new position:         ");
        localStringBuilder.append(localFrameInfo.jdField_a_of_type_Long);
        Log.d((String)localObject, localStringBuilder.toString());
        localObject = this.jdField_a_of_type_JavaLangString;
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
              Log.w(this.jdField_a_of_type_JavaLangString, "this should never happen");
              l4 = paramLong;
              localObject = localFrameInfo;
              l5 = l1;
            }
            else
            {
              localObject = this.jdField_a_of_type_JavaLangString;
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
      paramSeekMode = this.jdField_a_of_type_JavaLangString;
      paramMediaExtractor = new StringBuilder();
      paramMediaExtractor.append("fast seek to ");
      paramMediaExtractor.append(paramLong);
      paramMediaExtractor.append(" arrived at ");
      paramMediaExtractor.append(localFrameInfo.jdField_a_of_type_Long);
      Log.d(paramSeekMode, paramMediaExtractor.toString());
      localObject = localFrameInfo;
      l4 = l2;
    }
    if (l5 == l4) {
      Log.d(this.jdField_a_of_type_JavaLangString, "exact seek match!");
    }
    return localObject;
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec.configure(paramMediaFormat, this.jdField_a_of_type_AndroidViewSurface, null, 0);
  }
  
  public void a(Surface paramSurface)
  {
    if (paramSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface = paramSurface;
      a();
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
    a().releaseOutputBuffer(paramFrameInfo.jdField_a_of_type_Int, paramBoolean);
    c(paramFrameInfo);
  }
  
  public int b()
  {
    MediaFormat localMediaFormat = a();
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