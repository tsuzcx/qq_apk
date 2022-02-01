package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class ContactsViewPager
  extends ViewPager
{
  private int jdField_a_of_type_Int;
  private HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = null;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
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
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView == null))
    {
      this.jdField_b_of_type_Boolean = true;
      localObject = getParent();
      while ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView == null)) {
        if ((localObject instanceof HeaderScrollView)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = ((HeaderScrollView)localObject);
        } else if ((localObject instanceof View)) {
          localObject = ((View)localObject).getParent();
        } else {
          localObject = null;
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
    if (localObject != null) {
      return ((HeaderScrollView)localObject).jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool1 = false;
    if (i == 0)
    {
      this.jdField_a_of_type_Int = ((int)(paramMotionEvent.getX() + 0.5F));
      this.jdField_b_of_type_Int = ((int)(paramMotionEvent.getY() + 0.5F));
      this.jdField_a_of_type_Boolean = true;
      this.c = false;
      FrameHelperActivity.b(false);
    }
    else
    {
      if (i == 2)
      {
        j = (int)(paramMotionEvent.getX() + 0.5F);
        i = (int)(paramMotionEvent.getY() + 0.5F);
        int k = Math.abs(j - this.jdField_a_of_type_Int);
        i = Math.abs(i - this.jdField_b_of_type_Int);
        int m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if ((this.jdField_a_of_type_Boolean) && (k > m))
        {
          if ((k * 0.5F > i) && (this.jdField_a_of_type_Int > (int)(ScreenUtil.SCREEN_WIDTH * 0.1F))) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0) {
            FrameHelperActivity.b(true);
          }
          this.jdField_a_of_type_Boolean = false;
        }
        else
        {
          i = 0;
        }
        if (a())
        {
          this.c = true;
          return false;
        }
        j = i;
        if (!this.c) {
          break label237;
        }
        j = i;
        if (k <= m * 3) {
          break label237;
        }
        return false;
      }
      if ((i == 1) || (i == 3))
      {
        FrameHelperActivity.b(true);
        this.jdField_a_of_type_Boolean = false;
        this.c = false;
      }
    }
    int j = 0;
    label237:
    if (j == 0) {}
    try
    {
      boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      FrameHelperActivity.b(false);
    }
    else if ((i == 1) || (i == 3))
    {
      FrameHelperActivity.b(true);
      this.jdField_a_of_type_Boolean = false;
      this.c = false;
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager
 * JD-Core Version:    0.7.0.1
 */