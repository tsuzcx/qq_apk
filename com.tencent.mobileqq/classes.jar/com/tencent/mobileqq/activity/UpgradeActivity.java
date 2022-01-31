package com.tencent.mobileqq.activity;

import acdt;
import acdu;
import acdv;
import acdw;
import acdx;
import acdy;
import acdz;
import acea;
import aceb;
import acec;
import aced;
import acee;
import acef;
import aceg;
import aceh;
import acei;
import acej;
import acek;
import ajjy;
import akgn;
import akgo;
import akgt;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.view.Window;
import awao;
import awqx;
import babr;
import badr;
import bafb;
import bahs;
import baig;
import bcar;
import bcat;
import bcds;
import bcec;
import bchb;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

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
    if (akgo.a().a() == 4)
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
    UpgradeDetailActivity.a(this, akgo.a().a(), false, true, true);
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaLangString = ajjy.a(2131650123);
    this.jdField_c_of_type_JavaLangString = "检测到你的网络环境处于2G/3G下，继续下载QQ将会产生流量。";
    showDialog(8192);
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaLangString = "下载QQ失败";
    this.jdField_c_of_type_JavaLangString = ajjy.a(2131650126);
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
    if (akgo.a().a() == 4) {}
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
      this.jdField_a_of_type_Long = awao.a();
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = akgo.a().a();
    if ((paramBundle == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType <= 0))
    {
      finish();
      return true;
    }
    getWindow().setBackgroundDrawableResource(2131101491);
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
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_b_of_type_Boolean) && (bchb.a().b()))
    {
      if (!bchb.a().f()) {
        badr.a(this);
      }
      finish();
    }
  }
  
  public void onAccountChanged()
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
      ((bafb)localObject1).setCanceledOnTouchOutside(false);
      ((bafb)localObject1).setOnDismissListener(new acec(this));
      return localObject1;
      awqx.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, akgn.b(), String.valueOf(0), akgo.a(), "");
      localObject1 = babr.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
      ((bafb)localObject1).setPositiveButton(2131654774, new acee(this)).setNegativeButton(2131651476, new aced(this)).setOnKeyListener(new acdt(this));
      continue;
      if (this.jdField_d_of_type_Int == 0)
      {
        awqx.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, akgn.b(), String.valueOf(0), akgo.a(), "");
        localObject1 = babr.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        b();
        if (akgo.a().a() == 4) {}
        for (paramInt = 2131627950;; paramInt = 2131654774)
        {
          ((bafb)localObject1).setPositiveButton(paramInt, new aceh(this)).setNegativeButton(2131654773, new aceg(this)).setOnKeyListener(new acef(this));
          break;
        }
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        awqx.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, akgn.b(), String.valueOf(2), akgo.a(), "");
        awqx.b(this.app, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          acei localacei = new acei(this);
          acej localacej = new acej(this);
          if (this.jdField_a_of_type_Boolean) {
            if ((this.g == null) || ("".equals(this.g)))
            {
              localObject1 = ajjy.a(2131650127);
              if ((this.h != null) && (!"".equals(this.h))) {
                break label620;
              }
              str = ajjy.a(2131650120);
              paramInt = baig.aO(this, this.app.c());
              baig.ae(this, this.app.c(), paramInt + 1);
              baig.j(this, this.app.c(), System.currentTimeMillis());
              localObject1 = babr.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, (String)localObject1, str, this.f, localacej, localacei);
              b();
              ((Dialog)localObject1).setCanceledOnTouchOutside(false);
              ((Dialog)localObject1).setOnDismissListener(new acek(this));
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
            label620:
            str = this.h;
          }
          if ((this.jdField_e_of_type_JavaLangString == null) || ("".equals(this.jdField_e_of_type_JavaLangString)))
          {
            localObject2 = ajjy.a(2131650118);
            label657:
            if ((this.jdField_d_of_type_JavaLangString != null) && (!"".equals(this.jdField_d_of_type_JavaLangString))) {
              break label737;
            }
          }
          label737:
          for (String str = ajjy.a(2131650125);; str = this.jdField_d_of_type_JavaLangString)
          {
            paramInt = baig.aN(this, this.app.c());
            baig.ad(this, this.app.c(), paramInt + 1);
            baig.i(this, this.app.c(), System.currentTimeMillis());
            break;
            localObject2 = this.jdField_e_of_type_JavaLangString;
            break label657;
          }
        }
        Object localObject2 = babr.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((bafb)localObject2).setPositiveButton(ajjy.a(2131650124), new acdv(this)).setNegativeButton(ajjy.a(2131650129), new acdu(this));
        continue;
        localObject2 = babr.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((bafb)localObject2).setPositiveButton(ajjy.a(2131650121), new acdx(this)).setNegativeButton(ajjy.a(2131650122), new acdw(this));
        continue;
        long l = System.currentTimeMillis();
        if (l - jdField_c_of_type_Long <= 1000L)
        {
          finish();
          return null;
        }
        jdField_c_of_type_Long = l;
        localObject2 = akgo.a().a();
        if ((localObject2 == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Akgt == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null))
        {
          bcec.a().a(ajjy.a(2131650128));
          finish();
          return null;
        }
        this.jdField_b_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
        this.jdField_c_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          l = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Akgt.jdField_a_of_type_Long;
          bahs.b(true);
          paramInt = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Akgt.jdField_a_of_type_Int;
          bahs.b(paramInt);
          if (bchb.a().b())
          {
            localObject2 = babr.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, new acdy(this), new acdz(this));
            ((bafb)localObject2).setOnDismissListener(new acea(this));
            bcds.b("qqBaseActivity", bcat.a(10010, 1, 1, 100));
            bcds.b("qqBaseActivity", bcat.a(10010, 1, 2, 100));
            bcds.b("qqBaseActivity", bcat.a(10010, 1, 3, 100));
            bcar.a().a(16, bcat.a(10010, 1, 1, 100));
            bcar.a().a(16, bcat.a(10010, 1, 2, 100));
            bcar.a().a(16, bcat.a(10010, 1, 3, 100));
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
          bchb.a().a(false);
          localObject2 = babr.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, "");
          ((badr)localObject2).a(new aceb(this, (badr)localObject2, paramInt), true);
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