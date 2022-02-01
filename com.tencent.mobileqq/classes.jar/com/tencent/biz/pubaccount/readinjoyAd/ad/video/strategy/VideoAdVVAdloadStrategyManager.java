package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoAdVVAdloadStrategyManager
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new VideoAdVVAdloadStrategyManager.1(this, Looper.getMainLooper());
  private VideoFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
  private VideoAdTimeLoadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public VideoAdVVAdloadStrategyManager(VideoFeedsAdapter paramVideoFeedsAdapter, ArrayList<VideoInfo> paramArrayList, VideoAdTimeLoadManager paramVideoAdTimeLoadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager = paramVideoAdTimeLoadManager;
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    if (VideoAdStrategyManager.a != 3)
    {
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "chooseStrategy:不是混合策略,结束运行");
      b();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
    }
    do
    {
      return;
      if (paramLong >= VideoAdStrategyManager.i * 1000)
      {
        VideoAdStrategyManager.a = 1;
        QLog.d("VideoAdVVAdloadStrategyManager", 2, "chooseStrategy:走时长策略");
        b();
        e();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
        return;
      }
    } while (!paramBoolean);
    if (paramLong < VideoAdStrategyManager.i * 1000)
    {
      VideoAdStrategyManager.a = 2;
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "chooseStrategy:走vv策略");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
  }
  
  private void e()
  {
    QLog.d("VideoAdVVAdloadStrategyManager", 2, "clearAdVideoInfo");
    try
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter != null) && (VideoAdTimeLoadManager.a != null))
      {
        Iterator localIterator = VideoAdTimeLoadManager.a.iterator();
        while (localIterator.hasNext())
        {
          VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
          QLog.d("VideoAdVVAdloadStrategyManager", 2, "clearAdVideoInfo  del vid : " + localVideoInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilArrayList.remove(localVideoInfo);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.d(localVideoInfo);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "clearAdVideoInfo error : " + localException.getMessage());
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager != null) && (VideoAdStrategyManager.a != 1))
    {
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "结束 adloadtime");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager.e();
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (VideoAdStrategyManager.b())) {
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "startRecord has chosen stop");
    }
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4097);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4097, 500L);
  }
  
  public void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      QLog.d("VideoAdVVAdloadStrategyManager", 2, "startRecordIfNeed no need");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = paramString;
      }
    } while (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString));
    a(this.jdField_a_of_type_Long, true);
    b();
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
        QLog.d("VideoAdVVAdloadStrategyManager", 2, "暂停计时:" + this.jdField_a_of_type_Long);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdVVAdloadStrategyManager
 * JD-Core Version:    0.7.0.1
 */