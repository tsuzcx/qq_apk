package com.tencent.biz.subscribe.part.block.base;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseListViewAdapter<E>
  extends RecyclerView.Adapter
{
  private Handler a;
  public ArrayList<E> a;
  
  public BaseListViewAdapter()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(E paramE, int paramInt)
  {
    if ((paramE == null) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, paramE);
  }
  
  public void a(ArrayList<E> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    notifyDataSetChanged();
    if (paramArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public ArrayList<E> b()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void b(List<E> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyItemRangeInserted(this.jdField_a_of_type_JavaUtilArrayList.size(), paramList.size());
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    a().removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.base.BaseListViewAdapter
 * JD-Core Version:    0.7.0.1
 */