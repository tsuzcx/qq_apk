package com.tencent.biz.qqstory.view.widget;

import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import java.util.List;

public abstract class InnerListViewAdapter
{
  private int jdField_a_of_type_Int;
  private List jdField_a_of_type_JavaUtilList;
  
  public InnerListViewAdapter(int paramInt, List paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt, BaseViewHolder paramBaseViewHolder)
  {
    a(paramInt, this.jdField_a_of_type_JavaUtilList.get(paramInt), paramBaseViewHolder);
  }
  
  public abstract void a(int paramInt, Object paramObject, BaseViewHolder paramBaseViewHolder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.InnerListViewAdapter
 * JD-Core Version:    0.7.0.1
 */