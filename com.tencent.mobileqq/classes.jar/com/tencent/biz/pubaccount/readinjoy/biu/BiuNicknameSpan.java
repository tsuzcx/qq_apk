package com.tencent.biz.pubaccount.readinjoy.biu;

import android.content.Context;
import android.graphics.Paint;
import android.text.style.ForegroundColorSpan;
import android.util.SparseIntArray;
import com.tencent.mobileqq.text.EmotcationConstants;
import org.jetbrains.annotations.NotNull;
import tnq;
import tns;

public class BiuNicknameSpan
  extends ForegroundColorSpan
  implements tnq, tns
{
  private int a;
  public long a;
  public String a;
  private String b;
  
  public BiuNicknameSpan(String paramString, long paramLong, CharSequence paramCharSequence)
  {
    super(-15504151);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    if (paramCharSequence != null) {}
    for (paramString = paramCharSequence.toString();; paramString = "")
    {
      this.b = paramString;
      return;
    }
  }
  
  public BiuNicknameSpan(String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    if (paramCharSequence != null) {}
    for (paramString = paramCharSequence.toString();; paramString = "")
    {
      this.b = paramString;
      return;
    }
  }
  
  public BiuNicknameSpan(String paramString, long paramLong, CharSequence paramCharSequence, Context paramContext, Paint paramPaint, int paramInt)
  {
    super(-15504151);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    if (paramCharSequence != null) {}
    for (paramString = paramCharSequence.toString();; paramString = "")
    {
      this.b = paramString;
      return;
    }
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuffer(paramCharSequence);
    int i = 0;
    if (i < paramCharSequence.length())
    {
      int k = paramCharSequence.codePointAt(i);
      int j;
      if ((k == 20) && (i < paramCharSequence.length() - 1))
      {
        paramCharSequence.delete(i, i + 2);
        j = i - 1;
      }
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (EmotcationConstants.EMOJI_MAP.get(k, -1) < 0);
      if ((k > 65535) && (paramCharSequence.length() >= i + 2)) {
        paramCharSequence.delete(i, i + 2);
      }
      for (;;)
      {
        j = i - 1;
        break;
        paramCharSequence.delete(i, i + 1);
      }
    }
    return paramCharSequence.toString();
  }
  
  @NotNull
  public String a()
  {
    return this.b;
  }
  
  public void a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan
 * JD-Core Version:    0.7.0.1
 */