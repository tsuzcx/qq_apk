package com.tencent.mobileqq.activity.contact.newfriend.connections;

import afly;
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
import bbkx;
import java.util.ArrayList;
import rtz;

public class ThemeTabLayout
  extends FrameLayout
{
  public float a;
  private ConnectionsTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout;
  private TabThemeMaskView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTabThemeMaskView;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout.getScrollX();
    }
    return 0.0F;
  }
  
  public void a()
  {
    Object localObject = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560918, this, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout = ((ConnectionsTabLayout)((RelativeLayout)localObject).findViewById(2131364626));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = bbkx.a(10.0F);
    addView((View)localObject, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTabThemeMaskView = new TabThemeMaskView(getContext());
    localObject = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTabThemeMaskView, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout.a(paramInt);
  }
  
  public void a(ArrayList<afly> paramArrayList, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTabThemeMaskView == null)) {}
    while ((paramArrayList == null) || (paramInt < 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout.a(paramArrayList, paramInt);
  }
  
  public void a(rtz paramrtz)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout.b(paramrtz);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout.a();
  }
  
  public void b(ArrayList<afly> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout.b(paramArrayList, paramInt);
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
  
  public void setOnTabSelectedListener(rtz paramrtz)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTabThemeMaskView == null)) {}
    while (paramrtz == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout.a(paramrtz);
  }
  
  public void setScrollPosition(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectionsTabLayout.setScrollX((int)paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.connections.ThemeTabLayout
 * JD-Core Version:    0.7.0.1
 */