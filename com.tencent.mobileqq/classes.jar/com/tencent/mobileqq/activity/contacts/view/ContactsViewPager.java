package com.tencent.mobileqq.activity.contacts.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import axlk;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class ContactsViewPager
  extends ViewPager
{
  private int jdField_a_of_type_Int;
  private HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public ContactsViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactsViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean a()
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView == null))
    {
      this.jdField_b_of_type_Boolean = true;
      ViewParent localViewParent = getParent();
      while ((localViewParent != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView == null)) {
        if ((localViewParent instanceof HeaderScrollView)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView = ((HeaderScrollView)localViewParent);
        } else if ((localViewParent instanceof View)) {
          localViewParent = ((View)localViewParent).getParent();
        } else {
          localViewParent = null;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.jdField_a_of_type_Int = ((int)(paramMotionEvent.getX() + 0.5F));
      this.jdField_b_of_type_Int = ((int)(paramMotionEvent.getY() + 0.5F));
      this.jdField_a_of_type_Boolean = true;
      this.c = false;
      FrameHelperActivity.c(false);
      i = 0;
      if (i != 0) {}
    }
    int j;
    try
    {
      boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramMotionEvent)
    {
      int k;
      int m;
      label173:
      return false;
    }
    if (i == 2)
    {
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      k = Math.abs(j - this.jdField_a_of_type_Int);
      i = Math.abs(i - this.jdField_b_of_type_Int);
      m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      if ((!this.jdField_a_of_type_Boolean) || (k <= m)) {
        break label259;
      }
      if ((k * 0.5F <= i) || (this.jdField_a_of_type_Int <= (int)(axlk.jdField_a_of_type_Int * 0.1F))) {
        break label254;
      }
      j = 1;
      if (j == 0) {
        FrameHelperActivity.c(true);
      }
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      if (a())
      {
        this.c = true;
        return false;
      }
      i = j;
      if (!this.c) {
        break;
      }
      i = j;
      if (k <= m * 3) {
        break;
      }
      return false;
      if ((i == 1) || (i == 3))
      {
        FrameHelperActivity.c(true);
        this.jdField_a_of_type_Boolean = false;
        this.c = false;
      }
      i = 0;
      break;
      label254:
      j = 0;
      break label173;
      label259:
      j = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      FrameHelperActivity.c(false);
    }
    for (;;)
    {
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent) {}
      if ((i == 1) || (i == 3))
      {
        FrameHelperActivity.c(true);
        this.jdField_a_of_type_Boolean = false;
        this.c = false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.ContactsViewPager
 * JD-Core Version:    0.7.0.1
 */