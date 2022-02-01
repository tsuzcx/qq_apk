package com.tencent.common.app;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQLifecycleBusinessObserver;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.service.Cmd2HandlerMapHelper;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.transfile.InitHwEngineValue;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public abstract class AppInterface
  extends AppRuntime
{
  private final ConcurrentHashMap<String, BusinessHandler> allHandler = new ConcurrentHashMap();
  protected MobileQQ app;
  private final List<BusinessObserver> bgObservers = new Vector();
  private MqqHandler defaultHandler = new MqqHandler(Looper.getMainLooper());
  private final List<BusinessObserver> defaultObservers = new Vector();
  protected final ConcurrentHashMap<Class, MqqHandler> handlerMap = new ConcurrentHashMap();
  protected HwEngine mHwEngine;
  protected String processName = "";
  private final List<BusinessObserver> uiObservers = new Vector();
  
  public AppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    this.app = paramMobileQQ;
    this.processName = paramString;
  }
  
  private void destroyBusinessObserverList()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("mqq", 4, new Object[] { "onDestroy, uiObservers size:", Integer.valueOf(this.uiObservers.size()), ", bgObservers size:", Integer.valueOf(this.uiObservers.size()), ", defaultObservers size:", Integer.valueOf(this.defaultObservers.size()) });
    }
    synchronized (this.uiObservers)
    {
      this.uiObservers.clear();
      synchronized (this.bgObservers)
      {
        this.bgObservers.clear();
        synchronized (this.defaultObservers)
        {
          this.defaultObservers.clear();
          synchronized (this.allHandler)
          {
            Iterator localIterator = this.allHandler.entrySet().iterator();
            for (;;)
            {
              boolean bool = localIterator.hasNext();
              if (!bool) {
                break;
              }
              try
              {
                BusinessHandler localBusinessHandler = (BusinessHandler)((Map.Entry)localIterator.next()).getValue();
                if (localBusinessHandler != null) {
                  localBusinessHandler.onDestroy();
                }
              }
              catch (Exception localException)
              {
                QLog.d("mqq", 1, "handler destroy fail", localException);
              }
            }
            return;
          }
        }
      }
    }
    for (;;)
    {
      throw localObject5;
    }
  }
  
  private void invokeSkin()
  {
    Class localClass = Class.forName("com.tencent.mobileqq.vas.theme.SimpleTintManager");
    Object localObject = localClass.getMethod("instance", new Class[0]).invoke(localClass, new Object[0]);
    localClass.getMethod("checkSkinEngineInit", new Class[0]).invoke(localObject, new Object[0]);
  }
  
  private void removeOriginObserver(List<BusinessObserver> paramList, QQLifecycleBusinessObserver paramQQLifecycleBusinessObserver)
  {
    try
    {
      int i = paramList.indexOf(paramQQLifecycleBusinessObserver);
      if (i >= 0)
      {
        paramQQLifecycleBusinessObserver = (BusinessObserver)paramList.remove(i);
        if ((paramQQLifecycleBusinessObserver instanceof QQLifecycleBusinessObserver)) {
          ((QQLifecycleBusinessObserver)paramQQLifecycleBusinessObserver).markObserverRemove();
        }
      }
      return;
    }
    finally {}
  }
  
  public void addDefaultObservers(@NotNull BusinessObserver paramBusinessObserver)
  {
    synchronized (this.defaultObservers)
    {
      paramBusinessObserver = new QQLifecycleBusinessObserver(paramBusinessObserver);
      if (!this.defaultObservers.contains(paramBusinessObserver)) {
        this.defaultObservers.add(paramBusinessObserver);
      }
      return;
    }
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    addObserver(paramBusinessObserver, false);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    paramBusinessObserver = new QQLifecycleBusinessObserver(paramBusinessObserver);
    if (paramBoolean) {
      synchronized (this.bgObservers)
      {
        if (!this.bgObservers.contains(paramBusinessObserver)) {
          this.bgObservers.add(paramBusinessObserver);
        }
        return;
      }
    }
    synchronized (this.uiObservers)
    {
      if (!this.uiObservers.contains(paramBusinessObserver)) {
        this.uiObservers.add(paramBusinessObserver);
      }
      return;
    }
  }
  
  public boolean containObserver(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    paramBusinessObserver = new QQLifecycleBusinessObserver(paramBusinessObserver);
    if (paramBoolean) {
      return this.bgObservers.contains(paramBusinessObserver);
    }
    return this.uiObservers.contains(paramBusinessObserver);
  }
  
  protected BusinessHandler createHandler(String paramString)
  {
    Object localObject1;
    try
    {
      Constructor[] arrayOfConstructor = Class.forName(paramString).getDeclaredConstructors();
      int j = arrayOfConstructor.length;
      localObject1 = null;
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break label173;
        }
        Constructor localConstructor = arrayOfConstructor[i];
        try
        {
          Class[] arrayOfClass = localConstructor.getParameterTypes();
          localObject2 = localObject1;
          if (arrayOfClass.length == 1)
          {
            localObject2 = localObject1;
            if (AppInterface.class.isAssignableFrom(arrayOfClass[0]))
            {
              localConstructor.setAccessible(true);
              localObject2 = (BusinessHandler)localConstructor.newInstance(new Object[] { this });
              try
              {
                Cmd2HandlerMapHelper.a(paramString, ((BusinessHandler)localObject2).getCommandList());
              }
              catch (Exception paramString)
              {
                localObject1 = localObject2;
                break label130;
              }
            }
          }
          i += 1;
          localObject1 = localObject2;
        }
        catch (Exception paramString) {}
      }
      QLog.e("mqq", 1, paramString, new Object[0]);
    }
    catch (Exception paramString)
    {
      localObject1 = null;
    }
    label130:
    Object localObject2 = localObject1;
    if ((paramString instanceof InvocationTargetException))
    {
      QLog.e("mqq", 1, ((InvocationTargetException)paramString).getTargetException(), new Object[0]);
      localObject2 = localObject1;
    }
    label173:
    return localObject2;
  }
  
  public abstract BaseApplication getApp();
  
  public abstract int getAppid();
  
  public BusinessHandler getBusinessHandler(String paramString)
  {
    Object localObject = (BusinessHandler)this.allHandler.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    synchronized (this.allHandler)
    {
      BusinessHandler localBusinessHandler = (BusinessHandler)this.allHandler.get(paramString);
      localObject = localBusinessHandler;
      if (localBusinessHandler == null)
      {
        localBusinessHandler = createHandler(paramString);
        localObject = localBusinessHandler;
        if (localBusinessHandler != null)
        {
          this.allHandler.put(paramString, localBusinessHandler);
          localObject = localBusinessHandler;
        }
      }
      return localObject;
    }
  }
  
  public List<BusinessObserver> getBusinessObserver(int paramInt)
  {
    if (paramInt == 1) {
      return this.uiObservers;
    }
    if (paramInt == 2) {
      return this.bgObservers;
    }
    if (paramInt == 0) {
      return this.defaultObservers;
    }
    return this.defaultObservers;
  }
  
  public abstract String getCurrentAccountUin();
  
  public String getCurrentNickname()
  {
    return "";
  }
  
  public MqqHandler getHandler(Class paramClass)
  {
    if (this.handlerMap.get(paramClass) != null) {
      return (MqqHandler)this.handlerMap.get(paramClass);
    }
    return this.defaultHandler;
  }
  
  public MqqHandler getHandlerWithoutDefault(Class paramClass)
  {
    return (MqqHandler)this.handlerMap.get(paramClass);
  }
  
  public HwEngine getHwEngine()
  {
    if (this.mHwEngine == null)
    {
      InitHwEngineValue localInitHwEngineValue = new InitHwEngineValue();
      this.mHwEngine = new HwEngine(getApplication(), getCurrentAccountUin(), getAppid(), this, localInitHwEngineValue.localId, localInitHwEngineValue.switchIpv6);
    }
    return this.mHwEngine;
  }
  
  public MobileQQServiceBase getMobileQQService()
  {
    return null;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (MobileQQ.sProcessId != 1) {
      try
      {
        invokeSkin();
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("mqq", 1, "appinterface on create error : ", paramBundle);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.handlerMap.clear();
    this.defaultHandler.removeCallbacksAndMessages(null);
    destroyBusinessObserverList();
  }
  
  public void receiveToService(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MobileQQServiceBase localMobileQQServiceBase = getMobileQQService();
    if (localMobileQQServiceBase != null) {
      localMobileQQServiceBase.handleResponse(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
    }
  }
  
  public void removeHandler(Class paramClass)
  {
    this.handlerMap.remove(paramClass);
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    paramBusinessObserver = new QQLifecycleBusinessObserver(paramBusinessObserver);
    removeOriginObserver(this.uiObservers, paramBusinessObserver);
    removeOriginObserver(this.bgObservers, paramBusinessObserver);
    removeOriginObserver(this.defaultObservers, paramBusinessObserver);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    MobileQQServiceBase localMobileQQServiceBase = getMobileQQService();
    if (localMobileQQServiceBase != null) {
      localMobileQQServiceBase.handleRequest(paramToServiceMsg);
    }
  }
  
  public void setHandler(Class paramClass, MqqHandler paramMqqHandler)
  {
    if (paramMqqHandler == null)
    {
      this.handlerMap.remove(paramClass);
      return;
    }
    this.handlerMap.put(paramClass, paramMqqHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.AppInterface
 * JD-Core Version:    0.7.0.1
 */