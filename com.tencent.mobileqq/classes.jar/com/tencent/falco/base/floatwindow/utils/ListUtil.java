package com.tencent.falco.base.floatwindow.utils;

import java.util.List;

public class ListUtil
{
  public static <T> boolean addAll(List<T> paramList1, List<T> paramList2)
  {
    if ((paramList2 != null) && (paramList1 != null)) {
      return paramList1.addAll(paramList2);
    }
    return false;
  }
  
  public static <T> T get(List<T> paramList, int paramInt)
  {
    if ((!isEmpty(paramList)) && (paramInt < getCount(paramList)) && (paramInt >= 0)) {
      return paramList.get(paramInt);
    }
    return null;
  }
  
  public static <T> int getCount(List<T> paramList)
  {
    if (paramList == null) {
      return 0;
    }
    return paramList.size();
  }
  
  public static <T> boolean isEmpty(List<T> paramList)
  {
    return (paramList == null) || (paramList.size() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.utils.ListUtil
 * JD-Core Version:    0.7.0.1
 */