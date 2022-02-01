package com.tencent.av.utils;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.utils.ProcessUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;

final class VideoMsgTools$2
  implements Runnable
{
  VideoMsgTools$2(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean1, String paramString1, String paramString2, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addMessage");
    }
    if ((ProcessUtil.a(this.a.getApp())) && (!QQUtils.a(this.a.getApp())))
    {
      QQMessageFacade localQQMessageFacade = this.a.getMessageFacade();
      if (localQQMessageFacade != null)
      {
        MessageRecord localMessageRecord = this.b;
        if ((localMessageRecord != null) && (!TextUtils.isEmpty(localMessageRecord.frienduin))) {
          localQQMessageFacade.a(this.b, this.d);
        }
      }
    }
    else
    {
      this.a.getMsgHandler().a(this.b, this.c);
    }
    if (!TextUtils.isEmpty(this.e)) {
      CUOpenCardGuideMng.a(this.a, this.b.frienduin, this.f, this.g, "qav");
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addMessage end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.2
 * JD-Core Version:    0.7.0.1
 */