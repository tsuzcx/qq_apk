package com.tencent.mobileqq.activity.aio.upcoming;

import aimx;
import aini;
import android.os.Message;
import bcst;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.os.MqqHandler;

public class AIOUpComingMsgHelper$1
  implements Runnable
{
  public AIOUpComingMsgHelper$1(aimx paramaimx, long paramLong) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = aimx.a(this.this$0).a().b(aimx.a(this.this$0).jdField_a_of_type_JavaLangString, aimx.a(this.this$0).jdField_a_of_type_Int, this.a);
    if (!aini.a(localMessageRecord)) {
      localMessageRecord = null;
    }
    for (;;)
    {
      if (localMessageRecord == null) {
        bcst.b(null, "dc00898", "", "", "0X800AE94", "0X800AE94", 0, 0, "", "", "", "");
      }
      Message localMessage = aimx.a(this.this$0).obtainMessage();
      localMessage.what = 1;
      localMessage.obj = localMessageRecord;
      aimx.a(this.this$0).sendMessage(localMessage);
      aimx.a(this.this$0, aimx.a(this.this$0).jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */