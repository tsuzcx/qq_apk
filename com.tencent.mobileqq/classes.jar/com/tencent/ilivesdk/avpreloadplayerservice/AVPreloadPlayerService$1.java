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
    AVPreloadPlayerService.h(this.a).getLogger().i("AVPreloadPlayerService", "preload---onTaskGapTime url=" + paramString, new Object[0]);
    AVPreloadPlayerService.a(this.a).k = paramLong;
  }
  
  public void a(String paramString, AVPreloadTaskInterface.TaskReportInfo paramTaskReportInfo, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    AVPreloadPlayerService.b(this.a).getLogger().i("AVPreloadPlayerService", "preload---onTaskPreloadFinish url=" + paramString, new Object[0]);
    if (paramTaskReportInfo != null)
    {
      AVPreloadPlayerService.a(this.a).j = (paramTaskReportInfo.a() / 1024);
      AVPreloadPlayerService.a(this.a).h = paramTaskReportInfo.b();
      AVPreloadPlayerService.a(this.a).g = paramTaskReportInfo.a();
      AVPreloadPlayerService.a(this.a).jdField_c_of_type_Boolean = paramTaskReportInfo.a();
    }
    AVPreloadPlayerService.a(this.a).jdField_b_of_type_Long = paramAVPreloadTaskInterface.a();
    AVPreloadPlayerService.a(this.a).jdField_c_of_type_Long = paramAVPreloadTaskInterface.b();
    AVPreloadPlayerService.a(this.a).jdField_c_of_type_Int = paramAVPreloadTaskInterface.a();
    AVPreloadPlayerService.a(this.a).jdField_l_of_type_JavaLangString = ("" + paramAVPreloadTaskInterface.j());
    AVPreloadPlayerService.a(this.a).jdField_l_of_type_Long = paramAVPreloadTaskInterface.e();
    AVPreloadPlayerService.a(this.a).m = (paramAVPreloadTaskInterface.h() / 1024L);
  }
  
  public void a(String paramString, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    AVPreloadPlayerService.a(this.a).jdField_b_of_type_Long = paramAVPreloadTaskInterface.a();
    AVPreloadPlayerService.a(this.a).getLogger().i("AVPreloadPlayerService", "preload---onTaskPreloadStart url=" + paramString, new Object[0]);
  }
  
  public void b(String paramString, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    AVPreloadPlayerService.c(this.a).getLogger().i("AVPreloadPlayerService", "preload---onTaskFailed url=" + paramString, new Object[0]);
    AVPreloadPlayerService.a(this.a).jdField_d_of_type_Int = paramAVPreloadTaskInterface.d();
  }
  
  public void c(String paramString, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    AVPreloadPlayerService.d(this.a).getLogger().i("AVPreloadPlayerService", "preload---onTaskCompleted url=" + paramString, new Object[0]);
  }
  
  public void d(String paramString, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    AVPreloadPlayerService.e(this.a).getLogger().i("AVPreloadPlayerService", "preload---onTaskStop url=" + paramString, new Object[0]);
    AVPreloadPlayerService.a(this.a).jdField_d_of_type_Long = paramAVPreloadTaskInterface.c();
  }
  
  public void e(String paramString, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    AVPreloadPlayerService.f(this.a).getLogger().i("AVPreloadPlayerService", "preload---onTaskFirstFrame url=" + paramString, new Object[0]);
    AVPreloadPlayerService.a(this.a).e = paramAVPreloadTaskInterface.d();
    AVPreloadPlayerService.a(this.a).a = paramAVPreloadTaskInterface.b();
    AVPreloadPlayerService.a(this.a).jdField_b_of_type_Int = paramAVPreloadTaskInterface.c();
    if (AVPreloadPlayerService.a(this.a) != null) {
      AVPreloadPlayerService.b(this.a).onPreloadFirstFrame(paramAVPreloadTaskInterface);
    }
  }
  
  public void f(String paramString, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    AVPreloadPlayerService.g(this.a).getLogger().i("AVPreloadPlayerService", "preload---onTaskCanPlay url=" + paramString, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.AVPreloadPlayerService.1
 * JD-Core Version:    0.7.0.1
 */