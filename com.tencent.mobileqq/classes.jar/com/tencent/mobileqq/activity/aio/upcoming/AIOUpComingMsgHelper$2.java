package com.tencent.mobileqq.activity.aio.upcoming;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AIOUpComingMsgHelper$2
  extends MessageObserver
{
  AIOUpComingMsgHelper$2(AIOUpComingMsgHelper paramAIOUpComingMsgHelper) {}
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.AIOUpComingMsgHelper", 4, "onMsgRevokeNotice isSuccess=" + paramBoolean1);
    }
    if ((paramBoolean1) && (paramList != null) && (!paramList.isEmpty())) {
      AIOUpComingMsgHelper.a(this.a, (MessageRecord)paramList.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.2
 * JD-Core Version:    0.7.0.1
 */