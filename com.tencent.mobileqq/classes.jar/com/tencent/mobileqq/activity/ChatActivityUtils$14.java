package com.tencent.mobileqq.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.AVLoadingDialogActivity;
import com.tencent.av.utils.GVideoUpdateUtil.OnGVideoUpdateListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.api.IGroupVideoHelper;
import mqq.os.MqqHandler;

final class ChatActivityUtils$14
  implements GVideoUpdateUtil.OnGVideoUpdateListener
{
  ChatActivityUtils$14(int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, QCallFacade paramQCallFacade, long paramLong1, Intent paramIntent, long paramLong2, String paramString) {}
  
  public void a(Context paramContext, String paramString)
  {
    int i = this.a;
    paramString = null;
    if ((i == 0) && (this.b == 3000)) {
      ThreadManager.post(new ChatActivityUtils.14.1(this), 5, null, true);
    }
    i = this.f.getIntExtra("MultiAVType", 0);
    String str;
    if (i != 2)
    {
      paramString = this.f.getComponent().getClassName();
      str = paramContext.getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createOrEnterGroupAudio, className[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], contextName[");
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      QLog.w("ChatActivityUtils", 1, localStringBuilder.toString());
    }
    else
    {
      str = null;
    }
    if (i == 2)
    {
      if (this.c.getAVNotifyCenter().a(1, this.g))
      {
        paramContext = new Intent("tencent.video.q2v.back2VideoRoom");
        this.c.getApp().sendBroadcast(paramContext);
      }
      else
      {
        ((IGroupVideoHelper)QRoute.api(IGroupVideoHelper.class)).enterTroopVideoByPlugin(this.c, paramContext, this.f, 1);
      }
    }
    else if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("com.tencent.av.ui.AVActivity")) && (((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.mobileqq.qcall.QCallDetailActivity"))) || (str.equals("com.tencent.mobileqq.activity.selectmember.SelectMemberActivity")) || (str.equals("com.tencent.mobileqq.activity.SplashActivity")) || (str.equals("com.tencent.mobileqq.activity.recent.RecentT9SearchActivity"))))
    {
      paramString = new Intent(paramContext, AVLoadingDialogActivity.class);
      paramString.putExtra("avactivity_intent", this.f);
      paramString.addFlags(268435456);
      QQAudioHelper.b("发起音视频_start_AVLoadingDialogActivity");
      paramContext.startActivity(paramString);
    }
    else
    {
      QQAudioHelper.b("发起音视频_start_AVActivity");
      paramContext.startActivity(this.f);
    }
    if (this.a == 0) {
      ThreadManager.getFileThreadHandler().post(new ChatActivityUtils.14.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.14
 * JD-Core Version:    0.7.0.1
 */