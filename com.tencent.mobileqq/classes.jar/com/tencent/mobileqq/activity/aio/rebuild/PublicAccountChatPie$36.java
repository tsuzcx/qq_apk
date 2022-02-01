package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class PublicAccountChatPie$36
  implements Runnable
{
  PublicAccountChatPie$36(PublicAccountChatPie paramPublicAccountChatPie, String paramString, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    List localList = this.this$0.a.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (localList != null)
    {
      bool1 = bool2;
      if (!localList.isEmpty()) {
        i = localList.size() - 1;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i >= 0)
      {
        if ((((MessageRecord)localList.get(i)).msgUid == this.jdField_a_of_type_Long) && (((MessageRecord)localList.get(i)).shmsgseq == this.b)) {
          bool1 = true;
        }
      }
      else
      {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.this$0.a.getCurrentAccountUin(), "show_msg_result", bool1, 0L, 0L, new HashMap(), "");
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.b, 2, "reportShowMsgResult uin = " + this.jdField_a_of_type_JavaLangString + " , type = " + this.jdField_a_of_type_Int + " , msguid = " + this.jdField_a_of_type_Long + " , result = " + bool1);
        }
        if ((!bool1) && (QLog.isColorLevel())) {
          QLog.d(this.this$0.b, 2, "lost msg uin = " + this.jdField_a_of_type_JavaLangString + " , type = " + this.jdField_a_of_type_Int + " , msguid = " + this.jdField_a_of_type_Long + " , msgseq = " + this.b);
        }
        return;
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.36
 * JD-Core Version:    0.7.0.1
 */