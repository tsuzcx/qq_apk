package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import bjun;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import psp;
import psq;
import syl;
import syo;
import syv;
import syx;
import syy;
import vgd;

public class ZImageView
  extends ImageView
{
  static int FADE_DURATION = 300;
  private boolean hasSetAlphaBgDrawable;
  private boolean isRound;
  private ValueAnimator mAlphaAnimator;
  private Drawable mBackgroundDrawableTemp;
  public syl mController;
  private URL mUrl;
  private Drawable sColorDrawable = new ColorDrawable(-1);
  private boolean startAplhaOnce;
  private String tag = "zimage.ZImageView.v" + hashCode();
  
  public ZImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ZImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ZImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mController = new syl(this.sColorDrawable, this);
    this.mAlphaAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
    this.mAlphaAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mAlphaAnimator.setDuration(FADE_DURATION);
    this.mAlphaAnimator.addListener(new syx(this));
    this.mAlphaAnimator.addUpdateListener(new syy(this));
  }
  
  private void resetBgDrawable()
  {
    if (this.hasSetAlphaBgDrawable)
    {
      setBackgroundDrawable(this.mBackgroundDrawableTemp);
      this.hasSetAlphaBgDrawable = false;
      if (QLog.isColorLevel()) {
        syv.a(this.tag, "cancel alpha bg drawable !");
      }
    }
  }
  
  private void setBgDrawable()
  {
    if ((!this.hasSetAlphaBgDrawable) && (this.mController.a != this.sColorDrawable))
    {
      this.mBackgroundDrawableTemp = getBackground();
      setBackgroundDrawable(this.mController.a);
      this.hasSetAlphaBgDrawable = true;
      if (QLog.isColorLevel()) {
        syv.a(this.tag, "set alpha bg drawable !");
      }
    }
  }
  
  public void doAlphaAnimationInNextDraw()
  {
    this.startAplhaOnce = true;
    this.mAlphaAnimator.cancel();
  }
  
  @Deprecated
  public boolean isRound()
  {
    return this.isRound;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (QLog.isColorLevel())
    {
      localObject = getParent();
      if (localObject == null) {
        break label63;
      }
    }
    label63:
    for (Object localObject = localObject.getClass().getName();; localObject = null)
    {
      syv.a(this.tag, "onAttachedToWindow, parent: " + (String)localObject);
      this.mController.b("onAttachedToWindow");
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel()) {
      syv.a(this.tag, "onDetachedFromWindow");
    }
    this.mController.a("onDetachedFromWindow");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mUrl != null)
    {
      if (QLog.isColorLevel()) {
        syv.a(this.tag, "onDraw dispatch load image");
      }
      syo localsyo = new syo();
      psq.a.a(localsyo, this.mUrl.toString());
      localsyo.jdField_a_of_type_Int = getWidth();
      localsyo.b = getHeight();
      this.mController.a(localsyo);
      this.mUrl = null;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    if (QLog.isColorLevel()) {
      syv.a(this.tag, "onFinishTemporaryDetach");
    }
    this.mController.b("onFinishTemporaryDetach");
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (QLog.isColorLevel())
    {
      localObject = getParent();
      if (localObject == null) {
        break label63;
      }
    }
    label63:
    for (Object localObject = localObject.getClass().getName();; localObject = null)
    {
      syv.a(this.tag, "onStartTemporaryDetach, parent: " + (String)localObject);
      this.mController.a("onStartTemporaryDetach");
      return;
    }
  }
  
  public ZImageView setImage(URL paramURL)
  {
    bjun.a("ZImageView.setImage");
    if (paramURL == null)
    {
      bjun.a();
      return this;
    }
    if ((this.mUrl != null) && (this.mUrl.getPath().equals(paramURL.getPath()))) {
      QLog.d("ZImageView", 2, "setImage | same");
    }
    this.mUrl = null;
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT >= 19) {
        bool = isAttachedToWindow();
      }
      syv.a(this.tag, "setImage " + paramURL + " width " + getWidth() + " isAttach " + bool);
    }
    if (getWidth() > 0)
    {
      bjun.a("ZImageView.newImageRequest");
      syo localsyo = new syo();
      psq.a.a(localsyo, paramURL.toString());
      localsyo.jdField_a_of_type_Int = getWidth();
      localsyo.b = getHeight();
      psp.a(1, localsyo);
      this.mController.a(localsyo);
      bjun.a();
    }
    for (;;)
    {
      bjun.a();
      return this;
      this.mUrl = paramURL;
    }
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mAlphaAnimator.cancel();
      setBgDrawable();
      setImageDrawable(paramDrawable);
      this.mAlphaAnimator.start();
      return;
    }
    setImageDrawable(paramDrawable);
  }
  
  public ZImageView setImageForImageCollection(syo paramsyo, vgd paramvgd)
  {
    if ((paramsyo == null) || (paramsyo.jdField_a_of_type_JavaNetURL == null)) {
      return this;
    }
    psq.a.a(paramsyo, paramsyo.jdField_a_of_type_JavaNetURL.toString());
    if (paramvgd != null) {
      this.mController.a(paramvgd);
    }
    this.mUrl = null;
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "setImageForImageCollection url = " + paramsyo.jdField_a_of_type_JavaNetURL + " reqWidth = " + paramsyo.jdField_a_of_type_Int + " reqHeight = " + paramsyo.b);
    }
    this.mController.a(paramsyo);
    return this;
  }
  
  public ZImageView setImagePlaceHolder(Drawable paramDrawable)
  {
    this.mUrl = null;
    this.mController.a(paramDrawable);
    return this;
  }
  
  public void setPublicAccountImageDownListener(vgd paramvgd)
  {
    if (paramvgd != null) {
      this.mController.a(paramvgd);
    }
  }
  
  @Deprecated
  public void setRound(boolean paramBoolean)
  {
    this.isRound = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView
 * JD-Core Version:    0.7.0.1
 */