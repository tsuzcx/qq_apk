package com.tencent.av.app;

import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class GAudioMessageMonitor
{
  public static String a = "GAudioMsgReceiver";
  VideoAppInterface b;
  GAudioMessageMonitor.GAudioMsgReceiver c;
  boolean d = false;
  
  public GAudioMessageMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.b = paramVideoAppInterface;
    this.c = new GAudioMessageMonitor.GAudioMsgReceiver(paramVideoAppInterface);
  }
  
  public void a()
  {
    if (this.d)
    {
      this.b.getApplication().unregisterReceiver(this.c);
      this.d = false;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "regist QQGAudioMsg Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.MultiVideo");
    localIntentFilter.addAction("tencent.video.q2v.AddDiscussMember");
    localIntentFilter.addAction("tencent.video.q2v.SwitchToMultiAudo");
    localIntentFilter.addAction("tencent.video.q2v.GroupSystemMsg");
    localIntentFilter.addAction("tencent.video.q2v.SelectMember");
    localIntentFilter.addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    localIntentFilter.addAction("tencent.video.q2v.GvideoGift");
    localIntentFilter.addAction("tencent.video.q2v.GvideoLevelUpgrade");
    localIntentFilter.addAction("tencent.video.q2v.GvideoMemUntInvite");
    localIntentFilter.addAction("tencent.video.q2v.close_invite_msg_box_by_invite_id");
    localIntentFilter.addAction("tencent.video.q2v.randomMultiOwnerOnlinePush");
    localIntentFilter.addAction("tencent.video.q2v.random1V1OnlinePush");
    localIntentFilter.addAction("tencent.video.q2v.avreportOnlinePush");
    localIntentFilter.addAction("tencent.video.q2v.AudioTransPush");
    localIntentFilter.addAction("tencent.video.q2v.AudioEngineReady");
    localIntentFilter.addAction("tencent.video.q2v.GroupInfoChanged");
    if (this.b.getApplication().registerReceiver(this.c, localIntentFilter) != null) {
      this.d = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GAudioMessageMonitor
 * JD-Core Version:    0.7.0.1
 */