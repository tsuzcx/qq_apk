package com.tencent.biz.pubaccount.readinjoy.viola.view;

import agej;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import aseg;
import aseh;
import bhgv;
import bhmi;
import bjus;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.NativeVueLoaderManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
import ocd;
import org.json.JSONObject;
import ozs;
import paa;
import pfd;
import pfl;
import pfr;
import tbx;
import tbz;
import tcz;
import tdd;
import tdf;
import thy;
import tja;
import tjb;
import tjd;
import tje;
import tjf;
import tjh;
import tji;
import tjj;
import tjk;
import tjl;
import tjm;
import tjn;
import tjo;
import tjp;
import tjq;
import tjr;
import tjx;

public class ViolaBaseView
  extends RelativeLayout
  implements IActivityState, tbx
{
  private static String jdField_b_of_type_JavaLangString = "ViolaBaseView";
  private static int jdField_d_of_type_Int;
  private static int jdField_e_of_type_Int = 1;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private bhgv jdField_a_of_type_Bhgv;
  private ViolaInstance jdField_a_of_type_ComTencentViolaCoreViolaInstance;
  public String a;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private paa jdField_a_of_type_Paa;
  private tdd jdField_a_of_type_Tdd;
  private tjo jdField_a_of_type_Tjo;
  private tjp jdField_a_of_type_Tjp;
  private tjq jdField_a_of_type_Tjq;
  private tjr jdField_a_of_type_Tjr;
  private tjx jdField_a_of_type_Tjx = new tjx();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g = true;
  private boolean h;
  private boolean i;
  private boolean j;
  
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
  
  private void a(int paramInt)
  {
    if (paramInt == jdField_d_of_type_Int)
    {
      this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_START);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    NativeVueLoaderManager.a().a();
    pfl.a(jdField_b_of_type_JavaLangString + "_" + paramInt, new tja(this, paramInt));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((this.h) || (!paramBoolean) || (this.f)) {
      return;
    }
    this.h = true;
    if (this.jdField_a_of_type_Tjr != null)
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        new Handler(Looper.getMainLooper()).post(new ViolaBaseView.14(this, paramInt));
      }
    }
    else
    {
      if (paramInt != 100) {
        break label162;
      }
      this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_NET);
      this.jdField_a_of_type_Tdd.reportData(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Tdd.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 2, "openViolaPage error,code=" + paramInt + ",biz url=" + this.jdField_a_of_type_JavaLangString);
      return;
      this.jdField_a_of_type_Tjr.a(paramInt);
      break;
      label162:
      if (paramInt == 1)
      {
        this.jdField_a_of_type_Tdd.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_Tdd.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Tdd.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SDK, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 5)
      {
        this.jdField_a_of_type_Tdd.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.jdField_a_of_type_Tdd.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Tdd.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 7)
      {
        this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_UNZIP);
        this.jdField_a_of_type_Tdd.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Tdd.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 8)
      {
        this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.jdField_a_of_type_Tdd.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Tdd.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 6)
      {
        this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.jdField_a_of_type_Tdd.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Tdd.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 9)
      {
        this.jdField_a_of_type_Tdd.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_CHANGE_CGI);
        this.jdField_a_of_type_Tdd.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Tdd.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_CHANGE_CGI, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 3)
      {
        this.jdField_a_of_type_Tdd.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.jdField_a_of_type_Tdd.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Tdd.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 2)
      {
        this.jdField_a_of_type_Tdd.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.jdField_a_of_type_Tdd.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Tdd.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 10)
      {
        this.jdField_a_of_type_Tdd.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.jdField_a_of_type_Tdd.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Tdd.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Tjo = new tjo(this, Looper.getMainLooper());
    this.jdField_a_of_type_Int = Math.abs(new Random().nextInt());
  }
  
  private void a(String paramString, tjn paramtjn)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http"))) {}
    String str;
    do
    {
      return;
      str = Uri.parse(paramString).getQueryParameter("v_bid");
    } while (TextUtils.isEmpty(str));
    tbz.a(str, new tjk(this, str, paramString, paramtjn));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_c_of_type_JavaLangString = paramString;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_NET);
        this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.TIME_BIZ_JS_NET, Long.toString(System.currentTimeMillis() - this.jdField_c_of_type_Long));
        l();
      }
      ThreadManager.post(new ViolaBaseView.18(this), 8, null, true);
      return;
    }
    a(3, paramBoolean);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Tjr != null)
    {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        break label67;
      }
      new Handler(Looper.getMainLooper()).post(new ViolaBaseView.13(this, paramInt));
    }
    for (;;)
    {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "openViolaPage process,code=" + paramInt);
      return;
      label67:
      this.jdField_a_of_type_Tjr.b(paramInt);
    }
  }
  
  private void b(String paramString)
  {
    if (!pfr.a(paramString))
    {
      c(7);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip exists unzip fail");
      }
    }
    do
    {
      return;
      if ((aseh.i()) && (aseg.i()))
      {
        a(jdField_e_of_type_Int);
        return;
      }
      c(8);
    } while (!QLog.isColorLevel());
    QLog.e(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip succ but not Exist");
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (paramBoolean) {
      this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_OFFLINE);
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
    if ((TextUtils.isEmpty(paramString)) || (ozs.a() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "checkOfflineUpNotCallback.");
    }
    ThreadManager.post(new ViolaBaseView.8(this, paramString), 8, null, true);
  }
  
  private void c(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (paramBoolean) {
      this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_OFFLINE);
    }
    tbz.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + thy.b(), new tji(this, paramBoolean, l));
    a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547", new tjj(this, paramBoolean, System.currentTimeMillis()));
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance == null) {}
    while (this.f) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.renderVueDomDirectly(paramString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "render VueDom");
      }
    }
    p();
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_START);
    }
    Bundle localBundle = new Bundle();
    new bjus("https://viola.kandian.qq.com/cgi-bin/bundle/exchange?from=android&originUrl=" + URLEncoder.encode(new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&v_sdk=").append("8.4.5").append("&v_appid=1&v_uid=").append(ozs.a()).append("&v_platform=1").toString()), "GET", new tjd(this, paramBoolean)).a(localBundle);
  }
  
  private void e(boolean paramBoolean)
  {
    tbz.a(this.jdField_d_of_type_JavaLangString, new tje(this, paramBoolean));
  }
  
  private void f()
  {
    if (ViolaSDKEngine.isInitialized())
    {
      this.jdField_a_of_type_Boolean = true;
      b(1);
      if (this.jdField_a_of_type_Tjp != null) {
        this.jdField_a_of_type_Tjp.a();
      }
      this.jdField_a_of_type_Boolean = true;
      l();
      return;
    }
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      b(0);
      h();
      return;
    }
    ThreadManager.post(new ViolaBaseView.2(this, (QQAppInterface)ozs.a()), 8, null, true);
  }
  
  private void f(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    a(this.jdField_a_of_type_JavaLangString, new tjf(this, paramBoolean, l));
  }
  
  private void g()
  {
    this.g = true;
    this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
    this.jdField_c_of_type_JavaLangString = tbz.a(this.jdField_a_of_type_JavaLangString);
    if (tbz.b()) {
      this.jdField_c_of_type_JavaLangString = tbz.c(this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from v_bid url: " + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_OFFLINE);
      l();
      return;
    }
    this.g = false;
    if (this.jdField_a_of_type_JavaLangString.contains("v_debug_test=1"))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from cgi debugVersion url: " + this.jdField_a_of_type_JavaLangString);
      }
      b(true);
      return;
    }
    Object localObject = bhmi.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.jdField_a_of_type_JavaLangString) + "_" + ozs.a());
    if ((localObject instanceof String))
    {
      this.jdField_c_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from cgi cache url: " + this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_CACHE);
        l();
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
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tjp != null) {
      this.jdField_a_of_type_Tjp.c();
    }
    a(9, paramBoolean);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
    this.jdField_e_of_type_JavaLangString = tbz.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT);
      this.jdField_a_of_type_Tjo.sendEmptyMessageDelayed(3, 0L);
      return;
    }
    Object localObject = bhmi.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ozs.a());
    if ((localObject instanceof String))
    {
      this.jdField_e_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Tdd.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT_CACHE);
        this.jdField_a_of_type_Tjo.sendEmptyMessageDelayed(3, 0L);
        return;
      }
      c(true);
      return;
    }
    c(true);
  }
  
  private void i()
  {
    ThreadManager.post(new ViolaBaseView.6(this), 8, null, true);
  }
  
  private void j()
  {
    String str1 = Uri.parse("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559").getQueryParameter("v_bid");
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    String str2 = thy.b("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559");
    if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip exists [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559]");
      }
      b(str2);
    }
    for (;;)
    {
      tbz.a(str1, new tjl(this));
      return;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip not exists [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559],try load from cdn");
      }
      i();
    }
  }
  
  private void k()
  {
    WeakReference localWeakReference2 = null;
    if (this.jdField_c_of_type_Int >= 2) {
      return;
    }
    if ((this.j) && (this.jdField_a_of_type_Tjp != null))
    {
      this.jdField_a_of_type_Tjp.a(this.jdField_c_of_type_JavaLangString);
      return;
    }
    ViolaRenderContainer localViolaRenderContainer = new ViolaRenderContainer(getContext());
    addView(localViolaRenderContainer);
    addOnLayoutChangeListener(new tjm(this));
    for (;;)
    {
      try
      {
        ViolaSDKManager.getInstance().setBridgeAdapter(new tcz());
        if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance == null)
        {
          BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          if (this.jdField_a_of_type_AndroidSupportV4AppFragment == null) {
            break label295;
          }
          WeakReference localWeakReference1 = new WeakReference(this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity());
          if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null) {
            localWeakReference2 = new WeakReference(this.jdField_a_of_type_AndroidSupportV4AppFragment);
          }
          this.jdField_a_of_type_ComTencentViolaCoreViolaInstance = new ViolaInstance(localBaseApplicationImpl, localWeakReference1, localWeakReference2, null, -1L, this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setRenderContainer(localViolaRenderContainer);
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setViolaPageListener(new tjb(this));
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Tjq == null)) {
          break;
        }
        this.jdField_c_of_type_Int = 2;
        o();
        if (!this.jdField_a_of_type_Tjx.a()) {
          break label300;
        }
        q();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_b_of_type_JavaLangString, 2, "renderJS: " + this.jdField_c_of_type_JavaLangString);
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_b_of_type_JavaLangString, 1, "initViola Exception " + localException.getMessage());
      return;
      label295:
      Object localObject = null;
      continue;
      label300:
      p();
    }
  }
  
  private void l()
  {
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Boolean)) {
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        new Handler(Looper.getMainLooper()).post(new ViolaBaseView.11(this));
        tbz.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      }
    }
    do
    {
      return;
      k();
      break;
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        b(2);
        return;
      }
    } while (this.jdField_a_of_type_Boolean);
    b(3);
    f();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Tjr == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      new Handler(Looper.getMainLooper()).post(new ViolaBaseView.12(this));
    }
    for (;;)
    {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "openViolaPage success!");
      return;
      this.jdField_a_of_type_Tjr.a();
    }
  }
  
  private void n()
  {
    tbz.jdField_a_of_type_Int += 1;
    this.h = false;
    this.jdField_a_of_type_Tdd.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.mRenderJsStartTime = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.mPageStartTime = this.jdField_b_of_type_Long;
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.renderJSSource(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Tjq.a(), thy.c(this.jdField_a_of_type_JavaLangString));
    m();
    a(true);
    if (this.jdField_b_of_type_Boolean) {
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
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "start renderNativeVue, url: " + this.jdField_a_of_type_JavaLangString);
    }
    NativeVueLoaderManager.a().a(this.jdField_a_of_type_Tjq.a(), this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, new tjh(this));
  }
  
  public int a()
  {
    if ((c()) && (this.jdField_e_of_type_Boolean)) {
      return this.jdField_b_of_type_Int;
    }
    return 1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityBack();
    }
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
  
  public void a(String paramString, Fragment paramFragment, tjq paramtjq)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("VideoFeeds.js"))) {
      ocd.a(null, null, "0X800AF0D", "0X800AF0D", 0, 0, null, null, null, "" + System.currentTimeMillis(), false);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
    if ((ViolaSDKManager.getInstance().getReportDelegate() instanceof tdd)) {
      this.jdField_a_of_type_Tdd = ((tdd)ViolaSDKManager.getInstance().getReportDelegate());
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Tjq = paramtjq;
      this.jdField_a_of_type_Paa = new paa().b("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_d_of_type_Boolean = Build.CPU_ABI.contains("arm");
      n();
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      c(4);
      return;
      this.jdField_a_of_type_Tdd = new tdd();
      ViolaSDKManager.getInstance().setReportDelegate(this.jdField_a_of_type_Tdd);
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      c(11);
      return;
    }
    this.jdField_a_of_type_Tjx.a(NativeVueLoaderManager.a(paramString));
    a(jdField_d_of_type_Int);
  }
  
  public void a(tjr paramtjr)
  {
    this.jdField_a_of_type_Tjr = paramtjr;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    n();
    if (!this.jdField_d_of_type_Boolean)
    {
      c(11);
      return;
    }
    a(jdField_d_of_type_Int);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) && (ViolaSDKEngine.isInitialized()) && (!this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.isDestroy()))
    {
      if (!paramBoolean) {
        break label65;
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(thy.a().toString());
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setPageVisibility(true);
        this.jdField_c_of_type_Boolean = true;
        c();
      }
    }
    label65:
    do
    {
      return;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(thy.b().toString());
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setPageVisibility(false);
        this.jdField_c_of_type_Boolean = false;
        d();
      }
    } while (!(ViolaSDKManager.getInstance().getComponentAdapter() instanceof tdf));
    ((tdf)ViolaSDKManager.getInstance().getComponentAdapter()).a();
  }
  
  public boolean a()
  {
    return c();
  }
  
  public int b()
  {
    int m = 100;
    int k = m;
    if (this.jdField_a_of_type_Tjq != null)
    {
      k = m;
      if (tjq.a(this.jdField_a_of_type_Tjq) != null)
      {
        k = m;
        if (!tjq.a(this.jdField_a_of_type_Tjq).has("fromType")) {}
      }
    }
    try
    {
      k = tjq.a(this.jdField_a_of_type_Tjq).getInt("fromType");
      return k;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 2, "getFromType error  url: " + this.jdField_a_of_type_JavaLangString + " , error msg :" + localException.getMessage());
    }
    return 100;
  }
  
  public void b()
  {
    if (!this.i)
    {
      this.i = true;
      this.jdField_a_of_type_Tdd.a();
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
  
  public void e()
  {
    ThreadManager.post(new ViolaBaseView.19(this), 8, null, true);
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
    this.f = true;
    if ((!this.h) && (this.jdField_c_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) && (!this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.isReceiveOrder()) && (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.mRenderJsStartTime >= 3000L)) {
      this.jdField_a_of_type_Tdd.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_NOT_RECEIVE_ORDER, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Tdd.a();
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityDestroy();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      c(this.jdField_a_of_type_JavaLangString.replace("v_bid", "_bid"));
      e();
    }
    if (!c()) {
      pfd.a().b(ViolaUtils.getPageName(this.jdField_a_of_type_JavaLangString), b());
    }
  }
  
  public void onActivityPause()
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityPause();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 18)
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity();
      if ((paramInt2 == -1) && (localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        localObject = agej.a(new Intent((Context)localObject, SplashActivity.class), null);
        if ((paramIntent != null) && ((ozs.a() instanceof QQAppInterface)))
        {
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          ForwardUtils.a((QQAppInterface)ozs.a(), this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity(), this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity(), (Intent)localObject, null);
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
    this.jdField_b_of_type_Boolean = true;
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
  }
  
  public void setBaseViewListener(tjp paramtjp)
  {
    this.jdField_a_of_type_Tjp = paramtjp;
    this.j = true;
  }
  
  public void setListener(tjr paramtjr)
  {
    this.jdField_a_of_type_Tjr = paramtjr;
  }
  
  public void setPageStartTime(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView
 * JD-Core Version:    0.7.0.1
 */