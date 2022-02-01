package com.tencent.mobileqq.app;

import anrs;
import mqq.util.WeakReference;
import pmh;
import tue;
import twi;

class PublicAccountHandler$FolderRefreshRunnable
  implements Runnable
{
  private final WeakReference<QQAppInterface> a;
  private final WeakReference<anrs> b;
  
  public PublicAccountHandler$FolderRefreshRunnable(QQAppInterface paramQQAppInterface, anrs paramanrs)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramanrs);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    anrs localanrs = (anrs)this.b.get();
    if ((localObject != null) && (localanrs != null))
    {
      twi.a().a((QQAppInterface)localObject, localanrs.a());
      tue.a().c((QQAppInterface)localObject);
      twi.a().g((QQAppInterface)localObject);
      localObject = pmh.a();
      if (localObject != null) {
        ((pmh)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.FolderRefreshRunnable
 * JD-Core Version:    0.7.0.1
 */