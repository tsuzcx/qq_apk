package com.tencent.mobileqq.app;

import aody;
import mqq.util.WeakReference;
import pfa;
import tug;
import twk;

class PublicAccountHandler$FolderRefreshRunnable
  implements Runnable
{
  private final WeakReference<QQAppInterface> a;
  private final WeakReference<aody> b;
  
  public PublicAccountHandler$FolderRefreshRunnable(QQAppInterface paramQQAppInterface, aody paramaody)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramaody);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    aody localaody = (aody)this.b.get();
    if ((localObject != null) && (localaody != null))
    {
      twk.a().a((QQAppInterface)localObject, localaody.a());
      tug.a().c((QQAppInterface)localObject);
      twk.a().g((QQAppInterface)localObject);
      localObject = pfa.a();
      if (localObject != null) {
        ((pfa)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.FolderRefreshRunnable
 * JD-Core Version:    0.7.0.1
 */