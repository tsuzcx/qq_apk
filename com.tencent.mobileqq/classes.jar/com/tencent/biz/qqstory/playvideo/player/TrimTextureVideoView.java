package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Build;
import android.util.AttributeSet;
import vxa;
import vxb;
import vyi;
import vyo;
import wxe;
import xcp;

public class TrimTextureVideoView
  extends TextureVideoView
  implements MediaPlayer.OnSeekCompleteListener, vyo
{
  public static int h;
  protected Runnable a;
  private vxb a;
  protected Runnable b;
  private vyo b;
  protected boolean h;
  public int i;
  protected boolean i;
  protected int j;
  protected boolean j;
  protected int k;
  protected boolean k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  
  public TrimTextureVideoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new TrimTextureVideoView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new TrimTextureVideoView.2(this);
    e();
  }
  
  public TrimTextureVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new TrimTextureVideoView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new TrimTextureVideoView.2(this);
    e();
  }
  
  public TrimTextureVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new TrimTextureVideoView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new TrimTextureVideoView.2(this);
    e();
  }
  
  private void e()
  {
    int i1 = jdField_h_of_type_Int + 1;
    jdField_h_of_type_Int = i1;
    this.jdField_i_of_type_Int = i1;
    setOnErrorListener(new vxa(this));
    f();
    super.setOnSeekCompleteListener(this);
  }
  
  private void f()
  {
    if (Build.MODEL.toUpperCase().equals("PIXEL 2 XL")) {
      this.jdField_k_of_type_Boolean = false;
    }
  }
  
  public int a()
  {
    return this.jdField_k_of_type_Int;
  }
  
  protected vyi a()
  {
    if (this.jdField_k_of_type_Boolean) {
      return new com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer();
    }
    return super.a();
  }
  
  public void a()
  {
    wxe.a(this.jdField_a_of_type_JavaLangString, "[%d]stopPlayback()", Integer.valueOf(this.jdField_i_of_type_Int));
    super.a();
  }
  
  public void a(vyi paramvyi)
  {
    this.jdField_j_of_type_Boolean = true;
    if ((this.jdField_j_of_type_Int != 0) && (this.l != 0))
    {
      int i1 = super.getCurrentPosition();
      if (i1 < this.l)
      {
        wxe.a(this.jdField_a_of_type_JavaLangString, "It need adjust start time,startTime=%s,currentPos=%s", Integer.valueOf(this.jdField_j_of_type_Int), Integer.valueOf(i1));
        this.jdField_k_of_type_Int = i1;
      }
    }
    if (this.jdField_b_of_type_Vyo != null) {
      this.jdField_b_of_type_Vyo.a(paramvyi);
    }
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    wxe.a(this.jdField_a_of_type_JavaLangString, "[%d]resumePlay(%b)", Integer.valueOf(this.jdField_i_of_type_Int), Boolean.valueOf(paramBoolean));
    if ((paramBoolean) || (!super.isPlaying()))
    {
      this.m = this.jdField_j_of_type_Int;
      super.seekTo(this.m);
      this.jdField_j_of_type_Boolean = false;
      if (this.jdField_a_of_type_Vxb != null) {
        this.jdField_a_of_type_Vxb.b();
      }
    }
    super.start();
  }
  
  @TargetApi(14)
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_k_of_type_Boolean) && (com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.b())) {}
    for (int i1 = 0 + paramInt1;; i1 = 0)
    {
      float f1;
      float f2;
      if (((paramInt1 % 180 > 0) && (paramInt2 < paramInt3)) || ((paramInt1 % 180 == 0) && (paramInt2 > paramInt3)))
      {
        setRotation(i1 + 90);
        f1 = 1.0F / xcp.a(getResources());
        f2 = Math.min(paramInt3, paramInt2) * 1.0F / Math.max(paramInt3, paramInt2);
        setScaleX(Math.max(f1, f2));
        setScaleY(Math.max(f1, f2));
        wxe.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
        return true;
      }
      if (i1 != 0)
      {
        setRotation(i1);
        f1 = 1.0F / xcp.a(getResources());
        f2 = Math.min(paramInt3, paramInt2) * 1.0F / Math.max(paramInt3, paramInt2);
        setScaleX(Math.max(f1, f2));
        setScaleY(Math.max(f1, f2));
        wxe.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate! but return false", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
        return false;
      }
      wxe.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      return false;
    }
  }
  
  public int b()
  {
    return this.jdField_j_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_i_of_type_Boolean = false;
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    wxe.a(this.jdField_a_of_type_JavaLangString, "[%d]stopPlay! cancel schedule!", Integer.valueOf(this.jdField_i_of_type_Int));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Vyi == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Vyi.a(0.0F, 0.0F);
      return;
    }
    this.jdField_a_of_type_Vyi.a(1.0F, 1.0F);
  }
  
  public int c()
  {
    return this.l;
  }
  
  @TargetApi(14)
  public void c()
  {
    wxe.a(this.jdField_a_of_type_JavaLangString, "[%d]pausePlay()", Integer.valueOf(this.jdField_i_of_type_Int));
    this.m = super.getCurrentPosition();
    removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    super.pause();
  }
  
  @TargetApi(14)
  public void d()
  {
    if (this.l != 0)
    {
      removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      postDelayed(this.jdField_b_of_type_JavaLangRunnable, this.l - this.jdField_j_of_type_Int);
    }
  }
  
  @TargetApi(14)
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_i_of_type_Boolean = true;
    wxe.a(this.jdField_a_of_type_JavaLangString, "[%d]onAttachedToWindow! schedule!", Integer.valueOf(this.jdField_i_of_type_Int));
    post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  @TargetApi(14)
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_i_of_type_Boolean = false;
    wxe.a(this.jdField_a_of_type_JavaLangString, "[%d]onDetachedFromWindow! cancel schedule!", Integer.valueOf(this.jdField_i_of_type_Int));
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  @Deprecated
  public void onSeekComplete(android.media.MediaPlayer paramMediaPlayer)
  {
    if ((this.jdField_j_of_type_Int != 0) && (this.l != 0))
    {
      int i1 = super.getCurrentPosition();
      if (i1 < this.l)
      {
        wxe.a(this.jdField_a_of_type_JavaLangString, "It need adjust start time,startTime=%s,currentPos=%s", Integer.valueOf(this.jdField_j_of_type_Int), Integer.valueOf(i1));
        this.jdField_k_of_type_Int = i1;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    wxe.a(this.jdField_a_of_type_JavaLangString, "onSizeChanged(%d, %d, %d, %d)", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4));
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    b(this.jdField_h_of_type_Boolean);
  }
  
  public void setOnRecyclePlayListener(vxb paramvxb)
  {
    this.jdField_a_of_type_Vxb = paramvxb;
  }
  
  public void setOnSeekCompleteListener(vyo paramvyo)
  {
    this.jdField_b_of_type_Vyo = paramvyo;
  }
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    int i2 = getDuration();
    int i3 = Math.max(paramInt2 - paramInt1, 1000);
    int i1 = paramInt1;
    paramInt1 = paramInt2;
    if (paramInt2 > i2)
    {
      i1 = i2 - i3;
      paramInt1 = i2;
    }
    wxe.a(this.jdField_a_of_type_JavaLangString, "[%d]setPlayRange(%d, %d)", Integer.valueOf(this.jdField_i_of_type_Int), Integer.valueOf(i1), Integer.valueOf(paramInt1));
    if ((isPlaying()) && ((i1 != this.jdField_j_of_type_Int) || (paramInt1 != this.l)))
    {
      super.seekTo(this.jdField_j_of_type_Int);
      this.jdField_j_of_type_Boolean = false;
    }
    this.jdField_j_of_type_Int = i1;
    this.jdField_k_of_type_Int = i1;
    this.l = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView
 * JD-Core Version:    0.7.0.1
 */