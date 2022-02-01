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
  private SmallScreenActivityPlugin a;
  
  public VideoInviteUIFull(VideoInviteActivity paramVideoInviteActivity)
  {
    super(paramVideoInviteActivity);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = null;
    this.jdField_a_of_type_Int = 2;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b())
    {
      DataReport.e(false, true);
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteUIFull", 2, "startVideo phone is calling!");
      }
      String str1 = a(2131695444);
      String str2 = a(2131695447);
      PopupDialog.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getApplicationContext(), 230, str2, str1, 2131690728, 2131694583, new VideoInviteUIFull.MyOnClickListener(null), null);
      return true;
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    long l = QQAudioHelper.b();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("DestroyUI isQuit[");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append("], mPeerUin[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("], mIsDoubleVideoMeeting[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.i);
    ((StringBuilder)localObject1).append("], seq[");
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append("]");
    AVLog.printAllUserLog("VideoInviteUIFull", ((StringBuilder)localObject1).toString());
    Object localObject2 = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
    if (localObject2 == null) {
      return;
    }
    localObject1 = ((VideoController)localObject2).a();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.e = paramBoolean;
    ((VideoController)localObject2).a(true);
    ((VideoController)localObject2).e(false);
    localObject2 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
    if (localObject2 != null) {
      ((SmallScreenActivityPlugin)localObject2).a(l, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.e);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
    if (!paramBoolean)
    {
      int i = SmallScreenUtils.a(((SessionInfo)localObject1).K);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.overridePendingTransition(0, i);
    }
  }
  
  private void k()
  {
    ImageView localImageView = (ImageView)super.a(2131363125);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = UITools.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if (i <= 320)
    {
      localLayoutParams.topMargin = super.a().getDimensionPixelSize(2131297794);
      localLayoutParams.width = super.a().getDimensionPixelSize(2131297790);
      localLayoutParams.height = super.a().getDimensionPixelSize(2131297790);
    }
    else if (i <= 480)
    {
      localLayoutParams.topMargin = super.a().getDimensionPixelSize(2131297795);
      localLayoutParams.width = super.a().getDimensionPixelSize(2131297791);
      localLayoutParams.height = super.a().getDimensionPixelSize(2131297791);
    }
    else
    {
      localLayoutParams.topMargin = super.a().getDimensionPixelSize(2131297798);
      localLayoutParams.width = super.a().getDimensionPixelSize(2131297793);
      localLayoutParams.height = super.a().getDimensionPixelSize(2131297793);
    }
    localImageView.setLayoutParams(localLayoutParams);
  }
  
  public void BtnOnClick(View paramView)
  {
    long l = QQAudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo BtnOnClick, id[");
    localStringBuilder.append(LayoutDef.a(paramView.getId()));
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.d("VideoInviteUIFull", 1, localStringBuilder.toString());
    boolean bool = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.i;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131373510: 
      QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, REFUSE");
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l, true);
      if (bool)
      {
        a("0X80051FF");
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean)
      {
        a("0X8004398");
        return;
      }
      a("0X80043F6");
      return;
    case 2131373348: 
      QLog.d("VideoInviteUIFull", 1, "onClick HIDE ");
      paramView = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
      if (paramView != null) {
        paramView.a("backgroundReason", "3");
      }
      c();
      return;
    case 2131363130: 
      QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, ACCEPT_BY_AUDIO");
      if (a()) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c(l);
      a("0X80043F7");
      return;
    case 2131363129: 
      QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, MSG_REPLY");
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, false);
      if (bool) {
        paramView = "0X8005200";
      } else if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        paramView = "0X80043A5";
      } else {
        paramView = "0X80043AB";
      }
      a(paramView);
      return;
    }
    if (a()) {
      return;
    }
    QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, ACCEPT");
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean = true;
    AVReport.a().R = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c(l);
    if (bool)
    {
      a("0X80051FE");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean)
    {
      a("0X8004397");
      return;
    }
    a("0X80043F5");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373510, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131363130, false);
    }
  }
  
  public void a(Context paramContext, String paramString, Intent paramIntent)
  {
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramString))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if (paramContext != null)
      {
        TraeHelper.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if (paramContext.equals("homekey"))
        {
          if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
            a("0X8004399");
          } else {
            a("0X80043F8");
          }
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a("backgroundReason", "1");
          com.tencent.av.VideoConstants.ProcessInfo.a = "1";
        }
      }
    }
    else if ("android.intent.action.SCREEN_OFF".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a("backgroundReason", "4");
      com.tencent.av.VideoConstants.ProcessInfo.a = "4";
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a("ACTION_SCREEN_OFF");
    }
  }
  
  public void a(VideoInviteUIBase paramVideoInviteUIBase)
  {
    super.a(paramVideoInviteUIBase);
    AVReport.a().u = this.jdField_b_of_type_Long;
    AVReport.a().v = this.c;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      AVReport.a().u = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().v = SystemClock.elapsedRealtime();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        a("0X800439A");
      } else {
        a("0X80043F9");
      }
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.runOnUiThread(new VideoInviteUIFull.1(this));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteUIFull", 2, "onBackPressed");
    }
    if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
      if (localObject != null) {
        ((VideoController)localObject).d();
      }
      com.tencent.av.VideoConstants.ProcessInfo.a = "3";
      localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
      if (localObject != null) {
        ((SmallScreenActivityPlugin)localObject).a();
      }
      b(false);
    }
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setContentView(2131559779);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(2097152);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().clearFlags(524288);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().clearFlags(1024);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b();
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131373551).setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.f();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(-1046L);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)super.a(2131373554));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559741);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.e();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.a(2131363125));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.a(2131363128));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setText(2131720273);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppSessionInfo.k == 9500)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363130, 8);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363129, 8);
    }
    else if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363130, 4);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363129, 0);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setText(2131695941);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setAcceptDrawableTop(super.a().getDrawable(2130842026));
    }
    Object localObject = WTogetherUtil.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_c_of_type_JavaLangString);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h();
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373510, super.a(2131690208), this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppSessionInfo.j);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131363119, super.a(2131690187), this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppSessionInfo.j);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject).append(super.a(2131690206));
      localObject = ((StringBuilder)localObject).toString();
      UITools.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView, (String)localObject);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373510, super.a(2131690208));
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131363119, super.a(2131690187));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject).append(super.a(2131690206));
      localObject = ((StringBuilder)localObject).toString();
      UITools.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView, (String)localObject);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setTitle((CharSequence)localObject);
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.b();
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(), 1, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, null);
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteUIFull", 2, "video invite full onCreate OK");
    }
    int i;
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
      i = 1;
    } else {
      i = 2;
    }
    int j;
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a().f == 2) {
      j = 2;
    } else {
      j = 3;
    }
    ReportController.b(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", i, j, "", "", "", "");
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(true);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = SmallScreenActivityPlugin.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    new VideoControlUI.QavStatusBar((RelativeLayout)a(2131373628)).a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if ((FontSettingManager.getFontLevel() >= 17.0F) && ((this.jdField_b_of_type_Int <= 800) || ((UITools.a()) && (this.jdField_b_of_type_Int <= 1280))))
    {
      localObject = (RelativeLayout)super.a(2131363106);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      localObject = (RelativeLayout)super.a(2131363115);
      localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    }
    k();
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean)
    {
      a("0X8004396");
      return;
    }
    a("0X80043F4");
  }
  
  public void j()
  {
    super.j();
    QLog.d("VideoInviteUIFull", 1, "onDestroy");
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.f();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(-1045L);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.b();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteUIFull
 * JD-Core Version:    0.7.0.1
 */