package com.tencent.mobileqq.apollo;

import android.view.View;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ApolloTicker
{
  public static final String TAG = "sava_ApolloTicker";
  public int mInterval = 3;
  private float mOffscreenFrameInterval;
  public boolean mTickerUseGlobalTimer;
  public boolean mTimerAlive;
  public long ticker;
  private Map<Long, ApolloTicker.ApolloTickerInfo> tickerMap = new HashMap();
  
  public ApolloTicker()
  {
    QLog.d("sava_ApolloTicker", 1, "tickerObj new");
  }
  
  private Timer getTimer()
  {
    Object localObject = ApolloUtilImpl.getApolloManager();
    if ((this.mTickerUseGlobalTimer) && (localObject != null) && (((ApolloManagerServiceImpl)localObject).mGlobalTimer != null))
    {
      localObject = ((ApolloManagerServiceImpl)localObject).mGlobalTimer;
      this.mTimerAlive = true;
      QLog.i("sava_ApolloTicker", 1, "get global Timer ");
      return localObject;
    }
    return new Timer();
  }
  
  public void createTicker(long paramLong)
  {
    QLog.d("sava_ApolloTicker", 1, "ApolloTicker  thread=" + Thread.currentThread().getId() + "ticker = " + paramLong);
    Object localObject = ApolloRender.getCurrentRenderView();
    this.ticker = paramLong;
    try
    {
      Timer localTimer = getTimer();
      localObject = new ApolloTicker.NativeDrawTask(this, (View)localObject, paramLong, 2L);
      ApolloTicker.ApolloTickerInfo localApolloTickerInfo = new ApolloTicker.ApolloTickerInfo();
      localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer = localTimer;
      localApolloTickerInfo.jdField_a_of_type_Int = 1;
      localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask = ((ApolloTicker.NativeDrawTask)localObject);
      localTimer.scheduleAtFixedRate((TimerTask)localObject, 0L, 16L);
      this.tickerMap.put(Long.valueOf(paramLong), localApolloTickerInfo);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("sava_ApolloTicker", 1, "createTicker ", localThrowable);
    }
  }
  
  public void disposeTicker(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ApolloTicker", 2, "disposeTicker ticker = " + paramLong + ",thread=" + Thread.currentThread().getId());
    }
    ApolloTicker.ApolloTickerInfo localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)this.tickerMap.remove(Long.valueOf(paramLong));
    if (localApolloTickerInfo == null)
    {
      QLog.e("sava_ApolloTicker", 1, "[disposeTicker], null error. ticker:" + paramLong);
      return;
    }
    Timer localTimer = localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer;
    if (!this.mTimerAlive) {
      if (localTimer != null)
      {
        localTimer.cancel();
        localTimer.purge();
      }
    }
    for (;;)
    {
      localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer = null;
      return;
      if (localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
        localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.cancel();
      }
    }
  }
  
  public void driveOffScreenFrame(long paramLong)
  {
    if ((paramLong < 0L) || (!nativeGetNeedRecord(paramLong)) || (this.mOffscreenFrameInterval <= 0.0F)) {
      return;
    }
    long l = System.currentTimeMillis();
    ApolloTicker.ApolloTickerInfo localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)this.tickerMap.get(Long.valueOf(this.ticker));
    if (localApolloTickerInfo != null) {}
    for (int j = localApolloTickerInfo.jdField_a_of_type_Int;; j = 1)
    {
      float f = j / 60.0F * j * 1000.0F / 2.0F;
      int i = 0;
      if (paramLong >= 0L) {
        if (nativeGetNeedRecord(paramLong)) {}
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label234;
        }
        QLog.d("sava_ApolloTicker", 2, new Object[] { "driveOffScreenFrame frame:", Integer.valueOf(i), ", cost:", Long.valueOf(System.currentTimeMillis() - l), ", halfPhysicalInterval:", Float.valueOf(f), ", interval:", Integer.valueOf(j), ", ticker:", Long.valueOf(this.ticker) });
        return;
        nativeCallbackTicker(this.ticker, System.currentTimeMillis(), this.mOffscreenFrameInterval);
        int k = i + 1;
        i = k;
        if ((float)(System.currentTimeMillis() - l) <= f)
        {
          i = k;
          break;
        }
      }
      label234:
      break;
    }
  }
  
  public float getDuration(long paramLong)
  {
    ApolloTicker.ApolloTickerInfo localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
    if (localApolloTickerInfo != null) {
      return localApolloTickerInfo.jdField_a_of_type_Int / 60.0F;
    }
    return 0.0F;
  }
  
  public int getInterval(long paramLong)
  {
    ApolloTicker.ApolloTickerInfo localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
    if (localApolloTickerInfo != null) {
      return localApolloTickerInfo.jdField_a_of_type_Int;
    }
    return 1;
  }
  
  public native void nativeCallbackTicker(long paramLong, double paramDouble1, double paramDouble2);
  
  public native boolean nativeGetNeedRecord(long paramLong);
  
  public native void nativeSetRecorderMode(long paramLong, boolean paramBoolean);
  
  public void pauseTicker(long paramLong)
  {
    ApolloTicker.ApolloTickerInfo localApolloTickerInfo;
    try
    {
      localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
      if (localApolloTickerInfo == null)
      {
        QLog.e("sava_ApolloTicker", 1, "[pauseTicker], null error. ticker:" + paramLong);
        return;
      }
      String str = "";
      if (localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
        str = localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.a();
      }
      QLog.d("sava_ApolloTicker", 1, new Object[] { "pauseTicker ticker = ", Long.valueOf(paramLong), ",thread=", Long.valueOf(Thread.currentThread().getId()), ",intervalFps:", str + ", timer:" + localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer });
      if (localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer == null) {
        return;
      }
      if (!this.mTimerAlive)
      {
        localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer.cancel();
        localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer.purge();
        localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("sava_ApolloTicker", 2, "pause ticker error=" + localThrowable.toString());
      return;
    }
    if (localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
      localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.cancel();
    }
  }
  
  public void resumeTicker(long paramLong)
  {
    resumeTicker(paramLong, ApolloRender.getCurrentRenderView());
  }
  
  public void resumeTicker(long paramLong, View paramView)
  {
    ApolloTicker.ApolloTickerInfo localApolloTickerInfo;
    int i;
    try
    {
      localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
      if (localApolloTickerInfo == null)
      {
        QLog.e("sava_ApolloTicker", 1, "[resumeTicker], null error. ticker:" + paramLong);
        return;
      }
      i = localApolloTickerInfo.jdField_a_of_type_Int;
      if (paramView == null)
      {
        QLog.e("sava_ApolloTicker", 1, "[resumeTicker], return, apolloView is null");
        return;
      }
    }
    catch (Throwable paramView)
    {
      QLog.e("sava_ApolloTicker", 2, "resumeTicker ticker error=" + paramView.toString());
      return;
    }
    if (localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer != null)
    {
      if (this.mTimerAlive) {
        break label224;
      }
      localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer.cancel();
      localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer.purge();
    }
    for (;;)
    {
      localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer = null;
      QLog.d("sava_ApolloTicker", 1, "resumeTicker ticker = " + paramLong + ",thread=" + Thread.currentThread().getId());
      paramView = new ApolloTicker.NativeDrawTask(this, paramView, paramLong, i);
      Timer localTimer = getTimer();
      localTimer.scheduleAtFixedRate(paramView, 0L, i * 16);
      localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer = localTimer;
      localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask = paramView;
      return;
      label224:
      if (localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
        localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.cancel();
      }
    }
  }
  
  public void setInterval(long paramLong, int paramInt)
  {
    if (paramInt == 1) {}
    ApolloTicker.ApolloTickerInfo localApolloTickerInfo;
    do
    {
      return;
      this.mInterval = paramInt;
      localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
      if (localApolloTickerInfo == null)
      {
        QLog.e("sava_ApolloTicker", 1, "setInterval tickerInfo null");
        return;
      }
      localObject = ApolloRender.getCurrentRenderView();
    } while (localObject == null);
    QLog.d("sava_ApolloTicker", 1, "ScheduledExecutorService setInterval call = " + paramInt + " thread=" + Thread.currentThread().getId());
    Timer localTimer = localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer;
    if ((!this.mTimerAlive) && (localTimer != null))
    {
      localTimer.cancel();
      localTimer.purge();
    }
    if (localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
      localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.cancel();
    }
    Object localObject = new ApolloTicker.NativeDrawTask(this, (View)localObject, paramLong, paramInt);
    localTimer = getTimer();
    localTimer.scheduleAtFixedRate((TimerTask)localObject, 0L, paramInt * 16);
    localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer = localTimer;
    localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask = ((ApolloTicker.NativeDrawTask)localObject);
    localApolloTickerInfo.jdField_a_of_type_Int = paramInt;
  }
  
  public void setOffscreenFrameInterval(float paramFloat)
  {
    this.mOffscreenFrameInterval = paramFloat;
  }
  
  public void setRenderView(View paramView)
  {
    Iterator localIterator = this.tickerMap.values().iterator();
    while (localIterator.hasNext())
    {
      ApolloTicker.ApolloTickerInfo localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)localIterator.next();
      if ((localApolloTickerInfo != null) && (localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null)) {
        localApolloTickerInfo.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.a(paramView);
      }
    }
    QLog.i("sava_ApolloTicker", 1, "setRenderView size:" + this.tickerMap.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTicker
 * JD-Core Version:    0.7.0.1
 */