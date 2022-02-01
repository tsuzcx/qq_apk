package com.tencent.aelight.camera.ae.camera.ui;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanel;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.gif.AEVideoStoryGIFTplViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.view.AECircleCaptureStyle;
import com.tencent.aelight.camera.ae.view.CountDownView;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.log.AEQLog;

class VideoStoryPiecesPart$10
  implements Observer<AECaptureModeChangingEvent>
{
  VideoStoryPiecesPart$10(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {
      return;
    }
    paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
    VideoStoryPiecesPart.a(this.a, paramAECaptureModeChangingEvent);
    AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when capture mode change");
    VideoStoryPiecesPart.E(this.a);
    VideoStoryPiecesPart.F(this.a);
    VideoStoryPiecesPart.G(this.a);
    VideoStoryPiecesPart.H(this.a);
    VideoStoryPiecesPart.I(this.a);
    VideoStoryPiecesPart.J(this.a);
    VideoStoryPiecesPart.n(this.a).a(paramAECaptureModeChangingEvent);
    VideoStoryPiecesPart.n(this.a).au();
    if (paramAECaptureModeChangingEvent == AECaptureMode.NORMAL) {
      VideoStoryPiecesPart.n(this.a).g(true);
    } else {
      VideoStoryPiecesPart.n(this.a).g(false);
    }
    if (VideoStoryPiecesPart.K(this.a) != null) {
      VideoStoryPiecesPart.K(this.a).a(paramAECaptureModeChangingEvent);
    }
    if (paramAECaptureModeChangingEvent == AECaptureMode.NORMAL)
    {
      VideoStoryPiecesPart.B(this.a).setVisibility(0);
      this.a.a();
      VideoStoryPiecesPart.B(this.a).setMaxDuration(this.a.a(paramAECaptureModeChangingEvent));
      VideoStoryPiecesPart.B(this.a).a(false);
      if (VideoStoryPiecesPart.z(this.a)) {
        VideoStoryPiecesPart.B(this.a).a(true, AECircleCaptureStyle.a);
      }
      VideoStoryPiecesPart.B(this.a).setGifMode(false);
      if (VideoStoryPiecesPart.z(this.a))
      {
        int i = this.a.b();
        if (i > 0)
        {
          paramAECaptureModeChangingEvent = (ViewGroup.MarginLayoutParams)VideoStoryPiecesPart.L(this.a).getLayoutParams();
          if (paramAECaptureModeChangingEvent != null)
          {
            paramAECaptureModeChangingEvent.bottomMargin = i;
            VideoStoryPiecesPart.L(this.a).setLayoutParams(paramAECaptureModeChangingEvent);
          }
        }
      }
      if (VideoStoryPiecesPart.M(this.a)) {
        VideoStoryPiecesPart.a(this.a, 0);
      }
      VideoStoryPiecesPart.a(this.a, true);
      if (!AECameraEntryManager.a(VideoStoryPiecesPart.n(this.a).s())) {
        VideoStoryPiecesPart.n(this.a).am().a();
      }
      if (VideoStoryPiecesPart.N(this.a) != null) {
        VideoStoryPiecesPart.N(this.a).a();
      }
    }
    else
    {
      if (paramAECaptureModeChangingEvent == AECaptureMode.GIF)
      {
        VideoStoryPiecesPart.B(this.a).setVisibility(0);
        VideoStoryPiecesPart.B(this.a).setFunctionFlag(4);
        VideoStoryPiecesPart.B(this.a).setMaxDuration(this.a.a(paramAECaptureModeChangingEvent));
        VideoStoryPiecesPart.B(this.a).a(true);
        VideoStoryPiecesPart.B(this.a).setGifMode(true);
        if (VideoStoryPiecesPart.M(this.a)) {
          VideoStoryPiecesPart.a(this.a, 0);
        }
        VideoStoryPiecesPart.a(this.a, true);
        VideoStoryPiecesPart.O(this.a).e();
        return;
      }
      if (paramAECaptureModeChangingEvent == AECaptureMode.PLAY)
      {
        VideoStoryPiecesPart.B(this.a).setVisibility(8);
        VideoStoryPiecesPart.a(this.a, 8);
        VideoStoryPiecesPart.a(this.a, false);
        VideoStoryPiecesPart.D(this.a).setMaterial(null);
        return;
      }
      if (paramAECaptureModeChangingEvent == AECaptureMode.ARCAKE)
      {
        VideoStoryPiecesPart.B(this.a).setVisibility(0);
        VideoStoryPiecesPart.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.10
 * JD-Core Version:    0.7.0.1
 */