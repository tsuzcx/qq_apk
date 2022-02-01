package com.tencent.ilivesdk.avpreloadplayerservice;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerPreloadAdapter.AVPreloadListener;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface.TaskReportInfo;

class AVPreloadPlayerService$1
  implements AVPlayerPreloadAdapter.AVPreloadListener
{
  AVPreloadPlayerService$1(AVPreloadPlayerService paramAVPreloadPlayerService) {}
  
  public void a(String paramString, long paramLong, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    paramAVPreloadTaskInterface = AVPreloadPlayerService.k(this.a).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload---onTaskGapTime url=");
    localStringBuilder.append(paramString);
    paramAVPreloadTaskInterface.i("AVPreloadPlayerService", localStringBuilder.toString(), new Object[0]);
    AVPreloadPlayerService.a(this.a).C = paramLong;
  }
  
  public void a(String paramString, AVPreloadTaskInterface.TaskReportInfo paramTaskReportInfo, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    LogInterface localLogInterface = AVPreloadPlayerService.c(this.a).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload---onTaskPreloadFinish url=");
    localStringBuilder.append(paramString);
    localLogInterface.i("AVPreloadPlayerService", localStringBuilder.toString(), new Object[0]);
    if (paramTaskReportInfo != null)
    {
      AVPreloadPlayerService.a(this.a).B = (paramTaskReportInfo.d() / 1024);
      AVPreloadPlayerService.a(this.a).r = paramTaskReportInfo.b();
      AVPreloadPlayerService.a(this.a).q = paramTaskReportInfo.a();
      AVPreloadPlayerService.a(this.a).D = paramTaskReportInfo.c();
    }
    AVPreloadPlayerService.a(this.a).j = paramAVPreloadTaskInterface.b();
    AVPreloadPlayerService.a(this.a).k = paramAVPreloadTaskInterface.c();
    AVPreloadPlayerService.a(this.a).u = paramAVPreloadTaskInterface.k();
    paramString = AVPreloadPlayerService.a(this.a);
    paramTaskReportInfo = new StringBuilder();
    paramTaskReportInfo.append("");
    paramTaskReportInfo.append(paramAVPreloadTaskInterface.r());
    paramString.E = paramTaskReportInfo.toString();
    AVPreloadPlayerService.a(this.a).F = paramAVPreloadTaskInterface.f();
    AVPreloadPlayerService.a(this.a).G = (paramAVPreloadTaskInterface.i() / 1024L);
  }
  
  public void a(String paramString, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    AVPreloadPlayerService.a(this.a).j = paramAVPreloadTaskInterface.b();
    paramAVPreloadTaskInterface = AVPreloadPlayerService.b(this.a).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload---onTaskPreloadStart url=");
    localStringBuilder.append(paramString);
    paramAVPreloadTaskInterface.i("AVPreloadPlayerService", localStringBuilder.toString(), new Object[0]);
  }
  
  public void b(String paramString, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    LogInterface localLogInterface = AVPreloadPlayerService.d(this.a).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload---onTaskFailed url=");
    localStringBuilder.append(paramString);
    localLogInterface.i("AVPreloadPlayerService", localStringBuilder.toString(), new Object[0]);
    AVPreloadPlayerService.a(this.a).z = paramAVPreloadTaskInterface.n();
  }
  
  public void c(String paramString, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    paramAVPreloadTaskInterface = AVPreloadPlayerService.e(this.a).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload---onTaskCompleted url=");
    localStringBuilder.append(paramString);
    paramAVPreloadTaskInterface.i("AVPreloadPlayerService", localStringBuilder.toString(), new Object[0]);
  }
  
  public void d(String paramString, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    LogInterface localLogInterface = AVPreloadPlayerService.f(this.a).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload---onTaskStop url=");
    localStringBuilder.append(paramString);
    localLogInterface.i("AVPreloadPlayerService", localStringBuilder.toString(), new Object[0]);
    AVPreloadPlayerService.a(this.a).l = paramAVPreloadTaskInterface.d();
  }
  
  public void e(String paramString, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    LogInterface localLogInterface = AVPreloadPlayerService.g(this.a).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload---onTaskFirstFrame url=");
    localStringBuilder.append(paramString);
    localLogInterface.i("AVPreloadPlayerService", localStringBuilder.toString(), new Object[0]);
    AVPreloadPlayerService.a(this.a).o = paramAVPreloadTaskInterface.e();
    AVPreloadPlayerService.a(this.a).s = paramAVPreloadTaskInterface.l();
    AVPreloadPlayerService.a(this.a).t = paramAVPreloadTaskInterface.m();
    if (AVPreloadPlayerService.h(this.a) != null) {
      AVPreloadPlayerService.i(this.a).onPreloadFirstFrame(paramAVPreloadTaskInterface);
    }
  }
  
  public void f(String paramString, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    paramAVPreloadTaskInterface = AVPreloadPlayerService.j(this.a).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload---onTaskCanPlay url=");
    localStringBuilder.append(paramString);
    paramAVPreloadTaskInterface.i("AVPreloadPlayerService", localStringBuilder.toString(), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.AVPreloadPlayerService.1
 * JD-Core Version:    0.7.0.1
 */