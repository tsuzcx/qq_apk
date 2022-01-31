package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.List;
import vof;
import vok;
import wsv;

public class InterceptTouchRelativeLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  IgnoreTouchXViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager;
  vof jdField_a_of_type_Vof;
  private vok jdField_a_of_type_Vok;
  boolean jdField_a_of_type_Boolean = false;
  private vok jdField_b_of_type_Vok;
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
    this.jdField_a_of_type_Vof = new vof(paramContext, "Fake_Pager");
    this.jdField_a_of_type_Vok = new vok(new ThreeDTransformer(true, true));
    this.jdField_b_of_type_Vok = new vok(new VerticalTransformer());
  }
  
  public static MotionEvent a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    paramMotionEvent.setLocation(paramMotionEvent.getY() / paramFloat2 * paramFloat1, paramMotionEvent.getX() / paramFloat1 * paramFloat2);
    return paramMotionEvent;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    int j = getWidth();
    int k = getHeight();
    int i;
    int m;
    try
    {
      i = this.jdField_a_of_type_Vof.a(paramMotionEvent);
      m = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a();
      if (m != 0) {}
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        localObject = (StoryPlayerGroupAdapter)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a();
        if (localObject != null) {
          break label184;
        }
        bool1 = super.dispatchTouchEvent(paramMotionEvent);
        return bool1;
      }
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      return false;
    }
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setSource(0);
    a(paramMotionEvent, j, k);
    boolean bool1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a(paramMotionEvent);
    paramMotionEvent.recycle();
    wsv.a("Q.qqstory.playernew.InterceptTouch", "delivering directly DELIVERING_AS_VERTICAL, scrollState = %d, handled = %s", Integer.valueOf(m), Boolean.valueOf(bool1));
    return true;
    wsv.a("Q.qqstory.playernew.InterceptTouch", "delivering directly DELIVERING_AS_HORIZONTAL, scrollState = %d, handled = %s", Integer.valueOf(m), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a(paramMotionEvent)));
    return true;
    label184:
    Object localObject = ((StoryPlayerGroupAdapter)localObject).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.c());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (localObject != null)
    {
      if (((StoryPlayerGroupHolder)localObject).b == ((StoryPlayerGroupHolder)localObject).a.size() - 1)
      {
        bool1 = true;
        label236:
        this.jdField_a_of_type_Boolean = bool1;
        if (((StoryPlayerGroupHolder)localObject).b != 0) {
          break label521;
        }
        bool1 = true;
        label253:
        this.jdField_b_of_type_Boolean = bool1;
      }
    }
    else
    {
      Log.v("Q.qqstory.playernew.InterceptTouch", "moveDirection = " + i);
      if (((i != 2) && (i != 4)) || ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 4))) {
        break label546;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.c();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a().getCount();
      if ((i != 2) && (i != 4)) {
        break label534;
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.setPageTransformer(true, this.jdField_b_of_type_Vok);
        localObject = MotionEvent.obtain(vof.a(this.jdField_a_of_type_Vof));
        ((MotionEvent)localObject).setLocation(paramMotionEvent.getX(), paramMotionEvent.getY());
        ((MotionEvent)localObject).setSource(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a(a((MotionEvent)localObject, j, k));
        ((MotionEvent)localObject).recycle();
      }
      if (i != 2) {
        break label527;
      }
      localObject = "UP";
      label428:
      wsv.a("Q.qqstory.playernew.InterceptTouch", "Move direction = %s, Event = %s", localObject, paramMotionEvent);
      this.jdField_a_of_type_Int = i;
      localObject = MotionEvent.obtain(paramMotionEvent);
      ((MotionEvent)localObject).setSource(0);
      bool1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a(a((MotionEvent)localObject, j, k));
      ((MotionEvent)localObject).recycle();
    }
    for (;;)
    {
      wsv.a("Q.qqstory.playernew.InterceptTouch", "delivering = %d, handled = %s", Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(bool1));
      bool1 = bool2;
      if (this.jdField_a_of_type_Int != 0) {
        break;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
      bool1 = false;
      break label236;
      label521:
      bool1 = false;
      break label253;
      label527:
      localObject = "DOWN";
      break label428;
      label534:
      this.jdField_a_of_type_Int = 0;
      bool1 = bool3;
      continue;
      label546:
      if (((i == 1) || (i == 3)) && ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3)))
      {
        j = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.c();
        k = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a().getCount();
        if (((i == 1) && (j < k - 1) && (this.jdField_a_of_type_Boolean)) || ((i == 3) && (j > 0) && (this.jdField_b_of_type_Boolean)))
        {
          if (this.jdField_a_of_type_Int == 0)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.setPageTransformer(true, this.jdField_a_of_type_Vok);
            localObject = MotionEvent.obtain(vof.a(this.jdField_a_of_type_Vof));
            ((MotionEvent)localObject).setLocation(paramMotionEvent.getX(), paramMotionEvent.getY());
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a((MotionEvent)localObject);
            ((MotionEvent)localObject).recycle();
          }
          if (i == 1) {}
          for (localObject = "Left";; localObject = "Right")
          {
            wsv.a("Q.qqstory.playernew.InterceptTouch", "Move direction = %s, Event = %s", localObject, paramMotionEvent);
            this.jdField_a_of_type_Int = i;
            bool1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.a(paramMotionEvent);
            break;
          }
        }
        this.jdField_a_of_type_Int = 0;
        bool1 = bool3;
      }
      else
      {
        this.jdField_a_of_type_Int = 0;
        bool1 = bool3;
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i = 0;
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if ((localView instanceof IgnoreTouchXViewPager)) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager = ((IgnoreTouchXViewPager)localView);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager != null) {
          break;
        }
        throw new IllegalStateException("should add XViewPager as a child view");
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.InterceptTouchRelativeLayout
 * JD-Core Version:    0.7.0.1
 */