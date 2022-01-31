package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
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
import kdw;
import kdx;
import kdy;

public class VideoInviteLock
  extends VideoInviteActivity
{
  public static String g = "VideoInviteLock";
  LinearLayout a;
  public ProgressBar a;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = null;
  Runnable jdField_b_of_type_JavaLangRunnable = new kdx(this);
  public TextView c;
  TextView d;
  int l;
  int m;
  
  public VideoInviteLock()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
  }
  
  public void BtnOnClick(View paramView)
  {
    boolean bool = super.getIntent().getBooleanExtra("isDoubleVideoMeeting", false);
    QLog.d(g, 1, "avideo BtnOnClick, id" + QavPanel.a(paramView.getId()) + ", isDoubleVideoMeeting[" + bool + "]");
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364272: 
      this.jdField_d_of_type_Boolean = false;
      super.a(true);
      if (bool)
      {
        ReportController.b(null, "CliOper", "", "", "0X80051FF", "0X80051FF", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.h), Integer.toString(this.i), "");
        return;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004202", "0X8004202", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.h), Integer.toString(this.i), "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004206", "0X8004206", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.h), Integer.toString(this.i), "");
      return;
    case 2131365419: 
      this.jdField_d_of_type_Boolean = true;
      AVReport.a().T = SystemClock.elapsedRealtime();
      super.e();
      return;
    case 2131365418: 
      this.jdField_a_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = true;
      super.e();
      ReportController.b(null, "CliOper", "", "", "0X8004207", "0X8004207", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.h), Integer.toString(this.i), "");
      return;
    }
    super.a(this, true);
    if (bool) {
      paramView = "0X8005200";
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.h), Integer.toString(this.i), "");
      return;
      if (this.jdField_b_of_type_Boolean) {
        paramView = "0X800439F";
      } else {
        paramView = "0X80043B1";
      }
    }
  }
  
  protected void a(int paramInt)
  {
    if ((this.m == paramInt) || (this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.m = paramInt;
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
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new kdw(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364263));
    Drawable localDrawable = BitmapTools.a(super.getApplicationContext(), 2130840224);
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364266));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364267));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364264));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131364269));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364271));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364270));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364268));
      super.a();
      if (!VideoUtils.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.i, this.jdField_a_of_type_ComTencentAvAppSessionInfo.A)) {
        break label395;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131429229);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365418, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131364274, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131364277, 2130840118);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131364272, 9, 0);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131364272, 1, 0);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131364272, 14);
    }
    for (;;)
    {
      super.h();
      super.setTitle(this.jdField_d_of_type_JavaLangString + super.getString(2131428889));
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation(this, this.jdField_a_of_type_ComTencentAvVideoController, 1, this.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, null);
      if (QLog.isColorLevel()) {
        QLog.d(g, 2, "video invite Lock onCreate OK");
      }
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840224);
      break;
      label395:
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.i == 9500)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365418, 8);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131364274, 8);
      }
      else if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131429064);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365418, 8);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131364274, 11);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131364274, 2, super.getResources().getDimensionPixelSize(2131559846));
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131364277, 2130840118);
        UITools.a(this.jdField_b_of_type_AndroidWidgetTextView, super.getResources().getString(2131429064));
      }
      else
      {
        UITools.a(this.jdField_b_of_type_AndroidWidgetTextView, super.getResources().getString(2131428843));
      }
    }
  }
  
  void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramBoolean);
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
    ImageView localImageView = (ImageView)super.findViewById(2131364266);
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
    QLog.d(g, 1, "avideo onCreate");
    AVReport.a().s = SystemClock.elapsedRealtime();
    super.onCreate(paramBundle);
    int i = UITools.a(super.getApplicationContext());
    this.l = UITools.b(super.getApplicationContext());
    super.setContentView(2130969368);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(1024);
    if (!this.jdField_c_of_type_Boolean) {
      super.getWindow().addFlags(2097152);
    }
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new kdy(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("tencent.notify.cancel.videorequest");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("android.intent.action.SCREEN_ON");
    super.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(g, 2, "onCreate error , mSessionInfo is null");
      }
      return;
    }
    b();
    this.m = 1;
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    }
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.f)))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.f);
      UITools.a(this.jdField_d_of_type_AndroidWidgetTextView, this.f);
    }
    paramBundle = super.getResources();
    if (i <= 320)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.topMargin = paramBundle.getDimensionPixelSize(2131559874);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      label303:
      if ((FontSettingManager.a() == 20.0F) || (FontSettingManager.a() == 18.0F) || (FontSettingManager.a() == 17.0F))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if (i <= 540)
        {
          localLayoutParams.topMargin = paramBundle.getDimensionPixelSize(2131559872);
          this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
        }
        if ((FontSettingManager.a() == 20.0F) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131364272, 1, super.getResources().getDimensionPixelSize(2131559894));
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365418, 2, super.getResources().getDimensionPixelSize(2131559894));
        }
        if ((this.l <= 800) || ((e()) && (this.l <= 1280))) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131364273, 4, 0);
        }
      }
      if ((NetworkUtil.h(super.getApplicationContext())) || (NetworkUtil.f(super.getApplicationContext()))) {
        break label733;
      }
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
      this.m = 2;
      label555:
      if (!this.jdField_b_of_type_Boolean) {
        break label754;
      }
      ReportController.b(null, "CliOper", "", "", "0X800439D", "0X800439D", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.h), Integer.toString(this.i), "");
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.i == 21) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.i == 1011))
      {
        this.jdField_d_of_type_Boolean = true;
        super.e();
        if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
          this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
        }
        if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
          this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
        }
      }
      if (((PowerManager)super.getSystemService("power")).isScreenOn()) {
        super.a("VideoInviteLock.onCreate");
      }
      k();
      if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
      return;
      if (i > 540) {
        break label303;
      }
      int j = paramBundle.getDimensionPixelSize(2131559865);
      j = j * 2 / 3;
      break label303;
      label733:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131428696);
      break label555;
      label754:
      ReportController.b(null, "CliOper", "", "", "0X80043FC", "0X80043FC", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.h), Integer.toString(this.i), "");
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(g, 2, "onDestroy");
    }
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
      super.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = null;
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.h();
      this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.b();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_b_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "0X8004200", "0X8004200", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.h), Integer.toString(this.i), "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X8004204", "0X8004204", 0, 0, Integer.toString(this.jdField_c_of_type_Int), Integer.toString(this.h), Integer.toString(this.i), "");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      AVReport.a().t = SystemClock.elapsedRealtime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteLock
 * JD-Core Version:    0.7.0.1
 */