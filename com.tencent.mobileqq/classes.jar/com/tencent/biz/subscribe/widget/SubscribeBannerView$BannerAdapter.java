package com.tencent.biz.subscribe.widget;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class SubscribeBannerView$BannerAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedList<View> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  protected abstract View a(View paramView, Object paramObject);
  
  protected abstract View a(ViewGroup paramViewGroup);
  
  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt % this.jdField_a_of_type_JavaUtilArrayList.size());
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
        break label76;
      }
    }
    label76:
    for (View localView = (View)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();; localView = a(paramViewGroup))
    {
      paramViewGroup.addView(localView);
      return a(localView, localObject);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.get(0);
      break;
    }
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    notifyDataSetChanged();
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      notifyDataSetChanged();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramObject);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      return 2147483647;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_Int -= 1;
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Int = getCount();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeBannerView.BannerAdapter
 * JD-Core Version:    0.7.0.1
 */