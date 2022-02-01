package com.tencent.mobileqq.activity.aio.tips;

import adab;
import aivw;
import arrs;
import arru;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QQOperateTips$1
  implements Runnable
{
  public QQOperateTips$1(aivw paramaivw) {}
  
  public void run()
  {
    Object localObject1 = aivw.a(this.this$0).a().a(aivw.a(this.this$0).jdField_a_of_type_JavaLangString, aivw.a(this.this$0).jdField_a_of_type_Int);
    int j = ((List)localObject1).size();
    Object localObject2;
    int i;
    if ((localObject1 != null) && (j > 0))
    {
      localObject2 = (ChatMessage)((List)localObject1).get(j - 1);
      if (localObject2 != null)
      {
        if (aivw.a(this.this$0).jdField_a_of_type_Int != 0) {
          break label333;
        }
        aivw.a(this.this$0, ((ChatMessage)localObject2).time);
        aivw.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
      if (aivw.a(this.this$0).a().a(aivw.a(this.this$0).jdField_a_of_type_JavaLangString, aivw.a(this.this$0).jdField_a_of_type_Int) <= 0) {
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
          QLog.d("QQOperateVoIP", 4, " from aio open .. unreadMsg index = " + aivw.a(this.this$0));
        }
        localObject2 = arrs.a(aivw.a(this.this$0));
        if (localObject2 != null)
        {
          localObject1 = ((arrs)localObject2).a(aivw.a(this.this$0).jdField_a_of_type_JavaLangString, aivw.a(this.this$0).jdField_a_of_type_Int, aivw.a(this.this$0), (List)localObject1, true, aivw.a(this.this$0));
          if (((arru)localObject1).jdField_a_of_type_Boolean)
          {
            localObject1 = ((arru)localObject1).jdField_a_of_type_JavaUtilArrayList;
            ((arrs)localObject2).a(aivw.a(this.this$0).jdField_a_of_type_JavaLangString, aivw.a(this.this$0).jdField_a_of_type_Int, (ArrayList)localObject1, aivw.a(this.this$0));
          }
        }
        aivw.a(this.this$0, -1);
        return;
        label333:
        if (aivw.a(this.this$0).jdField_a_of_type_Int != 3000) {
          break;
        }
        aivw.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        break;
        label365:
        i = 0;
        break label145;
      }
      aivw.a(this.this$0, i - 1);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.1
 * JD-Core Version:    0.7.0.1
 */