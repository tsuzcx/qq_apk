package com.tencent.mobileqq.app.proxy;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.List;
import mqq.app.AppRuntime;

class DataLineMsgProxy$13
  implements Runnable
{
  DataLineMsgProxy$13(DataLineMsgProxy paramDataLineMsgProxy, long paramLong, int paramInt, DataLineMsgProxy.LoadMoreAioMessageCb paramLoadMoreAioMessageCb) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
    if (DataLineMsgProxy.a(this.this$0.proxyManager, this.this$0.a)) {
      this.this$0.proxyManager.transSaveToDatabase(localEntityManager);
    }
    List localList = localEntityManager.rawQuery(DataLineMsgRecord.class, DataLineMsgProxy.a(this.this$0, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int), new String[] { String.valueOf(this.jdField_a_of_type_Long) });
    localEntityManager.close();
    new Handler(Looper.getMainLooper()).post(new DataLineMsgProxy.13.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.13
 * JD-Core Version:    0.7.0.1
 */