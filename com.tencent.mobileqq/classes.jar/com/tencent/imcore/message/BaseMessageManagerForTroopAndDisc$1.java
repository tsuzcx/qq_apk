package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;

class BaseMessageManagerForTroopAndDisc$1
  implements Runnable
{
  BaseMessageManagerForTroopAndDisc$1(BaseMessageManagerForTroopAndDisc paramBaseMessageManagerForTroopAndDisc, long paramLong1, long paramLong2, int paramInt, long paramLong3, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    long l = Math.min(this.jdField_a_of_type_Long, this.b);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->>pkgIndex : ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" beginSeq:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" fixEndSeq:");
      localStringBuilder.append(l);
      QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg.trooptroop_pull_msg", 2, localStringBuilder.toString());
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.putAioInParallelPullMsgMark(this.jdField_a_of_type_JavaLangString, this.c, l);
    BaseMessageManagerForTroopAndDisc.jdField_a_of_type_ComTencentImcoreMessageBaseMessageManagerForTroopAndDisc$Callback.a(this.this$0.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaLangString, this.c, l, true, this.jdField_a_of_type_AndroidOsBundle, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.1
 * JD-Core Version:    0.7.0.1
 */