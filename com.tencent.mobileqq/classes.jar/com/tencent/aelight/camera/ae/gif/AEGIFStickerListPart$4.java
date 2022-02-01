package com.tencent.aelight.camera.ae.gif;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;

class AEGIFStickerListPart$4
  implements Observer<Boolean>
{
  AEGIFStickerListPart$4(AEGIFStickerListPart paramAEGIFStickerListPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    Intent localIntent = AEGIFStickerListPart.e(this.a).s().getIntent();
    if (localIntent != null) {
      localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    if (paramBoolean.booleanValue())
    {
      if (AEGIFStickerListPart.f(this.a).a())
      {
        AEGIFStickerListPart.a(this.a).setVisibility(0);
        AEGIFStickerListPart.b(this.a).setVisibility(0);
        return;
      }
      AEGIFStickerListPart.a(this.a).setVisibility(8);
      AEGIFStickerListPart.b(this.a).setVisibility(8);
      return;
    }
    AEGIFStickerListPart.a(this.a).setVisibility(4);
    AEGIFStickerListPart.b(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.4
 * JD-Core Version:    0.7.0.1
 */