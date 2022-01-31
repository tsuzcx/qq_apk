package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.DownloadUrlQueryResult;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl;
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
import noj;
import nol;
import noo;
import nop;
import noq;
import nor;
import nos;

public class TVKPreloader
{
  @GuardedBy("sPendingPreloadQueue")
  private static long jdField_a_of_type_Long;
  private static Context jdField_a_of_type_AndroidContentContext;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  @GuardedBy("sPendingPreloadQueue")
  private static TVKPreloader.PreloadItem jdField_a_of_type_ComTencentBizQqstoryPlayvideoTVKPreloader$PreloadItem;
  private static TVK_ICacheMgr.IPreloadCallback jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCallback = new nol();
  private static TVK_ICacheMgr.IPreloadCompleteCallback jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCompleteCallback;
  @GuardedBy("sPendingPreloadQueue")
  private static final Queue jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private static final CopyOnWriteArraySet jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet;
  
  static
  {
    jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication();
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCompleteCallback = new noj();
  }
  
  public static int a(TVKPreloader.PreloadItem paramPreloadItem)
  {
    int i = 1;
    if (paramPreloadItem == null) {
      throw new NullPointerException("preloadItem is null");
    }
    paramPreloadItem = new File(paramPreloadItem.c);
    if (FileCacheUtils.a(paramPreloadItem)) {
      return 1;
    }
    if ((paramPreloadItem.isFile()) && (paramPreloadItem.length() >= 409600L)) {}
    while (i != 0)
    {
      return 2;
      i = 0;
    }
    if (paramPreloadItem.length() > 0L) {
      return 3;
    }
    return 4;
  }
  
  public static TVKPreloader.PreloadItem a(String paramString)
  {
    if (VideoViewFactory.a(BaseApplicationImpl.getContext()).a())
    {
      File localFile = FileCacheUtils.a(paramString, 0, true, true);
      if (localFile != null)
      {
        DownloadUrlManager.DownloadUrlQueryResult localDownloadUrlQueryResult = ((DownloadUrlManager)SuperManager.a(28)).a(paramString, 0);
        String str = localDownloadUrlQueryResult.b;
        if (str != null)
        {
          if ((localDownloadUrlQueryResult.jdField_a_of_type_Boolean) && (localFile.exists()) && (!FileCacheUtils.a(localFile)))
          {
            localFile.delete();
            SLog.d("Q.qqstory.player.TVKPreloader", "letPreloadVid %s - %d found orphan tmp , delete it", new Object[] { localDownloadUrlQueryResult.jdField_a_of_type_JavaLangString, Integer.valueOf(localDownloadUrlQueryResult.jdField_a_of_type_Int) });
          }
          SLog.a("Q.qqstory.player.TVKPreloader", "letPreloadVid : supportStreamPlay=true : TVK preload : vid=%s, url=%s", paramString, str);
          paramString = new TVKPreloader.PreloadItem(paramString, str, localFile.getAbsolutePath(), "");
          a(paramString);
          return paramString;
        }
        SLog.d("Q.qqstory.player.TVKPreloader", "letPreloadVid : supportStreamPlay=true : videoUrl null : TVK preload ignore ! vid=%s", new Object[] { paramString });
      }
    }
    for (;;)
    {
      return null;
      SLog.e("Q.qqstory.player.TVKPreloader", "letPreloadVid : supportStreamPlay=true : localVideoFile null : TVK preload ignore ! vid=%s", new Object[] { paramString });
      continue;
      SLog.d("Q.qqstory.player.TVKPreloader", "letPreloadVid : supportStreamPlay=false : TVK preload ignore ! vid=%s", new Object[] { paramString });
    }
  }
  
