package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInjoyWebRenderSoLoader;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.ContentScrollListener;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.BridgeAdapter;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.ui.ComponentAdapter;
import com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager;
import com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.NativeVueLoaderManager;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.NativeVueStatusInfo;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.ViolaBizLibHandler;
import com.tencent.mobileqq.earlydownload.handler.ViolaLibHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.IActivityState;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaRenderContainer;
import com.tencent.viola.core.ViolaSDKEngine;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.utils.ViolaUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

public class ViolaBaseView
  extends RelativeLayout
  implements CommonSuspensionGestureLayout.ContentScrollListener, IActivityState
{
  public static boolean a;
  private static String jdField_b_of_type_JavaLangString = "ViolaBaseView";
  private static int jdField_f_of_type_Int = 0;
  private static int jdField_g_of_type_Int = 1;
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private RIJTransMergeKanDianReport.ReportR5Builder jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokReportRIJTransMergeKanDianReport$ReportR5Builder;
  private ViolaReportDelegate jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate;
  private ViolaBaseView.MyHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$MyHandler;
  private ViolaBaseView.OnBaseViewListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$OnBaseViewListener;
  private ViolaBaseView.ViolaCreactPageObject jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaCreactPageObject;
  private ViolaBaseView.ViolaViewListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaViewListener;
  private NativeVueStatusInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeNativeVueStatusInfo = new NativeVueStatusInfo();
  private FPSCalculator.GetFPSListener jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator$GetFPSListener;
  private ViolaInstance jdField_a_of_type_ComTencentViolaCoreViolaInstance;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public String a;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new ViolaBaseView.2(this);
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new ViolaBaseView.3(this);
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean jdField_f_of_type_Boolean = true;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h = false;
  private boolean i = true;
  private boolean j = false;
  private boolean k = false;
  private boolean l;
  private boolean m;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public ViolaBaseView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ViolaBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ViolaBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public ViolaBaseView(Context paramContext, Boolean paramBoolean)
  {
    super(paramContext);
    a(paramContext);
    this.jdField_b_of_type_Boolean = paramBoolean.booleanValue();
  }
  
  private void a(int paramInt)
  {
    if (paramInt == jdField_f_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_START);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    NativeVueLoaderManager.a().a();
    ViolaSoLoaderManager.a.a().a(jdField_b_of_type_JavaLangString + "_" + paramInt + "_" + hashCode(), new ViolaBaseView.4(this, paramInt));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((this.j) || (!paramBoolean) || (this.h)) {
      return;
    }
    this.j = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaViewListener != null)
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        new Handler(Looper.getMainLooper()).post(new ViolaBaseView.18(this, paramInt));
      }
    }
    else
    {
      if (paramInt != 100) {
        break label164;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_NET);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 2, "openViolaPage error,code=" + paramInt + ",biz url=" + this.jdField_a_of_type_JavaLangString);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaViewListener.a(paramInt);
      break;
      label164:
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SDK, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 5)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 7)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_UNZIP);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 8)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 6)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 9)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_CHANGE_CGI);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_CHANGE_CGI, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 3)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 10)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$MyHandler = new ViolaBaseView.MyHandler(this, Looper.getMainLooper());
    this.jdField_a_of_type_Int = Math.abs(new Random().nextInt());
    if ("1".equals(Aladdin.getConfig(420).getString("is_show_net_detail", "")))
    {
      jdField_a_of_type_Boolean = true;
      return;
    }
    jdField_a_of_type_Boolean = false;
  }
  
  private void a(String paramString, ViolaBaseView.LoadAsyBack paramLoadAsyBack)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http"))) {}
    String str;
    do
    {
      return;
      str = Uri.parse(paramString).getQueryParameter("v_bid");
    } while (TextUtils.isEmpty(str));
    ViolaAccessHelper.a(str, new ViolaBaseView.8(this, str, paramString, paramLoadAsyBack));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_c_of_type_JavaLangString = paramString;
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_NET);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.TIME_BIZ_JS_NET, Long.toString(System.currentTimeMillis() - this.jdField_c_of_type_Long));
        p();
      }
      if (!paramBoolean) {
        t();
      }
      return;
    }
    a(3, paramBoolean);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaViewListener != null)
    {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        break label67;
      }
      new Handler(Looper.getMainLooper()).post(new ViolaBaseView.17(this, paramInt));
    }
    for (;;)
    {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "openViolaPage process,code=" + paramInt);
      return;
      label67:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaViewListener.b(paramInt);
    }
  }
  
  private void b(String paramString)
  {
    if (!ReadInjoyWebRenderSoLoader.a(paramString))
    {
      c(7);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip exists unzip fail");
      }
    }
    do
    {
      return;
      if ((ViolaLibHandler.i()) && (ViolaBizLibHandler.i()))
      {
        a(jdField_g_of_type_Int);
        return;
      }
      c(8);
    } while (!QLog.isColorLevel());
    QLog.e(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip succ but not Exist");
  }
  
  private void b(boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      a(2, paramBoolean);
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_OFFLINE);
    }
    if ((this.jdField_a_of_type_JavaLangString.contains("v_tid")) && (this.jdField_a_of_type_JavaLangString.contains("v_bundleName")))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from judgeIfNeedCgi v_tid url: " + this.jdField_a_of_type_JavaLangString);
      }
      d(paramBoolean);
      return;
    }
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    e(paramBoolean);
    f(paramBoolean);
  }
  
  private void c(int paramInt)
  {
    a(paramInt, true);
  }
  
  private void c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (ReadInJoyUtils.a() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "checkOfflineUpNotCallback.");
    }
    ThreadManager.post(new ViolaBaseView.11(this, paramString), 8, null, true);
  }
  
  private void c(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_OFFLINE);
    }
    ViolaAccessHelper.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + ViolaBizUtils.b(), new ViolaBaseView.6(this, paramBoolean, l1));
    a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547", new ViolaBaseView.7(this, paramBoolean, System.currentTimeMillis()));
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance == null) {}
    while (this.h) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.renderVueDomDirectly(paramString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "render VueDom");
      }
    }
    u();
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_START);
    }
    Bundle localBundle = new Bundle();
    new HttpCgiAsyncTask("https://viola.kandian.qq.com/cgi-bin/bundle/exchange?from=android&originUrl=" + URLEncoder.encode(new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&v_sdk=").append("8.5.5").append("&v_appid=1&v_uid=").append(ReadInJoyUtils.a()).append("&v_platform=1").toString()), "GET", new ViolaBaseView.19(this, paramBoolean)).a(localBundle);
  }
  
  private void e(boolean paramBoolean)
  {
    ViolaAccessHelper.a(this.jdField_d_of_type_JavaLangString, new ViolaBaseView.20(this, paramBoolean));
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaCreactPageObject != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaCreactPageObject.a());
  }
  
  private void f(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    a(this.jdField_a_of_type_JavaLangString, new ViolaBaseView.21(this, paramBoolean, l1));
  }
  
  private void g()
  {
    if (ViolaSDKEngine.isInitialized())
    {
      this.jdField_c_of_type_Boolean = true;
      b(1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$OnBaseViewListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$OnBaseViewListener.a();
      }
      this.jdField_c_of_type_Boolean = true;
      p();
      return;
    }
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      b(0);
      i();
      return;
    }
    ThreadManager.post(new ViolaBaseView.5(this, (QQAppInterface)ReadInJoyUtils.a()), 8, null, true);
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$OnBaseViewListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$OnBaseViewListener.c();
    }
    a(9, paramBoolean);
  }
  
  private void h()
  {
    this.i = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
    this.jdField_c_of_type_JavaLangString = ViolaAccessHelper.b(this.jdField_a_of_type_JavaLangString);
    if (ViolaAccessHelper.b()) {
      this.jdField_c_of_type_JavaLangString = ViolaAccessHelper.d(this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from v_bid url: " + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_OFFLINE);
      p();
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.i = false;
      if (this.jdField_a_of_type_JavaLangString.contains("v_debug_test=1"))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from cgi debugVersion url: " + this.jdField_a_of_type_JavaLangString);
        }
        b(true);
        return;
      }
      Object localObject = FileUtils.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.jdField_a_of_type_JavaLangString) + "_" + ReadInJoyUtils.a());
      if ((localObject instanceof String))
      {
        this.jdField_c_of_type_JavaLangString = ((String)localObject);
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from cgi cache url: " + this.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_CACHE);
          p();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from cgi no cache url: " + this.jdField_a_of_type_JavaLangString);
        }
        b(true);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from cgi no cache1 url: " + this.jdField_a_of_type_JavaLangString);
      }
      b(true);
      return;
    }
    QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource mOriginalJsUrl is empty!!!");
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
    this.jdField_e_of_type_JavaLangString = ViolaAccessHelper.b("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$MyHandler.sendEmptyMessageDelayed(3, 0L);
      return;
    }
    Object localObject = FileUtils.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ReadInJoyUtils.a());
    if ((localObject instanceof String))
    {
      this.jdField_e_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT_CACHE);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$MyHandler.sendEmptyMessageDelayed(3, 0L);
        return;
      }
      c(true);
      return;
    }
    c(true);
  }
  
  private void j()
  {
    ThreadManager.post(new ViolaBaseView.9(this), 8, null, true);
  }
  
  private void k()
  {
    String str1 = Uri.parse("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559").getQueryParameter("v_bid");
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    String str2 = ViolaBizUtils.b("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559");
    if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip exists [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559]");
      }
      b(str2);
    }
    for (;;)
    {
      ViolaAccessHelper.a(str1, new ViolaBaseView.10(this));
      return;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip not exists [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559],try load from cdn");
      }
      j();
    }
  }
  
  private void l()
  {
    WeakReference localWeakReference2 = null;
    if (this.jdField_c_of_type_Int >= 2) {
      return;
    }
    if ((this.l) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$OnBaseViewListener != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$OnBaseViewListener.a(this.jdField_c_of_type_JavaLangString);
      return;
    }
    ViolaRenderContainer localViolaRenderContainer = new ViolaRenderContainer(getContext());
    addView(localViolaRenderContainer);
    o();
    for (;;)
    {
      try
      {
        ViolaSDKManager.getInstance().setBridgeAdapter(new BridgeAdapter());
        if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance == null)
        {
          BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          if (this.jdField_a_of_type_AndroidSupportV4AppFragment == null) {
            break label215;
          }
          WeakReference localWeakReference1 = new WeakReference(this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity());
          if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null) {
            localWeakReference2 = new WeakReference(this.jdField_a_of_type_AndroidSupportV4AppFragment);
          }
          this.jdField_a_of_type_ComTencentViolaCoreViolaInstance = new ViolaInstance(localBaseApplicationImpl, localWeakReference1, localWeakReference2, null, -1L, this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setRenderContainer(localViolaRenderContainer);
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setViolaPageListener(new ViolaBaseView.12(this));
        m();
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_b_of_type_JavaLangString, 1, "initViola Exception " + localException.getMessage());
      return;
      label215:
      Object localObject = null;
    }
  }
  
  private void m()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaCreactPageObject != null))
    {
      this.jdField_c_of_type_Int = 2;
      s();
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeNativeVueStatusInfo.a()) {
        break label77;
      }
      v();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "renderJS: " + this.jdField_c_of_type_JavaLangString);
      }
      return;
      label77:
      u();
    }
  }
  
  private void n()
  {
    ThreadManager.post(new ViolaBaseView.13(this), 8, null, true);
  }
  
  private void o()
  {
    addOnLayoutChangeListener(new ViolaBaseView.14(this));
  }
  
  private void p()
  {
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_Boolean)) {
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        new Handler(Looper.getMainLooper()).post(new ViolaBaseView.15(this));
        ViolaAccessHelper.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      }
    }
    do
    {
      return;
      l();
      break;
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        b(2);
        return;
      }
    } while (this.jdField_c_of_type_Boolean);
    b(3);
    g();
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaViewListener == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      new Handler(Looper.getMainLooper()).post(new ViolaBaseView.16(this));
    }
    for (;;)
    {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "openViolaPage success!");
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaViewListener.a();
    }
  }
  
  private void r()
  {
    ViolaAccessHelper.jdField_a_of_type_Int += 1;
    this.j = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.mRenderJsStartTime = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.mPageStartTime = this.jdField_b_of_type_Long;
  }
  
  private void t()
  {
    ThreadManager.post(new ViolaBaseView.22(this), 8, null, true);
  }
  
  private void u()
  {
    this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.renderJSSource(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaCreactPageObject.a(), ViolaBizUtils.c(this.jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_AndroidSupportV4AppFragment == null) {
      f();
    }
    q();
    if (!this.jdField_b_of_type_Boolean) {
      a(true);
    }
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityResume();
    }
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(str);
      }
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "start renderNativeVue, url: " + this.jdField_a_of_type_JavaLangString);
    }
    NativeVueLoaderManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaCreactPageObject.a(), this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, new ViolaBaseView.24(this));
  }
  
  public int a()
  {
    if ((c()) && (this.jdField_g_of_type_Boolean)) {
      return this.jdField_b_of_type_Int;
    }
    return 1;
  }
  
  public <T> T a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.getModule(paramString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityBack();
    }
  }
  
  public void a(ViolaBaseView.ViolaViewListener paramViolaViewListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaViewListener = paramViolaViewListener;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    r();
    if (!this.jdField_f_of_type_Boolean)
    {
      c(11);
      return;
    }
    a(jdField_f_of_type_Int);
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) && (ViolaSDKEngine.isInitialized()) && (!this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.isDestroy())) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(paramString);
    }
    while ((this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) && (ViolaSDKEngine.isInitialized())) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
  }
  
  public void a(String paramString, Fragment paramFragment, ViolaBaseView.ViolaCreactPageObject paramViolaCreactPageObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("VideoFeeds.js"))) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800AF0D", "0X800AF0D", 0, 0, null, null, null, "" + System.currentTimeMillis(), false);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
    if ((ViolaSDKManager.getInstance().getReportDelegate() instanceof ViolaReportDelegate)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate = ((ViolaReportDelegate)ViolaSDKManager.getInstance().getReportDelegate());
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaCreactPageObject = paramViolaCreactPageObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokReportRIJTransMergeKanDianReport$ReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder().b("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_f_of_type_Boolean = Build.CPU_ABI.contains("arm");
      r();
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      c(4);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate = new ViolaReportDelegate();
      ViolaSDKManager.getInstance().setReportDelegate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate);
    }
    if (!this.jdField_f_of_type_Boolean)
    {
      c(11);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeNativeVueStatusInfo.a(NativeVueLoaderManager.a(paramString));
    a(jdField_f_of_type_Int);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) && (ViolaSDKEngine.isInitialized()) && (!this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.isDestroy()))
    {
      if (!paramBoolean) {
        break label65;
      }
      if (!this.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(ViolaBizUtils.a().toString());
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setPageVisibility(true);
        this.jdField_e_of_type_Boolean = true;
        c();
      }
    }
    label65:
    do
    {
      return;
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(ViolaBizUtils.b().toString());
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setPageVisibility(false);
        this.jdField_e_of_type_Boolean = false;
        d();
      }
    } while (!(ViolaSDKManager.getInstance().getComponentAdapter() instanceof ComponentAdapter));
    ((ComponentAdapter)ViolaSDKManager.getInstance().getComponentAdapter()).a();
  }
  
  public boolean a()
  {
    return c();
  }
  
  public int b()
  {
    int i1 = 100;
    int n = i1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaCreactPageObject != null)
    {
      n = i1;
      if (ViolaBaseView.ViolaCreactPageObject.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaCreactPageObject) != null)
      {
        n = i1;
        if (!ViolaBaseView.ViolaCreactPageObject.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaCreactPageObject).has("fromType")) {}
      }
    }
    try
    {
      n = ViolaBaseView.ViolaCreactPageObject.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaCreactPageObject).getInt("fromType");
      return n;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 2, "getFromType error  url: " + this.jdField_a_of_type_JavaLangString + " , error msg :" + localException.getMessage());
    }
    return 100;
  }
  
  public void b()
  {
    if (!this.k)
    {
      this.k = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.a();
    }
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Int >= 2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateCurrentPageInstance();
    }
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Int >= 3;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.clearCurrentPageInstance();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) && (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.consumeBackKeyEvent());
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (e())
    {
      RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!jdField_a_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new ViolaBaseView.1(this);
    }
    int n = (int)paramMotionEvent.getX();
    int i1 = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_d_of_type_Int = n;
      this.jdField_e_of_type_Int = i1;
      this.m = false;
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, ViewConfiguration.getLongPressTimeout() * 6);
      continue;
      if ((!this.m) && ((Math.abs(this.jdField_d_of_type_Int - n) > 20) || (Math.abs(this.jdField_e_of_type_Int - i1) > 20)))
      {
        this.m = true;
        removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        continue;
        removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (e())
    {
      RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void e()
  {
    ThreadManager.post(new ViolaBaseView.23(this), 8, null, true);
  }
  
  public void f()
  {
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
  }
  
  public boolean onActivityBack()
  {
    return false;
  }
  
  public void onActivityCreate()
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityCreate();
    }
  }
  
  public void onActivityDestroy()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    if ((!this.j) && (this.jdField_c_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) && (!this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.isReceiveOrder()) && (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.mRenderJsStartTime >= 3000L)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_NOT_RECEIVE_ORDER, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate.a();
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityDestroy();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      c(this.jdField_a_of_type_JavaLangString.replace("v_bid", "_bid"));
      e();
    }
    if (!c()) {
      ReadInJoyLogicEngineEventDispatcher.a().b(ViolaUtils.getPageName(this.jdField_a_of_type_JavaLangString), b());
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaCreactPageObject = null;
  }
  
  public void onActivityPause()
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityPause();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 18)
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity();
      if ((paramInt2 == -1) && (localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        localObject = AIOUtils.a(new Intent((Context)localObject, SplashActivity.class), null);
        if ((paramIntent != null) && ((ReadInJoyUtils.a() instanceof QQAppInterface)))
        {
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          ForwardUtils.a((QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity(), this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity(), (Intent)localObject, null);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onActivityResume()
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityResume();
    }
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance == null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance = new ViolaInstance(BaseApplicationImpl.getApplication(), new WeakReference(this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity()), new WeakReference(this.jdField_a_of_type_AndroidSupportV4AppFragment), null, -1L, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void onActivityStart()
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityStart();
    }
  }
  
  public void onActivityStop()
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityStop();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void setBaseViewListener(ViolaBaseView.OnBaseViewListener paramOnBaseViewListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$OnBaseViewListener = paramOnBaseViewListener;
    this.l = true;
  }
  
  public void setListener(ViolaBaseView.ViolaViewListener paramViolaViewListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$ViolaViewListener = paramViolaViewListener;
  }
  
  public void setPageStartTime(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView
 * JD-Core Version:    0.7.0.1
 */