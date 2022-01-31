package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class ZImageView
  extends ImageView
{
  static int jdField_a_of_type_Int = 300;
  static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-1);
  long jdField_a_of_type_Long = 0L;
  private DrawableController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderDrawableController;
  private String jdField_a_of_type_JavaLangString = "zimage.ZImageView.v" + hashCode();
  private URL jdField_a_of_type_JavaNetURL;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c = true;
  private boolean d;
  
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderDrawableController = new DrawableController(jdField_a_of_type_AndroidGraphicsDrawableDrawable, this);
  }
  
  public ZImageView a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaNetURL = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderDrawableController.a(paramDrawable);
    return this;
  }
  
  public ZImageView a(ImageRequest paramImageRequest, PublicAccountImageDownListener paramPublicAccountImageDownListener)
  {
    if ((paramImageRequest == null) || (paramImageRequest.jdField_a_of_type_JavaNetURL == null)) {
      return this;
    }
    if (paramPublicAccountImageDownListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderDrawableController.a(paramPublicAccountImageDownListener);
    }
    this.jdField_a_of_type_JavaNetURL = null;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setImageForImageCollection url = " + paramImageRequest.jdField_a_of_type_JavaNetURL + " reqWidth = " + paramImageRequest.jdField_a_of_type_Int + " reqHeight = " + paramImageRequest.b);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderDrawableController.a(paramImageRequest);
    return this;
  }
  
  public ZImageView a(URL paramURL)
  {
    if (paramURL == null) {
      return this;
    }
    this.jdField_a_of_type_JavaNetURL = null;
    if (QLog.isColorLevel()) {
      Utils.a(this.jdField_a_of_type_JavaLangString, "setImage " + paramURL);
    }
    if (getWidth() > 0)
    {
      ImageRequest localImageRequest = new ImageRequest();
      localImageRequest.jdField_a_of_type_JavaNetURL = paramURL;
      localImageRequest.jdField_a_of_type_Int = getWidth();
      localImageRequest.b = getHeight();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderDrawableController.a(localImageRequest);
      return this;
    }
    this.jdField_a_of_type_JavaNetURL = paramURL;
    return this;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (QLog.isColorLevel()) {
      Utils.a(this.jdField_a_of_type_JavaLangString, "onAttachedToWindow");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderDrawableController.b("onAttachedToWindow");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel()) {
      Utils.a(this.jdField_a_of_type_JavaLangString, "onDetachedFromWindow");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderDrawableController.a("onDetachedFromWindow");
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_JavaNetURL != null)
    {
      if (QLog.isColorLevel()) {
        Utils.a(this.jdField_a_of_type_JavaLangString, "onDraw dispatch load image");
      }
      ImageRequest localImageRequest = new ImageRequest();
      localImageRequest.jdField_a_of_type_JavaNetURL = this.jdField_a_of_type_JavaNetURL;
      localImageRequest.jdField_a_of_type_Int = getWidth();
      localImageRequest.b = getHeight();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderDrawableController.a(localImageRequest);
      this.jdField_a_of_type_JavaNetURL = null;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.b = true;
        this.c = false;
      }
      float f = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / jdField_a_of_type_Int;
      if ((f < 0.0F) || (f > 1.0F)) {
        break label173;
      }
      int i = (int)(f * 255.0F);
      getDrawable().mutate().setAlpha(i);
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      if ((this.b) && (!this.c)) {
        invalidate();
      }
      return;
      label173:
      getDrawable().mutate().setAlpha(255);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = 0L;
      this.b = false;
      this.c = true;
    }
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    if (QLog.isColorLevel()) {
      Utils.a(this.jdField_a_of_type_JavaLangString, "onFinishTemporaryDetach");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderDrawableController.b("onFinishTemporaryDetach");
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (QLog.isColorLevel()) {
      Utils.a(this.jdField_a_of_type_JavaLangString, "onStartTemporaryDetach");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderDrawableController.a("onStartTemporaryDetach");
  }
  
  public void setPublicAccountImageDownListener(PublicAccountImageDownListener paramPublicAccountImageDownListener)
  {
    if (paramPublicAccountImageDownListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderDrawableController.a(paramPublicAccountImageDownListener);
    }
  }
  
  public void setRound(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView
 * JD-Core Version:    0.7.0.1
 */