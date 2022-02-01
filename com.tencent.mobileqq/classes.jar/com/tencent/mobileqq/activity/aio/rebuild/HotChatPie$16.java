package com.tencent.mobileqq.activity.aio.rebuild;

import ahgz;
import amtp;
import bequ;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

public class HotChatPie$16
  implements Runnable
{
  public HotChatPie$16(ahgz paramahgz, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (ahgz.e(this.this$0) == null) {
      ahgz.b(this.this$0, new bequ(this.this$0.app, this.this$0.mActivity, this.this$0.sessionInfo, ahgz.b(this.this$0), ahgz.b(this.this$0), this.this$0.mTroopTips, ahgz.b(this.this$0), null));
    }
    amtp localamtp = (amtp)this.this$0.app.getBusinessHandler(35);
    if (this.a.userCreate == 1) {
      localamtp.a(this.a.troopUin);
    }
    while (this.a.uuid == null) {
      return;
    }
    localamtp.a(this.a.uuid.getBytes(), this.a.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16
 * JD-Core Version:    0.7.0.1
 */