package com.tencent.biz.richframework.part.block.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import cooperation.qqcircle.utils.ViewUtils;
import yzv;
import yzw;
import yzx;

public class NestScrollRecyclerView
  extends RecyclerViewCompat
  implements NestedScrollingParent
{
  private static String jdField_a_of_type_JavaLangString = "NestScrollRecyclerView";
  private int jdField_a_of_type_Int;
  private NestedScrollingParentHelper jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper;
  private View jdField_a_of_type_AndroidViewView;
  private RefreshHeaderView jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseRefreshHeaderView;
  private yzv jdField_a_of_type_Yzv;
  private yzw jdField_a_of_type_Yzw;
  private boolean jdField_a_of_type_Boolean;
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
    if (((paramRecyclerView instanceof NestScrollRecyclerView)) && ((getAdapter() instanceof yzx)) && (((yzx)getAdapter()).b()) && (((NestScrollRecyclerView)paramRecyclerView).a() == null)) {
      ((NestScrollRecyclerView)paramRecyclerView).a(((yzx)getAdapter()).a());
    }
  }
  
  private void a(MotionEvent paramMotionEvent, View paramView)
  {
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    paramView.getGlobalVisibleRect(localRect2);
    getGlobalVisibleRect(localRect1);
    float f1 = localRect1.left - localRect2.left;
    float f2 = localRect1.top - localRect2.top;
    QLog.d(jdField_a_of_type_JavaLangString, 4, "modifyEventPos offsetX:" + f1 + " offsetY:" + f2);
    paramMotionEvent.offsetLocation(f1, f2);
  }
  
  private void a(RefreshHeaderView paramRefreshHeaderView)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseRefreshHeaderView = paramRefreshHeaderView;
  }
  
  private boolean a(int paramInt, RecyclerView paramRecyclerView)
  {
    a(paramRecyclerView);
    if (((paramInt > 0) && (a(paramRecyclerView))) || ((paramInt < 0) && (!paramRecyclerView.canScrollVertically(-1))))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "parent is consume");
      return true;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "self consume");
    return false;
  }
  
  private boolean a(RecyclerView paramRecyclerView)
  {
    if (((paramRecyclerView instanceof NestScrollRecyclerView)) && (((NestScrollRecyclerView)paramRecyclerView).a() != null)) {
      return ((NestScrollRecyclerView)paramRecyclerView).a().a(paramRecyclerView);
    }
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "isNestViewNotReachTop mNestTargetViewWrapper is null");
      return false;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "isNestViewNotReachTop mNestTargetViewWrapper.getTop()" + this.jdField_b_of_type_AndroidViewView.getTop());
    if (this.jdField_b_of_type_AndroidViewView.getTop() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (((getAdapter() instanceof yzx)) && (((yzx)getAdapter()).b()) && (((yzx)getAdapter()).a() != null)) {
      ((yzx)getAdapter()).a().a(paramMotionEvent);
    }
    if (a() != null) {
      a().a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public RefreshHeaderView a()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseRefreshHeaderView;
  }
  
  public yzv a()
  {
    return this.jdField_a_of_type_Yzv;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Yzw != null) && (this.jdField_a_of_type_AndroidViewView != null) && (!a((RecyclerView)this.jdField_a_of_type_AndroidViewView)) && (ViewUtils.isInViewArea(this.jdField_a_of_type_AndroidViewView, paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) && (this.jdField_a_of_type_Yzw.a(paramMotionEvent, (RecyclerView)this.jdField_a_of_type_AndroidViewView)))
    {
      a(paramMotionEvent, this.jdField_a_of_type_AndroidViewView);
      return this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "velocityX" + paramInt1 + "   velocityY:" + paramInt2);
    return super.fling(paramInt1, paramInt2);
  }
  
  public int getNestedScrollAxes()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onInterceptTouchEvent hashCode" + hashCode());
    int i = paramMotionEvent.getAction();
    int j = paramMotionEvent.getActionIndex();
    switch (i)
    {
    case 1: 
    default: 
      return super.onInterceptTouchEvent(paramMotionEvent);
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
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onInterceptTouchEvent:  X:" + paramMotionEvent.getX() + " Y:" + paramMotionEvent.getY());
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.jdField_a_of_type_Int;
      i = (int)((i - this.jdField_b_of_type_Int) * 0.6F);
      QLog.d(jdField_a_of_type_JavaLangString, 1, "ACTION_MOVE dx:" + j + "    dy:" + i);
      if ((Math.abs(j) > this.d) && (Math.abs(j) >= Math.abs(i)))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "move axis x");
        return false;
      }
    } while (!(this.jdField_a_of_type_AndroidViewView instanceof NestScrollRecyclerView));
    QLog.d(jdField_a_of_type_JavaLangString, 4, "NestScrollRecyclerView");
    return false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt1 = getMeasuredHeight();
      paramInt2 = getMeasuredWidth();
      if (getMeasuredHeight() > ImmersiveUtils.b()) {
        paramInt1 = ImmersiveUtils.b();
      }
      if (getMeasuredWidth() > ImmersiveUtils.a()) {
        paramInt2 = ImmersiveUtils.a();
      }
      setMeasuredDimension(paramInt2, paramInt1);
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    Log.d(jdField_a_of_type_JavaLangString, String.format("----onNestedFling---------------- velocityX:%s, velocityY:%s, consumed:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(paramBoolean) }));
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
    Log.d(jdField_a_of_type_JavaLangString, String.format("onNestedPreScroll dx:%s,dy:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (((paramView instanceof RecyclerView)) && (a(paramInt2, (RecyclerView)paramView)))
    {
      scrollBy(0, paramInt2);
      Log.d(jdField_a_of_type_JavaLangString, "scrollBy" + paramInt2);
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d(jdField_a_of_type_JavaLangString, "onNestedScroll: targetView:" + paramView.hashCode() + " dxConsumed:" + paramInt1 + "   dyConsumed:" + paramInt2 + "   dxUnconsumed:" + paramInt3 + "   dyUnconsumed:" + paramInt4);
  }
  
  @SuppressLint({"NewApi"})
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    Log.d(jdField_a_of_type_JavaLangString, "----父布局onNestedScrollAccepted----------------");
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.jdField_b_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    Log.d(jdField_a_of_type_JavaLangString, String.format("父布局onStartNestedScroll: child:%s, target:%s, nestedScrollAxes:%s", new Object[] { Integer.valueOf(paramView1.hashCode()), Integer.valueOf(paramView2.hashCode()), Integer.valueOf(paramInt) }));
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    Log.d(jdField_a_of_type_JavaLangString, "----父布局onStopNestedScroll----------------");
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.onStopNestedScroll(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = a(paramMotionEvent);
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    super.setAdapter(paramAdapter);
  }
  
  public void setNeedLimitHeightWidth(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setNestScrollDelegate(yzv paramyzv)
  {
    this.jdField_a_of_type_Yzv = paramyzv;
  }
  
  public void setTransDispatchDelegate(yzw paramyzw)
  {
    this.jdField_a_of_type_Yzw = paramyzw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */