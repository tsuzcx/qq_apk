package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.report.AVReport;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;

public class VideoInviteUILock
  extends VideoInviteUIBase
{
  public VideoInviteUILock(VideoInviteActivity paramVideoInviteActivity)
  {
    super(paramVideoInviteActivity);
    this.b = 1;
  }
  
  private boolean n()
  {
    if (this.a.H.m())
    {
      DataReport.e(false, true);
      DialogUtil.b(this.a, a(2131893195), a(2131893192), null, new VideoInviteUILock.2(this), null);
      return true;
    }
    return false;
  }
  
  public void BtnOnClick(View paramView)
  {
    boolean bool = this.a.getIntent().getBooleanExtra("isDoubleVideoMeeting", false);
    long l = AudioHelper.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo BtnOnClick, id[");
    localStringBuilder.append(LayoutDef.a(paramView.getId()));
    localStringBuilder.append("], isDoubleVideoMeeting[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.d("VideoInviteUILock", 1, localStringBuilder.toString());
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131441182: 
      this.a.r = false;
      this.a.a(l, true);
      if (bool)
      {
        a("0X80051FF");
        return;
      }
      if (this.a.g)
      {
        a("0X8004202");
        return;
      }
      a("0X8004206");
      return;
    case 2131428983: 
      if (n()) {
        return;
      }
      this.a.f = true;
      this.a.r = true;
      this.a.c(l);
      a("0X8004207");
      return;
    case 2131428982: 
      this.a.a(l, this.a, true);
      if (bool) {
        paramView = "0X8005200";
      } else if (this.a.g) {
        paramView = "0X800439F";
      } else {
        paramView = "0X80043B1";
      }
      a(paramView);
      return;
    }
    this.a.r = true;
    AVReport.a().am = SystemClock.elapsedRealtime();
    this.a.c(l);
  }
  
  public void a(Context paramContext, String paramString, Intent paramIntent)
  {
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramString)) {
      return;
    }
    long l;
    if ("android.intent.action.SCREEN_OFF".equals(paramString))
    {
      l = AudioHelper.c();
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("ACTION_SCREEN_OFF, seq[");
        paramContext.append(l);
        paramContext.append("]");
        QLog.w("VideoInviteUILock", 2, paramContext.toString());
      }
      this.a.d().b("backgroundReason", "4");
      com.tencent.av.VideoConstants.ProcessInfo.a = "4";
      if (PhoneStatusTools.c(this.a))
      {
        this.a.a(l);
        if ((TraeHelper.a() != null) && (!this.a.d().j)) {
          TraeHelper.a().d();
        }
      }
      if (this.a.H == null) {
        paramContext = null;
      } else {
        paramContext = this.a.H.getCurrentAccountUin();
      }
      boolean bool = AVUtil.b(paramContext);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("ACTION_SCREEN_OFF avCallBtnState[");
        paramContext.append(bool);
        paramContext.append("], seq[");
        paramContext.append(l);
        paramContext.append("]");
        QLog.w("VideoInviteUILock", 1, paramContext.toString());
      }
      if (bool) {
        TraeHelper.a(this.a.H, false, l);
      }
      if (this.a.g)
      {
        a("0X8004208");
        return;
      }
      a("0X8004209");
      return;
    }
    if ("android.intent.action.SCREEN_ON".equals(paramString))
    {
      l = AudioHelper.c();
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("ACTION_SCREEN_ON, seq[");
        paramContext.append(l);
        paramContext.append("]");
        QLog.w("VideoInviteUILock", 2, paramContext.toString());
      }
      if ((this.a.g) && (!this.a.G)) {
        TraeHelper.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
      } else {
        TraeHelper.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
      }
      this.a.b(l);
      if ((Build.VERSION.SDK_INT <= 19) && (!VideoController.a(this.a))) {
        this.a.a("ACTION_SCREEN_ON");
      }
    }
  }
  
  public void a(VideoInviteUIBase paramVideoInviteUIBase)
  {
    super.a(paramVideoInviteUIBase);
    AVReport.a().w = this.f;
    AVReport.a().x = this.g;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      AVReport.a().w = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().x = SystemClock.elapsedRealtime();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      if (this.a.g) {
        ReportController.b(null, "CliOper", "", "", "0X8004200", "0X8004200", 0, 0, Integer.toString(this.a.i), Integer.toString(this.a.K), Integer.toString(this.a.M), "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X8004204", "0X8004204", 0, 0, Integer.toString(this.a.i), Integer.toString(this.a.K), Integer.toString(this.a.M), "");
      }
    }
    return true;
  }
  
  public void c()
  {
    if (this.a.r)
    {
      if (this.a.B != null) {
        this.a.B.setEnabled(false);
      }
      if (this.a.C != null) {
        this.a.C.setEnabled(false);
      }
    }
  }
  
  public void f()
  {
    super.f();
    long l = AudioHelper.c();
    this.a.setContentView(2131625822);
    this.a.getWindow().addFlags(524288);
    this.a.getWindow().addFlags(128);
    this.a.getWindow().addFlags(1024);
    if (!this.a.h) {
      this.a.getWindow().addFlags(2097152);
    }
    this.a.b();
    new VideoControlUI.QavStatusBar((RelativeLayout)b(2131441294)).a(this.a);
    if (this.a.Q != null) {
      this.a.Q.a(l);
    }
    this.a.Q = ((QavPanel)this.a.findViewById(2131441227));
    this.a.Q.a(2131625781);
    this.a.Q.setWaveVisibility(8);
    this.a.Q.a(new VideoInviteUILock.1(this, l));
    this.a.y = ((ImageView)this.a.findViewById(2131449647));
    this.a.z = ((TextView)this.a.findViewById(2131449648));
    this.a.a();
    if (this.a.e.p == 9500)
    {
      this.a.Q.setViewVisibility(2131428983, 8);
      this.a.Q.setViewVisibility(2131428982, 8);
    }
    else if (this.a.g)
    {
      this.a.A.setText(2131893703);
      this.a.Q.setViewVisibility(2131428983, 8);
      this.a.Q.b(2131428982, 11);
      this.a.Q.a(2131428982, 2, b().getDimensionPixelSize(2131298517));
      this.a.Q.a(2131441179, 2130842944);
      UITools.a(this.a.A, a(2131893702));
    }
    else
    {
      UITools.a(this.a.A, a(2131917907));
    }
    Object localObject = WTogetherUtil.a(this.a.o);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.a.A.setText((CharSequence)localObject);
    }
    this.a.m();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.p);
    ((StringBuilder)localObject).append(a(2131887106));
    localObject = ((StringBuilder)localObject).toString();
    this.a.setTitle((CharSequence)localObject);
    if (this.a.R != null) {
      this.a.R.b();
    }
    this.a.R = new QavInOutAnimation(this.a, this.a.d(), 1, this.a.Q, null, null, this.a.y, this.a.z, this.a.A, null);
    this.a.a(true);
    if ((FontSettingManager.getFontLevel() == 20.0F) || (FontSettingManager.getFontLevel() == 18.0F) || (FontSettingManager.getFontLevel() == 17.0F))
    {
      if ((FontSettingManager.getFontLevel() == 20.0F) && (!this.a.g))
      {
        this.a.Q.a(2131441182, 1, b().getDimensionPixelSize(2131298330));
        this.a.Q.a(2131428983, 2, b().getDimensionPixelSize(2131298330));
      }
      if ((this.c <= 800) || ((UITools.a()) && (this.c <= 1280))) {
        this.a.Q.a(2131441178, 4, 0);
      }
    }
    m();
    if (this.a.g) {
      a("0X800439D");
    } else {
      a("0X80043FC");
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteUILock", 2, "video invite Lock onCreate OK");
    }
  }
  
  public void l()
  {
    super.l();
    QLog.d("VideoInviteUILock", 1, "onDestroy");
    if (this.a.Q != null)
    {
      this.a.Q.a(-1047L);
      this.a.Q = null;
    }
    if (this.a.R != null)
    {
      this.a.R.b();
      this.a.R = null;
    }
  }
  
  void m()
  {
    ImageView localImageView = (ImageView)this.a.findViewById(2131449647);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = UITools.a(this.a);
    if (i <= 320)
    {
      localLayoutParams.topMargin = b().getDimensionPixelSize(2131298464);
      localLayoutParams.width = b().getDimensionPixelSize(2131298460);
      localLayoutParams.height = b().getDimensionPixelSize(2131298460);
    }
    else if (i <= 480)
    {
      localLayoutParams.topMargin = b().getDimensionPixelSize(2131298465);
      localLayoutParams.width = b().getDimensionPixelSize(2131298461);
      localLayoutParams.height = b().getDimensionPixelSize(2131298461);
    }
    else
    {
      localLayoutParams.topMargin = (b().getDimensionPixelSize(2131298468) + b().getDimensionPixelSize(2131298469));
      localLayoutParams.width = b().getDimensionPixelSize(2131298463);
      localLayoutParams.height = b().getDimensionPixelSize(2131298463);
    }
    localImageView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteUILock
 * JD-Core Version:    0.7.0.1
 */