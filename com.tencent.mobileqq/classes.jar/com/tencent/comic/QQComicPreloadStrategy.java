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
  public final HitRateHelper a;
  private int c = 0;
  private String d = "";
  private boolean e = false;
  
  QQComicPreloadStrategy(int paramInt)
  {
    b.a = "com.tencent.mobileqq:tool";
    b.c = true;
    b.d = "comic_plugin.apk";
    b.e = 2;
    b.h = "comic_plugin.apk";
    b.i = true;
    b.f = paramInt;
    this.a = new HitRateHelper(b.e, b.f);
    if (paramInt == 6)
    {
      this.a.a = new PreloadProcHitPluginSession("comic_leba_preload", b.a, b.d);
      return;
    }
    if (paramInt == 5)
    {
      this.a.a = new PreloadProcHitPluginSession("comic_activity_preload", b.a, b.d);
      return;
    }
    if (paramInt == 9999) {
      this.a.a = new PreloadProcHitPluginSession("comic_web_preload", b.a, b.d);
    }
  }
  
  private String b()
  {
    return this.d;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload start");
    }
    QQComicPluginBridge.a("preload_plugin");
    if (!QIPCServerHelper.getInstance().isModuleRunning(b.h)) {
      VasWebviewUtil.a("qqcomic", "launch_plugin_action", "0", 0, 201);
    }
    Object localObject = new Intent(AppHelper.a(), VipProxyPreLoadComicProcess.class);
    ((Intent)localObject).putExtra("userQqResources", 2);
    ((Intent)localObject).putExtra("useSkinEngine", false);
    ((Intent)localObject).putExtra("params_remote_connect_at_launch", true);
    ((Intent)localObject).putExtra("isPreloadProcess", true);
    ((Intent)localObject).putExtra("preloadEntry", b.f);
    ((Intent)localObject).putExtra("sendTime", SystemClock.elapsedRealtime());
    PreloadSuccessRateReporter.a(AppHelper.b(), 1, 1, 0L);
    QQComicPluginBridge.a((Intent)localObject);
    Map localMap = ((IIndividuationUrlApi)QRoute.api(IIndividuationUrlApi.class)).getUrlMap();
    if ((localMap instanceof Serializable)) {
      ((Intent)localObject).putExtra("urlMap", (Serializable)localMap);
    }
    this.a.a(this.c, b(), b.g);
    localObject = new QRoutePluginReceiverParams.Builder(AppHelper.a()).setIntent((Intent)localObject).setReceiverName("com.qqcomic.app.VipPreloadComicProcess").setSession(this.a.a).build();
    QRoute.plugin("comic_plugin.apk").sendBroadcast((QRoutePluginReceiverParams)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload end");
    }
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
      paramExtraResult.a = 2;
      if (bool) {
        localObject = "preload:ok:dpc";
      } else {
        localObject = "preload:fail:dpc";
      }
      paramExtraResult.b = ((String)localObject);
    }
    paramExtraResult = ((QQPluginPreloadServiceImpl)AppHelper.b().getRuntimeService(IQQPluginPreloadService.class, "")).manager;
    if (paramExtraResult != null)
    {
      paramExtraResult.b();
      if (paramExtraResult.b.get() != null)
      {
        b.b = ((PreloadServerParam)paramExtraResult.b.get()).d;
        this.e = ((PreloadServerParam)paramExtraResult.b.get()).c;
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
    paramExtraResult = ((QQPluginPreloadServiceImpl)AppHelper.b().getRuntimeService(IQQPluginPreloadService.class, "")).manager;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramExtraResult != null)
    {
      int i;
      if ((paramExtraResult.b.get() != null) && (((PreloadServerParam)paramExtraResult.b.get()).b)) {
        i = 1;
      } else {
        i = 0;
      }
      if (b.f == 5)
      {
        if ((i != 0) && (paramExtraResult.d.get() != -1))
        {
          if (paramExtraResult.d.get() == 1) {
            bool1 = true;
          }
          if (bool1)
          {
            localExtraResult.a = 2;
            localExtraResult.b = "preload:ok:publicaccount";
          }
          else
          {
            localExtraResult.a = 2;
            localExtraResult.b = "preload:fail:publicaccount";
          }
        }
        else
        {
          localExtraResult.a = 1;
        }
      }
      else
      {
        for (localExtraResult.b = "preload:ok:publicaccount";; localExtraResult.b = "preload:ok:web")
        {
          bool1 = true;
          break label312;
          if (b.f == 6)
          {
            if ((i != 0) && (paramExtraResult.c.get() != null))
            {
              bool1 = PluginPreloadStrategy.a((PreloadPublicParam)paramExtraResult.c.get(), String.valueOf(1113), paramExtraResult.a, "com.android.animation", paramExtraResult.d(), paramExtraResult.c(), paramExtraResult.e(), localExtraResult);
              break label312;
            }
            localExtraResult.a = 1;
            localExtraResult.b = "preload:fail:normal";
            bool1 = bool3;
            break label312;
          }
          if (b.f != 9999) {
            break;
          }
          localExtraResult.a = 1;
        }
        localExtraResult.a = 1;
        localExtraResult.b = "preload:fail:unknownentry";
        bool1 = bool3;
      }
      label312:
      bool2 = bool1;
      if (paramExtraResult.c.get() != null)
      {
        b.g = ((PreloadPublicParam)paramExtraResult.c.get()).a;
        bool2 = bool1;
      }
    }
    this.c = localExtraResult.a;
    this.d = localExtraResult.b;
    return bool2;
  }
  
  public void c(IQQComicPluginUtil.ExtraResult paramExtraResult)
  {
    if (paramExtraResult == null) {
      return;
    }
    this.c = paramExtraResult.a;
    this.d = paramExtraResult.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.QQComicPreloadStrategy
 * JD-Core Version:    0.7.0.1
 */