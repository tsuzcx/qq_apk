package com.tencent.mobileqq.app;

import akdi;
import mqq.util.WeakReference;
import osj;
import sbc;
import sdf;

class PublicAccountHandler$FolderRefreshRunnable
  implements Runnable
{
  private final WeakReference<QQAppInterface> a;
  private final WeakReference<akdi> b;
  
  public PublicAccountHandler$FolderRefreshRunnable(QQAppInterface paramQQAppInterface, akdi paramakdi)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramakdi);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    akdi localakdi = (akdi)this.b.get();
    if ((localObject != null) && (localakdi != null))
    {
      sdf.a().a((QQAppInterface)localObject, localakdi.a());
      sbc.a().c((QQAppInterface)localObject);
      sdf.a().g((QQAppInterface)localObject);
      localObject = osj.a();
      if (localObject != null) {
        ((osj)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.FolderRefreshRunnable
 * JD-Core Version:    0.7.0.1
 */