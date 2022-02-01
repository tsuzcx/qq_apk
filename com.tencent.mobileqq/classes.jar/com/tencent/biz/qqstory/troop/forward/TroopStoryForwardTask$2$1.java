package com.tencent.biz.qqstory.troop.forward;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopStory;
import zcm;
import zcn;

public class TroopStoryForwardTask$2$1
  implements Runnable
{
  public TroopStoryForwardTask$2$1(zcn paramzcn, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Zcn.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.storyId = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Zcn.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.serial();
    this.jdField_a_of_type_Zcn.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_Zcn.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.frienduin, this.jdField_a_of_type_Zcn.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.istroop, this.jdField_a_of_type_Zcn.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.uniseq, this.jdField_a_of_type_Zcn.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.msgData);
    this.jdField_a_of_type_Zcn.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask.2.1
 * JD-Core Version:    0.7.0.1
 */