package com.tencent.aelight.camera.ae.camera.ui;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.image.URLImageView;

class VideoStoryPiecesPart$13
  implements Observer<Boolean>
{
  VideoStoryPiecesPart$13(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    if (paramBoolean.booleanValue())
    {
      if (VideoStoryPiecesPart.R(this.a).a())
      {
        VideoStoryPiecesPart.S(this.a).setVisibility(0);
        VideoStoryPiecesPart.a(this.a, 8);
        this.a.a(false);
        VideoStoryPiecesPart.a(this.a, false);
      }
      else if (VideoStoryPiecesPart.R(this.a).b())
      {
        VideoStoryPiecesPart.S(this.a).setVisibility(0);
        this.a.a(true);
        VideoStoryPiecesPart.a(this.a, true);
        if (VideoStoryPiecesPart.M(this.a)) {
          VideoStoryPiecesPart.a(this.a, 0);
        }
        if ((AEMaterialManager.j()) && (VideoStoryPiecesPart.T(this.a) != null)) {
          VideoStoryPiecesPart.T(this.a).setVisibility(0);
        }
        VideoStoryPiecesPart.U(this.a).b(786435, new Object[0]);
      }
      else if (VideoStoryPiecesPart.R(this.a).c())
      {
        VideoStoryPiecesPart.S(this.a).setVisibility(0);
        VideoStoryPiecesPart.a(this.a, 8);
        VideoStoryPiecesPart.a(this.a, false);
        this.a.a(false);
      }
      else if (VideoStoryPiecesPart.R(this.a).d())
      {
        VideoStoryPiecesPart.a(this.a, true);
        VideoStoryPiecesPart.a(this.a, 8);
        this.a.a(false);
      }
    }
    else
    {
      VideoStoryPiecesPart.a(this.a, 8);
      VideoStoryPiecesPart.a(this.a, false);
      if (VideoStoryPiecesPart.T(this.a) != null) {
        VideoStoryPiecesPart.T(this.a).setVisibility(8);
      }
      VideoStoryPiecesPart.V(this.a).b(786434, new Object[0]);
      if (VideoStoryPiecesPart.a(this.a) != null) {
        VideoStoryPiecesPart.a(this.a).setVisibility(8);
      }
    }
    AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when other buttons visibility change");
    VideoStoryPiecesPart.E(this.a);
    VideoStoryPiecesPart.G(this.a);
    VideoStoryPiecesPart.I(this.a);
    if (!paramBoolean.booleanValue())
    {
      AEQLog.a("VideoStoryPiecesPart", "[BeautyTip]---clearBeautyTip when capturing");
      VideoStoryPiecesPart.W(this.a);
    }
    VideoStoryPiecesPart.J(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.13
 * JD-Core Version:    0.7.0.1
 */