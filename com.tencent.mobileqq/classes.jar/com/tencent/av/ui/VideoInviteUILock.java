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
    this.jdField_a_of_type_Int = 1;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b())
    {
      DataReport.e(false, true);
      DialogUtil.b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, a(2131695447), a(2131695444), null, new VideoInviteUILock.2(this), null);
      return true;
    }
    return false;
  }
  
  public void BtnOnClick(View paramView)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getIntent().getBooleanExtra("isDoubleVideoMeeting", false);
    long l = AudioHelper.b();
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
    case 2131373510: 
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l, true);
      if (bool)
      {
        a("0X80051FF");
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean)
      {
        a("0X8004202");
        return;
      }
      a("0X8004206");
      return;
    case 2131363130: 
      if (a()) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c(l);
      a("0X8004207");
      return;
    case 2131363129: 
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, true);
      if (bool) {
        paramView = "0X8005200";
      } else if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        paramView = "0X800439F";
      } else {
        paramView = "0X80043B1";
      }
      a(paramView);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean = true;
    AVReport.a().R = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c(l);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageButton != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
      }
    }
  }
  
  public void a(Context paramContext, String paramString, Intent paramIntent)
  {
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramString)) {
      return;
    }
    long l;
    if ("android.intent.action.SCREEN_OFF".equals(paramString))
    {
      l = AudioHelper.b();
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("ACTION_SCREEN_OFF, seq[");
        paramContext.append(l);
        paramContext.append("]");
        QLog.w("VideoInviteUILock", 2, paramContext.toString());
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a("backgroundReason", "4");
      com.tencent.av.VideoConstants.ProcessInfo.a = "4";
      if (PhoneStatusTools.c(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity))
      {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l);
        if ((TraeHelper.a() != null) && (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().jdField_d_of_type_Boolean)) {
          TraeHelper.a().b();
        }
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        paramContext = null;
      } else {
        paramContext = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
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
        TraeHelper.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, l);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean)
      {
        a("0X8004208");
        return;
      }
      a("0X8004209");
      return;
    }
    if ("android.intent.action.SCREEN_ON".equals(paramString))
    {
      l = AudioHelper.b();
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("ACTION_SCREEN_ON, seq[");
        paramContext.append(l);
        paramContext.append("]");
        QLog.w("VideoInviteUILock", 2, paramContext.toString());
      }
      if ((this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_i_of_type_Boolean)) {
        TraeHelper.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
      } else {
        TraeHelper.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b(l);
      if ((Build.VERSION.SDK_INT <= 19) && (!VideoController.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity))) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a("ACTION_SCREEN_ON");
      }
    }
  }
  
  public void a(VideoInviteUIBase paramVideoInviteUIBase)
  {
    super.a(paramVideoInviteUIBase);
    AVReport.a().s = this.jdField_b_of_type_Long;
    AVReport.a().t = this.c;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      AVReport.a().s = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().t = SystemClock.elapsedRealtime();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "0X8004200", "0X8004200", 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_i_of_type_Int), "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X8004204", "0X8004204", 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_i_of_type_Int), "");
      }
    }
    return true;
  }
  
  public void d()
  {
    super.d();
    long l = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setContentView(2131559780);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(524288);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(1024);
    if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(2097152);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b();
    new VideoControlUI.QavStatusBar((RelativeLayout)a(2131373628)).a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(l);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131373554));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559740);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(new VideoInviteUILock.1(this, l));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131380687));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131380688));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppSessionInfo.k == 9500)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363130, 8);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363129, 8);
    }
    else if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setText(2131695941);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363130, 8);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131363129, 11);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131363129, 2, a().getDimensionPixelSize(2131297847));
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373507, 2130842027);
      UITools.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, a(2131695940));
    }
    else
    {
      UITools.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, a(2131720272));
    }
    Object localObject = WTogetherUtil.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_c_of_type_JavaLangString);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_JavaLangString);
    ((StringBuilder)localObject).append(a(2131690206));
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setTitle((CharSequence)localObject);
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.b();
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(), 1, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, null);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(true);
    if ((FontSettingManager.getFontLevel() == 20.0F) || (FontSettingManager.getFontLevel() == 18.0F) || (FontSettingManager.getFontLevel() == 17.0F))
    {
      if ((FontSettingManager.getFontLevel() == 20.0F) && (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373510, 1, a().getDimensionPixelSize(2131297665));
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131363130, 2, a().getDimensionPixelSize(2131297665));
      }
      if ((this.jdField_b_of_type_Int <= 800) || ((UITools.a()) && (this.jdField_b_of_type_Int <= 1280))) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373506, 4, 0);
      }
    }
    k();
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
      a("0X800439D");
    } else {
      a("0X80043FC");
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteUILock", 2, "video invite Lock onCreate OK");
    }
  }
  
  public void j()
  {
    super.j();
    QLog.d("VideoInviteUILock", 1, "onDestroy");
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(-1047L);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.b();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
  }
  
  void k()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131380687);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = UITools.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if (i <= 320)
    {
      localLayoutParams.topMargin = a().getDimensionPixelSize(2131297794);
      localLayoutParams.width = a().getDimensionPixelSize(2131297790);
      localLayoutParams.height = a().getDimensionPixelSize(2131297790);
    }
    else if (i <= 480)
    {
      localLayoutParams.topMargin = a().getDimensionPixelSize(2131297795);
      localLayoutParams.width = a().getDimensionPixelSize(2131297791);
      localLayoutParams.height = a().getDimensionPixelSize(2131297791);
    }
    else
    {
      localLayoutParams.topMargin = (a().getDimensionPixelSize(2131297798) + a().getDimensionPixelSize(2131297799));
      localLayoutParams.width = a().getDimensionPixelSize(2131297793);
      localLayoutParams.height = a().getDimensionPixelSize(2131297793);
    }
    localImageView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteUILock
 * JD-Core Version:    0.7.0.1
 */