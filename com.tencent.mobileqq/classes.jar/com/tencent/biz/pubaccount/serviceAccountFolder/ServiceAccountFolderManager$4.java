package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ServiceAccountFolderManager$4
  implements Runnable
{
  ServiceAccountFolderManager$4(ServiceAccountFolderManager paramServiceAccountFolderManager, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(ServiceAccountFolderManager.a(this.this$0));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)localIterator.next();
      this.this$0.a(this.a, localServiceAccountFolderFeed, false);
    }
    localArrayList.clear();
    this.this$0.o(this.a);
    this.this$0.q(this.a);
    this.this$0.b(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.4
 * JD-Core Version:    0.7.0.1
 */