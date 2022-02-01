package com.tencent.av.gaudio;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils.ConfIdownloadTask;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GaInviteDialogActivity
  extends GaInviteActivity
{
  Button I = null;
  Button J = null;
  View K = null;
  boolean L = true;
  int M = 0;
  int N = 0;
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendIsResumeBroadcast isResume = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void k()
  {
    if (this.d == 2)
    {
      String str = String.valueOf(this.b);
      if (QAVHrMeeting.a(this.e.f(str)))
      {
        ChatActivityUtils.ConfIdownloadTask.a(this.l, str, new GaInviteDialogActivity.1(this));
        return;
      }
      l();
      return;
    }
    l();
  }
  
  private void l()
  {
    if (isFinishing()) {
      return;
    }
    g();
  }
  
  public void BtnOnClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131441090)
    {
      if (i != 2131441097) {
        return;
      }
      QAVGroupConfig.Report.a(true);
      if (this.f.j)
      {
        h();
      }
      else
      {
        long l = AudioHelper.c();
        sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
        sendBroadcast(new Intent("tencent.video.v2g.exitAVGame"));
        paramView = this.l;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("BtnOnClick[qav_gaudio_join], relationId[");
        localStringBuilder.append(this.v.aN);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(l);
        localStringBuilder.append("]");
        QLog.w(paramView, 1, localStringBuilder.toString());
        this.e.a(new Object[] { Integer.valueOf(308), Long.valueOf(this.v.aN) });
        k();
      }
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_join", 0, 0, "", "", "", "");
      return;
    }
    QAVGroupConfig.Report.a(false);
    super.a(-1036L);
  }
  
  void c(Intent paramIntent)
  {
    paramIntent.putExtra("ConfAppID", this.M);
    paramIntent.putExtra("MeetingConfID", this.N);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void f()
  {
    if ((!NetworkUtil.isWifiConnected(super.getApplicationContext())) && ((NetworkUtil.is3Gor4G(super.getApplicationContext())) || (NetworkUtil.isMobileNetWork(super.getApplicationContext())))) {
      this.L = false;
    }
    this.h = ((TextView)super.findViewById(2131441094));
    this.k = ((TextView)super.findViewById(2131441075));
    this.j = ((ImageView)super.findViewById(2131441088));
    this.J = ((Button)super.findViewById(2131441090));
    this.I = ((Button)super.findViewById(2131441097));
    a(null, 3);
    this.k.setSingleLine();
    this.K = super.findViewById(2131431855);
    if (!this.L) {
      ((TextView)super.findViewById(2131441100)).setVisibility(0);
    }
    super.f();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.l, 2, "onCreate");
    }
    super.setTheme(2131952187);
    super.setContentView(2131625736);
    super.onCreate(paramBundle);
  }
  
  protected void onPause()
  {
    super.onPause();
    a(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteDialogActivity
 * JD-Core Version:    0.7.0.1
 */