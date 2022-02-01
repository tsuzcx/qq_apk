package androidx.recyclerview.widget;

import java.util.Comparator;

final class GapWorker$1
  implements Comparator<GapWorker.Task>
{
  public int compare(GapWorker.Task paramTask1, GapWorker.Task paramTask2)
  {
    RecyclerView localRecyclerView = paramTask1.view;
    int k = 1;
    if (localRecyclerView == null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramTask2.view == null) {
      j = 1;
    } else {
      j = 0;
    }
    if (i != j)
    {
      if (paramTask1.view == null) {
        return 1;
      }
      return -1;
    }
    if (paramTask1.immediate != paramTask2.immediate)
    {
      i = k;
      if (paramTask1.immediate) {
        i = -1;
      }
      return i;
    }
    int i = paramTask2.viewVelocity - paramTask1.viewVelocity;
    if (i != 0) {
      return i;
    }
    i = paramTask1.distanceToItem - paramTask2.distanceToItem;
    if (i != 0) {
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.GapWorker.1
 * JD-Core Version:    0.7.0.1
 */