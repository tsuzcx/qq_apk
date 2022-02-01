package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.bizparts.danmaku.element.ColorElement;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import java.util.regex.Pattern;

public class RichTextParser
{
  public static int a = QCircleConfigHelper.a("QZoneSetting", "RichTextNeedDecode", Integer.valueOf(0)).intValue();
  public static final Pattern b = Pattern.compile("<uin:.*?,nickname:.*?>");
  public static final Pattern c = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
  public static final Pattern d = Pattern.compile("\\{url:(.*?),text:(.*?),color:(.*?)\\}");
  public static final Pattern e = Pattern.compile("\\{url:.*?,text:.*?\\}");
  public static final Pattern f = Pattern.compile("\\<uin:.*?,nick(name)?:.*?\\>");
  public static final Pattern g = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
  public static final Pattern h = Pattern.compile("\\{img:.*?,w:\\d+,h:\\d+\\}");
  public static final Pattern i = Pattern.compile("\\{img:.*?,w:\\d+,h:.+?\\}");
  
  public static ColorElement a(String paramString)
  {
    int j = paramString.indexOf("text:") + 5;
    int i1 = paramString.indexOf(",color:");
    ColorElement localColorElement;
    int k;
    int m;
    int n;
    if ((j != -1) && (i1 != -1))
    {
      localColorElement = new ColorElement();
      localColorElement.a = paramString.substring(j, i1);
      k = paramString.indexOf(",useDefaultFont:");
      m = paramString.indexOf(",useSuperFont:");
      n = paramString.indexOf(",fontName:");
      j = paramString.length() - 1;
      if (k == -1) {}
    }
    try
    {
      if (paramString.charAt(k + 16) == '1') {
        localColorElement.c = true;
      }
      label105:
      j = k;
      if (m != -1)
      {
        if (k == -1) {
          k = m;
        }
        j = k;
      }
      try
      {
        if (paramString.charAt(m + 14) == '0')
        {
          localColorElement.d = false;
          j = k;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          j = k;
        }
      }
      m = j;
      try
      {
        int i2 = paramString.indexOf(",bold:");
        k = j;
        if (i2 >= 0)
        {
          m = j;
          k = Math.min(i2, j);
        }
        j = k;
        m = k;
        if (paramString.charAt(i2 + 6) == '1')
        {
          m = k;
          localColorElement.e = true;
          j = k;
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          j = m;
        }
      }
      k = j;
      if (n != -1) {}
      try
      {
        str = paramString.substring(n + 10, j);
        if (!TextUtils.isEmpty(str))
        {
          str = str.trim();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("https://downv6.qq.com/video_story/qcircle/ttf/");
          localStringBuilder.append(str);
          localStringBuilder.append(".ttf");
          localColorElement.f = localStringBuilder.toString();
        }
        k = n;
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          String str;
          k = j;
        }
      }
      try
      {
        str = paramString.substring(i1 + 7, k);
        paramString = str;
        if (!TextUtils.isEmpty(str))
        {
          paramString = str;
          if (!str.startsWith("#"))
          {
            paramString = new StringBuilder();
            paramString.append("#");
            paramString.append(str);
            paramString = paramString.toString();
          }
        }
        localColorElement.b = Color.parseColor(paramString);
        return localColorElement;
      }
      catch (Exception paramString) {}
      return new ColorElement();
    }
    catch (Exception localException1)
    {
      break label105;
    }
    return localColorElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.RichTextParser
 * JD-Core Version:    0.7.0.1
 */