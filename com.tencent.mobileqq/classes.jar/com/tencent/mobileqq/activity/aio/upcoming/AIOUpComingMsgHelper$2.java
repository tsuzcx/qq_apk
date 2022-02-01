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
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMsgRevokeNotice isSuccess=");
      localStringBuilder.append(paramBoolean1);
      QLog.d("UpComingMsgLogic.AIOUpComingMsgHelper", 4, localStringBuilder.toString());
    }
    if ((paramBoolean1) && (paramList != null) && (!paramList.isEmpty())) {
      AIOUpComingMsgHelper.a(this.a, (MessageRecord)paramList.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.2
 * JD-Core Version:    0.7.0.1
 */