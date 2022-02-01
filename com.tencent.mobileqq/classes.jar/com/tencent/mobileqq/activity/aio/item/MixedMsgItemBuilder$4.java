package com.tencent.mobileqq.activity.aio.item;

import android.os.SystemClock;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class MixedMsgItemBuilder$4
  implements ActionSheet.OnButtonClickListener
{
  MixedMsgItemBuilder$4(MixedMsgItemBuilder paramMixedMsgItemBuilder, MessageForMixedMsg paramMessageForMixedMsg, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      long l;
      do
      {
        return;
        l = SystemClock.uptimeMillis();
      } while (l - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder.c < 500L);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder.c = l;
      paramView = (MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
      paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */