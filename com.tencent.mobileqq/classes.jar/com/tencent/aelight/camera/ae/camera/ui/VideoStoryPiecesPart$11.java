package com.tencent.aelight.camera.ae.camera.ui;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.CountDownSetting;
import com.tencent.aelight.camera.ae.view.CountDownView;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;

class VideoStoryPiecesPart$11
  implements Observer<AEVideoStoryTopBarViewModel.CountDownSetting>
{
  VideoStoryPiecesPart$11(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.CountDownSetting paramCountDownSetting)
  {
    if (paramCountDownSetting == null) {
      return;
    }
    boolean bool = paramCountDownSetting.a();
    if (bool) {
      VideoStoryPiecesPart.P(this.a);
    } else if (VideoStoryPiecesPart.N(this.a) != null) {
      VideoStoryPiecesPart.N(this.a).a();
    }
    VideoStoryPiecesPart.B(this.a).a(bool, new VideoStoryPiecesPart.11.1(this, paramCountDownSetting));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.11
 * JD-Core Version:    0.7.0.1
 */