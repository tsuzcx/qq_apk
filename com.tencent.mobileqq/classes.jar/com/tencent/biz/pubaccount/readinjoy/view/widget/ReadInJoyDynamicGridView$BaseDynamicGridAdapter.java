package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class ReadInJoyDynamicGridView$BaseDynamicGridAdapter<T>
  extends ReadInJoyDynamicGridView.AbstractDynamicGridAdapter<T>
{
  protected Context a;
  protected List<T> a;
  protected int b;
  
  protected ReadInJoyDynamicGridView$BaseDynamicGridAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = paramInt;
  }
  
  private void a(List<T> paramList)
  {
    b(paramList);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public List<T> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt, T paramT)
  {
    a(paramT);
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramT);
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public void b(int paramInt)
  {
    if (paramInt < getCount())
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramInt);
      notifyDataSetChanged();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (paramInt2 < getCount())
    {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_JavaUtilList, paramInt1, paramInt2);
      notifyDataSetChanged();
    }
  }
  
  public void b(T paramT)
  {
    a(paramT);
    this.jdField_a_of_type_JavaUtilList.add(paramT);
    notifyDataSetChanged();
  }
  
  public void c()
  {
    b();
    this.jdField_a_of_type_JavaUtilList.clear();
    notifyDataSetChanged();
  }
  
  public void c(List<T> paramList)
  {
    c();
    a(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public T getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.BaseDynamicGridAdapter
 * JD-Core Version:    0.7.0.1
 */