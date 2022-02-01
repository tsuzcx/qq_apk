package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import zrp;
import zrq;

public class EmptySupportViewPager
  extends ViewPager
{
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new zrp(this);
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new zrq(this);
  public List<ViewPager.OnPageChangeListener> a;
  public Set<Pair<View, Boolean>> a;
  
  public EmptySupportViewPager(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    super.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
  }
  
  public EmptySupportViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    super.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    if (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if (((Boolean)localPair.second).booleanValue()) {}
      int i;
      switch (paramInt)
      {
      default: 
        i = paramInt;
      }
      for (;;)
      {
        ((View)localPair.first).setVisibility(i);
        break;
        i = 0;
        continue;
        i = 8;
      }
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
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void removeOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnPageChangeListener);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.EmptySupportViewPager
 * JD-Core Version:    0.7.0.1
 */