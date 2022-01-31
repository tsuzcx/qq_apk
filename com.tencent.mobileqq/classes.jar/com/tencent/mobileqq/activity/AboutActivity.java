package com.tencent.mobileqq.activity;

import abvn;
import abvo;
import abvp;
import abvq;
import abvr;
import abvs;
import abvt;
import alls;
import alnq;
import alpo;
import alun;
import amlp;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aofm;
import aowf;
import atwc;
import azmj;
import bcwh;
import bczr;
import bdcb;
import bizf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

public class AboutActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private alls jdField_a_of_type_Alls = new abvt(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_a_of_type_JavaLangString = "http://im.qq.com/mobileqq/touch/android";
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_b_of_type_JavaLangString = "https://ti.qq.com/agreement/index.html";
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_c_of_type_JavaLangString = "https://ti.qq.com/agreement/privacy/index.html";
  private FormSimpleItem d;
  private FormSimpleItem e;
  private FormSimpleItem f;
  private FormSimpleItem g;
  
  public static String a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface == null) {
      return "";
    }
    return localQQAppInterface.getCurrentAccountUin();
  }
  
  public static void a(int paramInt)
  {
    bczr.a(BaseApplication.getContext(), "ark_brand_state_" + a(), String.valueOf(paramInt));
  }
  
  private void a(aofm paramaofm)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(1);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType;
    if (i == 0)
    {
      paramaofm = (atwc)this.app.getManager(244);
      if (paramaofm.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(paramaofm.jdField_b_of_type_JavaLangString.toString());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramaofm.jdField_c_of_type_JavaLangString.toString());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849731));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abvp(this, paramaofm));
        azmj.b(this.app, "CliOper", "", "", "0X800865B", "0X800865B", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(alpo.a(2131700090));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(alpo.a(2131700091));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849731));
    if (i == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abvq(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abvr(this));
  }
  
  private void a(aofm paramaofm, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem)
  {
    if (paramResourcePluginInfo.cLocalState == 0)
    {
      paramFormSimpleItem.setVisibility(8);
      return;
    }
    paramFormSimpleItem.setVisibility(0);
    if (paramResourcePluginInfo.isNew == 0) {
      paramFormSimpleItem.setRightIcon(getResources().getDrawable(2130849731));
    }
    for (;;)
    {
      paramFormSimpleItem.setLeftText(paramResourcePluginInfo.strResName);
      paramFormSimpleItem.setOnClickListener(new abvs(this, paramResourcePluginInfo, paramFormSimpleItem));
      return;
      paramFormSimpleItem.setRightIcon(null);
    }
  }
  
  public static String b()
  {
    return bczr.a(BaseApplication.getContext(), "ark_brand_state_" + a()).toString();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Alls);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = amlp.a().a();
    super.setContentView(2131558400);
    setTitle(2131689538);
    paramBundle = this.app.a();
    ((TextView)findViewById(2131377129)).setText(AppSetting.a());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379363));
    int i = this.jdField_b_of_type_AndroidWidgetTextView.getPaint().getFlags();
    this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFlags(i | 0x8);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16754769);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372262));
    i = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().getFlags();
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFlags(i | 0x8);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16754769);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_a_of_type_AndroidWidgetTextView).a(53).a();
    if (alun.a(1)) {
      alun.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131379285));
    Object localObject = paramBundle.a("com.tx.aboutfunction_8_0_3");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368411));
    if (localObject != null)
    {
      a(paramBundle, (ResourcePluginInfo)localObject, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      a(paramBundle);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371340));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abvn(this));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      localObject = paramBundle.a("com.tx.aboutimage");
      this.d = ((FormSimpleItem)findViewById(2131368198));
      if (localObject == null) {
        break label1339;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.d);
      label348:
      localObject = paramBundle.a("com.tencent.Feedback_5_8");
      this.e = ((FormSimpleItem)findViewById(2131366261));
      if (localObject == null) {
        break label1351;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.e);
      label387:
      localObject = paramBundle.a("com.tencent.help_5_8");
      this.f = ((FormSimpleItem)findViewById(2131367626));
      if (localObject == null) {
        break label1363;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.f);
    }
    for (;;)
    {
      this.g = ((FormSimpleItem)findViewById(2131365165));
      this.g.setVisibility(8);
      this.g.setOnClickListener(new abvo(this));
      i = bdcb.d();
      float f1 = alnq.a();
      if ((i <= 160) || (f1 > 16.0F))
      {
        paramBundle = (ImageView)findViewById(2131363447);
        localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
        if (i <= 160) {
          ((LinearLayout.LayoutParams)localObject).topMargin -= bcwh.a(this, 5.0F);
        }
        ((LinearLayout.LayoutParams)localObject).topMargin -= bcwh.a(this, (f1 - 16.0F) * 4.0F);
        if (((LinearLayout.LayoutParams)localObject).topMargin <= 0) {
          ((LinearLayout.LayoutParams)localObject).topMargin = bcwh.a(this, 1.0F);
        }
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (QLog.isColorLevel())
      {
        paramBundle = "appid: " + String.valueOf(AppSetting.a()) + "\n";
        paramBundle = paramBundle + "LC: " + AppSetting.d() + "\n";
        paramBundle = paramBundle + "buildNum: 4515\n";
        paramBundle = paramBundle + "isDebugVersion: " + String.valueOf(false) + "\n";
        paramBundle = paramBundle + "isPublicVersion: true\n";
        paramBundle = paramBundle + "isGrayVersion: false\n";
        paramBundle = paramBundle + "subVersion: 8.3.3\n";
        paramBundle = paramBundle + "productID: 130\n";
        paramBundle = paramBundle + "quaAppName: AQQ_2013 4.6\n";
        paramBundle = paramBundle + "supVersion: 2013\n";
        paramBundle = paramBundle + "revision: 6b98d0b0\n";
        paramBundle = paramBundle + "isSkinEngieAccelerated: " + String.valueOf(true) + "\n";
        paramBundle = paramBundle + "reportVersionName: 8.3.3.4515\n";
        paramBundle = paramBundle + "aboutSubVersionName: " + AppSetting.a() + "\n";
        paramBundle = paramBundle + "aboutSubVersionLog: " + AppSetting.b() + "\n";
        paramBundle = paramBundle + "versioncode: " + aowf.a(this) + "\n";
        paramBundle = paramBundle + "amem: " + bdcb.e() / 1024L / 1024L + "\n";
        paramBundle = paramBundle + "qua: " + bizf.a() + "\n";
        paramBundle = paramBundle + "qua_mm: " + bizf.c() + "\n";
        paramBundle = paramBundle + "qua_pic: " + bizf.b() + "\n";
        paramBundle = paramBundle + "ciBuildTime\n";
        paramBundle = paramBundle + "APP_ID: " + AppSetting.a() + "\n";
        paramBundle = paramBundle + "NOW: 2020-04-16\n";
        paramBundle = paramBundle + "richstatus: rich_status_android\n";
        paramBundle = paramBundle + "versionBuiltIn: 104\n";
        paramBundle = paramBundle + "64bit: false\n";
        QLog.d("script", 2, paramBundle + "model: " + Build.MODEL + "\n");
      }
      return true;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      label1339:
      this.d.setVisibility(8);
      break label348;
      label1351:
      this.e.setVisibility(8);
      break label387;
      label1363:
      this.f.setVisibility(8);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Alls);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (isFinishing()) {}
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetTextView.invalidate();
    this.jdField_b_of_type_AndroidWidgetTextView.invalidate();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131379363: 
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("uin", this.app.getCurrentAccountUin());
      startActivity(paramView.putExtra("url", this.jdField_b_of_type_JavaLangString));
      azmj.b(this.app, "CliOper", "", "", "0X8005746", "0X8005746", 0, 0, "", "", "", "");
      return;
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("uin", this.app.getCurrentAccountUin());
    startActivity(paramView.putExtra("url", this.jdField_c_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
    alun.a("1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity
 * JD-Core Version:    0.7.0.1
 */