package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class OnTopicRecommendHeaderFollowClickListener$3
  implements UserOperationModule.Ox978RespCallBack
{
  OnTopicRecommendHeaderFollowClickListener$3(OnTopicRecommendHeaderFollowClickListener paramOnTopicRecommendHeaderFollowClickListener, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnTopicRecommendHeaderFollowClickListener", 2, "取消关注 handleResp request businessID = " + OnTopicRecommendHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnTopicRecommendHeaderFollowClickListener).a + " requestFollowType = " + this.jdField_a_of_type_Boolean + " isSuccess = " + paramBoolean + " distUin = " + paramString + " data = " + paramInt);
    }
    int i = OnTopicRecommendHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnTopicRecommendHeaderFollowClickListener).a;
    if ((paramBoolean) && (paramInt == 2) && (String.valueOf(i).equals(paramString))) {
      ThreadManager.post(new OnTopicRecommendHeaderFollowClickListener.3.1(this), 5, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("OnTopicRecommendHeaderFollowClickListener", 2, "取消关注失败 isSuccess =" + paramBoolean + " distUin = " + paramString + " data = " + paramInt + " isfollow " + this.jdField_a_of_type_Boolean + " businessId = " + OnTopicRecommendHeaderFollowClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnTopicRecommendHeaderFollowClickListener).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderFollowClickListener.3
 * JD-Core Version:    0.7.0.1
 */