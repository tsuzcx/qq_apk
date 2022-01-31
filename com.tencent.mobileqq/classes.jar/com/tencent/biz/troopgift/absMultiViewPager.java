package com.tencent.biz.troopgift;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import ywr;

public abstract class absMultiViewPager
  extends ViewPager
  implements AdapterView.OnItemClickListener
{
  protected ViewPager.OnPageChangeListener a;
  protected AdapterView.OnItemClickListener a;
  protected absMultiViewPager.ViewPagerAdapter a;
  protected ArrayList<Object> a;
  protected ywr a;
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
    if ((paramInt1 > paramArrayList.size()) || (paramInt2 > paramArrayList.size())) {
      throw new IndexOutOfBoundsException("subArrayList exception, start or end is large than src list size. src size:" + paramArrayList.size() + ", start:" + paramInt1 + ", end:" + paramInt2);
    }
    ArrayList localArrayList = new ArrayList();
    while (paramInt1 < paramInt2)
    {
      localArrayList.add(paramArrayList.get(paramInt1));
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  public abstract int a();
  
  public abstract View a(int paramInt);
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ywr != null) {
      this.jdField_a_of_type_Ywr.a(paramInt1, paramInt2, getCurrentItem());
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter = new absMultiViewPager.ViewPagerAdapter();
    setAdapter(this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter);
    this.b.clear();
    int j = a();
    if (this.d != j)
    {
      a(this.d, j);
      this.d = j;
    }
    int i = 0;
    while (i < j)
    {
      this.b.add(a(i));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter.a(this.b);
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageSelected(0);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener != null) {
      this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
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
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = paramOnPageChangeListener;
    super.setOnPageChangeListener(paramOnPageChangeListener);
  }
  
  public void setOnPagerSizeChangeListener(ywr paramywr)
  {
    this.jdField_a_of_type_Ywr = paramywr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.troopgift.absMultiViewPager
 * JD-Core Version:    0.7.0.1
 */