package com.tencent.biz.pubaccount.readinjoySearch;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ReadInJoyNewSearchActivity$3
  implements Runnable
{
  ReadInJoyNewSearchActivity$3(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
    List localList = localEntityManager.query(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    if (localList != null)
    {
      Object localObject2 = null;
      Iterator localIterator = localList.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (ReadInJoySearchHistoryEntity)localIterator.next();
      } while (!((ReadInJoySearchHistoryEntity)localObject1).keyWord.equals(this.a));
      localEntityManager.remove((Entity)localObject1);
      if (localObject1 != null) {
        localList.remove(localObject1);
      }
      if (localList.size() == 20)
      {
        localEntityManager.remove((Entity)localList.get(localList.size() - 1));
        localList.remove(localList.size() - 1);
      }
    }
    else
    {
      new ArrayList();
    }
    Object localObject1 = new ReadInJoySearchHistoryEntity();
    ((ReadInJoySearchHistoryEntity)localObject1).keyWord = this.a;
    ((ReadInJoySearchHistoryEntity)localObject1).timestamp = System.currentTimeMillis();
    localEntityManager.persist((Entity)localObject1);
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.3
 * JD-Core Version:    0.7.0.1
 */