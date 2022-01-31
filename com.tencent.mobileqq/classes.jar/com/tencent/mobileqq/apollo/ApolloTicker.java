package com.tencent.mobileqq.apollo;

import akji;
import akod;
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
  public boolean mTickerUseGlobalTimer;
  public boolean mTimerAlive;
  public long ticker;
  private Map<Long, akod> tickerMap = new HashMap();
  
  public ApolloTicker()
  {
    QLog.d("sava_ApolloTicker", 1, "tickerObj new");
  }
  
  private Timer getTimer()
  {
    Object localObject = ApolloUtil.a();
    if ((this.mTickerUseGlobalTimer) && (localObject != null) && (((akji)localObject).jdField_a_of_type_JavaUtilTimer != null))
    {
      localObject = ((akji)localObject).jdField_a_of_type_JavaUtilTimer;
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
      akod localakod = new akod();
      localakod.jdField_a_of_type_JavaUtilTimer = localTimer;
      localakod.jdField_a_of_type_Int = 1;
      localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask = ((ApolloTicker.NativeDrawTask)localObject);
      localTimer.scheduleAtFixedRate((TimerTask)localObject, 0L, 16L);
      this.tickerMap.put(Long.valueOf(paramLong), localakod);
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
    akod localakod = (akod)this.tickerMap.get(Long.valueOf(paramLong));
    if (localakod == null)
    {
      QLog.e("sava_ApolloTicker", 1, "[disposeTicker], null error. ticker:" + paramLong);
      return;
    }
    Timer localTimer = localakod.jdField_a_of_type_JavaUtilTimer;
    if (!this.mTimerAlive) {
      if (localTimer != null)
      {
        localTimer.cancel();
        localTimer.purge();
      }
    }
    for (;;)
    {
      localakod.jdField_a_of_type_JavaUtilTimer = null;
      localakod = (akod)this.tickerMap.remove(Long.valueOf(paramLong));
      return;
      if (localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
        localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.cancel();
      }
    }
  }
  
  public float getDuration(long paramLong)
  {
    akod localakod = (akod)this.tickerMap.get(Long.valueOf(paramLong));
    if (localakod != null) {
      return localakod.jdField_a_of_type_Int / 60.0F;
    }
    return 0.0F;
  }
  
  public int getInterval(long paramLong)
  {
    akod localakod = (akod)this.tickerMap.get(Long.valueOf(paramLong));
    if (localakod != null) {
      return localakod.jdField_a_of_type_Int;
    }
    return 1;
  }
  
  public native void nativeCallbackTicker(long paramLong, double paramDouble1, double paramDouble2);
  
  public void pauseTicker(long paramLong)
  {
    akod localakod;
    try
    {
      localakod = (akod)this.tickerMap.get(Long.valueOf(paramLong));
      if (localakod == null)
      {
        QLog.e("sava_ApolloTicker", 1, "[pauseTicker], null error. ticker:" + paramLong);
        return;
      }
      String str = "";
      if (localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
        str = localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.a();
      }
      QLog.d("sava_ApolloTicker", 1, new Object[] { "pauseTicker ticker = ", Long.valueOf(paramLong), ",thread=", Long.valueOf(Thread.currentThread().getId()), ",intervalFps:", str });
      if (localakod.jdField_a_of_type_JavaUtilTimer == null) {
        return;
      }
      if (!this.mTimerAlive)
      {
        localakod.jdField_a_of_type_JavaUtilTimer.cancel();
        localakod.jdField_a_of_type_JavaUtilTimer.purge();
        localakod.jdField_a_of_type_JavaUtilTimer = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("sava_ApolloTicker", 2, "pause ticker error=" + localThrowable.toString());
      return;
    }
    if (localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
      localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.cancel();
    }
  }
  
  public void resumeTicker(long paramLong)
  {
    for (;;)
    {
      try
      {
        akod localakod = (akod)this.tickerMap.get(Long.valueOf(paramLong));
        if (localakod == null)
        {
          QLog.e("sava_ApolloTicker", 1, "[resumeTicker], null error. ticker:" + paramLong);
          return;
        }
        View localView = ApolloRender.getRenderViewByThreadId();
        int i = localakod.jdField_a_of_type_Int;
        if ((localView == null) || (localakod.jdField_a_of_type_JavaUtilTimer != null)) {
          break;
        }
        if (localakod.jdField_a_of_type_JavaUtilTimer != null)
        {
          if (!this.mTimerAlive)
          {
            localakod.jdField_a_of_type_JavaUtilTimer.cancel();
            localakod.jdField_a_of_type_JavaUtilTimer.purge();
            localakod.jdField_a_of_type_JavaUtilTimer = null;
          }
        }
        else
        {
          QLog.d("sava_ApolloTicker", 1, "resumeTicker ticker = " + paramLong + ",thread=" + Thread.currentThread().getId());
          ApolloTicker.NativeDrawTask localNativeDrawTask = new ApolloTicker.NativeDrawTask(this, localView, paramLong, i);
          Timer localTimer = getTimer();
          localTimer.scheduleAtFixedRate(localNativeDrawTask, 0L, i * 16);
          localakod.jdField_a_of_type_JavaUtilTimer = localTimer;
          localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask = localNativeDrawTask;
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
    akod localakod;
    do
    {
      return;
      this.mInterval = paramInt;
      localakod = (akod)this.tickerMap.get(Long.valueOf(paramLong));
      if (localakod == null)
      {
        QLog.e("sava_ApolloTicker", 1, "setInterval tickerInfo null");
        return;
      }
      localObject = ApolloRender.getRenderViewByThreadId();
    } while (localObject == null);
    QLog.d("sava_ApolloTicker", 1, "ScheduledExecutorService setInterval call = " + paramInt + " thread=" + Thread.currentThread().getId());
    Timer localTimer = localakod.jdField_a_of_type_JavaUtilTimer;
    if ((!this.mTimerAlive) && (localTimer != null))
    {
      localTimer.cancel();
      localTimer.purge();
    }
    if (localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null) {
      localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.cancel();
    }
    Object localObject = new ApolloTicker.NativeDrawTask(this, (View)localObject, paramLong, paramInt);
    localTimer = getTimer();
    localTimer.scheduleAtFixedRate((TimerTask)localObject, 0L, paramInt * 16);
    localakod.jdField_a_of_type_JavaUtilTimer = localTimer;
    localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask = ((ApolloTicker.NativeDrawTask)localObject);
    localakod.jdField_a_of_type_Int = paramInt;
  }
  
  public void setRenderView(View paramView)
  {
    Iterator localIterator = this.tickerMap.values().iterator();
    while (localIterator.hasNext())
    {
      akod localakod = (akod)localIterator.next();
      if ((localakod != null) && (localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask != null)) {
        localakod.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker$NativeDrawTask.a(paramView);
      }
    }
    QLog.i("sava_ApolloTicker", 1, "setRenderView size:" + this.tickerMap.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTicker
 * JD-Core Version:    0.7.0.1
 */