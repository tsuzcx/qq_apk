package com.tencent.aelight.camera.aioeditor.capture.text;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

class JourneyTextItem$2
  implements DynamicTextItem.PreHandleTextHandler
{
  JourneyTextItem$2(JourneyTextItem paramJourneyTextItem) {}
  
  @NonNull
  public String a(int paramInt, @NonNull String paramString)
  {
    if (paramInt == 0) {
      return TroopFileUtils.c(paramString);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.JourneyTextItem.2
 * JD-Core Version:    0.7.0.1
 */