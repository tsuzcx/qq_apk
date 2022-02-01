package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.CameraEmotionData;

public class CameraEmoRoamingObserver
  implements BusinessObserver
{
  protected void doOnAddEmoResult(int paramInt, CameraEmotionData paramCameraEmotionData) {}
  
  protected void doOnDeleteEmoResult(int paramInt) {}
  
  protected void doOnGetEmoListResult(int paramInt) {}
  
  protected void onCameraEmoInsert() {}
  
  protected void onCameraEmoSend(boolean paramBoolean, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
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
            onCameraEmoSend(paramBoolean, ((Integer)paramObject).intValue());
            return;
          }
          onCameraEmoInsert();
          return;
        }
        doOnDeleteEmoResult(((Integer)paramObject).intValue());
        return;
      }
      doOnGetEmoListResult(((Integer)paramObject).intValue());
      return;
    }
    paramObject = (Object[])paramObject;
    doOnAddEmoResult(((Integer)paramObject[0]).intValue(), (CameraEmotionData)paramObject[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.CameraEmoRoamingObserver
 * JD-Core Version:    0.7.0.1
 */