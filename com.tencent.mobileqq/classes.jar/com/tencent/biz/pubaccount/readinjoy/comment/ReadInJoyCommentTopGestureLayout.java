package com.tencent.biz.pubaccount.readinjoy.comment;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ReadInJoyCommentTopGestureLayout
  extends RelativeLayout
{
  float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int = 5;
  private Context jdField_a_of_type_AndroidContentContext;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  Scroller jdField_a_of_type_AndroidWidgetScroller;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ReadInJoyCommentTopGestureLayout.IFirstLevelCommentContainer jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout$IFirstLevelCommentContainer;
  private RecyclerView jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView;
  private boolean jdField_a_of_type_Boolean = true;
  float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private int e;
  
  public ReadInJoyCommentTopGestureLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyCommentTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyCommentTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramContext == null) {
      return;
    }
    paramContext = ViewConfiguration.get(paramContext);
    this.jdField_c_of_type_Int = paramContext.getScaledMinimumFlingVelocity();
    this.jdField_d_of_type_Int = paramContext.getScaledMaximumFlingVelocity();
    this.e = ViewUtils.a(50.0F);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height -= paramInt;
    if (localLayoutParams.height > this.jdField_b_of_type_Int) {
      localLayoutParams.height = this.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller == null) {
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_AndroidContentContext);
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    int i = this.jdField_a_of_type_AndroidViewView.getScrollX();
    int j = this.jdField_a_of_type_AndroidViewView.getScrollY();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, j, paramInt1 - i, paramInt2 - j, paramInt3);
    invalidate();
  }
  
  private boolean a()
  {
    return (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (a())
    {
      d();
      return;
    }
    int j = Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY());
    if (j > 200)
    {
      if (this.jdField_a_of_type_AndroidWidgetScroller != null) {
        this.jdField_a_of_type_AndroidWidgetScroller.setFinalY(0);
      }
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentTopGestureLayout.1(this, (View)localObject), 32L);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout$IFirstLevelCommentContainer;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = 1;; i = 2)
      {
        ((ReadInJoyCommentTopGestureLayout.IFirstLevelCommentContainer)localObject).a(i, j);
        return;
      }
    }
    a(0, 0, 200);
  }
  
  private boolean b()
  {
    return (this.jdField_b_of_type_Boolean) && (c()) && (d());
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    ReadInJoyCommentTopGestureLayout.IFirstLevelCommentContainer localIFirstLevelCommentContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout$IFirstLevelCommentContainer;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      localIFirstLevelCommentContainer.a(i, -1);
      return;
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount() != 0))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition() == 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop() != 0) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private void d()
  {
    int i = 1;
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    int j = this.jdField_b_of_type_Int - localLayoutParams.height;
    if (j > 200)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout$IFirstLevelCommentContainer;
      if (this.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        ((ReadInJoyCommentTopGestureLayout.IFirstLevelCommentContainer)localObject).a(i, j);
        return;
        i = 2;
      }
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { localLayoutParams.height, this.jdField_b_of_type_Int });
    localValueAnimator.addUpdateListener(new ReadInJoyCommentTopGestureLayout.2(this, localLayoutParams, (View)localObject));
    localValueAnimator.setDuration(120L);
    localValueAnimator.start();
  }
  
  private boolean d()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView != null) && (this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView.getChildCount() != 0))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView.getFirstVisibleItemPos() == 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView.getChildAt(0).getTop() != 0) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller == null) {
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_AndroidContentContext);
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    while (!this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
    postInvalidate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    if ((this.jdField_a_of_type_AndroidViewView == null) || (!a()) || (paramMotionEvent == null)) {
      return false;
    }
    if (this.jdField_b_of_type_Float != 0.0F) {
      f1 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
    }
    this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
    this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    int j = paramMotionEvent.getAction();
    if (j == 3)
    {
      a();
      return false;
    }
    label104:
    int i;
    switch (j)
    {
    case 1: 
    default: 
      i = 0;
      label107:
      if (a()) {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidViewView.getHeight();
      }
      boolean bool = b();
      QLog.d("ReadInJoyCommentTopGestureLayout", 1, "willIntercept: " + bool);
      if ((this.jdField_b_of_type_Boolean) && (i != 0))
      {
        i = 1;
        label173:
        if ((!bool) || (f1 <= 5.0F) || (j == 0)) {
          break label289;
        }
      }
      break;
    }
    label289:
    for (j = 1; (i != 0) || (j != 0); j = 0)
    {
      return true;
      this.jdField_c_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_d_of_type_Float = paramMotionEvent.getRawY();
      i = 0;
      break label107;
      float f2 = Math.max(paramMotionEvent.getRawX() - this.jdField_c_of_type_Float, 1.0F);
      float f3 = Math.abs((paramMotionEvent.getRawY() - this.jdField_d_of_type_Float) / f2);
      if ((f2 <= this.e) || (f3 >= 0.5F)) {
        break label104;
      }
      i = 1;
      break label107;
      i = 0;
      break label173;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    if ((this.jdField_a_of_type_AndroidViewView == null) || (!a()) || (paramMotionEvent == null)) {
      return false;
    }
    if (this.jdField_b_of_type_Float != 0.0F) {
      f1 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
    }
    this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
    this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default: 
      b();
      return true;
    case 2: 
      if (a()) {
        a((int)f1);
      }
      for (;;)
      {
        return true;
        i = (int)(this.jdField_a_of_type_AndroidViewView.getScrollY() - f1);
        if (i <= 0) {
          a(0, i, 0);
        }
      }
    }
    f1 = Math.max(paramMotionEvent.getRawX() - this.jdField_c_of_type_Float, 1.0F);
    float f2 = Math.abs((paramMotionEvent.getRawY() - this.jdField_d_of_type_Float) / f1);
    int i = paramMotionEvent.getPointerId(0);
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_d_of_type_Int);
    float f3 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i);
    if ((f1 > this.e) && (f2 < 0.5F) && (Math.abs(f3) > this.jdField_c_of_type_Int)) {
      c();
    }
    for (;;)
    {
      a();
      return true;
      b();
    }
  }
  
  public void setCommentListView(ReadInJoyCommentListView paramReadInJoyCommentListView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
  }
  
  public void setFirstLevelCommentContainer(ReadInJoyCommentTopGestureLayout.IFirstLevelCommentContainer paramIFirstLevelCommentContainer, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout$IFirstLevelCommentContainer = paramIFirstLevelCommentContainer;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setIsAllowedToInterceptTouchEvent(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setIsFirstCommentView(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_ComTencentMttSupportuiViewsRecyclerviewRecyclerView = paramRecyclerView;
  }
  
  public void setRootView(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      setIsAllowedToInterceptTouchEvent(this.jdField_c_of_type_Boolean);
      return;
    }
    setIsAllowedToInterceptTouchEvent(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */