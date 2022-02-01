package com.tencent.biz.richframework.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MultiTabViewPager
  extends ViewPagerCompat
{
  public MultiTabViewPager(Context paramContext)
  {
    super(paramContext);
    b(this);
  }
  
  public MultiTabViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(this);
  }
  
  public static void b(ViewPager paramViewPager)
  {
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mDefaultGutterSize");
      localField.setAccessible(true);
      localField.set(paramViewPager, Integer.valueOf(0));
      paramViewPager.requestLayout();
      return;
    }
    catch (Exception paramViewPager)
    {
      QLog.e("QCircleFolderTabViewPag", 1, "clearGutterSize:", paramViewPager);
    }
  }
  
  DataSetObserver a(ViewPager paramViewPager)
  {
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mObserver");
      localField.setAccessible(true);
      paramViewPager = (DataSetObserver)localField.get(paramViewPager);
      return paramViewPager;
    }
    catch (Exception paramViewPager)
    {
      paramViewPager.printStackTrace();
    }
    return null;
  }
  
  void a(PagerAdapter paramPagerAdapter, DataSetObserver paramDataSetObserver)
  {
    try
    {
      Method localMethod = PagerAdapter.class.getDeclaredMethod("setViewPagerObserver", new Class[] { DataSetObserver.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramPagerAdapter, new Object[] { paramDataSetObserver });
      return;
    }
    catch (Exception paramPagerAdapter)
    {
      paramPagerAdapter.printStackTrace();
    }
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView != this) && ((paramView instanceof MultiPicViewPager)) && (((MultiPicViewPager)paramView).a())) {
      return true;
    }
    if ((paramView instanceof RecyclerView))
    {
      RecyclerView localRecyclerView = (RecyclerView)paramView;
      if (((localRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) && (localRecyclerView.getLayoutManager().canScrollHorizontally())) {
        return true;
      }
    }
    return super.canScroll(paramView, paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    PagerAdapter localPagerAdapter = getAdapter();
    if (localPagerAdapter != null) {
      a(localPagerAdapter, null);
    }
    super.setAdapter(paramPagerAdapter);
    a(paramPagerAdapter, a(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.widget.MultiTabViewPager
 * JD-Core Version:    0.7.0.1
 */