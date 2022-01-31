package com.tencent.biz.TroopRedpoint;

import aljq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.qphone.base.util.QLog;
import nan;

public class TroopRedTouchManager$2
  implements Runnable
{
  public TroopRedTouchManager$2(nan paramnan, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.this$0.a = MsgBoxListActivity.a(this.a, aljq.I, true);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.redpoint", 2, "asyn nearbyMsgBoxUnReadNum=" + this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager.2
 * JD-Core Version:    0.7.0.1
 */