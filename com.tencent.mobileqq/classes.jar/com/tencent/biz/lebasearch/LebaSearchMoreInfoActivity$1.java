package com.tencent.biz.lebasearch;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiClient;

class LebaSearchMoreInfoActivity$1
  extends Handler
{
  LebaSearchMoreInfoActivity$1(LebaSearchMoreInfoActivity paramLebaSearchMoreInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1001) {
      return;
    }
    paramMessage = (Bundle)paramMessage.obj;
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(17, paramMessage, this.a.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity.1
 * JD-Core Version:    0.7.0.1
 */