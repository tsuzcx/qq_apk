package com.huawei.updatesdk.service.otaupdate;

import Override;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.c.g.a;
import com.huawei.updatesdk.service.e.c.a;
import com.huawei.updatesdk.service.f.a.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.concurrent.Executors;

public class AppUpdateActivity
  extends Activity
  implements com.huawei.updatesdk.service.b.b, b
{
  private String a = "com.huawei.appmarket";
  private AlertDialog b;
  private com.huawei.updatesdk.service.f.a c;
  private com.huawei.updatesdk.service.f.a d;
  private ProgressBar e;
  private TextView f;
  private boolean g = false;
  private boolean h = false;
  private ApkUpgradeInfo i = null;
  private boolean j = false;
  private boolean k = false;
  private com.huawei.updatesdk.a.b.b.b l;
  private int m = -99;
  private int n = -99;
  private int o = -99;
  private Intent p = null;
  private AppUpdateActivity.d q;
  
  private Intent a(int paramInt1, int paramInt2, int paramInt3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("downloadStatus", paramInt3);
    localIntent.putExtra("installState", paramInt1);
    localIntent.putExtra("installType", paramInt2);
    return localIntent;
  }
  
  private void a()
  {
    a.a(this, this.q);
    com.huawei.updatesdk.service.b.c.b().b(this);
    if (this.l != null) {
      this.l.b();
    }
    f.a(null);
  }
  
  private void a(View paramView)
  {
    try
    {
      paramView = (ScrollView)paramView.findViewById(g.a(this, "scroll_layout"));
      if (Build.VERSION.SDK_INT >= 22)
      {
        TypedValue localTypedValue = new TypedValue();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getTheme().resolveAttribute(16843987, localTypedValue, true);
        ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i1 = TypedValue.complexToDimensionPixelSize(localTypedValue.data, localDisplayMetrics);
        paramView.setPadding(i1, 0, i1, 0);
      }
      return;
    }
    catch (Exception paramView)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("AppUpdateActivity", paramView.toString());
    }
  }
  
  private void a(com.huawei.updatesdk.a.b.c.b paramb)
  {
    if (this.e == null) {
      return;
    }
    long l1 = paramb.a("download_apk_size", 0);
    int i1 = i.a(paramb.a("download_apk_already", 0), l1);
    this.e.setProgress(i1);
    i1 = (int)(this.e.getProgress() / this.e.getMax() * 100.0F);
    this.f.setText(i.a(i1));
  }
  
  private void a(ApkUpgradeInfo paramApkUpgradeInfo, TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramApkUpgradeInfo.getDiffSize_() > 0)
    {
      paramApkUpgradeInfo = i.a(this, paramApkUpgradeInfo.getLongSize_());
      SpannableString localSpannableString = new SpannableString(paramApkUpgradeInfo);
      localSpannableString.setSpan(new StrikethroughSpan(), 0, paramApkUpgradeInfo.length(), 33);
      localSpannableString.setSpan(new TextAppearanceSpan("HwChinese-medium", 0, (int)paramTextView.getTextSize(), null, null), 0, localSpannableString.length(), 33);
      paramTextView.setText(localSpannableString);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
    localIntent.setPackage(this.a);
    localIntent.putExtra("APP_PACKAGENAME", paramString);
    localIntent.putExtra("APP_MUST_UPDATE_BTN", this.k);
    try
    {
      this.h = false;
      startActivityForResult(localIntent, 1002);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("AppUpdateActivity", "goHiappUpgrade error: " + paramString.toString());
      this.h = true;
      paramString = new Intent();
      paramString.putExtra("status", 8);
      d.a().b(paramString);
      d(this.i);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      this.m = 1;
      finish();
    }
    do
    {
      for (;;)
      {
        return;
        Intent localIntent = new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withdetailId");
        localIntent.setPackage(this.a);
        localIntent.putExtra("appDetailId", paramString2);
        localIntent.putExtra("thirdId", paramString1);
        localIntent.addFlags(268468224);
        try
        {
          startActivity(localIntent);
          if (!this.j)
          {
            finish();
            return;
          }
        }
        catch (ActivityNotFoundException paramString1)
        {
          f.a(this);
          f.a(this.a);
          paramString1 = new Intent();
          paramString1.putExtra("status", 8);
          d.a().b(paramString1);
        }
      }
    } while (this.d == null);
    this.d.c();
  }
  
  private void b()
  {
    if (this.d != null)
    {
      this.d.a(new AppUpdateActivity.b(null));
      this.d.a(new AppUpdateActivity.c(null));
    }
  }
  
  private void b(com.huawei.updatesdk.a.b.c.b paramb)
  {
    paramb = paramb.a();
    if (paramb != null)
    {
      int i1 = paramb.getInt("download_status_param", -1);
      d.a().a(a(-1, -1, i1));
      if (!com.huawei.updatesdk.a.b.b.a.a.b(i1))
      {
        f();
        if (com.huawei.updatesdk.a.b.b.a.a.a(i1))
        {
          Toast.makeText(this, getString(g.b(this, "upsdk_third_app_dl_install_failed")), 0).show();
          finish();
        }
      }
    }
  }
  
  private void b(ApkUpgradeInfo paramApkUpgradeInfo)
  {
    com.huawei.updatesdk.service.f.a locala = com.huawei.updatesdk.service.f.a.a(this, null, getString(g.b(this, "upsdk_install")));
    locala.a(new AppUpdateActivity.6(this, paramApkUpgradeInfo, locala));
    paramApkUpgradeInfo = getString(g.b(this, "upsdk_app_download_info_new"));
    locala.a(new AppUpdateActivity.7(this));
    locala.a(a.a.a, paramApkUpgradeInfo);
    locala.a(new AppUpdateActivity.8(this, locala));
  }
  
  private void b(String paramString)
  {
    this.c = com.huawei.updatesdk.service.f.a.a(this, null, getString(g.b(this, "upsdk_third_app_dl_cancel_download_prompt_ex")));
    this.c.a(new AppUpdateActivity.3(this));
    paramString = getString(g.b(this, "upsdk_third_app_dl_sure_cancel_download"));
    this.c.a(new AppUpdateActivity.4(this));
    this.c.a(a.a.a, paramString);
  }
  
  private long c(ApkUpgradeInfo paramApkUpgradeInfo)
  {
    long l1 = paramApkUpgradeInfo.getLongSize_();
    if ((paramApkUpgradeInfo.getPackingType_() == 1) && (paramApkUpgradeInfo.getBundleSize_() > 0L)) {
      l1 = paramApkUpgradeInfo.getBundleSize_();
    }
    while (paramApkUpgradeInfo.getDiffSize_() <= 0) {
      return l1;
    }
    return paramApkUpgradeInfo.getDiffSize_();
  }
  
  private void c()
  {
    if (!com.huawei.updatesdk.service.e.c.a(this, this.a))
    {
      if (com.huawei.updatesdk.a.b.a.a.a() == null) {
        com.huawei.updatesdk.a.b.a.a.a(this);
      }
      f.a(this);
      f.a(this.a);
      this.d.c();
      return;
    }
    a(this.i.getPackage_(), this.i.getDetailId_());
  }
  
  private void c(int paramInt)
  {
    if ((paramInt == 5) || (paramInt == 4))
    {
      Toast.makeText(this, getString(g.b(this, "upsdk_third_app_dl_install_failed")), 0).show();
      g.a.a(this.a, -1000001);
      finish();
    }
    if (paramInt == 7)
    {
      g.a.a(this.a, -1000001);
      if (this.g) {
        d(this.i);
      }
    }
    else
    {
      return;
    }
    finish();
  }
  
  private void c(com.huawei.updatesdk.a.b.c.b paramb)
  {
    new Handler(Looper.getMainLooper()).post(new AppUpdateActivity.1(this, paramb));
  }
  
  private void c(String paramString)
  {
    if ((this.b != null) && (this.b.isShowing())) {
      return;
    }
    this.b = new AlertDialog.Builder(this).create();
    View localView = LayoutInflater.from(this).inflate(g.d(this, "upsdk_app_dl_progress_dialog"), null);
    this.e = ((ProgressBar)localView.findViewById(g.a(this, "third_app_dl_progressbar")));
    this.e.setMax(100);
    this.f = ((TextView)localView.findViewById(g.a(this, "third_app_dl_progress_text")));
    localView.findViewById(g.a(this, "cancel_bg")).setOnClickListener(new AppUpdateActivity.5(this, paramString));
    this.b.setView(localView);
    this.b.setCancelable(false);
    this.b.setCanceledOnTouchOutside(false);
    if (!a.a(this)) {
      this.b.show();
    }
    this.f.setText(i.a(0));
  }
  
  private void d()
  {
    int i1 = com.huawei.updatesdk.service.e.b.a().b();
    if ((i1 >= 11) && (i1 < 17)) {
      this.d.a(g.e(this, "upsdk_update_all_button"), g.f(this, "upsdk_white"));
    }
  }
  
  private void d(ApkUpgradeInfo paramApkUpgradeInfo)
  {
    if (paramApkUpgradeInfo == null)
    {
      finish();
      return;
    }
    String str3 = getString(g.b(this, "upsdk_ota_title"));
    String str2 = getString(g.b(this, "upsdk_ota_notify_updatebtn"));
    String str1 = getString(g.b(this, "upsdk_ota_cancel"));
    d(str3);
    if (1 == paramApkUpgradeInfo.getIsCompulsoryUpdate_())
    {
      str1 = getString(g.b(this, "upsdk_ota_force_cancel_new"));
      if (this.k) {
        this.d.a();
      }
      this.g = true;
    }
    this.d.a(new AppUpdateActivity.9(this));
    b();
    this.d.a(new AppUpdateActivity.10(this));
    if (this.g) {
      this.d.a(false);
    }
    for (;;)
    {
      this.d.a(a.a.a, str2);
      this.d.a(a.a.b, str1);
      d();
      return;
      this.d.a(new AppUpdateActivity.2(this));
    }
  }
  
  private void d(String paramString)
  {
    View localView = LayoutInflater.from(this).inflate(g.d(this, "upsdk_ota_update_view"), null);
    if (TextUtils.isEmpty(this.i.getNewFeatures_())) {}
    for (Object localObject = getString(g.b(this, "upsdk_choice_update"));; localObject = this.i.getNewFeatures_())
    {
      ((TextView)localView.findViewById(g.a(this, "content_textview"))).setText((CharSequence)localObject);
      localObject = this.i.getVersion_();
      ((TextView)localView.findViewById(g.a(this, "version_textview"))).setText((CharSequence)localObject);
      localObject = i.a(this, c(this.i));
      ((TextView)localView.findViewById(g.a(this, "appsize_textview"))).setText((CharSequence)localObject);
      localObject = this.i.getName_();
      ((TextView)localView.findViewById(g.a(this, "name_textview"))).setText((CharSequence)localObject);
      localObject = (TextView)localView.findViewById(g.a(this, "allsize_textview"));
      a(this.i, (TextView)localObject);
      a(localView);
      this.d = com.huawei.updatesdk.service.f.a.a(this, paramString, null);
      this.d.a(localView);
      return;
    }
  }
  
  private void e()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addDataScheme("package");
    this.q = new AppUpdateActivity.d(this, null);
    a.a(this, localIntentFilter, this.q);
  }
  
  private void e(ApkUpgradeInfo paramApkUpgradeInfo)
  {
    e();
    c(paramApkUpgradeInfo.getPackage_());
    this.l = new com.huawei.updatesdk.a.b.b.b(new com.huawei.updatesdk.a.b.b.a(paramApkUpgradeInfo.getDownurl_(), paramApkUpgradeInfo.getLongSize_(), paramApkUpgradeInfo.getSha256_()));
    this.l.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
  }
  
  private void f()
  {
    try
    {
      if ((this.b != null) && (this.b.isShowing()))
      {
        this.b.dismiss();
        this.b = null;
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.a("AppUpdateActivity", "progressDialog dismiss IllegalArgumentException");
    }
  }
  
  public void a(int paramInt)
  {
    Toast.makeText(this, getString(g.b(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
    d.a().a(paramInt);
    finish();
  }
  
  public void a(int paramInt, com.huawei.updatesdk.a.b.c.b paramb)
  {
    if (paramb == null) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        b(paramb);
        return;
      }
      if (1 == paramInt)
      {
        a(paramb);
        return;
      }
    } while (2 != paramInt);
    c(paramb);
  }
  
  public void a(ApkUpgradeInfo paramApkUpgradeInfo)
  {
    if (paramApkUpgradeInfo != null)
    {
      com.huawei.updatesdk.service.b.c.b().a(this);
      b(paramApkUpgradeInfo);
      return;
    }
    Toast.makeText(this, getString(g.b(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
    finish();
  }
  
  public void b(int paramInt)
  {
    Toast.makeText(this, getString(g.b(this, "upsdk_connect_server_fail_prompt_toast")), 0).show();
    d.a().a(paramInt);
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    if (this.g) {
      overridePendingTransition(0, 0);
    }
    this.p = new Intent();
    this.p.putExtra("status", this.m);
    this.p.putExtra("failcause", this.n);
    this.p.putExtra("compulsoryUpdateCancel", this.g);
    this.p.putExtra("buttonstatus", this.o);
    d.a().b(this.p);
    super.finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1002)
    {
      if (paramIntent != null)
      {
        paramIntent = com.huawei.updatesdk.a.b.c.b.a(paramIntent);
        this.m = paramInt2;
        this.n = paramIntent.b("installResultCode", -99);
        if (this.i.getIsCompulsoryUpdate_() == 1) {
          this.g = paramIntent.a("compulsoryUpdateCancel", false);
        }
      }
      if ((this.i.getIsCompulsoryUpdate_() == 1) && (paramInt2 == 4)) {
        this.g = true;
      }
      if (paramInt2 != 4) {
        break label101;
      }
    }
    label101:
    for (this.o = 100;; this.o = 101)
    {
      if (!this.h) {
        finish();
      }
      return;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    paramBundle = com.huawei.updatesdk.a.b.c.b.a(getIntent()).a();
    if (paramBundle == null)
    {
      super.finish();
      return;
    }
    Serializable localSerializable = paramBundle.getSerializable("app_update_parm");
    if ((localSerializable != null) && ((localSerializable instanceof ApkUpgradeInfo)))
    {
      this.i = ((ApkUpgradeInfo)localSerializable);
      this.k = paramBundle.getBoolean("app_must_btn", false);
      if (this.i.getIsCompulsoryUpdate_() == 1) {
        this.j = true;
      }
      if (!TextUtils.isEmpty(h.a().b())) {
        this.a = h.a().b();
      }
      if ((this.i.getDevType_() != 1) || (com.huawei.updatesdk.service.e.c.a(this) != c.a.b)) {
        d(this.i);
      }
    }
    else
    {
      this.m = 3;
      finish();
      return;
    }
    a(this.i.getPackage_());
  }
  
  protected void onDestroy()
  {
    if (this.c != null)
    {
      this.c.c();
      this.c = null;
    }
    if (this.d != null)
    {
      this.d.c();
      this.d = null;
    }
    f();
    a();
    super.onDestroy();
    finishActivity(1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.AppUpdateActivity
 * JD-Core Version:    0.7.0.1
 */