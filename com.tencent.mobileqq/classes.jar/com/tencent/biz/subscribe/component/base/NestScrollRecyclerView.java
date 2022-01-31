package com.tencent.biz.subscribe.component.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import yij;

public class NestScrollRecyclerView
  extends RecyclerViewCompat
  implements NestedScrollingParent
{
  private static String jdField_a_of_type_JavaLangString = "NestScrollRecyclerView";
  private int jdField_a_of_type_Int;
  private NestedScrollingParentHelper jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper;
  private View jdField_a_of_type_AndroidViewView;
  private RefreshHeaderView jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private int c;
  private int d;
  
  public NestScrollRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    this.d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    if (((paramRecyclerView instanceof NestScrollRecyclerView)) && ((getAdapter() instanceof yij)) && (((yij)getAdapter()).b()) && (((NestScrollRecyclerView)paramRecyclerView).a() == null)) {
      ((NestScrollRecyclerView)paramRecyclerView).a(((yij)getAdapter()).a());
    }
  }
  
  private void a(RefreshHeaderView paramRefreshHeaderView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView = paramRefreshHeaderView;
  }
  
  private boolean a()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    while (this.jdField_b_of_type_AndroidViewView.getTop() <= 0) {
      return false;
    }
    return true;
  }
  
  private boolean a(int paramInt, RecyclerView paramRecyclerView)
  {
    a(paramRecyclerView);
    return ((paramInt > 0) && (a())) || ((paramInt < 0) && (!paramRecyclerView.canScrollVertically(-1)));
  }
  
  public RefreshHeaderView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView;
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    return super.fling(paramInt1, paramInt2);
  }
  
  public int getNestedScrollAxes()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = paramMotionEvent.getAction();
    int j = paramMotionEvent.getActionIndex();
    boolean bool1;
    switch (i)
    {
    case 1: 
    default: 
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    case 0: 
      this.jdField_a_of_type_Int = ((int)(paramMotionEvent.getX() + 0.5F));
      this.jdField_b_of_type_Int = ((int)(paramMotionEvent.getY() + 0.5F));
      this.c = MotionEventCompat.findPointerIndex(paramMotionEvent, j);
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_b_of_type_AndroidViewView = null;
    }
    do
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.jdField_a_of_type_Int;
      i = (int)((i - this.jdField_b_of_type_Int) * 0.6F);
      if (Math.abs(j) > this.d)
      {
        bool1 = bool2;
        if (Math.abs(j) >= Math.abs(i)) {
          break;
        }
      }
      bool1 = bool2;
      if ((this.jdField_a_of_type_AndroidViewView instanceof NestScrollRecyclerView)) {
        break;
      }
    } while ((Math.abs(j) <= this.d) || (Math.abs(i) <= Math.abs(j)));
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    if (((paramView instanceof NestScrollRecyclerView)) && (a((int)paramFloat2, (NestScrollRecyclerView)paramView))) {
      fling((int)paramFloat1, (int)paramFloat2);
    }
    for (boolean bool = true;; bool = false)
    {
      Log.d(jdField_a_of_type_JavaLangString, String.format("----onNestedPreFling---------------- ret:%s, velocityY:%s", new Object[] { Boolean.valueOf(bool), Float.valueOf(paramFloat2) }));
      return bool;
    }
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (((paramView instanceof RecyclerView)) && (a(paramInt2, (RecyclerView)paramView)))
    {
      scrollBy(0, paramInt2);
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d(jdField_a_of_type_JavaLangString, "----父布局onNestedScroll----------------");
  }
  
  @SuppressLint({"NewApi"})
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.jdField_b_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    Log.d(jdField_a_of_type_JavaLangString, "----父布局onStopNestedScroll----------------");
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.onStopNestedScroll(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((getAdapter() instanceof yij)) && (((yij)getAdapter()).b())) {
      ((yij)getAdapter()).a().a(paramMotionEvent);
    }
    if (a() != null) {
      a().a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    super.setAdapter(paramAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.component.base.NestScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */