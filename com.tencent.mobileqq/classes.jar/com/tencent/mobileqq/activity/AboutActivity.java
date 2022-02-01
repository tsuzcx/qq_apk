package com.tencent.mobileqq.activity;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.managers.TimUpgradeHongdianManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.QRoutePluginServiceParams.Builder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QUA;
import java.util.Calendar;
import protocol.KQQConfig.UpgradeInfo;

public class AboutActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private FormSimpleItem a;
  private FormSimpleItem b;
  private FormSimpleItem c;
  private FormSimpleItem d;
  private FormSimpleItem e;
  private FormSimpleItem f;
  private FormSimpleItem g;
  private TextView h;
  private TextView i;
  private String j = "https://im.qq.com/mobileqq/touch/android";
  private String k = "https://ti.qq.com/agreement/index.html";
  private String l = "https://ti.qq.com/agreement/privacy/index.html";
  private RedTouch m;
  private UpgradeDetailWrapper n;
  private ConfigObserver o = new AboutActivity.7(this);
  
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
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ark_brand_state_");
    localStringBuilder.append(a());
    SharePreferenceUtils.a(localBaseApplication, localStringBuilder.toString(), String.valueOf(paramInt));
  }
  
  private void a(AboutConfig paramAboutConfig)
  {
    this.a.setVisibility(0);
    this.a.setBgType(1);
    this.b.setBgType(2);
    this.a.setRightIcon(null);
    paramAboutConfig = this.n;
    if ((paramAboutConfig != null) && (paramAboutConfig.b != null))
    {
      int i1 = this.n.b.iUpgradeType;
      if (i1 == 0)
      {
        paramAboutConfig = (TimUpgradeHongdianManager)this.app.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER);
        if (paramAboutConfig.a())
        {
          this.a.a(true);
          this.a.setLeftText(paramAboutConfig.c.toString());
          this.a.setRightText(paramAboutConfig.d.toString());
          this.a.setRightIcon(getResources().getDrawable(2130852591));
          this.a.setOnClickListener(new AboutActivity.3(this, paramAboutConfig));
          ReportController.b(this.app, "CliOper", "", "", "0X800865B", "0X800865B", 0, 0, "", "", "", "");
          return;
        }
        this.a.setRightText(HardCodeUtil.a(2131897993));
        this.a.a(false);
        this.a.setRightIcon(null);
        this.a.setOnClickListener(null);
        return;
      }
      this.a.a(true);
      this.a.setRightText(HardCodeUtil.a(2131897994));
      this.a.setRightIcon(getResources().getDrawable(2130852591));
      if (i1 == 3)
      {
        this.a.setOnClickListener(new AboutActivity.4(this));
        return;
      }
      this.a.setOnClickListener(new AboutActivity.5(this));
      return;
    }
    this.a.setRightText("");
    this.a.setOnClickListener(null);
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
      paramFormSimpleItem.setRightIcon(getResources().getDrawable(2130852591));
    } else {
      paramFormSimpleItem.setRightIcon(null);
    }
    paramFormSimpleItem.setLeftText(paramResourcePluginInfo.strResName);
    paramFormSimpleItem.setOnClickListener(new AboutActivity.6(this, paramResourcePluginInfo, paramFormSimpleItem));
  }
  
  public static String b()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ark_brand_state_");
    localStringBuilder.append(a());
    return SharePreferenceUtils.a(localBaseApplication, localStringBuilder.toString()).toString();
  }
  
  private void c()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    int i1 = ((Calendar)localObject).get(1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initCopyRightShow year=");
      ((StringBuilder)localObject).append(i1);
      QLog.d("AboutActivity", 2, ((StringBuilder)localObject).toString());
    }
    localObject = (TextView)findViewById(2131431427);
    Resources localResources = getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i1);
    localStringBuilder.append("");
    ((TextView)localObject).setText(localResources.getString(2131886627, new Object[] { localStringBuilder.toString() }));
  }
  
  public void a(RedTouch paramRedTouch)
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localRedTypeInfo.red_type.set(0);
    localRedTypeInfo.red_desc.set("");
    localRedTypeInfo.red_content.set("");
    localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
    localAppInfo.iNewFlag.set(1);
    paramRedTouch.a(localRedTypeInfo);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.addObserver(this.o);
    this.n = UpgradeController.a().d();
    super.setContentView(2131623964);
    setTitle(2131886129);
    paramBundle = this.app.getAboutConfig();
    ((TextView)findViewById(2131446517)).setText(AppSetting.b());
    c();
    this.i = ((TextView)findViewById(2131449223));
    int i1 = this.i.getPaint().getFlags();
    this.i.getPaint().setFlags(i1 | 0x8);
    this.i.setTextColor(-16754769);
    this.i.setOnClickListener(this);
    this.h = ((TextView)findViewById(2131440651));
    i1 = this.h.getPaint().getFlags();
    this.h.getPaint().setFlags(i1 | 0x8);
    this.h.setTextColor(-16754769);
    this.h.setOnClickListener(this);
    this.m = new RedTouch(this, this.h).c(53).a();
    if (PrivacyPolicyHelper.a(1)) {
      a(this.m);
    }
    this.a = ((FormSimpleItem)findViewById(2131449144));
    Object localObject = paramBundle.a("com.tx.aboutfunction_8_0_3");
    this.b = ((FormSimpleItem)findViewById(2131435892));
    if (localObject != null) {
      a(paramBundle, (ResourcePluginInfo)localObject, this.b);
    } else {
      this.b.setVisibility(8);
    }
    a(paramBundle);
    this.c = ((FormSimpleItem)findViewById(2131439544));
    this.c.setOnClickListener(new AboutActivity.1(this));
    this.c.setVisibility(0);
    localObject = paramBundle.a("com.tx.aboutimage");
    this.d = ((FormSimpleItem)findViewById(2131435660));
    if (localObject != null) {
      a(paramBundle, (ResourcePluginInfo)localObject, this.d);
    } else {
      this.d.setVisibility(8);
    }
    localObject = paramBundle.a("com.tencent.Feedback_5_8");
    this.e = ((FormSimpleItem)findViewById(2131433065));
    if (localObject != null) {
      a(paramBundle, (ResourcePluginInfo)localObject, this.e);
    } else {
      this.e.setVisibility(8);
    }
    localObject = paramBundle.a("com.tencent.help_5_8");
    this.f = ((FormSimpleItem)findViewById(2131435013));
    if (localObject != null) {
      a(paramBundle, (ResourcePluginInfo)localObject, this.f);
    } else {
      this.f.setVisibility(8);
    }
    this.g = ((FormSimpleItem)findViewById(2131431803));
    this.g.setVisibility(8);
    this.g.setOnClickListener(new AboutActivity.2(this));
    i1 = DeviceInfoUtil.J();
    float f1 = FontSettingManager.getFontLevel();
    if ((i1 <= 160) || (f1 > 16.0F))
    {
      paramBundle = (ImageView)findViewById(2131429728);
      localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
      if (i1 <= 160) {
        ((LinearLayout.LayoutParams)localObject).topMargin -= DisplayUtil.a(this, 5.0F);
      }
      ((LinearLayout.LayoutParams)localObject).topMargin -= DisplayUtil.a(this, (f1 - 16.0F) * 4.0F);
      if (((LinearLayout.LayoutParams)localObject).topMargin <= 0) {
        ((LinearLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this, 1.0F);
      }
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("appid: ");
      paramBundle.append(String.valueOf(AppSetting.d()));
      paramBundle.append("\n");
      paramBundle = paramBundle.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("LC: ");
      ((StringBuilder)localObject).append(AppSetting.f());
      ((StringBuilder)localObject).append("\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("buildNum: 5770\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("isDebugVersion: ");
      ((StringBuilder)localObject).append(String.valueOf(false));
      ((StringBuilder)localObject).append("\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("isPublicVersion: true\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("isGrayVersion: false\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("subVersion: 8.8.17\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("productID: 130\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("quaAppName: AQQ_2013 4.6\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("supVersion: 2013\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("revision: 846a9bfd\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("isSkinEngieAccelerated: ");
      ((StringBuilder)localObject).append(String.valueOf(true));
      ((StringBuilder)localObject).append("\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("reportVersionName: 8.8.17.5770\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("aboutSubVersionName: ");
      ((StringBuilder)localObject).append(AppSetting.b());
      ((StringBuilder)localObject).append("\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("aboutSubVersionLog: ");
      ((StringBuilder)localObject).append(AppSetting.c());
      ((StringBuilder)localObject).append("\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("versioncode: ");
      ((StringBuilder)localObject).append(ApkUtils.a(this));
      ((StringBuilder)localObject).append("\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("amem: ");
      ((StringBuilder)localObject).append(DeviceInfoUtil.r() / 1024L / 1024L);
      ((StringBuilder)localObject).append("\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("qua: ");
      ((StringBuilder)localObject).append(QUA.getQUA3());
      ((StringBuilder)localObject).append("\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("qua_mm: ");
      ((StringBuilder)localObject).append(QUA.getVersionForHabo());
      ((StringBuilder)localObject).append("\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("qua_pic: ");
      ((StringBuilder)localObject).append(QUA.getVersionForPic());
      ((StringBuilder)localObject).append("\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("ciBuildTime\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("APP_ID: ");
      ((StringBuilder)localObject).append(AppSetting.d());
      ((StringBuilder)localObject).append("\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("NOW: 2021-08-04\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("richstatus: rich_status_android\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("versionBuiltIn: 104\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("64bit: false\n");
      paramBundle = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("model: ");
      ((StringBuilder)localObject).append(Build.MODEL);
      ((StringBuilder)localObject).append("\n");
      QLog.d("script", 2, ((StringBuilder)localObject).toString());
    }
    if (!TripleGraySwitchUtil.b(this, "KEY_DISABLE_START_DF_PLUGIN", false)) {
      try
      {
        paramBundle = new Intent();
        paramBundle.setClassName(this, "com.tencent.mobileqq.sample_feature.FeatureSampleService");
        paramBundle = new QRoutePluginServiceParams.Builder(this).setIntent(paramBundle).build();
        QRoute.plugin("sample_feature.apk").startService(paramBundle);
        return true;
      }
      catch (Exception paramBundle)
      {
        PluginRuntime.handleCrash(paramBundle, "sample_feature.apk", this);
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.o);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (isFinishing()) {}
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.h.invalidate();
    this.i.invalidate();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Intent localIntent;
    if (i1 != 2131440651)
    {
      if (i1 == 2131449223)
      {
        localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("uin", this.app.getCurrentAccountUin());
        startActivity(localIntent.putExtra("url", this.k));
        ReportController.b(this.app, "CliOper", "", "", "0X8005746", "0X8005746", 0, 0, "", "", "", "");
      }
    }
    else
    {
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      localIntent.putExtra("title", getResources().getString(2131892729));
      startActivity(localIntent.putExtra("url", this.l));
      this.m.g();
      PrivacyPolicyHelper.a("1");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity
 * JD-Core Version:    0.7.0.1
 */