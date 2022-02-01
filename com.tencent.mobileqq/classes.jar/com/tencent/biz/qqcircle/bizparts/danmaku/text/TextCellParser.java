package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.bizparts.danmaku.matcher.ColorMatcher;
import com.tencent.biz.qqcircle.bizparts.danmaku.matcher.EmoMatcher;
import com.tencent.biz.qqcircle.bizparts.danmaku.matcher.SystemEmojiMatcher;
import com.tencent.biz.qqcircle.bizparts.danmaku.matcher.TextMatcher;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class TextCellParser
{
  public static final int a = ViewUtils.a(17.0F);
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = a(null, paramString, a, false);
    paramString = new StringBuilder();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = ((TextCell)((Iterator)localObject).next()).getText();
      if (str != null) {
        paramString.append(str);
      }
    }
    return paramString.toString();
  }
  
  public static ArrayList<TextCell> a(TextLayoutBase paramTextLayoutBase, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    return a(paramTextLayoutBase, paramCharSequence, paramInt, paramBoolean, true, -1);
  }
  
  public static ArrayList<TextCell> a(TextLayoutBase paramTextLayoutBase, CharSequence paramCharSequence, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramTextLayoutBase, paramCharSequence, paramInt, paramBoolean1, paramBoolean2, -1);
  }
  
  public static ArrayList<TextCell> a(TextLayoutBase paramTextLayoutBase, CharSequence paramCharSequence, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return new ArrayList();
    }
    int j = paramCharSequence.hashCode();
    if (paramBoolean2)
    {
      ArrayList localArrayList = UiElementFixedCache.a().a(j);
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        return localArrayList;
      }
    }
    new ArrayList();
    int i = paramInt2;
    if (paramInt2 == -1) {
      i = paramInt1 - ViewUtils.a(1.5F);
    }
    paramTextLayoutBase = b(paramTextLayoutBase, paramCharSequence, i, paramBoolean1);
    if (paramBoolean2) {
      UiElementFixedCache.a().a(j, paramTextLayoutBase);
    }
    return paramTextLayoutBase;
  }
  
  private static ArrayList<TextCell> b(TextLayoutBase paramTextLayoutBase, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList(5);
    localArrayList3.add(new EmoMatcher(paramTextLayoutBase, Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2)));
    localArrayList3.add(new ColorMatcher(Patterns.m));
    localArrayList3.add(new EmoMatcher(paramTextLayoutBase, Patterns.p));
    localArrayList3.add(new SystemEmojiMatcher(paramTextLayoutBase, Patterns.o));
    Object localObject = localArrayList3.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TextMatcher)((Iterator)localObject).next()).a(paramCharSequence.toString());
    }
    int k = paramCharSequence.length();
    localObject = new StringBuilder(k);
    int i = 0;
    while (i < k)
    {
      Iterator localIterator = localArrayList3.iterator();
      TextMatcher localTextMatcher;
      do
      {
        boolean bool = localIterator.hasNext();
        j = 1;
        if (!bool) {
          break;
        }
        localTextMatcher = (TextMatcher)localIterator.next();
      } while (!localTextMatcher.a(i));
      if (((StringBuilder)localObject).length() > 0)
      {
        localArrayList2.add(new TextCell(0, ((StringBuilder)localObject).toString()));
        ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
      }
      localArrayList1.clear();
      localArrayList1 = localTextMatcher.a(paramInt, paramBoolean, paramTextLayoutBase, paramCharSequence, localArrayList1);
      if (localArrayList1 != null) {
        localArrayList2.addAll(localArrayList1);
      }
      i = localTextMatcher.a() - 1;
      break label297;
      int j = 0;
      label297:
      if (j == 0) {
        ((StringBuilder)localObject).append(paramCharSequence.charAt(i));
      }
      i += 1;
    }
    if (((StringBuilder)localObject).length() > 0) {
      localArrayList2.add(new TextCell(0, ((StringBuilder)localObject).toString()));
    }
    return localArrayList2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellParser
 * JD-Core Version:    0.7.0.1
 */