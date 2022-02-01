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
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;

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
      AEGIFStickerListPart.a(this.a).setVisibility(8);
      return;
    }
    if (localAECaptureMode == AECaptureMode.GIF)
    {
      AEGIFStickerListPart.a(this.a);
      AEFontManager.a().a();
      AEBaseDataReporter.a().aj();
      if ((paramAECaptureModeChangingEvent.a != null) && (!TextUtils.isEmpty(AEGIFStickerListPart.a(this.a))))
      {
        AEBaseReportParam.a().s(AEGIFStickerListPart.a(this.a));
        AEBaseDataReporter.a().am();
      }
    }
    else if (localAECaptureMode == AECaptureMode.PLAY)
    {
      AEGIFStickerListPart.a(this.a).setVisibility(8);
      AEGIFStickerListPart.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.2
 * JD-Core Version:    0.7.0.1
 */