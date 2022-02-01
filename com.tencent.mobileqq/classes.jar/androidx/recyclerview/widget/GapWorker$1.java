package androidx.recyclerview.widget;

import java.util.Comparator;

final class GapWorker$1
  implements Comparator<GapWorker.Task>
{
  public int compare(GapWorker.Task paramTask1, GapWorker.Task paramTask2)
  {
    int k = -1;
    int m = 1;
    int i;
    int j;
    if (paramTask1.view == null)
    {
      i = 1;
      if (paramTask2.view != null) {
        break label48;
      }
      j = 1;
      label25:
      if (i == j) {
        break label56;
      }
      if (paramTask1.view != null) {
        break label54;
      }
      i = m;
    }
    label48:
    label54:
    label56:
    do
    {
      do
      {
        return i;
        i = 0;
        break;
        j = 0;
        break label25;
        return -1;
        if (paramTask1.immediate != paramTask2.immediate)
        {
          if (paramTask1.immediate) {}
          for (i = k;; i = 1) {
            return i;
          }
        }
        j = paramTask2.viewVelocity - paramTask1.viewVelocity;
        i = j;
      } while (j != 0);
      j = paramTask1.distanceToItem - paramTask2.distanceToItem;
      i = j;
    } while (j != 0);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.GapWorker.1
 * JD-Core Version:    0.7.0.1
 */