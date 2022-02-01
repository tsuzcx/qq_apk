package com.tencent.aelight.camera.ae.mode;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;

class AEVideoStoryCaptureModePart$2
  implements Observer<AECaptureModeChangingEvent>
{
  AEVideoStoryCaptureModePart$2(AEVideoStoryCaptureModePart paramAEVideoStoryCaptureModePart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {
      return;
    }
    paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
    AEVideoStoryCaptureModePart.a(this.a, paramAECaptureModeChangingEvent);
    if (paramAECaptureModeChangingEvent != AECaptureMode.NORMAL) {
      AEVideoStoryCaptureModePart.a(this.a).b(196616, new Object[0]);
    }
    if (AEVideoStoryCaptureModePart.b(this.a) != null)
    {
      i = 0;
      while (i < AEVideoStoryCaptureModePart.b(this.a).length)
      {
        if (paramAECaptureModeChangingEvent == AEVideoStoryCaptureModePart.b(this.a)[i]) {
          break label91;
        }
        i += 1;
      }
    }
    int i = -1;
    label91:
    boolean bool = true;
    if (i != -1) {
      AEVideoStoryCaptureModePart.c(this.a).setCurrentItem(i, true);
    }
    AEVideoStoryCaptureModePart localAEVideoStoryCaptureModePart = this.a;
    if (paramAECaptureModeChangingEvent != AECaptureMode.GIF) {
      bool = false;
    }
    AEVideoStoryCaptureModePart.a(localAEVideoStoryCaptureModePart, bool);
    AEVideoStoryCaptureModePart.d(this.a).notifyDataSetChanged();
    AEVideoStoryCaptureModePart.e(this.a).setVisibility(0);
    paramAECaptureModeChangingEvent = AEVideoStoryCaptureModePart.e(this.a);
    if (AEVideoStoryCaptureModePart.f(this.a)) {
      i = 2063925278;
    } else {
      i = 2063925279;
    }
    paramAECaptureModeChangingEvent.setImageResource(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModePart.2
 * JD-Core Version:    0.7.0.1
 */