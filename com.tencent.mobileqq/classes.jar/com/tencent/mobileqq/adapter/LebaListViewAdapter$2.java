package com.tencent.mobileqq.adapter;

import aiba;
import arjg;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class LebaListViewAdapter$2
  implements Runnable
{
  public LebaListViewAdapter$2(aiba paramaiba, RedTouch paramRedTouch, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = arjg.a(this.this$0.a);
    if (QLog.isColorLevel()) {
      QLog.d("LebaListViewAdapter", 2, "updateExtendFriendRedTouch() : " + i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      ThreadManager.getUIHandler().post(new LebaListViewAdapter.2.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.LebaListViewAdapter.2
 * JD-Core Version:    0.7.0.1
 */