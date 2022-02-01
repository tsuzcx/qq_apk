package com.tencent.biz.qqstory.model.filter;

public class FilterItem$Builder
{
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  
  public FilterItem a()
  {
    try
    {
      FilterItem localFilterItem = new FilterItem(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c, null);
      return localFilterItem;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new FilterItem.FilterItemIllegalException("create FilterItem instance failed", localIllegalArgumentException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.FilterItem.Builder
 * JD-Core Version:    0.7.0.1
 */