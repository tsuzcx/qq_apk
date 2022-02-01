package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class OnSocialHeaderFollowClickListener$3
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  OnSocialHeaderFollowClickListener$3(OnSocialHeaderFollowClickListener paramOnSocialHeaderFollowClickListener, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnSocialHeaderFollowClickListener, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "", false);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    OnSocialHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnSocialHeaderFollowClickListener, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramReadInJoyUserInfo.faceUrl + "140", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.3
 * JD-Core Version:    0.7.0.1
 */