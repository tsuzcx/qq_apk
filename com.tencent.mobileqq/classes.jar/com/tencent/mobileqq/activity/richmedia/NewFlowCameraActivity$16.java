package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$16
  extends OrientationEventListener
{
  NewFlowCameraActivity$16(NewFlowCameraActivity paramNewFlowCameraActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    NewFlowCameraActivity.a(this.a).a(paramInt);
    if (this.a.i) {}
    do
    {
      return;
      if (paramInt == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "OrientationEventListener unknown");
        }
        this.a.n = 90;
        return;
      }
      if ((paramInt > 315) || (paramInt < 45))
      {
        this.a.n = 90;
        return;
      }
      if ((paramInt > 45) && (paramInt < 135))
      {
        this.a.n = 180;
        return;
      }
      if ((paramInt > 135) && (paramInt < 225))
      {
        this.a.n = 270;
        return;
      }
    } while ((paramInt <= 225) || (paramInt >= 315));
    this.a.n = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.16
 * JD-Core Version:    0.7.0.1
 */