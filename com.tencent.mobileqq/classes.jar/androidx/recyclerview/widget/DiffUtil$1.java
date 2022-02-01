package androidx.recyclerview.widget;

import java.util.Comparator;

final class DiffUtil$1
  implements Comparator<DiffUtil.Snake>
{
  public int compare(DiffUtil.Snake paramSnake1, DiffUtil.Snake paramSnake2)
  {
    int j = paramSnake1.x - paramSnake2.x;
    int i = j;
    if (j == 0) {
      i = paramSnake1.y - paramSnake2.y;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.DiffUtil.1
 * JD-Core Version:    0.7.0.1
 */