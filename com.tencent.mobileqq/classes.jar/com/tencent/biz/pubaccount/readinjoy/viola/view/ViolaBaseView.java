package com.tencent.biz.pubaccount.readinjoy.viola.view;

import aekt;
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
import aphn;
import apho;
import bcwm;
import bdcs;
import bfib;
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
import java.util.Random;
import org.json.JSONObject;
import ors;
import orz;
import oxi;
import oxo;
import smi;
import smk;
import snc;
import sng;
import sni;
import spw;
import squ;
import sqv;
import sqx;
import sqy;
import sqz;
import srb;
import src;
import srd;
import sre;
import srf;
import srg;
import srh;
import sri;
import srj;
import srk;

public class ViolaBaseView
  extends RelativeLayout
  implements IActivityState, smi
{
  private static String jdField_b_of_type_JavaLangString = "ViolaBaseView";
  private static int jdField_d_of_type_Int;
  private static int jdField_e_of_type_Int = 1;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private bcwm jdField_a_of_type_Bcwm;
  private ViolaInstance jdField_a_of_type_ComTencentViolaCoreViolaInstance;
  public String a;
  private orz jdField_a_of_type_Orz;
  private sng jdField_a_of_type_Sng;
  private srh jdField_a_of_type_Srh;
  private sri jdField_a_of_type_Sri;
  private srj jdField_a_of_type_Srj;
  private srk jdField_a_of_type_Srk;
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
      this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_START);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    oxi.a(jdField_b_of_type_JavaLangString + "_" + Integer.toString(paramInt), new squ(this, paramInt));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((this.h) || (!paramBoolean) || (this.f)) {
      return;
    }
    this.h = true;
    if (this.jdField_a_of_type_Srk != null)
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
      this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_NET);
      this.jdField_a_of_type_Sng.reportData(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Sng.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 2, "openViolaPage error,code=" + paramInt + ",biz url=" + this.jdField_a_of_type_JavaLangString);
      return;
      this.jdField_a_of_type_Srk.a(paramInt);
      break;
      label162:
      if (paramInt == 1)
      {
        this.jdField_a_of_type_Sng.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_Sng.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Sng.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SDK, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 5)
      {
        this.jdField_a_of_type_Sng.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.jdField_a_of_type_Sng.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Sng.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 7)
      {
        this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_UNZIP);
        this.jdField_a_of_type_Sng.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Sng.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 8)
      {
        this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.jdField_a_of_type_Sng.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Sng.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 6)
      {
        this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.jdField_a_of_type_Sng.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Sng.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 9)
      {
        this.jdField_a_of_type_Sng.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_CHANGE_CGI);
        this.jdField_a_of_type_Sng.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Sng.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_CHANGE_CGI, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 3)
      {
        this.jdField_a_of_type_Sng.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.jdField_a_of_type_Sng.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Sng.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 2)
      {
        this.jdField_a_of_type_Sng.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.jdField_a_of_type_Sng.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Sng.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 10)
      {
        this.jdField_a_of_type_Sng.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.jdField_a_of_type_Sng.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Sng.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Srh = new srh(this, Looper.getMainLooper());
    this.jdField_a_of_type_Int = Math.abs(new Random().nextInt());
  }
  
  private void a(String paramString, srg paramsrg)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http"))) {}
    String str;
    do
    {
      return;
      str = Uri.parse(paramString).getQueryParameter("v_bid");
    } while (TextUtils.isEmpty(str));
    smk.a(str, new srd(this, str, paramString, paramsrg));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_c_of_type_JavaLangString = paramString;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_NET);
        this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.TIME_BIZ_JS_NET, Long.toString(System.currentTimeMillis() - this.jdField_c_of_type_Long));
        l();
      }
      ThreadManager.post(new ViolaBaseView.18(this), 8, null, true);
      return;
    }
    a(3, paramBoolean);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Srk != null)
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
      this.jdField_a_of_type_Srk.b(paramInt);
    }
  }
  
  private void b(String paramString)
  {
    if (!oxo.a(paramString))
    {
      c(7);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip exists unzip fail");
      }
    }
    do
    {
      return;
      if ((apho.i()) && (aphn.i()))
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
      this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_OFFLINE);
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
    if ((TextUtils.isEmpty(paramString)) || (ors.a() == null)) {
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
      this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_OFFLINE);
    }
    smk.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + spw.b(), new srb(this, paramBoolean, l));
    a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547", new src(this, paramBoolean, System.currentTimeMillis()));
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_START);
    }
    Bundle localBundle = new Bundle();
    new bfib("https://viola.kandian.qq.com/cgi-bin/bundle/exchange?from=android&originUrl=" + URLEncoder.encode(new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&v_sdk=").append("8.3.3").append("&v_appid=1&v_uid=").append(ors.a()).append("&v_platform=1").toString()), "GET", new sqx(this, paramBoolean)).a(localBundle);
  }
  
  private void e(boolean paramBoolean)
  {
    smk.a(this.jdField_d_of_type_JavaLangString, new sqy(this, paramBoolean));
  }
  
  private void f()
  {
    if (ViolaSDKEngine.isInitialized())
    {
      this.jdField_a_of_type_Boolean = true;
      b(1);
      if (this.jdField_a_of_type_Sri != null) {
        this.jdField_a_of_type_Sri.a();
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
    ThreadManager.post(new ViolaBaseView.2(this, (QQAppInterface)ors.a()), 8, null, true);
  }
  
  private void f(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    a(this.jdField_a_of_type_JavaLangString, new sqz(this, paramBoolean, l));
  }
  
  private void g()
  {
    this.g = true;
    this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
    this.jdField_c_of_type_JavaLangString = smk.a(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from v_bid url: " + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_OFFLINE);
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
    Object localObject = bdcs.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.jdField_a_of_type_JavaLangString) + "_" + ors.a());
    if ((localObject instanceof String))
    {
      this.jdField_c_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from cgi cache url: " + this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_CACHE);
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
    if (this.jdField_a_of_type_Sri != null) {
      this.jdField_a_of_type_Sri.c();
    }
    a(9, paramBoolean);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
    this.jdField_e_of_type_JavaLangString = smk.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT);
      this.jdField_a_of_type_Srh.sendEmptyMessageDelayed(3, 0L);
      return;
    }
    Object localObject = bdcs.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ors.a());
    if ((localObject instanceof String))
    {
      this.jdField_e_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Sng.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT_CACHE);
        this.jdField_a_of_type_Srh.sendEmptyMessageDelayed(3, 0L);
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
    String str2 = spw.b("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559");
    if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip exists [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559]");
      }
      b(str2);
    }
    for (;;)
    {
      smk.a(str1, new sre(this));
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
    if ((this.j) && (this.jdField_a_of_type_Sri != null))
    {
      this.jdField_a_of_type_Sri.a(this.jdField_c_of_type_JavaLangString);
      return;
    }
    ViolaRenderContainer localViolaRenderContainer = new ViolaRenderContainer(getContext());
    addView(localViolaRenderContainer);
    addOnLayoutChangeListener(new srf(this));
    for (;;)
    {
      try
      {
        ViolaSDKManager.getInstance().setBridgeAdapter(new snc());
        if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance == null)
        {
          BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          if (this.jdField_a_of_type_AndroidSupportV4AppFragment == null) {
            break label329;
          }
          WeakReference localWeakReference1 = new WeakReference(this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity());
          if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null) {
            localWeakReference2 = new WeakReference(this.jdField_a_of_type_AndroidSupportV4AppFragment);
          }
          this.jdField_a_of_type_ComTencentViolaCoreViolaInstance = new ViolaInstance(localBaseApplicationImpl, localWeakReference1, localWeakReference2, null, -1L, this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setRenderContainer(localViolaRenderContainer);
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setViolaPageListener(new sqv(this));
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Srj == null)) {
          break;
        }
        this.jdField_c_of_type_Int = 2;
        o();
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.renderJSSource(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Srj.a(), spw.c(this.jdField_a_of_type_JavaLangString));
        m();
        a(true);
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityResume();
        }
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
      label329:
      Object localObject = null;
    }
  }
  
  private void l()
  {
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Boolean)) {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        new Handler(Looper.getMainLooper()).post(new ViolaBaseView.11(this));
      }
    }
    do
    {
      return;
      k();
      return;
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
    if (this.jdField_a_of_type_Srk == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      new Handler(Looper.getMainLooper()).post(new ViolaBaseView.12(this));
    }
    for (;;)
    {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "openViolaPage success!");
      return;
      this.jdField_a_of_type_Srk.a();
    }
  }
  
  private void n()
  {
    smk.jdField_a_of_type_Int += 1;
    this.h = false;
    this.jdField_a_of_type_Sng.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.mRenderJsStartTime = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.mPageStartTime = this.jdField_b_of_type_Long;
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
  }
  
  public void a(String paramString, Fragment paramFragment, srj paramsrj)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
    if ((ViolaSDKManager.getInstance().getReportDelegate() instanceof sng)) {
      this.jdField_a_of_type_Sng = ((sng)ViolaSDKManager.getInstance().getReportDelegate());
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Srj = paramsrj;
      this.jdField_a_of_type_Orz = new orz().b("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_d_of_type_Boolean = Build.CPU_ABI.contains("arm");
      n();
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      c(4);
      return;
      this.jdField_a_of_type_Sng = new sng();
      ViolaSDKManager.getInstance().setReportDelegate(this.jdField_a_of_type_Sng);
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      c(11);
      return;
    }
    a(jdField_d_of_type_Int);
  }
  
  public void a(srk paramsrk)
  {
    this.jdField_a_of_type_Srk = paramsrk;
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
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(spw.a().toString());
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
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(spw.b().toString());
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setPageVisibility(false);
        this.jdField_c_of_type_Boolean = false;
        d();
      }
    } while (!(ViolaSDKManager.getInstance().getComponentAdapter() instanceof sni));
    ((sni)ViolaSDKManager.getInstance().getComponentAdapter()).a();
  }
  
  public boolean a()
  {
    return c();
  }
  
  public void b()
  {
    if (!this.i)
    {
      this.i = true;
      this.jdField_a_of_type_Sng.a();
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
      this.jdField_a_of_type_Sng.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_NOT_RECEIVE_ORDER, this.jdField_a_of_type_JavaLangString);
    }
    a(spw.c().toString());
    this.jdField_a_of_type_Sng.a();
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityDestroy();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      c(this.jdField_a_of_type_JavaLangString.replace("v_bid", "_bid"));
      e();
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
        localObject = aekt.a(new Intent((Context)localObject, SplashActivity.class), null);
        if ((paramIntent != null) && ((ors.a() instanceof QQAppInterface)))
        {
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          ForwardUtils.a((QQAppInterface)ors.a(), this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity(), this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity(), (Intent)localObject, null);
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
  
  public void setBaseViewListener(sri paramsri)
  {
    this.jdField_a_of_type_Sri = paramsri;
    this.j = true;
  }
  
  public void setListener(srk paramsrk)
  {
    this.jdField_a_of_type_Srk = paramsrk;
  }
  
  public void setPageStartTime(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView
 * JD-Core Version:    0.7.0.1
 */