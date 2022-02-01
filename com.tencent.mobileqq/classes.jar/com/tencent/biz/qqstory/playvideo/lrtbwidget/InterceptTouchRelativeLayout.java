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
  private int jdField_a_of_type_Int = 0;
  IgnoreTouchXViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager;
  InterceptTouchRelativeLayout.FakeViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInterceptTouchRelativeLayout$FakeViewPager;
  private PageTransformerWrapper jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPageTransformerWrapper;
  boolean jdField_a_of_type_Boolean = false;
  private PageTransformerWrapper jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPageTransformerWrapper;
  boolean jdField_b_of_type_Boolean = false;
  
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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInterceptTouchRelativeLayout$FakeViewPager = new InterceptTouchRelativeLayout.FakeViewPager(paramContext, "Fake_Pager");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPageTransformerWrapper = new PageTransformerWrapper(new ThreeDTransformer(true, true));
    this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPageTransformerWrapper = new PageTransformerWrapper(new VerticalTransformer());
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
      int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInterceptTouchRelativeLayout$FakeViewPager.a(paramMotionEvent);
      int m = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a();
      boolean bool1;
      if (m != 0)
      {
        int n = this.jdField_a_of_type_Int;
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
            bool1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a(paramMotionEvent);
            paramMotionEvent.recycle();
            SLog.a("Q.qqstory.playernew.InterceptTouch", "delivering directly DELIVERING_AS_VERTICAL, scrollState = %d, handled = %s", Integer.valueOf(m), Boolean.valueOf(bool1));
            return true;
          }
        }
        SLog.a("Q.qqstory.playernew.InterceptTouch", "delivering directly DELIVERING_AS_HORIZONTAL, scrollState = %d, handled = %s", Integer.valueOf(m), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a(paramMotionEvent)));
        return true;
      }
      label148:
      Object localObject = (StoryPlayerGroupAdapter)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a();
      if (localObject == null) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      localObject = ((StoryPlayerGroupAdapter)localObject).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.c());
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      if (localObject != null)
      {
        if (((StoryPlayerGroupHolder)localObject).b == ((StoryPlayerGroupHolder)localObject).a.size() - 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.jdField_a_of_type_Boolean = bool1;
        if (((StoryPlayerGroupHolder)localObject).b == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.jdField_b_of_type_Boolean = bool1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveDirection = ");
      ((StringBuilder)localObject).append(i);
      Log.v("Q.qqstory.playernew.InterceptTouch", ((StringBuilder)localObject).toString());
      if ((i == 2) || (i == 4))
      {
        m = this.jdField_a_of_type_Int;
        if ((m == 0) || (m == 2) || (m == 4)) {}
      }
      else
      {
        if (((i == 1) || (i == 3)) && ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)))
        {
          j = this.jdField_a_of_type_Int;
          if ((j == 0) || (j == 1) || (j == 3)) {}
        }
        else
        {
          this.jdField_a_of_type_Int = 0;
          bool1 = bool2;
          break label742;
        }
        j = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.c();
        k = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a().getCount();
        if (((i == 1) && (j < k - 1) && (this.jdField_a_of_type_Boolean)) || ((i == 3) && (j > 0) && (this.jdField_b_of_type_Boolean)))
        {
          if (this.jdField_a_of_type_Int == 0)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.setPageTransformer(true, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPageTransformerWrapper);
            localObject = MotionEvent.obtain(InterceptTouchRelativeLayout.FakeViewPager.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInterceptTouchRelativeLayout$FakeViewPager));
            ((MotionEvent)localObject).setLocation(paramMotionEvent.getX(), paramMotionEvent.getY());
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a((MotionEvent)localObject);
            ((MotionEvent)localObject).recycle();
          }
          if (i == 1) {
            localObject = "Left";
          } else {
            localObject = "Right";
          }
          SLog.a("Q.qqstory.playernew.InterceptTouch", "Move direction = %s, Event = %s", localObject, paramMotionEvent);
          this.jdField_a_of_type_Int = i;
          bool1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a(paramMotionEvent);
          break label742;
        }
        this.jdField_a_of_type_Int = 0;
        bool1 = bool2;
        break label742;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.c();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a().getCount();
      if ((i != 2) && (i != 4))
      {
        this.jdField_a_of_type_Int = 0;
        bool1 = bool2;
      }
      else
      {
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.setPageTransformer(true, this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPageTransformerWrapper);
          localObject = MotionEvent.obtain(InterceptTouchRelativeLayout.FakeViewPager.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInterceptTouchRelativeLayout$FakeViewPager));
          ((MotionEvent)localObject).setLocation(paramMotionEvent.getX(), paramMotionEvent.getY());
          ((MotionEvent)localObject).setSource(0);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a(a((MotionEvent)localObject, j, k));
          ((MotionEvent)localObject).recycle();
        }
        if (i == 2) {
          localObject = "UP";
        } else {
          localObject = "DOWN";
        }
        SLog.a("Q.qqstory.playernew.InterceptTouch", "Move direction = %s, Event = %s", localObject, paramMotionEvent);
        this.jdField_a_of_type_Int = i;
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setSource(0);
        bool1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a(a((MotionEvent)localObject, j, k));
        ((MotionEvent)localObject).recycle();
      }
      label742:
      SLog.a("Q.qqstory.playernew.InterceptTouch", "delivering = %d, handled = %s", Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(bool1));
      if (this.jdField_a_of_type_Int != 0) {
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
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager = ((IgnoreTouchXViewPager)localObject);
        break;
      }
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager != null) {
      return;
    }
    Object localObject = new IllegalStateException("should add XViewPager as a child view");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.InterceptTouchRelativeLayout
 * JD-Core Version:    0.7.0.1
 */