package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdTimeLoadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdVVAdloadStrategyManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoAdVVAdloadStrategyManager
  implements IVideoAdVVAdloadStrategyManager
{
  private String a;
  private long b;
  private AtomicBoolean c = new AtomicBoolean(false);
  private IVideoFeedsAdapter d;
  private ArrayList<VideoInfo> e;
  private IVideoAdTimeLoadManager f;
  private Handler g = new VideoAdVVAdloadStrategyManager.1(this, Looper.getMainLooper());
  
  public VideoAdVVAdloadStrategyManager(IVideoFeedsAdapter paramIVideoFeedsAdapter, ArrayList<VideoInfo> paramArrayList, IVideoAdTimeLoadManager paramIVideoAdTimeLoadManager)
  {
    this.d = paramIVideoFeedsAdapter;
    this.e = paramArrayList;
    this.f = paramIVideoAdTimeLoadManager;
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    if (VideoAdStrategyManager.b != 3)
    {
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "chooseStrategy:不是混合策略,结束运行");
      b();
      this.c.compareAndSet(false, true);
      return;
    }
    if (paramLong >= VideoAdStrategyManager.l * 1000)
    {
      VideoAdStrategyManager.b = 1;
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "chooseStrategy:走时长策略");
      b();
      e();
      this.c.compareAndSet(false, true);
      return;
    }
    if (paramBoolean)
    {
      if (paramLong < VideoAdStrategyManager.l * 1000)
      {
        VideoAdStrategyManager.b = 2;
        QLog.d("VideoAdVVAdloadStrategyManager", 2, "chooseStrategy:走vv策略");
      }
      this.c.compareAndSet(false, true);
    }
  }
  
  private void e()
  {
    QLog.d("VideoAdVVAdloadStrategyManager", 2, "clearAdVideoInfo");
    try
    {
      Object localObject;
      if ((this.d != null) && (VideoAdTimeLoadManager.a != null))
      {
        Iterator localIterator = VideoAdTimeLoadManager.a.iterator();
        while (localIterator.hasNext())
        {
          localObject = (VideoInfo)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("clearAdVideoInfo  del vid : ");
          localStringBuilder.append(((VideoInfo)localObject).b);
          QLog.d("VideoAdVVAdloadStrategyManager", 2, localStringBuilder.toString());
          this.e.remove(localObject);
          this.d.d((VideoInfo)localObject);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearAdVideoInfo error : ");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.d("VideoAdVVAdloadStrategyManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void f()
  {
    if ((this.f != null) && (VideoAdStrategyManager.b != 1))
    {
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "结束 adloadtime");
      this.f.e();
    }
  }
  
  public void a()
  {
    if ((!this.c.get()) && (!VideoAdStrategyManager.d()))
    {
      Handler localHandler = this.g;
      if (localHandler != null)
      {
        localHandler.removeMessages(4097);
        this.g.sendEmptyMessageDelayed(4097, 500L);
      }
      return;
    }
    QLog.d("VideoAdVVAdloadStrategyManager", 2, "startRecord has chosen stop");
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.c.get()))
    {
      if (this.a == null) {
        this.a = paramString;
      }
      if (!TextUtils.equals(this.a, paramString))
      {
        a(this.b, true);
        b();
      }
      return;
    }
    QLog.d("VideoAdVVAdloadStrategyManager", 2, "startRecordIfNeed no need");
  }
  
  public void b()
  {
    try
    {
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "结束计时");
      c();
      f();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      if (this.g != null)
      {
        this.g.removeMessages(4097);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("暂停计时:");
        localStringBuilder.append(this.b);
        QLog.d("VideoAdVVAdloadStrategyManager", 2, localStringBuilder.toString());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    this.g = null;
    VideoAdStrategyManager.m = false;
    VideoAdStrategyManager.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdVVAdloadStrategyManager
 * JD-Core Version:    0.7.0.1
 */