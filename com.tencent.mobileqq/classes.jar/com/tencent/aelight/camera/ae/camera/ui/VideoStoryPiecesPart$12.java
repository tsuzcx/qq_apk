package com.tencent.aelight.camera.ae.camera.ui;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.image.URLImageView;

class VideoStoryPiecesPart$12
  implements Observer<Boolean>
{
  VideoStoryPiecesPart$12(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    if (paramBoolean.booleanValue())
    {
      if (VideoStoryPiecesPart.a(this.a).a())
      {
        VideoStoryPiecesPart.d(this.a).setVisibility(0);
        VideoStoryPiecesPart.a(this.a).setVisibility(8);
        this.a.a(false);
        VideoStoryPiecesPart.a(this.a, false);
      }
      else if (VideoStoryPiecesPart.a(this.a).b())
      {
        VideoStoryPiecesPart.d(this.a).setVisibility(0);
        this.a.a(true);
        VideoStoryPiecesPart.a(this.a, true);
        if (VideoStoryPiecesPart.d(this.a)) {
          VideoStoryPiecesPart.a(this.a).setVisibility(0);
        }
        if ((AEMaterialManager.a()) && (VideoStoryPiecesPart.a(this.a) != null)) {
          VideoStoryPiecesPart.a(this.a).setVisibility(0);
        }
        VideoStoryPiecesPart.a(this.a).a(786435, new Object[0]);
      }
      else if (VideoStoryPiecesPart.a(this.a).c())
      {
        VideoStoryPiecesPart.d(this.a).setVisibility(0);
        VideoStoryPiecesPart.a(this.a).setVisibility(8);
        VideoStoryPiecesPart.a(this.a, false);
        this.a.a(false);
      }
      else if (VideoStoryPiecesPart.a(this.a).d())
      {
        VideoStoryPiecesPart.a(this.a, true);
        VideoStoryPiecesPart.a(this.a).setVisibility(8);
        this.a.a(false);
      }
    }
    else
    {
      VideoStoryPiecesPart.a(this.a).setVisibility(8);
      VideoStoryPiecesPart.a(this.a, false);
      if (VideoStoryPiecesPart.a(this.a) != null) {
        VideoStoryPiecesPart.a(this.a).setVisibility(8);
      }
      VideoStoryPiecesPart.b(this.a).a(786434, new Object[0]);
      if (VideoStoryPiecesPart.a(this.a) != null) {
        VideoStoryPiecesPart.a(this.a).setVisibility(8);
      }
    }
    AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when other buttons visibility change");
    VideoStoryPiecesPart.c(this.a);
    VideoStoryPiecesPart.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.12
 * JD-Core Version:    0.7.0.1
 */