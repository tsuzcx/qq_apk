package com.tencent.mobileqq.activity;

import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

class ChatHistoryFileActivity$1
  implements TabBarView.OnTabChangeListener
{
  ChatHistoryFileActivity$1(ChatHistoryFileActivity paramChatHistoryFileActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    ChatHistoryViewBase localChatHistoryViewBase = null;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3)
          {
            if (paramInt2 == 4)
            {
              localChatHistoryViewBase = ChatHistoryFileActivity.a(this.a, 3);
              ReportController.b(this.a.app, "dc00898", "", "", "0X8007128", "0X8007128", 0, 0, "", "", "", "");
            }
          }
          else
          {
            localChatHistoryViewBase = ChatHistoryFileActivity.a(this.a, 2);
            ReportController.b(this.a.app, "dc00898", "", "", "0X8007127", "0X8007127", 0, 0, "", "", "", "");
          }
        }
        else
        {
          localChatHistoryViewBase = ChatHistoryFileActivity.a(this.a, 1);
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007126", "0X8007126", 0, 0, "", "", "", "");
        }
      }
      else {
        localChatHistoryViewBase = ChatHistoryFileActivity.a(this.a, 4);
      }
    }
    else {
      localChatHistoryViewBase = ChatHistoryFileActivity.a(this.a, 0);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.c();
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a());
    }
    if (localChatHistoryViewBase != null)
    {
      localChatHistoryViewBase.a(ChatHistoryFileActivity.a(this.a));
      localChatHistoryViewBase.b();
      ChatHistoryFileActivity localChatHistoryFileActivity = this.a;
      localChatHistoryFileActivity.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase = localChatHistoryViewBase;
      localChatHistoryViewBase = localChatHistoryFileActivity.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase;
      localChatHistoryFileActivity = this.a;
      localChatHistoryViewBase.a = localChatHistoryFileActivity;
      localChatHistoryFileActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a(), 0, new ViewGroup.LayoutParams(-1, -1));
      if (this.a.jdField_a_of_type_Boolean)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.e();
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity.1
 * JD-Core Version:    0.7.0.1
 */