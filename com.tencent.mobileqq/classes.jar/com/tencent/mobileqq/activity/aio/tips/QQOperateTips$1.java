package com.tencent.mobileqq.activity.aio.tips;

import aeyo;
import akpb;
import andn;
import andp;
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
  public QQOperateTips$1(aeyo paramaeyo) {}
  
  public void run()
  {
    Object localObject1 = aeyo.a(this.this$0).a().a(aeyo.a(this.this$0).jdField_a_of_type_JavaLangString, aeyo.a(this.this$0).jdField_a_of_type_Int);
    int j = ((List)localObject1).size();
    Object localObject2;
    int i;
    if ((localObject1 != null) && (j > 0))
    {
      localObject2 = (ChatMessage)((List)localObject1).get(j - 1);
      if (localObject2 != null)
      {
        if (aeyo.a(this.this$0).jdField_a_of_type_Int != 0) {
          break label333;
        }
        aeyo.a(this.this$0, ((ChatMessage)localObject2).time);
        aeyo.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
      if (aeyo.a(this.this$0).a().a(aeyo.a(this.this$0).jdField_a_of_type_JavaLangString, aeyo.a(this.this$0).jdField_a_of_type_Int) <= 0) {
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
          QLog.d("QQOperateVoIP", 4, " from aio open .. unreadMsg index = " + aeyo.a(this.this$0));
        }
        localObject2 = andn.a(aeyo.a(this.this$0));
        if (localObject2 != null)
        {
          localObject1 = ((andn)localObject2).a(aeyo.a(this.this$0).jdField_a_of_type_JavaLangString, aeyo.a(this.this$0).jdField_a_of_type_Int, aeyo.a(this.this$0), (List)localObject1, true, aeyo.a(this.this$0));
          if (((andp)localObject1).jdField_a_of_type_Boolean)
          {
            localObject1 = ((andp)localObject1).jdField_a_of_type_JavaUtilArrayList;
            ((andn)localObject2).a(aeyo.a(this.this$0).jdField_a_of_type_JavaLangString, aeyo.a(this.this$0).jdField_a_of_type_Int, (ArrayList)localObject1, aeyo.a(this.this$0));
          }
        }
        aeyo.a(this.this$0, -1);
        return;
        label333:
        if (aeyo.a(this.this$0).jdField_a_of_type_Int != 3000) {
          break;
        }
        aeyo.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        break;
        label365:
        i = 0;
        break label145;
      }
      aeyo.a(this.this$0, i - 1);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.1
 * JD-Core Version:    0.7.0.1
 */