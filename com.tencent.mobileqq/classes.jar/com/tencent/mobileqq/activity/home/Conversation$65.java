package com.tencent.mobileqq.activity.home;

import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class Conversation$65
  implements ActionSheet.OnButtonClickListener
{
  Conversation$65(Conversation paramConversation) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, " showActionSheetForCancelMayknowRecommand recommend_item_menu hide clicked");
      }
      ((FriendListHandler)this.a.s().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).reqHideConversationMayknowRecommend();
    }
    this.a.ai.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.65
 * JD-Core Version:    0.7.0.1
 */