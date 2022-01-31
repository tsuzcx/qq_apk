package com.tencent.mobileqq.app;

import ajso;
import atmp;
import atmq;
import com.tencent.mobileqq.data.Stranger;
import java.util.ArrayList;
import java.util.List;

public class StrangerHandler$1
  implements Runnable
{
  public StrangerHandler$1(ajso paramajso) {}
  
  public void run()
  {
    Object localObject = this.this$0.app.getEntityManagerFactory().createEntityManager();
    List localList = ((atmp)localObject).a(Stranger.class);
    ((atmp)localObject).a();
    localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    this.this$0.notifyUI(3, true, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.StrangerHandler.1
 * JD-Core Version:    0.7.0.1
 */