package com.tencent.mobileqq.activity.contact.addcontact;

import aeua;
import android.os.Handler;
import android.os.Message;
import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import java.util.Iterator;
import java.util.List;

public class ClassificationSearchActivity$15$1
  implements Runnable
{
  public ClassificationSearchActivity$15$1(aeua paramaeua) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.15.1
 * JD-Core Version:    0.7.0.1
 */