package com.tencent.mobileqq.activity;

import Override;
import addj;
import addk;
import addl;
import addm;
import addn;
import addo;
import addp;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import ansi;
import anvx;
import aoae;
import aqwe;
import arqj;
import awty;
import bdla;
import bgvx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QUA;
import protocol.KQQConfig.UpgradeInfo;

public class AboutActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ansi jdField_a_of_type_Ansi = new addp(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_a_of_type_JavaLangString = "https://im.qq.com/mobileqq/touch/android";
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
    SharePreferenceUtils.set(BaseApplication.getContext(), "ark_brand_state_" + a(), String.valueOf(paramInt));
  }
  
  private void a(aqwe paramaqwe)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(1);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iUpgradeType;
    if (i == 0)
    {
      paramaqwe = (awty)this.app.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER);
      if (paramaqwe.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(paramaqwe.jdField_b_of_type_JavaLangString.toString());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramaqwe.jdField_c_of_type_JavaLangString.toString());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850430));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new addl(this, paramaqwe));
        bdla.b(this.app, "CliOper", "", "", "0X800865B", "0X800865B", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anvx.a(2131699221));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anvx.a(2131699222));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850430));
    if (i == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new addm(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new addn(this));
  }
  
  private void a(aqwe paramaqwe, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem)
  {
    if (paramResourcePluginInfo.cLocalState == 0)
    {
      paramFormSimpleItem.setVisibility(8);
      return;
    }
    paramFormSimpleItem.setVisibility(0);
    if (paramResourcePluginInfo.isNew == 0) {
      paramFormSimpleItem.setRightIcon(getResources().getDrawable(2130850430));
    }
    for (;;)
    {
      paramFormSimpleItem.setLeftText(paramResourcePluginInfo.strResName);
      paramFormSimpleItem.setOnClickListener(new addo(this, paramResourcePluginInfo, paramFormSimpleItem));
      return;
      paramFormSimpleItem.setRightIcon(null);
    }
  }
  
  public static String b()
  {
    return SharePreferenceUtils.get(BaseApplication.getContext(), "ark_brand_state_" + a()).toString();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Ansi);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = bgvx.a().a();
    super.setContentView(2131558400);
    setTitle(2131689493);
    paramBundle = this.app.getAboutConfig();
    ((TextView)findViewById(2131378201)).setText(AppSetting.a());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380592));
    int i = this.jdField_b_of_type_AndroidWidgetTextView.getPaint().getFlags();
    this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFlags(i | 0x8);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16754769);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373166));
    i = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().getFlags();
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFlags(i | 0x8);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16754769);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_a_of_type_AndroidWidgetTextView).b(53).a();
    if (aoae.a(1)) {
      aoae.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131380514));
    Object localObject = paramBundle.a("com.tx.aboutfunction_8_0_3");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368980));
    if (localObject != null)
    {
      a(paramBundle, (ResourcePluginInfo)localObject, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      a(paramBundle);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372195));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new addj(this));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      localObject = paramBundle.a("com.tx.aboutimage");
      this.d = ((FormSimpleItem)findViewById(2131368793));
      if (localObject == null) {
        break label1342;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.d);
      label351:
      localObject = paramBundle.a("com.tencent.Feedback_5_8");
      this.e = ((FormSimpleItem)findViewById(2131366702));
      if (localObject == null) {
        break label1354;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.e);
      label390:
      localObject = paramBundle.a("com.tencent.help_5_8");
      this.f = ((FormSimpleItem)findViewById(2131368183));
      if (localObject == null) {
        break label1366;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.f);
    }
    for (;;)
    {
      this.g = ((FormSimpleItem)findViewById(2131365577));
      this.g.setVisibility(8);
      this.g.setOnClickListener(new addk(this));
      i = DeviceInfoUtil.getDispalyDpi();
      float f1 = FontSettingManager.getFontLevel();
      if ((i <= 160) || (f1 > 16.0F))
      {
        paramBundle = (ImageView)findViewById(2131363768);
        localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
        if (i <= 160) {
          ((LinearLayout.LayoutParams)localObject).topMargin -= DisplayUtil.dip2px(this, 5.0F);
        }
        ((LinearLayout.LayoutParams)localObject).topMargin -= DisplayUtil.dip2px(this, (f1 - 16.0F) * 4.0F);
        if (((LinearLayout.LayoutParams)localObject).topMargin <= 0) {
          ((LinearLayout.LayoutParams)localObject).topMargin = DisplayUtil.dip2px(this, 1.0F);
        }
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (QLog.isColorLevel())
      {
        paramBundle = "appid: " + String.valueOf(AppSetting.a()) + "\n";
        paramBundle = paramBundle + "LC: " + AppSetting.d() + "\n";
        paramBundle = paramBundle + "buildNum: 4875\n";
        paramBundle = paramBundle + "isDebugVersion: " + String.valueOf(false) + "\n";
        paramBundle = paramBundle + "isPublicVersion: true\n";
        paramBundle = paramBundle + "isGrayVersion: false\n";
        paramBundle = paramBundle + "subVersion: 8.4.10\n";
        paramBundle = paramBundle + "productID: 130\n";
        paramBundle = paramBundle + "quaAppName: AQQ_2013 4.6\n";
        paramBundle = paramBundle + "supVersion: 2013\n";
        paramBundle = paramBundle + "revision: b8c39faf\n";
        paramBundle = paramBundle + "isSkinEngieAccelerated: " + String.valueOf(true) + "\n";
        paramBundle = paramBundle + "reportVersionName: 8.4.10.4875\n";
        paramBundle = paramBundle + "aboutSubVersionName: " + AppSetting.a() + "\n";
        paramBundle = paramBundle + "aboutSubVersionLog: " + AppSetting.b() + "\n";
        paramBundle = paramBundle + "versioncode: " + arqj.a(this) + "\n";
        paramBundle = paramBundle + "amem: " + DeviceInfoUtil.getSystemAvaialbeMemory() / 1024L / 1024L + "\n";
        paramBundle = paramBundle + "qua: " + QUA.getQUA3() + "\n";
        paramBundle = paramBundle + "qua_mm: " + QUA.getVersionForHabo() + "\n";
        paramBundle = paramBundle + "qua_pic: " + QUA.getVersionForPic() + "\n";
        paramBundle = paramBundle + "ciBuildTime\n";
        paramBundle = paramBundle + "APP_ID: " + AppSetting.a() + "\n";
        paramBundle = paramBundle + "NOW: 2020-10-20\n";
        paramBundle = paramBundle + "richstatus: rich_status_android\n";
        paramBundle = paramBundle + "versionBuiltIn: 104\n";
        paramBundle = paramBundle + "64bit: false\n";
        QLog.d("script", 2, paramBundle + "model: " + Build.MODEL + "\n");
      }
      return true;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      label1342:
      this.d.setVisibility(8);
      break label351;
      label1354:
      this.e.setVisibility(8);
      break label390;
      label1366:
      this.f.setVisibility(8);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Ansi);
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      startActivity(localIntent.putExtra("url", this.jdField_b_of_type_JavaLangString));
      bdla.b(this.app, "CliOper", "", "", "0X8005746", "0X8005746", 0, 0, "", "", "", "");
      continue;
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      localIntent.putExtra("title", getResources().getString(2131694773));
      startActivity(localIntent.putExtra("url", this.jdField_c_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
      aoae.a("1");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity
 * JD-Core Version:    0.7.0.1
 */