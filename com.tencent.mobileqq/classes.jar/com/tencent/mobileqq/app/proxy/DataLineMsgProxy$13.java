package com.tencent.mobileqq.app.proxy;

import amjd;
import amje;
import android.os.Handler;
import android.os.Looper;
import awbw;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import java.util.List;

public class DataLineMsgProxy$13
  implements Runnable
{
  public DataLineMsgProxy$13(amjd paramamjd, long paramLong, int paramInt, amje paramamje) {}
  
  public void run()
  {
    awbw localawbw = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (amjd.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager, this.this$0.jdField_a_of_type_JavaLangString)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(localawbw);
    }
    List localList = localawbw.a(DataLineMsgRecord.class, amjd.a(this.this$0, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int), new String[] { String.valueOf(this.jdField_a_of_type_Long) });
    localawbw.a();
    new Handler(Looper.getMainLooper()).post(new DataLineMsgProxy.13.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.13
 * JD-Core Version:    0.7.0.1
 */