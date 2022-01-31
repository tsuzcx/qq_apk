package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public abstract class BannerView$BannerViewAdapter<T, V extends View>
  extends PagerAdapter
{
  private SparseArray<V> a;
  protected List<T> a;
  
  public int a()
  {
    int i = 1;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      i = 0;
    }
    while (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      return i;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 2;
  }
  
  public V a(int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localView == null) && (b() > 1)) {
      if (paramInt == 0)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        localObject = a(paramInt, localObject);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
      }
    }
    do
    {
      do
      {
        return localObject;
        if (paramInt == this.jdField_a_of_type_JavaUtilList.size() + 1)
        {
          localObject = this.jdField_a_of_type_JavaUtilList.get(0);
          break;
        }
        localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
        break;
        localObject = localView;
      } while (localView != null);
      localObject = localView;
    } while (b() != 1);
    Object localObject = a(paramInt, this.jdField_a_of_type_JavaUtilList.get(0));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
    return localObject;
  }
  
  public abstract V a(int paramInt, T paramT);
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof View)) {
      paramViewGroup.removeView((View)paramObject);
    }
  }
  
  public int getCount()
  {
    return a();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = a(paramInt);
    if ((localView != null) && (paramViewGroup != null)) {
      paramViewGroup.addView(localView);
    }
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.BannerView.BannerViewAdapter
 * JD-Core Version:    0.7.0.1
 */