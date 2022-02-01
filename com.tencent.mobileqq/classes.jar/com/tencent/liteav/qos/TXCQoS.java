package com.tencent.liteav.qos;

import android.os.Handler;
import com.tencent.liteav.basic.a.c;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TXCQoS
{
  public static final int AUTO_ADJUST_LIVEPUSH_RESOLUTION_STRATEGY = 1;
  public static final int AUTO_ADJUST_REALTIME_VIDEOCHAT_STRATEGY = 5;
  private static final Map<Integer, c> RESOLUTION_MAP;
  static final String TAG = "TXCQos";
  private int mAutoStrategy = -1;
  private int mBitrate = 0;
  private Handler mHandler = new Handler();
  private int mHeight = 0;
  private long mInstance;
  private long mInterval = 1000L;
  private boolean mIsEnableDrop = false;
  private a mListener;
  private b mNotifyListener;
  private Runnable mRunnable = new TXCQoS.1(this);
  private String mUserID = "";
  private int mWidth = 0;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), c.b);
    localHashMap.put(Integer.valueOf(1), c.c);
    localHashMap.put(Integer.valueOf(2), c.d);
    localHashMap.put(Integer.valueOf(3), c.e);
    localHashMap.put(Integer.valueOf(4), c.f);
    localHashMap.put(Integer.valueOf(5), c.g);
    localHashMap.put(Integer.valueOf(6), c.h);
    localHashMap.put(Integer.valueOf(7), c.i);
    localHashMap.put(Integer.valueOf(8), c.j);
    localHashMap.put(Integer.valueOf(9), c.k);
    localHashMap.put(Integer.valueOf(10), c.l);
    localHashMap.put(Integer.valueOf(11), c.m);
    localHashMap.put(Integer.valueOf(12), c.n);
    localHashMap.put(Integer.valueOf(13), c.o);
    localHashMap.put(Integer.valueOf(14), c.p);
    localHashMap.put(Integer.valueOf(15), c.q);
    localHashMap.put(Integer.valueOf(16), c.r);
    localHashMap.put(Integer.valueOf(17), c.s);
    localHashMap.put(Integer.valueOf(18), c.t);
    localHashMap.put(Integer.valueOf(19), c.u);
    RESOLUTION_MAP = Collections.unmodifiableMap(localHashMap);
    f.f();
  }
  
  public TXCQoS(boolean paramBoolean)
  {
    this.mInstance = nativeInit(paramBoolean);
  }
  
  public static c getProperResolutionByVideoBitrate(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramInt1 = nativeGetProperResolutionByVideoBitrate(paramBoolean, paramInt1, paramInt2);
    return (c)RESOLUTION_MAP.get(Integer.valueOf(paramInt1));
  }
  
  private native void nativeAddQueueInputSize(long paramLong, int paramInt);
  
  private native void nativeAddQueueOutputSize(long paramLong, int paramInt);
  
  private native void nativeAdjustBitrate(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private native void nativeDeinit(long paramLong);
  
  private native int nativeGetBitrate(long paramLong);
  
  private native int nativeGetHeight(long paramLong);
  
  private static native int nativeGetProperResolutionByVideoBitrate(boolean paramBoolean, int paramInt1, int paramInt2);
  
  private native int nativeGetWidth(long paramLong);
  
  private native long nativeInit(boolean paramBoolean);
  
  private native boolean nativeIsEnableDrop(long paramLong);
  
  private native void nativeReset(long paramLong, boolean paramBoolean);
  
  private native void nativeSetAutoAdjustBitrate(long paramLong, boolean paramBoolean);
  
  private native void nativeSetAutoAdjustStrategy(long paramLong, int paramInt);
  
  private native void nativeSetHasVideo(long paramLong, boolean paramBoolean);
  
  private native void nativeSetVideoDefaultResolution(long paramLong, int paramInt);
  
  private native void nativeSetVideoEncBitrate(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeSetVideoExpectBitrate(long paramLong, int paramInt);
  
  private native void nativeSetVideoRealBitrate(long paramLong, int paramInt);
  
  protected void finalize()
  {
    try
    {
      nativeDeinit(this.mInstance);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public String getUserID()
  {
    return this.mUserID;
  }
  
  public boolean isEnableDrop()
  {
    return nativeIsEnableDrop(this.mInstance);
  }
  
  public void reset(boolean paramBoolean)
  {
    nativeReset(this.mInstance, paramBoolean);
  }
  
  public void setAutoAdjustBitrate(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("autoAdjustBitrate is ");
    String str;
    if (paramBoolean) {
      str = "yes";
    } else {
      str = "no";
    }
    localStringBuilder.append(str);
    TXCLog.i("TXCQos", localStringBuilder.toString());
    nativeSetAutoAdjustBitrate(this.mInstance, paramBoolean);
  }
  
  public void setAutoAdjustStrategy(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("autoAdjustStrategy is ");
    localStringBuilder.append(paramInt);
    TXCLog.i("TXCQos", localStringBuilder.toString());
    nativeSetAutoAdjustStrategy(this.mInstance, paramInt);
    this.mAutoStrategy = paramInt;
  }
  
  public void setDefaultVideoResolution(c paramc)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DefaultVideoResolution is ");
    ((StringBuilder)localObject).append(paramc);
    TXCLog.i("TXCQos", ((StringBuilder)localObject).toString());
    int i = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    localObject = RESOLUTION_MAP.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (localEntry.getValue() == paramc) {
        i = ((Integer)localEntry.getKey()).intValue();
      }
    }
    nativeSetVideoDefaultResolution(this.mInstance, i);
  }
  
  public void setHasVideo(boolean paramBoolean)
  {
    nativeSetHasVideo(this.mInstance, paramBoolean);
  }
  
  public void setListener(a parama)
  {
    this.mListener = parama;
  }
  
  public void setNotifyListener(b paramb)
  {
    this.mNotifyListener = paramb;
  }
  
  public void setUserID(String paramString)
  {
    this.mUserID = paramString;
  }
  
  public void setVideoEncBitrate(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mBitrate = 0;
    nativeSetVideoEncBitrate(this.mInstance, paramInt1, paramInt2, paramInt3);
  }
  
  public void setVideoExpectBitrate(int paramInt)
  {
    nativeSetVideoExpectBitrate(this.mInstance, paramInt);
  }
  
  public void start(long paramLong)
  {
    this.mInterval = paramLong;
    this.mHandler.postDelayed(this.mRunnable, this.mInterval);
  }
  
  public void stop()
  {
    this.mHandler.removeCallbacks(this.mRunnable);
    this.mAutoStrategy = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.qos.TXCQoS
 * JD-Core Version:    0.7.0.1
 */