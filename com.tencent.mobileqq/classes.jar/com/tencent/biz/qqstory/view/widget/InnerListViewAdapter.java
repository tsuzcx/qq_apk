package com.tencent.biz.qqstory.view.widget;

import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import java.util.List;

public abstract class InnerListViewAdapter<T>
{
  private int a;
  private List<T> b;
  
  public InnerListViewAdapter(int paramInt, List<T> paramList)
  {
    this.a = paramInt;
    this.b = paramList;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt, BaseViewHolder paramBaseViewHolder)
  {
    a(paramInt, this.b.get(paramInt), paramBaseViewHolder);
  }
  
  public abstract void a(int paramInt, T paramT, BaseViewHolder paramBaseViewHolder);
  
  public List<T> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.InnerListViewAdapter
 * JD-Core Version:    0.7.0.1
 */