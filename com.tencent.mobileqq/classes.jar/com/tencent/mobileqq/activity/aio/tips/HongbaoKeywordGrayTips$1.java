package com.tencent.mobileqq.activity.aio.tips;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class HongbaoKeywordGrayTips$1
  implements Runnable
{
  HongbaoKeywordGrayTips$1(HongbaoKeywordGrayTips paramHongbaoKeywordGrayTips) {}
  
  public void run()
  {
    Object localObject = HongbaoKeywordGrayTips.a(this.this$0).getMessageFacade().b(HongbaoKeywordGrayTips.a(this.this$0).jdField_a_of_type_JavaLangString, HongbaoKeywordGrayTips.a(this.this$0).jdField_a_of_type_Int);
    int i = ((List)localObject).size();
    if (i > 0)
    {
      localObject = (ChatMessage)((List)localObject).get(i - 1);
      if (HongbaoKeywordGrayTips.a(this.this$0).jdField_a_of_type_Int == 0) {
        HongbaoKeywordGrayTips.a(this.this$0, ((ChatMessage)localObject).time);
      } else if ((HongbaoKeywordGrayTips.a(this.this$0).jdField_a_of_type_Int == 3000) || (HongbaoKeywordGrayTips.a(this.this$0).jdField_a_of_type_Int == 1)) {
        HongbaoKeywordGrayTips.a(this.this$0, ((ChatMessage)localObject).shmsgseq);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("size : ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", mLastMsgIdOrTime:");
      ((StringBuilder)localObject).append(HongbaoKeywordGrayTips.a(this.this$0));
      QLog.d("HongbaoKeywordGrayTips", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips.1
 * JD-Core Version:    0.7.0.1
 */