package com.tencent.mobileqq.activity.aio.doodle;

import java.util.Comparator;

public class LoadDataJob$SortComparator
  implements Comparator
{
  public LoadDataJob$SortComparator(LoadDataJob paramLoadDataJob) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (PathDrawer)paramObject1;
    paramObject2 = (PathDrawer)paramObject2;
    return paramObject1.a - paramObject2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.SortComparator
 * JD-Core Version:    0.7.0.1
 */