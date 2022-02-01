package com.tencent.aelight.camera.aioeditor.capture.text;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

class LangTextItem$1
  implements DynamicTextItem.PreHandleTextHandler
{
  LangTextItem$1(LangTextItem paramLangTextItem) {}
  
  @NonNull
  public String a(int paramInt, @NonNull String paramString)
  {
    if (paramInt == 0) {
      return TroopFileUtils.b(paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.LangTextItem.1
 * JD-Core Version:    0.7.0.1
 */