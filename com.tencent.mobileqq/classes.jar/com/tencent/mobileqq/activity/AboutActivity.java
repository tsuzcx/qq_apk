package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.managers.TimUpgradeHongdianManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import protocol.KQQConfig.UpgradeInfo;
import rcp;
import rcq;
import rcr;
import rcs;
import rct;
import rcu;
import rcv;
import rcw;
import rcx;

public class AboutActivity
  extends IphoneTitleBarActivity
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new rcw(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_a_of_type_JavaLangString = "http://im.qq.com/mobileqq/touch/android";
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_b_of_type_JavaLangString = "http://ti.qq.com/agreement/index.html";
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_c_of_type_JavaLangString = "http://www.qq.com/privacy.htm";
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
    SharePreferenceUtils.a(BaseApplication.getContext(), "ark_brand_state_" + a(), String.valueOf(paramInt));
  }
  
  private void a(AboutConfig paramAboutConfig)
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
      paramAboutConfig = (TimUpgradeHongdianManager)this.app.getManager(243);
      if (paramAboutConfig.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(paramAboutConfig.jdField_b_of_type_JavaLangString.toString());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramAboutConfig.jdField_c_of_type_JavaLangString.toString());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130845926));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new rcs(this, paramAboutConfig));
        ReportController.b(this.app, "CliOper", "", "", "0X800865B", "0X800865B", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("已是最新版本");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("有新版本可用");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130845926));
    if (i == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new rct(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new rcu(this));
  }
  
  private void a(AboutConfig paramAboutConfig, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem)
  {
    if (paramResourcePluginInfo.cLocalState == 0)
    {
      paramFormSimpleItem.setVisibility(8);
      return;
    }
    paramFormSimpleItem.setVisibility(0);
    if (paramResourcePluginInfo.isNew == 0) {
      paramFormSimpleItem.setRightIcon(getResources().getDrawable(2130845926));
    }
    for (;;)
    {
      paramFormSimpleItem.setLeftText(paramResourcePluginInfo.strResName);
      paramFormSimpleItem.setOnClickListener(new rcv(this, paramResourcePluginInfo, paramFormSimpleItem));
      return;
      paramFormSimpleItem.setRightIcon(null);
    }
  }
  
  public static String b()
  {
    return SharePreferenceUtils.a(BaseApplication.getContext(), "ark_brand_state_" + a()).toString();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    super.setContentView(2130968576);
    setTitle(2131435546);
    paramBundle = this.app.a();
    ((ImageView)findViewById(2131362652)).setOnClickListener(new rcp(this));
    ((TextView)findViewById(2131362653)).setText("V 7.6.0.3525");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362663));
    Object localObject = new SpannableString(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    ((SpannableString)localObject).setSpan(new rcx(this, this.jdField_b_of_type_JavaLangString, 2131362663), 0, this.jdField_b_of_type_AndroidWidgetTextView.getText().length(), 17);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362665));
    localObject = new SpannableString(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    ((SpannableString)localObject).setSpan(new rcx(this, this.jdField_c_of_type_JavaLangString, 2131362665), 0, this.jdField_a_of_type_AndroidWidgetTextView.getText().length(), 17);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131362654));
    localObject = paramBundle.a("com.tx.aboutfunction");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131362655));
    if (localObject != null)
    {
      a(paramBundle, (ResourcePluginInfo)localObject, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      a(paramBundle);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131362656));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new rcq(this));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      localObject = paramBundle.a("com.tx.aboutimage");
      this.d = ((FormSimpleItem)findViewById(2131362657));
      if (localObject == null) {
        break label1148;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.d);
      label384:
      localObject = paramBundle.a("com.tencent.Feedback_5_8");
      this.e = ((FormSimpleItem)findViewById(2131362660));
      if (localObject == null) {
        break label1160;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.e);
      label423:
      localObject = paramBundle.a("com.tencent.help_5_8");
      this.f = ((FormSimpleItem)findViewById(2131362659));
      if (localObject == null) {
        break label1172;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.f);
    }
    for (;;)
    {
      this.g = ((FormSimpleItem)findViewById(2131362658));
      this.g.setVisibility(8);
      this.g.setOnClickListener(new rcr(this));
      int i = DeviceInfoUtil.d();
      float f1 = FontSettingManager.a();
      if ((i <= 160) || (f1 > 16.0F))
      {
        paramBundle = (ImageView)findViewById(2131362652);
        localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
        if (i <= 160) {
          ((LinearLayout.LayoutParams)localObject).topMargin -= DisplayUtil.a(this, 5.0F);
        }
        ((LinearLayout.LayoutParams)localObject).topMargin -= DisplayUtil.a(this, (f1 - 16.0F) * 4.0F);
        if (((LinearLayout.LayoutParams)localObject).topMargin <= 0) {
          ((LinearLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this, 1.0F);
        }
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramBundle = "appid: " + String.valueOf(AppSetting.jdField_a_of_type_Int) + "\n";
      paramBundle = paramBundle + "LC: FD1F19421912DCF5\n";
      paramBundle = paramBundle + "buildNum: 3525\n";
      paramBundle = paramBundle + "isDebugVersion: " + String.valueOf(false) + "\n";
      paramBundle = paramBundle + "subVersion: 7.6.0\n";
      paramBundle = paramBundle + "productID: 130\n";
      paramBundle = paramBundle + "quaAppName: AQQ_2013 4.6\n";
      paramBundle = paramBundle + "supVersion: 2013\n";
      paramBundle = paramBundle + "revision: 345599\n";
      paramBundle = paramBundle + "isSkinEngieAccelerated: " + String.valueOf(true) + "\n";
      paramBundle = paramBundle + "reportVersionName: 7.6.0.3525\n";
      paramBundle = paramBundle + "aboutSubVersionName: V 7.6.0.3525\n";
      paramBundle = paramBundle + "aboutSubVersionLog: 7.6.0.3525.2018-05-05.r345599.BanBenPuJi\n";
      paramBundle = paramBundle + "isPublicVersion: true\n";
      paramBundle = paramBundle + "versioncode: " + ApkUtils.a(this) + "\n";
      paramBundle = paramBundle + "amem: " + DeviceInfoUtil.f() / 1024L / 1024L + "\n";
      paramBundle = paramBundle + "qua: " + QUA.a() + "\n";
      paramBundle = paramBundle + "qua_mm: " + QUA.c() + "\n";
      paramBundle = paramBundle + "qua_pic: " + QUA.b() + "\n";
      if (QLog.isColorLevel()) {
        QLog.d("script", 2, paramBundle);
      }
      return true;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      label1148:
      this.d.setVisibility(8);
      break label384;
      label1160:
      this.e.setVisibility(8);
      break label423;
      label1172:
      this.f.setVisibility(8);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (isFinishing()) {}
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetTextView.invalidate();
    this.jdField_b_of_type_AndroidWidgetTextView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity
 * JD-Core Version:    0.7.0.1
 */