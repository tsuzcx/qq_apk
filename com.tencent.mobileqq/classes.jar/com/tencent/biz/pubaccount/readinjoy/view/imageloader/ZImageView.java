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
import blfz;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import qdm;
import qdn;
import tlt;
import tlw;
import tmd;
import tmf;
import tmg;
import vuw;

public class ZImageView
  extends ImageView
{
  static int FADE_DURATION = 300;
  private boolean hasSetAlphaBgDrawable;
  private boolean isRound;
  private ValueAnimator mAlphaAnimator;
  private Drawable mBackgroundDrawableTemp;
  public tlt mController;
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
    this.mController = new tlt(this.sColorDrawable, this);
    this.mAlphaAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
    this.mAlphaAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mAlphaAnimator.setDuration(FADE_DURATION);
    this.mAlphaAnimator.addListener(new tmf(this));
    this.mAlphaAnimator.addUpdateListener(new tmg(this));
  }
  
  private void resetBgDrawable()
  {
    if (this.hasSetAlphaBgDrawable)
    {
      setBackgroundDrawable(this.mBackgroundDrawableTemp);
      this.hasSetAlphaBgDrawable = false;
      if (QLog.isColorLevel()) {
        tmd.a(this.tag, "cancel alpha bg drawable !");
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
        tmd.a(this.tag, "set alpha bg drawable !");
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
      tmd.a(this.tag, "onAttachedToWindow, parent: " + (String)localObject);
      this.mController.b("onAttachedToWindow");
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel()) {
      tmd.a(this.tag, "onDetachedFromWindow");
    }
    this.mController.a("onDetachedFromWindow");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mUrl != null)
    {
      if (QLog.isColorLevel()) {
        tmd.a(this.tag, "onDraw dispatch load image");
      }
      tlw localtlw = new tlw();
      qdn.a.a(localtlw, this.mUrl.toString());
      localtlw.jdField_a_of_type_Int = getWidth();
      localtlw.b = getHeight();
      this.mController.a(localtlw);
      this.mUrl = null;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    if (QLog.isColorLevel()) {
      tmd.a(this.tag, "onFinishTemporaryDetach");
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
      tmd.a(this.tag, "onStartTemporaryDetach, parent: " + (String)localObject);
      this.mController.a("onStartTemporaryDetach");
      return;
    }
  }
  
  public ZImageView setImage(URL paramURL)
  {
    blfz.a("ZImageView.setImage");
    if (paramURL == null)
    {
      blfz.a();
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
      tmd.a(this.tag, "setImage " + paramURL + " width " + getWidth() + " isAttach " + bool);
    }
    if (getWidth() > 0)
    {
      blfz.a("ZImageView.newImageRequest");
      tlw localtlw = new tlw();
      qdn.a.a(localtlw, paramURL.toString());
      localtlw.jdField_a_of_type_Int = getWidth();
      localtlw.b = getHeight();
      qdm.a(1, localtlw);
      this.mController.a(localtlw);
      blfz.a();
    }
    for (;;)
    {
      blfz.a();
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
  
  public ZImageView setImageForImageCollection(tlw paramtlw, vuw paramvuw)
  {
    if ((paramtlw == null) || (paramtlw.jdField_a_of_type_JavaNetURL == null)) {
      return this;
    }
    qdn.a.a(paramtlw, paramtlw.jdField_a_of_type_JavaNetURL.toString());
    if (paramvuw != null) {
      this.mController.a(paramvuw);
    }
    this.mUrl = null;
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "setImageForImageCollection url = " + paramtlw.jdField_a_of_type_JavaNetURL + " reqWidth = " + paramtlw.jdField_a_of_type_Int + " reqHeight = " + paramtlw.b);
    }
    this.mController.a(paramtlw);
    return this;
  }
  
  public ZImageView setImagePlaceHolder(Drawable paramDrawable)
  {
    this.mUrl = null;
    this.mController.a(paramDrawable);
    return this;
  }
  
  public void setPublicAccountImageDownListener(vuw paramvuw)
  {
    if (paramvuw != null) {
      this.mController.a(paramvuw);
    }
  }
  
  @Deprecated
  public void setRound(boolean paramBoolean)
  {
    this.isRound = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView
 * JD-Core Version:    0.7.0.1
 */