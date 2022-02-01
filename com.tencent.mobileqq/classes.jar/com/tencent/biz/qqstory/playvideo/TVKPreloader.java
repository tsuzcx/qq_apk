package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.util.URLUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.concurrent.GuardedBy;

public class TVKPreloader
{
  @GuardedBy("sPendingPreloadQueue")
  private static final Queue<TVKPreloader.PreloadItem> a = new LinkedList();
  @GuardedBy("sPendingPreloadQueue")
  private static TVKPreloader.PreloadItem b = null;
  @GuardedBy("sPendingPreloadQueue")
  private static long c;
  private static Context d = BaseApplicationImpl.getApplication();
  private static Handler e = new Handler(Looper.getMainLooper());
  private static final CopyOnWriteArraySet<TVKPreloader.PreloadListener> f = new CopyOnWriteArraySet();
  private static TVK_ICacheMgr.IPreloadCompleteCallback g = new TVKPreloader.1();
  private static TVK_ICacheMgr.IPreloadCallback h = new TVKPreloader.2();
  
  public static void a()
  {
    synchronized (a)
    {
      Object localObject1 = new ArrayList(a);
      a.clear();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        TVKPreloader.PreloadItem localPreloadItem = (TVKPreloader.PreloadItem)((Iterator)localObject1).next();
        e.post(new TVKPreloader.4(localPreloadItem));
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static void a(TVKPreloader.PreloadItem paramPreloadItem)
  {
    if (paramPreloadItem != null) {
      synchronized (a)
      {
        if (!a.contains(paramPreloadItem)) {
          a.offer(paramPreloadItem);
        }
        b(false);
        return;
      }
    }
    throw new IllegalArgumentException("item should not be null");
  }
  
  public static void a(String paramString)
  {
    a(paramString, VideoViewFactory.a(BaseApplicationImpl.getContext()).a());
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      File localFile = FileCacheUtils.a(paramString, 0, true, true);
      if (localFile != null) {
        ((DownloadUrlManager)SuperManager.a(28)).a(paramString, 0, new TVKPreloader.3(localFile, paramString));
      }
    }
  }
  
  public static int b(TVKPreloader.PreloadItem paramPreloadItem)
  {
    if (paramPreloadItem != null)
    {
      paramPreloadItem = new File(paramPreloadItem.c);
      boolean bool = FileCacheUtils.a(paramPreloadItem);
      int i = 1;
      if (bool) {
        return 1;
      }
      if ((!paramPreloadItem.isFile()) || (paramPreloadItem.length() < 409600L)) {
        i = 0;
      }
      if (i != 0) {
        return 2;
      }
      if (paramPreloadItem.length() > 0L) {
        return 3;
      }
      return 4;
    }
    throw new NullPointerException("preloadItem is null");
  }
  
  public static void b()
  {
    ??? = g();
    if (??? != null)
    {
      ((TVK_ICacheMgr)???).removePreloadCallback();
      ((TVK_ICacheMgr)???).releasePreload(20161223);
    }
    synchronized (a)
    {
      Object localObject2 = new ArrayList(a);
      if (b != null) {
        ((List)localObject2).add(0, b);
      }
      b = null;
      a.clear();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TVKPreloader.PreloadItem localPreloadItem = (TVKPreloader.PreloadItem)((Iterator)localObject2).next();
        e.post(new TVKPreloader.5(localPreloadItem));
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private static void b(TVK_ICacheMgr paramTVK_ICacheMgr, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString, TVKPreloader.PreloadItem paramPreloadItem)
  {
    paramString = paramString.replace("https://", "http://");
    paramTVK_ICacheMgr.setOnPreLoadCompleteCallback(g);
    paramTVK_ICacheMgr.setPreloadCallback(h);
    c = SystemClock.uptimeMillis();
    paramTVK_ICacheMgr.preLoadVideoByUrl(BaseApplicationImpl.getContext(), paramString, null, paramTVK_PlayerVideoInfo);
    e.post(new TVKPreloader.10(paramPreloadItem));
  }
  
  private static void b(boolean paramBoolean)
  {
    Queue localQueue = a;
    if (!paramBoolean) {}
    try
    {
      if (b != null)
      {
        SLog.a("Q.qqstory.playernew.TVKPreloader", "triggerPreload, clearCurrentItem=false, sCurrentPreloadItem=%s", b);
      }
      else
      {
        b = (TVKPreloader.PreloadItem)a.poll();
        if (b != null) {
          Bosses.get().postJob(new TVKPreloader.6("Q.qqstory.playernew.TVKPreloader"));
        }
      }
      return;
    }
    finally {}
  }
  
  private static void d(@NonNull TVKPreloader.PreloadItem paramPreloadItem)
  {
    int i = b(paramPreloadItem);
    if ((i != 1) && (i != 2))
    {
      TVK_ICacheMgr localTVK_ICacheMgr = g();
      if (localTVK_ICacheMgr == null)
      {
        e.post(new TVKPreloader.8(paramPreloadItem));
        b(true);
        return;
      }
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramPreloadItem.b;
      i = ((Integer)((StoryConfigManager)SuperManager.a(10)).c("key_story_video_preload_duration", Integer.valueOf(2))).intValue();
      TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = StoryPlayerTVKWrapper.a(paramPreloadItem.a, paramPreloadItem.c);
      localTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(i));
      if (arrayOfString[0].contains("qqstocdnd"))
      {
        VideoServerInfoManager localVideoServerInfoManager = (VideoServerInfoManager)SuperManager.a(4);
        String str = localVideoServerInfoManager.f();
        if (!TextUtils.isEmpty(str))
        {
          arrayOfString[0] = URLUtil.a(arrayOfString[0], "authkey", str);
          b(localTVK_ICacheMgr, localTVK_PlayerVideoInfo, arrayOfString[0], paramPreloadItem);
          return;
        }
        Bosses.get().postJob(new TVKPreloader.9("Q.qqstory.playernew.TVKPreloader", localVideoServerInfoManager, arrayOfString, i, paramPreloadItem, localTVK_ICacheMgr, localTVK_PlayerVideoInfo));
        return;
      }
      b(localTVK_ICacheMgr, localTVK_PlayerVideoInfo, arrayOfString[0], paramPreloadItem);
      return;
    }
    e.post(new TVKPreloader.7(paramPreloadItem));
    b(true);
  }
  
  private static TVK_ICacheMgr g()
  {
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getApplication())) {
      return TVK_SDKMgr.getProxyFactory().getCacheMgr(BaseApplicationImpl.getApplication());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader
 * JD-Core Version:    0.7.0.1
 */