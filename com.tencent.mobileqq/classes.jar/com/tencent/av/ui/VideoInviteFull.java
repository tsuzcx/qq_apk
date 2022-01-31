package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.report.AVReport;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import kdt;
import kdu;

public class VideoInviteFull
  extends VideoInviteActivity
{
  LinearLayout a;
  public ProgressBar a;
  final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new kdu(this, 0);
  Runnable jdField_b_of_type_JavaLangRunnable = new kdt(this);
  final BroadcastReceiver c;
  public TextView c;
  final BroadcastReceiver jdField_d_of_type_AndroidContentBroadcastReceiver = new kdu(this, 2);
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  int l = 0;
  int m = 0;
  int n;
  
  public VideoInviteFull()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_c_of_type_AndroidContentBroadcastReceiver = new kdu(this, 1);
  }
  
  public void BtnOnClick(View paramView)
  {
    QLog.d("VideoInviteFull", 1, "avideo BtnOnClick, id" + QavPanel.a(paramView.getId()));
    boolean bool = this.jdField_h_of_type_Boolean;
    switch (paramView.getId())
    {
    default: 
    case 2131364272: 
    case 2131365419: 
    case 2131365418: 
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365419, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131364272, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365418, false);
        return;
        QLog.d("VideoInviteFull", 1, "avideo BtnOnClick, REFUSE");
        this.jdField_d_of_type_Boolean = false;
        super.a(true);
        if (bool)
        {
          ReportController.b(null, "CliOper", "", "", "0X80051FF", "0X80051FF", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.jdField_h_of_type_Int), Integer.toString(this.i), "");
        }
        else if (this.jdField_b_of_type_Boolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004398", "0X8004398", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.jdField_h_of_type_Int), Integer.toString(this.i), "");
        }
        else
        {
          ReportController.b(null, "CliOper", "", "", "0X80043F6", "0X80043F6", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.jdField_h_of_type_Int), Integer.toString(this.i), "");
          continue;
          QLog.d("VideoInviteFull", 1, "avideo BtnOnClick, ACCEPT");
          this.jdField_d_of_type_Boolean = true;
          AVReport.a().T = SystemClock.elapsedRealtime();
          super.e();
          if (bool)
          {
            ReportController.b(null, "CliOper", "", "", "0X80051FE", "0X80051FE", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.jdField_h_of_type_Int), Integer.toString(this.i), "");
          }
          else if (this.jdField_b_of_type_Boolean)
          {
            ReportController.b(null, "CliOper", "", "", "0X8004397", "0X8004397", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.jdField_h_of_type_Int), Integer.toString(this.i), "");
          }
          else
          {
            ReportController.b(null, "CliOper", "", "", "0X80043F5", "0X80043F5", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.jdField_h_of_type_Int), Integer.toString(this.i), "");
            continue;
            QLog.d("VideoInviteFull", 1, "avideo BtnOnClick, ACCEPT_BY_AUDIO");
            this.jdField_a_of_type_Boolean = true;
            this.jdField_d_of_type_Boolean = true;
            super.e();
            ReportController.b(null, "CliOper", "", "", "0X80043F7", "0X80043F7", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.jdField_h_of_type_Int), Integer.toString(this.i), "");
          }
        }
      }
    }
    QLog.d("VideoInviteFull", 1, "avideo BtnOnClick, MSG_REPLY");
    super.a(this, false);
    if (bool) {
      paramView = "0X8005200";
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.jdField_h_of_type_Int), Integer.toString(this.i), "");
      return;
      if (this.jdField_b_of_type_Boolean) {
        paramView = "0X80043A5";
      } else {
        paramView = "0X80043AB";
      }
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.n == paramInt) {}
    while ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.n = paramInt;
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131428865);
      continue;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131428864);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
      continue;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131428863);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)super.findViewById(2131365940));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(1);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131366302));
    Object localObject = BitmapTools.a(super.getApplicationContext(), 2130840224);
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366304));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366305));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366306));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131428843);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131364269));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364271));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364270));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364268));
      super.a();
      if (!VideoUtils.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.i, this.jdField_a_of_type_ComTencentAvAppSessionInfo.A)) {
        break label485;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131429229);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365418, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365414, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365416, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setAcceptDrawableTop(super.getResources().getDrawable(2130840117));
      label275:
      if (UITools.b(super.getApplicationContext()) <= 480)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = super.getResources().getDimensionPixelSize(2131559966);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      super.h();
      if (!this.jdField_b_of_type_Boolean) {
        break label607;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131364272, super.getString(2131428891), this.jdField_a_of_type_ComTencentAvAppSessionInfo.D);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365419, super.getString(2131428893), this.jdField_a_of_type_ComTencentAvAppSessionInfo.D);
      localObject = this.jdField_d_of_type_JavaLangString + super.getString(2131428889);
      UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject);
    }
    for (;;)
    {
      super.setTitle((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation(this, this.jdField_a_of_type_ComTencentAvVideoController, 1, this.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFull", 2, "video invite full onCreate OK");
      }
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840224);
      break;
      label485:
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.i == 9500)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365418, 8);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365414, 8);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365416, 8);
        break label275;
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label275;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365418, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365414, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365416, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131429064);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setAcceptDrawableTop(super.getResources().getDrawable(2130840117));
      break label275;
      label607:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131364272, super.getString(2131428891));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365419, super.getString(2131428893));
      localObject = this.jdField_d_of_type_JavaLangString + super.getString(2131428889);
      UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject);
    }
  }
  
  void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131493513));
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-1291845633, PorterDuff.Mode.MULTIPLY);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131493513));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131493513));
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131493513));
      }
    }
    do
    {
      return;
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
      }
    } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
  }
  
  void k()
  {
    IntentFilter localIntentFilter = new IntentFilter("tencent.notify.cancel.videorequest");
    super.registerReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  void l()
  {
    ImageView localImageView = (ImageView)super.findViewById(2131366304);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = UITools.a(this);
    if (i <= 320)
    {
      localLayoutParams.topMargin = super.getResources().getDimensionPixelSize(2131560033);
      localLayoutParams.width = super.getResources().getDimensionPixelSize(2131560036);
      localLayoutParams.height = super.getResources().getDimensionPixelSize(2131560036);
    }
    for (;;)
    {
      localImageView.setLayoutParams(localLayoutParams);
      return;
      if (i <= 480)
      {
        localLayoutParams.topMargin = super.getResources().getDimensionPixelSize(2131560032);
        localLayoutParams.width = super.getResources().getDimensionPixelSize(2131560035);
        localLayoutParams.height = super.getResources().getDimensionPixelSize(2131560035);
      }
      else
      {
        localLayoutParams.topMargin = super.getResources().getDimensionPixelSize(2131560031);
        localLayoutParams.width = super.getResources().getDimensionPixelSize(2131560034);
        localLayoutParams.height = super.getResources().getDimensionPixelSize(2131560034);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    QLog.d("VideoInviteFull", 1, "avideo onCreate");
    AVReport.a().u = SystemClock.elapsedRealtime();
    super.onCreate(paramBundle);
    super.setContentView(2130969367);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    this.m = UITools.a(super.getApplicationContext());
    this.l = UITools.b(super.getApplicationContext());
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    super.registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    super.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
    k();
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFull", 2, "onCreate error , mSessionInfo is null");
      }
      return;
    }
    b();
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    }
    paramBundle = super.getResources();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFull", 2, "mScreenWidth = " + this.m + " , mScreenHeight = " + this.l + " , getFontLevel = " + FontSettingManager.a() + ", hasSmartBar = " + super.e());
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.m <= 320) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.topMargin = paramBundle.getDimensionPixelSize(2131559874);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    }
    if (FontSettingManager.a() >= 17.0F)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if (this.m <= 540)
      {
        localLayoutParams.topMargin = paramBundle.getDimensionPixelSize(2131559872);
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      }
      if ((this.l <= 800) || ((e()) && (this.l <= 1280)))
      {
        paramBundle = (RelativeLayout)super.findViewById(2131365413);
        localLayoutParams = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
        localLayoutParams.bottomMargin = 0;
        paramBundle.setLayoutParams(localLayoutParams);
        paramBundle = (RelativeLayout)super.findViewById(2131365417);
        localLayoutParams = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
        localLayoutParams.bottomMargin = 0;
        paramBundle.setLayoutParams(localLayoutParams);
      }
    }
    this.n = 1;
    if ((!NetworkUtil.h(super.getApplicationContext())) && (!NetworkUtil.f(super.getApplicationContext())))
    {
      if (NetworkUtil.b(super.getApplicationContext()))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131429067);
      }
      if (NetworkUtil.c(super.getApplicationContext()))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131429066);
      }
      this.n = 2;
      label522:
      if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.f)))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.f);
        UITools.a(this.jdField_d_of_type_AndroidWidgetTextView, this.f);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label711;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004396", "0X8004396", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.jdField_h_of_type_Int), Integer.toString(this.i), "");
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.i == 21) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.i == 1011))
      {
        this.jdField_d_of_type_Boolean = true;
        super.e();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131364272, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365418, false);
      }
      l();
      if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131428696);
      break label522;
      label711:
      ReportController.b(null, "CliOper", "", "", "0X80043F4", "0X80043F4", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.jdField_h_of_type_Int), Integer.toString(this.i), "");
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFull", 2, "onDestroy");
    }
    super.unregisterReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver);
    super.unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
    super.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.f();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.h();
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.b();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label60;
      }
      ReportController.b(null, "CliOper", "", "", "0X800439A", "0X800439A", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.jdField_h_of_type_Int), Integer.toString(this.i), "");
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      label60:
      ReportController.b(null, "CliOper", "", "", "0X80043F9", "0X80043F9", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.jdField_h_of_type_Int), Integer.toString(this.i), "");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFull", 2, "onResume");
    }
    super.a("VideoInviteFull.onResume");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      AVReport.a().v = SystemClock.elapsedRealtime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFull
 * JD-Core Version:    0.7.0.1
 */