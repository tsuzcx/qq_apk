package com.tencent.biz.qqstory.troop.forward;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;

class TroopStoryForwardTask$1
  implements Runnable
{
  TroopStoryForwardTask$1(TroopStoryForwardTask paramTroopStoryForwardTask) {}
  
  public void run()
  {
    MessageForTroopStory localMessageForTroopStory = (MessageForTroopStory)MessageRecordFactory.a(-2057);
    MessageRecordFactory.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopStory, this.this$0.k, this.this$0.l, this.this$0.jdField_d_of_type_Int);
    localMessageForTroopStory.uid = Long.valueOf(this.this$0.jdField_b_of_type_JavaLangString).longValue();
    localMessageForTroopStory.unionId = this.this$0.jdField_c_of_type_JavaLangString;
    localMessageForTroopStory.md5 = this.this$0.jdField_d_of_type_JavaLangString;
    localMessageForTroopStory.thumbUrl = this.this$0.e;
    localMessageForTroopStory.doodleUrl = this.this$0.f;
    localMessageForTroopStory.videoWidth = this.this$0.jdField_a_of_type_Int;
    localMessageForTroopStory.videoHeight = this.this$0.jdField_b_of_type_Int;
    localMessageForTroopStory.sourceName = this.this$0.g;
    localMessageForTroopStory.sourceActionType = this.this$0.h;
    localMessageForTroopStory.sourceActionData = this.this$0.i;
    localMessageForTroopStory.compatibleText = this.this$0.j;
    localMessageForTroopStory.ctrVersion = this.this$0.jdField_c_of_type_Int;
    localMessageForTroopStory.msg = MessageForTroopStory.MSG_CONTENT;
    localMessageForTroopStory.serial();
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory = localMessageForTroopStory;
    ((SVIPHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageForTroopStory);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(localMessageForTroopStory, 0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForTroopStory, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask.1
 * JD-Core Version:    0.7.0.1
 */