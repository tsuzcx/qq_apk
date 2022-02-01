package com.tencent.biz.subscribe.part.block.base;

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
import com.tencent.biz.subscribe.part.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class NestScrollRecyclerView
  extends RecyclerViewCompat
  implements NestedScrollingParent
{
  private static String jdField_a_of_type_JavaLangString = "NestScrollRecyclerView";
  private int jdField_a_of_type_Int;
  private NestedScrollingParentHelper jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper;
  private View jdField_a_of_type_AndroidViewView;
  private NestScrollRecyclerView.NestScrollDelegate jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView$NestScrollDelegate;
  private NestScrollRecyclerView.TransDispatchDelegate jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView$TransDispatchDelegate;
  private RefreshHeaderView jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView;
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
    if (((paramRecyclerView instanceof NestScrollRecyclerView)) && ((getAdapter() instanceof PullLoadMoreAdapter)) && (((PullLoadMoreAdapter)getAdapter()).b()))
    {
      paramRecyclerView = (NestScrollRecyclerView)paramRecyclerView;
      if (paramRecyclerView.a() == null) {
        paramRecyclerView.a(((PullLoadMoreAdapter)getAdapter()).a());
      }
    }
  }
  
  private void a(MotionEvent paramMotionEvent, View paramView)
  {
    Object localObject = new Rect();
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    getGlobalVisibleRect((Rect)localObject);
    float f1 = ((Rect)localObject).left - localRect.left;
    float f2 = ((Rect)localObject).top - localRect.top;
    paramView = jdField_a_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("modifyEventPos offsetX:");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(" offsetY:");
    ((StringBuilder)localObject).append(f2);
    QLog.d(paramView, 4, ((StringBuilder)localObject).toString());
    paramMotionEvent.offsetLocation(f1, f2);
  }
  
  private void a(RefreshHeaderView paramRefreshHeaderView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView = paramRefreshHeaderView;
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
    if ((paramRecyclerView instanceof NestScrollRecyclerView))
    {
      localObject = (NestScrollRecyclerView)paramRecyclerView;
      if (((NestScrollRecyclerView)localObject).a() != null) {
        return ((NestScrollRecyclerView)localObject).a().a(paramRecyclerView);
      }
    }
    paramRecyclerView = this.jdField_b_of_type_AndroidViewView;
    boolean bool = false;
    if (paramRecyclerView == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "isNestViewNotReachTop mNestTargetViewWrapper is null");
      return false;
    }
    paramRecyclerView = jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isNestViewNotReachTop mNestTargetViewWrapper.getTop()");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidViewView.getTop());
    QLog.d(paramRecyclerView, 1, ((StringBuilder)localObject).toString());
    if (this.jdField_b_of_type_AndroidViewView.getTop() > 0) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (((getAdapter() instanceof PullLoadMoreAdapter)) && (((PullLoadMoreAdapter)getAdapter()).b()) && (((PullLoadMoreAdapter)getAdapter()).a() != null)) {
      ((PullLoadMoreAdapter)getAdapter()).a().a(paramMotionEvent);
    }
    if (a() != null) {
      a().a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public NestScrollRecyclerView.NestScrollDelegate a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView$NestScrollDelegate;
  }
  
  public RefreshHeaderView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView$TransDispatchDelegate != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if ((localView != null) && (!a((RecyclerView)localView)) && (ViewUtils.a(this.jdField_a_of_type_AndroidViewView, paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) && (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView$TransDispatchDelegate.a(paramMotionEvent, (RecyclerView)this.jdField_a_of_type_AndroidViewView)))
      {
        a(paramMotionEvent, this.jdField_a_of_type_AndroidViewView);
        return this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("velocityX");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("   velocityY:");
    localStringBuilder.append(paramInt2);
    QLog.d(str, 1, localStringBuilder.toString());
    return super.fling(paramInt1, paramInt2);
  }
  
  public int getNestedScrollAxes()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInterceptTouchEvent hashCode");
    localStringBuilder.append(hashCode());
    QLog.d(str, 4, localStringBuilder.toString());
    int i = paramMotionEvent.getAction();
    int j = paramMotionEvent.getActionIndex();
    if (i != 0)
    {
      if (i != 2) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInterceptTouchEvent:  X:");
      localStringBuilder.append(paramMotionEvent.getX());
      localStringBuilder.append(" Y:");
      localStringBuilder.append(paramMotionEvent.getY());
      QLog.d(str, 4, localStringBuilder.toString());
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.jdField_a_of_type_Int;
      i = (int)((i - this.jdField_b_of_type_Int) * 0.6F);
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTION_MOVE dx:");
      localStringBuilder.append(j);
      localStringBuilder.append("    dy:");
      localStringBuilder.append(i);
      QLog.d(str, 1, localStringBuilder.toString());
      if ((Math.abs(j) > this.d) && (Math.abs(j) >= Math.abs(i)))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "move axis x");
        return false;
      }
      if ((this.jdField_a_of_type_AndroidViewView instanceof NestScrollRecyclerView))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "NestScrollRecyclerView");
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_Int = ((int)(paramMotionEvent.getX() + 0.5F));
      this.jdField_b_of_type_Int = ((int)(paramMotionEvent.getY() + 0.5F));
      this.c = MotionEventCompat.findPointerIndex(paramMotionEvent, j);
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_b_of_type_AndroidViewView = null;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt1 = getMeasuredHeight();
      paramInt2 = getMeasuredWidth();
      if (getMeasuredHeight() > ImmersiveUtils.getScreenHeight()) {
        paramInt1 = ImmersiveUtils.getScreenHeight();
      }
      if (getMeasuredWidth() > ImmersiveUtils.getScreenWidth()) {
        paramInt2 = ImmersiveUtils.getScreenWidth();
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
    if ((paramView instanceof NestScrollRecyclerView))
    {
      int i = (int)paramFloat2;
      if (a(i, (NestScrollRecyclerView)paramView))
      {
        fling((int)paramFloat1, i);
        bool = true;
        break label42;
      }
    }
    boolean bool = false;
    label42:
    Log.d(jdField_a_of_type_JavaLangString, String.format("----onNestedPreFling---------------- ret:%s, velocityY:%s", new Object[] { Boolean.valueOf(bool), Float.valueOf(paramFloat2) }));
    return bool;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    Log.d(jdField_a_of_type_JavaLangString, String.format("onNestedPreScroll dx:%s,dy:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (((paramView instanceof RecyclerView)) && (a(paramInt2, (RecyclerView)paramView)))
    {
      scrollBy(0, paramInt2);
      paramView = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollBy");
      localStringBuilder.append(paramInt2);
      Log.d(paramView, localStringBuilder.toString());
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNestedScroll: targetView:");
    localStringBuilder.append(paramView.hashCode());
    localStringBuilder.append(" dxConsumed:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("   dyConsumed:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("   dxUnconsumed:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("   dyUnconsumed:");
    localStringBuilder.append(paramInt4);
    Log.d(str, localStringBuilder.toString());
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
  
  public void setNestScrollDelegate(NestScrollRecyclerView.NestScrollDelegate paramNestScrollDelegate)
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView$NestScrollDelegate = paramNestScrollDelegate;
  }
  
  public void setTransDispatchDelegate(NestScrollRecyclerView.TransDispatchDelegate paramTransDispatchDelegate)
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView$TransDispatchDelegate = paramTransDispatchDelegate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */