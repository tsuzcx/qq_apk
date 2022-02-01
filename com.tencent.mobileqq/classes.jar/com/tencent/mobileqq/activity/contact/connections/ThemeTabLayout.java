package com.tencent.mobileqq.activity.contact.connections;

import ajiq;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import bhtq;
import java.util.ArrayList;
import szu;

public class ThemeTabLayout
  extends FrameLayout
{
  public float a;
  private ConnectionsTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout;
  private TabThemeMaskView jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabThemeMaskView;
  public float b;
  public float c;
  public float d;
  
  public ThemeTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ThemeTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ThemeTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.getScrollX();
    }
    return 0.0F;
  }
  
  public void a()
  {
    Object localObject = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561367, this, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout = ((ConnectionsTabLayout)((RelativeLayout)localObject).findViewById(2131364973));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = bhtq.a(10.0F);
    addView((View)localObject, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabThemeMaskView = new TabThemeMaskView(getContext());
    localObject = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabThemeMaskView, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.a(paramInt);
  }
  
  public void a(ArrayList<ajiq> paramArrayList, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabThemeMaskView == null)) {}
    while ((paramArrayList == null) || (paramInt < 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.a(paramArrayList, paramInt);
  }
  
  public void a(szu paramszu)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.b(paramszu);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.a();
  }
  
  public void b(ArrayList<ajiq> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.b(paramArrayList, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.b = 0.0F;
      this.jdField_a_of_type_Float = 0.0F;
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.jdField_a_of_type_Float += Math.abs(f1 - this.c);
      this.b += Math.abs(f2 - this.d);
      this.c = f1;
      this.d = f2;
      if (this.jdField_a_of_type_Float <= this.b) {
        getParent().requestDisallowInterceptTouchEvent(false);
      } else {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
  }
  
  public void setOnTabSelectedListener(szu paramszu)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabThemeMaskView == null)) {}
    while (paramszu == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.a(paramszu);
  }
  
  public void setScrollPosition(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.setScrollX((int)paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout
 * JD-Core Version:    0.7.0.1
 */