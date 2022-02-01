package com.tencent.mobileqq.activity.aio.tips;

import ahpw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class HongbaoKeywordGrayTips$1
  implements Runnable
{
  public HongbaoKeywordGrayTips$1(ahpw paramahpw) {}
  
  public void run()
  {
    Object localObject = ahpw.a(this.this$0).getMessageFacade().getAIOList(ahpw.a(this.this$0).curFriendUin, ahpw.a(this.this$0).curType);
    int i = ((List)localObject).size();
    if (i > 0)
    {
      localObject = (ChatMessage)((List)localObject).get(i - 1);
      if (ahpw.a(this.this$0).curType != 0) {
        break label130;
      }
      ahpw.a(this.this$0, ((ChatMessage)localObject).time);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "size : " + i + ", mLastMsgIdOrTime:" + ahpw.a(this.this$0));
      }
      return;
      label130:
      if ((ahpw.a(this.this$0).curType == 3000) || (ahpw.a(this.this$0).curType == 1)) {
        ahpw.a(this.this$0, ((ChatMessage)localObject).shmsgseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips.1
 * JD-Core Version:    0.7.0.1
 */