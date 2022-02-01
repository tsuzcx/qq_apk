package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.app.Activity;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticlePatchStatus;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFullPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.CountDownCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class ReadInJoyPatchAdUtils
{
  public static int a;
  public static long a;
  public static String a;
  private static ArrayBlockingQueue<AdvertisementInfo> a;
  public static boolean a;
  public static int b;
  public static long b;
  private static ArrayBlockingQueue<AdvertisementInfo> b;
  public static boolean b;
  public static boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ReadInJoyPatchAdUtils";
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 3;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    c = false;
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
        a(1);
        localArrayBlockingQueue1 = localArrayBlockingQueue2;
      }
    }
    while (localArrayBlockingQueue1.size() <= 0)
    {
      return null;
      localArrayBlockingQueue2 = jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue;
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      if (localArrayBlockingQueue2.size() <= 2)
      {
        a(2);
        localArrayBlockingQueue1 = localArrayBlockingQueue2;
      }
    }
    return (AdvertisementInfo)localArrayBlockingQueue1.poll();
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
    for (;;)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.2(localAdRequestData));
      return;
      localAdRequestData.f = 3;
      localAdRequestData.e = 0;
    }
  }
  
  public static void a(Activity paramActivity, VideoUIManager paramVideoUIManager, VideoPlayManager paramVideoPlayManager, VideoFullPlayController paramVideoFullPlayController, VideoUIManager.CountDownCallback paramCountDownCallback, ReadInJoyPatchAdUtils.OnPatchPlayListener paramOnPatchPlayListener)
  {
    ReadInJoyPatchAdView localReadInJoyPatchAdView = paramVideoUIManager.a();
    if (localReadInJoyPatchAdView == null) {
      return;
    }
    localReadInJoyPatchAdView.setOnPatchAdListener(new ReadInJoyPatchAdUtils.3(localReadInJoyPatchAdView, paramActivity, paramVideoUIManager, paramVideoPlayManager, paramCountDownCallback, paramVideoFullPlayController, paramOnPatchPlayListener));
  }
  
  public static void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      paramVideoPlayParam.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
      return;
    }
    paramVideoPlayParam.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
  }
  
  public static void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoUIManager paramVideoUIManager, boolean paramBoolean, ReadInJoyPatchAdUtils.OnPatchPlayListener paramOnPatchPlayListener)
  {
    int j = 0;
    VideoUIManager localVideoUIManager = null;
    if (!b(paramVideoPlayParam, paramVideoUIManager)) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        if (paramBoolean)
        {
          paramVideoUIManager = paramVideoUIManager.a().a;
          localVideoUIManager = paramVideoUIManager;
          if (paramVideoUIManager != null) {
            break label71;
          }
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (paramOnPatchPlayListener != null)) {
          paramOnPatchPlayListener.a(paramVideoPlayParam, paramVideoUIManager);
        }
        return;
        paramVideoUIManager = a(1);
        break;
        label71:
        paramVideoUIManager = localVideoUIManager;
      }
    }
  }
  
  public static void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoUIManager paramVideoUIManager, boolean paramBoolean1, boolean paramBoolean2, VideoUIManager.CountDownCallback paramCountDownCallback, VideoFullPlayController paramVideoFullPlayController, ReadInJoyPatchAdUtils.OnPatchPlayListener paramOnPatchPlayListener)
  {
    int j = 1;
    Object localObject = null;
    if (!a(paramVideoPlayParam, paramVideoUIManager)) {
      j = 0;
    }
    int i = j;
    if (paramBoolean1)
    {
      i = j;
      if (c) {
        i = 0;
      }
    }
    j = i;
    AdvertisementInfo localAdvertisementInfo;
    if (i != 0)
    {
      if (!paramBoolean2) {
        break label116;
      }
      localAdvertisementInfo = paramVideoUIManager.a().a;
      if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mAdExtInfo != null))
      {
        localObject = localAdvertisementInfo;
        j = i;
        if (a(localAdvertisementInfo.mAdExtInfo, 2)) {}
      }
      else
      {
        j = 0;
        localObject = localAdvertisementInfo;
      }
    }
    if (j != 0) {
      paramOnPatchPlayListener.b(paramVideoPlayParam, localObject);
    }
    label116:
    while (paramCountDownCallback == null)
    {
      return;
      localAdvertisementInfo = a(2);
      break;
    }
    paramCountDownCallback.a(paramVideoUIManager.a());
    paramVideoFullPlayController.c();
  }
  
  public static void a(VideoUIManager paramVideoUIManager)
  {
    if (paramVideoUIManager.a() != null)
    {
      paramVideoUIManager.a().setVisibility(8);
      paramVideoUIManager.a().a();
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
            if (localJSONObject.optInt("postPatchAdNoFirst") == 1)
            {
              bool = true;
              c = bool;
              jdField_a_of_type_Int = localJSONObject.optInt("patchAdLimitMinutes");
              jdField_b_of_type_Int = localJSONObject.optInt("patchAdDisplaySeconds");
              return true;
            }
          }
          else
          {
            if (localJSONObject.optInt("patchAdType") != 2) {
              continue;
            }
            jdField_b_of_type_Boolean = true;
            jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue.offer(paramAdvertisementInfo);
            continue;
          }
        }
        else {
          return false;
        }
      }
      catch (Exception paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
      boolean bool = false;
    }
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((!paramBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3) || (paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam == null) || (paramVideoPlayParam.a == null)) {}
    while (paramVideoPlayParam.jdField_b_of_type_Long != 56L) {
      return false;
    }
    return true;
  }
  
  public static boolean a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoUIManager paramVideoUIManager)
  {
    int i = paramVideoPlayParam.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramVideoPlayParam, paramVideoUIManager);
  }
  
  public static boolean a(VideoUIManager paramVideoUIManager)
  {
    if ((paramVideoUIManager == null) || (paramVideoUIManager.a() == null)) {}
    while ((paramVideoUIManager.a() == null) || (paramVideoUIManager.a().getVisibility() != 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null) {
        return false;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        do
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramString = null;
          }
        } while (paramString.optInt("patchAdType") != paramInt);
        paramInt = paramString.optInt("patchAdLimitMinutes");
      } while (SystemClock.elapsedRealtime() - jdField_b_of_type_Long < paramInt * 60000);
    }
    return true;
  }
  
  public static void b()
  {
    jdField_a_of_type_Long = jdField_b_of_type_Long;
    jdField_b_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((!paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3)) {
      return false;
    }
    return true;
  }
  
  public static boolean b(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoUIManager paramVideoUIManager)
  {
    int i = paramVideoPlayParam.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramVideoPlayParam, paramVideoUIManager);
  }
  
  public static void c()
  {
    jdField_b_of_type_Long = jdField_a_of_type_Long;
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) || (paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)) {
      return false;
    }
    return true;
  }
  
  private static boolean c(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoUIManager paramVideoUIManager)
  {
    if (paramVideoPlayParam.jdField_b_of_type_Int <= 30) {}
    while ((paramVideoPlayParam.a.mChannelID != 56L) || (paramVideoPlayParam.jdField_b_of_type_Boolean) || ((paramVideoUIManager != null) && (paramVideoUIManager.a()))) {
      return false;
    }
    return true;
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
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils
 * JD-Core Version:    0.7.0.1
 */