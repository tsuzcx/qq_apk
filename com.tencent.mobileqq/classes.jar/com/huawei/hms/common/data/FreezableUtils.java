package com.huawei.hms.common.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class FreezableUtils
{
  public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> paramArrayList)
  {
    return freezeIterable(paramArrayList);
  }
  
  public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] paramArrayOfE)
  {
    return freezeIterable(Arrays.asList(paramArrayOfE));
  }
  
  public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(((Freezable)paramIterable.next()).freeze());
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.common.data.FreezableUtils
 * JD-Core Version:    0.7.0.1
 */