package com.tencent.mobileqq.activity;

import aefo;
import aefp;
import aefq;
import aefr;
import aefs;
import aeft;
import aefu;
import aefv;
import aefw;
import aefx;
import aefy;
import aefz;
import aega;
import aegb;
import aegc;
import aegd;
import aege;
import aegf;
import alpo;
import amlo;
import amlp;
import amlu;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.view.Window;
import ayvc;
import azmj;
import bdcd;
import bdef;
import bdfq;
import bdii;
import bdiv;
import bfef;
import bfeh;
import bfhg;
import bfhq;
import bfko;
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
    if (amlp.a().a() == 4)
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
    UpgradeDetailActivity.a(this, amlp.a().a(), false, true, true);
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaLangString = alpo.a(2131716297);
    this.jdField_c_of_type_JavaLangString = "检测到你的网络环境处于2G/3G下，继续下载QQ将会产生流量。";
    showDialog(8192);
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaLangString = "下载QQ失败";
    this.jdField_c_of_type_JavaLangString = alpo.a(2131716300);
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
    if (amlp.a().a() == 4) {}
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
      this.jdField_a_of_type_Long = ayvc.a();
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
    paramBundle = amlp.a().a();
    if ((paramBundle == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType <= 0))
    {
      finish();
      return true;
    }
    getWindow().setBackgroundDrawableResource(2131167138);
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
    if ((this.jdField_b_of_type_Boolean) && (bfko.a().b()))
    {
      if (!bfko.a().f()) {
        bdef.a(this);
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
      ((bdfq)localObject1).setCanceledOnTouchOutside(false);
      ((bdfq)localObject1).setOnDismissListener(new aefx(this));
      return localObject1;
      azmj.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, amlo.b(), String.valueOf(0), amlp.a(), "");
      localObject1 = bdcd.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
      ((bdfq)localObject1).setPositiveButton(2131721223, new aefz(this)).setNegativeButton(2131717651, new aefy(this)).setOnKeyListener(new aefo(this));
      continue;
      if (this.jdField_d_of_type_Int == 0)
      {
        azmj.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, amlo.b(), String.valueOf(0), amlp.a(), "");
        localObject1 = bdcd.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        b();
        if (amlp.a().a() == 4) {}
        for (paramInt = 2131693693;; paramInt = 2131721223)
        {
          ((bdfq)localObject1).setPositiveButton(paramInt, new aegc(this)).setNegativeButton(2131721222, new aegb(this)).setOnKeyListener(new aega(this));
          break;
        }
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        azmj.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, amlo.b(), String.valueOf(2), amlp.a(), "");
        azmj.b(this.app, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          aegd localaegd = new aegd(this);
          aege localaege = new aege(this);
          if (this.jdField_a_of_type_Boolean) {
            if ((this.g == null) || ("".equals(this.g)))
            {
              localObject1 = alpo.a(2131716301);
              if ((this.h != null) && (!"".equals(this.h))) {
                break label620;
              }
              str = alpo.a(2131716294);
              paramInt = bdiv.aP(this, this.app.c());
              bdiv.af(this, this.app.c(), paramInt + 1);
              bdiv.j(this, this.app.c(), System.currentTimeMillis());
              localObject1 = bdcd.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, (String)localObject1, str, this.f, localaege, localaegd);
              b();
              ((Dialog)localObject1).setCanceledOnTouchOutside(false);
              ((Dialog)localObject1).setOnDismissListener(new aegf(this));
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
            localObject2 = alpo.a(2131716292);
            label657:
            if ((this.jdField_d_of_type_JavaLangString != null) && (!"".equals(this.jdField_d_of_type_JavaLangString))) {
              break label737;
            }
          }
          label737:
          for (String str = alpo.a(2131716299);; str = this.jdField_d_of_type_JavaLangString)
          {
            paramInt = bdiv.aO(this, this.app.c());
            bdiv.ae(this, this.app.c(), paramInt + 1);
            bdiv.i(this, this.app.c(), System.currentTimeMillis());
            break;
            localObject2 = this.jdField_e_of_type_JavaLangString;
            break label657;
          }
        }
        Object localObject2 = bdcd.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((bdfq)localObject2).setPositiveButton(alpo.a(2131716298), new aefq(this)).setNegativeButton(alpo.a(2131716303), new aefp(this));
        continue;
        localObject2 = bdcd.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((bdfq)localObject2).setPositiveButton(alpo.a(2131716295), new aefs(this)).setNegativeButton(alpo.a(2131716296), new aefr(this));
        continue;
        long l = System.currentTimeMillis();
        if (l - jdField_c_of_type_Long <= 1000L)
        {
          finish();
          return null;
        }
        jdField_c_of_type_Long = l;
        localObject2 = amlp.a().a();
        if ((localObject2 == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Amlu == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null))
        {
          bfhq.a().a(alpo.a(2131716302));
          finish();
          return null;
        }
        this.jdField_b_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
        this.jdField_c_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          l = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Amlu.jdField_a_of_type_Long;
          bdii.b(true);
          paramInt = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Amlu.jdField_a_of_type_Int;
          bdii.b(paramInt);
          if (bfko.a().b())
          {
            localObject2 = bdcd.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, new aeft(this), new aefu(this));
            ((bdfq)localObject2).setOnDismissListener(new aefv(this));
            bfhg.b("qqBaseActivity", bfeh.a(10010, 1, 1, 100));
            bfhg.b("qqBaseActivity", bfeh.a(10010, 1, 2, 100));
            bfhg.b("qqBaseActivity", bfeh.a(10010, 1, 3, 100));
            bfef.a().a(16, bfeh.a(10010, 1, 1, 100));
            bfef.a().a(16, bfeh.a(10010, 1, 2, 100));
            bfef.a().a(16, bfeh.a(10010, 1, 3, 100));
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
          bfko.a().a(false);
          localObject2 = bdcd.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, "");
          ((bdef)localObject2).a(new aefw(this, (bdef)localObject2, paramInt), true);
          return localObject2;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UpgradeActivity
 * JD-Core Version:    0.7.0.1
 */