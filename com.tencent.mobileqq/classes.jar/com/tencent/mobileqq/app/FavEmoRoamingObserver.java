package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FavEmoRoamingObserver
  implements BusinessObserver
{
  public static final String TAG = "FavEmoRoamingObserver";
  
  protected void onDelEmoResponse(boolean paramBoolean) {}
  
  protected void onModifyFavData(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          onModifyFavData(paramBoolean, paramObject);
          return;
        }
        onUpdateFavData(paramBoolean, paramObject);
        return;
      }
      try
      {
        onUploadReq((ArrayList)paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("FavEmoRoamingObserver", 1, "onUploadReq error, ", paramObject);
        return;
      }
    }
    if (paramObject != null) {
      onDelEmoResponse(((Boolean)paramObject).booleanValue());
    }
  }
  
  protected void onUpdateFavData(boolean paramBoolean, Object paramObject) {}
  
  protected void onUploadReq(List<CustomEmotionData> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FavEmoRoamingObserver
 * JD-Core Version:    0.7.0.1
 */