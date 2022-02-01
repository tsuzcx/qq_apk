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
  private int a;
  private int b;
  private boolean c;
  private HeaderScrollView d = null;
  private boolean e = false;
  private boolean f = false;
  
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
    if ((!this.e) && (this.d == null))
    {
      this.e = true;
      localObject = getParent();
      while ((localObject != null) && (this.d == null)) {
        if ((localObject instanceof HeaderScrollView)) {
          this.d = ((HeaderScrollView)localObject);
        } else if ((localObject instanceof View)) {
          localObject = ((View)localObject).getParent();
        } else {
          localObject = null;
        }
      }
    }
    Object localObject = this.d;
    if (localObject != null) {
      return ((HeaderScrollView)localObject).a;
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool1 = false;
    if (i == 0)
    {
      this.a = ((int)(paramMotionEvent.getX() + 0.5F));
      this.b = ((int)(paramMotionEvent.getY() + 0.5F));
      this.c = true;
      this.f = false;
      FrameHelperActivity.c(false);
    }
    else
    {
      if (i == 2)
      {
        j = (int)(paramMotionEvent.getX() + 0.5F);
        i = (int)(paramMotionEvent.getY() + 0.5F);
        int k = Math.abs(j - this.a);
        i = Math.abs(i - this.b);
        int m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if ((this.c) && (k > m))
        {
          if ((k * 0.5F > i) && (this.a > (int)(ScreenUtil.SCREEN_WIDTH * 0.1F))) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0) {
            FrameHelperActivity.c(true);
          }
          this.c = false;
        }
        else
        {
          i = 0;
        }
        if (a())
        {
          this.f = true;
          return false;
        }
        j = i;
        if (!this.f) {
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
        FrameHelperActivity.c(true);
        this.c = false;
        this.f = false;
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
      FrameHelperActivity.c(false);
    }
    else if ((i == 1) || (i == 3))
    {
      FrameHelperActivity.c(true);
      this.c = false;
      this.f = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager
 * JD-Core Version:    0.7.0.1
 */