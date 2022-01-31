package com.tencent.mobileqq.activity.aio.tips;

import abol;
import agvt;
import aouu;
import aouw;
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
  public QQOperateTips$1(agvt paramagvt) {}
  
  public void run()
  {
    Object localObject1 = agvt.a(this.this$0).a().a(agvt.a(this.this$0).jdField_a_of_type_JavaLangString, agvt.a(this.this$0).jdField_a_of_type_Int);
    int j = ((List)localObject1).size();
    Object localObject2;
    int i;
    if ((localObject1 != null) && (j > 0))
    {
      localObject2 = (ChatMessage)((List)localObject1).get(j - 1);
      if (localObject2 != null)
      {
        if (agvt.a(this.this$0).jdField_a_of_type_Int != 0) {
          break label333;
        }
        agvt.a(this.this$0, ((ChatMessage)localObject2).time);
        agvt.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
      if (agvt.a(this.this$0).a().a(agvt.a(this.this$0).jdField_a_of_type_JavaLangString, agvt.a(this.this$0).jdField_a_of_type_Int) <= 0) {
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
          QLog.d("QQOperateVoIP", 4, " from aio open .. unreadMsg index = " + agvt.a(this.this$0));
        }
        localObject2 = aouu.a(agvt.a(this.this$0));
        if (localObject2 != null)
        {
          localObject1 = ((aouu)localObject2).a(agvt.a(this.this$0).jdField_a_of_type_JavaLangString, agvt.a(this.this$0).jdField_a_of_type_Int, agvt.a(this.this$0), (List)localObject1, true, agvt.a(this.this$0));
          if (((aouw)localObject1).jdField_a_of_type_Boolean)
          {
            localObject1 = ((aouw)localObject1).jdField_a_of_type_JavaUtilArrayList;
            ((aouu)localObject2).a(agvt.a(this.this$0).jdField_a_of_type_JavaLangString, agvt.a(this.this$0).jdField_a_of_type_Int, (ArrayList)localObject1, agvt.a(this.this$0));
          }
        }
        agvt.a(this.this$0, -1);
        return;
        label333:
        if (agvt.a(this.this$0).jdField_a_of_type_Int != 3000) {
          break;
        }
        agvt.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        break;
        label365:
        i = 0;
        break label145;
      }
      agvt.a(this.this$0, i - 1);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.1
 * JD-Core Version:    0.7.0.1
 */