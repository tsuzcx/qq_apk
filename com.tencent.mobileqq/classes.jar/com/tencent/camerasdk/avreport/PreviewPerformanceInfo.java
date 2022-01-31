package com.tencent.camerasdk.avreport;

import android.os.Handler;
import android.os.HandlerThread;

public class PreviewPerformanceInfo
{
  public static final int COUNT_PERIOD = 300;
  private static final String TAG = "PreviewPerformanceInfo";
  private static final PreviewPerformanceInfo ourInstance = new PreviewPerformanceInfo();
  public int counter = 0;
  private Handler mHandler;
  public long memory_sample_count;
  public long render_count;
  public int render_height;
  public int render_width;
  public String sticker_id;
  public long total_memory;
  public long total_render_cost;
  
  public static PreviewPerformanceInfo getInstance()
  {
    return ourInstance;
  }
  
  public static Long getMicTime()
  {
    long l = System.currentTimeMillis();
    Long localLong = Long.valueOf(System.nanoTime());
    l = Long.valueOf(l * 1000L).longValue();
    return Long.valueOf((localLong.longValue() - localLong.longValue() / 1000000L * 1000000L) / 1000L + l);
  }
  
  private void initHandler()
  {
    if (this.mHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("PreviewPerformanceInfo");
      localHandlerThread.start();
      this.mHandler = new Handler(localHandlerThread.getLooper());
    }
  }
  
  private void resetData()
  {
    this.counter = 0;
    this.total_render_cost = 0L;
    this.render_count = 0L;
    this.total_memory = 0L;
    this.memory_sample_count = 0L;
  }
  
  public void destroy()
  {
    this.mHandler.post(new PreviewPerformanceInfo.5(this));
  }
  
  public void report()
  {
    initHandler();
    this.mHandler.post(new PreviewPerformanceInfo.4(this));
  }
  
  public void setResolution(int paramInt1, int paramInt2)
  {
    initHandler();
    this.mHandler.post(new PreviewPerformanceInfo.1(this, paramInt1, paramInt2));
  }
  
  public void setStickerID(String paramString)
  {
    initHandler();
    this.mHandler.post(new PreviewPerformanceInfo.2(this, paramString));
  }
  
  public void updateInfo(long paramLong)
  {
    initHandler();
    this.mHandler.post(new PreviewPerformanceInfo.3(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.PreviewPerformanceInfo
 * JD-Core Version:    0.7.0.1
 */