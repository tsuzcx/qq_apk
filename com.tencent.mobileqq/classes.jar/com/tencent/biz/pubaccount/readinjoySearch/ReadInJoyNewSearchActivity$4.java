package com.tencent.biz.pubaccount.readinjoySearch;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyNewSearchActivity$4
  implements Runnable
{
  ReadInJoyNewSearchActivity$4(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0.app.getEntityManagerFactory().createEntityManager();
    List localList = ((EntityManager)localObject).query(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Message localMessage = this.this$0.a.obtainMessage(1);
    localMessage.obj = localList;
    this.this$0.a.sendMessage(localMessage);
    ((EntityManager)localObject).close();
    if (localList != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("lookupHistory size: ");
        ((StringBuilder)localObject).append(localList.size());
        QLog.d("ReadInJoyNewSearchActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewSearchActivity", 2, "history is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.4
 * JD-Core Version:    0.7.0.1
 */