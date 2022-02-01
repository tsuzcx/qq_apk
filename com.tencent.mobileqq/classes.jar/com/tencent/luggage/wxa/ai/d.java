package com.tencent.luggage.wxa.ai;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Map;

final class d
{
  public static e a(e parame, String[] paramArrayOfString, Map<String, e> paramMap)
  {
    if ((parame == null) && (paramArrayOfString == null)) {
      return null;
    }
    int j = 0;
    int i = 0;
    if ((parame == null) && (paramArrayOfString.length == 1)) {
      return (e)paramMap.get(paramArrayOfString[0]);
    }
    if ((parame == null) && (paramArrayOfString.length > 1))
    {
      parame = new e();
      j = paramArrayOfString.length;
      while (i < j)
      {
        parame.a((e)paramMap.get(paramArrayOfString[i]));
        i += 1;
      }
      return parame;
    }
    if ((parame != null) && (paramArrayOfString != null) && (paramArrayOfString.length == 1)) {
      return parame.a((e)paramMap.get(paramArrayOfString[0]));
    }
    if ((parame != null) && (paramArrayOfString != null) && (paramArrayOfString.length > 1))
    {
      int k = paramArrayOfString.length;
      i = j;
      while (i < k)
      {
        parame.a((e)paramMap.get(paramArrayOfString[i]));
        i += 1;
      }
    }
    return parame;
  }
  
  static String a(String paramString)
  {
    return paramString.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
  }
  
  static void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length() - 1;
    while ((i >= 0) && (paramSpannableStringBuilder.charAt(i) == ' ')) {
      i -= 1;
    }
    if ((i >= 0) && (paramSpannableStringBuilder.charAt(i) != '\n')) {
      paramSpannableStringBuilder.append('\n');
    }
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, e parame)
  {
    if (parame.a() != -1) {
      paramSpannableStringBuilder.setSpan(new StyleSpan(parame.a()), paramInt1, paramInt2, 33);
    }
    if (parame.b()) {
      paramSpannableStringBuilder.setSpan(new StrikethroughSpan(), paramInt1, paramInt2, 33);
    }
    if (parame.c()) {
      paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt1, paramInt2, 33);
    }
    if (parame.f()) {
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(parame.e()), paramInt1, paramInt2, 33);
    }
    if (parame.h()) {
      paramSpannableStringBuilder.setSpan(new BackgroundColorSpan(parame.g()), paramInt1, paramInt2, 33);
    }
    if (parame.d() != null) {
      paramSpannableStringBuilder.setSpan(new TypefaceSpan(parame.d()), paramInt1, paramInt2, 33);
    }
    if (parame.j() != null) {
      paramSpannableStringBuilder.setSpan(new AlignmentSpan.Standard(parame.j()), paramInt1, paramInt2, 33);
    }
    int i = parame.k();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(parame.l() / 100.0F), paramInt1, paramInt2, 33);
        return;
      }
      paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(parame.l()), paramInt1, paramInt2, 33);
      return;
    }
    paramSpannableStringBuilder.setSpan(new AbsoluteSizeSpan((int)parame.l(), true), paramInt1, paramInt2, 33);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ai.d
 * JD-Core Version:    0.7.0.1
 */