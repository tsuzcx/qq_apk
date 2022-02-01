package com.tencent.mobileqq.activity.contact.recommendtroop.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class CommonAdapter<T>
  extends QuickRecyclerAdapter<T>
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  
  public CommonAdapter(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    a(new CommonAdapter.1(this, paramInt));
  }
  
  protected abstract ViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt);
  
  protected abstract void a(ViewHolder paramViewHolder, T paramT, int paramInt);
  
  public ViewHolder b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramContext, paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.base.CommonAdapter
 * JD-Core Version:    0.7.0.1
 */