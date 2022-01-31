package com.tencent.mobileqq.app;

import aknx;
import alpu;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;

public class ClubContentUpdateHandler$1
  implements Runnable
{
  public ClubContentUpdateHandler$1(alpu paramalpu, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      aknx localaknx = (aknx)this.this$0.a.getManager(153);
      int i = ApolloUtil.a(1);
      if (i != this.jdField_a_of_type_Int) {
        localaknx.a(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ClubContentUpdateHandler.1
 * JD-Core Version:    0.7.0.1
 */