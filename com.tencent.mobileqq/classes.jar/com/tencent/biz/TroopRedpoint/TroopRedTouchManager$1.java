package com.tencent.biz.TroopRedpoint;

import ajsf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.qphone.base.util.QLog;
import mxx;

public class TroopRedTouchManager$1
  implements Runnable
{
  public TroopRedTouchManager$1(mxx parammxx, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.this$0.a = MsgBoxListActivity.a(this.a, ajsf.I);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.redpoint", 2, "asyn nearbyMsgBoxUnReadNum=" + this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager.1
 * JD-Core Version:    0.7.0.1
 */