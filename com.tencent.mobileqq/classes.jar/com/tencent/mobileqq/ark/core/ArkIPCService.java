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
  static volatile ArkIPCService jdField_a_of_type_ComTencentMobileqqArkCoreArkIPCService;
  @ConfigInject(configPath="Business/qqark-impl/src/main/resources/Inject_ArkIPCService_APIList.yml", version=1)
  public static final ArrayList<Class<? extends IPCMethodHandler>> a;
  private final HashMap<String, Class<? extends IPCMethodHandler>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(ArkQQAPIIPCModule.GetUinHandler.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArkQQAPIIPCModule.GetNicknameHandler.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArkQQAPIIPCModule.GetNicknameByViewHandler.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArkQQAPIIPCModule.GetSKeyHandler.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArkQQAPIIPCModule.GetPSKeyHandler.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArkQQAPIIPCModule.LoginHandler.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArkQQAPIIPCModule.GetUserInformationHandler.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArkQQAPIIPCModule.GetAudioOutputModeHandler.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArkQQAPIIPCModule.GetPSKeyAsyncHandler.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArkQQAPIIPCModule.LaunchMiniappHandler.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArkAppSSOIPCHandler.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArkVipReporterIPCHandler.class);
  }
  
  ArkIPCService(String paramString)
  {
    super(paramString);
    a();
  }
  
  public static ArkIPCService a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArkCoreArkIPCService == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqArkCoreArkIPCService == null) {
          jdField_a_of_type_ComTencentMobileqqArkCoreArkIPCService = new ArkIPCService("ArkQQAPIIPCModule");
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqArkCoreArkIPCService;
  }
  
  IPCMethodHandler a(String paramString)
  {
    Object localObject = (Class)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
  
  protected void a()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
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
    if (a())
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
      paramIPCMethodHandler = ((IPCSyncMethodHandler)paramIPCMethodHandler).a(paramIPCMethod.a());
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
      ((IPCAsyncMethodHandler)paramIPCMethodHandler).a(paramIPCMethod.a(), new ArkIPCService.2(this, paramIPCMethod));
    }
  }
  
  void a(String paramString, Class<? extends IPCMethodHandler> paramClass)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramClass);
  }
  
  boolean a()
  {
    return MobileQQ.sProcessId == 1;
  }
  
  void b(IPCMethod paramIPCMethod, IPCMethodHandler paramIPCMethodHandler)
  {
    boolean bool2 = paramIPCMethodHandler instanceof IPCSyncMethodHandler;
    boolean bool1 = true;
    if (bool2)
    {
      paramIPCMethodHandler = QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramIPCMethod.a(), paramIPCMethod.a());
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
      QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramIPCMethod.a(), paramIPCMethod.a(), new ArkIPCService.3(this, paramIPCMethod));
      return;
    }
    paramIPCMethod = new StringBuilder();
    paramIPCMethod.append("call, invalid handler class, ");
    paramIPCMethod.append(paramIPCMethodHandler.getClass().toString());
    QLog.i("ArkApp.ArkIPCService", 1, paramIPCMethod.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkIPCService
 * JD-Core Version:    0.7.0.1
 */