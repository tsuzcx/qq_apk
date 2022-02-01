package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Looper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class WSPlayerForNetInfoHandler
  implements INetInfoHandler
{
  private WeakReference<WSPlayerManager> a;
  
  public WSPlayerForNetInfoHandler(WSPlayerManager paramWSPlayerManager)
  {
    this.a = new WeakReference(paramWSPlayerManager);
  }
  
  private void a()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b();
      return;
    }
    ThreadManager.getUIHandler().post(new WSPlayerForNetInfoHandler.1(this));
  }
  
  private void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleConnectNetWorkChange] thread:");
    ((StringBuilder)localObject).append(Thread.currentThread());
    WSLog.e("WSPlayerForNetInfoHandler", ((StringBuilder)localObject).toString());
    localObject = (WSPlayerManager)this.a.get();
    if ((localObject != null) && (((WSPlayerManager)localObject).r() != null))
    {
      WSPlayerParam localWSPlayerParam = ((WSPlayerManager)localObject).r();
      if ((!((WSPlayerManager)localObject).j()) && (!((WSPlayerManager)localObject).i()))
      {
        if (((WSPlayerManager)localObject).k()) {
          ((WSPlayerManager)localObject).b();
        }
      }
      else {
        ((WSPlayerManager)localObject).b(localWSPlayerParam, false);
      }
    }
  }
  
  public void onNetMobile2None()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNetMobile2None] thread:");
    localStringBuilder.append(Thread.currentThread());
    WSLog.b("WSPlayerForNetInfoHandler", localStringBuilder.toString());
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNetMobile2Wifi] s:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", thread:");
    localStringBuilder.append(Thread.currentThread());
    WSLog.b("WSPlayerForNetInfoHandler", localStringBuilder.toString());
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNetNone2Mobile] s:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", thread:");
    localStringBuilder.append(Thread.currentThread());
    WSLog.b("WSPlayerForNetInfoHandler", localStringBuilder.toString());
    a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNetNone2Wifi] s:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", thread:");
    localStringBuilder.append(Thread.currentThread());
    WSLog.b("WSPlayerForNetInfoHandler", localStringBuilder.toString());
    a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNetWifi2Mobile] s:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", thread:");
    localStringBuilder.append(Thread.currentThread());
    WSLog.b("WSPlayerForNetInfoHandler", localStringBuilder.toString());
  }
  
  public void onNetWifi2None()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNetWifi2None] thread:");
    localStringBuilder.append(Thread.currentThread());
    WSLog.b("WSPlayerForNetInfoHandler", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerForNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */