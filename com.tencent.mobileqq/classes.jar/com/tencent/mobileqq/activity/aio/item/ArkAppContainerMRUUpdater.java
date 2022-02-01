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
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static boolean jdField_a_of_type_Boolean;
  WeakReference<ArkAioContainerWrapper> jdField_a_of_type_JavaLangRefWeakReference;
  LinkedList<WeakReference<ArkAioContainerWrapper>> jdField_a_of_type_JavaUtilLinkedList;
  
  public ArkAppContainerMRUUpdater()
  {
    jdField_a_of_type_Boolean = a();
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    jdField_a_of_type_AndroidOsHandler = new ArkAppContainerMRUUpdater.1(this, Looper.getMainLooper());
    MagnifierSDK.a().a().a(new ArkAppContainerMRUUpdater.2(this));
  }
  
  public static ArkAppContainerMRUUpdater a()
  {
    return ArkAppContainerMRUUpdater.LazyHolder.a;
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessage(localHandler.obtainMessage(4));
  }
  
  public static void a(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessage(localHandler.obtainMessage(1, paramWeakReference));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      b("removeLast, list is empty");
      return;
    }
    int m = this.jdField_a_of_type_JavaUtilLinkedList.size();
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
    int k = this.jdField_a_of_type_JavaUtilLinkedList.indexOf(this.jdField_a_of_type_JavaLangRefWeakReference);
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
      localObject = (WeakReference)this.jdField_a_of_type_JavaUtilLinkedList.peekLast();
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
    b();
  }
  
  private boolean a()
  {
    ArkPlatformConfigBean localArkPlatformConfigBean = (ArkPlatformConfigBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkPlatformConfigBean.class);
    if ((localArkPlatformConfigBean != null) && (localArkPlatformConfigBean.a() != null)) {
      return localArkPlatformConfigBean.a().b;
    }
    QLog.i("ArkApp.ArkAppContainerMRUUpdater", 1, "confBean.getConfig() get fail");
    return false;
  }
  
  private void b() {}
  
  private static void b(String paramString) {}
  
  public static void b(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessage(localHandler.obtainMessage(2, paramWeakReference));
  }
  
  private void c()
  {
    b("do clear");
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
  }
  
  private static void c(String paramString)
  {
    QLog.i("ArkApp.ArkAppContainerMRUUpdater", 1, String.format(Locale.CHINA, paramString, new Object[0]));
  }
  
  public static void c(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessage(localHandler.obtainMessage(3, paramWeakReference));
  }
  
  private void d(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (paramWeakReference == null) {
      return;
    }
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference == paramWeakReference)
    {
      int i = this.jdField_a_of_type_JavaUtilLinkedList.indexOf(localWeakReference);
      int j = this.jdField_a_of_type_JavaUtilLinkedList.size();
      if ((i != -1) && (i != j - 1) && (j != 0))
      {
        this.jdField_a_of_type_JavaLangRefWeakReference = ((WeakReference)this.jdField_a_of_type_JavaUtilLinkedList.get(i + 1));
        return;
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  private void e(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (paramWeakReference == null)
    {
      b("doMoveToFirst node is null");
      return;
    }
    d(paramWeakReference);
    b(String.format("doMoveToFirst: %h", new Object[] { paramWeakReference.get() }));
    if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.getFirst() == paramWeakReference))
    {
      b("doMoveToFirst node already in the first position");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramWeakReference)) {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramWeakReference);
    }
    this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramWeakReference);
    a(false);
  }
  
  private void f(WeakReference<ArkAioContainerWrapper> paramWeakReference)
  {
    if (paramWeakReference == null)
    {
      b("doMoveToFirstInActive node is null");
      return;
    }
    b(String.format("doMoveToFirstInActive: %h", new Object[] { paramWeakReference.get() }));
    if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramWeakReference)))
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramWeakReference);
      WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localWeakReference == null)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramWeakReference);
      }
      else
      {
        int i = this.jdField_a_of_type_JavaUtilLinkedList.indexOf(localWeakReference);
        if (i > 0) {
          this.jdField_a_of_type_JavaUtilLinkedList.add(i, paramWeakReference);
        }
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
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
    this.jdField_a_of_type_JavaUtilLinkedList.remove(paramWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainerMRUUpdater
 * JD-Core Version:    0.7.0.1
 */