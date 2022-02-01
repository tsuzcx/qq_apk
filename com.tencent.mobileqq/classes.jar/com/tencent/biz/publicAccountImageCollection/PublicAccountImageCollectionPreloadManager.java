package com.tencent.biz.publicAccountImageCollection;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ac.ArticleComment.GetPhotoCollectionInfoResponse;
import com.tencent.mobileqq.ac.ArticleComment.PhotoFirstItemInfo;
import com.tencent.mobileqq.ac.ArticleComment.PhotoItemInfo;
import com.tencent.mobileqq.ac.ArticleComment.RetInfo;
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

public class PublicAccountImageCollectionPreloadManager
{
  private static PublicAccountImageCollectionPreloadManager jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager;
  private static String jdField_a_of_type_JavaLangString = "PublicAccountImageCollectionPreloadManager";
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public MQLruCache<String, PublicAccountImageCollectionUtils.PhotoCollectionInfo> a;
  private PublicAccountArticleObserver jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver;
  Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, String> a;
  private List<String> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  volatile boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  private PublicAccountArticleObserver jdField_b_of_type_ComTencentBizPubaccountPublicAccountArticleObserver;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private List<String> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  int c = 0;
  
  private PublicAccountImageCollectionPreloadManager()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(30);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static PublicAccountImageCollectionPreloadManager a()
  {
    if (jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager == null) {
      jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager = new PublicAccountImageCollectionPreloadManager();
    }
    return jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager;
  }
  
