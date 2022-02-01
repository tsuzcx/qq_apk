package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.ArrayList;
import java.util.List;

class StrangerHandler$1
  implements Runnable
{
  StrangerHandler$1(StrangerHandler paramStrangerHandler) {}
  
  public void run()
  {
    Object localObject = StrangerHandler.a(this.this$0).getEntityManagerFactory().createEntityManager();
    List localList = ((EntityManager)localObject).query(Stranger.class);
    ((EntityManager)localObject).close();
    localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    this.this$0.notifyUI(3, true, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.StrangerHandler.1
 * JD-Core Version:    0.7.0.1
 */