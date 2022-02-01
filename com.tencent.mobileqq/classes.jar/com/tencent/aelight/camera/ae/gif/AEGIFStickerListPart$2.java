package com.tencent.aelight.camera.ae.gif;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.font.AEFontManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;

class AEGIFStickerListPart$2
  implements Observer<AECaptureModeChangingEvent>
{
  AEGIFStickerListPart$2(AEGIFStickerListPart paramAEGIFStickerListPart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {
      return;
    }
    AECaptureMode localAECaptureMode = paramAECaptureModeChangingEvent.b;
    if (localAECaptureMode == AECaptureMode.NORMAL)
    {
      AEGIFStickerListPart.a(this.a).setVisibility(8);
      AEGIFStickerListPart.b(this.a).setVisibility(8);
      return;
    }
    if (localAECaptureMode == AECaptureMode.GIF)
    {
      AEGIFStickerListPart.c(this.a);
      AEFontManager.a().b();
      AEBaseDataReporter.a().ao();
      if ((paramAECaptureModeChangingEvent.a != null) && (!TextUtils.isEmpty(AEGIFStickerListPart.d(this.a))))
      {
        AEBaseReportParam.a().D(AEGIFStickerListPart.d(this.a));
        AEBaseDataReporter.a().ar();
      }
    }
    else if (localAECaptureMode == AECaptureMode.PLAY)
    {
      AEGIFStickerListPart.a(this.a).setVisibility(8);
      AEGIFStickerListPart.b(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.2
 * JD-Core Version:    0.7.0.1
 */