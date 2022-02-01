package com.tencent.biz.pubaccount.readinjoy.biu;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ReadInJoyDeliverBiuActivity$13
  extends FriendListObserver
{
  ReadInJoyDeliverBiuActivity$13(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "current uin = " + paramString + " is success " + paramBoolean);
    }
    if (paramBoolean) {
      ThreadManager.getUIHandler().post(new ReadInJoyDeliverBiuActivity.13.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity.13
 * JD-Core Version:    0.7.0.1
 */