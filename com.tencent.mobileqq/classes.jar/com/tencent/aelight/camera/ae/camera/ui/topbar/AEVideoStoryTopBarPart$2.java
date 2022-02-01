package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.app.Activity;
import android.support.annotation.Nullable;
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

class AEVideoStoryTopBarPart$2
  implements Observer<AECaptureModeChangingEvent>
{
  AEVideoStoryTopBarPart$2(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {
      return;
    }
    paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("arcake : captureModeChangedLiveData");
    ((StringBuilder)localObject).append(paramAECaptureModeChangingEvent.toString());
    AEQLog.a("AEVideoStoryTopBarPart", ((StringBuilder)localObject).toString());
    localObject = AECaptureMode.NORMAL;
    int i = 0;
    if (paramAECaptureModeChangingEvent == localObject)
    {
      if (!AECameraEntryManager.k(AEVideoStoryTopBarPart.a(this.a).getIntent())) {
        AEVideoStoryTopBarPart.a(this.a).a().setImageResource(2064056666);
      }
      AEVideoStoryTopBarPart.a(this.a).setVisibility(0);
      if (!AECameraEntryManager.k(AEVideoStoryTopBarPart.b(this.a).getIntent())) {
        AEVideoStoryTopBarPart.b(this.a).a().setImageResource(2064056603);
      }
      AEVideoStoryTopBarPart.c(this.a).setVisibility(0);
      if (paramAECaptureModeChangingEvent.getHasCountDown())
      {
        AEVideoStoryTopBarPart.d(this.a).setVisibility(8);
        AEVideoStoryTopBarPart.e(this.a).a().setImageResource(2064056596);
        AEVideoStoryTopBarPart.e(this.a).setVisibility(0);
        AEVideoStoryTopBarPart.a(this.a, 10);
      }
      else
      {
        if (!AECameraEntryManager.k(AEVideoStoryTopBarPart.c(this.a).getIntent())) {
          AEVideoStoryTopBarPart.d(this.a).a().setImageResource(2064056392);
        }
        AEVideoStoryTopBarPart.d(this.a).setVisibility(0);
        AEVideoStoryTopBarPart.e(this.a).setVisibility(8);
      }
      AEVideoStoryTopBarPart.f(this.a).setVisibility(8);
    }
    else if (paramAECaptureModeChangingEvent == AECaptureMode.GIF)
    {
      AEVideoStoryTopBarPart.a(this.a).a().setImageResource(2064056665);
      AEVideoStoryTopBarPart.a(this.a).setVisibility(0);
      AEVideoStoryTopBarPart.b(this.a).a().setImageResource(2064056602);
      AEVideoStoryTopBarPart.d(this.a).a().setImageResource(2064056391);
      AEVideoStoryTopBarPart.c(this.a).setVisibility(8);
      AEVideoStoryTopBarPart.e(this.a).a().setImageResource(2064056393);
      AEVideoStoryTopBarPart.e(this.a).setVisibility(0);
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
      paramAECaptureModeChangingEvent = AEVideoStoryTopBarPart.f(this.a);
      if (bool) {
        i = 8;
      }
      paramAECaptureModeChangingEvent.setVisibility(i);
    }
    else if (paramAECaptureModeChangingEvent == AECaptureMode.PLAY)
    {
      AEVideoStoryTopBarPart.a(this.a).a().setImageResource(2064056666);
      AEVideoStoryTopBarPart.a(this.a).setVisibility(8);
    }
    else if (paramAECaptureModeChangingEvent == AECaptureMode.ARCAKE)
    {
      AEVideoStoryTopBarPart.a(this.a).a().setImageResource(2130844568);
      AEVideoStoryTopBarPart.a(this.a).setVisibility(8);
      if (AEVideoStoryTopBarPart.a(this.a) != null) {
        AEVideoStoryTopBarPart.a(this.a).setVisibility(0);
      }
    }
    if (this.a.a()) {
      AEVideoStoryTopBarPart.d(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart.2
 * JD-Core Version:    0.7.0.1
 */