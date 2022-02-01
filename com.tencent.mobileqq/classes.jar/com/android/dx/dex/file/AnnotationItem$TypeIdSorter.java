package com.android.dx.dex.file;

import java.util.Comparator;

class AnnotationItem$TypeIdSorter
  implements Comparator<AnnotationItem>
{
  public int compare(AnnotationItem paramAnnotationItem1, AnnotationItem paramAnnotationItem2)
  {
    int i = AnnotationItem.access$100(paramAnnotationItem1).getIndex();
    int j = AnnotationItem.access$100(paramAnnotationItem2).getIndex();
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.AnnotationItem.TypeIdSorter
 * JD-Core Version:    0.7.0.1
 */