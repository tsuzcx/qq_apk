package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.graphics.drawable.Drawable;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import com.tencent.qphone.base.util.QLog;

public class DrawableController
  implements IBitmapCallback
{
  static int jdField_a_of_type_Int;
  static int b;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  CloseableBitmap jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap;
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
    jdField_a_of_type_Int += 1;
    a("resetUrl");
    CloseableBitmap localCloseableBitmap = ImageManager.a().a(paramImageRequest);
    if (localCloseableBitmap == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest = paramImageRequest;
      ImageManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest, this);
      return;
    }
    b += 1;
    a(paramImageRequest, localCloseableBitmap, false, "setImageRequest");
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap = paramCloseableBitmap;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.a()) {}
    for (paramString = new ZBitmapDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.b);; paramString = new ZBitmapDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramString);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener != null) {
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener.a(paramImageRequest.jdField_a_of_type_JavaNetURL, paramCloseableBitmap);
      }
      return;
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof ZBitmapDrawable))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest != null)
    {
      ImageManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest, "reset");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest = null;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      Utils.a(this.jdField_a_of_type_JavaLangString, "attachToWindow " + paramString + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.DrawableController
 * JD-Core Version:    0.7.0.1
 */