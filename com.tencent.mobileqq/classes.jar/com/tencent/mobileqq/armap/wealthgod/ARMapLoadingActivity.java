package com.tencent.mobileqq.armap.wealthgod;

import abav;
import abaw;
import abax;
import abay;
import abaz;
import abba;
import abbb;
import abbc;
import abbd;
import abbe;
import abbf;
import abbg;
import abbh;
import abbi;
import abbj;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.nineoldandroids.animation.ValueAnimator;
import com.qq.im.poi.LbsPackNameUtil;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.config.ARMapConfig.WealthGodConfig;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.config.ConfigCheckHander;
import com.tencent.mobileqq.armap.config.ConfigCheckHander.Listener;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class ARMapLoadingActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  private ArMapHandler jdField_a_of_type_ComTencentMobileqqArmapArMapHandler;
  private ArMapObserver jdField_a_of_type_ComTencentMobileqqArmapArMapObserver;
  private ARMapConfig jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig;
  private ARMapConfigManager jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager;
  private ConfigCheckHander.Listener jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander$Listener;
  private ARMapLoadingActivity.LoadingTimeStamp jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp = new ARMapLoadingActivity.LoadingTimeStamp();
  private ARMapSplashView jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView;
  private WealthGodInfo jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo;
  private EarlyDownloadManager.EarlyDownLoadListener jdField_a_of_type_ComTencentMobileqqEarlydownloadEarlyDownloadManager$EarlyDownLoadListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private double jdField_b_of_type_Double;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  
  private void A()
  {
    String str = "";
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null)
    {
      l = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Long;
      str = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapLoadingActivity", 2, String.format("reportLoadFail mCurUIState=%s adCode=%s companyName=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Long.valueOf(l), str }));
      }
      if (this.jdField_b_of_type_Int == 1) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007950", "0X8007950", 0, 0, "2", "", String.valueOf(l), str);
      }
      do
      {
        return;
        if (this.jdField_b_of_type_Int == 4)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X800794D", "0X800794D", 0, 0, "2", "", String.valueOf(l), str);
          return;
        }
        if (this.jdField_b_of_type_Int == 5)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80079C5", "0X80079C5", 0, 0, "2", "", String.valueOf(l), str);
          return;
        }
        if (this.jdField_b_of_type_Int == 6)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X800794E", "0X800794E", 0, 0, "2", "", String.valueOf(l), str);
          return;
        }
      } while (this.jdField_b_of_type_Int != 7);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X800794B", "0X800794B", 0, 0, "2", "", String.valueOf(l), str);
      return;
      l = 0L;
    }
  }
  
  private void B()
  {
    String str = "";
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null)
    {
      l = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Long;
      str = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapLoadingActivity", 2, String.format("reportLoadCancel mCurUIState=%s adCode=%s companyName=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Long.valueOf(l), str }));
      }
      if (this.jdField_b_of_type_Int == 1) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007950", "0X8007950", 0, 0, "3", "", String.valueOf(l), str);
      }
      do
      {
        return;
        if (this.jdField_b_of_type_Int == 4)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X800794D", "0X800794D", 0, 0, "3", "", String.valueOf(l), str);
          return;
        }
        if (this.jdField_b_of_type_Int == 5)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80079C5", "0X80079C5", 0, 0, "3", "", String.valueOf(l), str);
          return;
        }
        if (this.jdField_b_of_type_Int == 6)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X800794E", "0X800794E", 0, 0, "3", "", String.valueOf(l), str);
          return;
        }
      } while (this.jdField_b_of_type_Int != 7);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X800794B", "0X800794B", 0, 0, "3", "", String.valueOf(l), str);
      return;
      l = 0L;
    }
  }
  
  private void C() {}
  
  private WealthGodInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.a();
      if (localObject1 != null) {
        break label61;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapLoadingActivity", 2, String.format("getCachedWealthGodInfo info=%s", new Object[] { localObject1 }));
      }
      return localObject1;
      label61:
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      if ((l3 >= ((WealthGodInfo)localObject1).c) && (l3 <= ((WealthGodInfo)localObject1).jdField_d_of_type_Long))
      {
        this.jdField_a_of_type_Double = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.a();
        this.jdField_b_of_type_Double = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.b();
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.a();
      }
      else
      {
        long l4 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.b();
        long l2 = 900000L;
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.a();
        long l1 = l2;
        if (localObject3 != null)
        {
          localObject3 = ((ARMapConfig)localObject3).wealthGodConfig;
          l1 = l2;
          if (localObject3 != null) {
            l1 = ((ARMapConfig.WealthGodConfig)localObject3).loadingPageInfoExpireDuration;
          }
        }
        if (l3 - l4 > l1)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("ARMapLoadingActivity", 2, String.format("getCachedWealthGodInfo cache info invalid! curTime=%s cacheUpdateTime=%s invalidInterval=%s", new Object[] { Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l1) }));
            localObject1 = localObject2;
          }
        }
        else
        {
          this.jdField_a_of_type_Double = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.a();
          this.jdField_b_of_type_Double = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.b();
          this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.a();
        }
      }
    }
  }
  
  private void a()
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long <= 1000L) {
      return;
    }
    if (!this.h) {
      this.i = true;
    }
    finish();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("ARMapLoadingActivity", 1, String.format("handleLoadFail failType=%s subType=%s failInfo=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setLoadStatus(3, paramInt1);
    }
    if (((paramInt1 == 1) || (paramInt1 == 4)) && (!this.g)) {
      w();
    }
    this.h = true;
    A();
    b(paramInt1, paramInt2, paramString);
    u();
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("sendStartCompletedResponseDelay delay=%s", new Object[] { Long.valueOf(paramLong) }));
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(105, paramLong);
  }
  
  private void a(WealthGodInfo paramWealthGodInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo = paramWealthGodInfo;
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setWealthGodInfo(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo, this.jdField_a_of_type_Boolean);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.a();
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo == null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 200L);
    }
    for (;;)
    {
      f();
      y();
      return;
      if (this.jdField_b_of_type_Int == 5) {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.c();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(102, 200L);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("startARMapThread preStart=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ARMapThreadStubReceiver.class);
    localIntent.setAction("com.tencent.mobileqq.armap.ACTION_START_THREAD");
    localIntent.putExtra("pre_start_thread", paramBoolean);
    sendBroadcast(localIntent);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.k = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(108);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(108, 5000L);
      return;
    }
    this.j = false;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "sendStartCompletedResponse");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.armap.ACTION_START_ARMAP_LOADING_COMPLETED");
    sendBroadcast(localIntent);
  }
  
  private void b(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("reportLoadFail failType=%s subType=%s failInfo=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    ThreadManager.post(new abay(this, paramInt1, paramInt2, paramString), 5, null, false);
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("reportPreStartThreadSuccess success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    ThreadManager.post(new abaz(this, paramBoolean), 5, null, false);
  }
  
  private boolean b()
  {
    ARMapConfig localARMapConfig = ((ARMapConfigManager)this.app.getManager(189)).a();
    if (localARMapConfig == null) {}
    for (boolean bool = false;; bool = localARMapConfig.isWealthGodEnterOpen())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapLoadingActivity", 2, String.format("hasWealthGodEntry hasEntry=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new abbb(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED");
      localIntentFilter.addAction("com.tencent.mobileqq.armap.ACTION_START_ARMAP_COMPLETED");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("reportStartThreadTimeout timeout=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    ThreadManager.post(new abba(this, paramBoolean), 5, null, false);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("launchARMap mIsResume=%s mNeedLaunchARMapOnAnimEnd=%s", new Object[] { Boolean.valueOf(this.mIsResume), Boolean.valueOf(this.jdField_e_of_type_Boolean) }));
    }
    g();
    if (!this.mIsResume)
    {
      QLog.d("ARMapLoadingActivity", 1, "launchARMap activity is paused, launch armap after resume.");
      this.f = true;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.m = System.currentTimeMillis();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ARMapActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("extra_need_completed_response", true);
    localIntent.putExtra("extra_wealth_god_info", this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo);
    localIntent.putExtra("extra_in_special_area", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("extra_location_longitude", this.jdField_a_of_type_Double);
    localIntent.putExtra("extra_location_latitude", this.jdField_b_of_type_Double);
    localIntent.putExtra("extra_location_adcode", this.jdField_a_of_type_Long);
    localIntent.putExtra("extra_cur_progress", this.jdField_a_of_type_Int);
    localIntent.putExtra("extra_time_stamp", this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp);
    localIntent.putExtra("extra_lbs_pid", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("extra_lbs_location", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("extra_lbs_nick", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("extra_lbs_status", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("extra_lbs_uin", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("entrance_type", this.jdField_c_of_type_Int);
    localIntent.putExtra("entrance_from", this.jdField_d_of_type_Int);
    if (getIntent().getBooleanExtra("from_jump", false))
    {
      double d1 = getIntent().getDoubleExtra("default_lon", 0.0D);
      double d2 = getIntent().getDoubleExtra("default_lat", 0.0D);
      long l = getIntent().getLongExtra("adcode", 0L);
      localIntent.putExtra("default_lon", d1);
      localIntent.putExtra("default_lat", d2);
      localIntent.putExtra("adcode", l);
      localIntent.putExtra("from_jump", true);
    }
    startActivity(localIntent);
    overridePendingTransition(0, 0);
    t();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(109);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(109, 15000L);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "startProgressAnim");
    }
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[0]);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new abbc(this));
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(new abbd(this));
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setIntValues(new int[] { 0, 80 });
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(1000L);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "cancelProgressAnim");
    }
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "handleLocationMsg");
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.c = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new abbe(this, 3, true, true, 0L, false, false, "wealthgod_locate_check");
    }
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(106);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(106, 36000L);
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("handleRequestInfoMsg mADCode=%s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.e = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver = new abbf(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapHandler.a(this.jdField_a_of_type_Long, false, 1, null);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(107);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(107, 20000L);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "handleCheckAndDownloadResMsg");
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.g = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander$Listener == null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander$Listener = new abbg(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager != null)
    {
      ConfigCheckHander localConfigCheckHander = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.a();
      if (localConfigCheckHander != null)
      {
        localConfigCheckHander.a(this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander$Listener);
        if (localConfigCheckHander.a()) {
          break label99;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ARMapLoadingActivity", 2, "handleCheckAndDownloadResMsg no checking, start check.");
        }
        localConfigCheckHander.b(false);
      }
    }
    label99:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ARMapLoadingActivity", 2, "handleCheckAndDownloadResMsg checking is underway, wait callback.");
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "handleCheckAndDownloadSo");
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.i = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadEarlyDownloadManager$EarlyDownLoadListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadEarlyDownloadManager$EarlyDownLoadListener = new abbh(this);
    }
    ThreadManager.postImmediately(new abbi(this), null, false);
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "handleLaunchARMapMsg");
    }
    b(this.j);
    a(false);
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "handleSendStartCompletedMsg");
    }
    b();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "handleCheckLocationTimeoutMsg");
    }
    this.jdField_c_of_type_Boolean = true;
    SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_d_of_type_Long = System.currentTimeMillis();
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(104);
    localMessage.arg1 = 4;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "handleCheckRequestInfoTimeoutMsg");
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.f = System.currentTimeMillis();
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(104);
    localMessage.arg1 = 5;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "handleCheckStartARMapThreadTimeoutMsg");
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.l = System.currentTimeMillis();
    c(true);
    e();
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "handleCheckLaunchARMapTimeoutMsg");
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(104);
    localMessage.arg1 = 6;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "handleCheckAndDownloadSoTimeoutMsg");
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.j = System.currentTimeMillis();
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(104);
    localMessage.arg1 = 8;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "handleCheckAndDownloadSoEnd");
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.j = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
    {
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(103);
  }
  
  private void t()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "enableTouchToRetry");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setOnClickListener(new abaw(this));
    }
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "disableTouchToRetry");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setOnClickListener(null);
    }
  }
  
  private void w()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230, null, "定位不到你的位置，请检查网络设置及定位权限后再尝试一次吧。", "我知道了", null, null, new abax(this));
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ARMapLoadingActivity", 2, "showLocationFailDialog fail!", localException);
    }
  }
  
  private void x()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, SplashActivity.class);
    startActivity(localIntent);
  }
  
  private void y()
  {
    String str2 = "";
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null)
    {
      l = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Long;
      str2 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapLoadingActivity", 2, String.format("reportEntryState mCurUIState=%s adCode=%s companyName=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Long.valueOf(l), str2 }));
      }
      String str1 = "";
      if (this.jdField_b_of_type_Int == 1) {
        str1 = "4";
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X800783F", "0X800783F", 0, 0, str1, "", String.valueOf(l), str2);
        return;
        if (this.jdField_b_of_type_Int == 4) {
          str1 = "2";
        } else if (this.jdField_b_of_type_Int == 5) {
          str1 = "5";
        } else if (this.jdField_b_of_type_Int == 6) {
          str1 = "3";
        } else if (this.jdField_b_of_type_Int == 7) {
          str1 = "1";
        }
      }
      l = 0L;
    }
  }
  
  private void z()
  {
    String str = "";
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null)
    {
      l = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Long;
      str = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapLoadingActivity", 2, String.format("reportLocationSuccess mCurUIState=%s adCode=%s companyName=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Long.valueOf(l), str }));
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007950", "0X8007950", 0, 0, "1", "", String.valueOf(l), str);
      return;
      l = 0L;
    }
  }
  
  public String a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager != null)
    {
      ARMapConfig localARMapConfig = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.a();
      localObject1 = localObject2;
      if (localARMapConfig != null) {
        localObject1 = localARMapConfig.mapEngineSoMd5;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "getMapEngineSoMd5=" + (String)localObject1);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    return localObject2;
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    ARMapDPC localARMapDPC = SplashBitmapUtils.a();
    int k;
    if (localARMapDPC == null)
    {
      k = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ARMapLoadingActivity", 2, "needForceCheckSoMd5, dpc=" + localARMapDPC);
      }
      if (k != 0) {
        break label64;
      }
    }
    label64:
    do
    {
      return bool2;
      k = localARMapDPC.jdField_b_of_type_Int;
      break;
      if (!TextUtils.isEmpty(a())) {
        bool1 = true;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ARMapLoadingActivity", 2, "needForceCheckSoMd5 return=" + bool1);
    return bool1;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!b())
    {
      QLog.d("ARMapLoadingActivity", 1, "doOnCreate no entry, finish this activity.");
      x();
      finish();
      return false;
    }
    C();
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapLoadingActivity$LoadingTimeStamp.jdField_a_of_type_Long = System.currentTimeMillis();
    SplashBitmapUtils.a(this.app);
    setContentView(2130970198);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.app;
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapHandler = ((ArMapHandler)this.app.a(101));
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager = ((ARMapConfigManager)this.app.getManager(189));
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.a();
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView = ((ARMapSplashView)findViewById(2131369565));
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setSplashMode(2);
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setLoadStatus(0);
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setProgressMax(100);
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setARMapConfig(this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369567));
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369566));
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(0);
      this.mSystemBarComp.setStatusDrawable(null);
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        int k = ImmersiveUtils.a(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, k, 0, 0);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new abbj(this, getMainLooper(), this);
    c();
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      localObject = (WealthGodInfo)localIntent.getParcelableExtra("extra_wealth_god_info");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = a();
      }
      this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("extra_need_completed_response", false);
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("location");
      this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("nick");
      this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("pid");
      this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("status");
      this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("uin");
      this.jdField_c_of_type_Int = localIntent.getIntExtra("entrance_type", 0);
      this.jdField_d_of_type_Int = localIntent.getIntExtra("entrance_from", 0);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setLocationText(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setNickName(LbsPackNameUtil.a(this.jdField_b_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setRedPackDetail(LbsPackNameUtil.a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setWebKey(this.jdField_c_of_type_Int);
        if (StringUtil.a(this.jdField_d_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setCompanyToDefaultIcon();
        }
      }
      else
      {
        localObject = paramBundle;
        if (QLog.isColorLevel()) {
          QLog.d("ARMapLoadingActivity", 2, "armaploading jump from url mSplashView=" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView);
        }
      }
    }
    for (Object localObject = paramBundle;; localObject = null)
    {
      if (getIntent().getBooleanExtra("from_jump", false))
      {
        this.jdField_a_of_type_Long = getIntent().getLongExtra("adcode", 0L);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new abav(this), 400L);
        if (QLog.isColorLevel()) {
          QLog.d("ARMapLoadingActivity", 2, "armaploading activity fromJump  mADCode：" + this.jdField_a_of_type_Long);
        }
      }
      for (;;)
      {
        t();
        paramBundle = (WebProcessManager)this.app.getManager(12);
        if (paramBundle != null) {
          paramBundle.e();
        }
        return true;
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.a(FaceDrawable.a(this.app, this.jdField_d_of_type_JavaLangString, (byte)3));
        break;
        a((WealthGodInfo)localObject);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.g = true;
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadEarlyDownloadManager$EarlyDownLoadListener != null)
    {
      ArNativeSoDownloadHandler localArNativeSoDownloadHandler = (ArNativeSoDownloadHandler)((EarlyDownloadManager)this.app.getManager(76)).a("qq.android.ar.native.so_v7.3.8");
      if (localArNativeSoDownloadHandler != null) {
        localArNativeSoDownloadHandler.b(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadEarlyDownloadManager$EarlyDownLoadListener);
      }
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(105)) {
        b();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    }
    if (this.i) {
      B();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a(true);
    if (this.jdField_b_of_type_Boolean)
    {
      a(300L);
      this.jdField_b_of_type_Boolean = false;
    }
    if (this.f)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(103, 500L);
      this.f = false;
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long <= 1000L) {
      return true;
    }
    if (!this.h) {
      this.i = true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity
 * JD-Core Version:    0.7.0.1
 */