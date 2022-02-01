package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class ArkQQAPIIPCModule
  extends QIPCModule
{
  private static volatile ArkQQAPIIPCModule jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule;
  private final HashMap<String, Class<? extends Object>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private ArkQQAPIIPCModule(String paramString)
  {
    super(paramString);
    a();
  }
  
  public static int a()
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new ArkQQAPIIPCModule.11(localArrayList));
    return ((Integer)localArrayList.get(0)).intValue();
  }
  
  public static ArkQQAPIIPCModule a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule == null) {
        jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule = new ArkQQAPIIPCModule("ArkQQAPIIPCModule");
      }
      return jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule;
    }
    finally {}
  }
  
  private Object a(String paramString)
  {
    Class localClass = (Class)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localClass == null)
    {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "createHandler fail, action=" + paramString);
      return null;
    }
    try
    {
      paramString = localClass.newInstance();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static String a()
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new ArkQQAPIIPCModule.4(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new ArkQQAPIIPCModule.5(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String a(String paramString, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new ArkQQAPIIPCModule.6(paramString, paramLong, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetUin", ArkQQAPIIPCModule.GetUinHandler.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetNickname", ArkQQAPIIPCModule.GetNicknameHandler.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetNicknameByView", ArkQQAPIIPCModule.GetNicknameByViewHandler.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetSKey", ArkQQAPIIPCModule.GetSKeyHandler.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetPSKey", ArkQQAPIIPCModule.GetPSKeyHandler.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.Login", ArkQQAPIIPCModule.LoginHandler.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetUserInformation", ArkQQAPIIPCModule.GetUserInformationHandler.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetAudioOutputModeHandler", ArkQQAPIIPCModule.GetAudioOutputModeHandler.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetPSKeyAsync", ArkQQAPIIPCModule.GetPSKeyAsyncHandler.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.LaunchMiniappHandler", ArkQQAPIIPCModule.LaunchMiniappHandler.class);
  }
  
  public static void a(long paramLong1, long paramLong2, ArkQQAPIIPCModule.LoginHandler.OnLoginEventHandler paramOnLoginEventHandler)
  {
    a().a(new ArkQQAPIIPCModule.9(paramLong1, paramLong2, paramOnLoginEventHandler, paramLong2));
  }
  
  public static void a(String paramString, ArkQQAPIIPCModule.GetPSKeyAsyncHandler.OnGetPSKeyHandler paramOnGetPSKeyHandler)
  {
    a().a(new ArkQQAPIIPCModule.12(paramString, paramOnGetPSKeyHandler));
  }
  
  public static boolean a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new ArkQQAPIIPCModule.13(paramString, localArrayList));
    return ((Boolean)localArrayList.get(0)).booleanValue();
  }
  
  private static QQAppInterface b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String b()
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new ArkQQAPIIPCModule.7(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new ArkQQAPIIPCModule.8(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new ArkQQAPIIPCModule.10(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return null;
  }
  
  public void a(ArkQQAPIIPCModule.IPCMethod paramIPCMethod)
  {
    boolean bool = true;
    if (paramIPCMethod == null) {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, method is null");
    }
    Object localObject;
    do
    {
      return;
      localObject = a(paramIPCMethod.a());
      if (localObject == null)
      {
        QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, handler not found, method=" + paramIPCMethod.a());
        return;
      }
      if (b() == null) {
        break;
      }
      if ((localObject instanceof ArkQQAPIIPCModule.IPCSyncMethodHandler))
      {
        localObject = ((ArkQQAPIIPCModule.IPCSyncMethodHandler)localObject).a(paramIPCMethod.a());
        if (((EIPCResult)localObject).code == 0) {}
        for (bool = true;; bool = false)
        {
          paramIPCMethod.a(bool, ((EIPCResult)localObject).data);
          return;
        }
      }
    } while (!(localObject instanceof ArkQQAPIIPCModule.IPCAsyncMethodHandler));
    ((ArkQQAPIIPCModule.IPCAsyncMethodHandler)localObject).a(paramIPCMethod.a(), new ArkQQAPIIPCModule.2(this, paramIPCMethod));
    return;
    if ((localObject instanceof ArkQQAPIIPCModule.IPCSyncMethodHandler))
    {
      localObject = QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramIPCMethod.a(), paramIPCMethod.a());
      if (((EIPCResult)localObject).code != 0) {
        QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call.sync, method=" + paramIPCMethod.a() + " result=" + localObject);
      }
      if (((EIPCResult)localObject).code == 0) {}
      for (;;)
      {
        paramIPCMethod.a(bool, ((EIPCResult)localObject).data);
        return;
        bool = false;
      }
    }
    if ((localObject instanceof ArkQQAPIIPCModule.IPCAsyncMethodHandler))
    {
      QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramIPCMethod.a(), paramIPCMethod.a(), new ArkQQAPIIPCModule.3(this, paramIPCMethod));
      return;
    }
    QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, invalid handler class, " + localObject.getClass().toString());
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = a(paramString);
    if ((localObject instanceof ArkQQAPIIPCModule.IPCSyncMethodHandler)) {
      return ((ArkQQAPIIPCModule.IPCSyncMethodHandler)localObject).a(paramBundle);
    }
    if ((localObject instanceof ArkQQAPIIPCModule.IPCAsyncMethodHandler))
    {
      ((ArkQQAPIIPCModule.IPCAsyncMethodHandler)localObject).a(paramBundle, new ArkQQAPIIPCModule.1(this, paramInt));
      return null;
    }
    QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "onCall, invalid action, " + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule
 * JD-Core Version:    0.7.0.1
 */