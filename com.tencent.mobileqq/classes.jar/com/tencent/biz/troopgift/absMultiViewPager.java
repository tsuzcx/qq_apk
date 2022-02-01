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
  protected ArrayList<Object> f = new ArrayList();
  protected ArrayList<View> g = new ArrayList();
  protected absMultiViewPager.ViewPagerAdapter h;
  protected AdapterView.OnItemClickListener i;
  protected int j;
  protected absMultiViewPager.OnPagerSizeChangeListener k;
  protected ViewPager.OnPageChangeListener l;
  
  public absMultiViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public absMultiViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
  
  protected void a(int paramInt1, int paramInt2)
  {
    absMultiViewPager.OnPagerSizeChangeListener localOnPagerSizeChangeListener = this.k;
    if (localOnPagerSizeChangeListener != null) {
      localOnPagerSizeChangeListener.a(paramInt1, paramInt2, getCurrentItem());
    }
  }
  
  public abstract View b(int paramInt);
  
  public void b()
  {
    this.h = new absMultiViewPager.ViewPagerAdapter();
    setAdapter(this.h);
    this.g.clear();
    int n = getViewPagerCount();
    int m = this.j;
    if (m != n)
    {
      a(m, n);
      this.j = n;
    }
    m = 0;
    while (m < n)
    {
      this.g.add(b(m));
      m += 1;
    }
    this.h.a(this.g);
    this.h.notifyDataSetChanged();
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.l;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageSelected(0);
    }
  }
  
  public abstract int getViewPagerCount();
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AdapterView.OnItemClickListener localOnItemClickListener = this.i;
    if (localOnItemClickListener != null) {
      localOnItemClickListener.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void setData(ArrayList<Object> paramArrayList)
  {
    this.f = paramArrayList;
    b();
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.i = paramOnItemClickListener;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.l = paramOnPageChangeListener;
    super.setOnPageChangeListener(paramOnPageChangeListener);
  }
  
  public void setOnPagerSizeChangeListener(absMultiViewPager.OnPagerSizeChangeListener paramOnPagerSizeChangeListener)
  {
    this.k = paramOnPagerSizeChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.absMultiViewPager
 * JD-Core Version:    0.7.0.1
 */