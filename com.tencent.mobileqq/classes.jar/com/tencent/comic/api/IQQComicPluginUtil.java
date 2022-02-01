package com.tencent.comic.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.comic.api.plugin.PreloadPublicParam;
import com.tencent.comic.jsp.QQComicDownloadObserverProxy;
import com.tencent.comic.jsp.QQComicJsPluginBuilder;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Observer;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQQComicPluginUtil
  extends QRouteApi
{
  public static final String ACTION_PLUGIN_STARTUP_FAILED = "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED";
  public static final int BUZID_COMIC = 1;
  public static final String COMIC_PLUGIN_ID = "comic_plugin.apk";
  public static final int OP_RECEIVE = 2;
  public static final int OP_SEND = 1;
  public static final String PLUGIN_LAUNCH_ACTION = "launch_plugin_action";
  public static final int PLUGIN_LAUNCH_DONE = 202;
  public static final int PLUGIN_LAUNCH_START = 201;
  public static final int PLUGIN_TYPE_QQCOMIC = 2;
  public static final int PLUGIN_TYPE_QQREADER = 1;
  public static final String PPP_EXT1 = "ext1";
  public static final String PPP_MEM_LIMIT = "mem_limit";
  public static final String PPP_PRELOAD = "preload";
  public static final String PPP_PRELOAD_DATA = "preload_data";
  public static final String PPP_PRELOAD_SWITCH = "preload_switch";
  public static final String PPP_PROFILE = "ppp_profile";
  public static final int PRELOAD_ENTRY_LEBA = 6;
  public static final int PRELOAD_ENTRY_PUBLIC_ACCOUNT = 5;
  public static final int PRELOAD_ENTRY_WEB = 9999;
  public static final int STRATEGY_TYPE_COMMON = 3;
  public static final int STRATEGY_TYPE_LOCAL = 1;
  public static final int STRATEGY_TYPE_SERVER = 2;
  public static final int STRATEGY_TYPE_UNDEF = 0;
  
  public abstract boolean launchPlugin(Activity paramActivity, Intent paramIntent, String paramString, PreloadProcHitPluginSession paramPreloadProcHitPluginSession);
  
  public abstract void loadComicModule(Context paramContext);
  
  public abstract void notifyChangedWhenRuntimeCreated();
  
  public abstract boolean preloadPubilcProcess(PreloadPublicParam paramPreloadPublicParam, String paramString1, AppRuntime paramAppRuntime, String paramString2, int paramInt, long paramLong, int[] paramArrayOfInt, IQQComicPluginUtil.ExtraResult paramExtraResult);
  
  public abstract void reportHitRate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2);
  
  public abstract void reportPreload(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, long paramLong);
  
  public abstract void reportProcBeKiiled(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  public abstract void setDownloadObserver(QQComicDownloadObserverProxy paramQQComicDownloadObserverProxy);
  
  public abstract void setFirstInObserver(Observer paramObserver);
  
  public abstract void setJsPluginBuilder(QQComicJsPluginBuilder paramQQComicJsPluginBuilder);
  
  public abstract void setPluginReady(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.api.IQQComicPluginUtil
 * JD-Core Version:    0.7.0.1
 */