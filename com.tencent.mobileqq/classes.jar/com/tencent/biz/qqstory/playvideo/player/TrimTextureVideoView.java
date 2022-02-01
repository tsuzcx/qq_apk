package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Build;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;

public class TrimTextureVideoView
  extends TextureVideoView
  implements MediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnSeekCompleteListener
{
  public static int D;
  public int E = 0;
  protected int F = 0;
  protected int G = 0;
  protected int H = 0;
  protected int I = 0;
  protected int J = 0;
  protected int K = 0;
  protected int L = 0;
  protected int M = 0;
  protected boolean N = false;
  protected boolean O = false;
  protected boolean P = true;
  protected boolean Q = true;
  protected Runnable R = new TrimTextureVideoView.1(this);
  protected Runnable S = new TrimTextureVideoView.2(this);
  private TrimTextureVideoView.OnPlayRecycleListener a;
  private IMediaPlayer.OnSeekCompleteListener b;
  
  public TrimTextureVideoView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public TrimTextureVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public TrimTextureVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void e()
  {
    int i = D + 1;
    D = i;
    this.E = i;
    setOnErrorListener(new TrimTextureVideoView.3(this));
    f();
    super.setOnSeekCompleteListener(this);
  }
  
  private void f()
  {
    if (Build.MODEL.toUpperCase().equals("PIXEL 2 XL")) {
      this.Q = false;
    }
  }
  
  protected IMediaPlayer a()
  {
    if (this.Q) {
      return new com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer();
    }
    return super.a();
  }
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    this.P = true;
    if ((this.F != 0) && (this.H != 0))
    {
      int i = super.getCurrentPosition();
      if (i < this.H)
      {
        SLog.a(this.c, "It need adjust start time,startTime=%s,currentPos=%s", Integer.valueOf(this.F), Integer.valueOf(i));
        this.G = i;
      }
    }
    IMediaPlayer.OnSeekCompleteListener localOnSeekCompleteListener = this.b;
    if (localOnSeekCompleteListener != null) {
      localOnSeekCompleteListener.a(paramIMediaPlayer);
    }
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.a(this.c, "[%d]resumePlay(%b)", Integer.valueOf(this.E), Boolean.valueOf(paramBoolean));
    if ((paramBoolean) || (!super.isPlaying()))
    {
      this.I = this.F;
      super.seekTo(this.I);
      this.P = false;
      TrimTextureVideoView.OnPlayRecycleListener localOnPlayRecycleListener = this.a;
      if (localOnPlayRecycleListener != null) {
        localOnPlayRecycleListener.a();
      }
    }
    super.start();
  }
  
  @TargetApi(14)
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((this.Q) && (com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.n())) {
      i = paramInt1 + 0;
    } else {
      i = 0;
    }
    int j = paramInt1 % 180;
    float f1;
    float f2;
    if (((j > 0) && (paramInt2 < paramInt3)) || ((j == 0) && (paramInt2 > paramInt3)))
    {
      setRotation(i + 90);
      f1 = 1.0F / TakeVideoUtils.b(getResources());
      f2 = Math.min(paramInt3, paramInt2) * 1.0F / Math.max(paramInt3, paramInt2);
      setScaleX(Math.max(f1, f2));
      setScaleY(Math.max(f1, f2));
      SLog.a(this.c, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      return true;
    }
    if (i != 0)
    {
      setRotation(i);
      f1 = 1.0F / TakeVideoUtils.b(getResources());
      f2 = Math.min(paramInt3, paramInt2) * 1.0F / Math.max(paramInt3, paramInt2);
      setScaleX(Math.max(f1, f2));
      setScaleY(Math.max(f1, f2));
      SLog.a(this.c, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate! but return false", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      return false;
    }
    SLog.a(this.c, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
    return false;
  }
  
  public void b()
  {
    SLog.a(this.c, "[%d]stopPlayback()", Integer.valueOf(this.E));
    super.b();
  }
  
  public void b(boolean paramBoolean)
  {
    this.N = paramBoolean;
    if (this.i == null) {
      return;
    }
    if (paramBoolean)
    {
      this.i.a(0.0F, 0.0F);
      return;
    }
    this.i.a(1.0F, 1.0F);
  }
  
  @TargetApi(14)
  public void c()
  {
    SLog.a(this.c, "[%d]pausePlay()", Integer.valueOf(this.E));
    this.I = super.getCurrentPosition();
    removeCallbacks(this.S);
    super.pause();
  }
  
  @TargetApi(14)
  public void d()
  {
    if (this.H != 0)
    {
      removeCallbacks(this.S);
      postDelayed(this.S, this.H - this.F);
    }
  }
  
  public int getEndTime()
  {
    return this.H;
  }
  
  public int getRealStartTime()
  {
    return this.G;
  }
  
  public int getStartTime()
  {
    return this.F;
  }
  
  @TargetApi(14)
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.O = true;
    SLog.a(this.c, "[%d]onAttachedToWindow! schedule!", Integer.valueOf(this.E));
    post(this.R);
  }
  
  @TargetApi(14)
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.O = false;
    SLog.a(this.c, "[%d]onDetachedFromWindow! cancel schedule!", Integer.valueOf(this.E));
    removeCallbacks(this.R);
  }
  
  @Deprecated
  public void onSeekComplete(android.media.MediaPlayer paramMediaPlayer)
  {
    if ((this.F != 0) && (this.H != 0))
    {
      int i = super.getCurrentPosition();
      if (i < this.H)
      {
        SLog.a(this.c, "It need adjust start time,startTime=%s,currentPos=%s", Integer.valueOf(this.F), Integer.valueOf(i));
        this.G = i;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    SLog.a(this.c, "onSizeChanged(%d, %d, %d, %d)", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4));
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    b(this.N);
  }
  
  public void setOnRecyclePlayListener(TrimTextureVideoView.OnPlayRecycleListener paramOnPlayRecycleListener)
  {
    this.a = paramOnPlayRecycleListener;
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.b = paramOnSeekCompleteListener;
  }
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    int j = getDuration();
    int k = Math.max(paramInt2 - paramInt1, 1000);
    int i = paramInt1;
    paramInt1 = paramInt2;
    if (paramInt2 > j)
    {
      i = j - k;
      paramInt1 = j;
    }
    SLog.a(this.c, "[%d]setPlayRange(%d, %d)", Integer.valueOf(this.E), Integer.valueOf(i), Integer.valueOf(paramInt1));
    if ((isPlaying()) && ((i != this.F) || (paramInt1 != this.H)))
    {
      super.seekTo(this.F);
      this.P = false;
    }
    this.F = i;
    this.G = i;
    this.H = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView
 * JD-Core Version:    0.7.0.1
 */