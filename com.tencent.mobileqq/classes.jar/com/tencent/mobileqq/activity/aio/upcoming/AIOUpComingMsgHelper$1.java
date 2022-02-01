package com.tencent.mobileqq.activity.aio.upcoming;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.os.MqqHandler;

class AIOUpComingMsgHelper$1
  implements Runnable
{
  AIOUpComingMsgHelper$1(AIOUpComingMsgHelper paramAIOUpComingMsgHelper, long paramLong) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = AIOUpComingMsgHelper.a(this.this$0).getMessageFacade().b(AIOUpComingMsgHelper.a(this.this$0).jdField_a_of_type_JavaLangString, AIOUpComingMsgHelper.a(this.this$0).jdField_a_of_type_Int, this.a);
    if (!UpComingMsgUtil.a(localMessageRecord)) {
      localMessageRecord = null;
    }
    for (;;)
    {
      if (localMessageRecord == null) {
        ReportController.b(null, "dc00898", "", "", "0X800AE94", "0X800AE94", 0, 0, "", "", "", "");
      }
      Message localMessage = AIOUpComingMsgHelper.a(this.this$0).obtainMessage();
      localMessage.what = 1;
      localMessage.obj = localMessageRecord;
      AIOUpComingMsgHelper.a(this.this$0).sendMessage(localMessage);
      AIOUpComingMsgHelper.a(this.this$0, AIOUpComingMsgHelper.a(this.this$0).jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */