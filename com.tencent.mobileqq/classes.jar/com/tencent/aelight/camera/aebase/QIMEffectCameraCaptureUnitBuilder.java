package com.tencent.aelight.camera.aebase;

import com.tencent.aelight.camera.ae.AECMShowCameraUnit;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.IQIMCameraLifeCallback;
import com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;

public class QIMEffectCameraCaptureUnitBuilder
{
  public static IQIMCameraLifeCallback a(int paramInt, IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    if (paramInt != -1000)
    {
      if (paramInt != 10007)
      {
        if ((paramInt != 10017) && (paramInt != 10000))
        {
          if (paramInt != 10001) {
            if (paramInt != 10012) {
              if (paramInt == 10013) {
                break label144;
              }
            }
          }
          switch (paramInt)
          {
          default: 
            return new AEPituCameraUnit(paramIQIMCameraContainer, paramICameraEntrance);
          case 10027: 
            return new AECMShowCameraUnit(paramIQIMCameraContainer, paramICameraEntrance);
          case 10026: 
            return new AECircleMultiUnit(paramIQIMCameraContainer, paramICameraEntrance);
          case 10025: 
            return new QFaceUnlockCameraCaptureUnit(paramIQIMCameraContainer, paramICameraEntrance);
            return new QIMTribeEffectsCameraCaptureUnit(paramIQIMCameraContainer, paramICameraEntrance);
            return new AEPituQzoneCameraUnit(paramIQIMCameraContainer, paramICameraEntrance);
          }
        }
        label144:
        return new AEPituCameraUnit(paramIQIMCameraContainer, paramICameraEntrance);
      }
      return new QIMWebEffectCameraCaptureUnit(paramIQIMCameraContainer, paramICameraEntrance);
    }
    return new AEPituCameraUnit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QIMEffectCameraCaptureUnitBuilder
 * JD-Core Version:    0.7.0.1
 */