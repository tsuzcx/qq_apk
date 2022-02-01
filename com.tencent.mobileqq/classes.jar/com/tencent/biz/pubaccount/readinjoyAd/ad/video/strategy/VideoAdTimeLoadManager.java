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
  public static CopyOnWriteArrayList<VideoInfo> a = new CopyOnWriteArrayList();
  private static SparseArray<Integer> d = new SparseArray();
  private static ArrayList<Integer> e = new ArrayList();
  private static AtomicInteger f = new AtomicInteger(0);
  private static AtomicBoolean g = new AtomicBoolean(false);
  private static AtomicBoolean h = new AtomicBoolean(false);
  private IVideoFeedsAdapter b;
  private ArrayList<VideoInfo> c;
  private boolean i = false;
  private boolean j = false;
  private int k = 0;
  private int l = 2;
  private long m = 0L;
  private AtomicInteger n = new AtomicInteger(0);
  private Handler o = new VideoAdTimeLoadManager.1(this, Looper.getMainLooper());
  
  public VideoAdTimeLoadManager(IVideoFeedsAdapter paramIVideoFeedsAdapter, ArrayList<VideoInfo> paramArrayList)
  {
    this.b = paramIVideoFeedsAdapter;
    this.c = paramArrayList;
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
        if (localVideoInfo.aq) {
          localArrayList.add(localVideoInfo);
        }
      }
    }
    if (localArrayList.size() > 0) {
      a.addAll(localArrayList);
    }
    return localArrayList;
  }
  
  public static void a(int paramInt)
  {
    if (paramInt != 88888888) {
      return;
    }
    g.compareAndSet(true, false);
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
        a.add(localObject2);
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
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    if (this.b != null)
    {
      Object localObject = this.c;
      if ((localObject != null) && (paramInt >= 0) && (((ArrayList)localObject).size() > paramInt))
      {
        int i1 = h();
        if ((i1 > 0) && (paramInt - i1 < VideoAdStrategyManager.f + 1) && (!paramBoolean))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "not meet adProtectGap");
          return false;
        }
        if (paramInt > this.c.size() - 1)
        {
          localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("article size = ");
          localStringBuilder.append(this.c.size());
          localStringBuilder.append(" but  pos = ");
          localStringBuilder.append(paramInt);
          ((IRIJAdLogService)localObject).d("VideoAdTimeLoadManager", localStringBuilder.toString());
          return false;
        }
        if (e(paramInt))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "shouldInsert not allow insert！");
          return false;
        }
        if ((paramBoolean) && (i1 != 0) && (i1 == this.k))
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
    if (this.j) {
      return;
    }
    boolean bool1 = false;
    boolean bool2 = true;
    if ((!paramBoolean) && (this.n.get() == 1))
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
    localStringBuilder.append(this.m);
    localStringBuilder.append(" isMainThread : ");
    if (Looper.myLooper() == Looper.getMainLooper()) {
      paramBoolean = bool2;
    } else {
      paramBoolean = false;
    }
    localStringBuilder.append(paramBoolean);
    localIRIJAdLogService.d("VideoAdTimeLoadManager", localStringBuilder.toString());
    this.m += 1L;
    this.o.sendEmptyMessageDelayed(1001, 1000L);
    int i1 = VideoAdStrategyManager.c;
    k();
    if (this.i) {
      i1 = VideoAdStrategyManager.d;
    }
    if (this.m >= i1 - VideoAdStrategyManager.e) {
      m();
    }
    if (this.m >= i1) {
      a(false);
    }
  }
  
  private int d(int paramInt)
  {
    Integer localInteger = (Integer)d.get(paramInt);
    if (d.get(paramInt) == null)
    {
      d.put(paramInt, Integer.valueOf(0));
      return 0;
    }
    return localInteger.intValue();
  }
  
  private boolean e(int paramInt)
  {
    if (this.b != null)
    {
      Object localObject = this.c;
      if ((localObject != null) && (paramInt >= 0) && (((ArrayList)localObject).size() > paramInt))
      {
        if (((VideoInfo)this.c.get(paramInt)).aq)
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
  
  public static int h()
  {
    ArrayList localArrayList = e;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = e;
      return ((Integer)localArrayList.get(localArrayList.size() - 1)).intValue();
    }
    return 0;
  }
  
  public static void j()
  {
    e.clear();
    a.clear();
    d.clear();
    f.set(0);
    g.set(false);
  }
  
  private void k()
  {
    if ((VideoAdStrategyManager.o != 0) && (VideoAdStrategyManager.q != 0) && (VideoAdStrategyManager.p != 0) && (e != null))
    {
      if ((VideoAdStrategyManager.n.get() >= VideoAdStrategyManager.o) || (VideoAdStrategyManager.n.get() >= VideoAdStrategyManager.p) || (VideoAdStrategyManager.n.get() >= VideoAdStrategyManager.q))
      {
        if ((e.size() > 1) && (VideoAdStrategyManager.n.get() >= VideoAdStrategyManager.q))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "checkNeedInsertFromVV is adVvIntervalOther");
          l();
          return;
        }
        if ((e.size() == 0) && (VideoAdStrategyManager.n.get() >= VideoAdStrategyManager.o))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "checkNeedInsertFromVV is adVvIntervalFirst");
          l();
          return;
        }
        if ((e.size() == 1) && (VideoAdStrategyManager.n.get() >= VideoAdStrategyManager.p))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "checkNeedInsertFromVV is adVvIntervalSecond");
          l();
        }
      }
      return;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "checkNeedInsertFromVV no vv data");
  }
  
  private void l()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = a;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() == 0)) {
      m();
    }
    a(true);
  }
  
  private void m()
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (a.size() > 0)
    {
      localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("adVideoCache size :");
      localStringBuilder.append(a.size());
      ((IRIJAdLogService)localObject).d("VideoAdTimeLoadManager", localStringBuilder.toString());
      return;
    }
    if (e(this.k + 1)) {
      return;
    }
    int i1 = h();
    int i2 = d(i1);
    if (i2 >= 3)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "has preLoad 3 times");
      return;
    }
    if (g.compareAndSet(false, true))
    {
      localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("preLoadAd :");
      localStringBuilder.append(this.m);
      ((IRIJAdLogService)localObject).d("VideoAdTimeLoadManager", localStringBuilder.toString());
      localObject = new AdRequestData();
      ((AdRequestData)localObject).j = 1;
      ((AdRequestData)localObject).k = this.l;
      ((AdRequestData)localObject).l = i1;
      ((AdRequestData)localObject).e = true;
      ThreadManager.executeOnSubThread(new VideoAdTimeLoadManager.2(this, (AdRequestData)localObject));
      d.put(i1, Integer.valueOf(i2 + 1));
      return;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "preLoading : so return");
  }
  
  public void a()
  {
    b(false);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.c > paramVideoInfo.d) {
        this.l = 1;
      } else {
        this.l = 2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSceneId : sceneId = ");
      localStringBuilder.append(this.l);
      localStringBuilder.append(" , videoInfo = ");
      localStringBuilder.append(paramVideoInfo.g);
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
    localStringBuilder.append(g.get());
    ((IRIJAdLogService)localObject).d("VideoAdTimeLoadManager", localStringBuilder.toString());
    int i1 = this.k + 1;
    if (!a(i1, paramBoolean)) {
      return;
    }
    localObject = g();
    if (localObject == null)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "empty cache");
      return;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "onInsertAd : success");
    this.o.post(new VideoAdTimeLoadManager.3(this, i1, (VideoInfo)localObject));
    ((VideoInfo)localObject).at.a = i1;
    int i2 = h();
    if (i2 == 0) {
      ((VideoInfo)localObject).at.b = 0;
    } else {
      ((VideoInfo)localObject).at.b = (i1 - i2);
    }
    ((VideoInfo)localObject).at.d = VideoAdStrategyManager.d;
    c(i1);
    localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("insert success: pos = ");
    localStringBuilder.append(i1);
    ((IRIJAdLogService)localObject).d("VideoAdTimeLoadManager", localStringBuilder.toString());
  }
  
  public void b()
  {
    if ((VideoAdStrategyManager.e()) && (VideoAdStrategyManager.d()))
    {
      e();
      return;
    }
    this.o.removeMessages(1001);
    this.n.set(2);
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseTiming :");
    localStringBuilder.append(this.m);
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
    if (paramInt > this.k) {
      this.k = paramInt;
    }
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lastPlayPosition = ");
    localStringBuilder.append(this.k);
    localIRIJAdLogService.d("VideoAdTimeLoadManager", localStringBuilder.toString());
  }
  
  public void c()
  {
    if (this.n.get() == 2) {
      b(true);
    }
  }
  
  public void c(int paramInt)
  {
    e.add(Integer.valueOf(paramInt));
  }
  
  public void d()
  {
    b();
  }
  
  public void e()
  {
    this.j = true;
    f();
  }
  
  public void f()
  {
    if ((VideoAdStrategyManager.e()) && (VideoAdStrategyManager.d())) {
      return;
    }
    this.i = true;
    this.m = 0L;
    this.o.removeMessages(1001);
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("restoreTiming :");
    localStringBuilder.append(this.m);
    localIRIJAdLogService.d("VideoAdTimeLoadManager", localStringBuilder.toString());
  }
  
  public VideoInfo g()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = a;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > 0)) {
      return (VideoInfo)a.remove(0);
    }
    if (!g.get()) {
      m();
    } else {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "getVideoInfo onAdPreLoading is true");
    }
    return null;
  }
  
  public long i()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager
 * JD-Core Version:    0.7.0.1
 */