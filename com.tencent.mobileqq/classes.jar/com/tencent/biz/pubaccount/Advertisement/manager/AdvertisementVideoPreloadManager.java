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
  private static final Long jdField_a_of_type_JavaLangLong = Long.valueOf(86400000L);
  private static final String jdField_a_of_type_JavaLangString;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "mp4", "fhd", "shd", "hd", "sd", "msd" };
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private AdvertisementVideoPreloadManager.NetInfoHandler jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementVideoPreloadManager$NetInfoHandler;
  private PAAdPreloadTask jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_UserInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<PAAdPreloadTask> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private ArrayList<PAAdPreloadTask> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<PAAdPreloadTask> c = new ArrayList();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/Android/data/com.tencent.mobileqq/cache/public_account_ad_download/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public AdvertisementVideoPreloadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApplication().getApplicationContext();
  }
  
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    File localFile = new File(a(paramString));
    if ((localFile.exists()) && (localFile.length() > 0L)) {
      return 2;
    }
    paramString = new File(b(paramString));
    if ((paramString.exists()) && (paramString.length() > 0L)) {
      return 1;
    }
    return 0;
  }
  
  private PublicAccountEntityHelper a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return (PublicAccountEntityHelper)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(QQManagerFactory.PUBLIC_ACCOUNT_ENTITY_HELPER);
    }
    return null;
  }
  
  public static String a()
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new File(jdField_a_of_type_JavaLangString);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(String.valueOf(20170807));
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramString);
        return ((StringBuilder)localObject).toString();
      }
    }
    return "";
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString) == 2;
  }
  
  private String b()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentUin();
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    String str = a(paramString);
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
  
  private void b()
  {
    c("initCacheManager");
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = localTVK_IProxyFactory.getCacheMgr(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(new AdvertisementVideoPreloadManager.PreloadCallback(this, null));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setOnPreLoadCompleteCallback(new AdvertisementVideoPreloadManager.PreloadCompleteCallback(this, null));
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo(b(), "");
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementVideoPreloadManager$NetInfoHandler = new AdvertisementVideoPreloadManager.NetInfoHandler(this, this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementVideoPreloadManager$NetInfoHandler);
    ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.3(this));
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(int paramInt)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("continueDownload queueType:");
    ((StringBuilder)???).append(paramInt);
    c(((StringBuilder)???).toString());
    this.jdField_a_of_type_Int = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
      ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.11(this, paramInt));
      return;
    }
  }
  
  public static void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clearCacheVideo vid:");
    ((StringBuilder)localObject).append(paramString);
    c(((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new File(b(paramString));
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      paramString = new File(a(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  private void c()
  {
    c("resetDownload");
    this.jdField_a_of_type_Int = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
      this.jdField_b_of_type_Int = 0;
      return;
    }
  }
  
  public static void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementVideoPreloadManager", 2, paramString);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      c("onNetworkChange, no queue is working");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask;
    if (localObject == null)
    {
      c("onNetworkChange, no valid task");
      return;
    }
    if (((PAAdPreloadTask)localObject).isNetworkValid())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNetworkChange, vid:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid);
      ((StringBuilder)localObject).append(", networkType:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType);
      ((StringBuilder)localObject).append(", valid network, going on");
      c(((StringBuilder)localObject).toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onNetworkChange, vid:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid);
    ((StringBuilder)localObject).append(", networkType:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType);
    ((StringBuilder)localObject).append(", invalid network, skip to next task");
    c(((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localObject != null)
    {
      ((TVK_ICacheMgr)localObject).stopCacheData(20170807);
      b(this.jdField_a_of_type_Int);
    }
  }
  
  public void a()
  {
    c("installTVKSdk");
    TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidContentContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", b());
    if (!TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
    {
      ThreadManager.post(new AdvertisementVideoPreloadManager.2(this), 8, null, false);
      return;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startVideoDownload queueType:");
        ((StringBuilder)localObject2).append(paramInt);
        c(((StringBuilder)localObject2).toString());
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null)
        {
          c("startVideoDownload cache manager not init!");
          c();
          return;
        }
        if (paramInt <= this.jdField_a_of_type_Int)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startVideoDownload queue(");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append(") already run!");
          c(((StringBuilder)localObject2).toString());
          return;
        }
        if (this.jdField_a_of_type_Int != 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startVideoDownload break current queue(");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append(")!");
          c(((StringBuilder)localObject2).toString());
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
          c();
          break label904;
          if (this.c.size() > 0)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = ((PAAdPreloadTask)this.c.remove(0));
            continue;
            if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = ((PAAdPreloadTask)this.jdField_b_of_type_JavaUtilArrayList.remove(0));
              continue;
              if (this.jdField_b_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())
              {
                this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = ((PAAdPreloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int));
                this.jdField_b_of_type_Int += 1;
              }
            }
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask == null)
          {
            c("startVideoDownload no task to download");
            c();
            return;
          }
          this.jdField_a_of_type_Int = paramInt;
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mExpireTime > NetConnInfoCenter.getServerTimeMillis())
            {
              i = a((String)localObject2);
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("startVideoDownload vid:");
              ((StringBuilder)localObject4).append((String)localObject2);
              ((StringBuilder)localObject4).append(", cacheState:");
              ((StringBuilder)localObject4).append(i);
              c(((StringBuilder)localObject4).toString());
              if (i != 2) {
                if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isNetworkValid())
                {
                  localObject4 = b((String)localObject2);
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
          c(((StringBuilder)localObject5).toString());
          localObject5 = new TVK_PlayerVideoInfo(2, (String)localObject2, "");
          localHashMap = new HashMap();
          localHashMap.put("shouq_bus_type", "bus_type_pa_advertisement");
          ((TVK_PlayerVideoInfo)localObject5).setReportInfoMap(localHashMap);
          ((TVK_PlayerVideoInfo)localObject5).setConfigMap("cache_duration", String.valueOf(-1));
          ((TVK_PlayerVideoInfo)localObject5).setConfigMap("cache_servers_type", String.valueOf(20170807));
          ((TVK_PlayerVideoInfo)localObject5).setConfigMap("file_dir", (String)localObject4);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.preLoadVideoById(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, (TVK_PlayerVideoInfo)localObject5, "");
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          c(((StringBuilder)localObject4).toString());
          continue;
          int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(", networkType:");
          ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType);
          ((StringBuilder)localObject4).append(", curNetType:");
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append(", no valid network, skip to next task");
          c(((StringBuilder)localObject4).toString());
          b(paramInt);
          continue;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(", full cached, skip to next task");
          c(((StringBuilder)localObject4).toString());
          b(paramInt);
          continue;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(", expireTime:");
          ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mExpireTime);
          ((StringBuilder)localObject4).append(", task expired, clean cache and skip to next task");
          c(((StringBuilder)localObject4).toString());
          b(paramInt);
          if (a((String)localObject2) != 0)
          {
            ThreadManager.executeOnFileThread(new AdvertisementVideoPreloadManager.10(this, (String)localObject2));
            continue;
            c("startVideoDownload empty vid, skip to next task");
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
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramAdvertisementItem != null) {}
    try
    {
      if ((paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem != null) && (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList != null) && (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        Object localObject2 = paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
        VideoCoverItem localVideoCoverItem = (VideoCoverItem)paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(0);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("handlePreloadTaskFromMessage msgid:");
        ((StringBuilder)localObject3).append(paramAdvertisementItem.c);
        ((StringBuilder)localObject3).append(", vid:");
        ((StringBuilder)localObject3).append(localVideoCoverItem.b);
        c(((StringBuilder)localObject3).toString());
        if (!TextUtils.isEmpty(localVideoCoverItem.b))
        {
          localObject3 = new PAAdPreloadTask();
          ((PAAdPreloadTask)localObject3).mUserUin = b();
          ((PAAdPreloadTask)localObject3).mVideoVid = localVideoCoverItem.b;
          if (!this.jdField_b_of_type_JavaUtilArrayList.contains(localObject3))
          {
            ((PAAdPreloadTask)localObject3).mMsgId = paramAdvertisementItem.c;
            ((PAAdPreloadTask)localObject3).mSource = 2;
            long l;
            if (paramAdvertisementItem.jdField_a_of_type_Long > 0L) {
              l = paramAdvertisementItem.jdField_a_of_type_Long;
            } else {
              l = NetConnInfoCenter.getServerTimeMillis();
            }
            ((PAAdPreloadTask)localObject3).mReceiveTime = l;
            ((PAAdPreloadTask)localObject3).mExpireTime = (((PAAdPreloadTask)localObject3).mReceiveTime + jdField_a_of_type_JavaLangLong.longValue());
            ((PAAdPreloadTask)localObject3).mPreloadState = 1;
            ((PAAdPreloadTask)localObject3).mNetworkType = ((VideoDownloadItem)localObject2).e;
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject3);
            ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.8(this));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handlePreloadTaskFromMessage msgid:");
            ((StringBuilder)localObject2).append(paramAdvertisementItem.c);
            ((StringBuilder)localObject2).append(", vid:");
            ((StringBuilder)localObject2).append(localVideoCoverItem.b);
            ((StringBuilder)localObject2).append(", add to queue");
            c(((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handlePreloadTaskFromMessage msgid:");
            ((StringBuilder)localObject2).append(paramAdvertisementItem.c);
            ((StringBuilder)localObject2).append(", vid:");
            ((StringBuilder)localObject2).append(localVideoCoverItem.b);
            ((StringBuilder)localObject2).append(", exist in queue, ignore");
            c(((StringBuilder)localObject2).toString());
          }
        }
        return;
      }
      c("handlePreloadTaskFromMessage invalid item");
      return;
    }
    finally {}
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramAdvertisementItem != null) {}
    try
    {
      if ((paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem != null) && (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList != null) && (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() > paramInt))
      {
        String str = ((VideoCoverItem)paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handlePreloadTaskFromPlay msgid:");
        ((StringBuilder)localObject2).append(paramAdvertisementItem.c);
        ((StringBuilder)localObject2).append(", index:");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(", vid:");
        ((StringBuilder)localObject2).append(str);
        c(((StringBuilder)localObject2).toString());
        if (!TextUtils.isEmpty(str))
        {
          localObject2 = new PAAdPreloadTask();
          ((PAAdPreloadTask)localObject2).mUserUin = b();
          ((PAAdPreloadTask)localObject2).mVideoVid = str;
          if (!this.c.contains(localObject2))
          {
            ((PAAdPreloadTask)localObject2).mMsgId = paramAdvertisementItem.c;
            ((PAAdPreloadTask)localObject2).mSource = 3;
            long l;
            if (paramAdvertisementItem.jdField_a_of_type_Long > 0L) {
              l = paramAdvertisementItem.jdField_a_of_type_Long;
            } else {
              l = NetConnInfoCenter.getServerTimeMillis();
            }
            ((PAAdPreloadTask)localObject2).mReceiveTime = l;
            ((PAAdPreloadTask)localObject2).mExpireTime = (((PAAdPreloadTask)localObject2).mReceiveTime + jdField_a_of_type_JavaLangLong.longValue());
            ((PAAdPreloadTask)localObject2).mPreloadState = 1;
            ((PAAdPreloadTask)localObject2).mNetworkType = paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.e;
            this.c.add(localObject2);
            ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.9(this));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handlePreloadTaskFromPlay msgid:");
            ((StringBuilder)localObject2).append(paramAdvertisementItem.c);
            ((StringBuilder)localObject2).append(", index:");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(", vid:");
            ((StringBuilder)localObject2).append(str);
            ((StringBuilder)localObject2).append(", add to queue");
            c(((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handlePreloadTaskFromPlay msgid:");
            ((StringBuilder)localObject2).append(paramAdvertisementItem.c);
            ((StringBuilder)localObject2).append(", index:");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(", vid:");
            ((StringBuilder)localObject2).append(str);
            ((StringBuilder)localObject2).append(", exist in queue, ignore");
            c(((StringBuilder)localObject2).toString());
          }
        }
        return;
      }
      c("handlePreloadTaskFromPlay invalid item");
      return;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int i = paramQQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0);
      int j = paramConfig.version.get();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handlePreloadTaskFromConfig localVer:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", serverVer:");
      ((StringBuilder)localObject1).append(j);
      c(((StringBuilder)localObject1).toString());
      if (i != j)
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
              c("handlePreloadTaskFromConfig empty content");
            }
          }
          if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null))
          {
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
            c();
          }
          long l = NetConnInfoCenter.getServerTimeMillis();
          paramConfig = new ArrayList();
          localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (PAAdPreloadTask)((Iterator)localObject1).next();
            if ((((PAAdPreloadTask)localObject3).mExpireTime <= l) || (!localArrayList.contains(localObject3))) {
              paramConfig.add(localObject3);
            }
          }
          ThreadManager.executeOnFileThread(new AdvertisementVideoPreloadManager.4(this, paramConfig));
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
          paramConfig = new StringBuilder();
          paramConfig.append("handlePreloadTaskFromConfig new taskSize:");
          paramConfig.append(localArrayList.size());
          c(paramConfig.toString());
          ThreadManager.executeOnSubThread(new AdvertisementVideoPreloadManager.5(this));
          paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
          paramQQAppInterface.putInt("public_account_ad_preload_task", j);
          paramQQAppInterface.apply();
          ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.6(this));
        }
        else
        {
          c("handlePreloadTaskFromConfig empty config");
        }
      }
      else {
        c("handlePreloadTaskFromConfig same version, no need to update");
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
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.c.clear();
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localObject != null)
    {
      ((TVK_ICacheMgr)localObject).stopCacheData(20170807);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.removePreloadCallback();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setOnPreLoadCompleteCallback(null);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementVideoPreloadManager$NetInfoHandler;
    if (localObject != null)
    {
      ((AdvertisementVideoPreloadManager.NetInfoHandler)localObject).a();
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementVideoPreloadManager$NetInfoHandler);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementVideoPreloadManager$NetInfoHandler = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager
 * JD-Core Version:    0.7.0.1
 */