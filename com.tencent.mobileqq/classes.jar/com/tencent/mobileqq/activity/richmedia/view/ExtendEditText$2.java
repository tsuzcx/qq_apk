package com.tencent.mobileqq.activity.richmedia.view;

final class ExtendEditText$2
  implements ExtendEditText.LengthConvertor
{
  private boolean a(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
  }
  
  public int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 <= paramInt2) {
      i = paramInt1;
    } else {
      i = paramInt2;
    }
    int j = paramInt1;
    if (paramInt1 <= paramInt2) {
      j = paramInt2;
    }
    paramInt1 = i;
    int k;
    for (paramInt2 = 0; (paramInt1 < j) && (paramInt1 < paramCharSequence.length()); paramInt2 = k)
    {
      k = paramInt2;
      if (a(paramCharSequence.charAt(paramInt1))) {
        k = paramInt2 + 1;
      }
      paramInt1 += 1;
    }
    return j - i + paramInt2;
  }
  
  public int b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 <= paramInt2) {
      i = paramInt1;
    } else {
      i = paramInt2;
    }
    int j = paramInt1;
    if (paramInt1 <= paramInt2) {
      j = paramInt2;
    }
    paramInt1 = i;
    int k;
    for (paramInt2 = 0; paramInt1 < paramCharSequence.length(); paramInt2 = k)
    {
      k = paramInt2;
      if (a(paramCharSequence.charAt(paramInt1))) {
        k = paramInt2 + 1;
      }
      if (paramInt1 + k >= j) {
        return paramInt1 - i;
      }
      paramInt1 += 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.2
 * JD-Core Version:    0.7.0.1
 */