package com.tencent.mobileqq.apollo;

import amsx;
import anlp;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ApolloManager$9
  implements Runnable
{
  public ApolloManager$9(amsx paramamsx, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    try
    {
      if ((this.a.jdField_a_of_type_Int == 0) && (this.this$0.a != null)) {
        amsx.a(this.this$0.a, this.a.jdField_a_of_type_JavaLangString, "C2CAIO");
      }
      for (;;)
      {
        anlp.a().a(this.this$0.a, this.a);
        return;
        if ((this.a.jdField_a_of_type_Int == 1) && (this.this$0.a != null)) {
          ((amsx)this.this$0.a.getManager(153)).g();
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