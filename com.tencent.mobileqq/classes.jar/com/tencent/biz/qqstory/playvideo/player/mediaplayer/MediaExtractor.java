package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaFormat;
import android.net.Uri;
import java.nio.ByteBuffer;
import java.util.Map;

public class MediaExtractor
{
  private android.media.MediaExtractor a;
  
  public MediaExtractor()
  {
    a();
  }
  
  public int a(ByteBuffer paramByteBuffer, int paramInt)
  {
    return this.a.readSampleData(paramByteBuffer, paramInt);
  }
  
  @TargetApi(16)
  public MediaFormat a(int paramInt)
  {
    MediaFormat localMediaFormat = this.a.getTrackFormat(paramInt);
    if (localMediaFormat.getString("mime").startsWith("video/")) {
      localMediaFormat.setFloat("mpx-dar", localMediaFormat.getInteger("width") / localMediaFormat.getInteger("height"));
    }
    return localMediaFormat;
  }
  
  @TargetApi(16)
  protected void a()
  {
    android.media.MediaExtractor localMediaExtractor = this.a;
    if (localMediaExtractor != null) {
      localMediaExtractor.release();
    }
    this.a = new android.media.MediaExtractor();
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.a.seekTo(paramLong, paramInt);
  }
  
  public final void a(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.a.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void b()
  {
    this.a.release();
  }
  
  public void b(int paramInt)
  {
    this.a.selectTrack(paramInt);
  }
  
  public final int c()
  {
    return this.a.getTrackCount();
  }
  
  public boolean d()
  {
    return this.a.advance();
  }
  
  public int e()
  {
    return this.a.getSampleTrackIndex();
  }
  
  public long f()
  {
    return this.a.getSampleTime();
  }
  
  public long g()
  {
    return this.a.getCachedDuration();
  }
  
  public boolean h()
  {
    return this.a.hasCacheReachedEndOfStream();
  }
  
  public boolean i()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaExtractor
 * JD-Core Version:    0.7.0.1
 */