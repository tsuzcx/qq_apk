package com.tencent.biz.pubaccount.readinjoy.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.SwipeBackLayout;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import java.util.List;
import lbt;
import lbu;
import lbv;
import lbw;
import lbx;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ReadInJoyArticleDetailActivity
  extends QQBrowserActivity
{
  protected int a;
  protected long a;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  public volatile AppInterface a;
  public BrowserAppInterface a;
  public Object a;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  protected long b;
  protected String b;
  private long c;
  protected String c;
  private long d;
  protected String d;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  protected String e;
  private int f;
  
  public ReadInJoyArticleDetailActivity()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangClass = ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.class;
  }
  
  private void e()
  {
    if ((getIntent() != null) && (!getIntent().getBooleanExtra("from_native", false))) {
      return;
    }
    getMainLooper();
    Looper.myQueue().addIdleHandler(new lbx(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetail", 2, "请求开始时间" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_JavaLangString, new lbw(this));
  }
  
  @TargetApi(23)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public boolean a(String paramString)
  {
    return paramString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString);
  }
  
  public byte[] a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ArrayOfByte == null)
      {
        boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
        if (bool) {}
      }
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(500L);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleDetail", 2, "等待结束时间时" + System.currentTimeMillis());
        }
        if (this.jdField_a_of_type_ArrayOfByte == null) {
          this.jdField_a_of_type_JavaLangString = null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleDetail", 2, "返回结果时间" + System.currentTimeMillis());
        }
        return this.jdField_a_of_type_ArrayOfByte;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  @TargetApi(14)
  public void b()
  {
    WebViewFragment localWebViewFragment = b();
    if ((localWebViewFragment instanceof ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment))
    {
      ((ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment)localWebViewFragment).f();
      return;
    }
    QLog.e("ReadInJoyArticleDetail", 1, "setWebViewVisibility error curFragment error");
  }
  
  public void c()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label94;
      }
      if ((!SystemUtil.b()) && (!SystemUtil.d())) {
        this.mSystemBarComp.setStatusBarColor(-7829368);
      }
    }
    else
    {
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-7829368);
    this.mSystemBarComp.setStatusBarDarkMode(true);
    return;
    label94:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      a(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.d())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    while (paramInt2 != 1)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      ReportController.b(null, "CliOper", "", "", "0X8005438", "0X8005438", 0, 0, "", "", "", "");
      QfavBuilder.a(this, paramIntent);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof BrowserAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    ThreadManager.getSubThreadHandler().post(new lbt(this));
    this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout = new SwipeBackLayout(this);
    this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.a(this);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getSubThreadHandler().post(new lbv(this));
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    long l = this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    if ((l > 0L) && (this.jdField_b_of_type_Long > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetail", 2, "start to report article read info:" + ReadInJoyUtils.a(this.jdField_e_of_type_JavaLangString, this.jdField_e_of_type_Long, 0));
      }
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FB", "0X80066FB", 0, 0, Long.toString(l / 1000L), Long.toString(this.jdField_b_of_type_Long), Integer.toString(this.f), ReadInJoyUtils.a(this.jdField_e_of_type_JavaLangString, this.jdField_e_of_type_Long, 0), false);
    }
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ReadInJoyUtils.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = this.jdField_b_of_type_Long;
    localReportInfo.mChannelId = this.jdField_a_of_type_Int;
    localReportInfo.mAlgorithmId = ((int)this.jdField_e_of_type_Long);
    localReportInfo.mStrategyId = this.f;
    localReportInfo.mOperation = 9;
    localReportInfo.mReadTimeLength = ((int)(l / 1000L));
    localReportInfo.mInnerId = this.jdField_e_of_type_JavaLangString;
    localArrayList.add(localReportInfo);
    ThreadManager.getSubThreadHandler().post(new lbu(this, localArrayList));
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.j();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    c();
    e();
  }
  
  @TargetApi(12)
  protected void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getIntent().getExtras();
    this.jdField_b_of_type_JavaLangString = localBundle.getString("url");
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("ip_connect", false);
    this.jdField_a_of_type_JavaLangString = localBundle.getString("read_in_joy_from_cache");
    String str = PreloadManager.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_JavaLangString = localBundle.getString("preload_iamge_url");
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(str)) && (str.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetail", 2, "在onCreate中执行操作的时间时" + System.currentTimeMillis());
      }
      a();
    }
    super.onCreate(paramBundle);
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      QLog.d("ReadInJoyArticleDetail", 2, "initModel url empty");
      return;
    }
    this.jdField_d_of_type_JavaLangString = localBundle.getString("subscribename");
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_d_of_type_JavaLangString = "";
    }
    paramBundle = String.valueOf(53);
    str = localBundle.getString("from");
    if (str == null) {}
    for (;;)
    {
      this.jdField_e_of_type_Int = Integer.valueOf(paramBundle).intValue();
      this.jdField_b_of_type_Long = localBundle.getLong("articleid", -1L);
      this.jdField_e_of_type_JavaLangString = localBundle.getString("row_key", "");
      this.jdField_a_of_type_Int = localBundle.getInt("channelid", -1);
      this.f = localBundle.getInt("strategyid", -1);
      this.jdField_e_of_type_Long = localBundle.getLong("algorithmid", -1L);
      this.jdField_a_of_type_Long = localBundle.getLong("recommendSeq", -1L);
      return;
      paramBundle = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity
 * JD-Core Version:    0.7.0.1
 */