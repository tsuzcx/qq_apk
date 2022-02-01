package com.tencent.aelight.camera.ae.config;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean;
import com.tencent.mobileqq.app.BusinessObserver;

public abstract class CameraPeakServiceObserver
  implements BusinessObserver
{
  public static final int STATE_SENSITIVE_FACE_FAILED = -2;
  public static final int STATE_SENSITIVE_FACE_ILLEGAL = -1;
  public static final int STATE_SENSITIVE_FACE_LEGAL = 0;
  
  protected void onGetFontData(boolean paramBoolean, GetFontDataRsp paramGetFontDataRsp) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            onUpdateFaceDetect(paramBoolean, ((Integer)paramObject).intValue());
            return;
          }
          onGetFontData(paramBoolean, (GetFontDataRsp)paramObject);
          return;
        }
        onUpdateOnlineUserNum(paramBoolean, ((Integer)paramObject).intValue());
        return;
      }
      onUpdateTextValid(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    }
    onUpdateRecommendText(paramBoolean, (RecognizedEmotionBean)paramObject);
  }
  
  public void onUpdateFaceDetect(boolean paramBoolean, int paramInt) {}
  
  public void onUpdateOnlineUserNum(boolean paramBoolean, int paramInt) {}
  
  public void onUpdateRecommendText(boolean paramBoolean, RecognizedEmotionBean paramRecognizedEmotionBean) {}
  
  public void onUpdateTextValid(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.config.CameraPeakServiceObserver
 * JD-Core Version:    0.7.0.1
 */