package com.tencent.biz.qcircleshadow.lib;

import android.os.Looper;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;

public class QCircleHostQzoneThreadHelper
{
  public static Looper getBackGroundLooper()
  {
    return QCircleServiceImpl.getQZoneService().getBackGroundLooper();
  }
  
  public static Looper getBusinessThreadLooper()
  {
    return QCircleServiceImpl.getQZoneService().getBusinessThreadLooper();
  }
  
  public static Looper getRealTimeLooper()
  {
    return QCircleServiceImpl.getQZoneService().getRealTimeLooper();
  }
  
  public static int getVideoThreadId()
  {
    return QCircleServiceImpl.getQZoneService().getVideoThreadId();
  }
  
  public static void postBackGoundThread(Runnable paramRunnable)
  {
    QCircleServiceImpl.getQZoneService().postBackGoundThread(paramRunnable, 0L);
  }
  
  public static void postBackGoundThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    QCircleServiceImpl.getQZoneService().postBackGoundThread(paramRunnable, paramLong);
  }
  
  public static void postNormalThread(Runnable paramRunnable)
  {
    QCircleServiceImpl.getQZoneService().postNormalThread(paramRunnable, 0L);
  }
  
  public static void postNormalThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    QCircleServiceImpl.getQZoneService().postNormalThread(paramRunnable, paramLong);
  }
  
  public static void postRealTimeThread(Runnable paramRunnable)
  {
    QCircleServiceImpl.getQZoneService().postRealTimeThread(paramRunnable, 0L);
  }
  
  public static void postRealTimeThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    QCircleServiceImpl.getQZoneService().postRealTimeThread(paramRunnable, paramLong);
  }
  
  public static void postReportThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    QCircleServiceImpl.getQZoneService().postReportThreadThread(paramRunnable, paramLong);
  }
  
  public static void postReportThreadThread(Runnable paramRunnable)
  {
    QCircleServiceImpl.getQZoneService().postReportThreadThread(paramRunnable, 0L);
  }
  
  public static void postVideoThread(Runnable paramRunnable)
  {
    QCircleServiceImpl.getQZoneService().postVideoThread(paramRunnable, 0L);
  }
  
  public static void postVideoThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    QCircleServiceImpl.getQZoneService().postVideoThread(paramRunnable, paramLong);
  }
  
  public static void removeBackGroundThreadTask(Runnable paramRunnable)
  {
    QCircleServiceImpl.getQZoneService().removeBackGroundThreadTask(paramRunnable);
  }
  
  public static void removeRealTimeThreadTask(Runnable paramRunnable)
  {
    QCircleServiceImpl.getQZoneService().removeRealTimeThreadTask(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper
 * JD-Core Version:    0.7.0.1
 */