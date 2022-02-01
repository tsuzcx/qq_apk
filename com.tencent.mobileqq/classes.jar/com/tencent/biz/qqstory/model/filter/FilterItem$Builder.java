package com.tencent.biz.qqstory.model.filter;

public class FilterItem$Builder
{
  public long a;
  public String b;
  public int c;
  public String d;
  public String e;
  
  public FilterItem a()
  {
    try
    {
      FilterItem localFilterItem = new FilterItem(this.a, this.b, this.c, this.d, this.e, null);
      return localFilterItem;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new FilterItem.FilterItemIllegalException("create FilterItem instance failed", localIllegalArgumentException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.FilterItem.Builder
 * JD-Core Version:    0.7.0.1
 */