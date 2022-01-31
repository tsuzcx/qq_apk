package com.tencent.mobileqq.activity.aio.tips;

import agvi;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class HongbaoKeywordGrayTips$1
  implements Runnable
{
  public HongbaoKeywordGrayTips$1(agvi paramagvi) {}
  
  public void run()
  {
    Object localObject = agvi.a(this.this$0).a().a(agvi.a(this.this$0).jdField_a_of_type_JavaLangString, agvi.a(this.this$0).jdField_a_of_type_Int);
    int i = ((List)localObject).size();
    if (i > 0)
    {
      localObject = (ChatMessage)((List)localObject).get(i - 1);
      if (agvi.a(this.this$0).jdField_a_of_type_Int != 0) {
        break label130;
      }
      agvi.a(this.this$0, ((ChatMessage)localObject).time);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "size : " + i + ", mLastMsgIdOrTime:" + agvi.a(this.this$0));
      }
      return;
      label130:
      if ((agvi.a(this.this$0).jdField_a_of_type_Int == 3000) || (agvi.a(this.this$0).jdField_a_of_type_Int == 1)) {
        agvi.a(this.this$0, ((ChatMessage)localObject).shmsgseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips.1
 * JD-Core Version:    0.7.0.1
 */