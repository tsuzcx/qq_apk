package com.tencent.mobileqq.activity.aio.core;

import admh;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$57
  implements Runnable
{
  BaseChatPie$57(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = admh.b(this.this$0.app, this.this$0.sessionInfo);
    if ((localMessageRecord != null) && (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
    {
      this.this$0.app.getMessageFacade().sendSpecialMessage(localMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
      if (QLog.isColorLevel()) {
        QLog.i("BabyQReportCookie", 2, "now enter the aio!!!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.57
 * JD-Core Version:    0.7.0.1
 */