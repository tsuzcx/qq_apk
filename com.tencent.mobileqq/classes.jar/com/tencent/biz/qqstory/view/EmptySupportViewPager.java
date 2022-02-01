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
  public Set<Pair<View, Boolean>> a = new HashSet();
  public List<ViewPager.OnPageChangeListener> b;
  private DataSetObserver c = new EmptySupportViewPager.1(this);
  private ViewPager.OnPageChangeListener d = new EmptySupportViewPager.2(this);
  
  public EmptySupportViewPager(Context paramContext)
  {
    super(paramContext);
    super.setOnPageChangeListener(this.d);
  }
  
  public EmptySupportViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnPageChangeListener(this.d);
  }
  
  public void addOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramOnPageChangeListener);
  }
  
  public void clearOnPageChangeListeners()
  {
    List localList = this.b;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void removeOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    List localList = this.b;
    if (localList != null) {
      localList.remove(paramOnPageChangeListener);
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    PagerAdapter localPagerAdapter = super.getAdapter();
    if (localPagerAdapter != null) {
      localPagerAdapter.unregisterDataSetObserver(this.c);
    }
    super.setAdapter(paramPagerAdapter);
    if (paramPagerAdapter != null)
    {
      paramPagerAdapter.registerDataSetObserver(this.c);
      this.c.onChanged();
    }
  }
  
  protected void setAllEmptyViewVisibility(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
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
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    throw new RuntimeException("please use addOnPageChangeListener instead");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.EmptySupportViewPager
 * JD-Core Version:    0.7.0.1
 */