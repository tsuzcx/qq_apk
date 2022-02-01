package com.tencent.biz.qqcircle.flutter.richtext.matcher;

import com.tencent.biz.qqcircle.bizparts.danmaku.matcher.TextMatcher;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextLayoutBase;
import com.tencent.biz.qqcircle.flutter.richtext.QcircleFlutterTextCellParser;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class AtUserMatcher
  extends TextMatcher
{
  public static int b = -16777216;
  
  public AtUserMatcher(Pattern paramPattern)
  {
    super(paramPattern);
  }
  
  public static HashMap<String, Object> a(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf("uin:");
    int k = paramString1.indexOf(paramString2);
    if (k == -1)
    {
      paramString1 = new HashMap();
      paramString1.put("text", "");
      return paramString1;
    }
    String str = paramString1.substring(i + 4, k);
    int j = paramString1.indexOf(",who:", k);
    i = j;
    if (j == -1) {
      i = paramString1.length() - 1;
    }
    j = paramString1.indexOf(",superLike:");
    if (j != -1) {
      i = j;
    }
    j = i;
    if (i == -1) {
      j = paramString1.length() - 1;
    }
    paramString1 = paramString1.substring(k + paramString2.length(), j);
    try
    {
      paramString2 = URLDecoder.decode(paramString1, "UTF-8");
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      label123:
      break label123;
    }
    paramString2 = new HashMap();
    paramString2.put("nodeType", Integer.valueOf(QcircleFlutterTextCellParser.q));
    paramString2.put("text", paramString1);
    paramString2.put("uinStr", str);
    paramString2.put("textColor", Integer.valueOf(b));
    return paramString2;
  }
  
  public ArrayList<TextCell> a(int paramInt, boolean paramBoolean, TextLayoutBase paramTextLayoutBase, CharSequence paramCharSequence, ArrayList<TextCell> paramArrayList)
  {
    return null;
  }
  
  public HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence)
  {
    return a(this.a, ",nick:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.richtext.matcher.AtUserMatcher
 * JD-Core Version:    0.7.0.1
 */