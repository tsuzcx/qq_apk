package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import bhxr;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import pdz;
import sfd;
import sfg;
import sfm;
import sfo;
import sfp;
import tpv;

public class ZImageView
  extends ImageView
{
  static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-1);
  static int e = 300;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private String jdField_a_of_type_JavaLangString = "zimage.ZImageView.v" + hashCode();
  private URL jdField_a_of_type_JavaNetURL;
  protected sfd a;
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
    this.jdField_a_of_type_Sfd = new sfd(jdField_a_of_type_AndroidGraphicsDrawableDrawable, this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(e);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new sfo(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new sfp(this));
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Sfd.jdField_a_of_type_AndroidGraphicsDrawableDrawable != jdField_a_of_type_AndroidGraphicsDrawableDrawable))
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getBackground();
      setBackgroundDrawable(this.jdField_a_of_type_Sfd.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        sfm.a(this.jdField_a_of_type_JavaLangString, "set alpha bg drawable !");
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
        sfm.a(this.jdField_a_of_type_JavaLangString, "cancel alpha bg drawable !");
      }
    }
  }
  
  public ZImageView a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaNetURL = null;
    this.jdField_a_of_type_Sfd.a(paramDrawable);
    return this;
  }
  
  public ZImageView a(URL paramURL)
  {
    bhxr.a("ZImageView.setImage");
    if (paramURL == null)
    {
      bhxr.a();
      return this;
    }
    if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.getPath().equals(paramURL.getPath()))) {
      QLog.d("ZImageView", 2, "setImage | same");
    }
    this.jdField_a_of_type_JavaNetURL = null;
    if (QLog.isColorLevel()) {
      sfm.a(this.jdField_a_of_type_JavaLangString, "setImage " + paramURL);
    }
    if (getWidth() > 0)
    {
      bhxr.a("ZImageView.newImageRequest");
      sfg localsfg = new sfg();
      localsfg.jdField_a_of_type_JavaNetURL = paramURL;
      localsfg.jdField_a_of_type_Int = getWidth();
      localsfg.b = getHeight();
      pdz.a(1, localsfg);
      this.jdField_a_of_type_Sfd.a(localsfg);
      bhxr.a();
    }
    for (;;)
    {
      bhxr.a();
      return this;
      this.jdField_a_of_type_JavaNetURL = paramURL;
    }
  }
  
  public ZImageView a(sfg paramsfg, tpv paramtpv)
  {
    if ((paramsfg == null) || (paramsfg.jdField_a_of_type_JavaNetURL == null)) {
      return this;
    }
    if (paramtpv != null) {
      this.jdField_a_of_type_Sfd.a(paramtpv);
    }
    this.jdField_a_of_type_JavaNetURL = null;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setImageForImageCollection url = " + paramsfg.jdField_a_of_type_JavaNetURL + " reqWidth = " + paramsfg.jdField_a_of_type_Int + " reqHeight = " + paramsfg.b);
    }
    this.jdField_a_of_type_Sfd.a(paramsfg);
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
      sfm.a(this.jdField_a_of_type_JavaLangString, "onAttachedToWindow, parent: " + (String)localObject);
      this.jdField_a_of_type_Sfd.b("onAttachedToWindow");
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel()) {
      sfm.a(this.jdField_a_of_type_JavaLangString, "onDetachedFromWindow");
    }
    this.jdField_a_of_type_Sfd.a("onDetachedFromWindow");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_JavaNetURL != null)
    {
      if (QLog.isColorLevel()) {
        sfm.a(this.jdField_a_of_type_JavaLangString, "onDraw dispatch load image");
      }
      sfg localsfg = new sfg();
      localsfg.jdField_a_of_type_JavaNetURL = this.jdField_a_of_type_JavaNetURL;
      localsfg.jdField_a_of_type_Int = getWidth();
      localsfg.b = getHeight();
      this.jdField_a_of_type_Sfd.a(localsfg);
      this.jdField_a_of_type_JavaNetURL = null;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    if (QLog.isColorLevel()) {
      sfm.a(this.jdField_a_of_type_JavaLangString, "onFinishTemporaryDetach");
    }
    this.jdField_a_of_type_Sfd.b("onFinishTemporaryDetach");
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
      sfm.a(this.jdField_a_of_type_JavaLangString, "onStartTemporaryDetach, parent: " + (String)localObject);
      this.jdField_a_of_type_Sfd.a("onStartTemporaryDetach");
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
  
  public void setPublicAccountImageDownListener(tpv paramtpv)
  {
    if (paramtpv != null) {
      this.jdField_a_of_type_Sfd.a(paramtpv);
    }
  }
  
  @Deprecated
  public void setRound(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView
 * JD-Core Version:    0.7.0.1
 */