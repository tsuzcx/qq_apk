package com.tencent.biz.pubaccount.readinjoySearch;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.Iterator;
import java.util.List;

class ReadInJoyNewSearchActivity$5$1
  implements Runnable
{
  ReadInJoyNewSearchActivity$5$1(ReadInJoyNewSearchActivity.5 param5) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a.a.app.getEntityManagerFactory().createEntityManager();
    List localList = localEntityManager.query(ReadInJoySearchHistoryEntity.class);
    if (localList == null) {
      return;
    }
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localEntityManager.remove((ReadInJoySearchHistoryEntity)((Iterator)localObject).next());
    }
    localList.clear();
    localObject = this.a.a.a.obtainMessage(1);
    ((Message)localObject).obj = localList;
    this.a.a.a.sendMessage((Message)localObject);
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.5.1
 * JD-Core Version:    0.7.0.1
 */