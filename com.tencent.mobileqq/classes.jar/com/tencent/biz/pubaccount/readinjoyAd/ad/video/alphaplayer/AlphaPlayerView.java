package com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class AlphaPlayerView
  extends FrameLayout
  implements MediaPlayer.OnCompletionListener, TextureSurfaceRenderer.RendererStatusChangeListener
{
  private static int g = -1;
  private static int h = 0;
  private static int i = 1;
  private static int j = 2;
  private static int k = 3;
  private AlphaTextureRenderer a;
  private MediaPlayer b;
  private TextureView c;
  private AlphaPlayerListener d;
  private int e;
  private int f = g;
  private String l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public AlphaPlayerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AlphaPlayerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(TextureView paramTextureView, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPlay: width-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" height-");
    localStringBuilder.append(paramInt2);
    Log.d("AlphaPlayerView", localStringBuilder.toString());
    b(paramTextureView, paramInt1, paramInt2);
  }
  
  private void b(TextureView paramTextureView, int paramInt1, int paramInt2)
  {
    if ((this.c != null) && (paramInt1 != 0) && (paramInt2 != 0))
    {
      localObject = this.a;
      if (localObject != null) {
        ((AlphaTextureRenderer)localObject).e();
      }
      this.a = new AlphaTextureRenderer(getContext(), paramTextureView.getSurfaceTexture(), paramInt1, paramInt2, this.n, this.o);
      this.a.a(this);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setupRenderer failed: surface-");
    ((StringBuilder)localObject).append(paramTextureView);
    ((StringBuilder)localObject).append(", width-");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", height-");
    ((StringBuilder)localObject).append(paramInt2);
    Log.w("AlphaPlayerView", ((StringBuilder)localObject).toString());
  }
  
  private MediaPlayer h()
  {
    MediaPlayer localMediaPlayer = this.b;
    if (localMediaPlayer == null) {
      this.b = new MediaPlayer();
    }
    try
    {
      localMediaPlayer.reset();
    }
    catch (Throwable localThrowable2)
    {
      label30:
      break label30;
    }
    this.b = new MediaPlayer();
    try
    {
      this.b.setDataSource(this.l);
      this.b.setVolume(0.0F, 0.0F);
      this.b.setLooping(this.m);
      this.b.setOnCompletionListener(this);
    }
    catch (Throwable localThrowable1)
    {
      Log.e("AlphaPlayerView", "initPlayer failed", localThrowable1);
      AlphaThreadUtil.a(new AlphaPlayerView.1(this));
    }
    return this.b;
  }
  
  private TextureView i()
  {
    TextureView localTextureView = new TextureView(getContext());
    localTextureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localTextureView.setOpaque(false);
    return localTextureView;
  }
  
  public void a()
  {
    Log.d("AlphaPlayerView", "play");
    this.f = i;
    AlphaPlayerListener localAlphaPlayerListener = this.d;
    if (localAlphaPlayerListener != null) {
      localAlphaPlayerListener.a(this.f);
    }
    this.c = i();
    this.c.setSurfaceTextureListener(new AlphaPlayerView.2(this));
    addView(this.c, 0);
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, AlphaPlayerListener paramAlphaPlayerListener)
  {
    this.l = paramString;
    this.n = paramBoolean1;
    this.m = paramBoolean2;
    this.o = paramBoolean3;
    this.d = paramAlphaPlayerListener;
    this.f = h;
    if (paramAlphaPlayerListener != null) {
      paramAlphaPlayerListener.a(this.f);
    }
  }
  
  public void b()
  {
    Log.i("AlphaPlayerView", "onGLInit");
  }
  
  public void c()
  {
    Log.w("AlphaPlayerView", "onGLInitFailed");
    AlphaThreadUtil.a(new AlphaPlayerView.3(this));
  }
  
  public void d()
  {
    Log.i("AlphaPlayerView", "onGLComponentsInit");
    MediaPlayer localMediaPlayer = h();
    if (localMediaPlayer == null) {
      return;
    }
    try
    {
      localMediaPlayer.setSurface(new Surface(this.a.d()));
      localMediaPlayer.prepare();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGLComponentsInited: videosize(");
      localStringBuilder.append(localMediaPlayer.getVideoWidth());
      localStringBuilder.append(", ");
      localStringBuilder.append(localMediaPlayer.getVideoHeight());
      localStringBuilder.append(")");
      Log.i("AlphaPlayerView", localStringBuilder.toString());
      this.a.a(localMediaPlayer.getVideoWidth(), localMediaPlayer.getVideoHeight());
      if (this.e > 500)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("start play, seek to: ");
        localStringBuilder.append(this.e);
        Log.i("AlphaPlayerView", localStringBuilder.toString());
        localMediaPlayer.setOnSeekCompleteListener(new AlphaPlayerView.4(this, localMediaPlayer));
        localMediaPlayer.seekTo(this.e);
        return;
      }
      localMediaPlayer.start();
      return;
    }
    catch (Throwable localThrowable)
    {
      AlphaThreadUtil.a(new AlphaPlayerView.5(this));
      Log.e("AlphaPlayerView", "start the video failed!", localThrowable);
    }
  }
  
  public void e()
  {
    Log.w("AlphaPlayerView", "onGLComponentsInitFailed");
    AlphaThreadUtil.a(new AlphaPlayerView.6(this));
  }
  
  public void f()
  {
    Log.i("AlphaPlayerView", "onGLComponentsDeInit");
  }
  
  public void g()
  {
    Log.i("AlphaPlayerView", "onGLDeInit");
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    Log.i("AlphaPlayerView", "onCompletion");
    this.f = k;
    paramMediaPlayer = this.d;
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.a(this);
      this.d.a(this.f);
    }
    paramMediaPlayer = this.a;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.f();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Log.d("AlphaPlayerView", "onDetachedFromWindow");
    Object localObject = this.a;
    if (localObject != null) {
      ((AlphaTextureRenderer)localObject).e();
    }
    localObject = this.b;
    if (localObject != null) {}
    try
    {
      ((MediaPlayer)localObject).stop();
      this.b.release();
      label42:
      super.onDetachedFromWindow();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label42;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSizeChanged w:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" h:");
    ((StringBuilder)localObject).append(paramInt2);
    Log.i("AlphaPlayerView", ((StringBuilder)localObject).toString());
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    localObject = this.a;
    if (localObject != null) {
      ((AlphaTextureRenderer)localObject).b(paramInt1, paramInt2);
    }
  }
  
  public void setBegin(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer.AlphaPlayerView
 * JD-Core Version:    0.7.0.1
 */