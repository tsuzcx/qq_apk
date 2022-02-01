package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import com.etrump.mixlayout.api.IETDecoration;

public class ETAnimator$DecorationHolder
{
  public int a = -1;
  public int b = -1;
  public ETTextLayout c = null;
  public CharSequence d = null;
  private long e = 0L;
  
  static DecorationHolder a(TextCellLayout paramTextCellLayout)
  {
    if (paramTextCellLayout.m == null) {
      return null;
    }
    DecorationHolder localDecorationHolder = new DecorationHolder();
    localDecorationHolder.c = paramTextCellLayout.n;
    localDecorationHolder.d = paramTextCellLayout.j();
    localDecorationHolder.a = paramTextCellLayout.m.currentFrameIndex();
    localDecorationHolder.e = System.currentTimeMillis();
    localDecorationHolder.b = paramTextCellLayout.k;
    return localDecorationHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.ETAnimator.DecorationHolder
 * JD-Core Version:    0.7.0.1
 */