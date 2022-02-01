package com.tencent.mobileqq.activity;

import Override;
import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import adjz;
import adka;
import adkb;
import adkc;
import adkd;
import adke;
import adkf;
import adkg;
import adkh;
import adki;
import adkj;
import adkk;
import adkl;
import adkm;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvi;
import anzc;
import aodi;
import aodj;
import aslf;
import aslh;
import asll;
import avpm;
import avpp;
import avpu;
import avql;
import avqm;
import bcvh;
import bdla;
import bhhr;
import bhid;
import bisl;
import bkzi;
import bkzz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class AuthDevActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler = new adjz(this);
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new adkf(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anvi jdField_a_of_type_Anvi = new adkk(this);
  private aodj jdField_a_of_type_Aodj = new adkb(this);
  private bisl jdField_a_of_type_Bisl;
  private bkzi jdField_a_of_type_Bkzi;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FaceSecureCheck.SecureCheckResponse jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse;
  private String jdField_a_of_type_JavaLangString = "";
  private List<SvcDevLoginInfo> jdField_a_of_type_JavaUtilList;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new adkl(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private oidb_0x5e1.RspBody jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody;
  private boolean jdField_a_of_type_Boolean;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bkzi jdField_b_of_type_Bkzi;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_b_of_type_JavaLangString;
  private List<SvcDevLoginInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_c_of_type_JavaLangString;
  private List<SvcDevLoginInfo> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = true;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  
  private Dialog a()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131755829);
    localReportDialog.setContentView(2131559019);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365648);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131692000));
    }
    localTextView1 = (TextView)localReportDialog.findViewById(2131365644);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131691997));
    }
    localTextView1 = (TextView)localReportDialog.findViewById(2131365633);
    if (localTextView1 != null) {
      localTextView1.setText(2131691998);
    }
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365639);
    if (localTextView2 != null) {
      localTextView2.setText(2131691999);
    }
    if (localTextView1 != null) {
      localTextView1.setOnClickListener(new adkm(this));
    }
    if (localTextView2 != null) {
      localTextView2.setOnClickListener(new adka(this));
    }
    return localReportDialog;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody != null) && (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.size() != 0))
    {
      ((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.set(paramInt);
      FormSimpleItem localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (paramInt == 1) {}
      for (Object localObject = getString(2131692088);; localObject = getString(2131692093))
      {
        localFormSimpleItem.setRightText((CharSequence)localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("faceStateKey", String.valueOf(paramInt));
        setResult(-1, (Intent)localObject);
        return;
      }
    }
    QLog.e("Q.devlock.AuthDevActivity", 1, "refreshUserFaceState mFAceStateRsp is null or rpt_msg_uin_data is empty");
  }
  
  private void a(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131694210);
    }
    this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this, null));
    if (paramBoolean1) {}
    for (paramString1 = getString(2131691957, new Object[] { str });; paramString1 = getString(2131691955, new Object[] { str }))
    {
      this.jdField_a_of_type_Bkzi.a(paramString1);
      this.jdField_a_of_type_Bkzi.a(getResources().getString(2131691954), 3, false);
      this.jdField_a_of_type_Bkzi.c(2131690697);
      this.jdField_a_of_type_Bkzi.a(new adkj(this, paramString2, paramArrayList, paramInt, paramBoolean2, paramLong));
      this.jdField_a_of_type_Bkzi.show();
      return;
    }
  }
  
  private void a(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, byte[] paramArrayOfByte, boolean paramBoolean3, SvcDevLoginInfo paramSvcDevLoginInfo)
  {
    this.jdField_b_of_type_Bkzi = ((bkzi)bkzz.a(this, null));
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131559181, this.jdField_b_of_type_Bkzi.a(), false);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131361982);
    boolean bool1 = Arrays.equals(NetConnInfoCenter.GUID, paramArrayOfByte);
    boolean bool2 = a(paramSvcDevLoginInfo);
    if (this.jdField_a_of_type_Boolean)
    {
      paramSvcDevLoginInfo = getString(2131691928);
      paramArrayOfByte = getString(2131691928);
      if (paramLong2 > 0L)
      {
        paramArrayOfByte = new Date(1000L * paramLong2);
        paramSvcDevLoginInfo = getString(2131691923, new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(paramArrayOfByte) });
        paramArrayOfByte = getString(2131691923, new Object[] { new SimpleDateFormat("yyyy年MM月dd日 HH点mm分", Locale.getDefault()).format(paramArrayOfByte) });
        if ((bool1) || (bool2)) {
          paramSvcDevLoginInfo = getString(2131691930);
        }
        localTextView.setText(paramSvcDevLoginInfo);
        if ((!bool1) && (!bool2)) {
          break label357;
        }
        paramArrayOfByte = getString(2131691930);
      }
      label357:
      for (;;)
      {
        localTextView.setContentDescription(paramArrayOfByte);
        this.jdField_b_of_type_Bkzi.a(localLinearLayout);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_Bkzi.a(getResources().getString(2131691993), 5, 0);
        }
        if ((!bool1) || (this.jdField_a_of_type_Boolean)) {
          this.jdField_b_of_type_Bkzi.a(getResources().getString(2131691453), 3, 1);
        }
        this.jdField_b_of_type_Bkzi.c(2131690697);
        this.jdField_b_of_type_Bkzi.a(new adki(this, paramString2, paramLong1, paramString1, paramInt, paramBoolean3, paramArrayList, paramBoolean1, paramBoolean2));
        this.jdField_b_of_type_Bkzi.show();
        return;
        QLog.e("Q.devlock.AuthDevActivity", 1, "format login time error: time <= 0");
        break;
      }
    }
    if (bool1) {}
    for (paramArrayOfByte = getString(2131691918);; paramArrayOfByte = getString(2131691956, new Object[] { paramString1 }))
    {
      localTextView.setText(paramArrayOfByte);
      break;
    }
  }
  
  private void a(List<SvcDevLoginInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
      if (localSvcDevLoginInfo == null)
      {
        i += 1;
      }
      else
      {
        View localView = getLayoutInflater().inflate(2131561094, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131369110);
        label127:
        TextView localTextView1;
        Object localObject1;
        if (j == 1)
        {
          localRelativeLayout.setBackgroundResource(2130839496);
          TextView localTextView2 = (TextView)localView.findViewById(2131371803);
          localTextView1 = (TextView)localView.findViewById(2131368819);
          Object localObject2 = localSvcDevLoginInfo.strDeviceName;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = getResources().getString(2131694210);
          }
          localObject2 = null;
          boolean bool1 = Arrays.equals(NetConnInfoCenter.GUID, localSvcDevLoginInfo.vecGuid);
          boolean bool2 = a(localSvcDevLoginInfo);
          if (bool1) {
            localObject2 = "（" + getResources().getString(2131694207) + "）";
          }
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localSpannableStringBuilder.append((CharSequence)localObject2);
            adkg localadkg = new adkg(this);
            int k = ((String)localObject1).length();
            localSpannableStringBuilder.setSpan(localadkg, k, ((String)localObject2).length() + k, 33);
          }
          localTextView2.setText(localSpannableStringBuilder);
          localObject1 = new StringBuilder();
          localObject2 = new StringBuilder();
          if (bool2) {
            ((StringBuilder)localObject2).append(getString(2131691929)).append(" ").append(localSvcDevLoginInfo.strDeviceName);
          }
          if ((localSvcDevLoginInfo.iLoginTime > 0L) && (!this.jdField_a_of_type_Boolean)) {
            ((StringBuilder)localObject1).append(bhid.a(localSvcDevLoginInfo.iLoginTime * 1000L, "yyyy-MM-dd "));
          }
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation)) {
            ((StringBuilder)localObject1).append(localSvcDevLoginInfo.strLoginLocation);
          }
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
          {
            if (((StringBuilder)localObject1).length() > 0) {
              ((StringBuilder)localObject1).append(" ");
            }
            ((StringBuilder)localObject1).append(localSvcDevLoginInfo.strDeviceTypeInfo);
          }
          if ((!bool2) || (this.jdField_a_of_type_Boolean)) {
            break label579;
          }
          localTextView1.setText(((StringBuilder)localObject2).toString());
        }
        for (;;)
        {
          localRelativeLayout.setClickable(true);
          localRelativeLayout.setTag(localSvcDevLoginInfo);
          localRelativeLayout.setOnClickListener(new adkh(this, paramList, localRelativeLayout, i, localSvcDevLoginInfo));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          break;
          if (i == 0)
          {
            localRelativeLayout.setBackgroundResource(2130839512);
            break label127;
          }
          if (i == j - 1)
          {
            localRelativeLayout.setBackgroundResource(2130839503);
            break label127;
          }
          localRelativeLayout.setBackgroundResource(2130839506);
          break label127;
          label579:
          if (((StringBuilder)localObject1).length() > 0) {
            localTextView1.setText(((StringBuilder)localObject1).toString());
          }
        }
      }
    }
    paramList = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {}
    for (i = 4;; i = 0)
    {
      paramList.setVisibility(i);
      return;
    }
  }
  
  private boolean a(SvcDevLoginInfo paramSvcDevLoginInfo)
  {
    if (paramSvcDevLoginInfo == null) {
      return false;
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (Arrays.equals(((SvcDevLoginInfo)localIterator.next()).vecGuid, paramSvcDevLoginInfo.vecGuid)) {
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    Object localObject = this.app.getHandler(LoginInfoActivity.class);
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        ((MqqHandler)localObject).obtainMessage(20140331, 1, 0).sendToTarget();
      }
    }
    else
    {
      if (aslf.a().a() != aslf.c) {
        break label131;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131691979));
      label82:
      if (!this.jdField_a_of_type_Boolean) {
        break label145;
      }
      localObject = (aodi)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
      if (localObject != null) {
        ((aodi)localObject).a();
      }
      g();
    }
    for (;;)
    {
      return;
      ((MqqHandler)localObject).obtainMessage(20140331, 0, 0).sendToTarget();
      break;
      label131:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_b_of_type_JavaLangString);
      break label82;
      label145:
      if ((this.jdField_d_of_type_Boolean) && ((asll.a().c()) || (this.jdField_e_of_type_Boolean))) {
        l();
      }
      while ("app_qq_safe_center".equals(this.jdField_f_of_type_JavaLangString))
      {
        if (this.jdField_b_of_type_AndroidAppDialog == null) {
          this.jdField_b_of_type_AndroidAppDialog = a();
        }
        this.jdField_b_of_type_AndroidAppDialog.show();
        return;
        if (this.jdField_f_of_type_Boolean) {
          f();
        } else {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
  }
  
  private void f()
  {
    boolean bool1 = asll.a().b(this.app, this.jdField_a_of_type_JavaLangString, 0L);
    boolean bool2 = asll.a().a(this.app, this.jdField_a_of_type_JavaLangString, 0L);
    if ((bool1) && (bool2))
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692001));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131691934));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onCreate getRecentLoginDevList failed recentLoginRet=", Boolean.valueOf(bool1), " loginDevRet=", Boolean.valueOf(bool2) });
  }
  
  private void g()
  {
    QLog.d("Q.devlock.AuthDevActivity", 1, "startGetAuthDevList.begin to getAuthLoginDevList");
    boolean bool = asll.a().c(this.app, this.jdField_a_of_type_JavaLangString, 0L);
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131691996));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131691935));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, "startGetAuthDevList getAuthLoginDevList failed ret =" + bool);
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AuthDevActivity.13(this));
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AuthDevActivity.14(this));
  }
  
  private void k()
  {
    bcvh.a(this.app, getCurrentAccountUin(), new adkd(this));
    if (!"secureStateOk".equals(this.jdField_e_of_type_JavaLangString)) {
      bcvh.a(this.app, getCurrentAccountUin(), new adke(this));
    }
  }
  
  private void l()
  {
    if (!NetworkUtil.isNetSupport(this)) {
      QQToast.a(this, getString(2131692125), 0).b(getTitleBarHeight());
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          bdla.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_close", 0, 0, "", "", "", "");
          bdla.b(null, "dc00898", "", "", "0X800A71C", "0X800A71C", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("DevRpt", 2, "登录保护页点击开关，关闭登录保护的用户数、次数！0X800A71C");
          }
          QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.begin to close dev lock");
          b();
          return;
        }
        QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.begin to CheckDevLockSms");
        localObject = (DevlockInfo)getIntent().getParcelableExtra("DevlockInfo");
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || ((localObject != null) && (((DevlockInfo)localObject).AllowSet == 0)))
        {
          Intent localIntent = new Intent(this, AuthDevOpenUgActivity.class);
          localIntent.putExtra("DevlockInfo", (Parcelable)localObject);
          startActivityForResult(localIntent, 0);
          return;
        }
        if (aslf.a().a() == aslf.c)
        {
          aslf.a().a(this, this.jdField_b_of_type_JavaLangString);
          return;
        }
        bdla.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "0", "", "", "");
        bdla.b(null, "dc00898", "", "", "0X800A71B", "0X800A71B", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "登录保护页点击开关，开启登录保护的用户数、次数！0X800A71B");
        }
        if (this.jdField_c_of_type_Boolean) {
          break;
        }
      } while ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing()));
      i();
      return;
      i();
      this.jdField_c_of_type_Boolean = false;
      Object localObject = this.app.getCurrentAccountUin();
      i = asll.a().a(this.app, (String)localObject, "", null, this.jdField_a_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    this.jdField_c_of_type_Boolean = true;
    j();
    QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.CheckDevLockSms fail ret=" + i);
    QQToast.a(getApplicationContext(), getString(2131691974), 0).b(getTitleBarHeight());
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    String str = this.app.getCurrentAccountUin();
    int i = asll.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + i);
      }
      e();
      QQToast.a(this, getString(2131694257), 0).a();
    }
  }
  
  void b()
  {
    c();
    ReportDialog localReportDialog = new ReportDialog(this, 2131755829);
    localReportDialog.setContentView(2131559019);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365648);
    if (localTextView != null) {
      localTextView.setText(getString(2131691942));
    }
    localTextView = (TextView)localReportDialog.findViewById(2131365644);
    if (localTextView != null)
    {
      localObject = (anzc)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if ((localObject != null) && (((anzc)localObject).h()) && (((anzc)localObject).b() == 1)) {}
      localTextView.setText(getString(2131691941));
    }
    localTextView = (TextView)localReportDialog.findViewById(2131365633);
    if (localTextView != null) {
      localTextView.setText(2131690845);
    }
    Object localObject = (TextView)localReportDialog.findViewById(2131365639);
    if (localObject != null) {
      ((TextView)localObject).setText(2131690697);
    }
    localReportDialog.setOnDismissListener(new adkc(this));
    if (localTextView != null) {
      localTextView.setOnClickListener(this);
    }
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidAppDialog = localReportDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  void c()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
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
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(true);
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("from_risk_hint", false))
    {
      getIntent().removeExtra("from_risk_hint");
      Intent localIntent = new Intent(this, LoginInfoActivity.class);
      localIntent.putExtra("from_risk_hint", true);
      startActivity(localIntent);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1003) {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null) {
          break label28;
        }
      }
    }
    label28:
    label416:
    for (;;)
    {
      return;
      paramInt1 = paramIntent.getInt("resultState", 1);
      if (paramInt1 == 2) {
        aslf.a().a(aslf.d);
      }
      while (paramInt1 != 1)
      {
        this.jdField_b_of_type_JavaLangString = paramIntent.getString("resultMobileMask");
        if (paramInt1 != 2) {
          break label108;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_b_of_type_JavaLangString);
        return;
        if (paramInt1 == 3)
        {
          aslf.a().a(aslf.c);
          aslf.a().a(0L);
        }
      }
      continue;
      label108:
      if (paramInt1 == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131691979));
        return;
        boolean bool1;
        if ((paramInt1 == 11) || (paramInt1 == 21))
        {
          QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, resultCode is ", Integer.valueOf(paramInt2) });
          if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_face_scan_result", false)))
          {
            a(1);
            return;
          }
          if (paramIntent == null) {}
          for (bool1 = true;; bool1 = false)
          {
            QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, data == null ? ", Boolean.valueOf(bool1) });
            if (paramIntent == null) {
              break;
            }
            QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, KEY_FACE_SCAN_RESULT is ", Boolean.valueOf(paramIntent.getBooleanExtra("key_face_scan_result", false)) });
            return;
          }
        }
        if (paramInt1 == 12)
        {
          if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_face_scan_result", false)))
          {
            a(0);
            QQToast.a(this, getString(2131691962), 0).a();
          }
        }
        else if (paramInt1 == 0)
        {
          QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode is 0, resultCode is : ", Integer.valueOf(paramInt2) });
          if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null))
          {
            paramIntent = paramIntent.getExtras();
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
            {
              bool1 = true;
              label382:
              boolean bool2 = paramIntent.getBoolean("auth_dev_open", bool1);
              String str = paramIntent.getString("phone_num");
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1) {
                break label627;
              }
              bool1 = true;
              boolean bool3 = paramIntent.getBoolean("allow_set");
              QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "status is ", Boolean.valueOf(bool1), "open is ", Boolean.valueOf(bool2), " status is ", Boolean.valueOf(bool1), " allowSet is ", Boolean.valueOf(bool3) });
              if (!bool2) {
                break label633;
              }
              this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 1;
              label507:
              this.jdField_a_of_type_Boolean = bool2;
              if (!TextUtils.isEmpty(str))
              {
                this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
                this.jdField_b_of_type_JavaLangString = str;
              }
              this.jdField_b_of_type_Boolean = bool3;
              if (!bool3) {
                break label644;
              }
            }
            for (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 1;; this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 0)
            {
              if (!this.jdField_a_of_type_Boolean) {
                break label653;
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
              g();
              paramIntent = this.app.getHandler(LoginInfoActivity.class);
              if (paramIntent == null) {
                break;
              }
              paramIntent.obtainMessage(20140331, 1, 0).sendToTarget();
              return;
              bool1 = false;
              break label382;
              label627:
              bool1 = false;
              break label416;
              label633:
              this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 0;
              break label507;
            }
          }
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      localObject1 = ((Intent)localObject1).getExtras();
      if ((localObject1 == null) || (!((Bundle)localObject1).containsKey("devlock_need_broadcast"))) {}
    }
    for (boolean bool = ((Bundle)localObject1).getBoolean("devlock_need_broadcast");; bool = false)
    {
      if (bool)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("mqq.intent.action.DEVLOCK_ROAM");
        ((Intent)localObject1).putExtra("auth_dev_open", this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          Object localObject2 = (WtloginManager)this.app.getManager(1);
          if (localObject2 != null)
          {
            localObject2 = ((WtloginManager)localObject2).getLocalTicket(this.app.getCurrentAccountUin(), 16L, 33554432);
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("devlock_roam_sig", ((Ticket)localObject2)._sig);
            }
          }
        }
        sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("auth_dev_open", this.jdField_a_of_type_Boolean);
      ((Intent)localObject1).putExtra("allow_set", this.jdField_b_of_type_Boolean);
      ((Intent)localObject1).putExtra("phone_num", this.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody != null) && (!this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.isEmpty())) {
        ((Intent)localObject1).putExtra("faceStateKey", String.valueOf(((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get()));
      }
      setResult(0, (Intent)localObject1);
      if ((AuthDevOpenUgActivity.a()) && (this.g))
      {
        finish();
        startActivity(new Intent(this, LoginInfoActivity.class));
      }
      finish();
      return false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
      ((Intent)localObject).putExtra("hide_more_button", true);
      startActivity((Intent)localObject);
      bdla.b(null, "dc00898", "", "", "0X800A720", "0X800A720", 0, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        QLog.d("DevRpt", 2, "点击帮助！0X800A720");
        continue;
        l();
        continue;
        this.app.sendWirelessMeibaoReq(1);
        bdla.b(this.app, "CliOper", "", "", "My_eq_lock", "Clk_protect_detail", 0, 0, "", "", "", "");
        bdla.b(this.app, "dc00898", "", "", "0X800ACA0", "0X800ACA0", 0, 0, "1", "", "", "");
        if ((TextUtils.isEmpty(this.app.getCurrentAccountUin())) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick current is empty");
        }
        aslh.a(this, this.app, aslh.a, 1003, null);
        continue;
        c();
        bdla.b(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickCancel", "dialogRightBtn", 0, 1, "", "", "", "");
        bdla.b(null, "dc00898", "", "", "0X800A71E", "0X800A71E", 0, 0, "", "", "", "");
        if (QLog.isColorLevel())
        {
          QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击取消！0X800A71E");
          continue;
          int i;
          try
          {
            c();
            localObject = getSharedPreferences(LoginInfoActivity.a(getCurrentAccountUin()) + "_" + LoginInfoActivity.jdField_a_of_type_JavaLangString, 0).edit();
            ((SharedPreferences.Editor)localObject).putLong(LoginInfoActivity.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
            ((SharedPreferences.Editor)localObject).commit();
            bdla.b(null, "dc00898", "", "", "0X800A71D", "0X800A71D", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击关闭！0X800A71D");
            }
            bdla.b(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickClose", "dialogLeftBtn", 0, 2, "", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CloseDevLock");
            }
            if (!this.jdField_c_of_type_Boolean)
            {
              if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
                continue;
              }
              i();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
            i();
            this.jdField_c_of_type_Boolean = false;
            str = this.app.getCurrentAccountUin();
            i = asll.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
          }
          if (i != 0)
          {
            j();
            this.jdField_c_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CloseDevLock fail ret =" + i);
            }
            QQToast.a(getApplicationContext(), getString(2131691940), 0).b(getTitleBarHeight());
            continue;
            bdla.b(null, "dc00898", "", "", "0X800A31B", "0X800A31B", 0, 0, "", "", "", "");
            if (aslf.a().a() == aslf.c)
            {
              QQToast.a(getApplicationContext(), getString(2131692094), 0).b(getTitleBarHeight());
            }
            else if (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody == null)
            {
              QLog.e("Q.devlock.AuthDevActivity", 1, "faceVerifyLayout click error : mFaceStateRsp is null");
            }
            else
            {
              if ((this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data != null) && (!this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.isEmpty())) {
                break;
              }
              QLog.e("Q.devlock.AuthDevActivity", 1, "faceVerifyLayout click error : mFaceStateRsp.rpt_msg_uin_data is null or empty");
            }
          }
        }
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
    QQAppInterface localQQAppInterface = this.app;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      str = "";
      label810:
      avpp.a(localQQAppInterface, this, str, this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody, this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse, new AuthDevActivity.15(this));
      if (((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() != 1) {
        break label898;
      }
    }
    label898:
    for (String str = "1";; str = "0")
    {
      bdla.b(null, "dc00898", "", "", "0X800AA7D", "0X800AA7D", 0, 0, str, "", "", "");
      break;
      str = this.jdField_b_of_type_JavaLangString;
      break label810;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131561093);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131377260));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131363076));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131373255));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370542));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131366400));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379777));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363082));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363675));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363078));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131381601));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131381600));
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131693032);
    this.rightViewText.setOnClickListener(this);
    paramBundle = super.getIntent();
    if (TextUtils.equals(paramBundle.getExtras().getString("devlock_open_source"), "PhoneUnity")) {
      this.leftView.setText(2131698836);
    }
    if (this.app == null)
    {
      QLog.e("Q.devlock.AuthDevActivity", 1, "app is null, refresh app");
      this.app = ((QQAppInterface)getAppRuntime());
    }
    if (this.app == null)
    {
      finish();
      QLog.e("Q.devlock.AuthDevActivity", 1, "error : app is null");
    }
    label647:
    label886:
    do
    {
      return;
      boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131691971));
        this.rightViewText.setContentDescription(getString(2131691939));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131693171));
      }
      try
      {
        this.jdField_a_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "packName = " + this.jdField_a_of_type_JavaLangString);
        }
        addObserver(this.jdField_a_of_type_Anvi);
        addObserver(this.jdField_a_of_type_Aodj);
        this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("from");
        if ("app_qq_safe_center".equals(this.jdField_f_of_type_JavaLangString))
        {
          paramBundle = bhhr.j(this, getCurrentAccountUin());
          if (!TextUtils.isEmpty(paramBundle)) {}
          try
          {
            if (new JSONObject(paramBundle).optInt("securityType", 0) != 0) {
              break label647;
            }
            bool = true;
            this.jdField_f_of_type_Boolean = bool;
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "parse dev gray switch error : ", paramBundle.getMessage() });
            }
          }
          a();
          if (this.jdField_f_of_type_Boolean) {
            break label886;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          paramBundle = avpm.a().a();
          if (paramBundle != null) {
            paramBundle.a(new View[] { this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem });
          }
          bdla.b(this.app, "dc00898", "", "", "0X800AC9F", "0X800AC9F", 0, 0, "1", "", "", "");
          if (!(paramBundle instanceof avqm)) {
            continue;
          }
          k();
          return;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          localNameNotFoundException.printStackTrace();
          continue;
          bool = false;
          continue;
          this.jdField_f_of_type_Boolean = paramBundle.getExtras().getBoolean("auth_dev_gray_switch");
          this.jdField_a_of_type_Boolean = paramBundle.getExtras().getBoolean("auth_dev_open");
          this.jdField_b_of_type_JavaLangString = paramBundle.getExtras().getString("phone_num");
          this.jdField_d_of_type_Boolean = paramBundle.getExtras().getBoolean("allow_set");
          this.jdField_e_of_type_Boolean = paramBundle.getExtras().getBoolean("enable_open_allowset_dev");
          this.g = paramBundle.getExtras().getBoolean("h5_flag");
          this.jdField_e_of_type_JavaLangString = paramBundle.getExtras().getString("secureState", "secureStateUNKNOWN");
          this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)paramBundle.getParcelableExtra("DevlockInfo"));
          if ("secureStateOk".equals(this.jdField_e_of_type_JavaLangString))
          {
            this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("faceAppId");
            this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("faceTmpKey");
            this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse = new FaceSecureCheck.SecureCheckResponse();
            this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.bool_sec_pass.set(true);
            this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.str_tmpkey.set(this.jdField_d_of_type_JavaLangString);
            this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.str_openid.set(this.jdField_c_of_type_JavaLangString);
          }
          d();
          continue;
          super.setTitle(2131691924);
          this.rightViewText.setVisibility(8);
          bdla.b(null, "dc00898", "", "", "0X800AC52", "0X800AC52", 0, 0, "", "", "", "");
        }
      }
    } while (!(paramBundle instanceof avql));
    bdla.a(null, "dc00898", "", "", "0X800B0ED", "0X800B0ED", 0, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    j();
    h();
    removeObserver(this.jdField_a_of_type_Anvi);
    removeObserver(this.jdField_a_of_type_Aodj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity
 * JD-Core Version:    0.7.0.1
 */