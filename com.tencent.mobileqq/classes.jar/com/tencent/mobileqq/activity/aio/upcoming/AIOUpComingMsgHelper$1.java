package com.tencent.mobileqq.activity.aio.upcoming;

import aimf;
import aimq;
import android.os.Message;
import bdla;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.os.MqqHandler;

public class AIOUpComingMsgHelper$1
  implements Runnable
{
  public AIOUpComingMsgHelper$1(aimf paramaimf, long paramLong) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = aimf.a(this.this$0).getMessageFacade().queryMsgItemByUniseq(aimf.a(this.this$0).curFriendUin, aimf.a(this.this$0).curType, this.a);
    if (!aimq.a(localMessageRecord)) {
      localMessageRecord = null;
    }
    for (;;)
    {
      if (localMessageRecord == null) {
        bdla.b(null, "dc00898", "", "", "0X800AE94", "0X800AE94", 0, 0, "", "", "", "");
      }
      Message localMessage = aimf.a(this.this$0).obtainMessage();
      localMessage.what = 1;
      localMessage.obj = localMessageRecord;
      aimf.a(this.this$0).sendMessage(localMessage);
      aimf.a(this.this$0, aimf.a(this.this$0).curFriendUin);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */