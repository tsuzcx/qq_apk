package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGamePubAIOHelper$7
  implements Runnable
{
  QQGamePubAIOHelper$7(QQGamePubAIOHelper paramQQGamePubAIOHelper) {}
  
  public void run()
  {
    try
    {
      if (!QQGamePubAIOHelper.a(this.this$0)) {
        return;
      }
      long l = System.currentTimeMillis();
      List localList = QQGamePubAIOHelper.a(this.this$0).getMessageFacade().a(QQGamePubAIOHelper.a(this.this$0).jdField_a_of_type_JavaLangString, QQGamePubAIOHelper.a(this.this$0).jdField_a_of_type_Int, new int[] { -5008 }, 100);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryTeamMsgFromDb... query aioList- > ,cost:");
        localStringBuilder.append(System.currentTimeMillis() - l);
        localStringBuilder.append(",size:");
        localStringBuilder.append(localList.size());
        QLog.i("QQGamePub_QQGamePubAIOHelper", 2, localStringBuilder.toString());
      }
      QQGamePubAIOHelper.a(this.this$0, localList);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_QQGamePubAIOHelper", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.7
 * JD-Core Version:    0.7.0.1
 */