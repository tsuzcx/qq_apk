package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import com.tencent.biz.qqcircle.utils.DisplayUtil;
import java.util.LinkedList;

public class TextCellHelper
{
  public static final int a = (int)(DisplayUtil.a() * 20.0F);
  private static final LinkedList<TextCellHelper.ParseOption> b = new LinkedList();
  
  static
  {
    int i = 10 - b.size();
    while (i > 0)
    {
      TextCellHelper.ParseOption localParseOption = new TextCellHelper.ParseOption(null);
      b.add(localParseOption);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellHelper
 * JD-Core Version:    0.7.0.1
 */