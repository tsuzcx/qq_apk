package com.tencent.mobileqq.activity.contacts.view.pullrefresh;

import afti;
import android.widget.Scroller;

public class AutoScroller
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private afti jdField_a_of_type_Afti;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private CommonRefreshLayout jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public AutoScroller(CommonRefreshLayout paramCommonRefreshLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout = paramCommonRefreshLayout;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramCommonRefreshLayout.getContext());
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.removeCallbacks(this);
    if ((!this.b) && (this.jdField_a_of_type_Afti != null)) {
      this.jdField_a_of_type_Afti.a();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.removeCallbacks(this);
    this.jdField_a_of_type_Int = 0;
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
    }
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, 0, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.post(this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(afti paramafti)
  {
    this.jdField_a_of_type_Afti = paramafti;
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
    if (this.jdField_a_of_type_Afti != null) {
      this.jdField_a_of_type_Afti.a(j - k);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.pullrefresh.AutoScroller
 * JD-Core Version:    0.7.0.1
 */