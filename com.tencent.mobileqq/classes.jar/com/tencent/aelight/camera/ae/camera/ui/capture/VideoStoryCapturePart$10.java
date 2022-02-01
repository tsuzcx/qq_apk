package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.reactive.SimpleObserver;
import mqq.os.MqqHandler;

class VideoStoryCapturePart$10
  extends SimpleObserver<GenerateContext>
{
  VideoStoryCapturePart$10(VideoStoryCapturePart paramVideoStoryCapturePart, long paramLong, int paramInt) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    AEQLog.b("VideoStoryCapturePart", "generate observer --- onNext");
    VideoStoryCapturePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiCaptureVideoStoryCapturePart, paramGenerateContext, this.jdField_a_of_type_Int);
  }
  
  public void onCancel()
  {
    AEQLog.b("VideoStoryCapturePart", "generate observer --- onCancel");
  }
  
  public void onComplete()
  {
    AEQLog.b("VideoStoryCapturePart", "generate observer --- onComplete");
  }
  
  public void onError(@NonNull Error paramError)
  {
    AEQLog.a("VideoStoryCapturePart", "generate observer --- onError", paramError);
    ThreadManager.getUIHandler().post(new VideoStoryCapturePart.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.10
 * JD-Core Version:    0.7.0.1
 */