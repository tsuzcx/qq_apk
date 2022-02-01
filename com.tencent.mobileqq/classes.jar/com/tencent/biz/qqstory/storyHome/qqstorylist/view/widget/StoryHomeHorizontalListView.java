package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ListAdapter;
import bhgr;
import blmf;
import blqm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import ytv;
import ytw;
import ytx;
import yuk;
import ztk;

public class StoryHomeHorizontalListView
  extends HorizontalListView
{
  private float jdField_a_of_type_Float;
  public int a;
  private blmf jdField_a_of_type_Blmf;
  private ytw jdField_a_of_type_Ytw;
  private ytx jdField_a_of_type_Ytx;
  private ztk jdField_a_of_type_Ztk;
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
    this.jdField_c_of_type_Int = bhgr.a(paramContext, 147.0F);
    super.setOnItemScollEventListener(new ytv(this));
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
      yuk.a("HorizontalListView", "on item scroll last:%d, count:%d", Integer.valueOf(i), Integer.valueOf(j));
    } while ((j - i >= this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Ztk == null) || (!this.jdField_a_of_type_Ztk.a(false)));
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
      if ((this.jdField_a_of_type_Boolean) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > bhgr.a(getContext(), 5.0F))) {
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
    blqm.a("StoryHorizontal.onLayout");
    int i = this.mCurrentX;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_Ytx != null) && (i != this.mCurrentX))
    {
      this.jdField_a_of_type_Ytx.a(i, this.mCurrentX);
      yuk.a("Q.qqstory.friendStory", "onLayout() %d -> %d", Integer.valueOf(i), Integer.valueOf(this.mCurrentX));
    }
    blqm.a();
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramInt3 > 0) && (paramInt3 > bhgr.a(getContext(), 50.0F)))
    {
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Ytw != null) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Ytw.R_();
      }
    }
    for (;;)
    {
      return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      if ((this.jdField_b_of_type_Boolean) && (paramInt3 < 0) && (paramInt3 < -bhgr.a(getContext(), 50.0F)))
      {
        this.jdField_b_of_type_Boolean = false;
        if ((this.jdField_a_of_type_Ytw != null) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_Ytw.S_();
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
  
  public void setOnItemScollEventListener(blmf paramblmf)
  {
    this.jdField_a_of_type_Blmf = paramblmf;
  }
  
  public void setOnLoadMoreListener(ztk paramztk)
  {
    this.jdField_a_of_type_Ztk = paramztk;
  }
  
  public void setOnOverScrollRightListener(ytw paramytw)
  {
    this.jdField_a_of_type_Ytw = paramytw;
  }
  
  public void setOnScrollChangeListener(ytx paramytx)
  {
    this.jdField_a_of_type_Ytx = paramytx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView
 * JD-Core Version:    0.7.0.1
 */