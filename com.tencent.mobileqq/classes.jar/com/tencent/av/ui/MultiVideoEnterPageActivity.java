package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.ConfIdownloadTask;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class MultiVideoEnterPageActivity
  extends BaseActivity
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new MultiVideoEnterPageActivity.5(this);
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new MultiVideoEnterPageActivity.MyVideoObserver(this);
  MultiMembersAudioUI jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
  MultiVideoEnterPageActivity.MainUI jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI = new MultiVideoEnterPageActivity.MainUI();
  MultiVideoEnterPageActivity.TimeoutRunnable jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable = null;
  MultiVideoMembersClickListener jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = new MultiVideoEnterPageActivity.1(this);
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  final String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  long[] jdField_a_of_type_ArrayOfLong = null;
  MultiVideoEnterPageMembersControlUI[] jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI = null;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  String jdField_c_of_type_JavaLangString = null;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  int i = 0;
  final int j = 0;
  final int k = 1;
  
  public MultiVideoEnterPageActivity()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiVideoEnterPageActivity_");
    localStringBuilder.append(QQAudioHelper.b());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  private void a(int paramInt, String paramString)
  {
    if ((paramInt == 3000) && (QAVHrMeeting.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_JavaLangString))))
    {
      ChatActivityUtils.ConfIdownloadTask.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, new MultiVideoEnterPageActivity.9(this));
      paramInt = 1;
    }
    else
    {
      paramInt = 0;
    }
    if (paramInt == 0) {
      d(10);
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b())
    {
      DataReport.e(false, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startMultipVideo phone is calling!");
      }
      String str = getResources().getString(2131695445);
      DialogUtil.a(this, 230, getResources().getString(2131695691), str, 2131690728, 2131694583, new MultiVideoEnterPageActivity.10(this), null).show();
      return true;
    }
    return false;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_b_of_type_Boolean == true)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_b_of_type_Boolean = false;
      VideoNodeManager.e();
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    int m = paramView.getId();
    if (m != 2131373399)
    {
      if (m != 2131373406)
      {
        if (m != 2131373503) {
          return;
        }
        e();
        m = this.jdField_b_of_type_Int;
        if (m == 1)
        {
          if (this.f == 10) {
            ReportController.b(null, "CliOper", "", "", "0X8005934", "0X8005934", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X80046DB", "0X80046DB", 0, 0, "", "", "", "");
          }
        }
        else if (m == 3000) {
          ReportController.b(null, "CliOper", "", "", "Multi_call", "Clk_icon_chatmember", 0, 0, "", "", "", "");
        }
        finish();
        super.overridePendingTransition(0, 2130772191);
        return;
      }
      if (c()) {
        return;
      }
      QAVGroupConfig.Report.c();
      a(this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString);
      return;
    }
    a(paramView);
  }
  
  void a()
  {
    Object localObject;
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
    {
      findViewById(2131373529).setBackgroundColor(Color.parseColor("#181818"));
      localObject = getResources().getDrawable(2130842257);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      ((TextView)findViewById(2131373503)).setCompoundDrawables((Drawable)localObject, null, null, null);
      ((TextView)findViewById(2131373503)).setCompoundDrawablePadding(0);
      ((TextView)findViewById(2131373503)).setTextColor(Color.parseColor("#737373"));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373405));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = ((MultiMembersAudioUI)findViewById(2131366270));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setIsEnterpage(true);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, true);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setOnItemClickListener(this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373403));
    this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131366269));
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.a(this);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
    {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#757575"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#737373"));
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_b_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130842323));
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFF"));
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130842325));
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.a(4);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI = new MultiVideoEnterPageMembersControlUI[2];
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0] = new MultiVideoEnterPageMembersControlUI(this);
        localObject = new LinearLayout.LayoutParams(-1, -1, 1.0F);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0], (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, true);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].a(MultiVideoEnterPageMembersControlUI.jdField_c_of_type_Int);
        localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
        localObject[0].jdField_b_of_type_Boolean = true;
        localObject[0].jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].setLowHeightMode();
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new MultiVideoEnterPageActivity.2(this));
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1] = new MultiVideoEnterPageMembersControlUI(this);
        localObject = new LinearLayout.LayoutParams(-1, -1, 1.0F);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1], (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, true);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].a(MultiVideoEnterPageMembersControlUI.jdField_d_of_type_Int);
        localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
        localObject[1].jdField_b_of_type_Boolean = true;
        localObject[1].jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new MultiVideoEnterPageActivity.3(this));
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new MultiVideoEnterPageActivity.4(this));
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.a(0);
        this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
      }
      a(false);
      if ((this.jdField_b_of_type_Int == 1) && (this.f == 2)) {
        UITools.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_a_of_type_AndroidWidgetButton, getResources().getString(2131693106), this.f);
      }
    }
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 10);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 2);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, paramInt))
    {
      QQToast.a(this, HardCodeUtil.a(2131707054), 1).b(a(this).getDimensionPixelSize(2131299168));
      finish();
    }
  }
  
  void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramArrayList == null)
    {
      paramArrayList = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUserListALLUpdate, simpleData is null, flag[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramArrayList, 1, ((StringBuilder)localObject).toString());
      if (!this.jdField_a_of_type_Boolean)
      {
        b();
        finish();
      }
      return;
    }
    if ((paramInt1 != 2) && (paramInt1 != 10) && (paramInt1 != 12)) {
      this.e = paramInt2;
    } else {
      this.e = paramArrayList.size();
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUserListALLUpdate, flag[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], groupId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], userCount[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], simpleData[");
    localStringBuilder.append(paramArrayList.size());
    localStringBuilder.append("], mMemberCount[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], multiAVType[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.e == 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        paramArrayList = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
        if ((paramArrayList != null) && (paramArrayList.length == 2))
        {
          if (paramInt1 == 2)
          {
            paramArrayList[0].jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_c_of_type_AndroidWidgetTextView.setText(2131695683);
            this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
          else if (paramInt1 == 10)
          {
            paramArrayList[1].jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_c_of_type_AndroidWidgetTextView.setText(2131695684);
            this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_a_of_type_AndroidWidgetButton.setText(2131695543);
        }
        return;
      }
      b();
      finish();
      return;
    }
    if (paramInt1 == 10)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
      if ((localObject != null) && (localObject.length > 1))
      {
        localObject[1].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].a(paramArrayList);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
          if (localObject[0] != null) {
            localObject[0].jdField_b_of_type_AndroidViewView.setVisibility(0);
          }
        }
        a(true);
        break label606;
      }
    }
    localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject[0].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].setVisibility(0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].a(paramArrayList);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
    }
    label606:
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(0);
    paramArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList.size(), paramArrayList);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramArrayList);
    paramArrayList = String.format(super.getResources().getString(2131695681), new Object[] { Integer.valueOf(this.e) });
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_b_of_type_AndroidWidgetTextView.setText(paramArrayList);
    c();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable);
  }
  
  void a(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this, 2131694395, 1).b(super.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", String.valueOf(this.jdField_a_of_type_Long));
    localBundle = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6, 0, 0, localBundle, null);
    if (localBundle == null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "closeGAudio, rsp is null");
      paramView.setVisibility(8);
      return;
    }
    boolean bool2 = localBundle.getBoolean("isAdmin");
    boolean bool1 = localBundle.getBoolean("isOwner");
    if (1 == QQAudioHelper.a(7))
    {
      QQAudioHelper.a(HardCodeUtil.a(2131707052));
      bool1 = true;
    }
    if ((!bool2) && (!bool1))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "closeGAudio, 没有权限");
      paramView.setVisibility(8);
      QQToast.a(super.getApplicationContext(), 2131693105, 1).a();
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8009E29", "0X8009E29", 0, 0, "", "", "", "");
    MultiVideoEnterPageActivity.AutoHideQQCustomDialog.a(this, 230, getResources().getString(2131695502), getResources().getString(2131693102), 2131695421, 2131720247, new MultiVideoEnterPageActivity.7(this, paramView), new MultiVideoEnterPageActivity.8(this)).show();
  }
  
  void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Int != 1) {
      return;
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("uin", String.valueOf(this.jdField_a_of_type_Long));
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6, 0, 0, (Bundle)localObject, null);
    }
    else
    {
      localObject = getIntent().getBundleExtra("groupInfo");
    }
    if (localObject == null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setCloseBtn, rsp is null");
      return;
    }
    boolean bool = ((Bundle)localObject).getBoolean("isAdmin");
    paramBoolean = ((Bundle)localObject).getBoolean("isOwner");
    if (1 == QQAudioHelper.a(7))
    {
      QQAudioHelper.a(HardCodeUtil.a(2131707057));
      paramBoolean = true;
    }
    if ((bool) || (paramBoolean)) {
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
        if ((localObject != null) && (localObject.length > 1) && (localObject[1] != null)) {
          localObject[1].jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        }
      }
      else
      {
        int m = (ImmersiveUtils.getScreenWidth() - AIOUtils.b(12.0F, getResources()) * 2 - AIOUtils.b(11.0F, getResources())) / 2;
        if (m < AIOUtils.b(170.0F, getResources()))
        {
          localObject = this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_b_of_type_AndroidWidgetButton.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).width = m;
          this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_b_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
          localObject = this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).width = m;
          this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_a_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_b_of_type_AndroidWidgetButton.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
        this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      }
    }
  }
  
  boolean a()
  {
    Object localObject1 = super.getIntent();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->can not get intent");
      }
      return false;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(".processExtraData");
    QQAudioHelper.a(((StringBuilder)localObject2).toString(), ((Intent)localObject1).getExtras(), true);
    this.jdField_b_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("openClass", false);
    this.jdField_a_of_type_ArrayOfLong = ((Intent)localObject1).getLongArrayExtra("DiscussUinList");
    this.jdField_d_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("creator_nick");
    this.jdField_a_of_type_Int = ((Intent)localObject1).getIntExtra("sessionType", 0);
    int m = this.jdField_a_of_type_Int;
    if ((m != 3) && (m != 4))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("processExtraData-->get the wrong sessionType,Type=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    this.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("Type", -1);
    if (this.jdField_d_of_type_Int != 3)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("processExtraData-->get the wrong GAudioStatus,Type=");
        ((StringBuilder)localObject2).append(this.jdField_d_of_type_Int);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    this.jdField_c_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("GroupId");
    localObject2 = this.jdField_b_of_type_JavaLangString;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->can not get the groupuin");
      }
      return false;
    }
    this.jdField_a_of_type_Long = Long.valueOf((String)localObject2).longValue();
    if (this.jdField_a_of_type_Long == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->can not get the groupuin");
      }
      return false;
    }
    m = ((Intent)localObject1).getIntExtra("MultiAVType", 0);
    if (QLog.isColorLevel())
    {
      localObject2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get Intent AVType : ");
      localStringBuilder.append(m);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    this.f = m;
    this.jdField_b_of_type_Int = ((Intent)localObject1).getIntExtra("uinType", -1);
    m = this.jdField_b_of_type_Int;
    if (m == 3000)
    {
      this.jdField_c_of_type_Int = 2;
    }
    else
    {
      if (m != 1) {
        break label445;
      }
      this.jdField_c_of_type_Int = 1;
    }
    this.jdField_a_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("flag", false);
    return true;
    label445:
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->can not get uin Type.");
    }
    return false;
  }
  
  void b()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 25);
    localIntent.putExtra("relationId", this.jdField_a_of_type_Long);
    localIntent.putExtra("openClass", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("relationType", this.jdField_c_of_type_Int);
    localIntent.putExtra("MultiAVType", this.f);
    localIntent.putExtra("reason", 5);
    localIntent.putExtra("from", "MultiVideoEnterPageActivity");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    super.sendBroadcast(localIntent);
  }
  
  void b(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
      if ((arrayOfMultiVideoEnterPageMembersControlUI != null) && (arrayOfMultiVideoEnterPageMembersControlUI.length == 2) && (paramInt == 10))
      {
        arrayOfMultiVideoEnterPageMembersControlUI[1].setVisibility(4);
        arrayOfMultiVideoEnterPageMembersControlUI = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
        if (arrayOfMultiVideoEnterPageMembersControlUI[0] != null) {
          arrayOfMultiVideoEnterPageMembersControlUI[0].jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        b();
      }
    }
    else
    {
      b();
      finish();
    }
  }
  
  public boolean b()
  {
    if ((Build.VERSION.SDK_INT >= 17) && (super.isDestroyed())) {
      return true;
    }
    return isFinishing();
  }
  
  void c()
  {
    int m = NetworkUtil.getSystemNetwork(this);
    if (NetworkUtil.isBluetoothSharedNetwork(this)) {
      m = 1;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNetTips,netinfo=");
      localStringBuilder.append(m);
      QLog.e((String)localObject, 2, localStringBuilder.toString());
    }
    if (m != 0) {
      if (m != 1)
      {
        if (m != 2)
        {
          if ((m == 3) || (m == 4))
          {
            m = 2131695539;
            break label112;
          }
        }
        else
        {
          m = 2131695540;
          break label112;
        }
      }
      else
      {
        m = 2131720224;
        break label112;
      }
    }
    m = -1;
    label112:
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
    if (localObject != null)
    {
      int i1 = localObject.length;
      int n = 0;
      while (n < i1)
      {
        localStringBuilder = localObject[n];
        if (m != -1) {
          localStringBuilder.jdField_c_of_type_AndroidWidgetTextView.setText(m);
        }
        localStringBuilder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        n += 1;
      }
    }
    if (m != -1) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(m);
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  void c(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNetTips-->type=");
      localStringBuilder.append(paramInt);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new MultiVideoEnterPageActivity.RemoveTipsRunnale(this);
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      if (((VideoAppInterface)localObject).a() == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_JavaLangRunnable);
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2)
          {
            paramInt = 2131695947;
            break label157;
          }
        }
        else
        {
          paramInt = 2131695949;
          break label157;
        }
      }
      else {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoEnterPageActivity.6(this), 1000L);
      }
      paramInt = -1;
      label157:
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
      if (localObject != null)
      {
        int n = localObject.length;
        int m = 0;
        while (m < n)
        {
          localStringBuilder = localObject[m];
          if (paramInt != -1)
          {
            localStringBuilder.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt);
            localStringBuilder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          }
          m += 1;
        }
      }
      if (paramInt != -1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
    }
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "quitGAudioChatDialog");
    }
    MultiVideoEnterPageActivity.DialogInterfaceOnClickListener localDialogInterfaceOnClickListener1 = new MultiVideoEnterPageActivity.DialogInterfaceOnClickListener(this, 0);
    MultiVideoEnterPageActivity.DialogInterfaceOnClickListener localDialogInterfaceOnClickListener2 = new MultiVideoEnterPageActivity.DialogInterfaceOnClickListener(this, 1);
    MultiVideoEnterPageActivity.AutoHideQQCustomDialog.a(this, 230, null, super.getResources().getString(2131695517), 2131720199, 2131695433, localDialogInterfaceOnClickListener1, localDialogInterfaceOnClickListener2).show();
  }
  
  void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterButtonClick --> AVType = ");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    e(paramInt);
    int m = this.jdField_b_of_type_Int;
    if (m == 1)
    {
      if (paramInt == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005935", "0X8005935", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80046DC", "0X80046DC", 0, 0, "", "", "", "");
      return;
    }
    if (m == 3000)
    {
      if (this.e <= 0)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005577", "0X8005577", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Clk_join_chatmember", 0, 0, "", "", "", "");
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  void e(int paramInt)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this, 2131694395, 1).b(super.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().f > 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f < 7))
    {
      QQToast.a(this, 2131695889, 1).b(super.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClickEnterMultiVideoChat, mRelationId[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], mGAudioInRoom[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.d);
    localStringBuilder.append("], mGAudioGroupId[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
    localStringBuilder.append("], mHaveMoreRoom[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], avtype[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], currentAvtype[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (((this.jdField_a_of_type_ComTencentAvVideoController.d) && (this.jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d()))
    {
      d();
      return;
    }
    f(paramInt);
  }
  
  @TargetApi(9)
  void f(int paramInt)
  {
    int m = paramInt;
    if (paramInt == 0) {
      m = this.jdField_a_of_type_ComTencentAvVideoController.a().j;
    }
    paramInt = m;
    if (this.jdField_b_of_type_Int == 3000)
    {
      paramInt = m;
      if (!this.jdField_a_of_type_Boolean) {
        paramInt = 1;
      }
    }
    if (paramInt == 2)
    {
      localObject = new Intent(this, JumpActivity.class);
      ((Intent)localObject).setData(Uri.parse("mqqapi://gvideo/open_plugin?src_type=app"));
    }
    else
    {
      localObject = new Intent(this, AVActivity.class);
    }
    ((Intent)localObject).addFlags(262144);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("sessionType", 3);
    ((Intent)localObject).putExtra("GroupId", String.valueOf(this.jdField_a_of_type_Long));
    ((Intent)localObject).putExtra("Type", 1);
    ((Intent)localObject).putExtra("DiscussUinList", this.jdField_a_of_type_ArrayOfLong);
    ((Intent)localObject).putExtra("MultiAVType", paramInt);
    ((Intent)localObject).putExtra("uin", String.valueOf(this.jdField_a_of_type_Long));
    ((Intent)localObject).putExtra("uinType", this.jdField_b_of_type_Int);
    ((Intent)localObject).putExtra("ConfAppID", this.h);
    ((Intent)localObject).putExtra("MeetingConfID", this.i);
    super.startActivity((Intent)localObject);
    finish();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject != null) {
      ((VideoController)localObject).a(SessionMgr.a(this.jdField_c_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]), this.jdField_a_of_type_Int, false, false, false);
    }
    if (paramInt == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentAvVideoController;
      if (localObject != null) {
        ((VideoController)localObject).d(1010);
      }
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    e();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131559727);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    AVActivity.a(getWindow(), true);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    AVActivity.a(super.getWindow());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    paramBundle = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "onCreate-->can not get the VideoAppInterface");
      }
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = paramBundle.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "onCreate-->can not get the VideoController");
      }
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "can not processExtraData");
      }
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable = new MultiVideoEnterPageActivity.TimeoutRunnable(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable, 15000L);
    a();
    ReportController.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    if (this.jdField_c_of_type_JavaLangRunnable == null) {
      this.jdField_c_of_type_JavaLangRunnable = new MultiVideoEnterPageActivity.RefreshDisplayNameRunnable(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_c_of_type_JavaLangRunnable);
    QAVGroupConfig.Report.b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localVideoController != null) {
      localVideoController.l = false;
    }
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.a();
    AVUtil.a(this);
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume, mRelationType[");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append("], mRelationId[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("], multiAVType[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().j);
      localStringBuilder.append("], currentAvtype[");
      localStringBuilder.append(this.f);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      a(this.f);
    }
    if (this.jdField_b_of_type_JavaLangRunnable == null) {
      this.jdField_b_of_type_JavaLangRunnable = new MultiVideoEnterPageActivity.RefreshFaceRunnable(this);
    } else {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity
 * JD-Core Version:    0.7.0.1
 */