package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;

class RichStatItemBuilder$1
  implements Runnable
{
  RichStatItemBuilder$1(RichStatItemBuilder paramRichStatItemBuilder) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(RichStatItemBuilder.a().feedsId))
    {
      ((FriendListHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getRichStatus(new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin });
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "sign feedid is is null reget friend sign");
      }
    }
    SignatureHandler localSignatureHandler;
    do
    {
      return;
      localSignatureHandler = (SignatureHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
    } while (localSignatureHandler == null);
    localSignatureHandler.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */