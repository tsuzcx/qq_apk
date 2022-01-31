package com.tencent.mobileqq.activity.aio.tips;

import aenu;
import akaq;
import amnb;
import amnd;
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
  public QQOperateTips$1(aenu paramaenu) {}
  
  public void run()
  {
    Object localObject1 = aenu.a(this.this$0).a().a(aenu.a(this.this$0).jdField_a_of_type_JavaLangString, aenu.a(this.this$0).jdField_a_of_type_Int);
    int j = ((List)localObject1).size();
    Object localObject2;
    int i;
    if ((localObject1 != null) && (j > 0))
    {
      localObject2 = (ChatMessage)((List)localObject1).get(j - 1);
      if (localObject2 != null)
      {
        if (aenu.a(this.this$0).jdField_a_of_type_Int != 0) {
          break label333;
        }
        aenu.a(this.this$0, ((ChatMessage)localObject2).time);
        aenu.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
      if (aenu.a(this.this$0).a().a(aenu.a(this.this$0).jdField_a_of_type_JavaLangString, aenu.a(this.this$0).jdField_a_of_type_Int) <= 0) {
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
          QLog.d("QQOperateVoIP", 4, " from aio open .. unreadMsg index = " + aenu.a(this.this$0));
        }
        localObject2 = amnb.a(aenu.a(this.this$0));
        if (localObject2 != null)
        {
          localObject1 = ((amnb)localObject2).a(aenu.a(this.this$0).jdField_a_of_type_JavaLangString, aenu.a(this.this$0).jdField_a_of_type_Int, aenu.a(this.this$0), (List)localObject1, true, aenu.a(this.this$0));
          if (((amnd)localObject1).jdField_a_of_type_Boolean)
          {
            localObject1 = ((amnd)localObject1).jdField_a_of_type_JavaUtilArrayList;
            ((amnb)localObject2).a(aenu.a(this.this$0).jdField_a_of_type_JavaLangString, aenu.a(this.this$0).jdField_a_of_type_Int, (ArrayList)localObject1, aenu.a(this.this$0));
          }
        }
        aenu.a(this.this$0, -1);
        return;
        label333:
        if (aenu.a(this.this$0).jdField_a_of_type_Int != 3000) {
          break;
        }
        aenu.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        break;
        label365:
        i = 0;
        break label145;
      }
      aenu.a(this.this$0, i - 1);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.1
 * JD-Core Version:    0.7.0.1
 */