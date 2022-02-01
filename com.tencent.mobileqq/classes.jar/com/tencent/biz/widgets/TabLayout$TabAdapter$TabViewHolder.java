package com.tencent.biz.widgets;

import android.util.SparseArray;
import android.view.View;

public class TabLayout$TabAdapter$TabViewHolder
{
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  
  private TabLayout$TabAdapter$TabViewHolder(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public <T extends View> T a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localView.findViewById(paramInt));
      }
    }
    return (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout.TabAdapter.TabViewHolder
 * JD-Core Version:    0.7.0.1
 */