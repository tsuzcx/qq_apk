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
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptReport;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageTypeOptHelper;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.net.URL;

public class ZImageView
  extends ImageView
{
  static int FADE_DURATION = 300;
  private boolean hasSetAlphaBgDrawable = false;
  private boolean isRound;
  private ValueAnimator mAlphaAnimator;
  private Drawable mBackgroundDrawableTemp = null;
  public DrawableController mController;
  private URL mUrl;
  private Drawable sColorDrawable = new ColorDrawable(-1);
  private boolean startAplhaOnce = false;
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
    this.mController = new DrawableController(this.sColorDrawable, this);
    this.mAlphaAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
    this.mAlphaAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mAlphaAnimator.setDuration(FADE_DURATION);
    this.mAlphaAnimator.addListener(new ZImageView.1(this));
    this.mAlphaAnimator.addUpdateListener(new ZImageView.2(this));
  }
  
  private void resetBgDrawable()
  {
    if (this.hasSetAlphaBgDrawable)
    {
      setBackgroundDrawable(this.mBackgroundDrawableTemp);
      this.hasSetAlphaBgDrawable = false;
      if (QLog.isColorLevel()) {
        Utils.a(this.tag, "cancel alpha bg drawable !");
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
        Utils.a(this.tag, "set alpha bg drawable !");
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
  
  public void onAttachedToWindow()
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
      Utils.a(this.tag, "onAttachedToWindow, parent: " + (String)localObject);
      this.mController.b("onAttachedToWindow");
      return;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel()) {
      Utils.a(this.tag, "onDetachedFromWindow");
    }
    this.mController.a("onDetachedFromWindow");
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.mUrl != null)
    {
      if (QLog.isColorLevel()) {
        Utils.a(this.tag, "onDraw dispatch load image");
      }
      ImageRequest localImageRequest = new ImageRequest();
      RIJImageTypeOptHelper.a.a(localImageRequest, this.mUrl.toString());
      localImageRequest.jdField_a_of_type_Int = getWidth();
      localImageRequest.b = getHeight();
      this.mController.a(localImageRequest);
      this.mUrl = null;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    if (QLog.isColorLevel()) {
      Utils.a(this.tag, "onFinishTemporaryDetach");
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
      Utils.a(this.tag, "onStartTemporaryDetach, parent: " + (String)localObject);
      this.mController.a("onStartTemporaryDetach");
      return;
    }
  }
  
  public ZImageView setImage(URL paramURL)
  {
    TraceUtils.traceBegin("ZImageView.setImage");
    if (paramURL == null)
    {
      TraceUtils.traceEnd();
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
      Utils.a(this.tag, "setImage " + paramURL + " width " + getWidth() + " isAttach " + bool);
    }
    if (getWidth() > 0)
    {
      TraceUtils.traceBegin("ZImageView.newImageRequest");
      ImageRequest localImageRequest = new ImageRequest();
      RIJImageTypeOptHelper.a.a(localImageRequest, paramURL.toString());
      localImageRequest.jdField_a_of_type_Int = getWidth();
      localImageRequest.b = getHeight();
      RIJImageOptReport.a(1, localImageRequest);
      this.mController.a(localImageRequest);
      TraceUtils.traceEnd();
    }
    for (;;)
    {
      TraceUtils.traceEnd();
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
  
  public ZImageView setImageForImageCollection(ImageRequest paramImageRequest, PublicAccountImageDownListener paramPublicAccountImageDownListener)
  {
    if ((paramImageRequest == null) || (paramImageRequest.jdField_a_of_type_JavaNetURL == null)) {
      return this;
    }
    RIJImageTypeOptHelper.a.a(paramImageRequest, paramImageRequest.jdField_a_of_type_JavaNetURL.toString());
    if (paramPublicAccountImageDownListener != null) {
      this.mController.a(paramPublicAccountImageDownListener);
    }
    this.mUrl = null;
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "setImageForImageCollection url = " + paramImageRequest.jdField_a_of_type_JavaNetURL + " reqWidth = " + paramImageRequest.jdField_a_of_type_Int + " reqHeight = " + paramImageRequest.b);
    }
    this.mController.a(paramImageRequest);
    return this;
  }
  
  public ZImageView setImagePlaceHolder(Drawable paramDrawable)
  {
    this.mUrl = null;
    this.mController.a(paramDrawable);
    return this;
  }
  
  public void setPublicAccountImageDownListener(PublicAccountImageDownListener paramPublicAccountImageDownListener)
  {
    if (paramPublicAccountImageDownListener != null) {
      this.mController.a(paramPublicAccountImageDownListener);
    }
  }
  
  @Deprecated
  public void setRound(boolean paramBoolean)
  {
    this.isRound = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView
 * JD-Core Version:    0.7.0.1
 */