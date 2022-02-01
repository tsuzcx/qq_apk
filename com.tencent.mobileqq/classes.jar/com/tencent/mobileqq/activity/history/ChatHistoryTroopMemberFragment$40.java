package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class ChatHistoryTroopMemberFragment$40
  extends DiscussionObserver
{
  ChatHistoryTroopMemberFragment$40(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void a(boolean paramBoolean, Long paramLong)
  {
    if (this.a.c != null) {
      this.a.c.dismiss();
    }
  }
  
  public void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if (paramBoolean)
    {
      ReportController.b(this.a.b, "CliOper", "", "", "0X80040F5", "0X80040F5", 0, 0, "", "", "", "");
      this.a.a(paramLong2 + "");
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
      }
      if (this.a.k)
      {
        this.a.d(paramLong2 + "");
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter.notifyDataSetChanged();
        }
      }
    }
    for (;;)
    {
      if (this.a.c != null) {
        this.a.c.dismiss();
      }
      return;
      QQToast.a(this.a.getActivity(), 1, this.a.getString(2131693579), 0).b(this.a.getActivity().getTitleBarHeight());
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3)
  {
    this.a.getActivity().runOnUiThread(new ChatHistoryTroopMemberFragment.40.1(this, paramBoolean1, paramString, paramBoolean2, paramInt1, paramInt2, paramBoolean3));
  }
  
  public void b(boolean paramBoolean, Long paramLong)
  {
    if (this.a.c != null) {
      this.a.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.40
 * JD-Core Version:    0.7.0.1
 */