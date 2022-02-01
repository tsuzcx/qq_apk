package com.tencent.mobileqq.app;

import aoan;
import mqq.util.WeakReference;
import pvj;
import uot;
import uqx;

class PublicAccountHandler$FolderRefreshRunnable
  implements Runnable
{
  private final WeakReference<QQAppInterface> a;
  private final WeakReference<aoan> b;
  
  public PublicAccountHandler$FolderRefreshRunnable(QQAppInterface paramQQAppInterface, aoan paramaoan)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramaoan);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    aoan localaoan = (aoan)this.b.get();
    if ((localObject != null) && (localaoan != null))
    {
      uqx.a().a((QQAppInterface)localObject, localaoan.a());
      uot.a().c((QQAppInterface)localObject);
      uqx.a().g((QQAppInterface)localObject);
      localObject = pvj.a();
      if (localObject != null) {
        ((pvj)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.FolderRefreshRunnable
 * JD-Core Version:    0.7.0.1
 */