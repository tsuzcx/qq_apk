package com.tencent.biz.pubaccount.readinjoySearch;

import aukm;
import aukn;
import auko;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ReadInJoyNewSearchActivity$3
  implements Runnable
{
  ReadInJoyNewSearchActivity$3(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity, String paramString) {}
  
  public void run()
  {
    aukn localaukn = this.this$0.app.getEntityManagerFactory().createEntityManager();
    List localList = localaukn.a(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    ReadInJoySearchHistoryEntity localReadInJoySearchHistoryEntity;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        localReadInJoySearchHistoryEntity = (ReadInJoySearchHistoryEntity)localIterator.next();
        if (localReadInJoySearchHistoryEntity.keyWord.equals(this.a)) {
          localaukn.b(localReadInJoySearchHistoryEntity);
        }
      }
    }
    for (;;)
    {
      if (localReadInJoySearchHistoryEntity != null) {
        localList.remove(localReadInJoySearchHistoryEntity);
      }
      if (localList.size() == 20)
      {
        localaukn.b((aukm)localList.get(localList.size() - 1));
        localList.remove(localList.size() - 1);
      }
      for (;;)
      {
        localReadInJoySearchHistoryEntity = new ReadInJoySearchHistoryEntity();
        localReadInJoySearchHistoryEntity.keyWord = this.a;
        localReadInJoySearchHistoryEntity.timestamp = System.currentTimeMillis();
        localaukn.a(localReadInJoySearchHistoryEntity);
        localaukn.a();
        return;
        new ArrayList();
      }
      localReadInJoySearchHistoryEntity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.3
 * JD-Core Version:    0.7.0.1
 */