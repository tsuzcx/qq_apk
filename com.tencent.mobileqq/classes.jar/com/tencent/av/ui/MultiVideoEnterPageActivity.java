package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.ChatActivityUtils.ConfIdownloadTask;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import jxm;
import jxn;
import jxo;
import jxp;
import jxq;
import jxr;
import jxs;
import jxt;
import jxu;
import jxv;
import jxw;
import jxx;
import mqq.app.BaseActivity;

public class MultiVideoEnterPageActivity
  extends BaseActivity
{
  int jdField_a_of_type_Int;
  public long a;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public VideoController a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new jxp(this);
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new jxt(this);
  public MultiMembersAudioUI a;
  MultiVideoMembersClickListener jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = new jxm(this);
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  public final String a;
  public jxx a;
  public boolean a;
  long[] jdField_a_of_type_ArrayOfLong = null;
  public MultiVideoEnterPageMembersControlUI[] a;
  public int b;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout = null;
  public TextView b;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  public String b;
  public int c;
  public TextView c;
  public Runnable c;
  String c;
  int jdField_d_of_type_Int;
  public TextView d;
  String jdField_d_of_type_JavaLangString;
  public int e;
  TextView e;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  final int j = 0;
  final int k = 1;
  
  public MultiVideoEnterPageActivity()
  {
    this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_e_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_Jxx = null;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = ("MultiVideoEnterPageActivity_" + AudioHelper.a());
  }
  
  private void a(int paramInt, String paramString)
  {
    int n = 0;
    int m = n;
    if (paramInt == 3000)
    {
      m = n;
      if (QAVHrMeeting.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_JavaLangString)))
      {
        ChatActivityUtils.ConfIdownloadTask.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, new jxr(this));
        m = 1;
      }
    }
    if (m == 0) {
      c(10);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c == true)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c = false;
      VideoNodeManager.e();
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366141: 
      QAVGroupConfig.Report.c();
      a(this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString);
      return;
    }
    e();
    if (this.jdField_b_of_type_Int == 1) {
      if (this.f == 10) {
        ReportController.b(null, "CliOper", "", "", "0X8005934", "0X8005934", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      super.finish();
      super.overridePendingTransition(0, 2131034240);
      return;
      ReportController.b(null, "CliOper", "", "", "0X80046DB", "0X80046DB", 0, 0, "", "", "", "");
      continue;
      if (this.jdField_b_of_type_Int == 3000) {
        ReportController.b(null, "CliOper", "", "", "Multi_call", "Clk_icon_chatmember", 0, 0, "", "", "", "");
      }
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366130));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366136));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366135));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366140));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131366132));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = ((MultiMembersAudioUI)findViewById(2131366134));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, true);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setOnItemClickListener(this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366137));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131366141));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131366139));
    this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366133));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131366131));
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label568;
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      }
      if (this.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI = new MultiVideoEnterPageMembersControlUI[2];
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0] = new MultiVideoEnterPageMembersControlUI(this);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0], localLayoutParams);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].a(MultiVideoEnterPageMembersControlUI.jdField_c_of_type_Int);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].setLowHeightMode();
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new jxn(this));
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1] = new MultiVideoEnterPageMembersControlUI(this);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1], localLayoutParams);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].a(MultiVideoEnterPageMembersControlUI.jdField_d_of_type_Int);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].setLowHeightMode();
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new jxo(this));
      UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, getResources().getString(2131428914));
      if (this.jdField_b_of_type_Int != 3000) {
        break label646;
      }
      UITools.a(this.jdField_a_of_type_AndroidWidgetButton, getResources().getString(2131428937));
    }
    label568:
    while (this.jdField_b_of_type_Int != 1)
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetButton == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break;
    }
    label646:
    UITools.a(this.jdField_a_of_type_AndroidWidgetButton, getResources().getString(2131428936), this.f);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 10);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 2);
    }
    while (this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, paramInt)) {
      return;
    }
    QQToast.a(a(this), "通话已结束", 1).b(a(this).getDimensionPixelSize(2131558448));
    a(this);
  }
  
  boolean a()
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->can not get intent");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              AudioHelper.a(this.jdField_a_of_type_JavaLangString + ".processExtraData", localIntent.getExtras(), true);
              this.jdField_a_of_type_ArrayOfLong = localIntent.getLongArrayExtra("DiscussUinList");
              this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("creator_nick");
              this.jdField_a_of_type_Int = localIntent.getIntExtra("sessionType", -1);
              if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->get the wrong sessionType,Type=" + this.jdField_a_of_type_Int);
            return false;
            this.jdField_d_of_type_Int = localIntent.getIntExtra("Type", -1);
            if (this.jdField_d_of_type_Int == 3) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->get the wrong GAudioStatus,Type=" + this.jdField_d_of_type_Int);
          return false;
          this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("uin");
          this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("GroupId");
          if (this.jdField_b_of_type_JavaLangString != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->can not get the groupuin");
        return false;
        this.jdField_a_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
        if (this.jdField_a_of_type_Long != 0L) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->can not get the groupuin");
      return false;
      int m = localIntent.getIntExtra("MultiAVType", 0);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Get Intent AVType : " + m);
      }
      this.f = m;
      this.jdField_b_of_type_Int = localIntent.getIntExtra("uinType", -1);
      if (this.jdField_b_of_type_Int == 3000) {}
      for (this.jdField_c_of_type_Int = 2;; this.jdField_c_of_type_Int = 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().W = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a().X = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a().Y = false;
        this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("flag", false);
        return true;
        if (this.jdField_b_of_type_Int != 1) {
          break;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->can not get uin Type.");
    return false;
  }
  
  public void b()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 25);
    localIntent.putExtra("relationId", this.jdField_a_of_type_Long);
    localIntent.putExtra("relationType", this.jdField_c_of_type_Int);
    localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvVideoController.a().D);
    localIntent.putExtra("reason", 5);
    localIntent.putExtra("from", "MultiVideoEnterPageActivity");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    super.sendBroadcast(localIntent);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setNetTips-->type=" + paramInt);
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new jxw(this);
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_JavaLangRunnable);
      switch (paramInt)
      {
      default: 
        paramInt = -1;
      }
      while (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null)
      {
        MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
        int n = arrayOfMultiVideoEnterPageMembersControlUI.length;
        int m = 0;
        while (m < n)
        {
          MultiVideoEnterPageMembersControlUI localMultiVideoEnterPageMembersControlUI = arrayOfMultiVideoEnterPageMembersControlUI[m];
          if (paramInt != -1)
          {
            localMultiVideoEnterPageMembersControlUI.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt);
            localMultiVideoEnterPageMembersControlUI.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          }
          m += 1;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jxq(this), 1000L);
        paramInt = -1;
        continue;
        paramInt = 2131428864;
        continue;
        paramInt = 2131428863;
      }
    } while (paramInt == -1);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public void c()
  {
    int m = NetworkUtil.a(super.getApplicationContext());
    if (NetworkUtil.f(super.getApplicationContext())) {
      m = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "setNetTips,netinfo=" + m);
    }
    switch (m)
    {
    default: 
      m = -1;
    }
    while (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null)
    {
      MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
      int i1 = arrayOfMultiVideoEnterPageMembersControlUI.length;
      int n = 0;
      while (n < i1)
      {
        MultiVideoEnterPageMembersControlUI localMultiVideoEnterPageMembersControlUI = arrayOfMultiVideoEnterPageMembersControlUI[n];
        if (m != -1) {
          localMultiVideoEnterPageMembersControlUI.jdField_c_of_type_AndroidWidgetTextView.setText(m);
        }
        localMultiVideoEnterPageMembersControlUI.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        n += 1;
      }
      m = 2131429110;
      continue;
      m = 2131429111;
      continue;
      m = 2131428696;
      continue;
      m = -1;
    }
    if (m != -1) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(m);
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onEnterButtonClick --> AVType = " + paramInt);
    }
    d(paramInt);
    if (this.jdField_b_of_type_Int == 1) {
      if (paramInt == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005935", "0X8005935", 0, 0, "", "", "", "");
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().Y) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().W)) {
          break label235;
        }
        ReportController.b(null, "CliOper", "", "", "0X800667F", "0X800667F", 0, 0, "", "", "", "");
      }
    }
    label235:
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().X) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().W))
    {
      return;
      ReportController.b(null, "CliOper", "", "", "0X80046DC", "0X80046DC", 0, 0, "", "", "", "");
      break;
      if (this.jdField_b_of_type_Int != 3000) {
        break;
      }
      if (this.jdField_e_of_type_Int <= 0)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005577", "0X8005577", 0, 0, "", "", "", "");
        break;
      }
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Clk_join_chatmember", 0, 0, "", "", "", "");
      break;
    }
    ReportController.b(null, "CliOper", "", "", "0X8006418", "0X8006418", 0, 0, "", "", "", "");
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "quitGAudioChatDialog");
    }
    jxs localjxs1 = new jxs(this, 0);
    jxs localjxs2 = new jxs(this, 1);
    DialogUtil.b(this, 230, null, super.getResources().getString(2131428983), 2131428675, 2131429053, localjxs1, localjxs2).show();
  }
  
  void d(int paramInt)
  {
    if (!NetworkUtil.d(super.getApplicationContext()))
    {
      QQToast.a(super.getApplicationContext(), 2131433103, 1).b(super.getResources().getDimensionPixelSize(2131558448));
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().g > 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().g < 7))
    {
      QQToast.a(super.getApplicationContext(), 2131428992, 1).b(super.getResources().getDimensionPixelSize(2131558448));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "BtnOnClick-->Enter MultiVideoChat-->GroupId = " + this.jdField_a_of_type_Long + " isInMultiVideoChat = " + this.jdField_a_of_type_ComTencentAvVideoController.e + " MultiVideoRoomId=" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.f = paramInt;
    }
    if (((this.jdField_a_of_type_ComTencentAvVideoController.e) && (this.jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentAvVideoController.l()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e()))
    {
      d();
      return;
    }
    e(paramInt);
  }
  
  @TargetApi(9)
  public void e(int paramInt)
  {
    int m = paramInt;
    if (paramInt == 0) {
      m = this.jdField_a_of_type_ComTencentAvVideoController.a().D;
    }
    paramInt = m;
    if (this.jdField_b_of_type_Int == 3000)
    {
      paramInt = m;
      if (!this.jdField_a_of_type_Boolean) {
        paramInt = 1;
      }
    }
    Intent localIntent;
    if (paramInt == 2)
    {
      localIntent = new Intent(this, JumpActivity.class);
      localIntent.setData(Uri.parse("mqqapi://gvideo/open_plugin?src_type=app"));
    }
    for (;;)
    {
      localIntent.addFlags(262144);
      localIntent.addFlags(268435456);
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("GroupId", String.valueOf(this.jdField_a_of_type_Long));
      localIntent.putExtra("Type", 1);
      localIntent.putExtra("DiscussUinList", this.jdField_a_of_type_ArrayOfLong);
      localIntent.putExtra("MultiAVType", paramInt);
      localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Long));
      localIntent.putExtra("uinType", this.jdField_b_of_type_Int);
      localIntent.putExtra("graySwitch", super.getIntent().getIntExtra("graySwitch", 0));
      localIntent.putExtra("ltMultiMembership", super.getIntent().getIntExtra("ltMultiMembership", 5));
      localIntent.putExtra("multiPstnAutoTranTime", super.getIntent().getIntExtra("multiPstnAutoTranTime", 100000));
      localIntent.putExtra("multiPstnMissDelayTime", super.getIntent().getIntExtra("multiPstnMissDelayTime", 20));
      localIntent.putExtra("multiPstnMissShowTime", super.getIntent().getIntExtra("multiPstnMissShowTime", 60));
      localIntent.putExtra("ConfAppID", this.h);
      localIntent.putExtra("MeetingConfID", this.i);
      localIntent.putExtra("ipPstnEnterType", 2);
      super.startActivity(localIntent);
      super.finish();
      if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
        this.jdField_a_of_type_ComTencentAvVideoController.d(1010);
      }
      return;
      localIntent = new Intent(this, AVActivity.class);
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2130969322);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    if (Build.VERSION.SDK_INT >= 19) {
      super.getWindow().addFlags(67108864);
    }
    if (ImmersiveUtils.a()) {
      ImmersiveUtils.a(getWindow(), true);
    }
    try
    {
      super.getWindow().addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "onCreate-->can not get the VideoAppInterface");
        }
        super.finish();
        return;
      }
    }
    catch (NoSuchFieldException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Not exist FLAG_NEEDS_MENU_KEY field,Info=" + paramBundle.getMessage());
        }
      }
    }
    catch (IllegalAccessException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Could not access FLAG_NEEDS_MENU_KEY,info=" + paramBundle.getMessage());
        }
      }
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "onCreate-->can not get the VideoController");
        }
        super.finish();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "can not processExtraData");
        }
        super.finish();
        return;
      }
      this.jdField_a_of_type_Jxx = new jxx(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jxx, 15000L);
      a();
      ReportController.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      if (this.jdField_c_of_type_JavaLangRunnable == null) {
        this.jdField_c_of_type_JavaLangRunnable = new jxu(this);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_c_of_type_JavaLangRunnable);
      QAVGroupConfig.Report.b();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jxx);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.q = false;
      }
      this.jdField_c_of_type_JavaLangRunnable = null;
      this.jdField_b_of_type_JavaLangRunnable = null;
      this.jdField_a_of_type_JavaLangRunnable = null;
      this.jdField_a_of_type_Jxx = null;
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      this.jdField_d_of_type_AndroidWidgetTextView = null;
      this.jdField_e_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_AndroidWidgetProgressBar = null;
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
      this.jdField_a_of_type_AndroidWidgetButton = null;
      this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_c_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_ComTencentAvVideoController = null;
      this.jdField_a_of_type_Jxx = null;
      this.jdField_b_of_type_JavaLangRunnable = null;
      return;
      AVLog.e(this.jdField_a_of_type_JavaLangString, "mApp == null");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onResume, mRelationType[" + this.jdField_c_of_type_Int + "], mRelationId[" + this.jdField_a_of_type_Long + "], multiAVType[" + this.jdField_a_of_type_ComTencentAvVideoController.a().D + "], currentAvtype[" + this.f + "]");
      a(this.f);
    }
    if (this.jdField_b_of_type_JavaLangRunnable == null) {
      this.jdField_b_of_type_JavaLangRunnable = new jxv(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2000L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity
 * JD-Core Version:    0.7.0.1
 */