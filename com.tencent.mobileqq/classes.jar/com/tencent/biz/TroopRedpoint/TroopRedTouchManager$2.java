package com.tencent.biz.TroopRedpoint;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.qphone.base.util.QLog;

class TroopRedTouchManager$2
  implements Runnable
{
  TroopRedTouchManager$2(TroopRedTouchManager paramTroopRedTouchManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.this$0.a = MsgBoxListActivity.getNearbyMsgBoxUnReadNum(this.a, AppConstants.NEARBY_LBS_HELLO_UIN, true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("asyn nearbyMsgBoxUnReadNum=");
      localStringBuilder.append(this.this$0.a);
      QLog.d("nearby.redpoint", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager.2
 * JD-Core Version:    0.7.0.1
 */