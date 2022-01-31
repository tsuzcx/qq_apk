package com.tencent.mobileqq.activity;

import aaeq;
import aaer;
import aaes;
import aaet;
import aaeu;
import aaev;
import aaew;
import ajuf;
import ajwc;
import ajya;
import akcy;
import akuz;
import amoo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aney;
import asfc;
import axqy;
import baxn;
import bbax;
import bbdh;
import bgyi;
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
  private ajuf jdField_a_of_type_Ajuf = new aaew(this);
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
    bbax.a(BaseApplication.getContext(), "ark_brand_state_" + a(), String.valueOf(paramInt));
  }
  
  private void a(amoo paramamoo)
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
      paramamoo = (asfc)this.app.getManager(244);
      if (paramamoo.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(paramamoo.jdField_b_of_type_JavaLangString.toString());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramamoo.jdField_c_of_type_JavaLangString.toString());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849300));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aaes(this, paramamoo));
        axqy.b(this.app, "CliOper", "", "", "0X800865B", "0X800865B", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajya.a(2131699721));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajya.a(2131699722));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849300));
    if (i == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aaet(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aaeu(this));
  }
  
  private void a(amoo paramamoo, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem)
  {
    if (paramResourcePluginInfo.cLocalState == 0)
    {
      paramFormSimpleItem.setVisibility(8);
      return;
    }
    paramFormSimpleItem.setVisibility(0);
    if (paramResourcePluginInfo.isNew == 0) {
      paramFormSimpleItem.setRightIcon(getResources().getDrawable(2130849300));
    }
    for (;;)
    {
      paramFormSimpleItem.setLeftText(paramResourcePluginInfo.strResName);
      paramFormSimpleItem.setOnClickListener(new aaev(this, paramResourcePluginInfo, paramFormSimpleItem));
      return;
      paramFormSimpleItem.setRightIcon(null);
    }
  }
  
  public static String b()
  {
    return bbax.a(BaseApplication.getContext(), "ark_brand_state_" + a()).toString();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Ajuf);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = akuz.a().a();
    super.setContentView(2131558400);
    setTitle(2131689538);
    paramBundle = this.app.a();
    ((TextView)findViewById(2131376622)).setText(AppSetting.a());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378745));
    int i = this.jdField_b_of_type_AndroidWidgetTextView.getPaint().getFlags();
    this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFlags(i | 0x8);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16754769);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371943));
    i = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().getFlags();
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFlags(i | 0x8);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16754769);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_a_of_type_AndroidWidgetTextView).a(53).a();
    if (akcy.a(1)) {
      akcy.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378667));
    Object localObject = paramBundle.a("com.tx.aboutfunction_8_0_3");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368265));
    if (localObject != null)
    {
      a(paramBundle, (ResourcePluginInfo)localObject, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      a(paramBundle);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371027));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aaeq(this));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      localObject = paramBundle.a("com.tx.aboutimage");
      this.d = ((FormSimpleItem)findViewById(2131368060));
      if (localObject == null) {
        break label1287;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.d);
      label348:
      localObject = paramBundle.a("com.tencent.Feedback_5_8");
      this.e = ((FormSimpleItem)findViewById(2131366174));
      if (localObject == null) {
        break label1299;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.e);
      label387:
      localObject = paramBundle.a("com.tencent.help_5_8");
      this.f = ((FormSimpleItem)findViewById(2131367498));
      if (localObject == null) {
        break label1311;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.f);
    }
    for (;;)
    {
      this.g = ((FormSimpleItem)findViewById(2131365080));
      this.g.setVisibility(8);
      this.g.setOnClickListener(new aaer(this));
      i = bbdh.d();
      float f1 = ajwc.a();
      if ((i <= 160) || (f1 > 16.0F))
      {
        paramBundle = (ImageView)findViewById(2131363408);
        localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
        if (i <= 160) {
          ((LinearLayout.LayoutParams)localObject).topMargin -= baxn.a(this, 5.0F);
        }
        ((LinearLayout.LayoutParams)localObject).topMargin -= baxn.a(this, (f1 - 16.0F) * 4.0F);
        if (((LinearLayout.LayoutParams)localObject).topMargin <= 0) {
          ((LinearLayout.LayoutParams)localObject).topMargin = baxn.a(this, 1.0F);
        }
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramBundle = "appid: " + String.valueOf(AppSetting.a()) + "\n";
      paramBundle = paramBundle + "LC: " + AppSetting.d() + "\n";
      paramBundle = paramBundle + "buildNum: 4480\n";
      paramBundle = paramBundle + "isDebugVersion: " + String.valueOf(false) + "\n";
      paramBundle = paramBundle + "isPublicVersion: true\n";
      paramBundle = paramBundle + "isGrayVersion: false\n";
      paramBundle = paramBundle + "subVersion: 8.3.0\n";
      paramBundle = paramBundle + "productID: 130\n";
      paramBundle = paramBundle + "quaAppName: AQQ_2013 4.6\n";
      paramBundle = paramBundle + "supVersion: 2013\n";
      paramBundle = paramBundle + "revision: a9855103\n";
      paramBundle = paramBundle + "isSkinEngieAccelerated: " + String.valueOf(true) + "\n";
      paramBundle = paramBundle + "reportVersionName: 8.3.0.4480\n";
      paramBundle = paramBundle + "aboutSubVersionName: " + AppSetting.a() + "\n";
      paramBundle = paramBundle + "aboutSubVersionLog: " + AppSetting.b() + "\n";
      paramBundle = paramBundle + "versioncode: " + aney.a(this) + "\n";
      paramBundle = paramBundle + "amem: " + bbdh.e() / 1024L / 1024L + "\n";
      paramBundle = paramBundle + "qua: " + bgyi.a() + "\n";
      paramBundle = paramBundle + "qua_mm: " + bgyi.c() + "\n";
      paramBundle = paramBundle + "qua_pic: " + bgyi.b() + "\n";
      paramBundle = paramBundle + "ciBuildTime";
      paramBundle = paramBundle + "APP_ID: " + AppSetting.a() + "\n";
      paramBundle = paramBundle + "NOW: 2020-03-16\n";
      paramBundle = paramBundle + "richstatus: rich_status_android\n";
      paramBundle = paramBundle + "versionBuiltIn: 104\n";
      if (QLog.isColorLevel()) {
        QLog.d("script", 2, paramBundle);
      }
      return true;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      label1287:
      this.d.setVisibility(8);
      break label348;
      label1299:
      this.e.setVisibility(8);
      break label387;
      label1311:
      this.f.setVisibility(8);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Ajuf);
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
    case 2131378745: 
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("uin", this.app.getCurrentAccountUin());
      startActivity(paramView.putExtra("url", this.jdField_b_of_type_JavaLangString));
      axqy.b(this.app, "CliOper", "", "", "0X8005746", "0X8005746", 0, 0, "", "", "", "");
      return;
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("uin", this.app.getCurrentAccountUin());
    startActivity(paramView.putExtra("url", this.jdField_c_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
    akcy.a("1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity
 * JD-Core Version:    0.7.0.1
 */