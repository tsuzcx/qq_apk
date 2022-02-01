package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.report.AVReport;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class VideoInviteUIFull
  extends VideoInviteUIBase
{
  private SmallScreenActivityPlugin h = null;
  
  public VideoInviteUIFull(VideoInviteActivity paramVideoInviteActivity)
  {
    super(paramVideoInviteActivity);
    this.b = 2;
  }
  
  private void b(boolean paramBoolean)
  {
    long l = QQAudioHelper.d();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("DestroyUI isQuit[");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append("], mPeerUin[");
    ((StringBuilder)localObject1).append(this.a.o);
    ((StringBuilder)localObject1).append("], mIsDoubleVideoMeeting[");
    ((StringBuilder)localObject1).append(this.a.G);
    ((StringBuilder)localObject1).append("], seq[");
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append("]");
    AVLog.printAllUserLog("VideoInviteUIFull", ((StringBuilder)localObject1).toString());
    Object localObject2 = this.a.d();
    if (localObject2 == null) {
      return;
    }
    localObject1 = ((VideoController)localObject2).k();
    this.a.s = paramBoolean;
    ((VideoController)localObject2).a(true);
    ((VideoController)localObject2).h(false);
    localObject2 = this.h;
    if (localObject2 != null) {
      ((SmallScreenActivityPlugin)localObject2).a(l, this.a.s);
    }
    this.a.finish();
    if (!paramBoolean)
    {
      int i = SmallScreenUtils.a(((SessionInfo)localObject1).bB);
      this.a.overridePendingTransition(0, i);
    }
  }
  
  private boolean m()
  {
    if (this.a.H.m())
    {
      DataReport.e(false, true);
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteUIFull", 2, "startVideo phone is calling!");
      }
      String str1 = a(2131893192);
      String str2 = a(2131893195);
      PopupDialog.a(this.a.getApplicationContext(), 230, str2, str1, 2131887648, 2131892267, new VideoInviteUIFull.MyOnClickListener(null), null);
      return true;
    }
    return false;
  }
  
  private void n()
  {
    ImageView localImageView = (ImageView)super.b(2131428978);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = UITools.a(this.a);
    if (i <= 320)
    {
      localLayoutParams.topMargin = super.b().getDimensionPixelSize(2131298464);
      localLayoutParams.width = super.b().getDimensionPixelSize(2131298460);
      localLayoutParams.height = super.b().getDimensionPixelSize(2131298460);
    }
    else if (i <= 480)
    {
      localLayoutParams.topMargin = super.b().getDimensionPixelSize(2131298465);
      localLayoutParams.width = super.b().getDimensionPixelSize(2131298461);
      localLayoutParams.height = super.b().getDimensionPixelSize(2131298461);
    }
    else
    {
      localLayoutParams.topMargin = super.b().getDimensionPixelSize(2131298468);
      localLayoutParams.width = super.b().getDimensionPixelSize(2131298463);
      localLayoutParams.height = super.b().getDimensionPixelSize(2131298463);
    }
    localImageView.setLayoutParams(localLayoutParams);
  }
  
  public void BtnOnClick(View paramView)
  {
    long l = QQAudioHelper.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo BtnOnClick, id[");
    localStringBuilder.append(LayoutDef.a(paramView.getId()));
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.d("VideoInviteUIFull", 1, localStringBuilder.toString());
    boolean bool = this.a.G;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131441182: 
      QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, REFUSE");
      this.a.r = false;
      this.a.a(l, true);
      if (bool)
      {
        a("0X80051FF");
        return;
      }
      if (this.a.g)
      {
        a("0X8004398");
        return;
      }
      a("0X80043F6");
      return;
    case 2131441020: 
      QLog.d("VideoInviteUIFull", 1, "onClick HIDE ");
      paramView = this.a.d();
      if (paramView != null) {
        paramView.b("backgroundReason", "3");
      }
      e();
      return;
    case 2131428983: 
      QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, ACCEPT_BY_AUDIO");
      if (m()) {
        return;
      }
      this.a.f = true;
      this.a.r = true;
      this.a.c(l);
      a("0X80043F7");
      return;
    case 2131428982: 
      QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, MSG_REPLY");
      this.a.a(l, this.a, false);
      if (bool) {
        paramView = "0X8005200";
      } else if (this.a.g) {
        paramView = "0X80043A5";
      } else {
        paramView = "0X80043AB";
      }
      a(paramView);
      return;
    }
    if (m()) {
      return;
    }
    QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, ACCEPT");
    this.a.r = true;
    AVReport.a().am = SystemClock.elapsedRealtime();
    this.a.c(l);
    if (bool)
    {
      a("0X80051FE");
      return;
    }
    if (this.a.g)
    {
      a("0X8004397");
      return;
    }
    a("0X80043F5");
  }
  
  public void a(Context paramContext, String paramString, Intent paramIntent)
  {
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramString))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if (paramContext != null)
      {
        TraeHelper.b(this.a.H);
        if (paramContext.equals("homekey"))
        {
          if (this.a.g) {
            a("0X8004399");
          } else {
            a("0X80043F8");
          }
          this.a.d().b("backgroundReason", "1");
          com.tencent.av.VideoConstants.ProcessInfo.a = "1";
        }
      }
    }
    else if ("android.intent.action.SCREEN_OFF".equals(paramString))
    {
      this.a.d().b("backgroundReason", "4");
      com.tencent.av.VideoConstants.ProcessInfo.a = "4";
      this.a.h = true;
      this.a.a("ACTION_SCREEN_OFF");
    }
  }
  
  public void a(VideoInviteUIBase paramVideoInviteUIBase)
  {
    super.a(paramVideoInviteUIBase);
    AVReport.a().y = this.f;
    AVReport.a().z = this.g;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      AVReport.a().y = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().z = SystemClock.elapsedRealtime();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      if (this.a.g) {
        a("0X800439A");
      } else {
        a("0X80043F9");
      }
    }
    return false;
  }
  
  public void c()
  {
    if (this.a.r)
    {
      this.a.Q.setViewEnable(2131441182, false);
      this.a.Q.setViewEnable(2131428983, false);
    }
  }
  
  public void d()
  {
    this.a.runOnUiThread(new VideoInviteUIFull.1(this));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteUIFull", 2, "onBackPressed");
    }
    if (!this.a.r)
    {
      Object localObject = this.a.d();
      if (localObject != null) {
        ((VideoController)localObject).p();
      }
      com.tencent.av.VideoConstants.ProcessInfo.a = "3";
      localObject = this.h;
      if (localObject != null) {
        ((SmallScreenActivityPlugin)localObject).a();
      }
      b(false);
    }
  }
  
  public void f()
  {
    super.f();
    this.a.setContentView(2131625821);
    this.a.getWindow().addFlags(2097152);
    this.a.getWindow().addFlags(128);
    this.a.getWindow().clearFlags(524288);
    this.a.getWindow().clearFlags(1024);
    this.a.b();
    if (ThemeUtil.isInNightMode(this.a.H)) {
      this.a.findViewById(2131441224).setVisibility(0);
    }
    if (this.a.Q != null)
    {
      this.a.Q.e();
      this.a.Q.a(-1046L);
    }
    this.a.Q = ((QavPanel)super.b(2131441227));
    this.a.Q.a(2131625782);
    this.a.Q.d();
    this.a.y = ((ImageView)super.b(2131428978));
    this.a.z = ((TextView)super.b(2131428981));
    this.a.A.setText(2131917908);
    this.a.a();
    if (this.a.e.p == 9500)
    {
      this.a.Q.setViewVisibility(2131428983, 8);
      this.a.Q.setViewVisibility(2131428982, 8);
    }
    else if (this.a.g)
    {
      this.a.Q.setViewVisibility(2131428983, 4);
      this.a.Q.setViewVisibility(2131428982, 0);
      this.a.A.setText(2131893703);
      this.a.Q.setAcceptDrawableTop(super.b().getDrawable(2130842943));
    }
    Object localObject = WTogetherUtil.a(this.a.o);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.a.A.setText((CharSequence)localObject);
    }
    this.a.m();
    if (this.a.g)
    {
      this.a.Q.a(2131441182, super.a(2131887108), this.a.e.o);
      this.a.Q.a(2131428972, super.a(2131887087), this.a.e.o);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.p);
      ((StringBuilder)localObject).append(super.a(2131887106));
      localObject = ((StringBuilder)localObject).toString();
      UITools.a(this.a.z, (String)localObject);
    }
    else
    {
      this.a.Q.a(2131441182, super.a(2131887108));
      this.a.Q.a(2131428972, super.a(2131887087));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.p);
      ((StringBuilder)localObject).append(super.a(2131887106));
      localObject = ((StringBuilder)localObject).toString();
      UITools.a(this.a.z, (String)localObject);
    }
    this.a.setTitle((CharSequence)localObject);
    if (this.a.R != null) {
      this.a.R.b();
    }
    this.a.R = new QavInOutAnimation(this.a, this.a.d(), 1, this.a.Q, null, null, this.a.y, this.a.z, this.a.A, null);
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteUIFull", 2, "video invite full onCreate OK");
    }
    int i;
    if (this.a.g) {
      i = 1;
    } else {
      i = 2;
    }
    int j;
    if (this.a.d().k().i == 2) {
      j = 2;
    } else {
      j = 3;
    }
    ReportController.b(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", i, j, "", "", "", "");
    this.a.a(true);
    this.h = SmallScreenActivityPlugin.a(this.a.H);
    new VideoControlUI.QavStatusBar((RelativeLayout)b(2131441294)).a(this.a);
    if ((FontSettingManager.getFontLevel() >= 17.0F) && ((this.c <= 800) || ((UITools.a()) && (this.c <= 1280))))
    {
      localObject = (RelativeLayout)super.b(2131428959);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      localObject = (RelativeLayout)super.b(2131428968);
      localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    }
    n();
    if (this.a.g)
    {
      a("0X8004396");
      return;
    }
    a("0X80043F4");
  }
  
  public void l()
  {
    super.l();
    QLog.d("VideoInviteUIFull", 1, "onDestroy");
    if (this.a.Q != null)
    {
      this.a.Q.e();
      this.a.Q.a(-1045L);
      this.a.Q = null;
    }
    if (this.a.R != null)
    {
      this.a.R.b();
      this.a.R = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteUIFull
 * JD-Core Version:    0.7.0.1
 */