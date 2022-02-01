package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.text.InputFilter;
import android.text.Spanned;

class AEGIFTextEditFragment$LengthInputFilter
  implements InputFilter
{
  private int b = 32;
  
  public AEGIFTextEditFragment$LengthInputFilter(AEGIFTextEditFragment paramAEGIFTextEditFragment) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence.equals("\n")) {
      return "";
    }
    paramInt1 = 0;
    paramInt2 = 0;
    char c;
    while ((paramInt1 <= this.b) && (paramInt2 < paramSpanned.length()))
    {
      c = paramSpanned.charAt(paramInt2);
      paramInt1 += AEGIFTextEditFragment.a(this.a, c);
      paramInt2 += 1;
    }
    if (paramInt1 > this.b) {
      return paramSpanned.subSequence(0, paramInt2 - 1);
    }
    paramInt2 = 0;
    while ((paramInt1 <= this.b) && (paramInt2 < paramCharSequence.length()))
    {
      c = paramCharSequence.charAt(paramInt2);
      paramInt1 += AEGIFTextEditFragment.a(this.a, c);
      paramInt2 += 1;
    }
    paramInt3 = paramInt2;
    if (paramInt1 > this.b) {
      paramInt3 = paramInt2 - 1;
    }
    return paramCharSequence.subSequence(0, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.LengthInputFilter
 * JD-Core Version:    0.7.0.1
 */