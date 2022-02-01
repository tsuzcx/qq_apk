package com.tencent.mobileqq.apollo;

import amme;
import anck;
import anhr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class ApolloManager$9
  implements Runnable
{
  public ApolloManager$9(amme paramamme, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    try
    {
      if (((this.a.curType == 0) || (anck.a(this.a.curType))) && (this.this$0.a != null)) {
        amme.a(this.this$0.a, this.a.curFriendUin, "C2CAIO");
      }
      for (;;)
      {
        anhr.a().a(this.this$0.a, this.a);
        return;
        if ((this.a.curType == 1) && (this.this$0.a != null)) {
          ((amme)this.this$0.a.getManager(QQManagerFactory.APOLLO_MANAGER)).g();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloManager", 2, "doAfterOpenAIO error", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.9
 * JD-Core Version:    0.7.0.1
 */