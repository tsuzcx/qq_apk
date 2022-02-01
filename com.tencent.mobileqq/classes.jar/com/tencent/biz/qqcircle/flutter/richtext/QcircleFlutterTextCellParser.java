package com.tencent.biz.qqcircle.flutter.richtext;

import android.util.Log;
import com.tencent.biz.qqcircle.bizparts.danmaku.matcher.TextMatcher;
import com.tencent.biz.qqcircle.flutter.richtext.matcher.AtUserMatcher;
import com.tencent.biz.qqcircle.flutter.richtext.matcher.EmoMatcher;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

public class QcircleFlutterTextCellParser
{
  public static String a = "QcircleFlutterTextCellParser";
  public static final int b = ViewUtils.a(17.0F);
  public static final Pattern c = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
  public static final Pattern d = Pattern.compile("\\{url:(.*?),text:(.*?),color:(.*?)\\}");
  public static final Pattern e = Pattern.compile("\\{url:.*?,text:.*?\\}");
  public static final Pattern f = Pattern.compile("\\<uin:.*?,nick(name)?:.*?\\>");
  public static final Pattern g = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]");
  public static final Pattern h = Pattern.compile("\\{text:.*?,color:.*?\\}");
  public static final Pattern i = Pattern.compile("\\{img:.*?,w:\\d+,h:\\d+\\}");
  public static final Pattern j = Pattern.compile("\\{img:.*?,w:\\d+,h:.+?\\}");
  public static int o = 0;
  public static int p = 1;
  public static int q = 2;
  public static int r = 3;
  public static int s = 4;
  public boolean k = true;
  public int l = -14392957;
  public int m = -14392957;
  public int n = b;
  
  public static ArrayList<HashMap<String, Object>> a(CharSequence paramCharSequence)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList(5);
    localArrayList2.add(new AtUserMatcher(c));
    localArrayList2.add(new EmoMatcher(g));
    Object localObject1 = localArrayList2.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((TextMatcher)((Iterator)localObject1).next()).a(paramCharSequence.toString());
    }
    int i3 = paramCharSequence.length();
    localObject1 = new StringBuilder(i3);
    int i1 = 0;
    while (i1 < i3)
    {
      Object localObject2 = localArrayList2.iterator();
      TextMatcher localTextMatcher;
      do
      {
        boolean bool = ((Iterator)localObject2).hasNext();
        i2 = 1;
        if (!bool) {
          break;
        }
        localTextMatcher = (TextMatcher)((Iterator)localObject2).next();
      } while (!localTextMatcher.a(i1));
      if (((StringBuilder)localObject1).length() > 0)
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("nodeType", Integer.valueOf(o));
        ((HashMap)localObject2).put("text", ((StringBuilder)localObject1).toString());
        localArrayList1.add(localObject2);
        ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
      }
      localArrayList1.add(localTextMatcher.a(0, true, paramCharSequence));
      i1 = localTextMatcher.a() - 1;
      break label249;
      int i2 = 0;
      label249:
      if (i2 == 0) {
        ((StringBuilder)localObject1).append(paramCharSequence.charAt(i1));
      }
      i1 += 1;
    }
    if (((StringBuilder)localObject1).length() > 0)
    {
      paramCharSequence = new HashMap();
      paramCharSequence.put("nodeType", Integer.valueOf(o));
      paramCharSequence.put("text", ((StringBuilder)localObject1).toString());
      localArrayList1.add(paramCharSequence);
    }
    Log.d(a, localArrayList1.toString());
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.richtext.QcircleFlutterTextCellParser
 * JD-Core Version:    0.7.0.1
 */