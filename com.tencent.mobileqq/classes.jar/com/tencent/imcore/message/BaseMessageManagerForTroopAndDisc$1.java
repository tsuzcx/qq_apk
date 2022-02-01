package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.qphone.base.util.QLog;

class BaseMessageManagerForTroopAndDisc$1
  implements Runnable
{
  BaseMessageManagerForTroopAndDisc$1(BaseMessageManagerForTroopAndDisc paramBaseMessageManagerForTroopAndDisc, long paramLong1, long paramLong2, int paramInt, long paramLong3, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    long l = Math.min(this.jdField_a_of_type_Long, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg.trooptroop_pull_msg", 2, "--->>pkgIndex : " + this.jdField_a_of_type_Int + " beginSeq:" + this.c + " fixEndSeq:" + l);
    }
    this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a().a(this.jdField_a_of_type_JavaLangString, this.c, l);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(this.jdField_a_of_type_JavaLangString, this.c, l, true, this.jdField_a_of_type_AndroidOsBundle, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.1
 * JD-Core Version:    0.7.0.1
 */