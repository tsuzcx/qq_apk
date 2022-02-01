package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.IBitmapCallback;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class MultiVideoHelper$1
  implements IBitmapCallback
{
  MultiVideoHelper$1(BaseArticleInfo paramBaseArticleInfo, URL paramURL) {}
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, CloseableBitmap paramCloseableBitmap)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.setHasFirstFramePreload(true);
    if (QLog.isColorLevel()) {
      QLog.d(MultiVideoHelper.a, 2, "preload success width: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getFirstFrameWidth() + ", height: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getFirstFrameHeight() + ", " + this.jdField_a_of_type_JavaNetURL + ", title: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    }
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    QLog.e(MultiVideoHelper.a, 2, "preload failed " + this.jdField_a_of_type_JavaNetURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoHelper.1
 * JD-Core Version:    0.7.0.1
 */