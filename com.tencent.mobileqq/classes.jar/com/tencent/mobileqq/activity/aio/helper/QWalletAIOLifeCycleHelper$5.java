package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class QWalletAIOLifeCycleHelper$5
  implements Runnable
{
  QWalletAIOLifeCycleHelper$5(QWalletAIOLifeCycleHelper paramQWalletAIOLifeCycleHelper, MessageRecord paramMessageRecord, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("addQQWalletTips", 2, "run()");
    }
    QWalletAIOLifeCycleHelper localQWalletAIOLifeCycleHelper = this.this$0;
    QQAppInterface localQQAppInterface = QWalletAIOLifeCycleHelper.b(localQWalletAIOLifeCycleHelper);
    MessageRecord localMessageRecord = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("“");
    localStringBuilder.append(this.b);
    localStringBuilder.append("”的读音不是“");
    localStringBuilder.append(this.a.msg);
    localStringBuilder.append("”，再想想哈~");
    localQWalletAIOLifeCycleHelper.a(localQQAppInterface, localMessageRecord, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.5
 * JD-Core Version:    0.7.0.1
 */