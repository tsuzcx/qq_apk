package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class Conversation$25
  implements Runnable
{
  Conversation$25(Conversation paramConversation) {}
  
  public void run()
  {
    int i = QZoneReport.a();
    Object localObject;
    try
    {
      MqqHandler localMqqHandler = this.this$0.A;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e("Q.recent", 1, localNullPointerException, new Object[0]);
      localObject = null;
    }
    if ((i >= 0) && (localObject != null))
    {
      localObject.removeMessages(1134061);
      localObject.sendEmptyMessageDelayed(1134061, i * 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.25
 * JD-Core Version:    0.7.0.1
 */