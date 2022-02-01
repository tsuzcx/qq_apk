package com.tencent.mobileqq.activity;

import Override;
import adqi;
import adqj;
import adqk;
import adql;
import adqm;
import adqn;
import adqo;
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
import anvn;
import anxh;
import anzj;
import aodp;
import aqzq;
import arta;
import axam;
import bdll;
import bhdu;
import bhgr;
import bhjc;
import bhlo;
import bmsw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import protocol.KQQConfig.UpgradeInfo;

public class AboutActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anvn jdField_a_of_type_Anvn = new adqo(this);
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
    bhjc.a(BaseApplication.getContext(), "ark_brand_state_" + a(), String.valueOf(paramInt));
  }
  
  private void a(aqzq paramaqzq)
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
      paramaqzq = (axam)this.app.getManager(244);
      if (paramaqzq.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(paramaqzq.jdField_b_of_type_JavaLangString.toString());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramaqzq.jdField_c_of_type_JavaLangString.toString());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850403));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new adqk(this, paramaqzq));
        bdll.b(this.app, "CliOper", "", "", "0X800865B", "0X800865B", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anzj.a(2131698635));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anzj.a(2131698636));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850403));
    if (i == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new adql(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new adqm(this));
  }
  
  private void a(aqzq paramaqzq, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem)
  {
    if (paramResourcePluginInfo.cLocalState == 0)
    {
      paramFormSimpleItem.setVisibility(8);
      return;
    }
    paramFormSimpleItem.setVisibility(0);
    if (paramResourcePluginInfo.isNew == 0) {
      paramFormSimpleItem.setRightIcon(getResources().getDrawable(2130850403));
    }
    for (;;)
    {
      paramFormSimpleItem.setLeftText(paramResourcePluginInfo.strResName);
      paramFormSimpleItem.setOnClickListener(new adqn(this, paramResourcePluginInfo, paramFormSimpleItem));
      return;
      paramFormSimpleItem.setRightIcon(null);
    }
  }
  
  public static String b()
  {
    return bhjc.a(BaseApplication.getContext(), "ark_brand_state_" + a()).toString();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Anvn);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = bhdu.a().a();
    super.setContentView(2131558400);
    setTitle(2131689493);
    paramBundle = this.app.a();
    ((TextView)findViewById(2131378144)).setText(AppSetting.a());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380533));
    int i = this.jdField_b_of_type_AndroidWidgetTextView.getPaint().getFlags();
    this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFlags(i | 0x8);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16754769);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372985));
    i = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().getFlags();
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFlags(i | 0x8);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16754769);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_a_of_type_AndroidWidgetTextView).a(53).a();
    if (aodp.a(1)) {
      aodp.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131380455));
    Object localObject = paramBundle.a("com.tx.aboutfunction_8_0_3");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368797));
    if (localObject != null)
    {
      a(paramBundle, (ResourcePluginInfo)localObject, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      a(paramBundle);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372038));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new adqi(this));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      localObject = paramBundle.a("com.tx.aboutimage");
      this.d = ((FormSimpleItem)findViewById(2131368609));
      if (localObject == null) {
        break label1340;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.d);
      label349:
      localObject = paramBundle.a("com.tencent.Feedback_5_8");
      this.e = ((FormSimpleItem)findViewById(2131366566));
      if (localObject == null) {
        break label1352;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.e);
      label388:
      localObject = paramBundle.a("com.tencent.help_5_8");
      this.f = ((FormSimpleItem)findViewById(2131368013));
      if (localObject == null) {
        break label1364;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.f);
    }
    for (;;)
    {
      this.g = ((FormSimpleItem)findViewById(2131365452));
      this.g.setVisibility(8);
      this.g.setOnClickListener(new adqj(this));
      i = bhlo.d();
      float f1 = anxh.a();
      if ((i <= 160) || (f1 > 16.0F))
      {
        paramBundle = (ImageView)findViewById(2131363666);
        localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
        if (i <= 160) {
          ((LinearLayout.LayoutParams)localObject).topMargin -= bhgr.a(this, 5.0F);
        }
        ((LinearLayout.LayoutParams)localObject).topMargin -= bhgr.a(this, (f1 - 16.0F) * 4.0F);
        if (((LinearLayout.LayoutParams)localObject).topMargin <= 0) {
          ((LinearLayout.LayoutParams)localObject).topMargin = bhgr.a(this, 1.0F);
        }
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (QLog.isColorLevel())
      {
        paramBundle = "appid: " + String.valueOf(AppSetting.a()) + "\n";
        paramBundle = paramBundle + "LC: " + AppSetting.d() + "\n";
        paramBundle = paramBundle + "buildNum: 4745\n";
        paramBundle = paramBundle + "isDebugVersion: " + String.valueOf(false) + "\n";
        paramBundle = paramBundle + "isPublicVersion: true\n";
        paramBundle = paramBundle + "isGrayVersion: false\n";
        paramBundle = paramBundle + "subVersion: 8.4.5\n";
        paramBundle = paramBundle + "productID: 130\n";
        paramBundle = paramBundle + "quaAppName: AQQ_2013 4.6\n";
        paramBundle = paramBundle + "supVersion: 2013\n";
        paramBundle = paramBundle + "revision: 6b9ba755\n";
        paramBundle = paramBundle + "isSkinEngieAccelerated: " + String.valueOf(true) + "\n";
        paramBundle = paramBundle + "reportVersionName: 8.4.5.4745\n";
        paramBundle = paramBundle + "aboutSubVersionName: " + AppSetting.a() + "\n";
        paramBundle = paramBundle + "aboutSubVersionLog: " + AppSetting.b() + "\n";
        paramBundle = paramBundle + "versioncode: " + arta.a(this) + "\n";
        paramBundle = paramBundle + "amem: " + bhlo.e() / 1024L / 1024L + "\n";
        paramBundle = paramBundle + "qua: " + bmsw.a() + "\n";
        paramBundle = paramBundle + "qua_mm: " + bmsw.c() + "\n";
        paramBundle = paramBundle + "qua_pic: " + bmsw.b() + "\n";
        paramBundle = paramBundle + "ciBuildTime\n";
        paramBundle = paramBundle + "APP_ID: " + AppSetting.a() + "\n";
        paramBundle = paramBundle + "NOW: 2020-08-13\n";
        paramBundle = paramBundle + "richstatus: rich_status_android\n";
        paramBundle = paramBundle + "versionBuiltIn: 104\n";
        paramBundle = paramBundle + "64bit: false\n";
        QLog.d("script", 2, paramBundle + "model: " + Build.MODEL + "\n");
      }
      return true;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      label1340:
      this.d.setVisibility(8);
      break label349;
      label1352:
      this.e.setVisibility(8);
      break label388;
      label1364:
      this.f.setVisibility(8);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Anvn);
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
      bdll.b(this.app, "CliOper", "", "", "0X8005746", "0X8005746", 0, 0, "", "", "", "");
      continue;
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      localIntent.putExtra("title", getResources().getString(2131694458));
      startActivity(localIntent.putExtra("url", this.jdField_c_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
      aodp.a("1");
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