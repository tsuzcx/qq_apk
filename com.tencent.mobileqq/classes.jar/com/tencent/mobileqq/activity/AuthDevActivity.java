package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import aaks;
import aakt;
import aaku;
import aakv;
import aakw;
import aakx;
import aaky;
import aakz;
import aala;
import aalb;
import aalc;
import aald;
import ajxl;
import akay;
import akge;
import akgf;
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
import aoeh;
import aoej;
import aoen;
import arch;
import axby;
import axqw;
import bbev;
import bcpq;
import bcpw;
import bfol;
import bfoy;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.request.Ticket;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class AuthDevActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private ajxl jdField_a_of_type_Ajxl = new aalb(this);
  private akgf jdField_a_of_type_Akgf = new aald(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler = new aaks(this);
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aakw(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcpq jdField_a_of_type_Bcpq;
  private bfol jdField_a_of_type_Bfol;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FaceSecureCheck.SecureCheckResponse jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse;
  private String jdField_a_of_type_JavaLangString = "";
  private List<SvcDevLoginInfo> jdField_a_of_type_JavaUtilList;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aalc(this);
  private oidb_0x5e1.RspBody jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bfol jdField_b_of_type_Bfol;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody != null) && (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.size() != 0))
    {
      ((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.set(paramInt);
      FormSimpleItem localFormSimpleItem = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (paramInt == 1) {}
      for (Object localObject = getString(2131692277);; localObject = getString(2131692284))
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
    this.jdField_b_of_type_Bfol = ((bfol)bfoy.a(this, null));
    this.jdField_b_of_type_Bfol.a(getResources().getString(2131692164), 5);
    this.jdField_b_of_type_Bfol.a(getResources().getString(2131691507), 3);
    this.jdField_b_of_type_Bfol.c(2131690596);
    this.jdField_b_of_type_Bfol.a(new aakz(this, paramString2, paramLong, paramString1, paramInt, paramArrayList, paramBoolean1, paramBoolean2));
    this.jdField_b_of_type_Bfol.show();
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
        View localView = getLayoutInflater().inflate(2131560726, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131368344);
        if (j == 1) {
          localRelativeLayout.setBackgroundResource(2130839169);
        }
        for (;;)
        {
          TextView localTextView2 = (TextView)localView.findViewById(2131370647);
          TextView localTextView1 = (TextView)localView.findViewById(2131368086);
          String str = localSvcDevLoginInfo.strDeviceName;
          Object localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = getResources().getString(2131694493);
          }
          str = null;
          if (Arrays.equals(NetConnInfoCenter.GUID, localSvcDevLoginInfo.vecGuid)) {
            str = "（" + getResources().getString(2131694490) + "）";
          }
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject);
          if (!TextUtils.isEmpty(str))
          {
            localSpannableStringBuilder.append(str);
            aakx localaakx = new aakx(this);
            int k = ((String)localObject).length();
            localSpannableStringBuilder.setSpan(localaakx, k, str.length() + k, 33);
          }
          localTextView2.setText(localSpannableStringBuilder);
          localObject = new StringBuffer();
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation)) {
            ((StringBuffer)localObject).append(localSvcDevLoginInfo.strLoginLocation);
          }
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
          {
            if (((StringBuffer)localObject).length() > 0) {
              ((StringBuffer)localObject).append(" ");
            }
            ((StringBuffer)localObject).append(localSvcDevLoginInfo.strDeviceTypeInfo);
          }
          if (((StringBuffer)localObject).length() > 0) {
            localTextView1.setText(((StringBuffer)localObject).toString());
          }
          localRelativeLayout.setClickable(true);
          localRelativeLayout.setTag(localSvcDevLoginInfo);
          localRelativeLayout.setOnClickListener(new aaky(this, localRelativeLayout, i));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          break;
          if (i == 0) {
            localRelativeLayout.setBackgroundResource(2130839185);
          } else if (i == j - 1) {
            localRelativeLayout.setBackgroundResource(2130839176);
          } else {
            localRelativeLayout.setBackgroundResource(2130839179);
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
  
  private void b(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131694493);
    }
    this.jdField_a_of_type_Bfol = ((bfol)bfoy.a(this, null));
    if (paramBoolean1) {}
    for (paramString1 = getString(2131692122, new Object[] { str });; paramString1 = getString(2131692121, new Object[] { str }))
    {
      this.jdField_a_of_type_Bfol.a(paramString1);
      this.jdField_a_of_type_Bfol.a(getResources().getString(2131692120), 3, false);
      this.jdField_a_of_type_Bfol.c(2131690596);
      this.jdField_a_of_type_Bfol.a(new aala(this, paramString2, paramArrayList, paramInt, paramBoolean2, paramLong));
      this.jdField_a_of_type_Bfol.show();
      return;
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "startGetAuthDevList.begin to getAuthLoginDevList");
    }
    boolean bool = aoen.a().c(this.app, this.jdField_a_of_type_JavaLangString, 0L);
    if (bool) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 2, "startGetAuthDevList getAuthLoginDevList failed ret =" + bool);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AuthDevActivity.11(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AuthDevActivity.12(this));
  }
  
  private void f()
  {
    axby.a(this.app, getCurrentAccountUin(), new aaku(this));
    if (!"secureStateOk".equals(this.jdField_e_of_type_JavaLangString)) {
      axby.a(this.app, getCurrentAccountUin(), new aakv(this));
    }
  }
  
  private void g()
  {
    if (!bbev.d(this)) {
      bcpw.a(this, getString(2131692321), 0).b(getTitleBarHeight());
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          axqw.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_close", 0, 0, "", "", "", "");
          axqw.b(null, "dc00898", "", "", "0X800A71C", "0X800A71C", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("DevRpt", 2, "登录保护页点击开关，关闭登录保护的用户数、次数！0X800A71C");
          }
          a();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CheckDevLockSms");
        }
        if (aoeh.a().a() == aoeh.c)
        {
          aoeh.a().a(this, this.jdField_b_of_type_JavaLangString);
          return;
        }
        axqw.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "0", "", "", "");
        axqw.b(null, "dc00898", "", "", "0X800A71B", "0X800A71B", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "登录保护页点击开关，开启登录保护的用户数、次数！0X800A71B");
        }
        if (this.jdField_c_of_type_Boolean) {
          break;
        }
      } while ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing()));
      d();
      return;
      d();
      this.jdField_c_of_type_Boolean = false;
      String str = this.app.getCurrentAccountUin();
      i = aoen.a().a(this.app, str, "", null, this.jdField_a_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    this.jdField_c_of_type_Boolean = true;
    e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CheckDevLockSms fail ret=" + i);
    }
    bcpw.a(getApplicationContext(), getString(2131692144), 0).b(getTitleBarHeight());
  }
  
  void a()
  {
    b();
    Dialog localDialog = new Dialog(this, 2131755791);
    localDialog.setContentView(2131558883);
    TextView localTextView = (TextView)localDialog.findViewById(2131365151);
    if (localTextView != null) {
      localTextView.setText(getString(2131692107));
    }
    localTextView = (TextView)localDialog.findViewById(2131365147);
    if (localTextView != null)
    {
      localObject = (akay)this.app.getManager(92);
      if ((localObject != null) && (((akay)localObject).h()) && (((akay)localObject).b() == 1)) {}
      localTextView.setText(getString(2131692106));
    }
    localTextView = (TextView)localDialog.findViewById(2131365136);
    if (localTextView != null) {
      localTextView.setText(2131690832);
    }
    Object localObject = (TextView)localDialog.findViewById(2131365142);
    if (localObject != null) {
      ((TextView)localObject).setText(2131690596);
    }
    localDialog.setOnDismissListener(new aakt(this));
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
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(true);
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
    label92:
    do
    {
      do
      {
        return;
        paramInt1 = paramIntent.getInt("resultState", 1);
        paramInt2 = paramIntent.getInt("emergency_phone_state", 1);
        if (paramInt1 == 2)
        {
          aoeh.a().a(aoeh.d);
          if (paramInt1 != 1)
          {
            this.jdField_b_of_type_JavaLangString = paramIntent.getString("resultMobileMask");
            if (paramInt1 != 2) {
              break label165;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_b_of_type_JavaLangString);
          }
          if (paramInt2 != 4) {
            break label187;
          }
          aoeh.a().b(aoeh.f);
        }
        for (;;)
        {
          paramIntent = paramIntent.getString("emergency_phone_mask");
          if (paramInt2 != 4) {
            break label204;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131692127));
          aoeh.a().a(paramIntent);
          return;
          if (paramInt1 != 3) {
            break;
          }
          aoeh.a().a(aoeh.c);
          aoeh.a().a(0L);
          break;
          if (paramInt1 != 3) {
            break label92;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131692148));
          break label92;
          if (paramInt2 != 1) {
            aoeh.a().b(aoeh.h);
          }
        }
      } while ((paramInt2 == 1) || (TextUtils.isEmpty(paramIntent)));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramIntent);
      aoeh.a().a(paramIntent);
      return;
      if ((paramInt1 == 11) || (paramInt1 == 21))
      {
        QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, resultCode is ", Integer.valueOf(paramInt2) });
        if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_face_scan_result", false)))
        {
          a(1);
          return;
        }
        if (paramIntent == null) {}
        for (boolean bool = true;; bool = false)
        {
          QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, data == null ? ", Boolean.valueOf(bool) });
          if (paramIntent == null) {
            break;
          }
          QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, KEY_FACE_SCAN_RESULT is ", Boolean.valueOf(paramIntent.getBooleanExtra("key_face_scan_result", false)) });
          return;
        }
      }
    } while ((paramInt1 != 12) || (paramInt2 != -1));
    label165:
    label187:
    label204:
    a(0);
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
      if ((AuthDevOpenUgActivity.a()) && (this.f))
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
    case 2131368457: 
    case 2131362880: 
    case 2131375767: 
    case 2131365559: 
    case 2131365142: 
    case 2131365136: 
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
          axqw.b(null, "dc00898", "", "", "0X800A720", "0X800A720", 0, 0, "", "", "", "");
          if (QLog.isColorLevel())
          {
            QLog.d("DevRpt", 2, "点击帮助！0X800A720");
            return;
            g();
            return;
            this.app.sendWirelessMeibaoReq(1);
            axqw.b(this.app, "CliOper", "", "", "My_eq_lock", "Clk_protect_detail", 0, 0, "", "", "", "");
            if ((TextUtils.isEmpty(this.app.getCurrentAccountUin())) && (QLog.isColorLevel())) {
              QLog.d("Q.devlock.AuthDevActivity", 2, "onClick current is empty");
            }
            aoej.a(this, this.app, aoej.a, 1003, null);
            return;
            aoej.a(this, this.app, aoej.b, 1003, null);
            return;
            b();
            axqw.b(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickCancel", "dialogRightBtn", 0, 1, "", "", "", "");
            axqw.b(null, "dc00898", "", "", "0X800A71E", "0X800A71E", 0, 0, "", "", "", "");
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
                axqw.b(null, "dc00898", "", "", "0X800A71D", "0X800A71D", 0, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                  QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击关闭！0X800A71D");
                }
                axqw.b(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickClose", "dialogLeftBtn", 0, 2, "", "", "", "");
                if (QLog.isColorLevel()) {
                  QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CloseDevLock");
                }
                if (!this.jdField_c_of_type_Boolean)
                {
                  if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
                    continue;
                  }
                  d();
                }
              }
              catch (Exception paramView)
              {
                for (;;)
                {
                  paramView.printStackTrace();
                }
                d();
                this.jdField_c_of_type_Boolean = false;
                paramView = this.app.getCurrentAccountUin();
                i = aoen.a().a(this.app, paramView, this.jdField_a_of_type_MqqObserverWtloginObserver);
              }
            }
          }
        }
      } while (i == 0);
      e();
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CloseDevLock fail ret =" + i);
      }
      bcpw.a(getApplicationContext(), getString(2131692105), 0).b(getTitleBarHeight());
      return;
    }
    axqw.b(null, "dc00898", "", "", "0X800A31B", "0X800A31B", 0, 0, "", "", "", "");
    if (aoeh.a().a() == aoeh.c)
    {
      bcpw.a(getApplicationContext(), getString(2131692285), 0).b(getTitleBarHeight());
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
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
    QQAppInterface localQQAppInterface = this.app;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      paramView = "";
      arch.a(localQQAppInterface, this, paramView, this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody, this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse, new AuthDevActivity.13(this));
      if (((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() != 1) {
        break label862;
      }
    }
    label862:
    for (paramView = "1";; paramView = "0")
    {
      axqw.b(null, "dc00898", "", "", "0X800AA7D", "0X800AA7D", 0, 0, paramView, "", "", "");
      return;
      paramView = this.jdField_b_of_type_JavaLangString;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131560725);
    super.setTitle(2131692141);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131375767));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131362874));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131372031));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131365559));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365880));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365557));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131362880));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362876));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131379518));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379517));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131693274);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.rightViewText.setContentDescription(getString(2131692100));
    }
    this.rightViewText.setOnClickListener(this);
    paramBundle = super.getIntent();
    this.jdField_a_of_type_Boolean = paramBundle.getExtras().getBoolean("auth_dev_open");
    this.jdField_b_of_type_JavaLangString = paramBundle.getExtras().getString("phone_num");
    this.jdField_d_of_type_Boolean = paramBundle.getExtras().getBoolean("allow_set");
    this.jdField_e_of_type_Boolean = paramBundle.getExtras().getBoolean("enable_open_allowset_dev");
    this.f = paramBundle.getExtras().getBoolean("h5_flag");
    this.jdField_e_of_type_JavaLangString = paramBundle.getExtras().getString("secureState", "secureStateUNKNOWN");
    if ("secureStateOk".equals(this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("faceAppId");
      this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("faceTmpKey");
      this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse = new FaceSecureCheck.SecureCheckResponse();
      this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.bool_sec_pass.set(true);
      this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.str_tmpkey.set(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.str_openid.set(this.jdField_c_of_type_JavaLangString);
    }
    if (TextUtils.equals(paramBundle.getExtras().getString("devlock_open_source"), "PhoneUnity")) {
      this.leftView.setText(2131699424);
    }
    if (aoeh.a().b() != aoeh.g)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramBundle = aoeh.a().a();
      if (!TextUtils.isEmpty(paramBundle)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramBundle);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    if (this.app == null) {
      this.app = ((QQAppInterface)getAppRuntime());
    }
    if (this.app == null)
    {
      finish();
      return;
    }
    paramBundle = this.app.getHandler(LoginInfoActivity.class);
    if (paramBundle != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label769;
      }
      paramBundle.obtainMessage(20140331, 1, 0).sendToTarget();
    }
    for (;;)
    {
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131692141));
      }
      try
      {
        this.jdField_a_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "packName = " + this.jdField_a_of_type_JavaLangString);
        }
        addObserver(this.jdField_a_of_type_Ajxl);
        addObserver(this.jdField_a_of_type_Akgf);
        if (aoeh.a().a() == aoeh.c)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131692148));
          if (!this.jdField_a_of_type_Boolean) {
            break label806;
          }
          paramBundle = (akge)this.app.a(34);
          if (paramBundle != null) {
            paramBundle.a();
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          c();
          f();
          return;
          label769:
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
          label806:
          if ((this.jdField_d_of_type_Boolean) && ((aoen.a().c()) || (this.jdField_e_of_type_Boolean))) {
            g();
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
    e();
    removeObserver(this.jdField_a_of_type_Ajxl);
    removeObserver(this.jdField_a_of_type_Akgf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity
 * JD-Core Version:    0.7.0.1
 */