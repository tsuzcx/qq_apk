package com.tencent.mobileqq.activity.aio.tips;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
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
    Object localObject = HongbaoKeywordGrayTips.a(this.this$0).getMessageFacade().a(HongbaoKeywordGrayTips.a(this.this$0).jdField_a_of_type_JavaLangString, HongbaoKeywordGrayTips.a(this.this$0).jdField_a_of_type_Int);
    int i = ((List)localObject).size();
    if (i > 0)
    {
      localObject = (ChatMessage)((List)localObject).get(i - 1);
      if (HongbaoKeywordGrayTips.a(this.this$0).jdField_a_of_type_Int != 0) {
        break label130;
      }
      HongbaoKeywordGrayTips.a(this.this$0, ((ChatMessage)localObject).time);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "size : " + i + ", mLastMsgIdOrTime:" + HongbaoKeywordGrayTips.a(this.this$0));
      }
      return;
      label130:
      if ((HongbaoKeywordGrayTips.a(this.this$0).jdField_a_of_type_Int == 3000) || (HongbaoKeywordGrayTips.a(this.this$0).jdField_a_of_type_Int == 1)) {
        HongbaoKeywordGrayTips.a(this.this$0, ((ChatMessage)localObject).shmsgseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips.1
 * JD-Core Version:    0.7.0.1
 */