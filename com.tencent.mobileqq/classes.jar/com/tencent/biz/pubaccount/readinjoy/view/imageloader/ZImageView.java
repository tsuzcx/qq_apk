package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import bfwu;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import rpe;
import rph;
import rpn;
import rpp;
import rpq;
import spa;

public class ZImageView
  extends ImageView
{
  static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-1);
  static int e = 300;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private String jdField_a_of_type_JavaLangString = "zimage.ZImageView.v" + hashCode();
  private URL jdField_a_of_type_JavaNetURL;
  protected rpe a;
  private boolean jdField_a_of_type_Boolean;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean;
  
  public ZImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ZImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ZImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Rpe = new rpe(jdField_a_of_type_AndroidGraphicsDrawableDrawable, this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(e);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new rpp(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new rpq(this));
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Rpe.jdField_a_of_type_AndroidGraphicsDrawableDrawable != jdField_a_of_type_AndroidGraphicsDrawableDrawable))
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getBackground();
      setBackgroundDrawable(this.jdField_a_of_type_Rpe.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        rpn.a(this.jdField_a_of_type_JavaLangString, "set alpha bg drawable !");
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_b_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        rpn.a(this.jdField_a_of_type_JavaLangString, "cancel alpha bg drawable !");
      }
    }
  }
  
  public ZImageView a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaNetURL = null;
    this.jdField_a_of_type_Rpe.a(paramDrawable);
    return this;
  }
  
  public ZImageView a(URL paramURL)
  {
    bfwu.a("ZImageView.setImage");
    if (paramURL == null)
    {
      bfwu.a();
      return this;
    }
    if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.getPath().equals(paramURL.getPath()))) {
      QLog.d("ZImageView", 2, "setImage | same");
    }
    this.jdField_a_of_type_JavaNetURL = null;
    if (QLog.isColorLevel()) {
      rpn.a(this.jdField_a_of_type_JavaLangString, "setImage " + paramURL);
    }
    if (getWidth() > 0)
    {
      bfwu.a("ZImageView.newImageRequest");
      rph localrph = new rph();
      localrph.jdField_a_of_type_JavaNetURL = paramURL;
      localrph.jdField_a_of_type_Int = getWidth();
      localrph.b = getHeight();
      this.jdField_a_of_type_Rpe.a(localrph);
      bfwu.a();
    }
    for (;;)
    {
      bfwu.a();
      return this;
      this.jdField_a_of_type_JavaNetURL = paramURL;
    }
  }
  
  public ZImageView a(rph paramrph, spa paramspa)
  {
    if ((paramrph == null) || (paramrph.jdField_a_of_type_JavaNetURL == null)) {
      return this;
    }
    if (paramspa != null) {
      this.jdField_a_of_type_Rpe.a(paramspa);
    }
    this.jdField_a_of_type_JavaNetURL = null;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setImageForImageCollection url = " + paramrph.jdField_a_of_type_JavaNetURL + " reqWidth = " + paramrph.jdField_a_of_type_Int + " reqHeight = " + paramrph.b);
    }
    this.jdField_a_of_type_Rpe.a(paramrph);
    return this;
  }
  
  @Deprecated
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
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
      rpn.a(this.jdField_a_of_type_JavaLangString, "onAttachedToWindow, parent: " + (String)localObject);
      this.jdField_a_of_type_Rpe.b("onAttachedToWindow");
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel()) {
      rpn.a(this.jdField_a_of_type_JavaLangString, "onDetachedFromWindow");
    }
    this.jdField_a_of_type_Rpe.a("onDetachedFromWindow");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_JavaNetURL != null)
    {
      if (QLog.isColorLevel()) {
        rpn.a(this.jdField_a_of_type_JavaLangString, "onDraw dispatch load image");
      }
      rph localrph = new rph();
      localrph.jdField_a_of_type_JavaNetURL = this.jdField_a_of_type_JavaNetURL;
      localrph.jdField_a_of_type_Int = getWidth();
      localrph.b = getHeight();
      this.jdField_a_of_type_Rpe.a(localrph);
      this.jdField_a_of_type_JavaNetURL = null;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    if (QLog.isColorLevel()) {
      rpn.a(this.jdField_a_of_type_JavaLangString, "onFinishTemporaryDetach");
    }
    this.jdField_a_of_type_Rpe.b("onFinishTemporaryDetach");
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
      rpn.a(this.jdField_a_of_type_JavaLangString, "onStartTemporaryDetach, parent: " + (String)localObject);
      this.jdField_a_of_type_Rpe.a("onStartTemporaryDetach");
      return;
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      b();
      setImageDrawable(paramDrawable);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
    setImageDrawable(paramDrawable);
  }
  
  public void setPublicAccountImageDownListener(spa paramspa)
  {
    if (paramspa != null) {
      this.jdField_a_of_type_Rpe.a(paramspa);
    }
  }
  
  @Deprecated
  public void setRound(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView
 * JD-Core Version:    0.7.0.1
 */