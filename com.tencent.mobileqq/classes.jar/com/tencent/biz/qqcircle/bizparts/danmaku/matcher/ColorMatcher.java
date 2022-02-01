package com.tencent.biz.qqcircle.bizparts.danmaku.matcher;

import com.tencent.biz.qqcircle.bizparts.danmaku.element.ColorElement;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.ColorTextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.RichTextParser;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextLayoutBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class ColorMatcher
  extends TextMatcher
{
  public ColorMatcher(Pattern paramPattern)
  {
    super(paramPattern);
  }
  
  public ArrayList<TextCell> a(int paramInt, boolean paramBoolean, TextLayoutBase paramTextLayoutBase, CharSequence paramCharSequence, ArrayList<TextCell> paramArrayList)
  {
    paramTextLayoutBase = RichTextParser.a(this.a);
    paramCharSequence = new ColorTextCell();
    if (paramTextLayoutBase == null)
    {
      paramArrayList.add(paramCharSequence);
      return paramArrayList;
    }
    paramCharSequence.type = 9;
    paramCharSequence.setTextColor(paramTextLayoutBase.b);
    paramCharSequence.setClickable(false);
    paramCharSequence.text = paramTextLayoutBase.a;
    paramCharSequence.useDefaultFont = paramTextLayoutBase.c;
    paramCharSequence.useSuperFont = paramTextLayoutBase.d;
    paramCharSequence.setTextBold(paramTextLayoutBase.e);
    paramCharSequence.setFontFamilyUrl(paramTextLayoutBase.f);
    paramArrayList.add(paramCharSequence);
    return paramArrayList;
  }
  
  public HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.matcher.ColorMatcher
 * JD-Core Version:    0.7.0.1
 */