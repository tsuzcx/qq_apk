package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class OnSocialHeaderFollowClickListener$2
  implements UserOperationModule.Ox978RespCallBack
{
  OnSocialHeaderFollowClickListener$2(OnSocialHeaderFollowClickListener paramOnSocialHeaderFollowClickListener, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("OnSocialHeaderFollowClickListener", 1, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    if (paramBoolean)
    {
      if ((OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnSocialHeaderFollowClickListener) != null) && (OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnSocialHeaderFollowClickListener).mSocialFeedInfo != null))
      {
        OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnSocialHeaderFollowClickListener).mSocialFeedInfo.h = paramInt;
        ReadInJoyLogicEngine.a().c(OnSocialHeaderFollowClickListener.a(OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnSocialHeaderFollowClickListener)), paramInt);
        if (this.jdField_a_of_type_Boolean) {
          OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnSocialHeaderFollowClickListener);
        }
        ThreadManager.getUIHandler().post(new OnSocialHeaderFollowClickListener.2.1(this));
      }
      return;
    }
    QQToast.a(OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnSocialHeaderFollowClickListener), HardCodeUtil.a(2131707823), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.2
 * JD-Core Version:    0.7.0.1
 */