  private PublicAccountImageCollectionUtils.PhotoCollectionInfo a(ArticleComment.GetPhotoCollectionInfoResponse paramGetPhotoCollectionInfoResponse, String paramString)
  {
    PublicAccountImageCollectionUtils.PhotoCollectionInfo localPhotoCollectionInfo = new PublicAccountImageCollectionUtils.PhotoCollectionInfo();
    if (paramGetPhotoCollectionInfoResponse.ret.has())
    {
      if (paramGetPhotoCollectionInfoResponse.article_share_url.has()) {
        localPhotoCollectionInfo.jdField_b_of_type_JavaLangString = paramGetPhotoCollectionInfoResponse.article_share_url.get().toStringUtf8();
      }
      if (paramGetPhotoCollectionInfoResponse.puin.has()) {
        localPhotoCollectionInfo.c = (paramGetPhotoCollectionInfoResponse.puin.get() + "");
      }
      if (paramGetPhotoCollectionInfoResponse.article_img_url.has()) {
        localPhotoCollectionInfo.d = paramGetPhotoCollectionInfoResponse.article_img_url.get().toStringUtf8();
      }
      if (paramGetPhotoCollectionInfoResponse.article_title.has()) {
        localPhotoCollectionInfo.e = paramGetPhotoCollectionInfoResponse.article_title.get().toStringUtf8();
      }
      if (paramGetPhotoCollectionInfoResponse.enable_comment.has()) {
        localPhotoCollectionInfo.jdField_a_of_type_Int = paramGetPhotoCollectionInfoResponse.enable_comment.get();
      }
      if (paramGetPhotoCollectionInfoResponse.comment_url.has()) {
        localPhotoCollectionInfo.f = paramGetPhotoCollectionInfoResponse.comment_url.get().toStringUtf8();
      }
      if (paramGetPhotoCollectionInfoResponse.firstItem.has())
      {
        localPhotoCollectionInfo.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoFirstItemInfo = new PublicAccountImageCollectionUtils.PhotoFirstItemInfo();
        localPhotoCollectionInfo.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoFirstItemInfo.jdField_a_of_type_JavaLangString = paramGetPhotoCollectionInfoResponse.firstItem.url.get().toStringUtf8();
        localPhotoCollectionInfo.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoFirstItemInfo.d = paramGetPhotoCollectionInfoResponse.firstItem.photo_author_name.get().toStringUtf8();
        localPhotoCollectionInfo.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoFirstItemInfo.c = paramGetPhotoCollectionInfoResponse.firstItem.photo_time.get().toStringUtf8();
        localPhotoCollectionInfo.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoFirstItemInfo.jdField_b_of_type_JavaLangString = paramGetPhotoCollectionInfoResponse.firstItem.publicaccount_name.get().toStringUtf8();
      }
      if ((paramGetPhotoCollectionInfoResponse.item.has()) && (paramGetPhotoCollectionInfoResponse.item.get().size() > 0))
      {
        localPhotoCollectionInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        int j = paramGetPhotoCollectionInfoResponse.item.get().size();
        int i = 0;
        while (i < j)
        {
          PublicAccountImageCollectionUtils.PhotoItemInfo localPhotoItemInfo = new PublicAccountImageCollectionUtils.PhotoItemInfo();
          localPhotoItemInfo.jdField_a_of_type_JavaLangString = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).url.get().toStringUtf8();
          localPhotoItemInfo.jdField_b_of_type_JavaLangString = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).content.get().toStringUtf8();
          localPhotoItemInfo.c = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).static_url.get().toStringUtf8();
          localPhotoItemInfo.jdField_a_of_type_Int = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).width.get();
          localPhotoItemInfo.jdField_b_of_type_Int = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).height.get();
          localPhotoCollectionInfo.jdField_a_of_type_JavaUtilArrayList.add(localPhotoItemInfo);
          i += 1;
        }
      }
      localPhotoCollectionInfo.jdField_a_of_type_JavaLangString = paramString;
    }
    return localPhotoCollectionInfo;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    ThreadManager.postImmediately(new PublicAccountImageCollectionPreloadManager.4(this, paramString, paramArrayOfByte), null, true);
  }
  
  private void a(List<String> paramList)
  {
    ThreadManager.post(new PublicAccountImageCollectionPreloadManager.5(this, paramList), 5, null, true);
  }
  
  private void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (FileUtils.b(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD + paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "loadPhotoCollectionInfo file exist");
      }
      c(paramString);
      return;
    }
    d(paramString);
  }
  
  private boolean b()
  {
    int i = NetworkState.getNetworkType();
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_b_of_type_Int == 1) {
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 4) {}
      }
      else
      {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "canPreloadImage is " + bool1);
      }
      return bool1;
      bool1 = bool2;
      if (this.jdField_b_of_type_Int == 2)
      {
        bool1 = bool2;
        if (i == 1) {
          bool1 = true;
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    ThreadManager.executeOnFileThread(new PublicAccountImageCollectionPreloadManager.ReadFileThread(this, paramString));
  }
  
  private void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "loadPhotoCollectionInfoFromServer articleId = " + paramString);
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      PublicAccountArticleHandler localPublicAccountArticleHandler = (PublicAccountArticleHandler)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_HANDLER);
      if (this.jdField_b_of_type_ComTencentBizPubaccountPublicAccountArticleObserver == null)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountPublicAccountArticleObserver = new PublicAccountImageCollectionPreloadManager.2(this, l);
        localPublicAccountArticleHandler.a(this.jdField_b_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
      }
      ThreadManager.executeOnSubThread(new PublicAccountImageCollectionPreloadManager.3(this, localPublicAccountArticleHandler, paramString));
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_b_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  public int a()
  {
    return this.c;
  }
  
  public PublicAccountImageCollectionUtils.PhotoCollectionInfo a(String paramString)
  {
    paramString = (PublicAccountImageCollectionUtils.PhotoCollectionInfo)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
    if (paramString != null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getPhotoCollectionInfoFromCache articleId =" + paramString.jdField_a_of_type_JavaLangString);
      }
    }
    while (!QLog.isColorLevel()) {
      return paramString;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getPhotoCollectionInfoFromCache info is null");
    return paramString;
  }
  
  public void a()
  {
    ThreadManager.executeOnSubThread(new PublicAccountImageCollectionPreloadManager.PreloadProtoThread(this));
  }
  
  public void a(PublicAccountArticleObserver paramPublicAccountArticleObserver)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountPublicAccountArticleObserver = paramPublicAccountArticleObserver;
  }
  
  void a(PublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PublicAccountImageCollectionPreloadManager.1(this, paramPhotoCollectionInfo));
  }
  
  public void a(PublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramPhotoCollectionInfo.jdField_a_of_type_JavaLangString, paramPhotoCollectionInfo);
    a(paramPhotoCollectionInfo.jdField_a_of_type_JavaLangString, paramArrayOfByte);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "add Task articleID:" + paramString);
    }
    ??? = a(paramString);
    if (??? != null)
    {
      b((PublicAccountImageCollectionUtils.PhotoCollectionInfo)???);
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilList.add(paramString);
        if (!this.jdField_a_of_type_Boolean) {
          e();
        }
      }
      return;
    }
  }
  
  public void a(String paramString, PublicAccountArticleObserver paramPublicAccountArticleObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getPhotoCollectionInfoFromFile");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver = paramPublicAccountArticleObserver;
    c(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "eventPAAlbumRequestAlbumHitStatics", paramBoolean, 0L, 0L, null, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("\n");
      localStringBuilder.append("doStatisticReportForProtoHit-->success = ").append(paramBoolean);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("photo_index", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "eventPAAlbumCacheHitStatics", paramBoolean, 0L, 0L, (HashMap)localObject, "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("\n");
      ((StringBuilder)localObject).append("doStatisticReportForImageHit-->success = ").append(paramBoolean).append(" ,photoIndex = ").append(paramInt);
      QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    paramLong = NetConnInfoCenter.getServerTimeMillis() - paramLong;
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "eventPAAlbumRequestAlbumTime", paramBoolean, paramLong, 0L, null, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("\n");
      localStringBuilder.append("doStatisticReportForProtoTime-->success = ").append(paramBoolean).append(" ,costTime = " + paramLong);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    if (NetworkState.isNetSupport())
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0);
      this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("album_predown_enable", 0);
      this.jdField_b_of_type_Int = ((SharedPreferences)localObject).getInt("album_predown_photo_rule", 0);
      this.c = ((SharedPreferences)localObject).getInt("album_predown_slide_photocounts", 0);
      if (this.jdField_a_of_type_Int != 1) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "canPreload is " + bool);
      }
      return bool;
    }
  }
  
  public void b()
  {
    this.jdField_b_of_type_ComTencentBizPubaccountPublicAccountArticleObserver = null;
  }
  
  public void b(PublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo)
  {
    if (!b()) {}
    for (;;)
    {
      return;
      LinkedList localLinkedList = new LinkedList();
      if (this.jdField_a_of_type_JavaUtilHashMap.get(paramPhotoCollectionInfo.jdField_a_of_type_JavaLangString) == null) {}
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        PublicAccountImageCollectionUtils.PhotoFirstItemInfo localPhotoFirstItemInfo = paramPhotoCollectionInfo.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoFirstItemInfo;
        if ((localPhotoFirstItemInfo != null) && (localPhotoFirstItemInfo.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(localPhotoFirstItemInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramPhotoCollectionInfo.jdField_a_of_type_JavaLangString, localPhotoFirstItemInfo.jdField_a_of_type_JavaLangString);
          localLinkedList.add(localPhotoFirstItemInfo.jdField_a_of_type_JavaLangString);
        }
        if (localLinkedList == null) {
          continue;
        }
        a(localLinkedList);
        return;
      }
    }
  }
  
  public void b(boolean paramBoolean, long paramLong)
  {
    paramLong = NetConnInfoCenter.getServerTimeMillis() - paramLong;
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "eventPAAlbumPreDownPhotoTime", paramBoolean, paramLong, 0L, null, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("\n");
      localStringBuilder.append("doStatisticReportForImageTime-->success = ").append(paramBoolean).append(" ,costTime = " + paramLong);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
  }
  
  public void d()
  {
    ThreadManager.post(new PublicAccountImageCollectionPreloadManager.6(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager
 * JD-Core Version:    0.7.0.1
 */