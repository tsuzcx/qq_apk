package com.tencent.mobileqq.app;

import alzl;
import mqq.util.WeakReference;
import owy;
import ssp;
import suv;

class PublicAccountHandler$FolderRefreshRunnable
  implements Runnable
{
  private final WeakReference<QQAppInterface> a;
  private final WeakReference<alzl> b;
  
  public PublicAccountHandler$FolderRefreshRunnable(QQAppInterface paramQQAppInterface, alzl paramalzl)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramalzl);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    alzl localalzl = (alzl)this.b.get();
    if ((localObject != null) && (localalzl != null))
    {
      suv.a().a((QQAppInterface)localObject, localalzl.a());
      ssp.a().c((QQAppInterface)localObject);
      suv.a().g((QQAppInterface)localObject);
      localObject = owy.a();
      if (localObject != null) {
        ((owy)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.FolderRefreshRunnable
 * JD-Core Version:    0.7.0.1
 */