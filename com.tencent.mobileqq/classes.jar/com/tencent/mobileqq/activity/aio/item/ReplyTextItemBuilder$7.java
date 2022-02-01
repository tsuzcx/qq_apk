package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.widget.QQToast;

class ReplyTextItemBuilder$7
  implements DialogInterface.OnClickListener
{
  ReplyTextItemBuilder$7(ReplyTextItemBuilder paramReplyTextItemBuilder, MessageForReplyText paramMessageForReplyText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).a) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)))
    {
      paramDialogInterface = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.jdField_a_of_type_AndroidContentContext;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697388, 0).b(paramDialogInterface.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */