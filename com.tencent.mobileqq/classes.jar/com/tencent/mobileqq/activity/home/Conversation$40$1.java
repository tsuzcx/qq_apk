package com.tencent.mobileqq.activity.home;

import android.os.SystemClock;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.PullRefreshHeader;

class Conversation$40$1
  implements Runnable
{
  Conversation$40$1(Conversation.40 param40, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$40.a.e(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$40.a.f)
    {
      Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$40.a, 800L);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$40.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      int j = 0;
      int i;
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$40.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
        if (this.jdField_a_of_type_Boolean) {
          i = 0;
        } else {
          i = 2;
        }
        ((PullRefreshHeader)localObject).a(i);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$40.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$40.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
        if (this.jdField_a_of_type_Boolean) {
          i = j;
        } else {
          i = 2;
        }
        ((MsgTabStoryNodeListManager)localObject).a(i);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$40.a.c > 0L) {
      StartupTracker.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$40.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.40.1
 * JD-Core Version:    0.7.0.1
 */