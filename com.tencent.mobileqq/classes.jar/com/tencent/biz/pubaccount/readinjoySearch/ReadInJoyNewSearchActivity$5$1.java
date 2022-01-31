package com.tencent.biz.pubaccount.readinjoySearch;

import android.os.Handler;
import android.os.Message;
import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import java.util.Iterator;
import java.util.List;
import sak;

public class ReadInJoyNewSearchActivity$5$1
  implements Runnable
{
  public ReadInJoyNewSearchActivity$5$1(sak paramsak) {}
  
  public void run()
  {
    aukp localaukp = this.a.a.app.getEntityManagerFactory().createEntityManager();
    List localList = localaukp.a(ReadInJoySearchHistoryEntity.class);
    if (localList == null) {
      return;
    }
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localaukp.b((ReadInJoySearchHistoryEntity)((Iterator)localObject).next());
    }
    localList.clear();
    localObject = this.a.a.a.obtainMessage(1);
    ((Message)localObject).obj = localList;
    this.a.a.a.sendMessage((Message)localObject);
    localaukp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.5.1
 * JD-Core Version:    0.7.0.1
 */