  private static TVK_ICacheMgr a()
  {
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getApplication())) {
      return TVK_SDKMgr.getProxyFactory().getCacheMgr(BaseApplicationImpl.getApplication());
    }
    return null;
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilQueue)
    {
      Object localObject1 = new ArrayList(jdField_a_of_type_JavaUtilQueue);
      jdField_a_of_type_JavaUtilQueue.clear();
      SLog.d("Q.qqstory.player.TVKPreloader", "cancelAllPending, count = %d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
      localObject1 = ((List)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        TVKPreloader.PreloadItem localPreloadItem = (TVKPreloader.PreloadItem)((Iterator)localObject1).next();
        jdField_a_of_type_AndroidOsHandler.post(new noo(localPreloadItem));
      }
    }
  }
  
  public static void a(TVKPreloader.PreloadItem paramPreloadItem)
  {
    if (paramPreloadItem == null) {
      throw new IllegalArgumentException("item should not be null");
    }
    synchronized (jdField_a_of_type_JavaUtilQueue)
    {
      if (!jdField_a_of_type_JavaUtilQueue.contains(paramPreloadItem))
      {
        jdField_a_of_type_JavaUtilQueue.offer(paramPreloadItem);
        SLog.a("Q.qqstory.player.TVKPreloader", "letsPreloadVideo %s", paramPreloadItem);
        b(false);
        return;
      }
      SLog.a("Q.qqstory.player.TVKPreloader", "letsPreloadVideo ignore : %s", paramPreloadItem);
    }
  }
  
  private static void b(@NonNull TVKPreloader.PreloadItem paramPreloadItem)
  {
    int i = a(paramPreloadItem);
    TVK_ICacheMgr localTVK_ICacheMgr;
    switch (i)
    {
    default: 
      localTVK_ICacheMgr = a();
      if (localTVK_ICacheMgr == null)
      {
        SLog.e("Q.qqstory.player.TVKPreloader", "preloadVideo failed, cacheMgr is null, %s", new Object[] { paramPreloadItem });
        jdField_a_of_type_AndroidOsHandler.post(new noq(paramPreloadItem));
        b(true);
        return;
      }
      break;
    case 1: 
    case 2: 
      SLog.b("Q.qqstory.player.TVKPreloader", "preloadVideo success, has already been cached/downloaded, state=%d, item=%s", Integer.valueOf(i), paramPreloadItem);
      jdField_a_of_type_AndroidOsHandler.post(new nop(paramPreloadItem));
      b(true);
      return;
    }
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramPreloadItem.b;
    i = ((Integer)((StoryConfigManager)SuperManager.a(10)).b("key_story_video_preload_duration", Integer.valueOf(2))).intValue();
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = VideoViewTVKImpl.a(DownloadTask.a(paramPreloadItem.jdField_a_of_type_JavaLangString, 0), paramPreloadItem.c);
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(i));
    if (arrayOfString[0].contains("qqstocdnd"))
    {
      VideoServerInfoManager localVideoServerInfoManager = (VideoServerInfoManager)SuperManager.a(4);
      String str = localVideoServerInfoManager.b();
      if (!TextUtils.isEmpty(str))
      {
        arrayOfString[0] = URLUtil.a(arrayOfString[0], "authkey", str);
        SLog.d("Q.qqstory.player.TVKPreloader", "preloadVideo 0 TVK start pre-load video, preload duration : %d, item : %s", new Object[] { Integer.valueOf(i), paramPreloadItem });
        b(localTVK_ICacheMgr, localTVK_PlayerVideoInfo, arrayOfString[0], paramPreloadItem);
        return;
      }
      Bosses.get().postJob(new nor(localVideoServerInfoManager, arrayOfString, i, paramPreloadItem, localTVK_ICacheMgr, localTVK_PlayerVideoInfo));
      return;
    }
    SLog.d("Q.qqstory.player.TVKPreloader", "preloadVideo 2 TVK start pre-load video, preload duration : %d, item : %s", new Object[] { Integer.valueOf(i), paramPreloadItem });
    b(localTVK_ICacheMgr, localTVK_PlayerVideoInfo, arrayOfString[0], paramPreloadItem);
  }
  
  private static void b(TVK_ICacheMgr paramTVK_ICacheMgr, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString, TVKPreloader.PreloadItem paramPreloadItem)
  {
    paramString = paramString.replace("https://", "http://");
    paramTVK_ICacheMgr.setOnPreLoadCompleteCallback(jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCompleteCallback);
    paramTVK_ICacheMgr.setPreloadCallback(jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCallback);
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
    paramTVK_ICacheMgr.preLoadVideoByUrl(BaseApplicationImpl.getContext(), paramString, null, paramTVK_PlayerVideoInfo);
    jdField_a_of_type_AndroidOsHandler.post(new nos(paramPreloadItem));
  }
  
  /* Error */
  private static void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 25	com/tencent/biz/qqstory/playvideo/TVKPreloader:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: iload_0
    //   7: ifne +9 -> 16
    //   10: getstatic 101	com/tencent/biz/qqstory/playvideo/TVKPreloader:jdField_a_of_type_ComTencentBizQqstoryPlayvideoTVKPreloader$PreloadItem	Lcom/tencent/biz/qqstory/playvideo/TVKPreloader$PreloadItem;
    //   13: ifnonnull +32 -> 45
    //   16: getstatic 25	com/tencent/biz/qqstory/playvideo/TVKPreloader:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   19: invokeinterface 398 1 0
    //   24: checkcast 75	com/tencent/biz/qqstory/playvideo/TVKPreloader$PreloadItem
    //   27: putstatic 101	com/tencent/biz/qqstory/playvideo/TVKPreloader:jdField_a_of_type_ComTencentBizQqstoryPlayvideoTVKPreloader$PreloadItem	Lcom/tencent/biz/qqstory/playvideo/TVKPreloader$PreloadItem;
    //   30: getstatic 101	com/tencent/biz/qqstory/playvideo/TVKPreloader:jdField_a_of_type_ComTencentBizQqstoryPlayvideoTVKPreloader$PreloadItem	Lcom/tencent/biz/qqstory/playvideo/TVKPreloader$PreloadItem;
    //   33: ifnull +9 -> 42
    //   36: getstatic 101	com/tencent/biz/qqstory/playvideo/TVKPreloader:jdField_a_of_type_ComTencentBizQqstoryPlayvideoTVKPreloader$PreloadItem	Lcom/tencent/biz/qqstory/playvideo/TVKPreloader$PreloadItem;
    //   39: invokestatic 400	com/tencent/biz/qqstory/playvideo/TVKPreloader:b	(Lcom/tencent/biz/qqstory/playvideo/TVKPreloader$PreloadItem;)V
    //   42: aload_1
    //   43: monitorexit
    //   44: return
    //   45: ldc 142
    //   47: ldc_w 402
    //   50: getstatic 101	com/tencent/biz/qqstory/playvideo/TVKPreloader:jdField_a_of_type_ComTencentBizQqstoryPlayvideoTVKPreloader$PreloadItem	Lcom/tencent/biz/qqstory/playvideo/TVKPreloader$PreloadItem;
    //   53: invokestatic 262	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   56: goto -14 -> 42
    //   59: astore_2
    //   60: aload_1
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramBoolean	boolean
    //   3	58	1	localQueue	Queue
    //   59	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	16	59	finally
    //   16	42	59	finally
    //   42	44	59	finally
    //   45	56	59	finally
    //   60	62	59	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader
 * JD-Core Version:    0.7.0.1
 */