package com.Vas.ColorFont;

import android.text.Spanned;
import android.text.style.CharacterStyle;
import java.util.Comparator;

class FounderColorLayout$SpanComparator
  implements Comparator<CharacterStyle>
{
  Spanned a;
  
  public int a(CharacterStyle paramCharacterStyle1, CharacterStyle paramCharacterStyle2)
  {
    Spanned localSpanned = this.a;
    if (localSpanned == null) {
      return 0;
    }
    int i = localSpanned.getSpanStart(paramCharacterStyle1);
    int j = this.a.getSpanStart(paramCharacterStyle2);
    if (i == j)
    {
      i = this.a.getSpanEnd(paramCharacterStyle1);
      j = this.a.getSpanEnd(paramCharacterStyle2);
      if (i == j) {
        return 0;
      }
      if (i > j) {
        return 1;
      }
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return -1;
  }
  
  public void a(Spanned paramSpanned)
  {
    this.a = paramSpanned;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FounderColorLayout.SpanComparator
 * JD-Core Version:    0.7.0.1
 */