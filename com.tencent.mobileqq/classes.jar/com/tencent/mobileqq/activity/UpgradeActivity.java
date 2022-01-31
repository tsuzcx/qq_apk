package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeConstants;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NewUpgradeDialog;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SPSettings;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appcircle.st.STUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;
import ukl;
import ukm;
import ukn;
import uko;
import ukp;
import ukq;
import ukr;
import ukt;
import uku;
import ukv;
import ukw;
import ukx;
import uky;
import ukz;
import ula;
import ulb;
import ulc;
import uld;

public class UpgradeActivity
  extends BaseActivity
{
  private static long jdField_c_of_type_Long;
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  private String h;
  
  private void a(boolean paramBoolean)
  {
    if (UpgradeController.a().a() == 4)
    {
      Object localObject = this.app.getHandler(Conversation.class);
      if (localObject != null)
      {
        localObject = ((MqqHandler)localObject).obtainMessage(1134018);
        ((Message)localObject).obj = this;
        ((Message)localObject).sendToTarget();
      }
      return;
    }
    UpgradeDetailActivity.a(this, UpgradeController.a().a(), false, true, true);
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaLangString = "下载暂停";
    this.jdField_c_of_type_JavaLangString = "检测到你的网络环境处于2G/3G下，继续下载QQ将会产生流量。";
    showDialog(8192);
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaLangString = "下载QQ失败";
    this.jdField_c_of_type_JavaLangString = "未能更新QQ新版本，点击“重试”继续下载。";
    showDialog(16384);
  }
  
  private void e()
  {
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("StrTitle");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("StrUpgradeDesc");
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("StrUrl");
    this.f = getIntent().getStringExtra("strDesc");
    this.g = getIntent().getStringExtra("lBtnText");
    this.h = getIntent().getStringExtra("rBtnText");
    this.jdField_c_of_type_Int = getIntent().getIntExtra("iUpgradeType", 0);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("iTipsType", 0);
    if (getIntent().hasExtra("strConfirmBtnText")) {
      this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("strConfirmBtnText");
    }
    if (getIntent().hasExtra("strCancelButtonDesc")) {
      this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("strCancelButtonDesc");
    }
    if (UpgradeController.a().a() == 4) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_Long = getIntent().getLongExtra("showTime", 0L);
      this.jdField_b_of_type_Int = getIntent().getIntExtra("iUpgradeSdkId", 0);
      this.jdField_e_of_type_Int = getIntent().getIntExtra("rate", 1);
      i = getIntent().getIntExtra("mode", 0);
      if (this.jdField_c_of_type_Int != 2) {
        break;
      }
      showDialog(2);
      return;
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_Long = MessageCache.a();
      Object localObject = this.app.getPreferences();
      ((SharedPreferences)localObject).getInt("upgrade_tip_count", 0);
      if (i == 0)
      {
        if (((SharedPreferences)localObject).getLong("upgrade_tip_time", 0L) == 0L)
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putLong("upgrade_tip_time", this.jdField_a_of_type_Long);
          ((SharedPreferences.Editor)localObject).commit();
          showDialog(1);
          return;
        }
        localObject = this.app.getHandler(Conversation.class);
        if (this.jdField_a_of_type_Boolean) {
          if (localObject != null) {
            ((MqqHandler)localObject).obtainMessage(1134018).sendToTarget();
          }
        }
        for (;;)
        {
          finish();
          return;
          if (localObject != null) {
            ((MqqHandler)localObject).sendEmptyMessage(11340003);
          }
        }
      }
      showDialog(1);
      return;
    }
    if (this.jdField_c_of_type_Int == 3)
    {
      showDialog(3);
      return;
    }
    finish();
  }
  
  private void f() {}
  
  private void g() {}
  
  public void a()
  {
    finish();
    this.app.b(false);
  }
  
  void b()
  {
    if (this.app != null)
    {
      localSharedPreferences = this.app.getPreferences();
      i = localSharedPreferences.getInt("upgrade_tip_count", 0);
      if (i < 1) {
        localSharedPreferences.edit().putInt("upgrade_tip_count", i + 1).commit();
      }
    }
    while (!QLog.isColorLevel())
    {
      SharedPreferences localSharedPreferences;
      int i;
      return;
    }
    QLog.i("UpgradeActivty", 2, "UpgradeTipCounter --- app is null");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = UpgradeController.a().a();
    if ((paramBundle == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType <= 0))
    {
      finish();
      return true;
    }
    getWindow().setBackgroundDrawableResource(2131492924);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("activity_type", 4096);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      finish();
      return true;
    case 4096: 
      e();
      return true;
    case 8192: 
      c();
      return true;
    }
    d();
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_b_of_type_Boolean) && (MyAppApi.a().b()))
    {
      if (!MyAppApi.a().f()) {
        NewUpgradeDialog.a(this);
      }
      finish();
    }
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    finish();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject1 = null;
    switch (paramInt)
    {
    }
    while (localObject1 != null)
    {
      ((QQCustomDialog)localObject1).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject1).setOnDismissListener(new ukv(this));
      return localObject1;
      ReportController.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(0), UpgradeController.a(), "");
      localObject1 = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
      ((QQCustomDialog)localObject1).setPositiveButton(2131433812, new ukx(this)).setNegativeButton(2131433815, new ukw(this)).setOnKeyListener(new ukl(this));
      continue;
      if (this.jdField_d_of_type_Int == 0)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(0), UpgradeController.a(), "");
        localObject1 = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        b();
        if (UpgradeController.a().a() == 4) {}
        for (paramInt = 2131433813;; paramInt = 2131433812)
        {
          ((QQCustomDialog)localObject1).setPositiveButton(paramInt, new ula(this)).setNegativeButton(2131433814, new ukz(this)).setOnKeyListener(new uky(this));
          break;
        }
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(2), UpgradeController.a(), "");
        ReportController.b(this.app, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          ulb localulb = new ulb(this);
          ulc localulc = new ulc(this);
          if (this.jdField_a_of_type_Boolean) {
            if ((this.g == null) || ("".equals(this.g)))
            {
              localObject1 = "稍后处理";
              if ((this.h != null) && (!"".equals(this.h))) {
                break label574;
              }
              str = "立即安装";
              localObject1 = DialogUtil.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, (String)localObject1, str, this.f, localulc, localulb);
              b();
              ((Dialog)localObject1).setCanceledOnTouchOutside(false);
              ((Dialog)localObject1).setOnDismissListener(new uld(this));
              return localObject1;
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QLog.d("UpgradeActivty", 2, "parse dialog wording error!");
            localException1.printStackTrace();
            continue;
            localObject2 = this.g;
            continue;
            label574:
            str = this.h;
          }
          if ((this.jdField_e_of_type_JavaLangString == null) || ("".equals(this.jdField_e_of_type_JavaLangString)))
          {
            localObject2 = "稍后处理";
            label608:
            if ((this.jdField_d_of_type_JavaLangString != null) && (!"".equals(this.jdField_d_of_type_JavaLangString))) {
              break label645;
            }
          }
          label645:
          for (String str = "马上升级";; str = this.jdField_d_of_type_JavaLangString)
          {
            break;
            localObject2 = this.jdField_e_of_type_JavaLangString;
            break label608;
          }
        }
        Object localObject2 = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((QQCustomDialog)localObject2).setPositiveButton("继续下载", new ukn(this)).setNegativeButton("取消", new ukm(this));
        continue;
        localObject2 = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((QQCustomDialog)localObject2).setPositiveButton("重试", new ukp(this)).setNegativeButton("取消", new uko(this));
        continue;
        long l = System.currentTimeMillis();
        if (l - jdField_c_of_type_Long <= 1000L)
        {
          finish();
          return null;
        }
        jdField_c_of_type_Long = l;
        localObject2 = UpgradeController.a().a();
        if ((localObject2 == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null))
        {
          ToastUtil.a().a("更新信息不全，无法更新");
          finish();
          return null;
        }
        this.jdField_b_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
        this.jdField_c_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          l = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Long;
          SPSettings.b(true);
          paramInt = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;
          SPSettings.b(paramInt);
          if (MyAppApi.a().b())
          {
            localObject2 = DialogUtil.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, new ukq(this), new ukr(this));
            ((QQCustomDialog)localObject2).setOnDismissListener(new ukt(this));
            LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 1, 100));
            LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 2, 100));
            LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 3, 100));
            AppCircleReportManager.a().a(16, STUtils.a(10010, 1, 1, 100));
            AppCircleReportManager.a().a(16, STUtils.a(10010, 1, 2, 100));
            AppCircleReportManager.a().a(16, STUtils.a(10010, 1, 3, 100));
            return localObject2;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            QLog.d("UpgradeActivty", 2, "parse dialog wording error!");
            localException2.printStackTrace();
          }
          this.jdField_b_of_type_Boolean = true;
          MyAppApi.a().a(false);
          localObject2 = DialogUtil.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, "");
          ((NewUpgradeDialog)localObject2).a(new uku(this, (NewUpgradeDialog)localObject2, paramInt), true);
          return localObject2;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UpgradeActivity
 * JD-Core Version:    0.7.0.1
 */