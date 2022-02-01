package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.app.Activity;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJPatchAdUtilService;
import com.tencent.mobileqq.kandian.biz.feeds.api.CountDownCallback;
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFullPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.ArticlePatchStatus;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class ReadInJoyPatchAdUtils
{
  public static int a = 0;
  public static long a = 0L;
  public static String a = "ReadInJoyPatchAdUtils";
  private static ArrayBlockingQueue<AdvertisementInfo> a;
  public static boolean a = false;
  public static int b = 3;
  public static long b = 0L;
  private static ArrayBlockingQueue<AdvertisementInfo> b;
  public static boolean b = false;
  public static boolean c = false;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue = new ArrayBlockingQueue(10);
    jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue = new ArrayBlockingQueue(10);
  }
  
  public static int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("patchAdDisplaySeconds");
  }
  
  public static AdvertisementInfo a(int paramInt)
  {
    ArrayBlockingQueue localArrayBlockingQueue2;
    ArrayBlockingQueue localArrayBlockingQueue1;
    if (paramInt == 1)
    {
      localArrayBlockingQueue2 = jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue;
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      if (localArrayBlockingQueue2.size() <= 2)
      {
        ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).requestPatchAd(1);
        localArrayBlockingQueue1 = localArrayBlockingQueue2;
      }
    }
    else
    {
      localArrayBlockingQueue2 = jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue;
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      if (localArrayBlockingQueue2.size() <= 2)
      {
        ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).requestPatchAd(2);
        localArrayBlockingQueue1 = localArrayBlockingQueue2;
      }
    }
    if (localArrayBlockingQueue1.size() <= 0) {
      return null;
    }
    return (AdvertisementInfo)localArrayBlockingQueue1.poll();
  }
  
  private static ReadInJoyPatchAdView a(IVideoUIManager paramIVideoUIManager)
  {
    if ((paramIVideoUIManager.a() != null) && ((paramIVideoUIManager.a() instanceof ReadInJoyPatchAdView))) {
      return (ReadInJoyPatchAdView)paramIVideoUIManager.a();
    }
    return null;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.clear();
    jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue.clear();
  }
  
  public static void a(int paramInt)
  {
    AdRequestData localAdRequestData = new AdRequestData();
    localAdRequestData.d = 1;
    if (paramInt == 1)
    {
      localAdRequestData.e = 3;
      localAdRequestData.f = 0;
    }
    else
    {
      localAdRequestData.f = 3;
      localAdRequestData.e = 0;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.2(localAdRequestData));
  }
  
  public static void a(Activity paramActivity, IVideoUIManager paramIVideoUIManager, IVideoPlayManager paramIVideoPlayManager, IVideoFullPlayController paramIVideoFullPlayController, CountDownCallback paramCountDownCallback, OnPatchPlayListener paramOnPatchPlayListener)
  {
    ReadInJoyPatchAdView localReadInJoyPatchAdView = a(paramIVideoUIManager);
    if (localReadInJoyPatchAdView == null) {
      return;
    }
    localReadInJoyPatchAdView.setOnPatchAdListener(new ReadInJoyPatchAdUtils.3(localReadInJoyPatchAdView, paramActivity, paramIVideoUIManager, paramIVideoPlayManager, paramCountDownCallback, paramIVideoFullPlayController, paramOnPatchPlayListener));
  }
  
  public static void a(IVideoUIManager paramIVideoUIManager)
  {
    paramIVideoUIManager = a(paramIVideoUIManager);
    if (paramIVideoUIManager != null)
    {
      paramIVideoUIManager.setVisibility(8);
      paramIVideoUIManager.a();
    }
  }
  
  public static void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      paramVideoPlayParam.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
      return;
    }
    paramVideoPlayParam.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
  }
  
  public static void a(VideoPlayParam paramVideoPlayParam, IVideoUIManager paramIVideoUIManager, boolean paramBoolean, OnPatchPlayListener paramOnPatchPlayListener)
  {
    boolean bool2 = b(paramVideoPlayParam, paramIVideoUIManager);
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = bool2;
    if (bool2)
    {
      if (paramBoolean)
      {
        localObject1 = a(paramIVideoUIManager);
        paramIVideoUIManager = localObject2;
        if (localObject1 != null) {
          paramIVideoUIManager = ((ReadInJoyPatchAdView)localObject1).a;
        }
      }
      else
      {
        paramIVideoUIManager = ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).getPatchAd(1);
      }
      bool1 = bool2;
      localObject1 = paramIVideoUIManager;
      if (paramIVideoUIManager == null)
      {
        bool1 = false;
        localObject1 = paramIVideoUIManager;
      }
    }
    if ((bool1) && (paramOnPatchPlayListener != null)) {
      paramOnPatchPlayListener.a(paramVideoPlayParam, (AdvertisementInfo)localObject1);
    }
  }
  
  public static void a(VideoPlayParam paramVideoPlayParam, IVideoUIManager paramIVideoUIManager, boolean paramBoolean1, boolean paramBoolean2, CountDownCallback paramCountDownCallback, IVideoFullPlayController paramIVideoFullPlayController, OnPatchPlayListener paramOnPatchPlayListener)
  {
    boolean bool2 = a(paramVideoPlayParam, paramIVideoUIManager);
    boolean bool1 = bool2;
    if (paramBoolean1)
    {
      bool1 = bool2;
      if (c) {
        bool1 = false;
      }
    }
    Object localObject = null;
    AdvertisementInfo localAdvertisementInfo = null;
    paramBoolean1 = bool1;
    if (bool1)
    {
      if (paramBoolean2)
      {
        localObject = a(paramIVideoUIManager);
        if (localObject != null) {
          localAdvertisementInfo = ((ReadInJoyPatchAdView)localObject).a;
        }
      }
      else
      {
        localAdvertisementInfo = ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).getPatchAd(2);
      }
      if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mAdExtInfo != null))
      {
        paramBoolean1 = bool1;
        localObject = localAdvertisementInfo;
        if (((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).inFrequentController(localAdvertisementInfo.mAdExtInfo, 2)) {}
      }
      else
      {
        paramBoolean1 = false;
        localObject = localAdvertisementInfo;
      }
    }
    if (paramBoolean1)
    {
      paramOnPatchPlayListener.b(paramVideoPlayParam, (AdvertisementInfo)localObject);
      return;
    }
    if (paramCountDownCallback != null)
    {
      paramCountDownCallback.a(paramIVideoUIManager.a());
      paramIVideoFullPlayController.a();
    }
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
        if (localJSONObject.has("patchAdType"))
        {
          if (localJSONObject.optInt("patchAdType") == 1)
          {
            jdField_a_of_type_Boolean = true;
            jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.offer(paramAdvertisementInfo);
          }
          else if (localJSONObject.optInt("patchAdType") == 2)
          {
            jdField_b_of_type_Boolean = true;
            jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue.offer(paramAdvertisementInfo);
          }
          if (localJSONObject.optInt("postPatchAdNoFirst") != 1) {
            break label114;
          }
          bool = true;
          c = bool;
          jdField_a_of_type_Int = localJSONObject.optInt("patchAdLimitMinutes");
          jdField_b_of_type_Int = localJSONObject.optInt("patchAdDisplaySeconds");
          return true;
        }
      }
      catch (Exception paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
      return false;
      label114:
      boolean bool = false;
    }
  }
  
  public static boolean a(IVideoUIManager paramIVideoUIManager)
  {
    paramIVideoUIManager = a(paramIVideoUIManager);
    return (paramIVideoUIManager != null) && (paramIVideoUIManager.getVisibility() == 0);
  }
  
  public static boolean a(VideoPlayParam paramVideoPlayParam)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVideoPlayParam != null)
    {
      if (paramVideoPlayParam.a == null) {
        return false;
      }
      bool1 = bool2;
      if (paramVideoPlayParam.jdField_b_of_type_Long == 56L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(VideoPlayParam paramVideoPlayParam, IVideoUIManager paramIVideoUIManager)
  {
    int i = paramVideoPlayParam.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramVideoPlayParam, paramIVideoUIManager);
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    try
    {
      paramString = new JSONObject(paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    if (paramString.optInt("patchAdType") != paramInt) {
      return false;
    }
    paramInt = paramString.optInt("patchAdLimitMinutes");
    if (SystemClock.elapsedRealtime() - jdField_b_of_type_Long >= paramInt * 60000) {
      bool = true;
    }
    return bool;
  }
  
  public static void b()
  {
    jdField_a_of_type_Long = jdField_b_of_type_Long;
    jdField_b_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public static boolean b(VideoPlayParam paramVideoPlayParam, IVideoUIManager paramIVideoUIManager)
  {
    int i = paramVideoPlayParam.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramVideoPlayParam, paramIVideoUIManager);
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void c()
  {
    jdField_b_of_type_Long = jdField_a_of_type_Long;
  }
  
  private static boolean c(VideoPlayParam paramVideoPlayParam, IVideoUIManager paramIVideoUIManager)
  {
    int i = paramVideoPlayParam.jdField_b_of_type_Int;
    boolean bool = false;
    if (i <= 30) {
      return false;
    }
    if (paramVideoPlayParam.a.mChannelID != 56L) {
      return false;
    }
    if (paramVideoPlayParam.jdField_b_of_type_Boolean) {
      return false;
    }
    if ((paramIVideoUIManager == null) || (!paramIVideoUIManager.a())) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!paramAbsBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void d()
  {
    Object localObject = jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue;
    ArrayBlockingQueue localArrayBlockingQueue = jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue;
    if ((((ArrayBlockingQueue)localObject).size() <= 2) || (localArrayBlockingQueue.size() <= 2))
    {
      localObject = new AdRequestData();
      ((AdRequestData)localObject).d = 1;
      ((AdRequestData)localObject).e = 3;
      ((AdRequestData)localObject).f = 3;
      ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.1((AdRequestData)localObject));
    }
  }
  
  public static boolean d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!paramAbsBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils
 * JD-Core Version:    0.7.0.1
 */