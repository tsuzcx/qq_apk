package com.tencent.biz.troopgift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public abstract class absMultiViewPager
  extends ViewPager
  implements AdapterView.OnItemClickListener
{
  protected AdapterView.OnItemClickListener a;
  protected ViewPager.OnPageChangeListener a;
  protected absMultiViewPager.OnPagerSizeChangeListener a;
  protected absMultiViewPager.ViewPagerAdapter a;
  protected ArrayList<Object> a;
  protected ArrayList<View> b = new ArrayList();
  protected int d;
  
  public absMultiViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public absMultiViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static ArrayList<Object> a(ArrayList<Object> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= paramArrayList.size()) && (paramInt2 <= paramArrayList.size()))
    {
      localObject = new ArrayList();
      while (paramInt1 < paramInt2)
      {
        ((ArrayList)localObject).add(paramArrayList.get(paramInt1));
        paramInt1 += 1;
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("subArrayList exception, start or end is large than src list size. src size:");
    ((StringBuilder)localObject).append(paramArrayList.size());
    ((StringBuilder)localObject).append(", start:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", end:");
    ((StringBuilder)localObject).append(paramInt2);
    paramArrayList = new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  public abstract int a();
  
  public abstract View a(int paramInt);
  
  protected void a(int paramInt1, int paramInt2)
  {
    absMultiViewPager.OnPagerSizeChangeListener localOnPagerSizeChangeListener = this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$OnPagerSizeChangeListener;
    if (localOnPagerSizeChangeListener != null) {
      localOnPagerSizeChangeListener.a(paramInt1, paramInt2, getCurrentItem());
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter = new absMultiViewPager.ViewPagerAdapter();
    setAdapter(this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter);
    this.b.clear();
    int j = a();
    int i = this.d;
    if (i != j)
    {
      a(i, j);
      this.d = j;
    }
    i = 0;
    while (i < j)
    {
      this.b.add(a(i));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter.a(this.b);
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter.notifyDataSetChanged();
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageSelected(0);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AdapterView.OnItemClickListener localOnItemClickListener = this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
    if (localOnItemClickListener != null) {
      localOnItemClickListener.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void setData(ArrayList<Object> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    b();
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = paramOnPageChangeListener;
    super.setOnPageChangeListener(paramOnPageChangeListener);
  }
  
  public void setOnPagerSizeChangeListener(absMultiViewPager.OnPagerSizeChangeListener paramOnPagerSizeChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$OnPagerSizeChangeListener = paramOnPagerSizeChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.absMultiViewPager
 * JD-Core Version:    0.7.0.1
 */