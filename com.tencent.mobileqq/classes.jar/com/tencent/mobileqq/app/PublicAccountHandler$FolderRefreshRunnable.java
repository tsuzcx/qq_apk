package com.tencent.mobileqq.app;

import aluw;
import mqq.util.WeakReference;
import owy;
import ssp;
import suv;

class PublicAccountHandler$FolderRefreshRunnable
  implements Runnable
{
  private final WeakReference<QQAppInterface> a;
  private final WeakReference<aluw> b;
  
  public PublicAccountHandler$FolderRefreshRunnable(QQAppInterface paramQQAppInterface, aluw paramaluw)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramaluw);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    aluw localaluw = (aluw)this.b.get();
    if ((localObject != null) && (localaluw != null))
    {
      suv.a().a((QQAppInterface)localObject, localaluw.a());
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