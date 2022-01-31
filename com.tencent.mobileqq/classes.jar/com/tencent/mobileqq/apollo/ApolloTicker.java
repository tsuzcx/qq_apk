package com.tencent.mobileqq.apollo;

import android.view.View;
import com.tencent.mobileqq.apollo.data.ApolloTickerInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import ync;

public class ApolloTicker
{
  public static final String TAG = "ApolloTicker";
  public long ticker;
  private Map tickerMap = new HashMap();
  
  public ApolloTicker()
  {
    QLog.d("ApolloTicker", 1, "tickerObj new");
  }
  
  public void createTicker(long paramLong)
  {
    QLog.d("ApolloTicker", 1, "ApolloTicker  thread=" + Thread.currentThread().getId() + "ticker = " + paramLong);
    Object localObject = ApolloRender.getRenderViewByThreadId();
    this.ticker = paramLong;
    if (localObject == null)
    {
      QLog.e("ApolloTicker", 1, "fail to createTicker.");
      return;
    }
    Timer localTimer = new Timer();
    localObject = new ync(this, (View)localObject, paramLong, 3L);
    ApolloTickerInfo localApolloTickerInfo = new ApolloTickerInfo();
    localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer = localTimer;
    localApolloTickerInfo.jdField_a_of_type_Int = 1;
    localApolloTickerInfo.jdField_a_of_type_JavaUtilTimerTask = ((TimerTask)localObject);
    localTimer.scheduleAtFixedRate((TimerTask)localObject, 0L, 16L);
    this.tickerMap.put(Long.valueOf(paramLong), localApolloTickerInfo);
  }
  
  public void disposeTicker(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTicker", 2, "disposeTicker ticker = " + paramLong + ",thread=" + Thread.currentThread().getId());
    }
    ApolloTickerInfo localApolloTickerInfo = (ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
    if (localApolloTickerInfo == null)
    {
      QLog.e("ApolloTicker", 1, "[disposeTicker], null error. ticker:" + paramLong);
      return;
    }
    Timer localTimer = localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer;
    if (localTimer != null) {
      localTimer.cancel();
    }
    localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer = null;
    localApolloTickerInfo = (ApolloTickerInfo)this.tickerMap.remove(Long.valueOf(paramLong));
  }
  
  public native void nativeCallbackTicker(long paramLong, double paramDouble1, double paramDouble2);
  
  public void pauseTicker(long paramLong)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTicker", 2, "pauseTicker ticker = " + paramLong + ",thread=" + Thread.currentThread().getId());
      }
      ApolloTickerInfo localApolloTickerInfo = (ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
      if (localApolloTickerInfo == null)
      {
        QLog.e("ApolloTicker", 1, "[pauseTicker], null error. ticker:" + paramLong);
        return;
      }
      if (localApolloTickerInfo.jdField_a_of_type_JavaUtilTimerTask != null) {
        localApolloTickerInfo.jdField_a_of_type_JavaUtilTimerTask.cancel();
      }
      if (localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer != null)
      {
        Timer localTimer = localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer;
        if (localTimer != null)
        {
          localTimer.cancel();
          localTimer.purge();
        }
        localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloTicker", 2, "pause ticker error=" + localThrowable.toString());
    }
  }
  
  public void resumeTicker(long paramLong)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTicker", 2, "resumeTicker ticker = " + paramLong + ",thread=" + Thread.currentThread().getId());
      }
      ApolloTickerInfo localApolloTickerInfo = (ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
      if (localApolloTickerInfo == null)
      {
        QLog.e("ApolloTicker", 1, "[resumeTicker], null error. ticker:" + paramLong);
        return;
      }
      View localView = ApolloRender.getRenderViewByThreadId();
      int i = localApolloTickerInfo.jdField_a_of_type_Int;
      if ((localView != null) && (localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer == null))
      {
        ync localync = new ync(this, localView, paramLong, i);
        Timer localTimer = new Timer();
        localTimer.scheduleAtFixedRate(localync, 0L, i * 16);
        localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer = localTimer;
        localApolloTickerInfo.jdField_a_of_type_JavaUtilTimerTask = localync;
        if ((localView != null) && ((localView instanceof ApolloTextureView)))
        {
          ((ApolloTextureView)localView).getRender().isRunning = true;
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloTicker", 2, "pause ticker error=" + localThrowable.toString());
    }
  }
  
  public void setInterval(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTicker", 2, "setInterval call = " + paramInt + " thread=" + Thread.currentThread().getId());
    }
    ApolloTickerInfo localApolloTickerInfo = (ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
    if (localApolloTickerInfo == null) {}
    do
    {
      return;
      localObject = ApolloRender.getRenderViewByThreadId();
    } while (localObject == null);
    if ((localObject instanceof ApolloTextureView)) {
      paramInt = 3;
    }
    int i = paramInt;
    if ((localObject instanceof ApolloSurfaceView))
    {
      i = paramInt;
      if (!((ApolloSurfaceView)localObject).isGameMode()) {
        i = 3;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTicker", 2, "real interval:" + i);
    }
    localApolloTickerInfo.jdField_a_of_type_JavaUtilTimerTask.cancel();
    Timer localTimer = localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer;
    if (localTimer != null)
    {
      localTimer.cancel();
      localTimer.purge();
    }
    Object localObject = new ync(this, (View)localObject, paramLong, i);
    localTimer = new Timer();
    localTimer.scheduleAtFixedRate((TimerTask)localObject, 0L, i * 16);
    localApolloTickerInfo.jdField_a_of_type_JavaUtilTimer = localTimer;
    localApolloTickerInfo.jdField_a_of_type_JavaUtilTimerTask = ((TimerTask)localObject);
    localApolloTickerInfo.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTicker
 * JD-Core Version:    0.7.0.1
 */