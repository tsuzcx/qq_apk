package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.widget.Scroller;

public class AutoScroller
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private AutoScroller.ScrollerCallback jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller$ScrollerCallback;
  private CommonRefreshLayout jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public AutoScroller(CommonRefreshLayout paramCommonRefreshLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout = paramCommonRefreshLayout;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramCommonRefreshLayout.getContext());
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.removeCallbacks(this);
    if ((!this.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller$ScrollerCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller$ScrollerCallback.a();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished())
      {
        this.b = true;
        this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      }
      b();
      this.b = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.removeCallbacks(this);
    this.jdField_a_of_type_Int = 0;
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
    }
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, 0, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.post(this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(AutoScroller.ScrollerCallback paramScrollerCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller$ScrollerCallback = paramScrollerCallback;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetScroller.isFinished();
  }
  
  public void run()
  {
    if ((!this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()) || (this.jdField_a_of_type_AndroidWidgetScroller.isFinished())) {}
    int j;
    int k;
    for (int i = 1;; i = 0)
    {
      j = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      k = this.jdField_a_of_type_Int;
      if (i == 0) {
        break;
      }
      b();
      return;
    }
    this.jdField_a_of_type_Int = j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller$ScrollerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller$ScrollerCallback.a(j - k);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.AutoScroller
 * JD-Core Version:    0.7.0.1
 */