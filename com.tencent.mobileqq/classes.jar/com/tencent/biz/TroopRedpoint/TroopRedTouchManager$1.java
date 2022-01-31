package com.tencent.biz.TroopRedpoint;

import ajsd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.qphone.base.util.QLog;
import mxu;

public class TroopRedTouchManager$1
  implements Runnable
{
  public TroopRedTouchManager$1(mxu parammxu, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.this$0.a = MsgBoxListActivity.a(this.a, ajsd.I);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.redpoint", 2, "asyn nearbyMsgBoxUnReadNum=" + this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager.1
 * JD-Core Version:    0.7.0.1
 */