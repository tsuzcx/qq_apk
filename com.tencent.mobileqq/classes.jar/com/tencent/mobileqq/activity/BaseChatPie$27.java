package com.tencent.mobileqq.activity;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.widget.ScrollerRunnable;

class BaseChatPie$27
  implements Runnable
{
  BaseChatPie$27(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(i + this.a, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.a, 250L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.27
 * JD-Core Version:    0.7.0.1
 */