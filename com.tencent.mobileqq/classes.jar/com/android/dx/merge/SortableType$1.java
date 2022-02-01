package com.android.dx.merge;

import java.util.Comparator;

final class SortableType$1
  implements Comparator<SortableType>
{
  public int compare(SortableType paramSortableType1, SortableType paramSortableType2)
  {
    if (paramSortableType1 == paramSortableType2) {
      return 0;
    }
    if (paramSortableType2 == null) {
      return -1;
    }
    if (paramSortableType1 == null) {
      return 1;
    }
    if (SortableType.access$000(paramSortableType1) != SortableType.access$000(paramSortableType2)) {
      return SortableType.access$000(paramSortableType1) - SortableType.access$000(paramSortableType2);
    }
    return paramSortableType1.getTypeIndex() - paramSortableType2.getTypeIndex();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.SortableType.1
 * JD-Core Version:    0.7.0.1
 */