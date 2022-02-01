package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGamePubAIOHelper$6
  implements Runnable
{
  QQGamePubAIOHelper$6(QQGamePubAIOHelper paramQQGamePubAIOHelper) {}
  
  public void run()
  {
    try
    {
      if (!QQGamePubAIOHelper.a(this.this$0)) {
        return;
      }
      long l = System.currentTimeMillis();
      List localList = QQGamePubAIOHelper.a(this.this$0).getMessageFacade().a(QQGamePubAIOHelper.a(this.this$0).jdField_a_of_type_JavaLangString, QQGamePubAIOHelper.a(this.this$0).jdField_a_of_type_Int, new int[] { -5008 }, 100);
      if (QLog.isColorLevel()) {
        QLog.i("QQGamePubAIOHelper", 2, "queryTeamMsgFromDb... query aioList- > ,cost:" + (System.currentTimeMillis() - l) + ",size:" + localList.size());
      }
      QQGamePubAIOHelper.a(this.this$0, localList);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePubAIOHelper", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.6
 * JD-Core Version:    0.7.0.1
 */