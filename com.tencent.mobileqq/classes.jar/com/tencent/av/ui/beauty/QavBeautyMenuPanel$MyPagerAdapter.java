package com.tencent.av.ui.beauty;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class QavBeautyMenuPanel$MyPagerAdapter
  extends PagerAdapter
{
  final List<BeautyBaseView> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public QavBeautyMenuPanel$MyPagerAdapter(List<BeautyBaseView> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Collection localCollection;
    if (localCollection != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(localCollection);
    }
  }
  
  public BeautyBaseView a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (BeautyBaseView)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramViewGroup != null) && ((paramObject instanceof BeautyBaseView))) {
      paramViewGroup.removeView((BeautyBaseView)paramObject);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    BeautyBaseView localBeautyBaseView = a(paramInt);
    if ((paramViewGroup != null) && (localBeautyBaseView != null)) {
      paramViewGroup.addView(localBeautyBaseView);
    }
    return localBeautyBaseView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.QavBeautyMenuPanel.MyPagerAdapter
 * JD-Core Version:    0.7.0.1
 */