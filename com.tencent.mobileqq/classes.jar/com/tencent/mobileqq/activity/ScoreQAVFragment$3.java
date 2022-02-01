package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoConstants;
import com.tencent.av.utils.ScoreManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ScoreReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ScoreQAVFragment$3
  implements View.OnClickListener
{
  ScoreQAVFragment$3(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    long l1;
    if ((this.a.n != null) && (!this.a.n.isEmpty())) {
      l1 = ScoreManager.b(this.a.n);
    } else {
      l1 = 0L;
    }
    SharedPreferences localSharedPreferences = SharedPreUtils.e(this.a.p);
    long l2 = localSharedPreferences.getLong("qav_roomid", 0L);
    long l3 = localSharedPreferences.getLong(VideoConstants.o, 0L);
    ScoreReportController.a(this.a.q, this.a.h, this.a.i, this.a.j, this.a.k, this.a.l, this.a.m, l3, l1, l2, this.a.o, this.a.f);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportEvent beginTime: ");
      localStringBuilder.append(this.a.h);
      localStringBuilder.append(", endTime: ");
      localStringBuilder.append(this.a.i);
      localStringBuilder.append(", sdkVersion: ");
      localStringBuilder.append(this.a.m);
      localStringBuilder.append(", peerSdkVersion: ");
      localStringBuilder.append(l3);
      localStringBuilder.append(", bussinessType: ");
      localStringBuilder.append(this.a.j);
      localStringBuilder.append(", bussinessFlag: ");
      localStringBuilder.append(this.a.k);
      localStringBuilder.append(", ip: ");
      localStringBuilder.append(this.a.n);
      localStringBuilder.append(", toUin: ");
      localStringBuilder.append(this.a.o);
      localStringBuilder.append(", score: ");
      localStringBuilder.append(this.a.l);
      localStringBuilder.append(", problems: ");
      localStringBuilder.append(this.a.f);
      QLog.d("ScoreActivity", 2, localStringBuilder.toString());
    }
    localSharedPreferences.edit().putBoolean(VideoConstants.t, true).commit();
    if (this.a.s != 0L) {
      try
      {
        this.a.q.getMessageFacade().h(this.a.o, this.a.r, this.a.s);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMsgByUniseq : ");
          localStringBuilder.append(localException);
          QLog.w("ScoreActivity", 2, localStringBuilder.toString());
        }
      }
    }
    this.a.getBaseActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment.3
 * JD-Core Version:    0.7.0.1
 */