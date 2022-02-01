package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptConfig;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptMonitor;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptReport;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;

public class DrawableController
  implements IBitmapCallback
{
  static int jdField_a_of_type_Int = 0;
  static int b = 0;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public CloseableBitmap a;
  ImageRequest jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest;
  ZImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView;
  PublicAccountImageDownListener jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener;
  private String jdField_a_of_type_JavaLangString = "zimage.DrawableController";
  private boolean jdField_a_of_type_Boolean = true;
  
  public DrawableController(Drawable paramDrawable, ZImageView paramZImageView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = paramZImageView;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + ".v" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.hashCode());
  }
  
  private void a(CloseableBitmap paramCloseableBitmap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap = paramCloseableBitmap;
    paramCloseableBitmap = new ZBitmapDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramCloseableBitmap, paramBoolean);
  }
  
  private boolean a(CloseableBitmap paramCloseableBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap != null) && (paramCloseableBitmap != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap.a() == paramCloseableBitmap.a())) {
      return (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof BitmapDrawable)) || (((BitmapDrawable)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable()).getBitmap() != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap.a());
    }
    return true;
  }
  
  public ImageRequest a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest != null) {
      a("setPlaceHolder");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(ImageRequest paramImageRequest)
  {
    TraceUtils.traceBegin("DrawableController.setImageRequest");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.isRound()) {
      paramImageRequest.c = 1;
    }
    jdField_a_of_type_Int += 1;
    a("resetUrl");
    CloseableBitmap localCloseableBitmap = ImageManager.a().a(paramImageRequest);
    if (localCloseableBitmap == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest = paramImageRequest;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      RIJImageOptMonitor.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest);
      ImageManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest, this);
    }
    for (;;)
    {
      TraceUtils.traceEnd();
      return;
      b += 1;
      RIJImageOptReport.b(1, paramImageRequest);
      a(paramImageRequest, localCloseableBitmap, false, "setImageRequest");
    }
  }
  
  public void a(ImageRequest paramImageRequest, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener != null) {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener.a(paramImageRequest.jdField_a_of_type_JavaNetURL, paramInt);
    }
  }
  
  public void a(ImageRequest paramImageRequest, CloseableBitmap paramCloseableBitmap)
  {
    if ((paramImageRequest.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest)) && (paramCloseableBitmap.a() != null))
    {
      a(paramImageRequest, paramCloseableBitmap, true, "onSuccess");
      return;
    }
    paramCloseableBitmap.a();
  }
  
  void a(ImageRequest paramImageRequest, CloseableBitmap paramCloseableBitmap, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest = paramImageRequest;
    if (QLog.isColorLevel()) {
      Utils.a(this.jdField_a_of_type_JavaLangString, "attachImage " + paramString + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest + " " + paramCloseableBitmap + " total:" + jdField_a_of_type_Int + " cache:" + b);
    }
    if ((!a()) || (a(paramCloseableBitmap))) {
      a(paramCloseableBitmap, paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.e = 0;
      RIJImageOptReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest, true, "attached");
    }
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener != null) {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener.a(paramImageRequest.jdField_a_of_type_JavaNetURL, paramCloseableBitmap);
    }
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener != null) {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener.a(paramImageRequest.jdField_a_of_type_JavaNetURL, paramThrowable);
    }
  }
  
  public void a(PublicAccountImageDownListener paramPublicAccountImageDownListener)
  {
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener = paramPublicAccountImageDownListener;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      Utils.a(this.jdField_a_of_type_JavaLangString, "detachFromWindow " + paramString + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap);
    }
    if (!a())
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof ZBitmapDrawable))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap = null;
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest != null)
    {
      ImageManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest, "reset");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a()
  {
    return (RIJImageOptConfig.a.e()) && (Utils.a());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      Utils.a(this.jdField_a_of_type_JavaLangString, "attachToWindow " + paramString + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.DrawableController
 * JD-Core Version:    0.7.0.1
 */