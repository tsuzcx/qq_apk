package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import aaba;
import aabb;
import aabc;
import aabd;
import aabe;
import aabf;
import aabg;
import aabh;
import aabi;
import aabj;
import aabk;
import ajjh;
import ajmp;
import ajru;
import ajrv;
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
import annw;
import anny;
import anoc;
import awcq;
import awqx;
import badq;
import bbms;
import bbmy;
import begr;
import behe;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
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
  private ajjh jdField_a_of_type_Ajjh = new aabi(this);
  private ajrv jdField_a_of_type_Ajrv = new aabk(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler = new aaba(this);
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aabd(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbms jdField_a_of_type_Bbms;
  private begr jdField_a_of_type_Begr;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_a_of_type_JavaLangString = "";
  private List<SvcDevLoginInfo> jdField_a_of_type_JavaUtilList;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aabj(this);
  private oidb_0x5e1.RspBody jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private begr jdField_b_of_type_Begr;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d;
  private boolean e;
  private boolean f;
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody != null) && (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.size() != 0))
    {
      ((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.set(paramInt);
      FormSimpleItem localFormSimpleItem = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (paramInt == 1) {}
      for (String str = getString(2131626690);; str = getString(2131626697))
      {
        localFormSimpleItem.setRightText(str);
        return;
      }
    }
    QLog.e("Q.devlock.AuthDevActivity", 1, "refreshUserFaceState mFAceStateRsp is null or rpt_msg_uin_data is empty");
  }
  
  private void a(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    this.jdField_b_of_type_Begr = ((begr)behe.a(this, null));
    this.jdField_b_of_type_Begr.a(getResources().getString(2131626578), 5);
    this.jdField_b_of_type_Begr.a(getResources().getString(2131625931), 3);
    this.jdField_b_of_type_Begr.c(2131625035);
    this.jdField_b_of_type_Begr.a(new aabg(this, paramString2, paramLong, paramString1, paramInt, paramArrayList, paramBoolean1, paramBoolean2));
    this.jdField_b_of_type_Begr.show();
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
        View localView = getLayoutInflater().inflate(2131495151, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131302722);
        if (j == 1) {
          localRelativeLayout.setBackgroundResource(2130839144);
        }
        for (;;)
        {
          TextView localTextView2 = (TextView)localView.findViewById(2131304981);
          TextView localTextView1 = (TextView)localView.findViewById(2131302466);
          String str = localSvcDevLoginInfo.strDeviceName;
          Object localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = getResources().getString(2131628832);
          }
          str = null;
          if (Arrays.equals(NetConnInfoCenter.GUID, localSvcDevLoginInfo.vecGuid)) {
            str = "（" + getResources().getString(2131628829) + "）";
          }
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject);
          if (!TextUtils.isEmpty(str))
          {
            localSpannableStringBuilder.append(str);
            aabe localaabe = new aabe(this);
            int k = ((String)localObject).length();
            localSpannableStringBuilder.setSpan(localaabe, k, str.length() + k, 33);
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
          localRelativeLayout.setOnClickListener(new aabf(this, localRelativeLayout, i));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          break;
          if (i == 0) {
            localRelativeLayout.setBackgroundResource(2130839160);
          } else if (i == j - 1) {
            localRelativeLayout.setBackgroundResource(2130839151);
          } else {
            localRelativeLayout.setBackgroundResource(2130839154);
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
      str = getResources().getString(2131628832);
    }
    this.jdField_a_of_type_Begr = ((begr)behe.a(this, null));
    if (paramBoolean1) {}
    for (paramString1 = getString(2131626536, new Object[] { str });; paramString1 = getString(2131626535, new Object[] { str }))
    {
      this.jdField_a_of_type_Begr.a(paramString1);
      this.jdField_a_of_type_Begr.a(getResources().getString(2131626534), 3, false);
      this.jdField_a_of_type_Begr.c(2131625035);
      this.jdField_a_of_type_Begr.a(new aabh(this, paramString2, paramArrayList, paramInt, paramBoolean2, paramLong));
      this.jdField_a_of_type_Begr.show();
      return;
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "startGetAuthDevList.begin to getAuthLoginDevList");
    }
    boolean bool = anoc.a().c(this.app, this.jdField_a_of_type_JavaLangString, 0L);
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
    awcq.a(this.app, getCurrentAccountUin(), new aabc(this));
  }
  
  private void g()
  {
    if (!badq.d(this)) {
      bbmy.a(this, getString(2131626719), 0).b(getTitleBarHeight());
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          awqx.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_close", 0, 0, "", "", "", "");
          awqx.b(null, "dc00898", "", "", "0X800A71C", "0X800A71C", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("DevRpt", 2, "登录保护页点击开关，关闭登录保护的用户数、次数！0X800A71C");
          }
          a();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CheckDevLockSms");
        }
        if (annw.a().a() == annw.c)
        {
          annw.a().a(this, this.jdField_b_of_type_JavaLangString);
          return;
        }
        awqx.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "0", "", "", "");
        awqx.b(null, "dc00898", "", "", "0X800A71B", "0X800A71B", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "登录保护页点击开关，开启登录保护的用户数、次数！0X800A71B");
        }
        if (this.jdField_c_of_type_Boolean) {
          break;
        }
      } while ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()));
      d();
      return;
      d();
      this.jdField_c_of_type_Boolean = false;
      String str = this.app.getCurrentAccountUin();
      i = anoc.a().a(this.app, str, "", null, this.jdField_a_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    this.jdField_c_of_type_Boolean = true;
    e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CheckDevLockSms fail ret=" + i);
    }
    bbmy.a(getApplicationContext(), getString(2131626558), 0).b(getTitleBarHeight());
  }
  
  void a()
  {
    b();
    Dialog localDialog = new Dialog(this, 2131690181);
    localDialog.setContentView(2131493323);
    TextView localTextView = (TextView)localDialog.findViewById(2131299583);
    if (localTextView != null) {
      localTextView.setText(getString(2131626521));
    }
    localTextView = (TextView)localDialog.findViewById(2131299579);
    if (localTextView != null)
    {
      localObject = (ajmp)this.app.getManager(92);
      if ((localObject != null) && (((ajmp)localObject).h()) && (((ajmp)localObject).b() == 1)) {}
      localTextView.setText(getString(2131626520));
    }
    localTextView = (TextView)localDialog.findViewById(2131299568);
    if (localTextView != null) {
      localTextView.setText(2131625271);
    }
    Object localObject = (TextView)localDialog.findViewById(2131299574);
    if (localObject != null) {
      ((TextView)localObject).setText(2131625035);
    }
    localDialog.setOnDismissListener(new aabb(this));
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
          annw.a().a(annw.d);
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
          annw.a().b(annw.f);
        }
        for (;;)
        {
          paramIntent = paramIntent.getString("emergency_phone_mask");
          if (paramInt2 != 4) {
            break label204;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131626541));
          annw.a().a(paramIntent);
          return;
          if (paramInt1 != 3) {
            break;
          }
          annw.a().a(annw.c);
          annw.a().a(0L);
          break;
          if (paramInt1 != 3) {
            break label92;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131626562));
          break label92;
          if (paramInt2 != 1) {
            annw.a().b(annw.h);
          }
        }
      } while ((paramInt2 == 1) || (TextUtils.isEmpty(paramIntent)));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramIntent);
      annw.a().a(paramIntent);
      return;
      if (paramInt1 == 3)
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
    } while ((paramInt1 != 4) || (paramInt2 != -1));
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
    case 2131302832: 
    case 2131297340: 
    case 2131310004: 
    case 2131299979: 
    case 2131299574: 
    case 2131299568: 
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
          awqx.b(null, "dc00898", "", "", "0X800A720", "0X800A720", 0, 0, "", "", "", "");
          if (QLog.isColorLevel())
          {
            QLog.d("DevRpt", 2, "点击帮助！0X800A720");
            return;
            g();
            return;
            this.app.sendWirelessMeibaoReq(1);
            awqx.b(this.app, "CliOper", "", "", "My_eq_lock", "Clk_protect_detail", 0, 0, "", "", "", "");
            if ((TextUtils.isEmpty(this.app.getCurrentAccountUin())) && (QLog.isColorLevel())) {
              QLog.d("Q.devlock.AuthDevActivity", 2, "onClick current is empty");
            }
            anny.a(this, this.app, anny.a, 1003, null);
            return;
            anny.a(this, this.app, anny.b, 1003, null);
            return;
            b();
            awqx.b(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickCancel", "dialogRightBtn", 0, 1, "", "", "", "");
            awqx.b(null, "dc00898", "", "", "0X800A71E", "0X800A71E", 0, 0, "", "", "", "");
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
                awqx.b(null, "dc00898", "", "", "0X800A71D", "0X800A71D", 0, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                  QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击关闭！0X800A71D");
                }
                awqx.b(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickClose", "dialogLeftBtn", 0, 2, "", "", "", "");
                if (QLog.isColorLevel()) {
                  QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CloseDevLock");
                }
                if (!this.jdField_c_of_type_Boolean)
                {
                  if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
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
                i = anoc.a().a(this.app, paramView, this.jdField_a_of_type_MqqObserverWtloginObserver);
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
      bbmy.a(getApplicationContext(), getString(2131626519), 0).b(getTitleBarHeight());
      return;
    }
    awqx.b(null, "dc00898", "", "", "0X800A31B", "0X800A31B", 0, 0, "", "", "", "");
    if (annw.a().a() == annw.c)
    {
      bbmy.a(getApplicationContext(), getString(2131626698), 0).b(getTitleBarHeight());
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
    if (((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() == 0)
    {
      Intent localIntent = new Intent(this, AuthDevVerifyCodeActivity.class);
      localIntent.putExtra("k_from", "f_SetFaceData");
      if (this.jdField_b_of_type_JavaLangString == null) {}
      for (paramView = "";; paramView = this.jdField_b_of_type_JavaLangString)
      {
        localIntent.putExtra("phone_num", paramView);
        startActivityForResult(localIntent, 3);
        return;
      }
    }
    PublicFragmentActivity.a(this, DeleteFaceFragment.class, 4);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131495150);
    super.setTitle(2131626555);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131310004));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131297334));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131306334));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131299979));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300280));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131299977));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131297340));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297336));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131313683));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131313682));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131627633);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.rightViewText.setContentDescription(getString(2131626514));
    }
    this.rightViewText.setOnClickListener(this);
    paramBundle = super.getIntent();
    this.jdField_a_of_type_Boolean = paramBundle.getExtras().getBoolean("auth_dev_open");
    this.jdField_b_of_type_JavaLangString = paramBundle.getExtras().getString("phone_num");
    this.d = paramBundle.getExtras().getBoolean("allow_set");
    this.e = paramBundle.getExtras().getBoolean("enable_open_allowset_dev");
    this.f = paramBundle.getExtras().getBoolean("h5_flag");
    if (TextUtils.equals(paramBundle.getExtras().getString("devlock_open_source"), "PhoneUnity")) {
      this.leftView.setText(2131633655);
    }
    if (annw.a().b() != annw.g)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramBundle = annw.a().a();
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
      super.finish();
      return;
    }
    paramBundle = this.app.getHandler(LoginInfoActivity.class);
    if (paramBundle != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label667;
      }
      paramBundle.obtainMessage(20140331, 1, 0).sendToTarget();
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131626555));
      }
      try
      {
        this.jdField_a_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "packName = " + this.jdField_a_of_type_JavaLangString);
        }
        addObserver(this.jdField_a_of_type_Ajjh);
        addObserver(this.jdField_a_of_type_Ajrv);
        if (annw.a().a() == annw.c)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131626562));
          if (!this.jdField_a_of_type_Boolean) {
            break label704;
          }
          paramBundle = (ajru)this.app.a(34);
          if (paramBundle != null) {
            paramBundle.a();
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          c();
          f();
          return;
          label667:
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
          label704:
          if ((this.d) && ((anoc.a().c()) || (this.e))) {
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
    removeObserver(this.jdField_a_of_type_Ajjh);
    removeObserver(this.jdField_a_of_type_Ajrv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity
 * JD-Core Version:    0.7.0.1
 */