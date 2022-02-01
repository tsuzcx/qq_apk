package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyDoubleImageView$1
  implements URLDrawable.URLDrawableListener
{
  ReadInjoyDoubleImageView$1(ReadInjoyDoubleImageView paramReadInjoyDoubleImageView, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadCanceled:");
      paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ReadInjoyDoubleImageView", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadFialed:");
      paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ReadInjoyDoubleImageView", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyDoubleImageView", 2, "onLoadProgressed");
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLoadSuccessed:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ReadInjoyDoubleImageView", 2, localStringBuilder.toString());
    }
    if (paramURLDrawable != null)
    {
      ReadInjoyDoubleImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyDoubleImageView, new ReadInjoyAdSuperBgDrawable(paramURLDrawable.getCurrDrawable(), ReadInjoyDoubleImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyDoubleImageView), ReadInjoyDoubleImageView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyDoubleImageView) - (ReadInjoyDoubleImageView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyDoubleImageView) + ReadInjoyDoubleImageView.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyDoubleImageView))));
      ReadInjoyDoubleImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyDoubleImageView).setImageDrawable(ReadInjoyDoubleImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyDoubleImageView));
      ReadInjoyDoubleImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyDoubleImageView, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyDoubleImageView.1
 * JD-Core Version:    0.7.0.1
 */