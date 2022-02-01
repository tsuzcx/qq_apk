package com.tencent.biz.pubaccount.weishi_new.recommend.presenter;

import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.IWeiShiCacheCallback;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class AbsWSGridPagePresenter$1
  implements IWeiShiCacheCallback
{
  AbsWSGridPagePresenter$1(AbsWSGridPagePresenter paramAbsWSGridPagePresenter, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(JceStruct paramJceStruct)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[AbsWSGridPagePresenter.java][onReadCacheCompleted] mSubTabId:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendPresenterAbsWSGridPagePresenter.c);
    WSLog.d("AbsWSGridPagePresenterLog", localStringBuilder.toString());
    AbsWSGridPagePresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendPresenterAbsWSGridPagePresenter, paramJceStruct, this.jdField_a_of_type_Boolean, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.presenter.AbsWSGridPagePresenter.1
 * JD-Core Version:    0.7.0.1
 */