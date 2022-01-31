package com.tencent.biz.pubaccount.readinjoy.comment;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.app.ThreadManager;
import ljw;
import ljx;
import mqq.os.MqqHandler;

public class ReadInJoyCommentTopGestureLayout
  extends RelativeLayout
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  Scroller jdField_a_of_type_AndroidWidgetScroller;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private boolean jdField_a_of_type_Boolean = true;
  float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
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
    setOnTouchListener(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if ((this.c) && (this.jdField_a_of_type_Boolean))
    {
      b();
      return;
    }
    int j = Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY());
    if (j > 200)
    {
      if (this.jdField_a_of_type_AndroidWidgetScroller != null) {
        this.jdField_a_of_type_AndroidWidgetScroller.setFinalY(0);
      }
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      ThreadManager.getUIHandler().postDelayed(new ljw(this, (View)localObject), 32L);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = 1;; i = 2)
      {
        ((ReadInJoyCommentListFragment)localObject).a(i, j);
        return;
      }
    }
    a(0, 0, 200);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height -= paramInt;
    if (localLayoutParams.height > this.jdField_a_of_type_Int) {
      localLayoutParams.height = this.jdField_a_of_type_Int;
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Boolean) {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount() != 0))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop() != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b()
  {
    int i = 1;
    Object localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (this.jdField_a_of_type_Int - ((ViewGroup.LayoutParams)localObject).height > 200)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
      if (this.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        ((ReadInJoyCommentListFragment)localObject).a(i, -1);
        return;
        i = 2;
      }
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ((ViewGroup.LayoutParams)localObject).height, this.jdField_a_of_type_Int });
    localValueAnimator.addUpdateListener(new ljx(this, (ViewGroup.LayoutParams)localObject));
    localValueAnimator.setDuration(120L);
    localValueAnimator.start();
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
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    float f;
    if (this.jdField_b_of_type_Float != 0.0F)
    {
      f = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      if ((this.c) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidViewView.getHeight();
      }
      if ((!a()) || (f <= 0.0F) || (paramMotionEvent.getAction() == 0)) {
        break label98;
      }
    }
    label98:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      f = 0.0F;
      break;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f = 0.0F;
    if ((this.jdField_a_of_type_AndroidViewView == null) || ((this.jdField_a_of_type_Boolean) && (!this.c))) {
      return false;
    }
    if (this.jdField_b_of_type_Float != 0.0F) {
      f = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
    }
    this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
    this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      a();
      return true;
    }
    if ((this.c) && (this.jdField_a_of_type_Boolean)) {
      a((int)f);
    }
    for (;;)
    {
      return true;
      int i = (int)(this.jdField_a_of_type_AndroidViewView.getScrollY() - f);
      if (i <= 0) {
        a(0, i, 0);
      }
    }
  }
  
  public void setCommentListView(ReadInJoyCommentListView paramReadInJoyCommentListView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
  }
  
  public void setFragment(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = paramReadInJoyCommentListFragment;
    this.c = paramBoolean;
  }
  
  public void setIsAllowedToInterceptTouchEvent(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setRootView(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      setIsAllowedToInterceptTouchEvent(this.c);
      return;
    }
    setIsAllowedToInterceptTouchEvent(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */