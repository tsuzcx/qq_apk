package com.tencent.ilivesdk.avpreloadservice;

import android.graphics.Bitmap;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface.TaskReportInfo;
import java.util.List;

public abstract interface AVPreloadEngine$PreloadResultListener
{
  public abstract void a(AVPreloadTaskInterface paramAVPreloadTaskInterface);
  
  public abstract void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, Bitmap paramBitmap, boolean paramBoolean);
  
  public abstract void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, String paramString, long paramLong);
  
  public abstract void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, String paramString, AVPreloadTaskInterface.TaskReportInfo paramTaskReportInfo);
  
  public abstract void a(List<Long> paramList);
  
  public abstract void b(AVPreloadTaskInterface paramAVPreloadTaskInterface);
  
  public abstract void c(AVPreloadTaskInterface paramAVPreloadTaskInterface);
  
  public abstract void d(AVPreloadTaskInterface paramAVPreloadTaskInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.PreloadResultListener
 * JD-Core Version:    0.7.0.1
 */