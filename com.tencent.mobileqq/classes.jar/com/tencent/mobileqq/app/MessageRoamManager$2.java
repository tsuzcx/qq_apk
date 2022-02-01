package com.tencent.mobileqq.app;

import android.database.SQLException;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MessageRoamManager$2
  implements Runnable
{
  MessageRoamManager$2(MessageRoamManager paramMessageRoamManager, String paramString1, String paramString2, String paramString3, Pair paramPair, long paramLong) {}
  
  public void run()
  {
    long l1;
    if (QLog.isColorLevel()) {
      l1 = SystemClock.uptimeMillis();
    } else {
      l1 = 0L;
    }
    this.this$0.b.getProxyManager().transSaveToDatabase();
    try
    {
      try
      {
        List localList1 = this.this$0.a(this.a, this.b, this.c, ((Long)this.d.first).longValue(), this.e);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label119;
      }
      catch (Exception localException)
      {
        break label130;
      }
    }
    catch (SQLException localSQLException)
    {
      label79:
      List localList2;
      Object localObject;
      Iterator localIterator;
      long l2;
      int i;
      break label79;
    }
    localList2 = ((MessageRecordEntityManager)this.this$0.b.getEntityManagerFactory().b()).query(MessageRecord.class, this.a, false, this.c, null, null, null, null, null);
    break label143;
    label119:
    QLog.e("Q.roammsg.MessageRoamManager", 1, "handlePBGetRoamMsg OutOfMemoryError ! ", localList2);
    return;
    label130:
    QLog.e("Q.roammsg.MessageRoamManager", 1, "getMessageByDay: ", localList2);
    localList2 = null;
    label143:
    if (localList2 != null)
    {
      localObject = new ArrayList(localList2.size());
      localIterator = localList2.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add((ChatMessage)localIterator.next());
      }
      this.this$0.a(23, localObject);
    }
    else
    {
      this.this$0.a(22, null);
    }
    if (QLog.isColorLevel())
    {
      l2 = SystemClock.uptimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryMessageByDayFromDB: costTime: ");
      ((StringBuilder)localObject).append(l2 - l1);
      ((StringBuilder)localObject).append(",records num: ");
      if (localList2 == null) {
        i = 0;
      } else {
        i = localList2.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("Q.roammsg.MessageRoamManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.2
 * JD-Core Version:    0.7.0.1
 */