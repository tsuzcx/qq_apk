package com.tencent.biz.pubaccount.Advertisement.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class AdvertisementVideoPreloadManager
  implements Manager
{
  private static final Long a = Long.valueOf(86400000L);
  private static final String b;
  private static final String[] c = { "mp4", "fhd", "shd", "hd", "sd", "msd" };
  private final Object d = new Object();
  private WeakReference<QQAppInterface> e;
  private Context f;
  private ArrayList<PAAdPreloadTask> g = new ArrayList();
  private ArrayList<PAAdPreloadTask> h = new ArrayList();
  private ArrayList<PAAdPreloadTask> i = new ArrayList();
  private PAAdPreloadTask j;
  private int k = 0;
  private int l = 0;
  private boolean m = false;
  private TVK_ICacheMgr n;
  private TVK_UserInfo o;
  private AdvertisementVideoPreloadManager.NetInfoHandler p;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/Android/data/com.tencent.mobileqq/cache/public_account_ad_download/");
    b = localStringBuilder.toString();
  }
  
  public AdvertisementVideoPreloadManager(QQAppInterface paramQQAppInterface)
  {
    this.e = new WeakReference(paramQQAppInterface);
    this.f = paramQQAppInterface.getApplication().getApplicationContext();
  }
  
  public static String b()
  {
    File localFile = new File(b);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return b;
  }
  
  private void b(int paramInt)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("continueDownload queueType:");
    ((StringBuilder)???).append(paramInt);
    f(((StringBuilder)???).toString());
    this.k = 0;
    synchronized (this.d)
    {
      this.j = null;
      ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.11(this, paramInt));
      return;
    }
  }
  
  public static boolean b(String paramString)
  {
    return g(paramString) == 2;
  }
  
  private String c()
  {
    WeakReference localWeakReference = this.e;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((QQAppInterface)this.e.get()).getCurrentUin();
    }
    return "";
  }
  
  public static void c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clearCacheVideo vid:");
    ((StringBuilder)localObject).append(paramString);
    f(((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new File(e(paramString));
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      paramString = new File(d(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  private PublicAccountEntityHelper d()
  {
    WeakReference localWeakReference = this.e;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return (PublicAccountEntityHelper)((QQAppInterface)this.e.get()).getManager(QQManagerFactory.PUBLIC_ACCOUNT_ENTITY_HELPER);
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new File(b);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(b);
        ((StringBuilder)localObject).append(String.valueOf(20170807));
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramString);
        return ((StringBuilder)localObject).toString();
      }
    }
    return "";
  }
  
  public static String e(String paramString)
  {
    String str = d(paramString);
    paramString = str;
    if (!TextUtils.isEmpty(str))
    {
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(".tmp");
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  private void e()
  {
    f("initCacheManager");
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      this.n = localTVK_IProxyFactory.getCacheMgr(this.f);
      this.n.setPreloadCallback(new AdvertisementVideoPreloadManager.PreloadCallback(this, null));
      this.n.setOnPreLoadCompleteCallback(new AdvertisementVideoPreloadManager.PreloadCompleteCallback(this, null));
    }
    this.o = new TVK_UserInfo(c(), "");
    this.p = new AdvertisementVideoPreloadManager.NetInfoHandler(this, this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.f, this.p);
    ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.3(this));
    this.m = true;
  }
  
  private void f()
  {
    f("resetDownload");
    this.k = 0;
    synchronized (this.d)
    {
      this.j = null;
      this.l = 0;
      return;
    }
  }
  
  public static void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementVideoPreloadManager", 2, paramString);
    }
  }
  
  private static int g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    File localFile = new File(d(paramString));
    if ((localFile.exists()) && (localFile.length() > 0L)) {
      return 2;
    }
    paramString = new File(e(paramString));
    if ((paramString.exists()) && (paramString.length() > 0L)) {
      return 1;
    }
    return 0;
  }
  
  private void g()
  {
    if (this.k == 0)
    {
      f("onNetworkChange, no queue is working");
      return;
    }
    Object localObject = this.j;
    if (localObject == null)
    {
      f("onNetworkChange, no valid task");
      return;
    }
    if (((PAAdPreloadTask)localObject).isNetworkValid())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNetworkChange, vid:");
      ((StringBuilder)localObject).append(this.j.mVideoVid);
      ((StringBuilder)localObject).append(", networkType:");
      ((StringBuilder)localObject).append(this.j.mNetworkType);
      ((StringBuilder)localObject).append(", valid network, going on");
      f(((StringBuilder)localObject).toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onNetworkChange, vid:");
    ((StringBuilder)localObject).append(this.j.mVideoVid);
    ((StringBuilder)localObject).append(", networkType:");
    ((StringBuilder)localObject).append(this.j.mNetworkType);
    ((StringBuilder)localObject).append(", invalid network, skip to next task");
    f(((StringBuilder)localObject).toString());
    localObject = this.n;
    if (localObject != null)
    {
      ((TVK_ICacheMgr)localObject).stopCacheData(20170807);
      b(this.k);
    }
  }
  
  public void a()
  {
    f("installTVKSdk");
    TVK_SDKMgr.initSdk(this.f, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", c());
    if (!TVK_SDKMgr.isInstalled(this.f))
    {
      ThreadManager.post(new AdvertisementVideoPreloadManager.2(this), 8, null, false);
      return;
    }
    e();
  }
  
  public void a(int paramInt)
  {
    if (!this.m) {
      a();
    }
    for (;;)
    {
      synchronized (this.d)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startVideoDownload queueType:");
        ((StringBuilder)localObject2).append(paramInt);
        f(((StringBuilder)localObject2).toString());
        if (this.n == null)
        {
          f("startVideoDownload cache manager not init!");
          f();
          return;
        }
        if (paramInt <= this.k)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startVideoDownload queue(");
          ((StringBuilder)localObject2).append(this.k);
          ((StringBuilder)localObject2).append(") already run!");
          f(((StringBuilder)localObject2).toString());
          return;
        }
        if (this.k != 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startVideoDownload break current queue(");
          ((StringBuilder)localObject2).append(this.k);
          ((StringBuilder)localObject2).append(")!");
          f(((StringBuilder)localObject2).toString());
          this.n.stopCacheData(20170807);
          f();
          break label904;
          if (this.i.size() > 0)
          {
            this.j = ((PAAdPreloadTask)this.i.remove(0));
            continue;
            if (this.h.size() > 0)
            {
              this.j = ((PAAdPreloadTask)this.h.remove(0));
              continue;
              if (this.l < this.g.size())
              {
                this.j = ((PAAdPreloadTask)this.g.get(this.l));
                this.l += 1;
              }
            }
          }
          if (this.j == null)
          {
            f("startVideoDownload no task to download");
            f();
            return;
          }
          this.k = paramInt;
          localObject2 = this.j.mVideoVid;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            if (this.j.mExpireTime > NetConnInfoCenter.getServerTimeMillis())
            {
              i1 = g((String)localObject2);
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("startVideoDownload vid:");
              ((StringBuilder)localObject4).append((String)localObject2);
              ((StringBuilder)localObject4).append(", cacheState:");
              ((StringBuilder)localObject4).append(i1);
              f(((StringBuilder)localObject4).toString());
              if (i1 != 2) {
                if (this.j.isNetworkValid())
                {
                  localObject4 = e((String)localObject2);
                  localObject5 = new File((String)localObject4);
                  boolean bool = ((File)localObject5).exists();
                  if (bool) {}
                }
              }
            }
          }
          try
          {
            ((File)localObject5).createNewFile();
          }
          catch (IOException localIOException)
          {
            HashMap localHashMap;
            continue;
          }
          Object localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("startVideoDownload create tmp file failed for vid:");
          ((StringBuilder)localObject5).append((String)localObject2);
          f(((StringBuilder)localObject5).toString());
          localObject5 = new TVK_PlayerVideoInfo(2, (String)localObject2, "");
          localHashMap = new HashMap();
          localHashMap.put("shouq_bus_type", "bus_type_pa_advertisement");
          ((TVK_PlayerVideoInfo)localObject5).setReportInfoMap(localHashMap);
          ((TVK_PlayerVideoInfo)localObject5).setConfigMap("cache_duration", String.valueOf(-1));
          ((TVK_PlayerVideoInfo)localObject5).setConfigMap("cache_servers_type", String.valueOf(20170807));
          ((TVK_PlayerVideoInfo)localObject5).setConfigMap("file_dir", (String)localObject4);
          this.n.preLoadVideoById(this.f, this.o, (TVK_PlayerVideoInfo)localObject5, "");
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          f(((StringBuilder)localObject4).toString());
          continue;
          int i1 = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(", networkType:");
          ((StringBuilder)localObject4).append(this.j.mNetworkType);
          ((StringBuilder)localObject4).append(", curNetType:");
          ((StringBuilder)localObject4).append(i1);
          ((StringBuilder)localObject4).append(", no valid network, skip to next task");
          f(((StringBuilder)localObject4).toString());
          b(paramInt);
          continue;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(", full cached, skip to next task");
          f(((StringBuilder)localObject4).toString());
          b(paramInt);
          continue;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(", expireTime:");
          ((StringBuilder)localObject4).append(this.j.mExpireTime);
          ((StringBuilder)localObject4).append(", task expired, clean cache and skip to next task");
          f(((StringBuilder)localObject4).toString());
          b(paramInt);
          if (g((String)localObject2) != 0)
          {
            ThreadManager.executeOnFileThread(new AdvertisementVideoPreloadManager.10(this, (String)localObject2));
            continue;
            f("startVideoDownload empty vid, skip to next task");
            b(paramInt);
          }
          return;
        }
      }
      label904:
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt == 3) {}
        }
      }
    }
  }
  
  public void a(AdvertisementItem paramAdvertisementItem)
  {
    Object localObject1 = this.d;
    if (paramAdvertisementItem != null) {}
    try
    {
      if ((paramAdvertisementItem.g != null) && (paramAdvertisementItem.c != null) && (paramAdvertisementItem.c.size() > 0))
      {
        Object localObject2 = paramAdvertisementItem.g;
        VideoCoverItem localVideoCoverItem = (VideoCoverItem)paramAdvertisementItem.c.get(0);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("handlePreloadTaskFromMessage msgid:");
        ((StringBuilder)localObject3).append(paramAdvertisementItem.d);
        ((StringBuilder)localObject3).append(", vid:");
        ((StringBuilder)localObject3).append(localVideoCoverItem.c);
        f(((StringBuilder)localObject3).toString());
        if (!TextUtils.isEmpty(localVideoCoverItem.c))
        {
          localObject3 = new PAAdPreloadTask();
          ((PAAdPreloadTask)localObject3).mUserUin = c();
          ((PAAdPreloadTask)localObject3).mVideoVid = localVideoCoverItem.c;
          if (!this.h.contains(localObject3))
          {
            ((PAAdPreloadTask)localObject3).mMsgId = paramAdvertisementItem.d;
            ((PAAdPreloadTask)localObject3).mSource = 2;
            long l1;
            if (paramAdvertisementItem.e > 0L) {
              l1 = paramAdvertisementItem.e;
            } else {
              l1 = NetConnInfoCenter.getServerTimeMillis();
            }
            ((PAAdPreloadTask)localObject3).mReceiveTime = l1;
            ((PAAdPreloadTask)localObject3).mExpireTime = (((PAAdPreloadTask)localObject3).mReceiveTime + a.longValue());
            ((PAAdPreloadTask)localObject3).mPreloadState = 1;
            ((PAAdPreloadTask)localObject3).mNetworkType = ((VideoDownloadItem)localObject2).u;
            this.h.add(localObject3);
            ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.8(this));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handlePreloadTaskFromMessage msgid:");
            ((StringBuilder)localObject2).append(paramAdvertisementItem.d);
            ((StringBuilder)localObject2).append(", vid:");
            ((StringBuilder)localObject2).append(localVideoCoverItem.c);
            ((StringBuilder)localObject2).append(", add to queue");
            f(((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handlePreloadTaskFromMessage msgid:");
            ((StringBuilder)localObject2).append(paramAdvertisementItem.d);
            ((StringBuilder)localObject2).append(", vid:");
            ((StringBuilder)localObject2).append(localVideoCoverItem.c);
            ((StringBuilder)localObject2).append(", exist in queue, ignore");
            f(((StringBuilder)localObject2).toString());
          }
        }
        return;
      }
      f("handlePreloadTaskFromMessage invalid item");
      return;
    }
    finally {}
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, int paramInt)
  {
    Object localObject1 = this.d;
    if (paramAdvertisementItem != null) {}
    try
    {
      if ((paramAdvertisementItem.g != null) && (paramAdvertisementItem.c != null) && (paramAdvertisementItem.c.size() > paramInt))
      {
        String str = ((VideoCoverItem)paramAdvertisementItem.c.get(paramInt)).c;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handlePreloadTaskFromPlay msgid:");
        ((StringBuilder)localObject2).append(paramAdvertisementItem.d);
        ((StringBuilder)localObject2).append(", index:");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(", vid:");
        ((StringBuilder)localObject2).append(str);
        f(((StringBuilder)localObject2).toString());
        if (!TextUtils.isEmpty(str))
        {
          localObject2 = new PAAdPreloadTask();
          ((PAAdPreloadTask)localObject2).mUserUin = c();
          ((PAAdPreloadTask)localObject2).mVideoVid = str;
          if (!this.i.contains(localObject2))
          {
            ((PAAdPreloadTask)localObject2).mMsgId = paramAdvertisementItem.d;
            ((PAAdPreloadTask)localObject2).mSource = 3;
            long l1;
            if (paramAdvertisementItem.e > 0L) {
              l1 = paramAdvertisementItem.e;
            } else {
              l1 = NetConnInfoCenter.getServerTimeMillis();
            }
            ((PAAdPreloadTask)localObject2).mReceiveTime = l1;
            ((PAAdPreloadTask)localObject2).mExpireTime = (((PAAdPreloadTask)localObject2).mReceiveTime + a.longValue());
            ((PAAdPreloadTask)localObject2).mPreloadState = 1;
            ((PAAdPreloadTask)localObject2).mNetworkType = paramAdvertisementItem.g.u;
            this.i.add(localObject2);
            ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.9(this));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handlePreloadTaskFromPlay msgid:");
            ((StringBuilder)localObject2).append(paramAdvertisementItem.d);
            ((StringBuilder)localObject2).append(", index:");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(", vid:");
            ((StringBuilder)localObject2).append(str);
            ((StringBuilder)localObject2).append(", add to queue");
            f(((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handlePreloadTaskFromPlay msgid:");
            ((StringBuilder)localObject2).append(paramAdvertisementItem.d);
            ((StringBuilder)localObject2).append(", index:");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(", vid:");
            ((StringBuilder)localObject2).append(str);
            ((StringBuilder)localObject2).append(", exist in queue, ignore");
            f(((StringBuilder)localObject2).toString());
          }
        }
        return;
      }
      f("handlePreloadTaskFromPlay invalid item");
      return;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    synchronized (this.d)
    {
      int i1 = paramQQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0);
      int i2 = paramConfig.version.get();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handlePreloadTaskFromConfig localVer:");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", serverVer:");
      ((StringBuilder)localObject1).append(i2);
      f(((StringBuilder)localObject1).toString());
      if (i1 != i2)
      {
        if (paramConfig.msg_content_list.size() > 0)
        {
          ArrayList localArrayList = new ArrayList();
          Object localObject3 = paramConfig.msg_content_list.get().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            paramConfig = (ConfigurationService.Content)((Iterator)localObject3).next();
            if ((paramConfig != null) && (paramConfig.content.has()))
            {
              if (paramConfig.compress.get() == 1)
              {
                Object localObject4 = OlympicUtil.a(paramConfig.content.get().toByteArray());
                localObject1 = null;
                paramConfig = (ConfigurationService.Config)localObject1;
                if (localObject4 != null) {
                  try
                  {
                    paramConfig = new String((byte[])localObject4, "UTF-8");
                  }
                  catch (Exception paramConfig)
                  {
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append("handlePreloadTaskFromConfig|uncompress failed ");
                    ((StringBuilder)localObject4).append(paramConfig);
                    QLog.e("AdvertisementVideoPreloadManager", 1, ((StringBuilder)localObject4).toString());
                    paramConfig = (ConfigurationService.Config)localObject1;
                  }
                }
              }
              else
              {
                paramConfig = paramConfig.content.get().toStringUtf8();
              }
              if (!TextUtils.isEmpty(paramConfig)) {
                localArrayList.addAll(PAAdPreloadTask.parserConfigTask(paramQQAppInterface.getCurrentAccountUin(), paramConfig));
              }
            }
            else
            {
              f("handlePreloadTaskFromConfig empty content");
            }
          }
          if ((this.k == 1) && (this.n != null))
          {
            this.n.stopCacheData(20170807);
            f();
          }
          long l1 = NetConnInfoCenter.getServerTimeMillis();
          paramConfig = new ArrayList();
          localObject1 = this.g.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (PAAdPreloadTask)((Iterator)localObject1).next();
            if ((((PAAdPreloadTask)localObject3).mExpireTime <= l1) || (!localArrayList.contains(localObject3))) {
              paramConfig.add(localObject3);
            }
          }
          ThreadManager.executeOnFileThread(new AdvertisementVideoPreloadManager.4(this, paramConfig));
          this.g.clear();
          this.g.addAll(localArrayList);
          paramConfig = new StringBuilder();
          paramConfig.append("handlePreloadTaskFromConfig new taskSize:");
          paramConfig.append(localArrayList.size());
          f(paramConfig.toString());
          ThreadManager.executeOnSubThread(new AdvertisementVideoPreloadManager.5(this));
          paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
          paramQQAppInterface.putInt("public_account_ad_preload_task", i2);
          paramQQAppInterface.apply();
          ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.6(this));
        }
        else
        {
          f("handlePreloadTaskFromConfig empty config");
        }
      }
      else {
        f("handlePreloadTaskFromConfig same version, no need to update");
      }
      return;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public void a(String paramString)
  {
    ThreadManager.executeOnSubThread(new AdvertisementVideoPreloadManager.7(this, paramString));
  }
  
  public void onDestroy()
  {
    this.g.clear();
    this.h.clear();
    this.i.clear();
    Object localObject = this.n;
    if (localObject != null)
    {
      ((TVK_ICacheMgr)localObject).stopCacheData(20170807);
      this.n.removePreloadCallback();
      this.n.setOnPreLoadCompleteCallback(null);
    }
    localObject = this.p;
    if (localObject != null)
    {
      ((AdvertisementVideoPreloadManager.NetInfoHandler)localObject).a();
      AppNetConnInfo.unregisterNetInfoHandler(this.p);
      this.p = null;
    }
    this.m = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager
 * JD-Core Version:    0.7.0.1
 */