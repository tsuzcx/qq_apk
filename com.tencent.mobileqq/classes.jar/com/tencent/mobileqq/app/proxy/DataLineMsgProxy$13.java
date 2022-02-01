package com.tencent.mobileqq.app.proxy;

import android.os.Handler;
import android.os.Looper;
import apas;
import apat;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class DataLineMsgProxy$13
  implements Runnable
{
  public DataLineMsgProxy$13(apas paramapas, long paramLong, int paramInt, apat paramapat) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (apas.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager, this.this$0.jdField_a_of_type_JavaLangString)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(localEntityManager);
    }
    List localList = localEntityManager.rawQuery(DataLineMsgRecord.class, apas.a(this.this$0, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int), new String[] { String.valueOf(this.jdField_a_of_type_Long) });
    localEntityManager.close();
    new Handler(Looper.getMainLooper()).post(new DataLineMsgProxy.13.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.13
 * JD-Core Version:    0.7.0.1
 */