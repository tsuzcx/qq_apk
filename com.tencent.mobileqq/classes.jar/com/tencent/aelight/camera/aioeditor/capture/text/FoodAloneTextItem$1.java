package com.tencent.aelight.camera.aioeditor.capture.text;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

class FoodAloneTextItem$1
  implements DynamicTextItem.PreHandleTextHandler
{
  FoodAloneTextItem$1(FoodAloneTextItem paramFoodAloneTextItem) {}
  
  @NonNull
  public String a(int paramInt, @NonNull String paramString)
  {
    if (paramInt == 0) {
      return TroopFileUtils.c(paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.FoodAloneTextItem.1
 * JD-Core Version:    0.7.0.1
 */