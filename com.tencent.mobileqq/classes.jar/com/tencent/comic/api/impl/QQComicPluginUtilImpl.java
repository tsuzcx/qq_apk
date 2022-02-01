package com.tencent.comic.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.comic.PluginPreloadReportUtils;
import com.tencent.comic.PluginPreloadStrategy;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.IQQComicPluginUtil.ExtraResult;
import com.tencent.comic.api.plugin.PreloadPublicParam;
import com.tencent.comic.jsp.QQComicDownloadObserverProxy;
import com.tencent.comic.jsp.QQComicJsPluginBuilder;
import com.tencent.comic.utils.AppHelper;
import com.tencent.comic.utils.PreloadSuccessRateReporter;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.comic.utils.RuntimeCreateObservable;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import java.util.Observer;
import mqq.app.AppRuntime;

public class QQComicPluginUtilImpl
  implements IQQComicPluginUtil
{
  public boolean launchPlugin(Activity paramActivity, Intent paramIntent, String paramString, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    return QQComicPluginBridge.a(paramActivity, paramIntent, paramString, paramPreloadProcHitPluginSession);
  }
  
  public void loadComicModule(Context paramContext)
  {
    QQComicPluginBridge.a(paramContext);
  }
  
  public void notifyChangedWhenRuntimeCreated()
  {
    if (QQComicPluginBridge.jdField_a_of_type_ComTencentComicUtilsRuntimeCreateObservable != null) {
      QQComicPluginBridge.jdField_a_of_type_ComTencentComicUtilsRuntimeCreateObservable.a();
    }
  }
  
  public boolean preloadPubilcProcess(PreloadPublicParam paramPreloadPublicParam, String paramString1, AppRuntime paramAppRuntime, String paramString2, int paramInt, long paramLong, int[] paramArrayOfInt, IQQComicPluginUtil.ExtraResult paramExtraResult)
  {
    return PluginPreloadStrategy.a(paramPreloadPublicParam, paramString1, paramAppRuntime, paramString2, paramInt, paramLong, paramArrayOfInt, paramExtraResult);
  }
  
  public void reportHitRate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    PluginPreloadReportUtils.a(AppHelper.a(), paramInt1, paramInt2, paramInt3, paramInt4, paramString1, new String[] { paramString2 });
  }
  
  public void reportPreload(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, long paramLong)
  {
    PreloadSuccessRateReporter.a(paramAppRuntime, paramInt1, paramInt2, paramLong);
  }
  
  public void reportProcBeKiiled(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    PluginPreloadReportUtils.a(paramAppRuntime, paramInt1, paramInt2, paramInt3, paramLong, new String[0]);
  }
  
  public void setDownloadObserver(QQComicDownloadObserverProxy paramQQComicDownloadObserverProxy)
  {
    QQComicPluginBridge.jdField_a_of_type_ComTencentComicJspQQComicDownloadObserverProxy = paramQQComicDownloadObserverProxy;
  }
  
  public void setFirstInObserver(Observer paramObserver)
  {
    QQComicPluginBridge.a(paramObserver);
  }
  
  public void setJsPluginBuilder(QQComicJsPluginBuilder paramQQComicJsPluginBuilder)
  {
    QQComicPluginBridge.jdField_a_of_type_ComTencentComicJspQQComicJsPluginBuilder = paramQQComicJsPluginBuilder;
  }
  
  public void setPluginReady(boolean paramBoolean)
  {
    QQComicPluginBridge.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicPluginUtilImpl
 * JD-Core Version:    0.7.0.1
 */