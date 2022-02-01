package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoAdTimeLoadManager
{
  private static SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray;
  public static CopyOnWriteArrayList<VideoInfo> a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList;
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new VideoAdTimeLoadManager.1(this, Looper.getMainLooper());
  private VideoFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 2;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public VideoAdTimeLoadManager(VideoFeedsAdapter paramVideoFeedsAdapter, ArrayList<VideoInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public static int a()
  {
    if ((jdField_b_of_type_JavaUtilArrayList != null) && (jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
      return ((Integer)jdField_b_of_type_JavaUtilArrayList.get(jdField_b_of_type_JavaUtilArrayList.size() - 1)).intValue();
    }
    return 0;
  }
  
  private int a(int paramInt)
  {
    Integer localInteger = (Integer)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, Integer.valueOf(0));
      return 0;
    }
    return localInteger.intValue();
  }
  
  public static ArrayList<VideoInfo> a(ArrayList<VideoInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)paramArrayList.next();
        if (localVideoInfo.jdField_c_of_type_Boolean) {
          localArrayList.add(localVideoInfo);
        }
      }
    }
    if (localArrayList.size() > 0) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(localArrayList);
    }
    return localArrayList;
  }
  
  public static void a(int paramInt)
  {
    if (paramInt != 88888888) {
      return;
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
  }
  
  public static void a(int paramInt, ArrayList<AdvertisementInfo> paramArrayList)
  {
    if ((paramInt != 88888888) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramArrayList.next();
      VideoInfo localVideoInfo = VideoAdExposureManager.a(localAdvertisementInfo, false);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localVideoInfo);
      localStringBuilder.append(localAdvertisementInfo.mTitle + "---");
    }
    ReadInJoyAdLog.a("VideoAdTimeLoadManager", "onAsyncDataReady :" + localStringBuilder.toString());
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter == null) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt))
    {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "Invalid parameter");
      return false;
    }
    if (((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_c_of_type_Boolean)
    {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", paramInt + " has adVideo");
      return true;
    }
    return false;
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter == null) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt))
    {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "Invalid parameter");
      return false;
    }
    int i = a();
    if ((i > 0) && (paramInt - i < VideoAdStrategyManager.e + 1) && (!paramBoolean))
    {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "not meet adProtectGap");
      return false;
    }
    if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
    {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "article size = " + this.jdField_a_of_type_JavaUtilArrayList.size() + " but  pos = " + paramInt);
      return false;
    }
    if (a(paramInt))
    {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "shouldInsert not allow insert！");
      return false;
    }
    if ((paramBoolean) && (i != 0) && (i == this.jdField_a_of_type_Int))
    {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "insertAd not allow insert vv default");
      return false;
    }
    return true;
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if ((!paramBoolean) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1))
    {
      localStringBuilder = new StringBuilder().append("repeat startPlay, so return isMainThread : ");
      if (Looper.myLooper() == Looper.getMainLooper()) {}
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        ReadInJoyAdLog.a("VideoAdTimeLoadManager", paramBoolean);
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("startTiming :").append(this.jdField_a_of_type_Long).append(" isMainThread : ");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", paramBoolean);
      this.jdField_a_of_type_Long += 1L;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 1000L);
      int i = VideoAdStrategyManager.jdField_b_of_type_Int;
      h();
      if (this.jdField_a_of_type_Boolean) {
        i = VideoAdStrategyManager.jdField_c_of_type_Int;
      }
      if (this.jdField_a_of_type_Long >= i - VideoAdStrategyManager.d) {
        j();
      }
      if (this.jdField_a_of_type_Long < i) {
        break;
      }
      a(false);
      return;
    }
  }
  
  public static void g()
  {
    jdField_b_of_type_JavaUtilArrayList.clear();
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    jdField_a_of_type_AndroidUtilSparseArray.clear();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  private void h()
  {
    if ((VideoAdStrategyManager.j == 0) || (VideoAdStrategyManager.l == 0) || (VideoAdStrategyManager.k == 0) || (jdField_b_of_type_JavaUtilArrayList == null)) {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "checkNeedInsertFromVV no vv data");
    }
    do
    {
      do
      {
        return;
      } while ((VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < VideoAdStrategyManager.j) && (VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < VideoAdStrategyManager.k) && (VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < VideoAdStrategyManager.l));
      if ((jdField_b_of_type_JavaUtilArrayList.size() > 1) && (VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= VideoAdStrategyManager.l))
      {
        ReadInJoyAdLog.a("VideoAdTimeLoadManager", "checkNeedInsertFromVV is adVvIntervalOther");
        i();
        return;
      }
      if ((jdField_b_of_type_JavaUtilArrayList.size() == 0) && (VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= VideoAdStrategyManager.j))
      {
        ReadInJoyAdLog.a("VideoAdTimeLoadManager", "checkNeedInsertFromVV is adVvIntervalFirst");
        i();
        return;
      }
    } while ((jdField_b_of_type_JavaUtilArrayList.size() != 1) || (VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < VideoAdStrategyManager.k));
    ReadInJoyAdLog.a("VideoAdTimeLoadManager", "checkNeedInsertFromVV is adVvIntervalSecond");
    i();
  }
  
  private void i()
  {
    if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      j();
    }
    a(true);
  }
  
  private void j()
  {
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0) {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "adVideoCache size :" + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
    while (a(this.jdField_a_of_type_Int + 1)) {
      return;
    }
    int i = a();
    int j = a(i);
    if (j >= 3)
    {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "has preLoad 3 times");
      return;
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "preLoadAd :" + this.jdField_a_of_type_Long);
      AdRequestData localAdRequestData = new AdRequestData();
      localAdRequestData.h = 1;
      localAdRequestData.i = this.jdField_b_of_type_Int;
      localAdRequestData.j = i;
      localAdRequestData.jdField_a_of_type_Boolean = true;
      ThreadManager.executeOnSubThread(new VideoAdTimeLoadManager.2(this, localAdRequestData));
      jdField_a_of_type_AndroidUtilSparseArray.put(i, Integer.valueOf(j + 1));
      return;
    }
    ReadInJoyAdLog.a("VideoAdTimeLoadManager", "preLoading : so return");
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public VideoInfo a()
  {
    if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)) {
      return (VideoInfo)jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(0);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      j();
    }
    for (;;)
    {
      return null;
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "getVideoInfo onAdPreLoading is true");
    }
  }
  
  public void a()
  {
    b(false);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.jdField_b_of_type_Int > paramVideoInfo.jdField_c_of_type_Int) {}
      for (this.jdField_b_of_type_Int = 1;; this.jdField_b_of_type_Int = 2)
      {
        QLog.d("VideoAdTimeLoadManager", 1, "setSceneId : sceneId = " + this.jdField_b_of_type_Int + " , videoInfo = " + paramVideoInfo.jdField_c_of_type_JavaLangString);
        return;
      }
    }
    QLog.d("VideoAdTimeLoadManager", 1, "setSceneId : videoInfo is null");
  }
  
  public void a(boolean paramBoolean)
  {
    ReadInJoyAdLog.a("VideoAdTimeLoadManager", "onInsertAd :" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    int i = this.jdField_a_of_type_Int + 1;
    if (!a(i, paramBoolean)) {
      return;
    }
    VideoInfo localVideoInfo = a();
    if (localVideoInfo == null)
    {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "empty cache");
      return;
    }
    ReadInJoyAdLog.a("VideoAdTimeLoadManager", "onInsertAd : success");
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoAdTimeLoadManager.3(this, i, localVideoInfo));
    localVideoInfo.a.jdField_a_of_type_Int = i;
    int j = a();
    if (j == 0) {}
    for (localVideoInfo.a.jdField_b_of_type_Int = 0;; localVideoInfo.a.jdField_b_of_type_Int = (i - j))
    {
      localVideoInfo.a.jdField_c_of_type_Int = VideoAdStrategyManager.jdField_c_of_type_Int;
      c(i);
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", "insert success: pos = " + i);
      return;
    }
  }
  
  public void b()
  {
    if ((VideoAdStrategyManager.c()) && (VideoAdStrategyManager.b()))
    {
      e();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    StringBuilder localStringBuilder = new StringBuilder().append("pauseTiming :").append(this.jdField_a_of_type_Long).append(" isMainThread : ");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      ReadInJoyAdLog.a("VideoAdTimeLoadManager", bool);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = paramInt;
    }
    ReadInJoyAdLog.a("VideoAdTimeLoadManager", "lastPlayPosition = " + this.jdField_a_of_type_Int);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {
      b(true);
    }
  }
  
  public void c(int paramInt)
  {
    jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt));
  }
  
  public void d()
  {
    b();
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
    f();
  }
  
  public void f()
  {
    if ((VideoAdStrategyManager.c()) && (VideoAdStrategyManager.b())) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    ReadInJoyAdLog.a("VideoAdTimeLoadManager", "restoreTiming :" + this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager
 * JD-Core Version:    0.7.0.1
 */