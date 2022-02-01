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
      QLog.w("Wadl_WadlProxyServiceManager", 1, "storeCmdToCache there must be an error too many unproceed message!");
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadActionCallback wadlResult:");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(",callBackList size=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      QLog.i("Wadl_WadlProxyServiceManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBundle != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((WadlProxyServiceCallBackInterface)((Iterator)localObject).next()).a(paramBundle);
      }
    }
  }
  
  private void e(Bundle paramBundle)
  {
    Object localObject = paramBundle.getParcelableArrayList("query_result");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQueryCallback params:");
    localStringBuilder.append(paramBundle.toString());
    localStringBuilder.append(",callBackList size=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = new ArrayList();
    }
    localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
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
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
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
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
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
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    paramBundle = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
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
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    QLog.i("Wadl_WadlProxyServiceManager", 1, ((StringBuilder)localObject).toString());
    if (paramBundle != null)
    {
      localObject = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((WadlResCallBack)((Iterator)localObject).next()).b(paramBundle);
      }
    }
  }
  
  protected void a()
  {
    QLog.i("Wadl_WadlProxyServiceManager", 1, "resetDiedCount");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send action msg cmd=");
    localStringBuilder.append(str);
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    if (!a())
    {
      QLog.w("Wadl_WadlProxyServiceManager", 1, "postRemoteNotify start but service is not launched and start service");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transferAsync from Service cmd=");
    localStringBuilder.append(paramString);
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    paramBundle.setClassLoader(getClass().getClassLoader());
    if (paramString != null)
    {
      if (paramString.equals("WADL.REVERSE_HEART_CMD"))
      {
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString.what = 4;
        paramString.setData(paramBundle);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        return;
      }
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
      if ((paramString.equals("WADL.REVERSE_START_MONITOR_CMD")) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(6))) {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6).sendToTarget();
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService != null) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendAsynRemoteCommandMessage mWadlService=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService);
    ((StringBuilder)localObject).append(",mServiceConnecting=");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    ((StringBuilder)localObject).append(",mCacheMsg size=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
    QLog.i("Wadl_WadlProxyServiceManager", 1, ((StringBuilder)localObject).toString());
    if ((a()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      while (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject = (Bundle)this.jdField_a_of_type_JavaUtilList.remove(0);
        if (localObject != null)
        {
          String str = ((Bundle)localObject).getString("WADL.REMOTE_NOTIFY_CMD_NAME");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("sendAsynRemoteCommandMessage strNotifyCmd=");
          localStringBuilder.append(str);
          localStringBuilder.append(",mWadlService=");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService);
          QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
          try
          {
            ((Bundle)localObject).setClassLoader(getClass().getClassLoader());
            if (this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService == null) {
              continue;
            }
            this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService.a("WADL.REMOTE_ACTION_CMD", (Bundle)localObject);
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
  
  public void b(int paramInt)
  {
    QLog.i("Wadl_WadlProxyServiceManager", 1, "innerStartService start");
    if (this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService != null)
    {
      QLog.w("Wadl_WadlProxyServiceManager", 1, "innerStartService mWadlService is working");
      return;
    }
    if (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
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
        QLog.e("Wadl_WadlProxyServiceManager", 1, "innerStartService fail", localThrowable);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 5000L);
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("innerStartService is connecting mWadlService:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService);
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
    try
    {
      this.c += 1;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("binderDied, diedCount=");
      ((StringBuilder)localObject).append(this.c);
      QLog.e("Wadl_WadlProxyServiceManager", 1, ((StringBuilder)localObject).toString());
      if (this.c > 9) {
        this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a(10.0F, true);
      } else if (this.c > 6) {
        this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a(2.0F, true);
      } else if (this.c > 3) {
        this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a(1.5F, true);
      } else {
        this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a(1.0F, true);
      }
      if (this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a())
      {
        localObject = WadlReportInfo.a();
        ((WadlReportInfo)localObject).c = "service dlied";
        ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportDC("204685", "444", (WadlReportInfo)localObject, "08a00036462");
        if (this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService != null)
        {
          this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService.asBinder().unlinkToDeath(this, 0);
          this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService = null;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroy: ");
    localStringBuilder.append(this);
    QLog.i("Wadl_WadlProxyServiceManager", 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    catch (Exception localException1)
    {
      QLog.e("Wadl_WadlProxyServiceManager", 1, "destroy clear callBackList exception", localException1);
    }
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    catch (Exception localException2)
    {
      QLog.e("Wadl_WadlProxyServiceManager", 1, "destroy clear resCallBacks exception", localException2);
    }
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
    catch (Exception localException3)
    {
      QLog.e("Wadl_WadlProxyServiceManager", 1, "destroy mMessageThread.quit exception", localException3);
    }
    IWadlService localIWadlService = this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService;
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
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      QLog.i("Wadl_WadlProxyServiceManager", 1, "reset mServiceConnecting");
      return false;
    case 6: 
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a();
        return false;
      }
      this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.b();
      return false;
    case 5: 
      this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a();
      return false;
    case 4: 
      this.jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor.a(paramMessage.getData());
      return false;
    case 3: 
      b(paramMessage.getData());
      return false;
    case 2: 
      b();
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
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        QLog.w("Wadl_WadlProxyServiceManager", 1, "onServiceConnected,but this is destroy");
        return;
      }
      this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService = IWadlService.Stub.a(paramIBinder);
      if (this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService == null)
      {
        QLog.w("Wadl_WadlProxyServiceManager", 1, "onServiceConnected,but asInterface fail");
        return;
      }
      this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService.a(this);
      this.jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService.asBinder().linkToDeath(this, 0);
      d();
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
    //   0: ldc 95
    //   2: iconst_1
    //   3: ldc_w 539
    //   6: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: getfield 85	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:jdField_a_of_type_ComTencentGamecenterWadlApiImplIWadlProxyServiceMonitor	Lcom/tencent/gamecenter/wadl/api/impl/IWadlProxyServiceMonitor;
    //   13: invokeinterface 457 1 0
    //   18: aload_0
    //   19: getfield 295	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService	Lcom/tencent/gamecenter/wadl/api/IWadlService;
    //   22: ifnull +25 -> 47
    //   25: aload_0
    //   26: getfield 295	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService	Lcom/tencent/gamecenter/wadl/api/IWadlService;
    //   29: aload_0
    //   30: invokeinterface 474 2 0
    //   35: goto +12 -> 47
    //   38: astore_1
    //   39: goto +22 -> 61
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 540	java/lang/Exception:printStackTrace	()V
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 295	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService	Lcom/tencent/gamecenter/wadl/api/IWadlService;
    //   52: aload_0
    //   53: getfield 46	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   56: iconst_0
    //   57: invokevirtual 380	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   60: return
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 295	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:jdField_a_of_type_ComTencentGamecenterWadlApiIWadlService	Lcom/tencent/gamecenter/wadl/api/IWadlService;
    //   66: aload_0
    //   67: getfield 46	com/tencent/gamecenter/wadl/api/impl/WadlProxyServiceManager:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   70: iconst_0
    //   71: invokevirtual 380	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.WadlProxyServiceManager
 * JD-Core Version:    0.7.0.1
 */