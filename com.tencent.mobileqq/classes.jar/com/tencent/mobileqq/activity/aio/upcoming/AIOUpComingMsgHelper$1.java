package com.tencent.mobileqq.activity.aio.upcoming;

import aiwv;
import aixg;
import android.os.Message;
import bdll;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.os.MqqHandler;

public class AIOUpComingMsgHelper$1
  implements Runnable
{
  public AIOUpComingMsgHelper$1(aiwv paramaiwv, long paramLong) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = aiwv.a(this.this$0).a().b(aiwv.a(this.this$0).jdField_a_of_type_JavaLangString, aiwv.a(this.this$0).jdField_a_of_type_Int, this.a);
    if (!aixg.a(localMessageRecord)) {
      localMessageRecord = null;
    }
    for (;;)
    {
      if (localMessageRecord == null) {
        bdll.b(null, "dc00898", "", "", "0X800AE94", "0X800AE94", 0, 0, "", "", "", "");
      }
      Message localMessage = aiwv.a(this.this$0).obtainMessage();
      localMessage.what = 1;
      localMessage.obj = localMessageRecord;
      aiwv.a(this.this$0).sendMessage(localMessage);
      aiwv.a(this.this$0, aiwv.a(this.this$0).jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */