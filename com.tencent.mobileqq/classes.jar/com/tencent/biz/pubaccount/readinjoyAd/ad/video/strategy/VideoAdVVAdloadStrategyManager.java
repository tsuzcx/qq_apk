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
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new VideoAdVVAdloadStrategyManager.1(this, Looper.getMainLooper());
  private IVideoAdTimeLoadManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdTimeLoadManager;
  private IVideoFeedsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public VideoAdVVAdloadStrategyManager(IVideoFeedsAdapter paramIVideoFeedsAdapter, ArrayList<VideoInfo> paramArrayList, IVideoAdTimeLoadManager paramIVideoAdTimeLoadManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter = paramIVideoFeedsAdapter;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdTimeLoadManager = paramIVideoAdTimeLoadManager;
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    if (VideoAdStrategyManager.a != 3)
    {
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "chooseStrategy:不是混合策略,结束运行");
      b();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
      return;
    }
    if (paramLong >= VideoAdStrategyManager.i * 1000)
    {
      VideoAdStrategyManager.a = 1;
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "chooseStrategy:走时长策略");
      b();
      e();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
      return;
    }
    if (paramBoolean)
    {
      if (paramLong < VideoAdStrategyManager.i * 1000)
      {
        VideoAdStrategyManager.a = 2;
        QLog.d("VideoAdVVAdloadStrategyManager", 2, "chooseStrategy:走vv策略");
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
    }
  }
  
  private void e()
  {
    QLog.d("VideoAdVVAdloadStrategyManager", 2, "clearAdVideoInfo");
    try
    {
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter != null) && (VideoAdTimeLoadManager.a != null))
      {
        Iterator localIterator = VideoAdTimeLoadManager.a.iterator();
        while (localIterator.hasNext())
        {
          localObject = (VideoInfo)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("clearAdVideoInfo  del vid : ");
          localStringBuilder.append(((VideoInfo)localObject).jdField_a_of_type_JavaLangString);
          QLog.d("VideoAdVVAdloadStrategyManager", 2, localStringBuilder.toString());
          this.jdField_a_of_type_JavaUtilArrayList.remove(localObject);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.d((VideoInfo)localObject);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdTimeLoadManager != null) && (VideoAdStrategyManager.a != 1))
    {
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "结束 adloadtime");
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdTimeLoadManager.e();
    }
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!VideoAdStrategyManager.d()))
    {
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null)
      {
        localHandler.removeMessages(4097);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4097, 500L);
      }
      return;
    }
    QLog.d("VideoAdVVAdloadStrategyManager", 2, "startRecord has chosen stop");
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = paramString;
      }
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString))
      {
        a(this.jdField_a_of_type_Long, true);
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
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4097);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("暂停计时:");
        localStringBuilder.append(this.jdField_a_of_type_Long);
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
    this.jdField_a_of_type_AndroidOsHandler = null;
    VideoAdStrategyManager.c = false;
    VideoAdStrategyManager.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdVVAdloadStrategyManager
 * JD-Core Version:    0.7.0.1
 */