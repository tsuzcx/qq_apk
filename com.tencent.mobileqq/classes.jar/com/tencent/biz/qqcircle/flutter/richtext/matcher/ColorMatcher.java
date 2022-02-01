package com.tencent.biz.qqcircle.flutter.richtext.matcher;

import com.tencent.biz.qqcircle.bizparts.danmaku.matcher.TextMatcher;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextLayoutBase;
import java.util.ArrayList;
import java.util.HashMap;

public class ColorMatcher
  extends TextMatcher
{
  public ArrayList<TextCell> a(int paramInt, boolean paramBoolean, TextLayoutBase paramTextLayoutBase, CharSequence paramCharSequence, ArrayList<TextCell> paramArrayList)
  {
    return null;
  }
  
  public HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence)
  {
    paramInt = this.a.indexOf("text:");
    int i = this.a.indexOf(",color");
    String str1 = this.a.substring(paramInt + 5, i);
    paramInt = this.a.indexOf("color:");
    i = this.a.indexOf("}");
    String str2 = this.a.substring(paramInt + 6, i);
    paramCharSequence = new HashMap();
    try
    {
      paramCharSequence.put("text", str1);
      paramCharSequence.put("color", str2);
      return paramCharSequence;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.richtext.matcher.ColorMatcher
 * JD-Core Version:    0.7.0.1
 */