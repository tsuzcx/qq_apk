package com.tencent.biz.qcircleshadow.lib;

import android.os.HandlerThread;
import android.os.Looper;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

public class QCircleHostQzoneThreadHelper
{
  public static Looper getBackGroundLooper()
  {
    return QzoneHandlerThreadFactory.getHandlerThreadLooper("BackGround_HandlerThread");
  }
  
  public static Looper getBusinessThreadLooper()
  {
    return QzoneHandlerThreadFactory.getHandlerThread("Business_HandlerThread").getLooper();
  }
  
  public static Looper getRealTimeLooper()
  {
    return QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").getLooper();
  }
  
  public static int getVideoThreadId()
  {
    return QzoneHandlerThreadFactory.getHandlerThread("Video_HandlerThread").getHandlerThread().getThreadId();
  }
  
  public static void postBackGoundThread(Runnable paramRunnable)
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(paramRunnable);
  }
  
  public static void postBackGoundThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").postDelayed(paramRunnable, paramLong);
  }
  
  public static void postNormalThread(Runnable paramRunnable)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(paramRunnable);
  }
  
  public static void postNormalThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(paramRunnable, paramLong);
  }
  
  public static void postRealTimeThread(Runnable paramRunnable)
  {
    QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").post(paramRunnable);
  }
  
  public static void postRealTimeThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").postDelayed(paramRunnable, paramLong);
  }
  
  public static void postReportThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").postDelayed(paramRunnable, paramLong);
  }
  
  public static void postReportThreadThread(Runnable paramRunnable)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(paramRunnable);
  }
  
  public static void postVideoThread(Runnable paramRunnable)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Video_HandlerThread").post(paramRunnable);
  }
  
  public static void postVideoThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Video_HandlerThread").postDelayed(paramRunnable, paramLong);
  }
  
  public static void removeBackGroundThreadTask(Runnable paramRunnable)
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").removeTask(paramRunnable);
  }
  
  public static void removeRealTimeThreadTask(Runnable paramRunnable)
  {
    QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").removeTask(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper
 * JD-Core Version:    0.7.0.1
 */