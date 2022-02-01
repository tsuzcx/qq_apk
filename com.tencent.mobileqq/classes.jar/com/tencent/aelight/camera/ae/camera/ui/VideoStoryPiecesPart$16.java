package com.tencent.aelight.camera.ae.camera.ui;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;

class VideoStoryPiecesPart$16
  implements Observer<Boolean>
{
  VideoStoryPiecesPart$16(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    VideoStoryPiecesPart.G(this.a);
    VideoStoryPiecesPart.I(this.a);
    if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
      VideoStoryPiecesPart.W(this.a);
    }
    VideoStoryPiecesPart.J(this.a);
    if (paramBoolean != null) {
      VideoStoryPiecesPart.b(this.a, paramBoolean.booleanValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.16
 * JD-Core Version:    0.7.0.1
 */