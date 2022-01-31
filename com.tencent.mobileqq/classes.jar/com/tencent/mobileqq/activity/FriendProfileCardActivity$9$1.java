package com.tencent.mobileqq.activity;

import aloz;
import awmk;
import azmj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$9$1
  implements Runnable
{
  FriendProfileCardActivity$9$1(FriendProfileCardActivity.9 param9) {}
  
  public void run()
  {
    Object localObject = (aloz)this.a.this$0.app.getManager(51);
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((aloz)localObject).e(this.a.this$0.a.a.a);
    } while ((localObject == null) || ((((Friends)localObject).abilityBits & 0x2) == 0L));
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "mReportPCCameraAblibityRunnable-->report");
    }
    azmj.b(null, "CliOper", "", "", "0X8004991", "0X8004991", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.9.1
 * JD-Core Version:    0.7.0.1
 */