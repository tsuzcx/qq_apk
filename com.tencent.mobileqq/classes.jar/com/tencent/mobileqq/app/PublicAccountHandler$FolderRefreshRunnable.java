package com.tencent.mobileqq.app;

import ajoy;
import mqq.util.WeakReference;
import ogy;
import rol;
import rqn;

class PublicAccountHandler$FolderRefreshRunnable
  implements Runnable
{
  private final WeakReference<QQAppInterface> a;
  private final WeakReference<ajoy> b;
  
  public PublicAccountHandler$FolderRefreshRunnable(QQAppInterface paramQQAppInterface, ajoy paramajoy)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramajoy);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    ajoy localajoy = (ajoy)this.b.get();
    if ((localObject != null) && (localajoy != null))
    {
      rqn.a().a((QQAppInterface)localObject, localajoy.a());
      rol.a().c((QQAppInterface)localObject);
      rqn.a().g((QQAppInterface)localObject);
      localObject = ogy.a();
      if (localObject != null) {
        ((ogy)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.FolderRefreshRunnable
 * JD-Core Version:    0.7.0.1
 */