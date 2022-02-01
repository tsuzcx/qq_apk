package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class GAudioMembersCtrlActivity$VideoMsgReceiver
  extends BroadcastReceiver
{
  GAudioMembersCtrlActivity$VideoMsgReceiver(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((!TextUtils.isEmpty(paramIntent.getPackage())) && (paramIntent.getPackage().equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName())))
    {
      if (paramContext.equals("tencent.av.v2q.StopVideoChat"))
      {
        int i = paramIntent.getIntExtra("stopReason3rd", -1);
        long l = paramIntent.getLongExtra("groupId", -1L);
        if ((i == 1) && (this.a.jdField_a_of_type_Long == l))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GAudioMembersCtrlActivity", 2, "ACTION_STOP_VIDEO_CHAT");
          }
          this.a.finish();
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receive broadcast from wrong package:");
      localStringBuilder.append(paramIntent.getPackage());
      localStringBuilder.append(",action:");
      localStringBuilder.append(paramContext);
      QLog.d("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.VideoMsgReceiver
 * JD-Core Version:    0.7.0.1
 */