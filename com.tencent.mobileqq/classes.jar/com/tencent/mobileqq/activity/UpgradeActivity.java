package com.tencent.mobileqq.activity;

import acoe;
import acof;
import acog;
import acoh;
import acoi;
import acoj;
import acok;
import acol;
import acom;
import acon;
import acoo;
import acop;
import acoq;
import acor;
import acos;
import acot;
import acou;
import acov;
import ajya;
import akuy;
import akuz;
import akve;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.view.Window;
import awzy;
import axqy;
import bbdj;
import bbfk;
import bbgu;
import bbjm;
import bbkb;
import bdfh;
import bdfj;
import bdii;
import bdis;
import bdlr;
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
    if (akuz.a().a() == 4)
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
    UpgradeDetailActivity.a(this, akuz.a().a(), false, true, true);
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaLangString = ajya.a(2131715925);
    this.jdField_c_of_type_JavaLangString = "检测到你的网络环境处于2G/3G下，继续下载QQ将会产生流量。";
    showDialog(8192);
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaLangString = "下载QQ失败";
    this.jdField_c_of_type_JavaLangString = ajya.a(2131715928);
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
    if (akuz.a().a() == 4) {}
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
      this.jdField_a_of_type_Long = awzy.a();
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
    paramBundle = akuz.a().a();
    if ((paramBundle == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType <= 0))
    {
      finish();
      return true;
    }
    getWindow().setBackgroundDrawableResource(2131167087);
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
    if ((this.jdField_b_of_type_Boolean) && (bdlr.a().b()))
    {
      if (!bdlr.a().f()) {
        bbfk.a(this);
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
      ((bbgu)localObject1).setCanceledOnTouchOutside(false);
      ((bbgu)localObject1).setOnDismissListener(new acon(this));
      return localObject1;
      axqy.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, akuy.b(), String.valueOf(0), akuz.a(), "");
      localObject1 = bbdj.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
      ((bbgu)localObject1).setPositiveButton(2131720683, new acop(this)).setNegativeButton(2131717279, new acoo(this)).setOnKeyListener(new acoe(this));
      continue;
      if (this.jdField_d_of_type_Int == 0)
      {
        axqy.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, akuy.b(), String.valueOf(0), akuz.a(), "");
        localObject1 = bbdj.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        b();
        if (akuz.a().a() == 4) {}
        for (paramInt = 2131693592;; paramInt = 2131720683)
        {
          ((bbgu)localObject1).setPositiveButton(paramInt, new acos(this)).setNegativeButton(2131720682, new acor(this)).setOnKeyListener(new acoq(this));
          break;
        }
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        axqy.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, akuy.b(), String.valueOf(2), akuz.a(), "");
        axqy.b(this.app, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          acot localacot = new acot(this);
          acou localacou = new acou(this);
          if (this.jdField_a_of_type_Boolean) {
            if ((this.g == null) || ("".equals(this.g)))
            {
              localObject1 = ajya.a(2131715929);
              if ((this.h != null) && (!"".equals(this.h))) {
                break label620;
              }
              str = ajya.a(2131715922);
              paramInt = bbkb.aO(this, this.app.c());
              bbkb.ae(this, this.app.c(), paramInt + 1);
              bbkb.j(this, this.app.c(), System.currentTimeMillis());
              localObject1 = bbdj.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, (String)localObject1, str, this.f, localacou, localacot);
              b();
              ((Dialog)localObject1).setCanceledOnTouchOutside(false);
              ((Dialog)localObject1).setOnDismissListener(new acov(this));
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
            localObject2 = ajya.a(2131715920);
            label657:
            if ((this.jdField_d_of_type_JavaLangString != null) && (!"".equals(this.jdField_d_of_type_JavaLangString))) {
              break label737;
            }
          }
          label737:
          for (String str = ajya.a(2131715927);; str = this.jdField_d_of_type_JavaLangString)
          {
            paramInt = bbkb.aN(this, this.app.c());
            bbkb.ad(this, this.app.c(), paramInt + 1);
            bbkb.i(this, this.app.c(), System.currentTimeMillis());
            break;
            localObject2 = this.jdField_e_of_type_JavaLangString;
            break label657;
          }
        }
        Object localObject2 = bbdj.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((bbgu)localObject2).setPositiveButton(ajya.a(2131715926), new acog(this)).setNegativeButton(ajya.a(2131715931), new acof(this));
        continue;
        localObject2 = bbdj.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((bbgu)localObject2).setPositiveButton(ajya.a(2131715923), new acoi(this)).setNegativeButton(ajya.a(2131715924), new acoh(this));
        continue;
        long l = System.currentTimeMillis();
        if (l - jdField_c_of_type_Long <= 1000L)
        {
          finish();
          return null;
        }
        jdField_c_of_type_Long = l;
        localObject2 = akuz.a().a();
        if ((localObject2 == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Akve == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null))
        {
          bdis.a().a(ajya.a(2131715930));
          finish();
          return null;
        }
        this.jdField_b_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
        this.jdField_c_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          l = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Akve.jdField_a_of_type_Long;
          bbjm.b(true);
          paramInt = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Akve.jdField_a_of_type_Int;
          bbjm.b(paramInt);
          if (bdlr.a().b())
          {
            localObject2 = bbdj.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, new acoj(this), new acok(this));
            ((bbgu)localObject2).setOnDismissListener(new acol(this));
            bdii.b("qqBaseActivity", bdfj.a(10010, 1, 1, 100));
            bdii.b("qqBaseActivity", bdfj.a(10010, 1, 2, 100));
            bdii.b("qqBaseActivity", bdfj.a(10010, 1, 3, 100));
            bdfh.a().a(16, bdfj.a(10010, 1, 1, 100));
            bdfh.a().a(16, bdfj.a(10010, 1, 2, 100));
            bdfh.a().a(16, bdfj.a(10010, 1, 3, 100));
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
          bdlr.a().a(false);
          localObject2 = bbdj.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, "");
          ((bbfk)localObject2).a(new acom(this, (bbfk)localObject2, paramInt), true);
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