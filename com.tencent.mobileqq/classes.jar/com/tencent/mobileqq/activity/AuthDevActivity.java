package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import android.app.Dialog;
import android.content.Intent;
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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.request.Ticket;
import rkl;
import rkm;
import rkn;
import rko;
import rkp;
import rkq;
import rkr;
import rks;
import rkt;
import rku;
import rkv;
import rkw;

public class AuthDevActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler = new rkl(this);
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new rkp(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new rku(this);
  private SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new rkw(this);
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString = "";
  private List jdField_a_of_type_JavaUtilList;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new rkv(this);
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = true;
  private boolean d;
  private boolean e;
  
  private void a(String paramString1, ArrayList paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131436599), 5);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131434024), 3);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.c(2131432998);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new rks(this, paramString2, paramLong, paramString1, paramInt, paramArrayList, paramBoolean1, paramBoolean2));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void a(List paramList)
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
        View localView = getLayoutInflater().inflate(2130970300, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131362731);
        if (j == 1) {
          localRelativeLayout.setBackgroundResource(2130838619);
        }
        for (;;)
        {
          TextView localTextView2 = (TextView)localView.findViewById(2131362736);
          TextView localTextView1 = (TextView)localView.findViewById(2131364095);
          String str = localSvcDevLoginInfo.strDeviceName;
          Object localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = getResources().getString(2131436490);
          }
          str = null;
          if (Arrays.equals(NetConnInfoCenter.GUID, localSvcDevLoginInfo.vecGuid)) {
            str = "（" + getResources().getString(2131436486) + "）";
          }
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject);
          if (!TextUtils.isEmpty(str))
          {
            localSpannableStringBuilder.append(str);
            rkq localrkq = new rkq(this);
            int k = ((String)localObject).length();
            localSpannableStringBuilder.setSpan(localrkq, k, str.length() + k, 33);
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
          localRelativeLayout.setOnClickListener(new rkr(this, localRelativeLayout, i));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          break;
          if (i == 0) {
            localRelativeLayout.setBackgroundResource(2130838631);
          } else if (i == j - 1) {
            localRelativeLayout.setBackgroundResource(2130838626);
          } else {
            localRelativeLayout.setBackgroundResource(2130838629);
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
  
  private void b(String paramString1, ArrayList paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131436490);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    if (paramBoolean1) {}
    for (paramString1 = getString(2131436550, new Object[] { str });; paramString1 = getString(2131436549, new Object[] { str }))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramString1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131436551), 3, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131432998);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new rkt(this, paramString2, paramArrayList, paramInt, paramBoolean2, paramLong));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "startGetAuthDevList.begin to getAuthLoginDevList");
    }
    boolean bool = EquipmentLockImpl.a().c(this.app, this.jdField_a_of_type_JavaLangString, 0L);
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
    this.jdField_a_of_type_AndroidOsHandler.post(new rkn(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new rko(this));
  }
  
  private void f()
  {
    if (!NetworkUtil.d(this)) {
      QQToast.a(this, getString(2131432992), 0).b(getTitleBarHeight());
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          ReportController.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_close", 0, 0, "", "", "", "");
          a();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CheckDevLockSms");
        }
        if (DevlockPhoneStatus.a().a() == DevlockPhoneStatus.c)
        {
          DevlockPhoneStatus.a().a(this, this.jdField_b_of_type_JavaLangString);
          return;
        }
        ReportController.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "0", "", "", "");
        if (this.c) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
      d();
      return;
      d();
      this.c = false;
      String str = this.app.getCurrentAccountUin();
      i = EquipmentLockImpl.a().a(this.app, str, "", null, this.jdField_a_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    this.c = true;
    e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CheckDevLockSms fail ret=" + i);
    }
    QQToast.a(getApplicationContext(), getString(2131436564), 0).b(getTitleBarHeight());
  }
  
  void a()
  {
    int j = 0;
    b();
    Dialog localDialog = new Dialog(this, 2131624515);
    localDialog.setContentView(2130968842);
    Object localObject = (TextView)localDialog.findViewById(2131364010);
    if (localObject != null) {
      ((TextView)localObject).setText(getString(2131436552));
    }
    TextView localTextView = (TextView)localDialog.findViewById(2131362758);
    int i;
    if (localTextView != null)
    {
      localObject = (MessageRoamManager)this.app.getManager(91);
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((MessageRoamManager)localObject).g())
        {
          if (((MessageRoamManager)localObject).b() != 1) {
            break label223;
          }
          i = 1;
        }
      }
      if (i == 0) {
        break label228;
      }
    }
    label223:
    label228:
    for (localObject = getString(2131436554);; localObject = getString(2131436553))
    {
      localTextView.setText((CharSequence)localObject);
      localObject = (TextView)localDialog.findViewById(2131364013);
      if (localObject != null) {
        ((TextView)localObject).setText(2131434920);
      }
      localTextView = (TextView)localDialog.findViewById(2131364014);
      if (localTextView != null) {
        localTextView.setText(2131432998);
      }
      localDialog.setOnDismissListener(new rkm(this));
      if (localObject != null) {
        ((TextView)localObject).setOnClickListener(this);
      }
      if (localTextView != null) {
        localTextView.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidAppDialog = localDialog;
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      i = 0;
      break;
    }
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1003) && (paramIntent != null))
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null) {
        break label28;
      }
    }
    label28:
    label92:
    do
    {
      return;
      paramInt1 = paramIntent.getInt("resultState", 1);
      paramInt2 = paramIntent.getInt("emergency_phone_state", 1);
      if (paramInt1 == 2)
      {
        DevlockPhoneStatus.a().a(DevlockPhoneStatus.d);
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
        DevlockPhoneStatus.a().b(DevlockPhoneStatus.f);
      }
      for (;;)
      {
        paramIntent = paramIntent.getString("emergency_phone_mask");
        if (paramInt2 != 4) {
          break label204;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131436604));
        DevlockPhoneStatus.a().a(paramIntent);
        return;
        if (paramInt1 != 3) {
          break;
        }
        DevlockPhoneStatus.a().a(DevlockPhoneStatus.c);
        DevlockPhoneStatus.a().a(0L);
        break;
        if (paramInt1 != 3) {
          break label92;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131436612));
        break label92;
        if (paramInt2 != 1) {
          DevlockPhoneStatus.a().b(DevlockPhoneStatus.h);
        }
      }
    } while ((paramInt2 == 1) || (TextUtils.isEmpty(paramIntent)));
    label165:
    label187:
    label204:
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramIntent);
    DevlockPhoneStatus.a().a(paramIntent);
  }
  
  protected boolean onBackEvent()
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
      finish();
      return false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    int i;
    do
    {
      do
      {
        return;
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "http://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
        paramView.putExtra("hide_more_button", true);
        startActivity(paramView);
        return;
        f();
        return;
        this.app.sendWirelessMeibaoReq(1);
        ReportController.b(this.app, "CliOper", "", "", "My_eq_lock", "Clk_protect_detail", 0, 0, "", "", "", "");
        if ((TextUtils.isEmpty(this.app.getCurrentAccountUin())) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick current is empty");
        }
        EquipLockWebEntrance.a(this, this.app, EquipLockWebEntrance.a, 1003, null);
        return;
        EquipLockWebEntrance.a(this, this.app, EquipLockWebEntrance.b, 1003, null);
        return;
        b();
        return;
        b();
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CloseDevLock");
        }
        if (this.c) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
      d();
      return;
      d();
      this.c = false;
      paramView = this.app.getCurrentAccountUin();
      i = EquipmentLockImpl.a().a(this.app, paramView, this.jdField_a_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    e();
    this.c = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CloseDevLock fail ret =" + i);
    }
    QQToast.a(getApplicationContext(), getString(2131436563), 0).b(getTitleBarHeight());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130970299);
    super.setTitle(2131436535);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131369963));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131369970));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131363448));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131369964));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131369965));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131369961));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369969));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131369967));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369968));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131433499);
    if (AppSetting.jdField_b_of_type_Boolean) {
      this.rightViewText.setContentDescription(getString(2131436545));
    }
    this.rightViewText.setOnClickListener(this);
    paramBundle = super.getIntent();
    this.jdField_a_of_type_Boolean = paramBundle.getExtras().getBoolean("auth_dev_open");
    this.jdField_b_of_type_JavaLangString = paramBundle.getExtras().getString("phone_num");
    this.d = paramBundle.getExtras().getBoolean("allow_set");
    this.e = paramBundle.getExtras().getBoolean("enable_open_allowset_dev");
    if (TextUtils.equals(paramBundle.getExtras().getString("devlock_open_source"), "PhoneUnity")) {
      this.leftView.setText(2131436777);
    }
    if (DevlockPhoneStatus.a().b() != DevlockPhoneStatus.g)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramBundle = DevlockPhoneStatus.a().a();
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
        break label628;
      }
      paramBundle.obtainMessage(20140331, 1, 0).sendToTarget();
    }
    for (;;)
    {
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131436535));
      }
      try
      {
        this.jdField_a_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "packName = " + this.jdField_a_of_type_JavaLangString);
        }
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
        if (DevlockPhoneStatus.a().a() == DevlockPhoneStatus.c)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131436612));
          if (!this.jdField_a_of_type_Boolean) {
            break label665;
          }
          paramBundle = (SecSvcHandler)this.app.a(34);
          if (paramBundle != null) {
            paramBundle.b();
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          c();
          return;
          label628:
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
        }
        label665:
        if ((this.d) && ((EquipmentLockImpl.a().c()) || (this.e)))
        {
          f();
          return;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    e();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity
 * JD-Core Version:    0.7.0.1
 */