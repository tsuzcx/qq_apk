package com.tencent.aelight.camera.aioeditor.capture.text;

import android.text.Spanned;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.LengthInputFilter;

class RelaxedAfternoon$1
  extends EditTextDialog.LengthInputFilter
{
  RelaxedAfternoon$1(RelaxedAfternoon paramRelaxedAfternoon, int paramInt)
  {
    super(paramInt);
  }
  
  public int a(CharSequence paramCharSequence)
  {
    if (this.a.g() == 0) {
      return super.a(paramCharSequence);
    }
    return 0;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.a.g() == 0) {
      this.b = 20;
    } else {
      this.b = 18;
    }
    return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.RelaxedAfternoon.1
 * JD-Core Version:    0.7.0.1
 */