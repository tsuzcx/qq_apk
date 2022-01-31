package com.tencent.mobileqq.activity.aio.tips;

import aeyq;
import akpc;
import andi;
import andk;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QQOperateTips$1
  implements Runnable
{
  public QQOperateTips$1(aeyq paramaeyq) {}
  
  public void run()
  {
    Object localObject1 = aeyq.a(this.this$0).a().a(aeyq.a(this.this$0).jdField_a_of_type_JavaLangString, aeyq.a(this.this$0).jdField_a_of_type_Int);
    int j = ((List)localObject1).size();
    Object localObject2;
    int i;
    if ((localObject1 != null) && (j > 0))
    {
      localObject2 = (ChatMessage)((List)localObject1).get(j - 1);
      if (localObject2 != null)
      {
        if (aeyq.a(this.this$0).jdField_a_of_type_Int != 0) {
          break label333;
        }
        aeyq.a(this.this$0, ((ChatMessage)localObject2).time);
        aeyq.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
      if (aeyq.a(this.this$0).a().a(aeyq.a(this.this$0).jdField_a_of_type_JavaLangString, aeyq.a(this.this$0).jdField_a_of_type_Int) <= 0) {
        break label365;
      }
      i = 1;
      label145:
      if (i != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (i > 0)
      {
        localObject2 = (ChatMessage)((List)localObject1).get(i - 1);
        if ((localObject2 == null) || (!((ChatMessage)localObject2).isread)) {}
      }
      else
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QQOperateVoIP", 4, " from aio open .. unreadMsg index = " + aeyq.a(this.this$0));
        }
        localObject2 = andi.a(aeyq.a(this.this$0));
        if (localObject2 != null)
        {
          localObject1 = ((andi)localObject2).a(aeyq.a(this.this$0).jdField_a_of_type_JavaLangString, aeyq.a(this.this$0).jdField_a_of_type_Int, aeyq.a(this.this$0), (List)localObject1, true, aeyq.a(this.this$0));
          if (((andk)localObject1).jdField_a_of_type_Boolean)
          {
            localObject1 = ((andk)localObject1).jdField_a_of_type_JavaUtilArrayList;
            ((andi)localObject2).a(aeyq.a(this.this$0).jdField_a_of_type_JavaLangString, aeyq.a(this.this$0).jdField_a_of_type_Int, (ArrayList)localObject1, aeyq.a(this.this$0));
          }
        }
        aeyq.a(this.this$0, -1);
        return;
        label333:
        if (aeyq.a(this.this$0).jdField_a_of_type_Int != 3000) {
          break;
        }
        aeyq.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        break;
        label365:
        i = 0;
        break label145;
      }
      aeyq.a(this.this$0, i - 1);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.1
 * JD-Core Version:    0.7.0.1
 */