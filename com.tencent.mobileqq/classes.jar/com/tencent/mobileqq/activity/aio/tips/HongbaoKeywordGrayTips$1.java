package com.tencent.mobileqq.activity.aio.tips;

import aenk;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class HongbaoKeywordGrayTips$1
  implements Runnable
{
  public HongbaoKeywordGrayTips$1(aenk paramaenk) {}
  
  public void run()
  {
    Object localObject = aenk.a(this.this$0).a().a(aenk.a(this.this$0).jdField_a_of_type_JavaLangString, aenk.a(this.this$0).jdField_a_of_type_Int);
    int i = ((List)localObject).size();
    if (i > 0)
    {
      localObject = (ChatMessage)((List)localObject).get(i - 1);
      if (aenk.a(this.this$0).jdField_a_of_type_Int != 0) {
        break label130;
      }
      aenk.a(this.this$0, ((ChatMessage)localObject).time);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "size : " + i + ", mLastMsgIdOrTime:" + aenk.a(this.this$0));
      }
      return;
      label130:
      if ((aenk.a(this.this$0).jdField_a_of_type_Int == 3000) || (aenk.a(this.this$0).jdField_a_of_type_Int == 1)) {
        aenk.a(this.this$0, ((ChatMessage)localObject).shmsgseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips.1
 * JD-Core Version:    0.7.0.1
 */