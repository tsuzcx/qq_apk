package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import acgb;
import acgc;
import acgd;
import acge;
import acgf;
import acgg;
import acgh;
import acgi;
import acgj;
import acgk;
import acgl;
import acgm;
import altm;
import alxa;
import amci;
import amcj;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqax;
import aqaz;
import aqbd;
import asxg;
import azbn;
import azqs;
import bdin;
import bdns;
import bety;
import bhuf;
import bhus;
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
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class AuthDevActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private altm jdField_a_of_type_Altm = new acgk(this);
  private amcj jdField_a_of_type_Amcj = new acgm(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler = new acgb(this);
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new acgf(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bety jdField_a_of_type_Bety;
  private bhuf jdField_a_of_type_Bhuf;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FaceSecureCheck.SecureCheckResponse jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse;
  private String jdField_a_of_type_JavaLangString = "";
  private List<SvcDevLoginInfo> jdField_a_of_type_JavaUtilList;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new acgl(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private oidb_0x5e1.RspBody jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bhuf jdField_b_of_type_Bhuf;
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
  private boolean f;
  private boolean g;
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody != null) && (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.size() != 0))
    {
      ((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.set(paramInt);
      FormSimpleItem localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (paramInt == 1) {}
      for (Object localObject = getString(2131692354);; localObject = getString(2131692361))
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
      str = getResources().getString(2131694652);
    }
    this.jdField_a_of_type_Bhuf = ((bhuf)bhus.a(this, null));
    if (paramBoolean1) {}
    for (paramString1 = getString(2131692193, new Object[] { str });; paramString1 = getString(2131692191, new Object[] { str }))
    {
      this.jdField_a_of_type_Bhuf.a(paramString1);
      this.jdField_a_of_type_Bhuf.a(getResources().getString(2131692190), 3, false);
      this.jdField_a_of_type_Bhuf.c(2131690648);
      this.jdField_a_of_type_Bhuf.a(new acgj(this, paramString2, paramArrayList, paramInt, paramBoolean2, paramLong));
      this.jdField_a_of_type_Bhuf.show();
      return;
    }
  }
  
  private void a(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, byte[] paramArrayOfByte, boolean paramBoolean3, SvcDevLoginInfo paramSvcDevLoginInfo)
  {
    this.jdField_b_of_type_Bhuf = ((bhuf)bhus.a(this, null));
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131559076, this.jdField_b_of_type_Bhuf.a(), false);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131361925);
    boolean bool1 = Arrays.equals(NetConnInfoCenter.GUID, paramArrayOfByte);
    boolean bool2 = a(paramSvcDevLoginInfo);
    if (this.jdField_a_of_type_Boolean)
    {
      paramSvcDevLoginInfo = getString(2131692157);
      paramArrayOfByte = getString(2131692157);
      if (paramLong2 > 0L)
      {
        paramArrayOfByte = new Date(1000L * paramLong2);
        paramSvcDevLoginInfo = getString(2131692153, new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(paramArrayOfByte) });
        paramArrayOfByte = getString(2131692153, new Object[] { new SimpleDateFormat("yyyy年MM月dd日 HH点mm分", Locale.getDefault()).format(paramArrayOfByte) });
        if ((bool1) || (bool2)) {
          paramSvcDevLoginInfo = getString(2131692159);
        }
        localTextView.setText(paramSvcDevLoginInfo);
        if ((!bool1) && (!bool2)) {
          break label355;
        }
        paramArrayOfByte = getString(2131692159);
      }
      label355:
      for (;;)
      {
        localTextView.setContentDescription(paramArrayOfByte);
        this.jdField_b_of_type_Bhuf.a(localLinearLayout);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_Bhuf.a(getResources().getString(2131692239), 5, 0);
        }
        if ((!bool1) || (this.jdField_a_of_type_Boolean)) {
          this.jdField_b_of_type_Bhuf.a(getResources().getString(2131691567), 3, 1);
        }
        this.jdField_b_of_type_Bhuf.c(2131690648);
        this.jdField_b_of_type_Bhuf.a(new acgi(this, paramString2, paramLong1, paramString1, paramInt, paramBoolean3, paramArrayList, paramBoolean1, paramBoolean2));
        this.jdField_b_of_type_Bhuf.show();
        return;
        QLog.e("Q.devlock.AuthDevActivity", 1, "format login time error: time <= 0");
        break;
      }
    }
    if (bool1) {}
    for (paramArrayOfByte = getString(2131692150);; paramArrayOfByte = getString(2131692192, new Object[] { paramString1 }))
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
        View localView = getLayoutInflater().inflate(2131560919, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131368527);
        label127:
        TextView localTextView1;
        Object localObject1;
        if (j == 1)
        {
          localRelativeLayout.setBackgroundResource(2130839254);
          TextView localTextView2 = (TextView)localView.findViewById(2131370977);
          localTextView1 = (TextView)localView.findViewById(2131368235);
          Object localObject2 = localSvcDevLoginInfo.strDeviceName;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = getResources().getString(2131694652);
          }
          localObject2 = null;
          boolean bool1 = Arrays.equals(NetConnInfoCenter.GUID, localSvcDevLoginInfo.vecGuid);
          boolean bool2 = a(localSvcDevLoginInfo);
          if (bool1) {
            localObject2 = "（" + getResources().getString(2131694649) + "）";
          }
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localSpannableStringBuilder.append((CharSequence)localObject2);
            acgg localacgg = new acgg(this);
            int k = ((String)localObject1).length();
            localSpannableStringBuilder.setSpan(localacgg, k, ((String)localObject2).length() + k, 33);
          }
          localTextView2.setText(localSpannableStringBuilder);
          localObject1 = new StringBuilder();
          localObject2 = new StringBuilder();
          if (bool2) {
            ((StringBuilder)localObject2).append(getString(2131692158)).append(" ").append(localSvcDevLoginInfo.strDeviceName);
          }
          if ((localSvcDevLoginInfo.iLoginTime > 0L) && (!this.jdField_a_of_type_Boolean)) {
            ((StringBuilder)localObject1).append(bdns.a(localSvcDevLoginInfo.iLoginTime * 1000L, "yyyy-MM-dd "));
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
            break label578;
          }
          localTextView1.setText(((StringBuilder)localObject2).toString());
        }
        for (;;)
        {
          localRelativeLayout.setClickable(true);
          localRelativeLayout.setTag(localSvcDevLoginInfo);
          localRelativeLayout.setOnClickListener(new acgh(this, paramList, localRelativeLayout, i, localSvcDevLoginInfo));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          break;
          if (i == 0)
          {
            localRelativeLayout.setBackgroundResource(2130839270);
            break label127;
          }
          if (i == j - 1)
          {
            localRelativeLayout.setBackgroundResource(2130839261);
            break label127;
          }
          localRelativeLayout.setBackgroundResource(2130839264);
          break label127;
          label578:
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
  
  private void c()
  {
    boolean bool1 = aqbd.a().b(this.app, this.jdField_a_of_type_JavaLangString, 0L);
    boolean bool2 = aqbd.a().a(this.app, this.jdField_a_of_type_JavaLangString, 0L);
    if ((bool1) && (bool2))
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692248));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131692162));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onCreate getRecentLoginDevList failed recentLoginRet=", Boolean.valueOf(bool1), " loginDevRet=", Boolean.valueOf(bool2) });
  }
  
  private void d()
  {
    QLog.d("Q.devlock.AuthDevActivity", 1, "startGetAuthDevList.begin to getAuthLoginDevList");
    boolean bool = aqbd.a().c(this.app, this.jdField_a_of_type_JavaLangString, 0L);
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692243));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131692163));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, "startGetAuthDevList getAuthLoginDevList failed ret =" + bool);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AuthDevActivity.11(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AuthDevActivity.12(this));
  }
  
  private void g()
  {
    azbn.a(this.app, getCurrentAccountUin(), new acgd(this));
    if (!"secureStateOk".equals(this.jdField_e_of_type_JavaLangString)) {
      azbn.a(this.app, getCurrentAccountUin(), new acge(this));
    }
  }
  
  private void h()
  {
    if (!bdin.d(this)) {
      QQToast.a(this, getString(2131692398), 0).b(getTitleBarHeight());
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          azqs.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_close", 0, 0, "", "", "", "");
          azqs.b(null, "dc00898", "", "", "0X800A71C", "0X800A71C", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("DevRpt", 2, "登录保护页点击开关，关闭登录保护的用户数、次数！0X800A71C");
          }
          QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.begin to close dev lock");
          a();
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
        if (aqax.a().a() == aqax.c)
        {
          aqax.a().a(this, this.jdField_b_of_type_JavaLangString);
          return;
        }
        azqs.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "0", "", "", "");
        azqs.b(null, "dc00898", "", "", "0X800A71B", "0X800A71B", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "登录保护页点击开关，开启登录保护的用户数、次数！0X800A71B");
        }
        if (this.jdField_c_of_type_Boolean) {
          break;
        }
      } while ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing()));
      e();
      return;
      e();
      this.jdField_c_of_type_Boolean = false;
      Object localObject = this.app.getCurrentAccountUin();
      i = aqbd.a().a(this.app, (String)localObject, "", null, this.jdField_a_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    this.jdField_c_of_type_Boolean = true;
    f();
    QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.CheckDevLockSms fail ret=" + i);
    QQToast.a(getApplicationContext(), getString(2131692216), 0).b(getTitleBarHeight());
  }
  
  void a()
  {
    b();
    Dialog localDialog = new Dialog(this, 2131755801);
    localDialog.setContentView(2131558919);
    TextView localTextView = (TextView)localDialog.findViewById(2131365237);
    if (localTextView != null) {
      localTextView.setText(getString(2131692177));
    }
    localTextView = (TextView)localDialog.findViewById(2131365233);
    if (localTextView != null)
    {
      localObject = (alxa)this.app.getManager(92);
      if ((localObject != null) && (((alxa)localObject).h()) && (((alxa)localObject).b() == 1)) {}
      localTextView.setText(getString(2131692176));
    }
    localTextView = (TextView)localDialog.findViewById(2131365222);
    if (localTextView != null) {
      localTextView.setText(2131690885);
    }
    Object localObject = (TextView)localDialog.findViewById(2131365228);
    if (localObject != null) {
      ((TextView)localObject).setText(2131690648);
    }
    localDialog.setOnDismissListener(new acgc(this));
    if (localTextView != null) {
      localTextView.setOnClickListener(this);
    }
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidAppDialog = localDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  void b()
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
    label108:
    label622:
    for (;;)
    {
      return;
      paramInt1 = paramIntent.getInt("resultState", 1);
      if (paramInt1 == 2) {
        aqax.a().a(aqax.d);
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
          aqax.a().a(aqax.c);
          aqax.a().a(0L);
        }
      }
      continue;
      if (paramInt1 == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131692222));
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
          if (paramInt2 == -1) {
            a(0);
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
              boolean bool2 = paramIntent.getBoolean("auth_dev_open", bool1);
              String str = paramIntent.getString("phone_num");
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1) {
                break label596;
              }
              bool1 = true;
              boolean bool3 = paramIntent.getBoolean("allow_set");
              QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "status is ", Boolean.valueOf(bool1), "open is ", Boolean.valueOf(bool2), " status is ", Boolean.valueOf(bool1), " allowSet is ", Boolean.valueOf(bool3) });
              if (!bool2) {
                break label602;
              }
              this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 1;
              this.jdField_a_of_type_Boolean = bool2;
              if (!TextUtils.isEmpty(str))
              {
                this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
                this.jdField_b_of_type_JavaLangString = str;
              }
              this.jdField_b_of_type_Boolean = bool3;
              if (!bool3) {
                break label613;
              }
            }
            for (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 1;; this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 0)
            {
              if (!this.jdField_a_of_type_Boolean) {
                break label622;
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
              d();
              paramIntent = this.app.getHandler(LoginInfoActivity.class);
              if (paramIntent == null) {
                break;
              }
              paramIntent.obtainMessage(20140331, 1, 0).sendToTarget();
              return;
              bool1 = false;
              break label351;
              bool1 = false;
              break label385;
              this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 0;
              break label476;
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
    default: 
    case 2131368655: 
    case 2131362914: 
    case 2131376318: 
    case 2131365228: 
    case 2131365222: 
      int i;
      do
      {
        for (;;)
        {
          return;
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", "http://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
          paramView.putExtra("hide_more_button", true);
          startActivity(paramView);
          azqs.b(null, "dc00898", "", "", "0X800A720", "0X800A720", 0, 0, "", "", "", "");
          if (QLog.isColorLevel())
          {
            QLog.d("DevRpt", 2, "点击帮助！0X800A720");
            return;
            h();
            return;
            this.app.sendWirelessMeibaoReq(1);
            azqs.b(this.app, "CliOper", "", "", "My_eq_lock", "Clk_protect_detail", 0, 0, "", "", "", "");
            azqs.b(this.app, "dc00898", "", "", "0X800ACA0", "0X800ACA0", 0, 0, "1", "", "", "");
            if ((TextUtils.isEmpty(this.app.getCurrentAccountUin())) && (QLog.isColorLevel())) {
              QLog.d("Q.devlock.AuthDevActivity", 2, "onClick current is empty");
            }
            aqaz.a(this, this.app, aqaz.a, 1003, null);
            return;
            b();
            azqs.b(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickCancel", "dialogRightBtn", 0, 1, "", "", "", "");
            azqs.b(null, "dc00898", "", "", "0X800A71E", "0X800A71E", 0, 0, "", "", "", "");
            if (QLog.isColorLevel())
            {
              QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击取消！0X800A71E");
              return;
              try
              {
                b();
                paramView = getSharedPreferences(LoginInfoActivity.a(getCurrentAccountUin()) + "_" + LoginInfoActivity.jdField_a_of_type_JavaLangString, 0).edit();
                paramView.putLong(LoginInfoActivity.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
                paramView.commit();
                azqs.b(null, "dc00898", "", "", "0X800A71D", "0X800A71D", 0, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                  QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击关闭！0X800A71D");
                }
                azqs.b(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickClose", "dialogLeftBtn", 0, 2, "", "", "", "");
                if (QLog.isColorLevel()) {
                  QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CloseDevLock");
                }
                if (!this.jdField_c_of_type_Boolean)
                {
                  if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
                    continue;
                  }
                  e();
                }
              }
              catch (Exception paramView)
              {
                for (;;)
                {
                  paramView.printStackTrace();
                }
                e();
                this.jdField_c_of_type_Boolean = false;
                paramView = this.app.getCurrentAccountUin();
                i = aqbd.a().a(this.app, paramView, this.jdField_a_of_type_MqqObserverWtloginObserver);
              }
            }
          }
        }
      } while (i == 0);
      f();
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CloseDevLock fail ret =" + i);
      }
      QQToast.a(getApplicationContext(), getString(2131692175), 0).b(getTitleBarHeight());
      return;
    }
    azqs.b(null, "dc00898", "", "", "0X800A31B", "0X800A31B", 0, 0, "", "", "", "");
    if (aqax.a().a() == aqax.c)
    {
      QQToast.a(getApplicationContext(), getString(2131692362), 0).b(getTitleBarHeight());
      return;
    }
    if (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody == null)
    {
      QLog.e("Q.devlock.AuthDevActivity", 1, "faceVerifyLayout click error : mFaceStateRsp is null");
      return;
    }
    if ((this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data == null) || (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.isEmpty()))
    {
      QLog.e("Q.devlock.AuthDevActivity", 1, "faceVerifyLayout click error : mFaceStateRsp.rpt_msg_uin_data is null or empty");
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
    QQAppInterface localQQAppInterface = this.app;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      paramView = "";
      asxg.a(localQQAppInterface, this, paramView, this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody, this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse, new AuthDevActivity.13(this));
      if (((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() != 1) {
        break label869;
      }
    }
    label869:
    for (paramView = "1";; paramView = "0")
    {
      azqs.b(null, "dc00898", "", "", "0X800AA7D", "0X800AA7D", 0, 0, paramView, "", "", "");
      return;
      paramView = this.jdField_b_of_type_JavaLangString;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131560918);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131376318));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131362908));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131372368));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369850));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365968));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378659));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131362914));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363361));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362910));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131380324));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380323));
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131693378);
    this.rightViewText.setOnClickListener(this);
    paramBundle = super.getIntent();
    this.f = paramBundle.getExtras().getBoolean("auth_dev_gray_switch");
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
    if (!this.f) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.rightViewText.setContentDescription(getString(2131692170));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131693521));
      }
      if (TextUtils.equals(paramBundle.getExtras().getString("devlock_open_source"), "PhoneUnity")) {
        this.leftView.setText(2131699798);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if (this.app == null)
      {
        QLog.e("Q.devlock.AuthDevActivity", 1, "app is null, refresh app");
        this.app = ((QQAppInterface)getAppRuntime());
      }
      if (this.app != null) {
        break;
      }
      finish();
      QLog.e("Q.devlock.AuthDevActivity", 1, "error : app is null");
      return;
      super.setTitle(2131692154);
      this.rightViewText.setVisibility(8);
      azqs.b(null, "dc00898", "", "", "0X800AC52", "0X800AC52", 0, 0, "", "", "", "");
    }
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    paramBundle = this.app.getHandler(LoginInfoActivity.class);
    if (paramBundle != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label901;
      }
      paramBundle.obtainMessage(20140331, 1, 0).sendToTarget();
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131692213));
      }
      try
      {
        this.jdField_a_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "packName = " + this.jdField_a_of_type_JavaLangString);
        }
        addObserver(this.jdField_a_of_type_Altm);
        addObserver(this.jdField_a_of_type_Amcj);
        if (aqax.a().a() == aqax.c)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131692222));
          azqs.b(this.app, "dc00898", "", "", "0X800AC9F", "0X800AC9F", 0, 0, "1", "", "", "");
          if (!this.jdField_a_of_type_Boolean) {
            break label938;
          }
          paramBundle = (amci)this.app.a(34);
          if (paramBundle != null) {
            paramBundle.a();
          }
          d();
          g();
          return;
          label901:
          paramBundle.obtainMessage(20140331, 0, 0).sendToTarget();
        }
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          continue;
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_b_of_type_JavaLangString);
          continue;
          label938:
          if ((this.jdField_d_of_type_Boolean) && ((aqbd.a().c()) || (this.jdField_e_of_type_Boolean))) {
            h();
          } else if (this.f) {
            c();
          } else {
            this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    f();
    removeObserver(this.jdField_a_of_type_Altm);
    removeObserver(this.jdField_a_of_type_Amcj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity
 * JD-Core Version:    0.7.0.1
 */