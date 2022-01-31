package com.tencent.mobileqq.app.proxy;

import aken;
import akeo;
import android.os.Handler;
import android.os.Looper;
import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import java.util.List;

public class DataLineMsgProxy$13
  implements Runnable
{
  public DataLineMsgProxy$13(aken paramaken, long paramLong, int paramInt, akeo paramakeo) {}
  
  public void run()
  {
    atmp localatmp = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (aken.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager, this.this$0.jdField_a_of_type_JavaLangString)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(localatmp);
    }
    List localList = localatmp.a(DataLineMsgRecord.class, aken.a(this.this$0, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int), new String[] { String.valueOf(this.jdField_a_of_type_Long) });
    localatmp.a();
    new Handler(Looper.getMainLooper()).post(new DataLineMsgProxy.13.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.13
 * JD-Core Version:    0.7.0.1
 */