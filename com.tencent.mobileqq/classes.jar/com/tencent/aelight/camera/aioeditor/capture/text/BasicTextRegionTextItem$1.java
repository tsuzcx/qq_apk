package com.tencent.aelight.camera.aioeditor.capture.text;

import android.text.Spanned;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.LengthInputFilter;

class BasicTextRegionTextItem$1
  extends EditTextDialog.LengthInputFilter
{
  BasicTextRegionTextItem$1(BasicTextRegionTextItem paramBasicTextRegionTextItem, int paramInt)
  {
    super(paramInt);
  }
  
  public int a(CharSequence paramCharSequence)
  {
    return 0;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    String str = paramCharSequence.subSequence(paramInt1, paramInt2).toString().replaceAll("\n", "");
    int i;
    if (paramInt2 - paramInt1 != str.length()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramInt2 = str.length();
      paramInt1 = 0;
      paramCharSequence = str;
    }
    paramSpanned = super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
    if ((paramSpanned == null) && (i != 0)) {
      return paramCharSequence;
    }
    return paramSpanned;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BasicTextRegionTextItem.1
 * JD-Core Version:    0.7.0.1
 */