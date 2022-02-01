package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.config.bean.ArkPlatformConfigBean;
import com.tencent.mobileqq.ark.config.config.ArkPlatformConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleCelling;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Locale;

public class ArkAppContainerMRUUpdater
{
  private static Handler c;
  private static boolean d;
  LinkedList<WeakReference<ArkAioContainerWrapper>> a;
  WeakReference<ArkAioContainerWrapper> b;
  
  public ArkAppContainerMRUUpdater()
  {
    d = d();
    if (!d) {
      return;
    }
    this.a = new LinkedList();
    c = new ArkAppContainerMRUUpdater.1(this, Looper.getMainLooper());
    MagnifierSDK.b().d().a(new ArkAppContainerMRUUpdater.2(this));
  }
  
  public static ArkAppContainerMRUUpdater a()
  {
    return ArkAppContainerMRUUpdater.LazyHolder.a;
  }
  
  public static void a(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (!d) {
      return;
    }
    Handler localHandler = c;
    localHandler.sendMessage(localHandler.obtainMessage(1, paramWeakReference));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.a.isEmpty())
    {
      b("removeLast, list is empty");
      return;
    }
    int m = this.a.size();
    int i;
    if (paramBoolean) {
      i = m;
    } else {
      i = m - 10;
    }
    int j = 0;
    if (i <= 0) {
      i = 0;
    }
    int k = this.a.indexOf(this.b);
    if (k > 0) {
      j = m - k;
    }
    k = i;
    if (i > j) {
      k = j;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeLast, size = ");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(", toBeRemovedCount = ");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append(" , numOfInactive = ");
    ((StringBuilder)localObject).append(j);
    b(((StringBuilder)localObject).toString());
    while (k > 0)
    {
      localObject = (WeakReference)this.a.peekLast();
      if (localObject == null) {
        break;
      }
      ArkAioContainerWrapper localArkAioContainerWrapper = (ArkAioContainerWrapper)((WeakReference)localObject).get();
      if (localArkAioContainerWrapper != null)
      {
        localArkAioContainerWrapper.doOnEvent(2);
        ArkAioContainerWrapper.a(localArkAioContainerWrapper);
        ArkAioContainerWrapper.b(localArkAioContainerWrapper);
      }
      g((WeakReference)localObject);
      k -= 1;
    }
    e();
  }
  
  public static void b()
  {
    if (!d) {
      return;
    }
    Handler localHandler = c;
    localHandler.sendMessage(localHandler.obtainMessage(4));
  }
  
  private static void b(String paramString) {}
  
  public static void b(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (!d) {
      return;
    }
    Handler localHandler = c;
    localHandler.sendMessage(localHandler.obtainMessage(2, paramWeakReference));
  }
  
  private static void c(String paramString)
  {
    QLog.i("ArkApp.ArkAppContainerMRUUpdater", 1, String.format(Locale.CHINA, paramString, new Object[0]));
  }
  
  public static void c(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (!d) {
      return;
    }
    Handler localHandler = c;
    localHandler.sendMessage(localHandler.obtainMessage(3, paramWeakReference));
  }
  
  private void d(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (paramWeakReference == null) {
      return;
    }
    WeakReference localWeakReference = this.b;
    if (localWeakReference == paramWeakReference)
    {
      int i = this.a.indexOf(localWeakReference);
      int j = this.a.size();
      if ((i != -1) && (i != j - 1) && (j != 0))
      {
        this.b = ((WeakReference)this.a.get(i + 1));
        return;
      }
      this.b = null;
    }
  }
  
  private boolean d()
  {
    ArkPlatformConfigBean localArkPlatformConfigBean = (ArkPlatformConfigBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkPlatformConfigBean.class);
    if ((localArkPlatformConfigBean != null) && (localArkPlatformConfigBean.b() != null)) {
      return localArkPlatformConfigBean.b().c;
    }
    QLog.i("ArkApp.ArkAppContainerMRUUpdater", 1, "confBean.getConfig() get fail");
    return false;
  }
  
  private void e() {}
  
  private void e(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (paramWeakReference == null)
    {
      b("doMoveToFirst node is null");
      return;
    }
    d(paramWeakReference);
    b(String.format("doMoveToFirst: %h", new Object[] { paramWeakReference.get() }));
    if ((!this.a.isEmpty()) && (this.a.getFirst() == paramWeakReference))
    {
      b("doMoveToFirst node already in the first position");
      return;
    }
    if (this.a.contains(paramWeakReference)) {
      this.a.remove(paramWeakReference);
    }
    this.a.addFirst(paramWeakReference);
    a(false);
  }
  
  private void f()
  {
    b("do clear");
    this.a.clear();
  }
  
  private void f(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (paramWeakReference == null)
    {
      b("doMoveToFirstInActive node is null");
      return;
    }
    b(String.format("doMoveToFirstInActive: %h", new Object[] { paramWeakReference.get() }));
    if ((!this.a.isEmpty()) && (this.a.contains(paramWeakReference)))
    {
      this.a.remove(paramWeakReference);
      WeakReference localWeakReference = this.b;
      if (localWeakReference == null)
      {
        this.a.addLast(paramWeakReference);
      }
      else
      {
        int i = this.a.indexOf(localWeakReference);
        if (i > 0) {
          this.a.add(i, paramWeakReference);
        }
      }
      this.b = paramWeakReference;
      a(false);
      return;
    }
    b("doMoveToFirstInActive node not in the list");
  }
  
  private void g(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (paramWeakReference == null)
    {
      b("doRemove node is null");
      return;
    }
    b(String.format("doRemove %h", new Object[] { paramWeakReference.get() }));
    d(paramWeakReference);
    this.a.remove(paramWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainerMRUUpdater
 * JD-Core Version:    0.7.0.1
 */