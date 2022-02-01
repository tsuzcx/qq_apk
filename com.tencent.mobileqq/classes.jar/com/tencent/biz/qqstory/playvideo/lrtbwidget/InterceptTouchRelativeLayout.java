package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class InterceptTouchRelativeLayout
  extends RelativeLayout
{
  IgnoreTouchXViewPager a;
  boolean b = false;
  boolean c = false;
  InterceptTouchRelativeLayout.FakeViewPager d;
  private int e = 0;
  private PageTransformerWrapper f;
  private PageTransformerWrapper g;
  
  public InterceptTouchRelativeLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public InterceptTouchRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InterceptTouchRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = new InterceptTouchRelativeLayout.FakeViewPager(paramContext, "Fake_Pager");
    this.f = new PageTransformerWrapper(new ThreeDTransformer(true, true));
    this.g = new PageTransformerWrapper(new VerticalTransformer());
  }
  
  public static MotionEvent a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    paramMotionEvent.setLocation(paramMotionEvent.getY() / paramFloat2 * paramFloat1, paramMotionEvent.getX() / paramFloat1 * paramFloat2);
    return paramMotionEvent;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = getWidth();
    int k = getHeight();
    boolean bool2 = false;
    try
    {
      int i = this.d.a(paramMotionEvent);
      int m = this.a.getScrollState();
      boolean bool1;
      if (m != 0)
      {
        int n = this.e;
        if (n != 1) {
          if (n != 2)
          {
            if (n != 3) {
              if (n != 4) {
                break label148;
              }
            }
          }
          else
          {
            paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
            paramMotionEvent.setSource(0);
            a(paramMotionEvent, j, k);
            bool1 = this.a.a(paramMotionEvent);
            paramMotionEvent.recycle();
            SLog.a("Q.qqstory.playernew.InterceptTouch", "delivering directly DELIVERING_AS_VERTICAL, scrollState = %d, handled = %s", Integer.valueOf(m), Boolean.valueOf(bool1));
            return true;
          }
        }
        SLog.a("Q.qqstory.playernew.InterceptTouch", "delivering directly DELIVERING_AS_HORIZONTAL, scrollState = %d, handled = %s", Integer.valueOf(m), Boolean.valueOf(this.a.a(paramMotionEvent)));
        return true;
      }
      label148:
      Object localObject = (StoryPlayerGroupAdapter)this.a.getAdapter();
      if (localObject == null) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      localObject = ((StoryPlayerGroupAdapter)localObject).a(this.a.getCurrentItem());
      this.b = false;
      this.c = false;
      if (localObject != null)
      {
        if (((StoryPlayerGroupHolder)localObject).l == ((StoryPlayerGroupHolder)localObject).f.size() - 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.b = bool1;
        if (((StoryPlayerGroupHolder)localObject).l == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.c = bool1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveDirection = ");
      ((StringBuilder)localObject).append(i);
      Log.v("Q.qqstory.playernew.InterceptTouch", ((StringBuilder)localObject).toString());
      if ((i == 2) || (i == 4))
      {
        m = this.e;
        if ((m == 0) || (m == 2) || (m == 4)) {}
      }
      else
      {
        if (((i == 1) || (i == 3)) && ((this.b) || (this.c)))
        {
          j = this.e;
          if ((j == 0) || (j == 1) || (j == 3)) {}
        }
        else
        {
          this.e = 0;
          bool1 = bool2;
          break label742;
        }
        j = this.a.getCurrentItem();
        k = this.a.getAdapter().getCount();
        if (((i == 1) && (j < k - 1) && (this.b)) || ((i == 3) && (j > 0) && (this.c)))
        {
          if (this.e == 0)
          {
            this.a.setPageTransformer(true, this.f);
            localObject = MotionEvent.obtain(InterceptTouchRelativeLayout.FakeViewPager.a(this.d));
            ((MotionEvent)localObject).setLocation(paramMotionEvent.getX(), paramMotionEvent.getY());
            this.a.a((MotionEvent)localObject);
            ((MotionEvent)localObject).recycle();
          }
          if (i == 1) {
            localObject = "Left";
          } else {
            localObject = "Right";
          }
          SLog.a("Q.qqstory.playernew.InterceptTouch", "Move direction = %s, Event = %s", localObject, paramMotionEvent);
          this.e = i;
          bool1 = this.a.a(paramMotionEvent);
          break label742;
        }
        this.e = 0;
        bool1 = bool2;
        break label742;
      }
      this.a.getCurrentItem();
      this.a.getAdapter().getCount();
      if ((i != 2) && (i != 4))
      {
        this.e = 0;
        bool1 = bool2;
      }
      else
      {
        if (this.e == 0)
        {
          this.a.setPageTransformer(true, this.g);
          localObject = MotionEvent.obtain(InterceptTouchRelativeLayout.FakeViewPager.a(this.d));
          ((MotionEvent)localObject).setLocation(paramMotionEvent.getX(), paramMotionEvent.getY());
          ((MotionEvent)localObject).setSource(0);
          this.a.a(a((MotionEvent)localObject, j, k));
          ((MotionEvent)localObject).recycle();
        }
        if (i == 2) {
          localObject = "UP";
        } else {
          localObject = "DOWN";
        }
        SLog.a("Q.qqstory.playernew.InterceptTouch", "Move direction = %s, Event = %s", localObject, paramMotionEvent);
        this.e = i;
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setSource(0);
        bool1 = this.a.a(a((MotionEvent)localObject, j, k));
        ((MotionEvent)localObject).recycle();
      }
      label742:
      SLog.a("Q.qqstory.playernew.InterceptTouch", "delivering = %d, handled = %s", Integer.valueOf(this.e), Boolean.valueOf(bool1));
      if (this.e != 0) {
        return true;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    catch (IllegalArgumentException paramMotionEvent) {}
    return false;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i = 0;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      if ((localObject instanceof IgnoreTouchXViewPager))
      {
        this.a = ((IgnoreTouchXViewPager)localObject);
        break;
      }
      i += 1;
    }
    if (this.a != null) {
      return;
    }
    Object localObject = new IllegalStateException("should add XViewPager as a child view");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.InterceptTouchRelativeLayout
 * JD-Core Version:    0.7.0.1
 */