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
    Object localObject = AECaptureMode.NORMAL;
    boolean bool = false;
    if (paramAECaptureModeChangingEvent != localObject) {
      AEVideoStoryCaptureModePart.a(this.a).a(196616, new Object[0]);
    }
    if (AEVideoStoryCaptureModePart.a(this.a) != null)
    {
      i = 0;
      while (i < AEVideoStoryCaptureModePart.a(this.a).length)
      {
        if (paramAECaptureModeChangingEvent == AEVideoStoryCaptureModePart.a(this.a)[i]) {
          break label97;
        }
        i += 1;
      }
    }
    int i = -1;
    label97:
    if (i != -1) {
      AEVideoStoryCaptureModePart.a(this.a).setCurrentItem(i, true);
    }
    localObject = this.a;
    if (paramAECaptureModeChangingEvent == AECaptureMode.GIF) {
      bool = true;
    }
    AEVideoStoryCaptureModePart.a((AEVideoStoryCaptureModePart)localObject, bool);
    AEVideoStoryCaptureModePart.a(this.a).notifyDataSetChanged();
    paramAECaptureModeChangingEvent = AEVideoStoryCaptureModePart.a(this.a);
    if (AEVideoStoryCaptureModePart.a(this.a)) {
      i = 2064056341;
    } else {
      i = 2064056342;
    }
    paramAECaptureModeChangingEvent.setImageResource(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModePart.2
 * JD-Core Version:    0.7.0.1
 */