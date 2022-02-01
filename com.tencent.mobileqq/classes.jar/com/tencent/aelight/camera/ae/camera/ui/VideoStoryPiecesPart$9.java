package com.tencent.aelight.camera.ae.camera.ui;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.gif.AEVideoStoryGIFTplViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.view.AECircleCaptureStyle;
import com.tencent.aelight.camera.ae.view.CountDownView;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;

class VideoStoryPiecesPart$9
  implements Observer<AECaptureModeChangingEvent>
{
  VideoStoryPiecesPart$9(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {
      return;
    }
    paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
    VideoStoryPiecesPart.a(this.a, paramAECaptureModeChangingEvent);
    AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when capture mode change");
    VideoStoryPiecesPart.c(this.a);
    if ((paramAECaptureModeChangingEvent == AECaptureMode.GIF) && (VideoStoryPiecesPart.a(this.a) != null) && (VideoStoryPiecesPart.a(this.a).getVisibility() == 0))
    {
      AECameraPrefsUtil.a().a("sp_key_ae_comics_gif_tips", true, 0);
      AEQLog.b("VideoStoryPiecesPart", "[ComicsTips]--set flag: comics gif tips has shown");
    }
    VideoStoryPiecesPart.d(this.a);
    VideoStoryPiecesPart.a(this.a).a(paramAECaptureModeChangingEvent);
    VideoStoryPiecesPart.a(this.a).R();
    if (paramAECaptureModeChangingEvent == AECaptureMode.NORMAL) {
      VideoStoryPiecesPart.a(this.a).f(true);
    } else {
      VideoStoryPiecesPart.a(this.a).f(false);
    }
    if (VideoStoryPiecesPart.a(this.a) != null) {
      VideoStoryPiecesPart.a(this.a).a(paramAECaptureModeChangingEvent);
    }
    if (paramAECaptureModeChangingEvent == AECaptureMode.NORMAL)
    {
      VideoStoryPiecesPart.a(this.a).setVisibility(0);
      this.a.b();
      VideoStoryPiecesPart.a(this.a).setMaxDuration(this.a.a(paramAECaptureModeChangingEvent));
      VideoStoryPiecesPart.a(this.a).a(false);
      if (VideoStoryPiecesPart.c(this.a)) {
        VideoStoryPiecesPart.a(this.a).a(true, AECircleCaptureStyle.a);
      }
      VideoStoryPiecesPart.a(this.a).b(false);
      if (VideoStoryPiecesPart.c(this.a))
      {
        int i = this.a.a();
        if (i > 0)
        {
          paramAECaptureModeChangingEvent = (ViewGroup.MarginLayoutParams)VideoStoryPiecesPart.c(this.a).getLayoutParams();
          if (paramAECaptureModeChangingEvent != null)
          {
            paramAECaptureModeChangingEvent.bottomMargin = i;
            VideoStoryPiecesPart.c(this.a).setLayoutParams(paramAECaptureModeChangingEvent);
          }
        }
      }
      if (VideoStoryPiecesPart.d(this.a)) {
        VideoStoryPiecesPart.a(this.a).setVisibility(0);
      }
      VideoStoryPiecesPart.a(this.a, true);
      if (!AECameraEntryManager.a(VideoStoryPiecesPart.a(this.a).a())) {
        VideoStoryPiecesPart.a(this.a).a().a();
      }
      if (VideoStoryPiecesPart.a(this.a) != null) {
        VideoStoryPiecesPart.a(this.a).a();
      }
    }
    else
    {
      if (paramAECaptureModeChangingEvent == AECaptureMode.GIF)
      {
        VideoStoryPiecesPart.a(this.a).setVisibility(0);
        VideoStoryPiecesPart.a(this.a).setFunctionFlag(4);
        VideoStoryPiecesPart.a(this.a).setMaxDuration(this.a.a(paramAECaptureModeChangingEvent));
        VideoStoryPiecesPart.a(this.a).a(true);
        VideoStoryPiecesPart.a(this.a).b(true);
        if (VideoStoryPiecesPart.d(this.a)) {
          VideoStoryPiecesPart.a(this.a).setVisibility(0);
        }
        VideoStoryPiecesPart.a(this.a, true);
        VideoStoryPiecesPart.a(this.a).a();
        return;
      }
      if (paramAECaptureModeChangingEvent == AECaptureMode.PLAY)
      {
        VideoStoryPiecesPart.a(this.a).setVisibility(8);
        VideoStoryPiecesPart.a(this.a).setVisibility(8);
        VideoStoryPiecesPart.a(this.a, false);
        VideoStoryPiecesPart.a(this.a).setMaterial(null);
        return;
      }
      if (paramAECaptureModeChangingEvent == AECaptureMode.ARCAKE)
      {
        VideoStoryPiecesPart.a(this.a).setVisibility(0);
        VideoStoryPiecesPart.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.9
 * JD-Core Version:    0.7.0.1
 */