package com.tencent.biz.qqcircle.bizparts.danmaku.matcher;

import com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoObjectPool;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextLayoutBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class EmoMatcher
  extends TextMatcher
{
  private TextLayoutBase b;
  
  public EmoMatcher(TextLayoutBase paramTextLayoutBase, Pattern paramPattern)
  {
    super(paramPattern);
    this.b = paramTextLayoutBase;
  }
  
  public ArrayList<TextCell> a(int paramInt, boolean paramBoolean, TextLayoutBase paramTextLayoutBase, CharSequence paramCharSequence, ArrayList<TextCell> paramArrayList)
  {
    paramTextLayoutBase = EmoObjectPool.a().a(this.a, paramInt, this.b);
    paramTextLayoutBase.cellIndex = 0;
    paramArrayList.add(paramTextLayoutBase);
    return paramArrayList;
  }
  
  public HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.matcher.EmoMatcher
 * JD-Core Version:    0.7.0.1
 */