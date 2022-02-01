package com.tencent.mobileqq.ark.core;

import android.os.Bundle;
import com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetAudioOutputModeHandler;
import com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetNicknameByViewHandler;
import com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetNicknameHandler;
import com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetPSKeyAsyncHandler;
import com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetPSKeyHandler;
import com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetSKeyHandler;
import com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetUinHandler;
import com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetUserInformationHandler;
import com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.LaunchMiniappHandler;
import com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.LoginHandler;
import com.tencent.mobileqq.ark.ipc.IPCAsyncMethodHandler;
import com.tencent.mobileqq.ark.ipc.IPCMethod;
import com.tencent.mobileqq.ark.ipc.IPCMethodHandler;
import com.tencent.mobileqq.ark.ipc.IPCSyncMethodHandler;
import com.tencent.mobileqq.ark.vipreport.ArkVipReporterIPCHandler;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class ArkIPCService
  extends QIPCModule
{
  static volatile ArkIPCService a;
  @ConfigInject(configPath="Business/qqark-impl/src/main/resources/Inject_ArkIPCService_APIList.yml", version=1)
  public static final ArrayList<Class<? extends IPCMethodHandler>> b = new ArrayList();
  private final HashMap<String, Class<? extends IPCMethodHandler>> c = new HashMap();
  
  static
  {
    b.add(ArkQQAPIIPCModule.GetUinHandler.class);
    b.add(ArkQQAPIIPCModule.GetNicknameHandler.class);
    b.add(ArkQQAPIIPCModule.GetNicknameByViewHandler.class);
    b.add(ArkQQAPIIPCModule.GetSKeyHandler.class);
    b.add(ArkQQAPIIPCModule.GetPSKeyHandler.class);
    b.add(ArkQQAPIIPCModule.LoginHandler.class);
    b.add(ArkQQAPIIPCModule.GetUserInformationHandler.class);
    b.add(ArkQQAPIIPCModule.GetAudioOutputModeHandler.class);
    b.add(ArkQQAPIIPCModule.GetPSKeyAsyncHandler.class);
    b.add(ArkQQAPIIPCModule.LaunchMiniappHandler.class);
    b.add(ArkAppSSOIPCHandler.class);
    b.add(ArkVipReporterIPCHandler.class);
  }
  
  ArkIPCService(String paramString)
  {
    super(paramString);
    b();
  }
  
  public static ArkIPCService a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ArkIPCService("ArkQQAPIIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  IPCMethodHandler a(String paramString)
  {
    Object localObject = (Class)this.c.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("action not found, action=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("ArkApp.ArkIPCService", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    try
    {
      paramString = (IPCMethodHandler)((Class)localObject).newInstance();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public void a(IPCMethod paramIPCMethod)
  {
    if (paramIPCMethod == null)
    {
      QLog.i("ArkApp.ArkIPCService", 1, "call, method is null");
      return;
    }
    Object localObject = a(paramIPCMethod.a());
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("call, handler not found, method=");
      ((StringBuilder)localObject).append(paramIPCMethod.a());
      QLog.i("ArkApp.ArkIPCService", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (c())
    {
      a(paramIPCMethod, (IPCMethodHandler)localObject);
      return;
    }
    b(paramIPCMethod, (IPCMethodHandler)localObject);
  }
  
  void a(IPCMethod paramIPCMethod, IPCMethodHandler paramIPCMethodHandler)
  {
    if ((paramIPCMethodHandler instanceof IPCSyncMethodHandler))
    {
      paramIPCMethodHandler = ((IPCSyncMethodHandler)paramIPCMethodHandler).a(paramIPCMethod.b());
      boolean bool;
      if (paramIPCMethodHandler.code == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramIPCMethod.a(bool, paramIPCMethodHandler.data);
      return;
    }
    if ((paramIPCMethodHandler instanceof IPCAsyncMethodHandler)) {
      ((IPCAsyncMethodHandler)paramIPCMethodHandler).a(paramIPCMethod.b(), new ArkIPCService.2(this, paramIPCMethod));
    }
  }
  
  void a(String paramString, Class<? extends IPCMethodHandler> paramClass)
  {
    this.c.put(paramString, paramClass);
  }
  
  protected void b()
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      try
      {
        a(((IPCMethodHandler)localClass.newInstance()).a(), localClass);
      }
      catch (Exception localException)
      {
        label46:
        StringBuilder localStringBuilder;
        break label46;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ArkIPCService.cinit, init failed for ");
      localStringBuilder.append(localClass);
      QLog.w("ArkApp.ArkIPCService", 1, localStringBuilder.toString());
    }
  }
  
  void b(IPCMethod paramIPCMethod, IPCMethodHandler paramIPCMethodHandler)
  {
    boolean bool2 = paramIPCMethodHandler instanceof IPCSyncMethodHandler;
    boolean bool1 = true;
    if (bool2)
    {
      paramIPCMethodHandler = QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramIPCMethod.a(), paramIPCMethod.b());
      if (paramIPCMethodHandler.code != 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call.sync, method=");
        localStringBuilder.append(paramIPCMethod.a());
        localStringBuilder.append(" result=");
        localStringBuilder.append(paramIPCMethodHandler);
        QLog.i("ArkApp.ArkIPCService", 1, localStringBuilder.toString());
      }
      if (paramIPCMethodHandler.code != 0) {
        bool1 = false;
      }
      paramIPCMethod.a(bool1, paramIPCMethodHandler.data);
      return;
    }
    if ((paramIPCMethodHandler instanceof IPCAsyncMethodHandler))
    {
      QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramIPCMethod.a(), paramIPCMethod.b(), new ArkIPCService.3(this, paramIPCMethod));
      return;
    }
    paramIPCMethod = new StringBuilder();
    paramIPCMethod.append("call, invalid handler class, ");
    paramIPCMethod.append(paramIPCMethodHandler.getClass().toString());
    QLog.i("ArkApp.ArkIPCService", 1, paramIPCMethod.toString());
  }
  
  boolean c()
  {
    return MobileQQ.sProcessId == 1;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    IPCMethodHandler localIPCMethodHandler = a(paramString);
    if ((localIPCMethodHandler instanceof IPCSyncMethodHandler)) {
      return ((IPCSyncMethodHandler)localIPCMethodHandler).a(paramBundle);
    }
    if ((localIPCMethodHandler instanceof IPCAsyncMethodHandler))
    {
      ((IPCAsyncMethodHandler)localIPCMethodHandler).a(paramBundle, new ArkIPCService.1(this, paramInt));
      return null;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onCall, invalid action, ");
    paramBundle.append(paramString);
    QLog.i("ArkApp.ArkIPCService", 1, paramBundle.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkIPCService
 * JD-Core Version:    0.7.0.1
 */