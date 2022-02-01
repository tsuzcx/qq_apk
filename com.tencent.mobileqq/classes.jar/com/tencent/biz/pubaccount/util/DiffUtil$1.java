package com.tencent.biz.pubaccount.util;

import java.util.Comparator;

final class DiffUtil$1
  implements Comparator<DiffUtil.Snake>
{
  public int a(DiffUtil.Snake paramSnake1, DiffUtil.Snake paramSnake2)
  {
    int j = paramSnake1.a - paramSnake2.a;
    int i = j;
    if (j == 0) {
      i = paramSnake1.b - paramSnake2.b;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.DiffUtil.1
 * JD-Core Version:    0.7.0.1
 */