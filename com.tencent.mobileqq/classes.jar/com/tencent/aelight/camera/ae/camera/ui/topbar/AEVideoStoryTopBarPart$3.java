package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.log.AEQLog;
import org.light.DeviceSupportUtil;

class AEVideoStoryTopBarPart$3
  implements Observer<AECaptureModeChangingEvent>
{
  AEVideoStoryTopBarPart$3(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {
      return;
    }
    paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
    AEVideoStoryTopBarPart.a(this.a, paramAECaptureModeChangingEvent);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("arcake : captureModeChangedLiveData");
    ((StringBuilder)localObject).append(paramAECaptureModeChangingEvent.toString());
    AEQLog.a("AEVideoStoryTopBarPart", ((StringBuilder)localObject).toString());
    localObject = AECaptureMode.NORMAL;
    int i = 0;
    if (paramAECaptureModeChangingEvent == localObject)
    {
      if (!AECameraEntryManager.o(AEVideoStoryTopBarPart.c(this.a).getIntent()))
      {
        this.a.d.getForegroundView().setImageResource(2063925631);
        if (AEVideoStoryTopBarPart.d(this.a) != null) {
          AEVideoStoryTopBarPart.d(this.a).setVisibility(8);
        }
        if (AEVideoStoryTopBarPart.e(this.a) != null) {
          AEVideoStoryTopBarPart.e(this.a).setVisibility(8);
        }
        return;
      }
      AEVideoStoryTopBarPart.e(this.a).setVisibility(0);
      if (!AECameraEntryManager.o(AEVideoStoryTopBarPart.f(this.a).getIntent())) {
        AEVideoStoryTopBarPart.g(this.a).getForegroundView().setImageResource(2063925573);
      }
      this.a.c.setVisibility(0);
      if (paramAECaptureModeChangingEvent.getHasCountDown())
      {
        AEVideoStoryTopBarPart.h(this.a).setVisibility(8);
        AEVideoStoryTopBarPart.a(this.a).getForegroundView().setImageResource(2063925566);
        AEVideoStoryTopBarPart.a(this.a).setVisibility(0);
        AEVideoStoryTopBarPart.a(this.a, 10);
      }
      else
      {
        if (!AECameraEntryManager.o(AEVideoStoryTopBarPart.i(this.a).getIntent())) {
          AEVideoStoryTopBarPart.h(this.a).getForegroundView().setImageResource(2063925355);
        }
        AEVideoStoryTopBarPart.h(this.a).setVisibility(0);
        AEVideoStoryTopBarPart.a(this.a).setVisibility(8);
      }
      AEVideoStoryTopBarPart.j(this.a).setVisibility(8);
    }
    else if (paramAECaptureModeChangingEvent == AECaptureMode.GIF)
    {
      if (AEVideoStoryTopBarPart.d(this.a) != null) {
        AEVideoStoryTopBarPart.d(this.a).setVisibility(0);
      }
      if (AEVideoStoryTopBarPart.e(this.a) != null) {
        AEVideoStoryTopBarPart.e(this.a).setVisibility(0);
      }
      this.a.d.getForegroundView().setImageResource(2063925630);
      AEVideoStoryTopBarPart.e(this.a).setVisibility(0);
      AEVideoStoryTopBarPart.g(this.a).getForegroundView().setImageResource(2063925572);
      AEVideoStoryTopBarPart.h(this.a).getForegroundView().setImageResource(2063925354);
      this.a.c.setVisibility(8);
      AEVideoStoryTopBarPart.a(this.a).getForegroundView().setImageResource(2063925356);
      AEVideoStoryTopBarPart.a(this.a).setVisibility(0);
      AEVideoStoryTopBarPart.a(this.a, 3);
      boolean bool;
      try
      {
        bool = DeviceSupportUtil.isAbilityDeviceSupport("shareGLContextError");
      }
      catch (Exception paramAECaptureModeChangingEvent)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[DeviceSupportUtil.isAbilityDeviceSupport] e = ");
        ((StringBuilder)localObject).append(paramAECaptureModeChangingEvent.toString());
        AEQLog.d("AEVideoStoryTopBarPart", ((StringBuilder)localObject).toString());
        bool = false;
      }
      paramAECaptureModeChangingEvent = new StringBuilder();
      paramAECaptureModeChangingEvent.append("[initViewModel]: deviceNotSupportSegment = ");
      paramAECaptureModeChangingEvent.append(bool);
      AEQLog.a("AEVideoStoryTopBarPart", paramAECaptureModeChangingEvent.toString());
      paramAECaptureModeChangingEvent = AEVideoStoryTopBarPart.j(this.a);
      if (bool) {
        i = 8;
      }
      paramAECaptureModeChangingEvent.setVisibility(i);
    }
    else if (paramAECaptureModeChangingEvent == AECaptureMode.PLAY)
    {
      if (AEVideoStoryTopBarPart.d(this.a) != null) {
        AEVideoStoryTopBarPart.d(this.a).setVisibility(0);
      }
      this.a.d.getForegroundView().setImageResource(2063925631);
      AEVideoStoryTopBarPart.e(this.a).setVisibility(8);
    }
    else if (paramAECaptureModeChangingEvent == AECaptureMode.ARCAKE)
    {
      if (AEVideoStoryTopBarPart.d(this.a) != null) {
        AEVideoStoryTopBarPart.d(this.a).setVisibility(0);
      }
      this.a.d.getForegroundView().setImageResource(2130845941);
      AEVideoStoryTopBarPart.e(this.a).setVisibility(8);
      if (AEVideoStoryTopBarPart.k(this.a) != null) {
        AEVideoStoryTopBarPart.k(this.a).setVisibility(0);
      }
    }
    if (this.a.a()) {
      AEVideoStoryTopBarPart.h(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart.3
 * JD-Core Version:    0.7.0.1
 */