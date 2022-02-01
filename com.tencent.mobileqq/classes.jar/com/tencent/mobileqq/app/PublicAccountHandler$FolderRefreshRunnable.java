package com.tencent.mobileqq.app;

import amxz;
import mqq.util.WeakReference;
import pkm;
import uaw;
import uda;

class PublicAccountHandler$FolderRefreshRunnable
  implements Runnable
{
  private final WeakReference<QQAppInterface> a;
  private final WeakReference<amxz> b;
  
  public PublicAccountHandler$FolderRefreshRunnable(QQAppInterface paramQQAppInterface, amxz paramamxz)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramamxz);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    amxz localamxz = (amxz)this.b.get();
    if ((localObject != null) && (localamxz != null))
    {
      uda.a().a((QQAppInterface)localObject, localamxz.a());
      uaw.a().c((QQAppInterface)localObject);
      uda.a().g((QQAppInterface)localObject);
      localObject = pkm.a();
      if (localObject != null) {
        ((pkm)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.FolderRefreshRunnable
 * JD-Core Version:    0.7.0.1
 */