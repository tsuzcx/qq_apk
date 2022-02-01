package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdTimeLoadManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoAdTimeLoadManager
  implements IVideoAdTimeLoadManager
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
  private IVideoFeedsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter;
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
  
  public VideoAdTimeLoadManager(IVideoFeedsAdapter paramIVideoFeedsAdapter, ArrayList<VideoInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter = paramIVideoFeedsAdapter;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public static int a()
  {
    ArrayList localArrayList = jdField_b_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = jdField_b_of_type_JavaUtilArrayList;
      return ((Integer)localArrayList.get(localArrayList.size() - 1)).intValue();
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
        if (localVideoInfo.r) {
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
    if ((paramInt == 88888888) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (AdvertisementInfo)paramArrayList.next();
        Object localObject2 = VideoAdExposureManager.a((AdvertisementInfo)localObject1, false);
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((AdvertisementInfo)localObject1).mTitle);
        ((StringBuilder)localObject2).append("---");
        localStringBuilder.append(((StringBuilder)localObject2).toString());
      }
      paramArrayList = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onAsyncDataReady :");
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      paramArrayList.d("VideoAdTimeLoadManager", ((StringBuilder)localObject1).toString());
    }
  }
  
  private boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter != null)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject != null) && (paramInt >= 0) && (((ArrayList)localObject).size() > paramInt))
      {
        if (((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).r)
        {
          localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" has adVideo");
          ((IRIJAdLogService)localObject).d("VideoAdTimeLoadManager", localStringBuilder.toString());
          return true;
        }
        return false;
      }
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "Invalid parameter");
    return false;
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter != null)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject != null) && (paramInt >= 0) && (((ArrayList)localObject).size() > paramInt))
      {
        int i = a();
        if ((i > 0) && (paramInt - i < VideoAdStrategyManager.e + 1) && (!paramBoolean))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "not meet adProtectGap");
          return false;
        }
        if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
        {
          localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("article size = ");
          localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
          localStringBuilder.append(" but  pos = ");
          localStringBuilder.append(paramInt);
          ((IRIJAdLogService)localObject).d("VideoAdTimeLoadManager", localStringBuilder.toString());
          return false;
        }
        if (a(paramInt))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "shouldInsert not allow insert！");
          return false;
        }
        if ((paramBoolean) && (i != 0) && (i == this.jdField_a_of_type_Int))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "insertAd not allow insert vv default");
          return false;
        }
        return true;
      }
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "Invalid parameter");
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    boolean bool1 = false;
    boolean bool2 = true;
    if ((!paramBoolean) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1))
    {
      localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("repeat startPlay, so return isMainThread : ");
      paramBoolean = bool1;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        paramBoolean = true;
      }
      localStringBuilder.append(paramBoolean);
      localIRIJAdLogService.d("VideoAdTimeLoadManager", localStringBuilder.toString());
      return;
    }
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTiming :");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" isMainThread : ");
    if (Looper.myLooper() == Looper.getMainLooper()) {
      paramBoolean = bool2;
    } else {
      paramBoolean = false;
    }
    localStringBuilder.append(paramBoolean);
    localIRIJAdLogService.d("VideoAdTimeLoadManager", localStringBuilder.toString());
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
    if (this.jdField_a_of_type_Long >= i) {
      a(false);
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
    if ((VideoAdStrategyManager.j != 0) && (VideoAdStrategyManager.l != 0) && (VideoAdStrategyManager.k != 0) && (jdField_b_of_type_JavaUtilArrayList != null))
    {
      if ((VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= VideoAdStrategyManager.j) || (VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= VideoAdStrategyManager.k) || (VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= VideoAdStrategyManager.l))
      {
        if ((jdField_b_of_type_JavaUtilArrayList.size() > 1) && (VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= VideoAdStrategyManager.l))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "checkNeedInsertFromVV is adVvIntervalOther");
          i();
          return;
        }
        if ((jdField_b_of_type_JavaUtilArrayList.size() == 0) && (VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= VideoAdStrategyManager.j))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "checkNeedInsertFromVV is adVvIntervalFirst");
          i();
          return;
        }
        if ((jdField_b_of_type_JavaUtilArrayList.size() == 1) && (VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= VideoAdStrategyManager.k))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "checkNeedInsertFromVV is adVvIntervalSecond");
          i();
        }
      }
      return;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "checkNeedInsertFromVV no vv data");
  }
  
  private void i()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() == 0)) {
      j();
    }
    a(true);
  }
  
  private void j()
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("adVideoCache size :");
      localStringBuilder.append(jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      ((IRIJAdLogService)localObject).d("VideoAdTimeLoadManager", localStringBuilder.toString());
      return;
    }
    if (a(this.jdField_a_of_type_Int + 1)) {
      return;
    }
    int i = a();
    int j = a(i);
    if (j >= 3)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "has preLoad 3 times");
      return;
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("preLoadAd :");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      ((IRIJAdLogService)localObject).d("VideoAdTimeLoadManager", localStringBuilder.toString());
      localObject = new AdRequestData();
      ((AdRequestData)localObject).h = 1;
      ((AdRequestData)localObject).i = this.jdField_b_of_type_Int;
      ((AdRequestData)localObject).j = i;
      ((AdRequestData)localObject).jdField_a_of_type_Boolean = true;
      ThreadManager.executeOnSubThread(new VideoAdTimeLoadManager.2(this, (AdRequestData)localObject));
      jdField_a_of_type_AndroidUtilSparseArray.put(i, Integer.valueOf(j + 1));
      return;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "preLoading : so return");
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public VideoInfo a()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > 0)) {
      return (VideoInfo)jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(0);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      j();
    } else {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "getVideoInfo onAdPreLoading is true");
    }
    return null;
  }
  
  public void a()
  {
    b(false);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.jdField_b_of_type_Int > paramVideoInfo.jdField_c_of_type_Int) {
        this.jdField_b_of_type_Int = 1;
      } else {
        this.jdField_b_of_type_Int = 2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSceneId : sceneId = ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(" , videoInfo = ");
      localStringBuilder.append(paramVideoInfo.jdField_c_of_type_JavaLangString);
      QLog.d("VideoAdTimeLoadManager", 1, localStringBuilder.toString());
      return;
    }
    QLog.d("VideoAdTimeLoadManager", 1, "setSceneId : videoInfo is null");
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInsertAd :");
    localStringBuilder.append(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    ((IRIJAdLogService)localObject).d("VideoAdTimeLoadManager", localStringBuilder.toString());
    int i = this.jdField_a_of_type_Int + 1;
    if (!a(i, paramBoolean)) {
      return;
    }
    localObject = a();
    if (localObject == null)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "empty cache");
      return;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "onInsertAd : success");
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoAdTimeLoadManager.3(this, i, (VideoInfo)localObject));
    ((VideoInfo)localObject).a.jdField_a_of_type_Int = i;
    int j = a();
    if (j == 0) {
      ((VideoInfo)localObject).a.jdField_b_of_type_Int = 0;
    } else {
      ((VideoInfo)localObject).a.jdField_b_of_type_Int = (i - j);
    }
    ((VideoInfo)localObject).a.jdField_c_of_type_Int = VideoAdStrategyManager.jdField_c_of_type_Int;
    c(i);
    localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("insert success: pos = ");
    localStringBuilder.append(i);
    ((IRIJAdLogService)localObject).d("VideoAdTimeLoadManager", localStringBuilder.toString());
  }
  
  public void b()
  {
    if ((VideoAdStrategyManager.e()) && (VideoAdStrategyManager.d()))
    {
      e();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseTiming :");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" isMainThread : ");
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localIRIJAdLogService.d("VideoAdTimeLoadManager", localStringBuilder.toString());
  }
  
  public void b(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = paramInt;
    }
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lastPlayPosition = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localIRIJAdLogService.d("VideoAdTimeLoadManager", localStringBuilder.toString());
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
    if ((VideoAdStrategyManager.e()) && (VideoAdStrategyManager.d())) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("restoreTiming :");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localIRIJAdLogService.d("VideoAdTimeLoadManager", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager
 * JD-Core Version:    0.7.0.1
 */