package com.tencent.mobileqq.activity.aio.upcoming;

import ahrg;
import ahrr;
import android.os.Message;
import bcef;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.os.MqqHandler;

public class AIOUpComingMsgHelper$1
  implements Runnable
{
  public AIOUpComingMsgHelper$1(ahrg paramahrg, long paramLong) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = ahrg.a(this.this$0).getMessageFacade().queryMsgItemByUniseq(ahrg.a(this.this$0).curFriendUin, ahrg.a(this.this$0).curType, this.a);
    if (!ahrr.a(localMessageRecord)) {
      localMessageRecord = null;
    }
    for (;;)
    {
      if (localMessageRecord == null) {
        bcef.b(null, "dc00898", "", "", "0X800AE94", "0X800AE94", 0, 0, "", "", "", "");
      }
      Message localMessage = ahrg.a(this.this$0).obtainMessage();
      localMessage.what = 1;
      localMessage.obj = localMessageRecord;
      ahrg.a(this.this$0).sendMessage(localMessage);
      ahrg.a(this.this$0, ahrg.a(this.this$0).curFriendUin);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */