package com.tencent.mobileqq.app;

import amme;
import anrv;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;

public class ClubContentUpdateHandler$1
  implements Runnable
{
  public ClubContentUpdateHandler$1(anrv paramanrv, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      amme localamme = (amme)this.this$0.a.getManager(QQManagerFactory.APOLLO_MANAGER);
      int i = ApolloUtil.a(1);
      if (i != this.jdField_a_of_type_Int) {
        localamme.a(1);
      }
      QLog.i("ClubContentUpdateHandler", 1, "handleApolloPanelRelTimeUpdate name: " + this.jdField_a_of_type_JavaLangString + ", ver: " + this.jdField_a_of_type_Int + ", locver: " + i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ClubContentUpdateHandler", 1, "handleApolloPanelRealTimeUpdate failed" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ClubContentUpdateHandler.1
 * JD-Core Version:    0.7.0.1
 */