package com.tencent.biz.qqstory.common.recyclerview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter
  extends HeaderAndFooterAdapter
{
  private List a;
  
  public BaseAdapter(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public abstract int a(int paramInt);
  
  public int a(Object paramObject)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramObject);
    if (i < 0) {
      return i;
    }
    this.jdField_a_of_type_JavaUtilList.set(i, paramObject);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      notifyItemChanged(i);
      return i;
    }
    notifyItemChanged(i + 1);
    return i;
  }
  
  public Object a(int paramInt)
  {
    if (((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 0)) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size() + b())) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    notifyDataSetChanged();
  }
  
  public void a(Object paramObject)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramObject);
    if (i < 0) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(i);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      notifyItemRemoved(i);
      return;
    }
    notifyItemRemoved(i + 1);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramObject);
    if (i != -1) {
      this.jdField_a_of_type_JavaUtilList.remove(i);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramObject);
    if (i != -1)
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        notifyItemMoved(i, paramInt);
        notifyItemChanged(paramInt);
        return;
      }
      notifyItemMoved(i + 1, paramInt + 1);
      notifyItemChanged(paramInt + 1);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      notifyItemInserted(paramInt);
      return;
    }
    notifyItemInserted(paramInt + 1);
  }
  
  public boolean a(List paramList)
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      boolean bool = i | this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      if (bool) {
        notifyDataSetChanged();
      }
      return bool;
    }
  }
  
  public boolean b(List paramList)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (bool) {
      notifyDataSetChanged();
    }
    return bool;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + a();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 0)) {
      return 1024;
    }
    if ((this.b != null) && (paramInt == this.jdField_a_of_type_JavaUtilList.size() + b())) {
      return 1025;
    }
    return a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.common.recyclerview.BaseAdapter
 * JD-Core Version:    0.7.0.1
 */