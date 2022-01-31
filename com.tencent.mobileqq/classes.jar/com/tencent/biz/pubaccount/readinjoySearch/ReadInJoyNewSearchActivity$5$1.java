package com.tencent.biz.pubaccount.readinjoySearch;

import android.os.Handler;
import android.os.Message;
import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import java.util.Iterator;
import java.util.List;
import rnw;

public class ReadInJoyNewSearchActivity$5$1
  implements Runnable
{
  public ReadInJoyNewSearchActivity$5$1(rnw paramrnw) {}
  
  public void run()
  {
    atmp localatmp = this.a.a.app.getEntityManagerFactory().createEntityManager();
    List localList = localatmp.a(ReadInJoySearchHistoryEntity.class);
    if (localList == null) {
      return;
    }
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localatmp.b((ReadInJoySearchHistoryEntity)((Iterator)localObject).next());
    }
    localList.clear();
    localObject = this.a.a.a.obtainMessage(1);
    ((Message)localObject).obj = localList;
    this.a.a.a.sendMessage((Message)localObject);
    localatmp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.5.1
 * JD-Core Version:    0.7.0.1
 */