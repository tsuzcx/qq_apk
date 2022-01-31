package com.tencent.mobileqq.activity.aio.helper;

import afgi;
import amdu;
import bcpx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.QLog;

public class TroopAddFriendTipsHelper$1
  implements Runnable
{
  public TroopAddFriendTipsHelper$1(afgi paramafgi, String paramString) {}
  
  public void run()
  {
    amdu localamdu = (amdu)afgi.a(this.this$0).a(20);
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = localamdu.a();
    localTroopBatchAddFriendMgr.c(this.a);
    localTroopBatchAddFriendMgr.a(this.a, null, 1);
    localTroopBatchAddFriendMgr.f(this.a);
    long l1 = bcpx.a(afgi.a(this.this$0), this.a);
    if (l1 <= 0L) {
      bcpx.a(afgi.a(this.this$0), this.a, 5L);
    }
    long l2;
    do
    {
      return;
      l2 = NetConnInfoCenter.getServerTime() - l1;
      if (l2 > 0L) {
        localamdu.c(this.a, 1, 0);
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopAddFriendTipsHelper", 2, "check recommend gray time " + l2 + " " + l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.1
 * JD-Core Version:    0.7.0.1
 */