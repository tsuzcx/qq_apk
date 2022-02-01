package com.tencent.biz.qqcircle.richframework.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerCompat
  extends ViewPager
{
  private List<ViewPager.OnPageChangeListener> a;
  private List<ViewPagerCompat.OnAdapterChangeListener> b;
  private ViewPagerCompat.PageChangeListenerImpl c;
  private boolean d = true;
  
  public ViewPagerCompat(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ViewPagerCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.c = new ViewPagerCompat.PageChangeListenerImpl(this, null);
    super.setOnPageChangeListener(this.c);
  }
  
  public void a(ViewPagerCompat.OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramOnAdapterChangeListener);
  }
  
  public void addOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(paramOnPageChangeListener);
  }
  
  public void b(ViewPagerCompat.OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    List localList = this.b;
    if (localList != null) {
      localList.remove(paramOnAdapterChangeListener);
    }
  }
  
  public void clearOnPageChangeListeners()
  {
    List localList = this.a;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public boolean getScrollable()
  {
    return this.d;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d) {
      try
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d) {
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
    }
    return false;
  }
  
  public void removeOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    List localList = this.a;
    if (localList != null) {
      localList.remove(paramOnPageChangeListener);
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    PagerAdapter localPagerAdapter = getAdapter();
    super.setAdapter(paramPagerAdapter);
    List localList = this.b;
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      int j = this.b.size();
      while (i < j)
      {
        ((ViewPagerCompat.OnAdapterChangeListener)this.b.get(i)).a(this, localPagerAdapter, paramPagerAdapter);
        i += 1;
      }
    }
  }
  
  @Deprecated
  public final void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener) {}
  
  public void setScrollable(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat
 * JD-Core Version:    0.7.0.1
 */