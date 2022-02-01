package com.tencent.mobileqq.activity.home;

import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class Conversation$63
  implements ActionSheet.OnButtonClickListener
{
  Conversation$63(Conversation paramConversation) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.superDismiss();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, " showActionSheetForCancelMayknowRecommand recommend_item_menu hide clicked");
      }
      ((FriendListHandler)this.a.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).reqHideConversationMayknowRecommend();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.63
 * JD-Core Version:    0.7.0.1
 */