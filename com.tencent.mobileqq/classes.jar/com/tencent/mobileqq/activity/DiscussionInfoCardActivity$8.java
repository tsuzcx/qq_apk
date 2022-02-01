package com.tencent.mobileqq.activity;

import android.graphics.Color;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

class DiscussionInfoCardActivity$8
  implements ActionSheet.OnButtonClickListener
{
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.getMessageFacade().a(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), 3000);
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.getMessageFacade().e(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), 3000);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, "chat_history_confirm_del_msg");
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.getHandler(Conversation.class);
      Message localMessage = paramView.obtainMessage(1017);
      localMessage.obj = DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity);
      localMessage.arg1 = 3000;
      paramView.sendMessage(localMessage);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity, 2, this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131690937), 0).a();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a != null) {
        ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.findViewById(2131379432)).setTextColor(Color.parseColor("#cccccc"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.8
 * JD-Core Version:    0.7.0.1
 */