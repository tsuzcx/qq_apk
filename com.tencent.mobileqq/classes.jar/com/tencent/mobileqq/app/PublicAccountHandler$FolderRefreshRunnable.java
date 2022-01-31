package com.tencent.mobileqq.app;

import akdh;
import mqq.util.WeakReference;
import osg;
import saz;
import sdc;

class PublicAccountHandler$FolderRefreshRunnable
  implements Runnable
{
  private final WeakReference<QQAppInterface> a;
  private final WeakReference<akdh> b;
  
  public PublicAccountHandler$FolderRefreshRunnable(QQAppInterface paramQQAppInterface, akdh paramakdh)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramakdh);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    akdh localakdh = (akdh)this.b.get();
    if ((localObject != null) && (localakdh != null))
    {
      sdc.a().a((QQAppInterface)localObject, localakdh.a());
      saz.a().c((QQAppInterface)localObject);
      sdc.a().g((QQAppInterface)localObject);
      localObject = osg.a();
      if (localObject != null) {
        ((osg)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.FolderRefreshRunnable
 * JD-Core Version:    0.7.0.1
 */