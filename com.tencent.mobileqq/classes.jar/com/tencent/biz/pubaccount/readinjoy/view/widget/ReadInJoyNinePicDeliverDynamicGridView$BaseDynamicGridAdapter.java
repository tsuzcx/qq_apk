package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class ReadInJoyNinePicDeliverDynamicGridView$BaseDynamicGridAdapter
  extends ReadInJoyNinePicDeliverDynamicGridView.AbstractDynamicGridAdapter
{
  protected int a;
  protected Context a;
  private ReadInJoyNinePicDeliverDynamicGridView.BaseDynamicGridAdapter.ExchangeItemsListener a;
  protected ArrayList<Object> a;
  
  protected ReadInJoyNinePicDeliverDynamicGridView$BaseDynamicGridAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    b(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void b(List<?> paramList)
  {
    a(paramList);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List<Object> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < getCount())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$BaseDynamicGridAdapter$ExchangeItemsListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$BaseDynamicGridAdapter$ExchangeItemsListener.a(paramInt1, paramInt2);
      }
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_JavaUtilArrayList, paramInt1, paramInt2);
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    a(paramObject);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramObject);
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public void c(Object paramObject)
  {
    a(paramObject);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    notifyDataSetChanged();
  }
  
  public void d(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramObject);
    b(paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView.BaseDynamicGridAdapter
 * JD-Core Version:    0.7.0.1
 */