package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdStrategyReportManager;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdStrategyReportData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoAdStrategyReportManager
  implements IVideoAdStrategyReportManager
{
  private HashMap<String, Integer> a = new HashMap();
  private AtomicInteger b = new AtomicInteger(0);
  private long c = 0L;
  private boolean d = false;
  private Handler e = new VideoAdStrategyReportManager.1(this, Looper.getMainLooper());
  
  private void a(boolean paramBoolean)
  {
    if (this.d) {
      return;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    if ((!paramBoolean) && (this.b.get() == 1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("repeat startPlay, so return isMainThread : ");
      paramBoolean = bool1;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        paramBoolean = true;
      }
      localStringBuilder.append(paramBoolean);
      ReadInJoyAdLog.a("VideoAdReportManager", localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTiming :");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" isMainThread : ");
    paramBoolean = bool2;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      paramBoolean = true;
    }
    localStringBuilder.append(paramBoolean);
    ReadInJoyAdLog.a("VideoAdReportManager", localStringBuilder.toString());
    this.c += 1L;
    this.e.sendEmptyMessageDelayed(1001, 1000L);
  }
  
  private void i()
  {
    this.a.clear();
  }
  
  private int j()
  {
    return this.a.size();
  }
  
  private int k()
  {
    Iterator localIterator = this.a.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((Integer)((Map.Entry)localIterator.next()).getValue()).intValue();
    }
    return i;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.c != null))
    {
      if (paramVideoPlayParam.c.aq)
      {
        paramVideoPlayParam = paramVideoPlayParam.c.au;
        StringBuilder localStringBuilder;
        if (paramVideoPlayParam.a <= 0)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("lastAdDistance: ");
          localStringBuilder.append(j());
          ReadInJoyAdLog.a("VideoAdReportManager", localStringBuilder.toString());
          paramVideoPlayParam.a = j();
        }
        if (paramVideoPlayParam.c <= 0L)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("lastAdTime: ");
          localStringBuilder.append(b());
          ReadInJoyAdLog.a("VideoAdReportManager", localStringBuilder.toString());
          paramVideoPlayParam.c = b();
        }
        if (paramVideoPlayParam.b <= 0)
        {
          paramVideoPlayParam.b = k();
          paramVideoPlayParam = new StringBuilder();
          paramVideoPlayParam.append("lastAdDistanceVV: ");
          paramVideoPlayParam.append(k());
          ReadInJoyAdLog.a("VideoAdReportManager", paramVideoPlayParam.toString());
        }
        i();
        h();
        return;
      }
      a();
      a(paramVideoPlayParam.c.b);
    }
  }
  
  public void a(String paramString)
  {
    if (this.a.containsKey(paramString))
    {
      int i = ((Integer)this.a.get(paramString)).intValue();
      this.a.put(paramString, Integer.valueOf(i + 1));
      return;
    }
    this.a.put(paramString, Integer.valueOf(1));
  }
  
  public long b()
  {
    return this.c;
  }
  
  public void c()
  {
    this.d = true;
    h();
  }
  
  public void d()
  {
    if (this.b.get() == 2) {
      a(true);
    }
  }
  
  public void e()
  {
    g();
  }
  
  public void f()
  {
    this.e.removeMessages(1001);
    this.e = null;
  }
  
  public void g()
  {
    this.e.removeMessages(1001);
    this.b.set(2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseTiming :");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" isMainThread : ");
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    ReadInJoyAdLog.a("VideoAdReportManager", localStringBuilder.toString());
  }
  
  public void h()
  {
    this.c = 0L;
    this.e.removeMessages(1001);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("restoreTiming :");
    localStringBuilder.append(this.c);
    ReadInJoyAdLog.a("VideoAdReportManager", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyReportManager
 * JD-Core Version:    0.7.0.1
 */