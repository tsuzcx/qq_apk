package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class VideoInviteActivity$MyBroadCastReceiver
  extends BroadcastReceiver
{
  VideoInviteActivity$MyBroadCastReceiver(VideoInviteActivity paramVideoInviteActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      String str2 = this.a.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive action = ");
      localStringBuilder.append(str1);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    if ("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO".equals(str1))
    {
      this.a.m();
      return;
    }
    if ("tencent.video.q2v.sdk.onRequestVideo".equals(str1))
    {
      paramContext = this.a.a;
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive action = ");
      paramIntent.append(str1);
      QLog.d(paramContext, 1, paramIntent.toString());
      this.a.p();
      return;
    }
    if ("android.intent.action.USER_PRESENT".equals(str1))
    {
      this.a.a("ACTION_USER_PRESENT");
      return;
    }
    if (this.a.W != null) {
      this.a.W.a(paramContext, str1, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.MyBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */