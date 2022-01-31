package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import java.io.File;
import non;
import noo;
import nop;
import noq;

public class VideoViewTextureImpl
  implements IVideoView
{
  public TextureVideoView a;
  
  public VideoViewTextureImpl(Context paramContext)
  {
    this.a = new TextureVideoView(paramContext.getApplicationContext());
  }
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    return this.a.getCurrentPosition();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.a();
  }
  
  @TargetApi(14)
  public void a(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
  
  public void a(long paramLong)
  {
    this.a.seekTo((int)paramLong);
  }
  
  public void a(IVideoView.OnCompletionListener paramOnCompletionListener)
  {
    this.a.setOnCompletionListener(new non(this, paramOnCompletionListener));
  }
  
  public void a(IVideoView.OnDownloadListener paramOnDownloadListener) {}
  
  public void a(IVideoView.OnErrorListener paramOnErrorListener)
  {
    this.a.setOnErrorListener(new noo(this, paramOnErrorListener, null));
  }
  
  public void a(IVideoView.OnInfoListener paramOnInfoListener)
  {
    this.a.setOnInfoListener(new nop(this, paramOnInfoListener));
  }
  
  public void a(IVideoView.OnPreparedListener paramOnPreparedListener)
  {
    TextureVideoView localTextureVideoView = this.a;
    if (paramOnPreparedListener == null) {}
    for (paramOnPreparedListener = null;; paramOnPreparedListener = new noq(this, paramOnPreparedListener))
    {
      localTextureVideoView.setOnPreparedListener(paramOnPreparedListener);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (FileCacheUtils.a(new File(paramString2))) {
        paramString1 = paramString2;
      }
    }
    this.a.setVideoPath(paramString1);
  }
  
  public boolean a()
  {
    return this.a.isPlaying();
  }
  
  public long b()
  {
    return this.a.getDuration();
  }
  
  public void b()
  {
    this.a.start();
  }
  
  public void c()
  {
    this.a.pause();
  }
  
  public void d()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTextureImpl
 * JD-Core Version:    0.7.0.1
 */