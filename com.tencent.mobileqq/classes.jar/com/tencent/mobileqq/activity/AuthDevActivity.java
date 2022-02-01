package com.tencent.mobileqq.activity;

import Override;
import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import adnm;
import adnn;
import adno;
import adnp;
import adnq;
import adnr;
import adns;
import adnt;
import adnu;
import adnv;
import adnw;
import adnx;
import adny;
import adnz;
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
import anmu;
import anqg;
import anus;
import anut;
import asfl;
import asfn;
import asfr;
import avep;
import aves;
import avex;
import avfn;
import avfo;
import bccl;
import bcst;
import bgnt;
import bgsg;
import bgsu;
import biau;
import bkho;
import bkif;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
  private Handler jdField_a_of_type_AndroidOsHandler = new adnm(this);
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new adns(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anmu jdField_a_of_type_Anmu = new adnx(this);
  private anut jdField_a_of_type_Anut = new adno(this);
  private biau jdField_a_of_type_Biau;
  private bkho jdField_a_of_type_Bkho;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FaceSecureCheck.SecureCheckResponse jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse;
  private String jdField_a_of_type_JavaLangString = "";
  private List<SvcDevLoginInfo> jdField_a_of_type_JavaUtilList;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new adny(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private oidb_0x5e1.RspBody jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody;
  private boolean jdField_a_of_type_Boolean;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bkho jdField_b_of_type_Bkho;
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
    ReportDialog localReportDialog = new ReportDialog(this, 2131755823);
    localReportDialog.setContentView(2131558985);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365479);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131691860));
    }
    localTextView1 = (TextView)localReportDialog.findViewById(2131365475);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131691857));
    }
    localTextView1 = (TextView)localReportDialog.findViewById(2131365464);
    if (localTextView1 != null) {
      localTextView1.setText(2131691858);
    }
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365470);
    if (localTextView2 != null) {
      localTextView2.setText(2131691859);
    }
    if (localTextView1 != null) {
      localTextView1.setOnClickListener(new adnz(this));
    }
    if (localTextView2 != null) {
      localTextView2.setOnClickListener(new adnn(this));
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
      for (Object localObject = getString(2131691948);; localObject = getString(2131691953))
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
      str = getResources().getString(2131693903);
    }
    this.jdField_a_of_type_Bkho = ((bkho)bkif.a(this, null));
    if (paramBoolean1) {}
    for (paramString1 = getString(2131691817, new Object[] { str });; paramString1 = getString(2131691815, new Object[] { str }))
    {
      this.jdField_a_of_type_Bkho.a(paramString1);
      this.jdField_a_of_type_Bkho.a(getResources().getString(2131691814), 3, false);
      this.jdField_a_of_type_Bkho.c(2131690582);
      this.jdField_a_of_type_Bkho.a(new adnw(this, paramString2, paramArrayList, paramInt, paramBoolean2, paramLong));
      this.jdField_a_of_type_Bkho.show();
      return;
    }
  }
  
  private void a(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, byte[] paramArrayOfByte, boolean paramBoolean3, SvcDevLoginInfo paramSvcDevLoginInfo)
  {
    this.jdField_b_of_type_Bkho = ((bkho)bkif.a(this, null));
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131559145, this.jdField_b_of_type_Bkho.a(), false);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131361981);
    boolean bool1 = Arrays.equals(NetConnInfoCenter.GUID, paramArrayOfByte);
    boolean bool2 = a(paramSvcDevLoginInfo);
    if (this.jdField_a_of_type_Boolean)
    {
      paramSvcDevLoginInfo = getString(2131691788);
      paramArrayOfByte = getString(2131691788);
      if (paramLong2 > 0L)
      {
        paramArrayOfByte = new Date(1000L * paramLong2);
        paramSvcDevLoginInfo = getString(2131691784, new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(paramArrayOfByte) });
        paramArrayOfByte = getString(2131691784, new Object[] { new SimpleDateFormat("yyyy年MM月dd日 HH点mm分", Locale.getDefault()).format(paramArrayOfByte) });
        if ((bool1) || (bool2)) {
          paramSvcDevLoginInfo = getString(2131691790);
        }
        localTextView.setText(paramSvcDevLoginInfo);
        if ((!bool1) && (!bool2)) {
          break label357;
        }
        paramArrayOfByte = getString(2131691790);
      }
      label357:
      for (;;)
      {
        localTextView.setContentDescription(paramArrayOfByte);
        this.jdField_b_of_type_Bkho.a(localLinearLayout);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_Bkho.a(getResources().getString(2131691853), 5, 0);
        }
        if ((!bool1) || (this.jdField_a_of_type_Boolean)) {
          this.jdField_b_of_type_Bkho.a(getResources().getString(2131691325), 3, 1);
        }
        this.jdField_b_of_type_Bkho.c(2131690582);
        this.jdField_b_of_type_Bkho.a(new adnv(this, paramString2, paramLong1, paramString1, paramInt, paramBoolean3, paramArrayList, paramBoolean1, paramBoolean2));
        this.jdField_b_of_type_Bkho.show();
        return;
        QLog.e("Q.devlock.AuthDevActivity", 1, "format login time error: time <= 0");
        break;
      }
    }
    if (bool1) {}
    for (paramArrayOfByte = getString(2131691781);; paramArrayOfByte = getString(2131691816, new Object[] { paramString1 }))
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
        View localView = getLayoutInflater().inflate(2131561124, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131368835);
        label127:
        TextView localTextView1;
        Object localObject1;
        if (j == 1)
        {
          localRelativeLayout.setBackgroundResource(2130839432);
          TextView localTextView2 = (TextView)localView.findViewById(2131371539);
          localTextView1 = (TextView)localView.findViewById(2131368563);
          Object localObject2 = localSvcDevLoginInfo.strDeviceName;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = getResources().getString(2131693903);
          }
          localObject2 = null;
          boolean bool1 = Arrays.equals(NetConnInfoCenter.GUID, localSvcDevLoginInfo.vecGuid);
          boolean bool2 = a(localSvcDevLoginInfo);
          if (bool1) {
            localObject2 = "（" + getResources().getString(2131693900) + "）";
          }
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localSpannableStringBuilder.append((CharSequence)localObject2);
            adnt localadnt = new adnt(this);
            int k = ((String)localObject1).length();
            localSpannableStringBuilder.setSpan(localadnt, k, ((String)localObject2).length() + k, 33);
          }
          localTextView2.setText(localSpannableStringBuilder);
          localObject1 = new StringBuilder();
          localObject2 = new StringBuilder();
          if (bool2) {
            ((StringBuilder)localObject2).append(getString(2131691789)).append(" ").append(localSvcDevLoginInfo.strDeviceName);
          }
          if ((localSvcDevLoginInfo.iLoginTime > 0L) && (!this.jdField_a_of_type_Boolean)) {
            ((StringBuilder)localObject1).append(bgsu.a(localSvcDevLoginInfo.iLoginTime * 1000L, "yyyy-MM-dd "));
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
          localRelativeLayout.setOnClickListener(new adnu(this, paramList, localRelativeLayout, i, localSvcDevLoginInfo));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          break;
          if (i == 0)
          {
            localRelativeLayout.setBackgroundResource(2130839448);
            break label127;
          }
          if (i == j - 1)
          {
            localRelativeLayout.setBackgroundResource(2130839439);
            break label127;
          }
          localRelativeLayout.setBackgroundResource(2130839442);
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
      if (asfl.a().a() != asfl.c) {
        break label130;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131691839));
      label82:
      if (!this.jdField_a_of_type_Boolean) {
        break label144;
      }
      localObject = (anus)this.app.a(34);
      if (localObject != null) {
        ((anus)localObject).a();
      }
      g();
    }
    for (;;)
    {
      return;
      ((MqqHandler)localObject).obtainMessage(20140331, 0, 0).sendToTarget();
      break;
      label130:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_b_of_type_JavaLangString);
      break label82;
      label144:
      if ((this.jdField_d_of_type_Boolean) && ((asfr.a().c()) || (this.jdField_e_of_type_Boolean))) {
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
    boolean bool1 = asfr.a().b(this.app, this.jdField_a_of_type_JavaLangString, 0L);
    boolean bool2 = asfr.a().a(this.app, this.jdField_a_of_type_JavaLangString, 0L);
    if ((bool1) && (bool2))
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131691861));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131691794));
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
    boolean bool = asfr.a().c(this.app, this.jdField_a_of_type_JavaLangString, 0L);
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131691856));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131691795));
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
    bccl.a(this.app, getCurrentAccountUin(), new adnq(this));
    if (!"secureStateOk".equals(this.jdField_e_of_type_JavaLangString)) {
      bccl.a(this.app, getCurrentAccountUin(), new adnr(this));
    }
  }
  
  private void l()
  {
    if (!bgnt.d(this)) {
      QQToast.a(this, getString(2131691985), 0).b(getTitleBarHeight());
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          bcst.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_close", 0, 0, "", "", "", "");
          bcst.b(null, "dc00898", "", "", "0X800A71C", "0X800A71C", 0, 0, "", "", "", "");
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
        if (asfl.a().a() == asfl.c)
        {
          asfl.a().a(this, this.jdField_b_of_type_JavaLangString);
          return;
        }
        bcst.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "0", "", "", "");
        bcst.b(null, "dc00898", "", "", "0X800A71B", "0X800A71B", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "登录保护页点击开关，开启登录保护的用户数、次数！0X800A71B");
        }
        if (this.jdField_c_of_type_Boolean) {
          break;
        }
      } while ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing()));
      i();
      return;
      i();
      this.jdField_c_of_type_Boolean = false;
      Object localObject = this.app.getCurrentAccountUin();
      i = asfr.a().a(this.app, (String)localObject, "", null, this.jdField_a_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    this.jdField_c_of_type_Boolean = true;
    j();
    QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.CheckDevLockSms fail ret=" + i);
    QQToast.a(getApplicationContext(), getString(2131691834), 0).b(getTitleBarHeight());
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    String str = this.app.getCurrentAccountUin();
    int i = asfr.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + i);
      }
      e();
      QQToast.a(this, getString(2131693950), 0).a();
    }
  }
  
  void b()
  {
    c();
    ReportDialog localReportDialog = new ReportDialog(this, 2131755823);
    localReportDialog.setContentView(2131558985);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365479);
    if (localTextView != null) {
      localTextView.setText(getString(2131691802));
    }
    localTextView = (TextView)localReportDialog.findViewById(2131365475);
    if (localTextView != null)
    {
      localObject = (anqg)this.app.getManager(92);
      if ((localObject != null) && (((anqg)localObject).h()) && (((anqg)localObject).b() == 1)) {}
      localTextView.setText(getString(2131691801));
    }
    localTextView = (TextView)localReportDialog.findViewById(2131365464);
    if (localTextView != null) {
      localTextView.setText(2131690728);
    }
    Object localObject = (TextView)localReportDialog.findViewById(2131365470);
    if (localObject != null) {
      ((TextView)localObject).setText(2131690582);
    }
    localReportDialog.setOnDismissListener(new adnp(this));
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
        asfl.a().a(asfl.d);
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
          asfl.a().a(asfl.c);
          asfl.a().a(0L);
        }
      }
      continue;
      label108:
      if (paramInt1 == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131691839));
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
            QQToast.a(this, getString(2131691822), 0).a();
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
            localObject2 = ((WtloginManager)localObject2).GetLocalTicket(this.app.getCurrentAccountUin(), 16L, 33554432);
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
      bcst.b(null, "dc00898", "", "", "0X800A720", "0X800A720", 0, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        QLog.d("DevRpt", 2, "点击帮助！0X800A720");
        continue;
        l();
        continue;
        this.app.sendWirelessMeibaoReq(1);
        bcst.b(this.app, "CliOper", "", "", "My_eq_lock", "Clk_protect_detail", 0, 0, "", "", "", "");
        bcst.b(this.app, "dc00898", "", "", "0X800ACA0", "0X800ACA0", 0, 0, "1", "", "", "");
        if ((TextUtils.isEmpty(this.app.getCurrentAccountUin())) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick current is empty");
        }
        asfn.a(this, this.app, asfn.a, 1003, null);
        continue;
        c();
        bcst.b(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickCancel", "dialogRightBtn", 0, 1, "", "", "", "");
        bcst.b(null, "dc00898", "", "", "0X800A71E", "0X800A71E", 0, 0, "", "", "", "");
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
            bcst.b(null, "dc00898", "", "", "0X800A71D", "0X800A71D", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击关闭！0X800A71D");
            }
            bcst.b(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickClose", "dialogLeftBtn", 0, 2, "", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CloseDevLock");
            }
            if (!this.jdField_c_of_type_Boolean)
            {
              if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
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
            i = asfr.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
          }
          if (i != 0)
          {
            j();
            this.jdField_c_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CloseDevLock fail ret =" + i);
            }
            QQToast.a(getApplicationContext(), getString(2131691800), 0).b(getTitleBarHeight());
            continue;
            bcst.b(null, "dc00898", "", "", "0X800A31B", "0X800A31B", 0, 0, "", "", "", "");
            if (asfl.a().a() == asfl.c)
            {
              QQToast.a(getApplicationContext(), getString(2131691954), 0).b(getTitleBarHeight());
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
      aves.a(localQQAppInterface, this, str, this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody, this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse, new AuthDevActivity.15(this));
      if (((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() != 1) {
        break label898;
      }
    }
    label898:
    for (String str = "1";; str = "0")
    {
      bcst.b(null, "dc00898", "", "", "0X800AA7D", "0X800AA7D", 0, 0, str, "", "", "");
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
    super.setContentView(2131561123);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131377099));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131363021));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131372962));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370290));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131366219));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379516));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363027));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363554));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363023));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131381332));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131381331));
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131692868);
    this.rightViewText.setOnClickListener(this);
    paramBundle = super.getIntent();
    if (TextUtils.equals(paramBundle.getExtras().getString("devlock_open_source"), "PhoneUnity")) {
      this.leftView.setText(2131698268);
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131691831));
        this.rightViewText.setContentDescription(getString(2131691799));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131692971));
      }
      try
      {
        this.jdField_a_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "packName = " + this.jdField_a_of_type_JavaLangString);
        }
        addObserver(this.jdField_a_of_type_Anmu);
        addObserver(this.jdField_a_of_type_Anut);
        this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("from");
        if ("app_qq_safe_center".equals(this.jdField_f_of_type_JavaLangString))
        {
          paramBundle = bgsg.j(this, getCurrentAccountUin());
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
          paramBundle = avep.a().a();
          if (paramBundle != null) {
            paramBundle.a(new View[] { this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem });
          }
          bcst.b(this.app, "dc00898", "", "", "0X800AC9F", "0X800AC9F", 0, 0, "1", "", "", "");
          if (!(paramBundle instanceof avfo)) {
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
          super.setTitle(2131691785);
          this.rightViewText.setVisibility(8);
          bcst.b(null, "dc00898", "", "", "0X800AC52", "0X800AC52", 0, 0, "", "", "", "");
        }
      }
    } while (!(paramBundle instanceof avfn));
    bcst.a(null, "dc00898", "", "", "0X800B0ED", "0X800B0ED", 0, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    j();
    h();
    removeObserver(this.jdField_a_of_type_Anmu);
    removeObserver(this.jdField_a_of_type_Anut);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity
 * JD-Core Version:    0.7.0.1
 */