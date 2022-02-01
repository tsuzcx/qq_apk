package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class PublicAccountChatPie$37
  implements Runnable
{
  PublicAccountChatPie$37(PublicAccountChatPie paramPublicAccountChatPie, String paramString, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    boolean bool = true;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        if ((((MessageRecord)((List)localObject).get(i)).msgUid == this.jdField_a_of_type_Long) && (((MessageRecord)((List)localObject).get(i)).shmsgseq == this.b)) {
          break label104;
        }
        i -= 1;
      }
    }
    bool = false;
    label104:
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.this$0.a.getCurrentAccountUin(), "show_msg_result", bool, 0L, 0L, new HashMap(), "");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.this$0.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportShowMsgResult uin = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" , type = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" , msguid = ");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append(" , result = ");
      localStringBuilder.append(bool);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((!bool) && (QLog.isColorLevel()))
    {
      localObject = this.this$0.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("lost msg uin = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" , type = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" , msguid = ");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append(" , msgseq = ");
      localStringBuilder.append(this.b);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.37
 * JD-Core Version:    0.7.0.1
 */