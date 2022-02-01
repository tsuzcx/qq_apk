package com.eclipsesource.mmv8.utils;

import java.util.List;

class V8ObjectUtils$ListWrapper
{
  private List<? extends Object> list;
  
  public V8ObjectUtils$ListWrapper(List<? extends Object> paramList)
  {
    this.list = paramList;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof ListWrapper;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((ListWrapper)paramObject).list == this.list) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return System.identityHashCode(this.list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.V8ObjectUtils.ListWrapper
 * JD-Core Version:    0.7.0.1
 */