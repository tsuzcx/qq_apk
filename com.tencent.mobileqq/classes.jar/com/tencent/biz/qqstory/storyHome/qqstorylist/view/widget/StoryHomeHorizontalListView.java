package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ListAdapter;
import baxn;
import bfsm;
import bfwu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import vdo;
import vdp;
import vdq;
import ved;
import wdd;

public class StoryHomeHorizontalListView
  extends HorizontalListView
{
  private float jdField_a_of_type_Float;
  public int a;
  private bfsm jdField_a_of_type_Bfsm;
  private vdp jdField_a_of_type_Vdp;
  private vdq jdField_a_of_type_Vdq;
  private wdd jdField_a_of_type_Wdd;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  protected int b;
  private boolean jdField_b_of_type_Boolean;
  protected int c;
  private boolean c;
  private boolean d;
  
  public StoryHomeHorizontalListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 5;
    a(paramContext);
  }
  
  public StoryHomeHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 5;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_b_of_type_Int = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = baxn.a(paramContext, 147.0F);
    super.setOnItemScollEventListener(new vdo(this));
    setOverScrollMode(1);
  }
  
  public void a()
  {
    if (!this.d) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_Boolean);
      i = getLastVisiblePosition();
      j = getAdapter().getCount();
      ved.a("HorizontalListView", "on item scroll last:%d, count:%d", Integer.valueOf(i), Integer.valueOf(j));
    } while ((j - i >= this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Wdd == null) || (!this.jdField_a_of_type_Wdd.a(false)));
    this.jdField_c_of_type_Boolean = true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.friendStory", 2, "StoryHomeHorizontalListView dispatchTouchEvent:ACTION_DOWN. mIsPress=" + this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.friendStory", 2, "StoryHomeHorizontalListView dispatchTouchEvent:ACTION_MOVE. mIsPress=" + this.jdField_a_of_type_Boolean);
      }
      float f2 = this.jdField_a_of_type_Float;
      f3 -= this.jdField_b_of_type_Float;
      if ((this.jdField_a_of_type_Boolean) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > baxn.a(getContext(), 5.0F))) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      if ((i == 3) || (i == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.friendStory", 2, "StoryHomeHorizontalListView dispatchTouchEvent:ACTION_CANCEL or UP. action=" + i + " mIsPress=" + this.jdField_a_of_type_Boolean);
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bfwu.a("StoryHorizontal.onLayout");
    int i = this.mCurrentX;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_Vdq != null) && (i != this.mCurrentX))
    {
      this.jdField_a_of_type_Vdq.a(i, this.mCurrentX);
      ved.a("Q.qqstory.friendStory", "onLayout() %d -> %d", Integer.valueOf(i), Integer.valueOf(this.mCurrentX));
    }
    bfwu.a();
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramInt3 > 0) && (paramInt3 > baxn.a(getContext(), 50.0F)))
    {
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Vdp != null) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Vdp.P_();
      }
    }
    for (;;)
    {
      return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      if ((this.jdField_b_of_type_Boolean) && (paramInt3 < 0) && (paramInt3 < -baxn.a(getContext(), 50.0F)))
      {
        this.jdField_b_of_type_Boolean = false;
        if ((this.jdField_a_of_type_Vdp != null) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_Vdp.Q_();
        }
      }
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  public void setDataCount(int paramInt)
  {
    if (paramInt >= this.jdField_b_of_type_Int / this.jdField_c_of_type_Int)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreComplete(boolean paramBoolean)
  {
    this.d = paramBoolean;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void setOnItemScollEventListener(bfsm parambfsm)
  {
    this.jdField_a_of_type_Bfsm = parambfsm;
  }
  
  public void setOnLoadMoreListener(wdd paramwdd)
  {
    this.jdField_a_of_type_Wdd = paramwdd;
  }
  
  public void setOnOverScrollRightListener(vdp paramvdp)
  {
    this.jdField_a_of_type_Vdp = paramvdp;
  }
  
  public void setOnScrollChangeListener(vdq paramvdq)
  {
    this.jdField_a_of_type_Vdq = paramvdq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView
 * JD-Core Version:    0.7.0.1
 */