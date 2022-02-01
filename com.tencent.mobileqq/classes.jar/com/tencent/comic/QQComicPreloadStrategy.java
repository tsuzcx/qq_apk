package com.tencent.comic;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.comic.api.IQQComicPluginUtil.ExtraResult;
import com.tencent.comic.api.IQQPluginPreloadService;
import com.tencent.comic.api.impl.QQPluginPreloadServiceImpl;
import com.tencent.comic.api.plugin.HitRateHelper;
import com.tencent.comic.api.plugin.IQQComicPluginPreloadStrategy;
import com.tencent.comic.api.plugin.IQQComicPluginPreloadStrategy.PluginPreloadInfo;
import com.tencent.comic.api.plugin.PreloadPublicParam;
import com.tencent.comic.api.plugin.PreloadServerParam;
import com.tencent.comic.utils.AppHelper;
import com.tencent.comic.utils.PreloadSuccessRateReporter;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.QRoutePluginReceiverParams;
import com.tencent.mobileqq.qroute.module.QRoutePluginReceiverParams.Builder;
import com.tencent.mobileqq.vas.api.IIndividuationUrlApi;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;

public class QQComicPreloadStrategy
  implements IQQComicPluginPreloadStrategy
{
  private int jdField_a_of_type_Int = 0;
  public final HitRateHelper a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  
  QQComicPreloadStrategy(int paramInt)
  {
    jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_b_of_type_Int = 2;
    jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_c_of_type_JavaLangString = "comic_plugin.apk";
    jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_b_of_type_Boolean = true;
    jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentComicApiPluginHitRateHelper = new HitRateHelper(jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_b_of_type_Int, jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_c_of_type_Int);
    if (paramInt == 6)
    {
      this.jdField_a_of_type_ComTencentComicApiPluginHitRateHelper.a = new PreloadProcHitPluginSession("comic_leba_preload", jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_a_of_type_JavaLangString, jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_b_of_type_JavaLangString);
      return;
    }
    if (paramInt == 5)
    {
      this.jdField_a_of_type_ComTencentComicApiPluginHitRateHelper.a = new PreloadProcHitPluginSession("comic_activity_preload", jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_a_of_type_JavaLangString, jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_b_of_type_JavaLangString);
      return;
    }
    if (paramInt == 9999) {
      this.jdField_a_of_type_ComTencentComicApiPluginHitRateHelper.a = new PreloadProcHitPluginSession("comic_web_preload", jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_a_of_type_JavaLangString, jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_b_of_type_JavaLangString);
    }
  }
  
  private String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload start");
    }
    QQComicPluginBridge.a("preload_plugin");
    if (!QIPCServerHelper.getInstance().isModuleRunning(jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_c_of_type_JavaLangString)) {
      VasWebviewUtil.a("qqcomic", "launch_plugin_action", "0", 0, 201);
    }
    Object localObject = new Intent(AppHelper.a(), VipProxyPreLoadComicProcess.class);
    ((Intent)localObject).putExtra("userQqResources", 2);
    ((Intent)localObject).putExtra("useSkinEngine", false);
    ((Intent)localObject).putExtra("params_remote_connect_at_launch", true);
    ((Intent)localObject).putExtra("isPreloadProcess", true);
    ((Intent)localObject).putExtra("preloadEntry", jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_c_of_type_Int);
    ((Intent)localObject).putExtra("sendTime", SystemClock.elapsedRealtime());
    PreloadSuccessRateReporter.a(AppHelper.a(), 1, 1, 0L);
    QQComicPluginBridge.a((Intent)localObject);
    Map localMap = ((IIndividuationUrlApi)QRoute.api(IIndividuationUrlApi.class)).getUrlMap();
    if ((localMap instanceof Serializable)) {
      ((Intent)localObject).putExtra("urlMap", (Serializable)localMap);
    }
    this.jdField_a_of_type_ComTencentComicApiPluginHitRateHelper.a(this.jdField_a_of_type_Int, a(), jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.d);
    localObject = new QRoutePluginReceiverParams.Builder(AppHelper.a()).setIntent((Intent)localObject).setReceiverName("com.qqcomic.app.VipPreloadComicProcess").setSession(this.jdField_a_of_type_ComTencentComicApiPluginHitRateHelper.a).build();
    QRoute.plugin("comic_plugin.apk").sendBroadcast((QRoutePluginReceiverParams)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload end");
    }
  }
  
  public void a(IQQComicPluginUtil.ExtraResult paramExtraResult)
  {
    if (paramExtraResult == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramExtraResult.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramExtraResult.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a(IQQComicPluginUtil.ExtraResult paramExtraResult)
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qr_process_config.name(), "0|24|0|24");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 4)
      {
        bool = "1".equals(localObject[2]);
        break label54;
      }
    }
    boolean bool = false;
    label54:
    if (paramExtraResult != null)
    {
      paramExtraResult.jdField_a_of_type_Int = 2;
      if (bool) {
        localObject = "preload:ok:dpc";
      } else {
        localObject = "preload:fail:dpc";
      }
      paramExtraResult.jdField_a_of_type_JavaLangString = ((String)localObject);
    }
    paramExtraResult = ((QQPluginPreloadServiceImpl)AppHelper.a().getRuntimeService(IQQPluginPreloadService.class, "")).manager;
    if (paramExtraResult != null)
    {
      paramExtraResult.b();
      if (paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null)
      {
        jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_a_of_type_Int = ((PreloadServerParam)paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Int;
        this.jdField_a_of_type_Boolean = ((PreloadServerParam)paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Boolean;
      }
    }
    return bool;
  }
  
  public boolean b(IQQComicPluginUtil.ExtraResult paramExtraResult)
  {
    IQQComicPluginUtil.ExtraResult localExtraResult = paramExtraResult;
    if (paramExtraResult == null) {
      localExtraResult = new IQQComicPluginUtil.ExtraResult();
    }
    paramExtraResult = ((QQPluginPreloadServiceImpl)AppHelper.a().getRuntimeService(IQQPluginPreloadService.class, "")).manager;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramExtraResult != null)
    {
      int i;
      if ((paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null) && (((PreloadServerParam)paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_a_of_type_Boolean)) {
        i = 1;
      } else {
        i = 0;
      }
      if (jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_c_of_type_Int == 5)
      {
        if ((i != 0) && (paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1))
        {
          if (paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
            bool1 = true;
          }
          if (bool1)
          {
            localExtraResult.jdField_a_of_type_Int = 2;
            localExtraResult.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          }
          else
          {
            localExtraResult.jdField_a_of_type_Int = 2;
            localExtraResult.jdField_a_of_type_JavaLangString = "preload:fail:publicaccount";
          }
        }
        else
        {
          localExtraResult.jdField_a_of_type_Int = 1;
        }
      }
      else
      {
        for (localExtraResult.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";; localExtraResult.jdField_a_of_type_JavaLangString = "preload:ok:web")
        {
          bool1 = true;
          break label312;
          if (jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_c_of_type_Int == 6)
          {
            if ((i != 0) && (paramExtraResult.b.get() != null))
            {
              bool1 = PluginPreloadStrategy.a((PreloadPublicParam)paramExtraResult.b.get(), String.valueOf(1113), paramExtraResult.jdField_a_of_type_MqqAppAppRuntime, "com.android.animation", paramExtraResult.a(), paramExtraResult.a(), paramExtraResult.a(), localExtraResult);
              break label312;
            }
            localExtraResult.jdField_a_of_type_Int = 1;
            localExtraResult.jdField_a_of_type_JavaLangString = "preload:fail:normal";
            bool1 = bool3;
            break label312;
          }
          if (jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.jdField_c_of_type_Int != 9999) {
            break;
          }
          localExtraResult.jdField_a_of_type_Int = 1;
        }
        localExtraResult.jdField_a_of_type_Int = 1;
        localExtraResult.jdField_a_of_type_JavaLangString = "preload:fail:unknownentry";
        bool1 = bool3;
      }
      label312:
      bool2 = bool1;
      if (paramExtraResult.b.get() != null)
      {
        jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo.d = ((PreloadPublicParam)paramExtraResult.b.get()).jdField_a_of_type_Int;
        bool2 = bool1;
      }
    }
    this.jdField_a_of_type_Int = localExtraResult.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = localExtraResult.jdField_a_of_type_JavaLangString;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.QQComicPreloadStrategy
 * JD-Core Version:    0.7.0.1
 */