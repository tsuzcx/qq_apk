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
    long l;
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      l = SeqUtil.a(paramIntent);
      if (!paramContext.equals("tencent.video.invite.accept")) {
        break label32;
      }
      this.a.a(l);
    }
    label32:
    do
    {
      return;
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
    } while (!paramContext.equals("tencent.video.q2v.sdk.onRequestVideo"));
    QLog.d("VideoInviteFloatBarUICtr", 1, "onReceive action = " + paramContext);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr.1
 * JD-Core Version:    0.7.0.1
 */