package com.tencent.aelight.camera.ae.camera.ui;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.CountDownSetting;
import com.tencent.aelight.camera.ae.view.CountDownView;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;

class VideoStoryPiecesPart$10
  implements Observer<AEVideoStoryTopBarViewModel.CountDownSetting>
{
  VideoStoryPiecesPart$10(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.CountDownSetting paramCountDownSetting)
  {
    if (paramCountDownSetting == null) {
      return;
    }
    boolean bool = paramCountDownSetting.a();
    if (bool) {
      VideoStoryPiecesPart.e(this.a);
    } else if (VideoStoryPiecesPart.a(this.a) != null) {
      VideoStoryPiecesPart.a(this.a).a();
    }
    VideoStoryPiecesPart.a(this.a).a(bool, new VideoStoryPiecesPart.10.1(this, paramCountDownSetting));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.10
 * JD-Core Version:    0.7.0.1
 */