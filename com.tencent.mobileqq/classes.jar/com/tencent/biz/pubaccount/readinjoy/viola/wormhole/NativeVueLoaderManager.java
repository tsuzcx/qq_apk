package com.tencent.biz.pubaccount.readinjoy.viola.wormhole;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import bbzm;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.nativevue.NativeVueEngine;
import com.tencent.nativevue.NativeVueEngine.Builder;
import com.tencent.nativevue.NativeVueEngine.DomResult;
import com.tencent.nativevue.NativeVuePreconditionAdapter;
import com.tencent.nativevue.NativeVuePreconditionAdapter.LoadSoResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.utils.ViolaUtils;
import tmd;
import tpf;
import tpg;

public class NativeVueLoaderManager
  implements NativeVuePreconditionAdapter
{
  private static volatile NativeVueLoaderManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeNativeVueLoaderManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static NativeVueLoaderManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeNativeVueLoaderManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeNativeVueLoaderManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeNativeVueLoaderManager = new NativeVueLoaderManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeNativeVueLoaderManager;
    }
    finally {}
  }
  
  private void a(long paramLong, String paramString)
  {
    ViolaUtils.reportNVCost(paramLong);
    IReportDelegate localIReportDelegate = ViolaSDKManager.getInstance().getReportDelegate();
    if (localIReportDelegate != null) {
      localIReportDelegate.reportData(paramString);
    }
  }
  
  public static boolean a(String paramString)
  {
    int i = 1;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      if (Aladdin.getConfig(366).getIntegerFromString("disable_native_vue_render_dom", 0) == 1) {}
      while (i == 0)
      {
        return "1".equals(Uri.parse(paramString).getQueryParameter("supportNV"));
        i = 0;
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      NativeVueEngine.Builder localBuilder = new NativeVueEngine.Builder().env("ViolaEnv", tmd.a()).logAdapter(new tpg(null)).preconditionAdapter(this);
      NativeVueEngine.getInstance().init(localBuilder);
    } while (!QLog.isColorLevel());
    QLog.d("NativeVueLoaderManager", 2, "init NativeVue");
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    int i = 1;
    if (Aladdin.getConfig(365).getIntegerFromString("disable_preload_native_vue", 0) == 1) {
      if (i == 0) {
        break label28;
      }
    }
    label28:
    do
    {
      return;
      i = 0;
      break;
      c();
    } while (!QLog.isColorLevel());
    QLog.d("NativeVueLoaderManager", 2, "preInitNativeVue");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, NativeVueEngine.DomResult paramDomResult)
  {
    c();
    if (paramString1 == null)
    {
      QLog.e("NativeVueLoaderManager", 1, "data is null");
      if (paramDomResult != null) {
        paramDomResult.onResult("");
      }
    }
    paramString2 = ViolaUtils.getVueDomFromJsSource(paramString2, "@nativeDom");
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("NativeVueLoaderManager", 1, "fail to get vueDom from js source");
      if (paramDomResult != null) {
        paramDomResult.onResult("");
      }
    }
    this.jdField_a_of_type_JavaLangString = paramString3;
    NativeVueEngine.getInstance().createVDom(paramString1, paramString2, paramInt, new NativeVueLoaderManager.NVDomResultProxy(this, paramDomResult, paramString3));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, NativeVueEngine.DomResult paramDomResult)
  {
    a(paramString1, paramString2, paramString3, 0, paramDomResult);
  }
  
  public void b()
  {
    int i = 1;
    if (Aladdin.getConfig(336).getIntegerFromString("disable_native_vue_predownload", 0) == 1) {}
    while (i != 0)
    {
      return;
      i = 0;
    }
    ViolaSDKManager.getInstance().getDomManager().post(new NativeVueLoaderManager.1(this));
  }
  
  public void loadNativeVueSo(NativeVuePreconditionAdapter.LoadSoResult paramLoadSoResult)
  {
    bbzm.a().a("nativevue", new tpf(this, paramLoadSoResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.wormhole.NativeVueLoaderManager
 * JD-Core Version:    0.7.0.1
 */