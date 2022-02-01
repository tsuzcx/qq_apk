package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EmptySupportViewPager
  extends ViewPager
{
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new EmptySupportViewPager.1(this);
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = new EmptySupportViewPager.2(this);
  public List<ViewPager.OnPageChangeListener> a;
  public Set<Pair<View, Boolean>> a;
  
  public EmptySupportViewPager(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    super.setOnPageChangeListener(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener);
  }
  
  public EmptySupportViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    super.setOnPageChangeListener(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener);
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if (((Boolean)localPair.second).booleanValue()) {
        if (paramInt != 0)
        {
          if ((paramInt == 4) || (paramInt == 8))
          {
            i = 0;
            break label75;
          }
        }
        else
        {
          i = 8;
          break label75;
        }
      }
      int i = paramInt;
      label75:
      ((View)localPair.first).setVisibility(i);
    }
  }
  
  public void addOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramOnPageChangeListener);
  }
  
  public void clearOnPageChangeListeners()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void removeOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.remove(paramOnPageChangeListener);
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    PagerAdapter localPagerAdapter = super.getAdapter();
    if (localPagerAdapter != null) {
      localPagerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    super.setAdapter(paramPagerAdapter);
    if (paramPagerAdapter != null)
    {
      paramPagerAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver.onChanged();
    }
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    throw new RuntimeException("please use addOnPageChangeListener instead");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.EmptySupportViewPager
 * JD-Core Version:    0.7.0.1
 */