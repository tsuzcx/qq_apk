package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.DisplayUtil;
import org.light.DeviceSupportUtil;

class AEAIONewTopBarPart$3
  implements Observer<AECaptureModeChangingEvent>
{
  AEAIONewTopBarPart$3(AEAIONewTopBarPart paramAEAIONewTopBarPart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {
      return;
    }
    paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
    AEAIONewTopBarPart.a(this.a, paramAECaptureModeChangingEvent);
    if (paramAECaptureModeChangingEvent == AECaptureMode.NORMAL)
    {
      if (this.a.a != null) {
        this.a.a.setVisibility(8);
      }
      if (AEAIONewTopBarPart.b(this.a) != null) {
        AEAIONewTopBarPart.b(this.a).setVisibility(8);
      }
      if (AEAIONewTopBarPart.c(this.a) != null) {
        AEAIONewTopBarPart.c(this.a).setVisibility(8);
      }
    }
    else
    {
      Object localObject = AECaptureMode.GIF;
      int i = 0;
      if (paramAECaptureModeChangingEvent == localObject)
      {
        if (AEAIONewTopBarPart.d(this.a) != null)
        {
          paramAECaptureModeChangingEvent = (ViewGroup.MarginLayoutParams)AEAIONewTopBarPart.d(this.a).getLayoutParams();
          paramAECaptureModeChangingEvent.topMargin = DisplayUtil.a(BaseApplicationImpl.getContext(), 48.0F);
          AEAIONewTopBarPart.d(this.a).setLayoutParams(paramAECaptureModeChangingEvent);
        }
        if (this.a.a != null) {
          this.a.a.setVisibility(0);
        }
        if (AEAIONewTopBarPart.b(this.a) != null) {
          AEAIONewTopBarPart.b(this.a).setVisibility(8);
        }
        if (AEAIONewTopBarPart.c(this.a) != null) {
          AEAIONewTopBarPart.c(this.a).setVisibility(0);
        }
        AEAIONewTopBarPart.c(this.a).setVisibility(0);
        AEAIONewTopBarPart.a(this.a).setVisibility(0);
        AEAIONewTopBarPart.a(this.a, 3);
        this.a.a.getForegroundView().setImageResource(2063925253);
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
        paramAECaptureModeChangingEvent = AEAIONewTopBarPart.e(this.a);
        if (bool) {
          i = 8;
        }
        paramAECaptureModeChangingEvent.setVisibility(i);
      }
      else if (paramAECaptureModeChangingEvent == AECaptureMode.PLAY)
      {
        if (AEAIONewTopBarPart.d(this.a) != null)
        {
          paramAECaptureModeChangingEvent = (ViewGroup.MarginLayoutParams)AEAIONewTopBarPart.d(this.a).getLayoutParams();
          paramAECaptureModeChangingEvent.topMargin = 60;
          AEAIONewTopBarPart.d(this.a).setLayoutParams(paramAECaptureModeChangingEvent);
        }
        if (this.a.a != null) {
          this.a.a.setVisibility(8);
        }
        if (AEAIONewTopBarPart.b(this.a) != null) {
          AEAIONewTopBarPart.b(this.a).setVisibility(0);
        }
        AEAIONewTopBarPart.b(this.a).getForegroundView().setImageResource(2063925631);
        AEAIONewTopBarPart.c(this.a).setVisibility(8);
      }
    }
    if (this.a.a()) {
      AEAIONewTopBarPart.f(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEAIONewTopBarPart.3
 * JD-Core Version:    0.7.0.1
 */