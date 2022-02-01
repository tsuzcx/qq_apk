package com.tencent.aelight.camera.ae.camera.ui;

import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.CountDownSetting;
import com.tencent.aelight.camera.ae.view.CountDownView;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aebase.view.IAECaptureButton.CountDownDelegate;

class VideoStoryPiecesPart$11$1
  implements IAECaptureButton.CountDownDelegate
{
  VideoStoryPiecesPart$11$1(VideoStoryPiecesPart.11 param11, AEVideoStoryTopBarViewModel.CountDownSetting paramCountDownSetting) {}
  
  public void a()
  {
    if (VideoStoryPiecesPart.N(this.b.a) != null) {
      VideoStoryPiecesPart.N(this.b.a).a(this.a.b(), false);
    }
    VideoStoryPiecesPart.B(this.b.a).setTouchEnable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.11.1
 * JD-Core Version:    0.7.0.1
 */