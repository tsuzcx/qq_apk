package com.tencent.biz.qqcircle.bizparts.danmaku.matcher;

import com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoObjectPool;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextLayoutBase;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class SystemEmojiMatcher
  extends TextMatcher
{
  private TextLayoutBase b;
  
  public SystemEmojiMatcher(TextLayoutBase paramTextLayoutBase, Pattern paramPattern)
  {
    super(paramPattern);
    this.b = paramTextLayoutBase;
  }
  
  public ArrayList<TextCell> a(int paramInt, boolean paramBoolean, TextLayoutBase paramTextLayoutBase, CharSequence paramCharSequence, ArrayList<TextCell> paramArrayList)
  {
    paramInt = Math.max(paramInt, ViewUtils.a(10.0F));
    paramCharSequence = EmoObjectPool.a().b(this.a, paramInt, this.b);
    paramTextLayoutBase = paramCharSequence;
    if (paramCharSequence == null) {
      paramTextLayoutBase = new TextCell(0, this.a);
    }
    paramArrayList.add(paramTextLayoutBase);
    return paramArrayList;
  }
  
  public HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.matcher.SystemEmojiMatcher
 * JD-Core Version:    0.7.0.1
 */