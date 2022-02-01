package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.SeqUtil;
import com.tencent.qphone.base.util.QLog;

class VideoInviteFloatBarUICtr$1
  extends BroadcastReceiver
{
  VideoInviteFloatBarUICtr$1(VideoInviteFloatBarUICtr paramVideoInviteFloatBarUICtr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      long l = SeqUtil.a(paramIntent);
      if (paramContext.equals("tencent.video.invite.accept"))
      {
        this.a.a(l);
        return;
      }
      if (paramContext.equals("tencent.video.invite.refuse"))
      {
        this.a.b(l);
        return;
      }
      if (paramContext.equals("tencent.video.invite.gaaccept"))
      {
        this.a.d(l);
        return;
      }
      if (paramContext.equals("tencent.video.invite.gaignore"))
      {
        this.a.c(l);
        return;
      }
      if (paramContext.equals("tencent.video.q2v.sdk.onRequestVideo"))
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive action = ");
        paramIntent.append(paramContext);
        QLog.d("VideoInviteFloatBarUICtr", 1, paramIntent.toString());
        this.a.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr.1
 * JD-Core Version:    0.7.0.1
 */