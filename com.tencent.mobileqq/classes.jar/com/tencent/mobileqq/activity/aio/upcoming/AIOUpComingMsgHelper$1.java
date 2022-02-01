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
    Object localObject2 = AIOUpComingMsgHelper.b(this.this$0).getMessageFacade().b(AIOUpComingMsgHelper.a(this.this$0).b, AIOUpComingMsgHelper.a(this.this$0).a, this.a);
    Object localObject1 = localObject2;
    if (!UpComingMsgUtil.a((MessageRecord)localObject2)) {
      localObject1 = null;
    }
    if (localObject1 == null) {
      ReportController.b(null, "dc00898", "", "", "0X800AE94", "0X800AE94", 0, 0, "", "", "", "");
    }
    localObject2 = AIOUpComingMsgHelper.c(this.this$0).obtainMessage();
    ((Message)localObject2).what = 1;
    ((Message)localObject2).obj = localObject1;
    AIOUpComingMsgHelper.c(this.this$0).sendMessage((Message)localObject2);
    localObject1 = this.this$0;
    AIOUpComingMsgHelper.a((AIOUpComingMsgHelper)localObject1, AIOUpComingMsgHelper.a((AIOUpComingMsgHelper)localObject1).b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */