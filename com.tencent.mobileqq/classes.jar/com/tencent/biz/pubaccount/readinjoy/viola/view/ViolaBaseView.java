package com.tencent.biz.pubaccount.readinjoy.viola.view;

import actj;
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
import anqf;
import anqg;
import baxs;
import bbdx;
import bdjd;
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
import onh;
import ono;
import org.json.JSONObject;
import osq;
import osw;
import rvv;
import rvx;
import rwp;
import rwt;
import rwv;
import ryp;
import rzn;
import rzo;
import rzq;
import rzr;
import rzs;
import rzu;
import rzv;
import rzw;
import rzx;
import rzy;
import rzz;
import saa;
import sab;
import sac;

public class ViolaBaseView
  extends RelativeLayout
  implements IActivityState, rvv
{
  private static String jdField_b_of_type_JavaLangString = "ViolaBaseView";
  private static int jdField_d_of_type_Int;
  private static int jdField_e_of_type_Int = 1;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private baxs jdField_a_of_type_Baxs;
  private ViolaInstance jdField_a_of_type_ComTencentViolaCoreViolaInstance;
  public String a;
  private ono jdField_a_of_type_Ono;
  private rwt jdField_a_of_type_Rwt;
  private saa jdField_a_of_type_Saa;
  private sab jdField_a_of_type_Sab;
  private sac jdField_a_of_type_Sac;
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
  private boolean g;
  private boolean h;
  
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
      this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_START);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    osq.a(jdField_b_of_type_JavaLangString + "_" + Integer.toString(paramInt), new rzn(this, paramInt));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((this.g) || (!paramBoolean) || (this.f)) {
      return;
    }
    this.g = true;
    if (this.jdField_a_of_type_Sac != null)
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
      this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_NET);
      this.jdField_a_of_type_Rwt.reportData(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Rwt.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 2, "openViolaPage error,code=" + paramInt + ",biz url=" + this.jdField_a_of_type_JavaLangString);
      return;
      this.jdField_a_of_type_Sac.a(paramInt);
      break;
      label162:
      if (paramInt == 1)
      {
        this.jdField_a_of_type_Rwt.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_Rwt.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Rwt.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SDK, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 5)
      {
        this.jdField_a_of_type_Rwt.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.jdField_a_of_type_Rwt.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Rwt.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 7)
      {
        this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_UNZIP);
        this.jdField_a_of_type_Rwt.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Rwt.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 8)
      {
        this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.jdField_a_of_type_Rwt.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Rwt.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 6)
      {
        this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.jdField_a_of_type_Rwt.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Rwt.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 9)
      {
        this.jdField_a_of_type_Rwt.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_CHANGE_CGI);
        this.jdField_a_of_type_Rwt.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Rwt.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_CHANGE_CGI, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 3)
      {
        this.jdField_a_of_type_Rwt.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.jdField_a_of_type_Rwt.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Rwt.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 2)
      {
        this.jdField_a_of_type_Rwt.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.jdField_a_of_type_Rwt.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Rwt.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 10)
      {
        this.jdField_a_of_type_Rwt.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.jdField_a_of_type_Rwt.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Rwt.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Saa = new saa(this, null);
    this.jdField_a_of_type_Int = Math.abs(new Random().nextInt());
  }
  
  private void a(String paramString, rzz paramrzz)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http"))) {}
    String str;
    do
    {
      return;
      str = Uri.parse(paramString).getQueryParameter("v_bid");
    } while (TextUtils.isEmpty(str));
    rvx.a(str, new rzw(this, str, paramString, paramrzz));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_c_of_type_JavaLangString = paramString;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_NET);
        this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.TIME_BIZ_JS_NET, Long.toString(System.currentTimeMillis() - this.jdField_c_of_type_Long));
        l();
      }
      ThreadManager.post(new ViolaBaseView.18(this), 8, null, true);
      return;
    }
    a(3, paramBoolean);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Sac != null)
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
      this.jdField_a_of_type_Sac.b(paramInt);
    }
  }
  
  private void b(String paramString)
  {
    if (!osw.a(paramString))
    {
      c(7);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip exists unzip fail");
      }
    }
    do
    {
      return;
      if ((anqg.i()) && (anqf.i()))
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
      this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_OFFLINE);
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
    if ((TextUtils.isEmpty(paramString)) || (onh.a() == null)) {
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
      this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_OFFLINE);
    }
    rvx.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + ryp.b(), new rzu(this, paramBoolean, l));
    a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547", new rzv(this, paramBoolean, System.currentTimeMillis()));
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_START);
    }
    Bundle localBundle = new Bundle();
    new bdjd("https://viola.kandian.qq.com/cgi-bin/bundle/exchange?from=android&originUrl=" + URLEncoder.encode(new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&v_sdk=").append("8.3.0").append("&v_appid=1&v_uid=").append(onh.a()).append("&v_platform=1").toString()), "GET", new rzq(this, paramBoolean)).a(localBundle);
  }
  
  private void e(boolean paramBoolean)
  {
    rvx.a(this.jdField_d_of_type_JavaLangString, new rzr(this, paramBoolean));
  }
  
  private boolean e()
  {
    return TextUtils.isEmpty(rvx.a(this.jdField_a_of_type_JavaLangString));
  }
  
  private void f()
  {
    if (ViolaSDKEngine.isInitialized())
    {
      this.jdField_a_of_type_Boolean = true;
      b(1);
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
    ThreadManager.post(new ViolaBaseView.2(this, (QQAppInterface)onh.a()), 8, null, true);
  }
  
  private void f(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    a(this.jdField_a_of_type_JavaLangString, new rzs(this, paramBoolean, l));
  }
  
  private void g()
  {
    this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
    this.jdField_c_of_type_JavaLangString = rvx.a(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from v_bid url: " + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_OFFLINE);
      l();
      return;
    }
    Object localObject = bbdx.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.jdField_a_of_type_JavaLangString) + "_" + onh.a());
    if ((localObject instanceof String))
    {
      this.jdField_c_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource process from cgi cache url: " + this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_CACHE);
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
    a(9, paramBoolean);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
    this.jdField_e_of_type_JavaLangString = rvx.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT);
      this.jdField_a_of_type_Saa.sendEmptyMessageDelayed(3, 0L);
      return;
    }
    Object localObject = bbdx.a("viola_cache_file_viola_qq_page_data_new_main_js_" + onh.a());
    if ((localObject instanceof String))
    {
      this.jdField_e_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Rwt.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT_CACHE);
        this.jdField_a_of_type_Saa.sendEmptyMessageDelayed(3, 0L);
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
    String str2 = ryp.b("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559");
    if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip exists [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559]");
      }
      b(str2);
    }
    for (;;)
    {
      rvx.a(str1, new rzx(this));
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
    ViolaRenderContainer localViolaRenderContainer = new ViolaRenderContainer(getContext());
    addView(localViolaRenderContainer);
    addOnLayoutChangeListener(new rzy(this));
    for (;;)
    {
      try
      {
        ViolaSDKManager.getInstance().setBridgeAdapter(new rwp());
        if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance == null)
        {
          BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          if (this.jdField_a_of_type_AndroidSupportV4AppFragment == null) {
            break label301;
          }
          WeakReference localWeakReference1 = new WeakReference(this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity());
          if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null) {
            localWeakReference2 = new WeakReference(this.jdField_a_of_type_AndroidSupportV4AppFragment);
          }
          this.jdField_a_of_type_ComTencentViolaCoreViolaInstance = new ViolaInstance(localBaseApplicationImpl, localWeakReference1, localWeakReference2, null, -1L, this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setRenderContainer(localViolaRenderContainer);
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setViolaPageListener(new rzo(this));
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Sab == null)) {
          break;
        }
        this.jdField_c_of_type_Int = 2;
        o();
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.renderJSSource(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Sab.a(), ryp.c(this.jdField_a_of_type_JavaLangString));
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
      label301:
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
    if (this.jdField_a_of_type_Sac == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      new Handler(Looper.getMainLooper()).post(new ViolaBaseView.12(this));
    }
    for (;;)
    {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "openViolaPage success!");
      return;
      this.jdField_a_of_type_Sac.a();
    }
  }
  
  private void n()
  {
    rvx.jdField_a_of_type_Int += 1;
    this.g = false;
    this.jdField_a_of_type_Rwt.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
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
  
  public void a(String paramString, Fragment paramFragment, sab paramsab)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
    if ((ViolaSDKManager.getInstance().getReportDelegate() instanceof rwt)) {
      this.jdField_a_of_type_Rwt = ((rwt)ViolaSDKManager.getInstance().getReportDelegate());
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Sab = paramsab;
      this.jdField_a_of_type_Ono = new ono().b("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_d_of_type_Boolean = Build.CPU_ABI.contains("arm");
      n();
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      c(4);
      return;
      this.jdField_a_of_type_Rwt = new rwt();
      ViolaSDKManager.getInstance().setReportDelegate(this.jdField_a_of_type_Rwt);
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      c(11);
      return;
    }
    a(jdField_d_of_type_Int);
  }
  
  public void a(sac paramsac)
  {
    this.jdField_a_of_type_Sac = paramsac;
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
        break label57;
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(ryp.a().toString());
        this.jdField_c_of_type_Boolean = true;
        c();
      }
    }
    label57:
    do
    {
      return;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(ryp.b().toString());
        this.jdField_c_of_type_Boolean = false;
        d();
      }
    } while (!(ViolaSDKManager.getInstance().getComponentAdapter() instanceof rwv));
    ((rwv)ViolaSDKManager.getInstance().getComponentAdapter()).a();
  }
  
  public boolean a()
  {
    return c();
  }
  
  public void b()
  {
    if (!this.h)
    {
      this.h = true;
      this.jdField_a_of_type_Rwt.a();
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
    if ((!this.g) && (this.jdField_c_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) && (!this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.isReceiveOrder()) && (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.mRenderJsStartTime >= 3000L)) {
      this.jdField_a_of_type_Rwt.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_NOT_RECEIVE_ORDER, this.jdField_a_of_type_JavaLangString);
    }
    a(ryp.c().toString());
    this.jdField_a_of_type_Rwt.a();
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
        localObject = actj.a(new Intent((Context)localObject, SplashActivity.class), null);
        if ((paramIntent != null) && ((onh.a() instanceof QQAppInterface)))
        {
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          ForwardUtils.a((QQAppInterface)onh.a(), this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity(), this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity(), (Intent)localObject, null);
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
  
  public void setListener(sac paramsac)
  {
    this.jdField_a_of_type_Sac = paramsac;
  }
  
  public void setPageStartTime(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView
 * JD-Core Version:    0.7.0.1
 */