package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import rhu;
import rhv;

public class ViewPagerCompat
  extends ViewPager
{
  private List<ViewPager.OnPageChangeListener> jdField_a_of_type_JavaUtilList;
  private rhv jdField_a_of_type_Rhv;
  private boolean jdField_a_of_type_Boolean = true;
  private List<rhu> b;
  
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
    this.jdField_a_of_type_Rhv = new rhv(this, null);
    super.setOnPageChangeListener(this.jdField_a_of_type_Rhv);
  }
  
  public void a(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramOnPageChangeListener);
  }
  
  public void a(rhu paramrhu)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramrhu);
  }
  
  public void b(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnPageChangeListener);
    }
  }
  
  public void b(rhu paramrhu)
  {
    if (this.b != null) {
      this.b.remove(paramrhu);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
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
    if (this.jdField_a_of_type_Boolean) {
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
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    PagerAdapter localPagerAdapter = getAdapter();
    super.setAdapter(paramPagerAdapter);
    if ((this.b != null) && (!this.b.isEmpty()))
    {
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        ((rhu)this.b.get(i)).a(this, localPagerAdapter, paramPagerAdapter);
        i += 1;
      }
    }
  }
  
  @Deprecated
  public final void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    QLog.e("ViewPagerCompat", 2, "ViewPagerCompat#setOnPageChangeListener had been deprecated !", new IllegalAccessException("call addOnPageChangeListener instead !"));
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat
 * JD-Core Version:    0.7.0.1
 */