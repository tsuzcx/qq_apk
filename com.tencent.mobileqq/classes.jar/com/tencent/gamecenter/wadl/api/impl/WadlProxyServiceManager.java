package com.tencent.gamecenter.wadl.api.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.api.IWadlService;
import com.tencent.gamecenter.wadl.api.IWadlService.Stub;
import com.tencent.gamecenter.wadl.api.IWadlServiceCallBack.Stub;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.biz.listener.WadlResCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class WadlProxyServiceManager
  extends IWadlServiceCallBack.Stub
  implements ServiceConnection, Handler.Callback, IBinder.DeathRecipient
{
  private final int a = 100;
  private final int b = 5000;
  private IWadlService c;
  private List<Bundle> d = new Vector();
  private Handler e;
  private CopyOnWriteArrayList<WadlProxyServiceCallBackInterface> f;
  private CopyOnWriteArrayList<WadlResCallBack> g;
  private IWadlProxyServiceMonitor h;
  private HandlerThread i = new HandlerThread("WadlClientMessage.Thread", 10);
  private volatile AtomicBoolean j = new AtomicBoolean(false);
  private volatile AtomicBoolean k = new AtomicBoolean(false);
  private int l = 0;
  
  public WadlProxyServiceManager()
  {
    this.i.start();
    this.e = new Handler(this.i.getLooper(), this);
    this.f = new CopyOnWriteArrayList();
    this.g = new CopyOnWriteArrayList();
    this.h = new WadlProxyServiceMonitor(this);
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.d.size() > 100)
    {
      QLog.w("Wadl_WadlProxyServiceManager", 1, "storeCmdToCache there must be an error too many unproceed message!");
      this.d.clear();
    }
    this.d.add(paramBundle);
  }
  
  private void d(Bundle paramBundle)
  {
    paramBundle = (WadlResult)paramBundle.getParcelable("download_result");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadActionCallback wadlResult:");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(",callBackList size=");
      ((StringBuilder)localObject).append(this.f.size());
      QLog.i("Wadl_WadlProxyServiceManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBundle != null)
    {
      localObject = this.f.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((WadlProxyServiceCallBackInterface)((Iterator)localObject).next()).a(paramBundle);
      }
    }
  }
  
  private void e()
  {
    if (!this.e.hasMessages(2)) {
      this.e.obtainMessage(2).sendToTarget();
    }
  }
  
  private void e(Bundle paramBundle)
  {
    Object localObject = paramBundle.getParcelableArrayList("query_result");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQueryCallback params:");
    localStringBuilder.append(paramBundle.toString());
    localStringBuilder.append(",callBackList size=");
    localStringBuilder.append(this.f.size());
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = new ArrayList();
    }
    localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((WadlProxyServiceCallBackInterface)((Iterator)localObject).next()).a(paramBundle);
    }
  }
  
  private void f(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQueryCallbackVia params");
    localStringBuilder.append(paramBundle.toString());
    localStringBuilder.append(",callBackList size=");
    localStringBuilder.append(this.f.size());
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    paramBundle = this.f.iterator();
    while (paramBundle.hasNext()) {
      ((WadlProxyServiceCallBackInterface)paramBundle.next()).b(localArrayList);
    }
  }
  
  private void g(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQueryAllTaskCallback params");
    localStringBuilder.append(paramBundle.toString());
    localStringBuilder.append(",callBackList size=");
    localStringBuilder.append(this.f.size());
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    paramBundle = this.f.iterator();
    while (paramBundle.hasNext()) {
      ((WadlProxyServiceCallBackInterface)paramBundle.next()).a(localArrayList);
    }
  }
  
  private void h(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQueryAllResCallback params");
    localStringBuilder.append(paramBundle.toString());
    localStringBuilder.append(",callBackList size=");
    localStringBuilder.append(this.f.size());
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    paramBundle = this.g.iterator();
    while (paramBundle.hasNext()) {
      ((WadlResCallBack)paramBundle.next()).c(localArrayList);
    }
  }
  
  private void i(Bundle paramBundle)
  {
    paramBundle = (WadlResult)paramBundle.getParcelable("download_result");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onWadlResStatusChanged params:");
    ((StringBuilder)localObject).append(paramBundle);
    ((StringBuilder)localObject).append(",callBackList size=");
    ((StringBuilder)localObject).append(this.f.size());
    QLog.i("Wadl_WadlProxyServiceManager", 1, ((StringBuilder)localObject).toString());
    if (paramBundle != null)
    {
      localObject = this.g.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((WadlResCallBack)((Iterator)localObject).next()).b(paramBundle);
      }
    }
  }
  
  protected void a()
  {
    QLog.i("Wadl_WadlProxyServiceManager", 1, "resetDiedCount");
    this.l = 0;
    this.h.a(1.0F, false);
  }
  
  public void a(int paramInt)
  {
    if (!this.e.hasMessages(1))
    {
      Message localMessage = this.e.obtainMessage(1);
      localMessage.what = paramInt;
      localMessage.sendToTarget();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send action msg cmd=");
    localStringBuilder.append(str);
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    if (!b())
    {
      QLog.w("Wadl_WadlProxyServiceManager", 1, "postRemoteNotify start but service is not launched and start service");
      b(0);
    }
    c(paramBundle);
    e();
  }
  
  public void a(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    if ((paramWadlProxyServiceCallBackInterface != null) && (!this.f.contains(paramWadlProxyServiceCallBackInterface))) {
      this.f.add(paramWadlProxyServiceCallBackInterface);
    }
  }
  
  public void a(WadlResCallBack paramWadlResCallBack)
  {
    if ((paramWadlResCallBack != null) && (!this.g.contains(paramWadlResCallBack))) {
      this.g.add(paramWadlResCallBack);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transferAsync from Service cmd=");
    localStringBuilder.append(paramString);
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    paramBundle.setClassLoader(getClass().getClassLoader());
    if (paramString != null)
    {
      if (paramString.equals("WADL.REVERSE_HEART_CMD"))
      {
        paramString = this.e.obtainMessage();
        paramString.what = 4;
        paramString.setData(paramBundle);
        this.e.sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_ACTION_CMD"))
      {
        paramString = this.e.obtainMessage();
        paramString.what = 3;
        paramString.setData(paramBundle);
        this.e.sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_STOP_MONITOR_CMD"))
      {
        paramString = this.e.obtainMessage();
        paramString.what = 5;
        paramString.setData(paramBundle);
        this.e.sendMessage(paramString);
        return;
      }
      if ((paramString.equals("WADL.REVERSE_START_MONITOR_CMD")) && (!this.e.hasMessages(6))) {
        this.e.obtainMessage(6).sendToTarget();
      }
    }
  }
  
  public void b(int paramInt)
  {
    QLog.i("Wadl_WadlProxyServiceManager", 1, "innerStartService start");
    if (this.c != null)
    {
      QLog.w("Wadl_WadlProxyServiceManager", 1, "innerStartService mWadlService is working");
      return;
    }
    if (!this.k.getAndSet(true))
    {
      try
      {
        WadlProxyService.a(this);
        if (paramInt == 1)
        {
          WadlReportInfo localWadlReportInfo = WadlReportInfo.a();
          localWadlReportInfo.e = "service dlied";
          ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportDC("204685", "999", localWadlReportInfo, "08a00036462");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Wadl_WadlProxyServiceManager", 1, "innerStartService fail", localThrowable);
        this.k.set(false);
      }
      if (this.k.get())
      {
        this.e.removeMessages(7);
        this.e.sendEmptyMessageDelayed(7, 5000L);
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("innerStartService is connecting mWadlService:");
      localStringBuilder.append(this.c);
      QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    }
  }
  
  public void b(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REVERSE_ACTION_CMD_NAME");
    if (str == null)
    {
      QLog.i("Wadl_WadlProxyServiceManager", 1, "onRemoteReverseInvoke strInvokeCmd is empty!");
      return;
    }
    try
    {
      if (str.equals("Wadl_Reverse_StartWadlService"))
      {
        a(0);
        return;
      }
      if (str.equals("Wadl_Reverse_onWadlTaskStatusChanged"))
      {
        d(paramBundle);
        return;
      }
      if (str.equals("Wadl_Reverse_QnQureyResult"))
      {
        e(paramBundle);
        return;
      }
      if (str.equals("Wadl_Reverse_QnQureyResultVia"))
      {
        f(paramBundle);
        return;
      }
      if (str.equals("Wadl_Reverse_QnQureyAllTask"))
      {
        g(paramBundle);
        return;
      }
      if (str.equals("Wadl_Reverse_QnQureyAllRes"))
      {
        h(paramBundle);
        return;
      }
      if (str.equals("Wadl_Reverse_onWadlResStatusChanged"))
      {
        i(paramBundle);
        return;
      }
      QLog.w("Wadl_WadlProxyServiceManager", 1, "onRemoteReverseInvoke unknow invokeCmd");
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("Wadl_WadlProxyServiceManager", 1, "onRemoteReverseInvoke exception", paramBundle);
    }
  }
  
  public void b(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    if (paramWadlProxyServiceCallBackInterface != null) {
      this.f.remove(paramWadlProxyServiceCallBackInterface);
    }
  }
  
  public void b(WadlResCallBack paramWadlResCallBack)
  {
    if (paramWadlResCallBack != null) {
      this.g.remove(paramWadlResCallBack);
    }
  }
  
  public boolean b()
  {
    return (this.c != null) && (!this.k.get());
  }
  
  public void binderDied()
  {
    try
    {
      this.l += 1;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("binderDied, diedCount=");
      ((StringBuilder)localObject).append(this.l);
      QLog.e("Wadl_WadlProxyServiceManager", 1, ((StringBuilder)localObject).toString());
      if (this.l > 9) {
        this.h.a(10.0F, true);
      } else if (this.l > 6) {
        this.h.a(2.0F, true);
      } else if (this.l > 3) {
        this.h.a(1.5F, true);
      } else {
        this.h.a(1.0F, true);
      }
      if (this.h.a())
      {
        localObject = WadlReportInfo.a();
        ((WadlReportInfo)localObject).e = "service dlied";
        ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportDC("204685", "444", (WadlReportInfo)localObject, "08a00036462");
        if (this.c != null)
        {
          this.c.asBinder().unlinkToDeath(this, 0);
          this.c = null;
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("Wadl_WadlProxyServiceManager", 1, "binderDied exception", localException);
    }
  }
  
  public void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendAsynRemoteCommandMessage mWadlService=");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(",mServiceConnecting=");
    ((StringBuilder)localObject).append(this.k);
    ((StringBuilder)localObject).append(",mCacheMsg size=");
    ((StringBuilder)localObject).append(this.d.size());
    QLog.i("Wadl_WadlProxyServiceManager", 1, ((StringBuilder)localObject).toString());
    if ((b()) && (!this.d.isEmpty())) {
      while (!this.d.isEmpty())
      {
        localObject = (Bundle)this.d.remove(0);
        if (localObject != null)
        {
          String str = ((Bundle)localObject).getString("WADL.REMOTE_NOTIFY_CMD_NAME");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("sendAsynRemoteCommandMessage strNotifyCmd=");
          localStringBuilder.append(str);
          localStringBuilder.append(",mWadlService=");
          localStringBuilder.append(this.c);
          QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
          try
          {
            ((Bundle)localObject).setClassLoader(getClass().getClassLoader());
            if (this.c == null) {
              continue;
            }
            this.c.a("WADL.REMOTE_ACTION_CMD", (Bundle)localObject);
          }
          catch (Exception localException) {}
          if ((localException instanceof DeadObjectException))
          {
            c((Bundle)localObject);
            QLog.i("Wadl_WadlProxyServiceManager", 1, "remote service is dead", localException);
          }
        }
      }
    }
  }
  
  public void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroy: ");
    localStringBuilder.append(this);
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    this.j.set(true);
    this.h.b();
    this.e.removeCallbacksAndMessages(null);
    try
    {
      this.f.clear();
    }
    catch (Exception localException1)
    {
      QLog.e("Wadl_WadlProxyServiceManager", 1, "destroy clear callBackList exception", localException1);
    }
    try
    {
      this.g.clear();
    }
    catch (Exception localException2)
    {
      QLog.e("Wadl_WadlProxyServiceManager", 1, "destroy clear resCallBacks exception", localException2);
    }
    try
    {
      this.i.quit();
    }
    catch (Exception localException3)
    {
      QLog.e("Wadl_WadlProxyServiceManager", 1, "destroy mMessageThread.quit exception", localException3);
    }
    IWadlService localIWadlService = this.c;
    if (localIWadlService != null)
    {
      try
      {
        localIWadlService.b(this);
        QLog.i("Wadl_WadlProxyServiceManager", 1, "destroy unregisterCallback success");
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("Wadl_WadlProxyServiceManager", 1, "destroy unregisterCallback exception", localRemoteException);
      }
      try
      {
        localIWadlService.asBinder().unlinkToDeath(this, 0);
        QLog.i("Wadl_WadlProxyServiceManager", 1, "destroy unlinkToDeath success");
      }
      catch (Exception localException4)
      {
        QLog.e("Wadl_WadlProxyServiceManager", 1, "destroy unlinkToDeath exception", localException4);
      }
      if (MobileQQ.sProcessId == 1) {
        try
        {
          MobileQQ.sMobileQQ.unbindService(this);
          QLog.i("Wadl_WadlProxyServiceManager", 1, "destroy unbindService success");
          return;
        }
        catch (Exception localException5)
        {
          QLog.e("Wadl_WadlProxyServiceManager", 1, "destroy unbindService exception", localException5);
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 7: 
      this.k.set(false);
      QLog.i("Wadl_WadlProxyServiceManager", 1, "reset mServiceConnecting");
      return false;
    case 6: 
      if (this.j.get())
      {
        this.h.b();
        return false;
      }
      this.h.c();
      return false;
    case 5: 
      this.h.b();
      return false;
    case 4: 
      this.h.a(paramMessage.getData());
      return false;
    case 3: 
      b(paramMessage.getData());
      return false;
    case 2: 
      c();
      return false;
    }
    b(paramMessage.what);
    return false;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onServiceConnected success, componentName=");
    localStringBuilder.append(paramComponentName);
    localStringBuilder.append(",service=");
    localStringBuilder.append(paramIBinder);
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    try
    {
      this.k.set(false);
      if (this.j.get())
      {
        QLog.w("Wadl_WadlProxyServiceManager", 1, "onServiceConnected,but this is destroy");
        return;
      }
      this.c = IWadlService.Stub.a(paramIBinder);
      if (this.c == null)
      {
        QLog.w("Wadl_WadlProxyServiceManager", 1, "onServiceConnected,but asInterface fail");
        return;
      }
      this.c.a(this);
      this.c.asBinder().linkToDeath(this, 0);
      e();
      return;
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
  }
  
  /* Error */
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    // Byte code:
    //   0: ldc 104
    //   2: iconst_1
    //   3: ldc_w 543
    //   6: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: getfield 94	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:h	Lcom/tencent/gamecenter/wadl/api/impl/IWadlProxyServiceMonitor;
    //   13: invokeinterface 461 1 0
    //   18: aload_0
    //   19: getfield 302	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:c	Lcom/tencent/gamecenter/wadl/api/IWadlService;
    //   22: ifnull +25 -> 47
    //   25: aload_0
    //   26: getfield 302	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:c	Lcom/tencent/gamecenter/wadl/api/IWadlService;
    //   29: aload_0
    //   30: invokeinterface 478 2 0
    //   35: goto +12 -> 47
    //   38: astore_1
    //   39: goto +22 -> 61
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 544	java/lang/Exception:printStackTrace	()V
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 302	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:c	Lcom/tencent/gamecenter/wadl/api/IWadlService;
    //   52: aload_0
    //   53: getfield 55	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   56: iconst_0
    //   57: invokevirtual 349	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   60: return
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 302	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:c	Lcom/tencent/gamecenter/wadl/api/IWadlService;
    //   66: aload_0
    //   67: getfield 55	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   70: iconst_0
    //   71: invokevirtual 349	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	WadlProxyServiceManager
    //   0	76	1	paramComponentName	ComponentName
    // Exception table:
    //   from	to	target	type
    //   9	35	38	finally
    //   43	47	38	finally
    //   9	35	42	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.WadlProxyServiceManager
 * JD-Core Version:    0.7.0.1
 */