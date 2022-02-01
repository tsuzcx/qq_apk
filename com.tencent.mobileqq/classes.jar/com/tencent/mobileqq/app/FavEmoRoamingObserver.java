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
    switch (paramInt)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (paramObject == null);
      onDelEmoResponse(((Boolean)paramObject).booleanValue());
      return;
    case 1: 
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
    case 2: 
      onUpdateFavData(paramBoolean, paramObject);
      return;
    }
    onModifyFavData(paramBoolean, paramObject);
  }
  
  protected void onUpdateFavData(boolean paramBoolean, Object paramObject) {}
  
  protected void onUploadReq(List<CustomEmotionData> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FavEmoRoamingObserver
 * JD-Core Version:    0.7.0.1
 */