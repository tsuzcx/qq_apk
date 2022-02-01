package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ListAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper.OnLoadMoreListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnItemScrollEventListener;
import com.tencent.widget.TraceUtils;

public class StoryHomeHorizontalListView
  extends HorizontalListView
{
  private float a;
  private float b;
  private boolean c;
  private boolean d;
  public int e = 5;
  protected int f;
  protected int g;
  private StoryHomeHorizontalListView.OnOverScrollRightListener h;
  private StoryHomeHorizontalListView.OnScrollChangeListener i;
  private HorizontalListView.OnItemScrollEventListener j;
  private boolean k;
  private LoadingMoreHelper.OnLoadMoreListener l;
  private boolean m;
  
  public StoryHomeHorizontalListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StoryHomeHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.f = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.g = DisplayUtil.a(paramContext, 147.0F);
    super.setOnItemScollEventListener(new StoryHomeHorizontalListView.1(this));
    setOverScrollMode(1);
  }
  
  public void a()
  {
    if (!this.m) {
      return;
    }
    if (this.k) {
      return;
    }
    int n = getLastVisiblePosition();
    int i1 = getAdapter().getCount();
    SLog.a("HorizontalListView", "on item scroll last:%d, count:%d", Integer.valueOf(n), Integer.valueOf(i1));
    if (i1 - n < this.e)
    {
      LoadingMoreHelper.OnLoadMoreListener localOnLoadMoreListener = this.l;
      if ((localOnLoadMoreListener != null) && (localOnLoadMoreListener.a(false))) {
        this.k = true;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    StringBuilder localStringBuilder;
    if (n == 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("StoryHomeHorizontalListView dispatchTouchEvent:ACTION_DOWN. mIsPress=");
        localStringBuilder.append(this.c);
        QLog.d("Q.qqstory.friendStory", 2, localStringBuilder.toString());
      }
      this.a = f1;
      this.b = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.c = true;
      this.d = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (n == 2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("StoryHomeHorizontalListView dispatchTouchEvent:ACTION_MOVE. mIsPress=");
        localStringBuilder.append(this.c);
        QLog.d("Q.qqstory.friendStory", 2, localStringBuilder.toString());
      }
      float f2 = this.a;
      f3 -= this.b;
      if ((this.c) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > DisplayUtil.a(getContext(), 5.0F))) {
        getParent().requestDisallowInterceptTouchEvent(false);
      } else {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
    else if ((n == 3) || (n == 1))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("StoryHomeHorizontalListView dispatchTouchEvent:ACTION_CANCEL or UP. action=");
        localStringBuilder.append(n);
        localStringBuilder.append(" mIsPress=");
        localStringBuilder.append(this.c);
        QLog.d("Q.qqstory.friendStory", 2, localStringBuilder.toString());
      }
      this.c = false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int getDividerWidth()
  {
    return this.mDividerWidth;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TraceUtils.traceBegin("StoryHorizontal.onLayout");
    int n = this.mCurrentX;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.i != null) && (n != this.mCurrentX))
    {
      this.i.a(n, this.mCurrentX);
      SLog.a("Q.qqstory.friendStory", "onLayout() %d -> %d", Integer.valueOf(n), Integer.valueOf(this.mCurrentX));
    }
    TraceUtils.traceEnd();
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    StoryHomeHorizontalListView.OnOverScrollRightListener localOnOverScrollRightListener;
    if ((this.d) && (paramInt3 > 0) && (paramInt3 > DisplayUtil.a(getContext(), 50.0F)))
    {
      this.d = false;
      localOnOverScrollRightListener = this.h;
      if ((localOnOverScrollRightListener != null) && (this.c)) {
        localOnOverScrollRightListener.e();
      }
    }
    else if ((this.d) && (paramInt3 < 0) && (paramInt3 < -DisplayUtil.a(getContext(), 50.0F)))
    {
      this.d = false;
      localOnOverScrollRightListener = this.h;
      if ((localOnOverScrollRightListener != null) && (this.c)) {
        localOnOverScrollRightListener.by_();
      }
    }
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  public void setDataCount(int paramInt)
  {
    if (paramInt >= this.f / this.g)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreComplete(boolean paramBoolean)
  {
    this.m = paramBoolean;
    this.k = false;
  }
  
  public void setOnItemScollEventListener(HorizontalListView.OnItemScrollEventListener paramOnItemScrollEventListener)
  {
    this.j = paramOnItemScrollEventListener;
  }
  
  public void setOnLoadMoreListener(LoadingMoreHelper.OnLoadMoreListener paramOnLoadMoreListener)
  {
    this.l = paramOnLoadMoreListener;
  }
  
  public void setOnOverScrollRightListener(StoryHomeHorizontalListView.OnOverScrollRightListener paramOnOverScrollRightListener)
  {
    this.h = paramOnOverScrollRightListener;
  }
  
  public void setOnScrollChangeListener(StoryHomeHorizontalListView.OnScrollChangeListener paramOnScrollChangeListener)
  {
    this.i = paramOnScrollChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView
 * JD-Core Version:    0.7.0.1
 */