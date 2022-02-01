package com.tencent.aelight.camera.ae.biz.circle;

import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class AECircleMultiUnit$3
  implements QQPermissionCallback
{
  AECircleMultiUnit$3(AECircleMultiUnit paramAECircleMultiUnit, QIMCameraCaptureActivity paramQIMCameraCaptureActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AECircleMultiUnit.h(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit.3
 * JD-Core Version:    0.7.0.1
 */