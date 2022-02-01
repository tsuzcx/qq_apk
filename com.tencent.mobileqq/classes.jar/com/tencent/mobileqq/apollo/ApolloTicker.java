package com.tencent.mobileqq.apollo;

import amme;
import amrn;
import android.view.View;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
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
  private Map<Long, amrn> tickerMap = new HashMap();
  
  public ApolloTicker()
  {
    QLog.d("sava_ApolloTicker", 1, "tickerObj new");
  }
  
  private Timer getTimer()
  {
    Object localObject = ApolloUtil.a();
    if ((this.mTickerUseGlobalTimer) && (localObject != null) && (((amme)localObject).jdField_a_of_type_JavaUtilTimer != null))
    {
      localObject = ((amme)localObject).jdField_a_of_type_JavaUtilTimer;
      this.mTimerAlive = true;
      QLog.i("sava_ApolloTicker", 1, "get global Timer ");
      return localObject;
    }
    return new Timer();
  }
  
  public void createTicker(long paramLong)
  {
    QLog.d("sava_ApolloTicker", 1, "ApolloTicker  thread=" + Thread.currentThread().getId() + "ticker = " + paramLong);
    Object localObject = ApolloRender.getRenderViewByThreadId();
    this.ticker = paramLong;
    try
    {
      Timer localTimer = getTimer();
      localObject = new ApolloTicker.NativeDrawTask(this, (View)localObject, paramLong, 2L);
      amrn localamrn = new amrn();
      localamrn.jdField_a_of_type_JavaUtilTimer = localTimer;
      localamrn.jdField_a_of_type_Int = 1;
      localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask = ((ApolloTicker.NativeDrawTask)localObject);
      localTimer.scheduleAtFixedRate((TimerTask)localObject, 0L, 16L);
      this.tickerMap.put(Long.valueOf(paramLong), localamrn);
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
    amrn localamrn = (amrn)this.tickerMap.get(Long.valueOf(paramLong));
    if (localamrn == null)
    {
      QLog.e("sava_ApolloTicker", 1, "[disposeTicker], null error. ticker:" + paramLong);
      return;
    }
    Timer localTimer = localamrn.jdField_a_of_type_JavaUtilTimer;
    if (!this.mTimerAlive) {
      if (localTimer != null)
      {
        localTimer.cancel();
        localTimer.purge();
      }
    }
    for (;;)
    {
      localamrn.jdField_a_of_type_JavaUtilTimer = null;
      localamrn = (amrn)this.tickerMap.remove(Long.valueOf(paramLong));
      return;
      if (localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
        localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.cancel();
      }
    }
  }
  
  public void driveOffScreenFrame(long paramLong)
  {
    if ((paramLong < 0L) || (!nativeGetNeedRecord(paramLong)) || (this.mOffscreenFrameInterval <= 0.0F)) {
      return;
    }
    long l = System.currentTimeMillis();
    amrn localamrn = (amrn)this.tickerMap.get(Long.valueOf(this.ticker));
    if (localamrn != null) {}
    for (int j = localamrn.jdField_a_of_type_Int;; j = 1)
    {
      float f = j / 60.0F * j * 1000.0F / 2.0F;
      int i = 0;
      if (paramLong >= 0L) {
        if (nativeGetNeedRecord(paramLong)) {}
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label217;
        }
        QLog.d("sava_ApolloTicker", 2, new Object[] { "driveOffScreenFrame frame:", Integer.valueOf(i), ", cost:", Long.valueOf(System.currentTimeMillis() - l), ", halfPhysicalInterval:", Float.valueOf(f), ", interval:", Integer.valueOf(j) });
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
      label217:
      break;
    }
  }
  
  public float getDuration(long paramLong)
  {
    amrn localamrn = (amrn)this.tickerMap.get(Long.valueOf(paramLong));
    if (localamrn != null) {
      return localamrn.jdField_a_of_type_Int / 60.0F;
    }
    return 0.0F;
  }
  
  public int getInterval(long paramLong)
  {
    amrn localamrn = (amrn)this.tickerMap.get(Long.valueOf(paramLong));
    if (localamrn != null) {
      return localamrn.jdField_a_of_type_Int;
    }
    return 1;
  }
  
  public native void nativeCallbackTicker(long paramLong, double paramDouble1, double paramDouble2);
  
  public native boolean nativeGetNeedRecord(long paramLong);
  
  public native void nativeSetRecorderMode(long paramLong, boolean paramBoolean);
  
  public void pauseTicker(long paramLong)
  {
    amrn localamrn;
    try
    {
      localamrn = (amrn)this.tickerMap.get(Long.valueOf(paramLong));
      if (localamrn == null)
      {
        QLog.e("sava_ApolloTicker", 1, "[pauseTicker], null error. ticker:" + paramLong);
        return;
      }
      String str = "";
      if (localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
        str = localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.a();
      }
      QLog.d("sava_ApolloTicker", 1, new Object[] { "pauseTicker ticker = ", Long.valueOf(paramLong), ",thread=", Long.valueOf(Thread.currentThread().getId()), ",intervalFps:", str });
      if (localamrn.jdField_a_of_type_JavaUtilTimer == null) {
        return;
      }
      if (!this.mTimerAlive)
      {
        localamrn.jdField_a_of_type_JavaUtilTimer.cancel();
        localamrn.jdField_a_of_type_JavaUtilTimer.purge();
        localamrn.jdField_a_of_type_JavaUtilTimer = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("sava_ApolloTicker", 2, "pause ticker error=" + localThrowable.toString());
      return;
    }
    if (localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
      localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.cancel();
    }
  }
  
  public void resumeTicker(long paramLong)
  {
    for (;;)
    {
      try
      {
        amrn localamrn = (amrn)this.tickerMap.get(Long.valueOf(paramLong));
        if (localamrn == null)
        {
          QLog.e("sava_ApolloTicker", 1, "[resumeTicker], null error. ticker:" + paramLong);
          return;
        }
        View localView = ApolloRender.getRenderViewByThreadId();
        int i = localamrn.jdField_a_of_type_Int;
        if ((localView == null) || (localamrn.jdField_a_of_type_JavaUtilTimer != null)) {
          break;
        }
        if (localamrn.jdField_a_of_type_JavaUtilTimer != null)
        {
          if (!this.mTimerAlive)
          {
            localamrn.jdField_a_of_type_JavaUtilTimer.cancel();
            localamrn.jdField_a_of_type_JavaUtilTimer.purge();
            localamrn.jdField_a_of_type_JavaUtilTimer = null;
          }
        }
        else
        {
          QLog.d("sava_ApolloTicker", 1, "resumeTicker ticker = " + paramLong + ",thread=" + Thread.currentThread().getId());
          ApolloTicker.NativeDrawTask localNativeDrawTask = new ApolloTicker.NativeDrawTask(this, localView, paramLong, i);
          Timer localTimer = getTimer();
          localTimer.scheduleAtFixedRate(localNativeDrawTask, 0L, i * 16);
          localamrn.jdField_a_of_type_JavaUtilTimer = localTimer;
          localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask = localNativeDrawTask;
          if ((localView == null) || (!(localView instanceof ApolloTextureView))) {
            break;
          }
          ((ApolloTextureView)localView).getRender().isRunning = true;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("sava_ApolloTicker", 2, "pause ticker error=" + localThrowable.toString());
        return;
      }
      if (localThrowable.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
        localThrowable.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.cancel();
      }
    }
  }
  
  public void setInterval(long paramLong, int paramInt)
  {
    if (paramInt == 1) {}
    amrn localamrn;
    do
    {
      return;
      this.mInterval = paramInt;
      localamrn = (amrn)this.tickerMap.get(Long.valueOf(paramLong));
      if (localamrn == null)
      {
        QLog.e("sava_ApolloTicker", 1, "setInterval tickerInfo null");
        return;
      }
      localObject = ApolloRender.getRenderViewByThreadId();
    } while (localObject == null);
    QLog.d("sava_ApolloTicker", 1, "ScheduledExecutorService setInterval call = " + paramInt + " thread=" + Thread.currentThread().getId());
    Timer localTimer = localamrn.jdField_a_of_type_JavaUtilTimer;
    if ((!this.mTimerAlive) && (localTimer != null))
    {
      localTimer.cancel();
      localTimer.purge();
    }
    if (localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
      localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.cancel();
    }
    Object localObject = new ApolloTicker.NativeDrawTask(this, (View)localObject, paramLong, paramInt);
    localTimer = getTimer();
    localTimer.scheduleAtFixedRate((TimerTask)localObject, 0L, paramInt * 16);
    localamrn.jdField_a_of_type_JavaUtilTimer = localTimer;
    localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask = ((ApolloTicker.NativeDrawTask)localObject);
    localamrn.jdField_a_of_type_Int = paramInt;
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
      amrn localamrn = (amrn)localIterator.next();
      if ((localamrn != null) && (localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null)) {
        localamrn.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.a(paramView);
      }
    }
    QLog.i("sava_ApolloTicker", 1, "setRenderView size:" + this.tickerMap.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTicker
 * JD-Core Version:    0.7.0.1
 */