package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.File;

public class VideoViewTextureImpl
  implements IVideoView
{
  StoryPlayerTVKWrapper.ReportData a = new StoryPlayerTVKWrapper.ReportData();
  TextureVideoView b;
  private String c = "VideoViewTextureImpl";
  
  public VideoViewTextureImpl(Context paramContext, String paramString)
  {
    this.b = new TextureVideoView(paramContext.getApplicationContext());
    paramContext = new StringBuilder();
    paramContext.append(this.c);
    paramContext.append(paramString);
    this.c = paramContext.toString();
  }
  
  public View a()
  {
    return this.b;
  }
  
  @TargetApi(14)
  public void a(int paramInt)
  {
    this.b.setVisibility(paramInt);
  }
  
  public void a(IVideoView.OnCompletionListener paramOnCompletionListener)
  {
    TextureVideoView localTextureVideoView = this.b;
    if (paramOnCompletionListener == null) {
      paramOnCompletionListener = null;
    } else {
      paramOnCompletionListener = new VideoViewTextureImpl.1(this, paramOnCompletionListener);
    }
    localTextureVideoView.setOnCompletionListener(paramOnCompletionListener);
  }
  
  public void a(IVideoView.OnDownloadListener paramOnDownloadListener) {}
  
  public void a(IVideoView.OnErrorListener paramOnErrorListener)
  {
    TextureVideoView localTextureVideoView = this.b;
    Object localObject = null;
    if (paramOnErrorListener == null) {
      paramOnErrorListener = localObject;
    } else {
      paramOnErrorListener = new VideoViewTextureImpl.2(this, paramOnErrorListener, null);
    }
    localTextureVideoView.setOnErrorListener(paramOnErrorListener);
  }
  
  public void a(IVideoView.OnInfoListener paramOnInfoListener)
  {
    TextureVideoView localTextureVideoView = this.b;
    if (paramOnInfoListener == null) {
      paramOnInfoListener = null;
    } else {
      paramOnInfoListener = new VideoViewTextureImpl.3(this, paramOnInfoListener);
    }
    localTextureVideoView.setOnInfoListener(paramOnInfoListener);
  }
  
  public void a(IVideoView.OnPreparedListener paramOnPreparedListener)
  {
    TextureVideoView localTextureVideoView = this.b;
    if (paramOnPreparedListener == null) {
      paramOnPreparedListener = null;
    } else {
      paramOnPreparedListener = new VideoViewTextureImpl.4(this, paramOnPreparedListener);
    }
    localTextureVideoView.setOnPreparedListener(paramOnPreparedListener);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    StoryPlayerTVKWrapper.ReportData localReportData = this.a;
    localReportData.b = paramString1;
    localReportData.c = true;
    if ((TextUtils.isEmpty(paramString2)) || (!FileCacheUtils.a(new File(paramString2)))) {
      paramString2 = paramString3;
    }
    SLog.d(this.c, "setVideoPath");
    this.b.setVideoPath(paramString2);
  }
  
  public StoryPlayerTVKWrapper.ReportData b()
  {
    return this.a;
  }
  
  public void c()
  {
    SLog.d(this.c, "stopPlayback");
    this.b.b();
  }
  
  public void d()
  {
    SLog.d(this.c, "start");
    this.b.start();
  }
  
  public long e()
  {
    return this.b.getCurrentPosition();
  }
  
  public void f()
  {
    SLog.d(this.c, "pause");
    this.b.pause();
  }
  
  public void g()
  {
    SLog.d(this.c, "restart");
    d();
  }
  
  public long h()
  {
    return this.b.getDuration();
  }
  
  public boolean i()
  {
    return this.b.isPlaying();
  }
  
  public int j()
  {
    return 0;
  }
  
  public int k()
  {
    return 1;
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTextureImpl
 * JD-Core Version:    0.7.0.1
 */