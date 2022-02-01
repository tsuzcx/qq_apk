package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class ChatHistoryTroopMemberFragment$40
  extends DiscussionObserver
{
  ChatHistoryTroopMemberFragment$40(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if (this.a.L != null) {
      this.a.L.dismiss();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if (paramBoolean)
    {
      ReportController.b(this.a.bc, "CliOper", "", "", "0X80040F5", "0X80040F5", 0, 0, "", "", "", "");
      paramLong1 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("");
      paramLong1.d(localStringBuilder.toString());
      if (this.a.K != null) {
        this.a.K.c();
      }
      if (this.a.ap)
      {
        paramLong1 = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLong2);
        localStringBuilder.append("");
        paramLong1.c(localStringBuilder.toString());
        if (this.a.ad != null) {
          this.a.ad.notifyDataSetChanged();
        }
      }
    }
    else
    {
      QQToast.makeText(this.a.getBaseActivity(), 1, this.a.getString(2131891098), 0).show(this.a.getBaseActivity().getTitleBarHeight());
    }
    if (this.a.L != null) {
      this.a.L.dismiss();
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3)
  {
    this.a.getBaseActivity().runOnUiThread(new ChatHistoryTroopMemberFragment.40.1(this, paramBoolean1, paramString, paramBoolean2, paramInt1, paramInt2, paramBoolean3));
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (this.a.L != null) {
      this.a.L.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.40
 * JD-Core Version:    0.7.0.1
 */