package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoFirstItemInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import tencent.im.oidb.ac.ArticleComment.GetPhotoCollectionInfoResponse;
import tencent.im.oidb.ac.ArticleComment.PhotoFirstItemInfo;
import tencent.im.oidb.ac.ArticleComment.PhotoItemInfo;
import tencent.im.oidb.ac.ArticleComment.RetInfo;

public class PublicAccountImageCollectionPreloadManagerImpl
  implements IPublicAccountImageCollectionPreloadManager
{
  public static final int DELETETIME = 172800000;
  private static final int MAX_CACHE_SIZE = 30;
  private static String TAG = "PublicAccountImageCollectionPreloadManager";
  private Object downloadTaskLock = new Object();
  int imageCollectionPreload = 0;
  int imageCollectionPreloadCover = 0;
  int imageCollectionPreloadImage = 0;
  public HashMap<String, String> imgMap = new HashMap();
  volatile boolean isProtoDoingWork;
  Object lock = new Object();
  Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
  private IPublicAccountArticleObserver mObserver;
  private IPublicAccountArticleObserver mPublicAccountArticleObserver;
  public MQLruCache<String, IPublicAccountImageCollectionUtils.PhotoCollectionInfo> photoCollectionInfoCache = new MQLruCache(30);
  private List<String> waitingList = new CopyOnWriteArrayList();
  private List<String> workingList = new CopyOnWriteArrayList();
  
  private boolean canPreloadImaga()
  {
    int i = NetworkState.getNetworkType();
    int j = this.imageCollectionPreloadCover;
    boolean bool2 = true;
    if (j == 1)
    {
      bool1 = bool2;
      if (i == 1) {
        break label54;
      }
      if (i == 4)
      {
        bool1 = bool2;
        break label54;
      }
    }
    else if ((j == 2) && (i == 1))
    {
      bool1 = bool2;
      break label54;
    }
    boolean bool1 = false;
    label54:
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canPreloadImage is ");
      localStringBuilder.append(bool1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  private IPublicAccountImageCollectionUtils.PhotoCollectionInfo convertDataToPhotoCollectionInfo(ArticleComment.GetPhotoCollectionInfoResponse paramGetPhotoCollectionInfoResponse, String paramString)
  {
    IPublicAccountImageCollectionUtils.PhotoCollectionInfo localPhotoCollectionInfo = new IPublicAccountImageCollectionUtils.PhotoCollectionInfo();
    if (paramGetPhotoCollectionInfoResponse.ret.has())
    {
      if (paramGetPhotoCollectionInfoResponse.article_share_url.has()) {
        localPhotoCollectionInfo.b = paramGetPhotoCollectionInfoResponse.article_share_url.get().toStringUtf8();
      }
      Object localObject;
      if (paramGetPhotoCollectionInfoResponse.puin.has())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramGetPhotoCollectionInfoResponse.puin.get());
        ((StringBuilder)localObject).append("");
        localPhotoCollectionInfo.c = ((StringBuilder)localObject).toString();
      }
      if (paramGetPhotoCollectionInfoResponse.article_img_url.has()) {
        localPhotoCollectionInfo.d = paramGetPhotoCollectionInfoResponse.article_img_url.get().toStringUtf8();
      }
      if (paramGetPhotoCollectionInfoResponse.article_title.has()) {
        localPhotoCollectionInfo.e = paramGetPhotoCollectionInfoResponse.article_title.get().toStringUtf8();
      }
      if (paramGetPhotoCollectionInfoResponse.enable_comment.has()) {
        localPhotoCollectionInfo.f = paramGetPhotoCollectionInfoResponse.enable_comment.get();
      }
      if (paramGetPhotoCollectionInfoResponse.comment_url.has()) {
        localPhotoCollectionInfo.g = paramGetPhotoCollectionInfoResponse.comment_url.get().toStringUtf8();
      }
      if (paramGetPhotoCollectionInfoResponse.firstItem.has())
      {
        localPhotoCollectionInfo.h = new IPublicAccountImageCollectionUtils.PhotoFirstItemInfo();
        localPhotoCollectionInfo.h.a = paramGetPhotoCollectionInfoResponse.firstItem.url.get().toStringUtf8();
        localPhotoCollectionInfo.h.d = paramGetPhotoCollectionInfoResponse.firstItem.photo_author_name.get().toStringUtf8();
        localPhotoCollectionInfo.h.c = paramGetPhotoCollectionInfoResponse.firstItem.photo_time.get().toStringUtf8();
        localPhotoCollectionInfo.h.b = paramGetPhotoCollectionInfoResponse.firstItem.publicaccount_name.get().toStringUtf8();
      }
      if ((paramGetPhotoCollectionInfoResponse.item.has()) && (paramGetPhotoCollectionInfoResponse.item.get().size() > 0))
      {
        localPhotoCollectionInfo.i = new ArrayList();
        int j = paramGetPhotoCollectionInfoResponse.item.get().size();
        int i = 0;
        while (i < j)
        {
          localObject = new IPublicAccountImageCollectionUtils.PhotoItemInfo();
          ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject).a = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).url.get().toStringUtf8();
          ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject).b = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).content.get().toStringUtf8();
          ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject).c = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).static_url.get().toStringUtf8();
          ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject).d = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).width.get();
          ((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject).e = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).height.get();
          localPhotoCollectionInfo.i.add(localObject);
          i += 1;
        }
      }
      localPhotoCollectionInfo.a = paramString;
    }
    return localPhotoCollectionInfo;
  }
  
  private void loadPhotoCollectionInfo(String paramString)
  {
    if (paramString == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD);
    localStringBuilder.append(paramString);
    if (FileUtils.fileExistsAndNotEmpty(localStringBuilder.toString()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "loadPhotoCollectionInfo file exist");
      }
      preloadFileToCache(paramString);
      return;
    }
    loadPhotoCollectionInfoFromServer(paramString);
  }
  
  private void loadPhotoCollectionInfoFromServer(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadPhotoCollectionInfoFromServer articleId = ");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      Object localObject = (IPublicAccountArticleHandler)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_HANDLER);
      if (this.mPublicAccountArticleObserver == null)
      {
        this.mPublicAccountArticleObserver = ((IPublicAccountArticleObserver)QRoute.api(IPublicAccountArticleObserver.class));
        this.mPublicAccountArticleObserver.setOnCallback(new PublicAccountImageCollectionPreloadManagerImpl.2(this, l));
        ((IPublicAccountArticleHandler)localObject).setPublicAccountArticleObserver(this.mPublicAccountArticleObserver);
      }
      ThreadManager.executeOnSubThread(new PublicAccountImageCollectionPreloadManagerImpl.3(this, (IPublicAccountArticleHandler)localObject, paramString));
    }
  }
  
  private void preloadFileToCache(String paramString)
  {
    ThreadManager.executeOnFileThread(new PublicAccountImageCollectionPreloadManagerImpl.ReadFileThread(this, paramString));
  }
  
  private void preloadImage(List<String> paramList)
  {
    ThreadManager.post(new PublicAccountImageCollectionPreloadManagerImpl.5(this, paramList), 5, null, true);
  }
  
  private void saveImageCollectionInfoToFile(String paramString, byte[] paramArrayOfByte)
  {
    ThreadManager.postImmediately(new PublicAccountImageCollectionPreloadManagerImpl.4(this, paramString, paramArrayOfByte), null, true);
  }
  
  private void startWork()
  {
    this.workingList.addAll(this.waitingList);
    this.waitingList.clear();
    this.isProtoDoingWork = true;
    preloadProto();
  }
  
  public void addTask(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add Task articleID:");
      localStringBuilder.append(paramString);
      QLog.d((String)???, 2, localStringBuilder.toString());
    }
    ??? = getPhotoCollectionInfoFromCache(paramString);
    if (??? != null)
    {
      preloadImage((IPublicAccountImageCollectionUtils.PhotoCollectionInfo)???);
      return;
    }
    synchronized (this.lock)
    {
      if (!this.waitingList.contains(paramString))
      {
        this.waitingList.add(paramString);
        if (!this.isProtoDoingWork) {
          startWork();
        }
      }
      return;
    }
  }
  
  public boolean canPreload()
  {
    boolean bool2 = NetworkState.isNetSupport();
    boolean bool1 = true;
    Object localObject1;
    Object localObject2;
    if (bool2)
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject2 = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_public_account_with_cuin_");
      localStringBuilder.append(((QQAppInterface)localObject1).getCurrentAccountUin());
      localObject1 = ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
      this.imageCollectionPreload = ((SharedPreferences)localObject1).getInt("album_predown_enable", 0);
      this.imageCollectionPreloadCover = ((SharedPreferences)localObject1).getInt("album_predown_photo_rule", 0);
      this.imageCollectionPreloadImage = ((SharedPreferences)localObject1).getInt("album_predown_slide_photocounts", 0);
      if (this.imageCollectionPreload == 1) {}
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("canPreload is ");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return bool1;
  }
  
  public void cancelNotDownloadTask()
  {
    synchronized (this.downloadTaskLock)
    {
      this.waitingList.clear();
      this.workingList.clear();
      this.imgMap.clear();
      return;
    }
  }
  
  public void checkDelDir()
  {
    ThreadManager.post(new PublicAccountImageCollectionPreloadManagerImpl.6(this), 5, null, false);
  }
  
  public void doStatisticReportForImageHit(boolean paramBoolean, int paramInt)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("photo_index", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "eventPAAlbumCacheHitStatics", paramBoolean, 0L, 0L, (HashMap)localObject, "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("\n");
      ((StringBuilder)localObject).append("doStatisticReportForImageHit-->success = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" ,photoIndex = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d(TAG, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void doStatisticReportForImageTime(boolean paramBoolean, long paramLong)
  {
    paramLong = NetConnInfoCenter.getServerTimeMillis() - paramLong;
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "eventPAAlbumPreDownPhotoTime", paramBoolean, paramLong, 0L, null, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder("\n");
      localStringBuilder1.append("doStatisticReportForImageTime-->success = ");
      localStringBuilder1.append(paramBoolean);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" ,costTime = ");
      localStringBuilder2.append(paramLong);
      localStringBuilder1.append(localStringBuilder2.toString());
      QLog.d(TAG, 2, localStringBuilder1.toString());
    }
  }
  
  public void doStatisticReportForProtoHit(boolean paramBoolean)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "eventPAAlbumRequestAlbumHitStatics", paramBoolean, 0L, 0L, null, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("\n");
      localStringBuilder.append("doStatisticReportForProtoHit-->success = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(TAG, 2, localStringBuilder.toString());
    }
  }
  
  public void doStatisticReportForProtoTime(boolean paramBoolean, long paramLong)
  {
    paramLong = NetConnInfoCenter.getServerTimeMillis() - paramLong;
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "eventPAAlbumRequestAlbumTime", paramBoolean, paramLong, 0L, null, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder("\n");
      localStringBuilder1.append("doStatisticReportForProtoTime-->success = ");
      localStringBuilder1.append(paramBoolean);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" ,costTime = ");
      localStringBuilder2.append(paramLong);
      localStringBuilder1.append(localStringBuilder2.toString());
      QLog.d(TAG, 2, localStringBuilder1.toString());
    }
  }
  
  public IPublicAccountImageCollectionUtils.PhotoCollectionInfo getPhotoCollectionInfoFromCache(String paramString)
  {
    paramString = (IPublicAccountImageCollectionUtils.PhotoCollectionInfo)this.photoCollectionInfoCache.get(paramString);
    if (paramString != null)
    {
      if (QLog.isColorLevel())
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPhotoCollectionInfoFromCache articleId =");
        localStringBuilder.append(paramString.a);
        QLog.d(str, 2, localStringBuilder.toString());
        return paramString;
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getPhotoCollectionInfoFromCache info is null");
    }
    return paramString;
  }
  
  public void getPhotoCollectionInfoFromFile(String paramString, IPublicAccountArticleObserver paramIPublicAccountArticleObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getPhotoCollectionInfoFromFile");
    }
    this.mObserver = paramIPublicAccountArticleObserver;
    preloadFileToCache(paramString);
  }
  
  public int getPreloadImageCount()
  {
    return this.imageCollectionPreloadImage;
  }
  
  void notifyUIToRefresh(IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo)
  {
    this.mMainThreadHandler.post(new PublicAccountImageCollectionPreloadManagerImpl.1(this, paramPhotoCollectionInfo));
  }
  
  public void preloadImage(IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo)
  {
    if (!canPreloadImaga()) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    if (this.imgMap.get(paramPhotoCollectionInfo.a) == null) {
      synchronized (this.downloadTaskLock)
      {
        IPublicAccountImageCollectionUtils.PhotoFirstItemInfo localPhotoFirstItemInfo = paramPhotoCollectionInfo.h;
        if ((localPhotoFirstItemInfo != null) && (localPhotoFirstItemInfo.a != null) && (!TextUtils.isEmpty(localPhotoFirstItemInfo.a)))
        {
          this.imgMap.put(paramPhotoCollectionInfo.a, localPhotoFirstItemInfo.a);
          localLinkedList.add(localPhotoFirstItemInfo.a);
        }
      }
    }
    preloadImage(localLinkedList);
  }
  
  public void preloadProto()
  {
    ThreadManager.executeOnSubThread(new PublicAccountImageCollectionPreloadManagerImpl.PreloadProtoThread(this));
  }
  
  public void removeObserver()
  {
    this.mPublicAccountArticleObserver = null;
  }
  
  public void saveImageCollectionInfo(IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo, byte[] paramArrayOfByte)
  {
    this.photoCollectionInfoCache.put(paramPhotoCollectionInfo.a, paramPhotoCollectionInfo);
    saveImageCollectionInfoToFile(paramPhotoCollectionInfo.a, paramArrayOfByte);
  }
  
  public void setObserver(IPublicAccountArticleObserver paramIPublicAccountArticleObserver)
  {
    this.mPublicAccountArticleObserver = paramIPublicAccountArticleObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl
 * JD-Core Version:    0.7.0.1
 */