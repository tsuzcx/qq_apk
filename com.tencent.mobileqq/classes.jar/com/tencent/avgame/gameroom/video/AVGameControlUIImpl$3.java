package com.tencent.avgame.gameroom.video;

import android.os.Handler;
import com.tencent.avgame.qav.AVGameCameraAssistant.CameraEventListener;
import com.tencent.avgame.report.AVGameQualityCameraReportUtil;
import com.tencent.avgame.ui.AVGameHandler;

class AVGameControlUIImpl$3
  implements AVGameCameraAssistant.CameraEventListener
{
  AVGameControlUIImpl$3(AVGameControlUIImpl paramAVGameControlUIImpl) {}
  
  public void a()
  {
    AVGameHandler.a().b().post(new AVGameControlUIImpl.3.4(this));
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, boolean paramBoolean) {}
  
  public void b(long paramLong)
  {
    AVGameHandler.a().b().post(new AVGameControlUIImpl.3.3(this, paramLong));
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    AVGameHandler.a().b().post(new AVGameControlUIImpl.3.1(this));
    AVGameQualityCameraReportUtil.a(paramBoolean);
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    AVGameHandler.a().b().post(new AVGameControlUIImpl.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.3
 * JD-Core Version:    0.7.0.1
 */