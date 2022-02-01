package com.tencent.aelight.camera.ae.biz.circle;

import android.view.MotionEvent;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.view.AETouchNotifyRelativeLayout.IAETouchNotify;

class AECircleMultiUnit$2
  implements AETouchNotifyRelativeLayout.IAETouchNotify
{
  AECircleMultiUnit$2(AECircleMultiUnit paramAECircleMultiUnit) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((AECircleMultiUnit.a(this.a) instanceof AEPituCameraUnit)) {
      ((AEPituCameraUnit)AECircleMultiUnit.a(this.a)).a(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit.2
 * JD-Core Version:    0.7.0.1
 */