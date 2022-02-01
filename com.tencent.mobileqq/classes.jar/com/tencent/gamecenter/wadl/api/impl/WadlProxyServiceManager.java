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
import com.tencent.gamecenter.wadl.util.WLog;
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
  private final int jdField_a_of_type_Int = 100;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("WadlClientMessage.Thread", 10);
  private IWadlService jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService;
  private IWadlProxyServiceMonitor jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor;
  private List<Bundle> jdField_a_of_type_JavaUtilList = new Vector();
  private CopyOnWriteArrayList<WadlProxyServiceCallBackInterface> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final int jdField_b_of_type_Int = 5000;
  private CopyOnWriteArrayList<WadlResCallBack> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private volatile AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int c = 0;
  
  public WadlProxyServiceManager()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor = new WadlProxyServiceMonitor(this);
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 100)
    {
      WLog.a("WadlProxyServiceManager", "storeCmdToCache there must be an error too many unproceed message!");
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBundle);
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2).sendToTarget();
    }
  }
  
  private void d(Bundle paramBundle)
  {
    paramBundle = (WadlResult)paramBundle.getParcelable("download_result");
    WLog.c("WadlProxyServiceManager", "downloadActionCallback params:" + paramBundle + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    if (paramBundle != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((WadlProxyServiceCallBackInterface)localIterator.next()).onWadlTaskStatusChanged(paramBundle);
      }
    }
  }
  
  private void e(Bundle paramBundle)
  {
    Object localObject = paramBundle.getParcelableArrayList("query_result");
    WLog.c("WadlProxyServiceManager", "onQueryCallback params:" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    if (localObject == null) {}
    for (paramBundle = new ArrayList();; paramBundle = (Bundle)localObject)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((WadlProxyServiceCallBackInterface)((Iterator)localObject).next()).onQueryCallback(paramBundle);
      }
      return;
    }
  }
  
  private void f(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
    WLog.c("WadlProxyServiceManager", "onQueryCallbackVia params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramBundle.hasNext()) {
      ((WadlProxyServiceCallBackInterface)paramBundle.next()).onQueryCallbackVia(localArrayList);
    }
  }
  
  private void g(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
    WLog.c("WadlProxyServiceManager", "onQueryAllTaskCallback params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramBundle.hasNext()) {
      ((WadlProxyServiceCallBackInterface)paramBundle.next()).onQueryCallback(localArrayList);
    }
  }
  
  private void h(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
    WLog.c("WadlProxyServiceManager", "onQueryAllResCallback params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    paramBundle = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramBundle.hasNext()) {
      ((WadlResCallBack)paramBundle.next()).a(localArrayList);
    }
  }
  
  private void i(Bundle paramBundle)
  {
    paramBundle = (WadlResult)paramBundle.getParcelable("download_result");
    WLog.c("WadlProxyServiceManager", "onWadlResStatusChanged params:" + paramBundle + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    if (paramBundle != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((WadlResCallBack)localIterator.next()).a(paramBundle);
      }
    }
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      WLog.c("WadlProxyServiceManager", "resetDiedCount");
    }
    this.c = 0;
    this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a(1.0F, false);
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      localMessage.what = paramInt;
      localMessage.sendToTarget();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
    WLog.c("WadlProxyServiceManager", "send action msg cmd=" + str);
    if (!a())
    {
      WLog.a("WadlProxyServiceManager", "postRemoteNotify start but service is not launched and start service");
      b(0);
    }
    c(paramBundle);
    d();
  }
  
  public void a(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    if ((paramWadlProxyServiceCallBackInterface != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramWadlProxyServiceCallBackInterface))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramWadlProxyServiceCallBackInterface);
    }
  }
  
  public void a(WadlResCallBack paramWadlResCallBack)
  {
    if ((paramWadlResCallBack != null) && (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramWadlResCallBack))) {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramWadlResCallBack);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      WLog.c("WadlProxyServiceManager", "transferAsync from Service cmd=" + paramString);
    }
    paramBundle.setClassLoader(getClass().getClassLoader());
    if (paramString != null)
    {
      if (!paramString.equals("WADL.REVERSE_HEART_CMD")) {
        break label84;
      }
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 4;
      paramString.setData(paramBundle);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    }
    label84:
    do
    {
      return;
      if (paramString.equals("WADL.REVERSE_ACTION_CMD"))
      {
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString.what = 3;
        paramString.setData(paramBundle);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_STOP_MONITOR_CMD"))
      {
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString.what = 5;
        paramString.setData(paramBundle);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        return;
      }
    } while ((!paramString.equals("WADL.REVERSE_START_MONITOR_CMD")) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(6)));
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6).sendToTarget();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService != null) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      WLog.c("WadlProxyServiceManager", "sendAsynRemoteCommandMessage mWadlService=" + this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService + ",mServiceConnecting=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean + ",mCacheMsg size=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    if ((a()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      while (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        Bundle localBundle = (Bundle)this.jdField_a_of_type_JavaUtilList.remove(0);
        if (localBundle != null)
        {
          String str = localBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
          if (QLog.isColorLevel()) {
            WLog.c("WadlProxyServiceManager", "##@sendAsynRemoteCommandMessage strNotifyCmd=" + str);
          }
          try
          {
            localBundle.setClassLoader(getClass().getClassLoader());
            if (this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService == null) {
              continue;
            }
            WLog.c("WadlProxyServiceManager", "send action to service cmd=" + str);
            this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService.a("WADL.REMOTE_ACTION_CMD", localBundle);
          }
          catch (Exception localException) {}
          if ((localException instanceof DeadObjectException))
          {
            c(localBundle);
            WLog.b("WadlProxyServiceManager", "remote service is dead", localException);
          }
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    WLog.c("WadlProxyServiceManager", "innerStartService start");
    if (this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService != null) {
      if (QLog.isColorLevel()) {
        WLog.b("WadlProxyServiceManager", "innerStartService mWadlService is working");
      }
    }
    do
    {
      return;
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
        break label139;
      }
      try
      {
        WadlProxyService.a(this);
        if (paramInt == 1)
        {
          WadlReportInfo localWadlReportInfo = WadlReportInfo.a();
          localWadlReportInfo.c = "service dlied";
          ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportDC("204685", "999", localWadlReportInfo, "08a00036462");
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          WLog.b("WadlProxyServiceManager", "innerStartService fail", localThrowable);
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        }
      }
    } while (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 5000L);
    return;
    label139:
    WLog.c("WadlProxyServiceManager", "innerStartService is connecting mWadlService:" + this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService);
  }
  
  public void b(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REVERSE_ACTION_CMD_NAME");
    if (QLog.isColorLevel()) {
      WLog.c("WadlProxyServiceManager", "onRemoteReverseInvoke begin cmd=" + str);
    }
    if (str == null) {
      return;
    }
    try
    {
      if (str.equals("Wadl_Reverse_StartWadlService"))
      {
        a(0);
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      WLog.a("WadlProxyServiceManager", "onRemoteReverseInvoke exception", paramBundle);
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
    WLog.a("WadlProxyServiceManager", "onRemoteReverseInvoke unknow invokeCmd");
  }
  
  public void b(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    if (paramWadlProxyServiceCallBackInterface != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramWadlProxyServiceCallBackInterface);
    }
  }
  
  public void b(WadlResCallBack paramWadlResCallBack)
  {
    if (paramWadlResCallBack != null) {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramWadlResCallBack);
    }
  }
  
  public void binderDied()
  {
    for (;;)
    {
      try
      {
        this.c += 1;
        WLog.a("WadlProxyServiceManager", "binderDied, diedCount=" + this.c);
        if (this.c > 9)
        {
          this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a(10.0F, true);
          if (!this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a()) {
            break;
          }
          WadlReportInfo localWadlReportInfo = WadlReportInfo.a();
          localWadlReportInfo.c = "service dlied";
          ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportDC("204685", "444", localWadlReportInfo, "08a00036462");
          if (this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService.asBinder().unlinkToDeath(this, 0);
          this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService = null;
          return;
        }
        if (this.c > 6)
        {
          this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a(2.0F, true);
          continue;
        }
        if (this.c <= 3) {
          break label195;
        }
      }
      catch (Exception localException)
      {
        WLog.a("WadlProxyServiceManager", "binderDied exception", localException);
        return;
      }
      this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a(1.5F, true);
      continue;
      label195:
      this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a(1.0F, true);
    }
  }
  
  public void c()
  {
    WLog.c("WadlProxyServiceManager", "destroy: " + this);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    catch (Exception localRemoteException)
    {
      try
      {
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      }
      catch (Exception localRemoteException)
      {
        try
        {
          this.jdField_a_of_type_AndroidOsHandlerThread.quit();
          localIWadlService = this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService;
          if (localIWadlService == null) {}
        }
        catch (Exception localRemoteException)
        {
          try
          {
            localIWadlService.b(this);
            WLog.c("WadlProxyServiceManager", "destroy unregisterCallback success");
          }
          catch (RemoteException localRemoteException)
          {
            try
            {
              for (;;)
              {
                IWadlService localIWadlService;
                localIWadlService.asBinder().unlinkToDeath(this, 0);
                WLog.c("WadlProxyServiceManager", "destroy unlinkToDeath success");
                if (MobileQQ.sProcessId == 1) {}
                try
                {
                  MobileQQ.sMobileQQ.unbindService(this);
                  WLog.c("WadlProxyServiceManager", "destroy unbindService success");
                  return;
                }
                catch (Exception localException5)
                {
                  WLog.a("WadlProxyServiceManager", "destroy unbindService exception", localException5);
                }
                localException1 = localException1;
                WLog.a("WadlProxyServiceManager", "destroy clear callBackList exception", localException1);
                continue;
                localException2 = localException2;
                WLog.a("WadlProxyServiceManager", "destroy clear resCallBacks exception", localException2);
                continue;
                localException3 = localException3;
                WLog.a("WadlProxyServiceManager", "destroy mMessageThread.quit exception", localException3);
                continue;
                localRemoteException = localRemoteException;
                WLog.a("WadlProxyServiceManager", "destroy unregisterCallback exception", localRemoteException);
              }
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                WLog.a("WadlProxyServiceManager", "destroy unlinkToDeath exception", localException4);
              }
            }
          }
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
    case 1: 
      b(paramMessage.what);
      return false;
    case 2: 
      b();
      return false;
    case 3: 
      b(paramMessage.getData());
      return false;
    case 4: 
      this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a(paramMessage.getData());
      return false;
    case 5: 
      this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a();
      return false;
    case 6: 
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a();
        return false;
      }
      this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.b();
      return false;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    WLog.c("WadlProxyServiceManager", "reset mServiceConnecting");
    return false;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    WLog.c("WadlProxyServiceManager", "onServiceConnected success, componentName=" + paramComponentName + ",service=" + paramIBinder);
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        WLog.b("WadlProxyServiceManager", "onServiceConnected,but this is destroy");
        return;
      }
      this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService = IWadlService.Stub.a(paramIBinder);
      if (this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService == null)
      {
        WLog.b("WadlProxyServiceManager", "onServiceConnected,but asInterface fail");
        return;
      }
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
      return;
    }
    this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService.a(this);
    this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService.asBinder().linkToDeath(this, 0);
    d();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    WLog.c("WadlProxyServiceManager", "onServiceDisconnected");
    try
    {
      this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a();
      if (this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService != null) {
        this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService.b(this);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
      return;
    }
    finally
    {
      this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService = null;
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.WadlProxyServiceManager
 * JD-Core Version:    0.7.0.1
 */