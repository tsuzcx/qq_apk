package com.tencent.luggage.game.widget.input;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;

class WAGamePanelInputEditText$2
  implements InputFilter
{
  WAGamePanelInputEditText$2(WAGamePanelInputEditText paramWAGamePanelInputEditText) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return null;
    }
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    if ((paramCharSequence instanceof Spannable)) {
      paramCharSequence = (Spannable)paramCharSequence;
    } else {
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    }
    Spannable localSpannable = WAGamePanelInputEditText.a(this.a, paramCharSequence);
    paramSpanned = localSpannable;
    if (localSpannable == paramCharSequence) {
      paramSpanned = null;
    }
    return paramSpanned;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.WAGamePanelInputEditText.2
 * JD-Core Version:    0.7.0.1
 */