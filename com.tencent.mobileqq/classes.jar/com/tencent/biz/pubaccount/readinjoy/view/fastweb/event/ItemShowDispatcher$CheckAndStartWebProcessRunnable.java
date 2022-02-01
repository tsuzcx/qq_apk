package com.tencent.biz.pubaccount.readinjoy.view.fastweb.event;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ItemShowDispatcher$CheckAndStartWebProcessRunnable
  implements Runnable
{
  private WeakReference<QQAppInterface> a;
  
  public ItemShowDispatcher$CheckAndStartWebProcessRunnable(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist()) {
      if (QLog.isColorLevel()) {
        QLog.d(ItemShowDispatcher.a(), 2, "checkWebProcess WebProcess Already Exist.");
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.a == null) || (this.a.get() == null));
      IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)((QQAppInterface)this.a.get()).getRuntimeService(IWebProcessManagerService.class, "");
      if (localIWebProcessManagerService != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(ItemShowDispatcher.a(), 2, "checkWebProcess start preload web process");
        }
        localIWebProcessManagerService.startWebProcess(-1, null);
      }
    } while (!QLog.isColorLevel());
    QLog.d(ItemShowDispatcher.a(), 2, "checkWebProcess enter preload web process");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher.CheckAndStartWebProcessRunnable
 * JD-Core Version:    0.7.0.1
 */