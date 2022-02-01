package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.qphone.base.util.QLog;

class DynamicAvatarRecordActivity$1
  extends BroadcastReceiver
{
  DynamicAvatarRecordActivity$1(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicAvatarRecordActivity", 2, "receive ACTION_START_VIDEO_CHAT.");
      }
      paramContext = BaseActivity2.a(this.a.l, 2131433436);
      if (paramContext != null) {
        this.a.l.removeView(paramContext);
      }
      if ((this.a.e != null) && (this.a.e.p != null)) {
        this.a.e.p.g();
      }
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.1
 * JD-Core Version:    0.7.0.1
 */