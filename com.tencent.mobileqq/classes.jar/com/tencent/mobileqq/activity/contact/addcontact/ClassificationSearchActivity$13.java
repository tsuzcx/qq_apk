package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ClassificationSearchActivity$13
  implements Runnable
{
  ClassificationSearchActivity$13(ClassificationSearchActivity paramClassificationSearchActivity, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
    Object localObject2 = localEntityManager.query(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Object localObject1;
    if (localObject2 != null)
    {
      Object localObject3 = null;
      Iterator localIterator = ((List)localObject2).iterator();
      do
      {
        localObject1 = localObject3;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (ReadInJoySearchHistoryEntity)localIterator.next();
      } while (!((ReadInJoySearchHistoryEntity)localObject1).keyWord.equals(this.a));
      localEntityManager.remove((Entity)localObject1);
      if (localObject1 != null) {
        ((List)localObject2).remove(localObject1);
      }
      localObject1 = localObject2;
      if (((List)localObject2).size() == 20)
      {
        localEntityManager.remove((Entity)((List)localObject2).get(((List)localObject2).size() - 1));
        ((List)localObject2).remove(((List)localObject2).size() - 1);
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = new ArrayList();
    }
    localObject2 = new ReadInJoySearchHistoryEntity();
    ((ReadInJoySearchHistoryEntity)localObject2).keyWord = this.a;
    ((ReadInJoySearchHistoryEntity)localObject2).timestamp = System.currentTimeMillis();
    localEntityManager.persist((Entity)localObject2);
    ((List)localObject1).add(0, localObject2);
    localEntityManager.close();
    localObject2 = this.this$0.A.obtainMessage(1);
    ((Message)localObject2).obj = localObject1;
    this.this$0.A.sendMessage((Message)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.13
 * JD-Core Version:    0.7.0.1
 */