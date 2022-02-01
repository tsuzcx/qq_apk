package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.apollo.ipc.reflect.Reflect;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloRoleInfoListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloUserDressInfoListener;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.ProcessUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApolloIPCModule
  extends QIPCModule
{
  private Map<String, TypeToken> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ConcurrentHashMap<Class<?>, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap b = new ConcurrentHashMap();
  
  private ApolloIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static ApolloIPCModule a()
  {
    return ApolloIPCModule.ApolloClientClass.a();
  }
  
  public static <T> T a(Class<T> paramClass)
  {
    return a().c(paramClass);
  }
  
  private <T> T a(String paramString)
  {
    try
    {
      paramString = c(getClass().getClassLoader().loadClass(paramString));
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new RuntimeException(paramString.getMessage());
    }
  }
  
  public static void a(int paramInt, IApolloResManager.ApolloRoleInfoListener paramApolloRoleInfoListener)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putInt("apolloRoleId", paramInt);
    localBundle.putLong("startTime", l);
    TraceReportUtil.a(132, String.valueOf(l));
    if (b()) {
      paramInt = 7;
    } else {
      paramInt = 3;
    }
    TraceReportUtil.a(132, String.valueOf(l), paramInt);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_get_role_dir", localBundle, new ApolloIPCModule.7(paramApolloRoleInfoListener));
  }
  
  private void a(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    QLog.d("[cmshow]cm_res", 1, " handleGetDressInfo ");
    ApolloResManagerImpl localApolloResManagerImpl = (ApolloResManagerImpl)paramQQAppInterface.getRuntimeService(IApolloResManager.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramBundle.getLong("startTime"));
    if (localApolloResManagerImpl == null)
    {
      localBundle.putString("apolloErrMsg", "apolloResManager is null");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    localApolloResManagerImpl.getApolloRoleInfo(paramQQAppInterface, paramBundle.getInt("apolloRoleId"), new ApolloIPCModule.1(this, localBundle, paramInt));
  }
  
  public static void a(String paramString, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localBundle.putLong("startTime", l);
    TraceReportUtil.a(132, String.valueOf(l));
    int i;
    if (b()) {
      i = 8;
    } else {
      i = 4;
    }
    TraceReportUtil.a(132, String.valueOf(l), i);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_check_face_data_download", localBundle, new ApolloIPCModule.8(paramOnFaceDataDownloadListener));
  }
  
  public static void a(String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    localBundle.putLong("startTime", l);
    TraceReportUtil.a(132, null, String.valueOf(l));
    int i;
    if (b()) {
      i = 5;
    } else {
      i = 1;
    }
    TraceReportUtil.a(132, String.valueOf(l), i);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_get_user_res_info", localBundle, new ApolloIPCModule.5(paramApolloUserDressInfoListener));
  }
  
  public static void a(ArrayList<Integer> paramArrayList, IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putIntegerArrayList("apolloDressIdList", paramArrayList);
    localBundle.putLong("startTime", l);
    TraceReportUtil.a(132, null, String.valueOf(l));
    int i;
    if (b()) {
      i = 6;
    } else {
      i = 2;
    }
    TraceReportUtil.a(132, String.valueOf(l), i);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_get_dress_info", localBundle, new ApolloIPCModule.6(paramApolloDressInfoListener));
  }
  
  private <T> T b(Class<T> paramClass)
  {
    Object localObject = (ServletImpl)paramClass.getAnnotation(ServletImpl.class);
    try
    {
      localObject = ((ServletImpl)localObject).a().newInstance();
      arrayOfClass = localObject.getClass().getInterfaces();
      m = arrayOfClass.length;
      k = 0;
      i = 0;
    }
    catch (InstantiationException paramClass)
    {
      Class[] arrayOfClass;
      int m;
      int k;
      int j;
      throw new RuntimeException(paramClass.getMessage());
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        int i;
        paramClass = new RuntimeException(paramClass.getMessage());
        for (;;)
        {
          throw paramClass;
        }
        i += 1;
      }
    }
    j = k;
    if (i < m)
    {
      if (!paramClass.equals(arrayOfClass[i])) {
        break label152;
      }
      j = 1;
    }
    if (j != 0)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramClass.getName(), TypeToken.a.a(paramClass));
      this.b.put(paramClass, localObject);
      return localObject;
    }
    throw new RuntimeException("please check you implement setting !");
  }
  
  private void b(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    QLog.d("[cmshow]cm_res", 1, " handleGetDressInfo ");
    ApolloResManagerImpl localApolloResManagerImpl = (ApolloResManagerImpl)paramQQAppInterface.getRuntimeService(IApolloResManager.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramBundle.getLong("startTime"));
    if (localApolloResManagerImpl == null)
    {
      localBundle.putString("apolloErrMsg", "apolloResManager is null");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    localApolloResManagerImpl.getApolloDressInfo(paramQQAppInterface, paramBundle.getIntegerArrayList("apolloDressIdList"), new ApolloIPCModule.2(this, localBundle, paramInt));
  }
  
  private static boolean b()
  {
    return CMResUtil.a();
  }
  
  private <T> T c(Class<T> paramClass)
  {
    ??? = this.b.get(paramClass);
    if (??? != null) {
      return ???;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramClass) == null) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramClass) == null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramClass, new Object());
        }
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramClass))
    {
      Object localObject2 = this.b.get(paramClass);
      if (localObject2 != null) {
        return localObject2;
      }
      if (ProcessUtil.a())
      {
        paramClass = b(paramClass);
        return paramClass;
      }
      localObject2 = paramClass.getClassLoader();
      RemoteInvokeHandler localRemoteInvokeHandler = new RemoteInvokeHandler(paramClass);
      localObject2 = Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { paramClass }, localRemoteInvokeHandler);
      this.b.put(paramClass, localObject2);
      return localObject2;
    }
  }
  
  private void c(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    QLog.d("[cmshow]cm_res", 1, " handleGetUserRes ");
    String str = paramBundle.getString("uin");
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramBundle.getLong("startTime"));
    if (TextUtils.isEmpty(str))
    {
      localBundle.putString("apolloErrMsg", "uin isEmpty");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    paramBundle = (ApolloResManagerImpl)paramQQAppInterface.getRuntimeService(IApolloResManager.class);
    if (paramBundle == null)
    {
      localBundle.putString("apolloErrMsg", "apolloResManager is null");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    paramBundle.getApolloUserDressInfo(str, new ApolloIPCModule.3(this, localBundle, paramInt));
  }
  
  private void d(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    QLog.d("[cmshow]cm_res", 1, " handleCheckFaceDataDownload ");
    String str = paramBundle.getString("url");
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramBundle.getLong("startTime"));
    if (TextUtils.isEmpty(str))
    {
      localBundle.putString("apolloErrMsg", "url isEmpty");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).checkDownloadFaceData(paramQQAppInterface, str, new ApolloIPCModule.4(this, localBundle, paramInt));
  }
  
  public void a(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject2 = paramString.split(";");
    if (localObject2.length < 3) {
      return;
    }
    Object localObject3 = localObject2[0];
    Object localObject1 = a((String)localObject3);
    localObject2 = localObject2[1];
    paramString = paramString.substring(((String)localObject3).length() + 1);
    localObject3 = ((TypeToken)this.jdField_a_of_type_JavaUtilMap.get(localObject3)).a(paramString);
    if (localObject3 == null) {
      return;
    }
    paramString = ParamDeserializer.a((MethodToken)localObject3, paramBundle);
    if (((MethodToken)localObject3).a() != null) {}
    try
    {
      paramBundle = getClass().getClassLoader().loadClass(((MethodToken)localObject3).a().a());
      int i = ((MethodToken)localObject3).a();
      localObject3 = paramBundle.getClassLoader();
      CallbackHandler localCallbackHandler = new CallbackHandler(paramBundle, this, paramInt);
      paramString[i] = Proxy.newProxyInstance((ClassLoader)localObject3, new Class[] { paramBundle }, localCallbackHandler);
      label153:
      Reflect.a(localObject1).a((String)localObject2, paramString);
      return;
    }
    catch (ClassNotFoundException paramBundle)
    {
      break label153;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCall, action : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("[cmshow]cm_res", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      QLog.i("[cmshow]cm_res", 2, "onRemoteInvoke cannot get QQAppInterface");
      return null;
    }
    localObject = (QQAppInterface)localObject;
    a(paramString, paramBundle, paramInt);
    if ("action_get_user_res_info".equals(paramString))
    {
      c(paramBundle, paramInt, (QQAppInterface)localObject);
      return null;
    }
    if ("action_get_dress_info".equals(paramString))
    {
      b(paramBundle, paramInt, (QQAppInterface)localObject);
      return null;
    }
    if ("action_get_role_dir".equals(paramString))
    {
      a(paramBundle, paramInt, (QQAppInterface)localObject);
      return null;
    }
    if ("action_check_face_data_download".equals(paramString)) {
      d(paramBundle, paramInt, (QQAppInterface)localObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ApolloIPCModule
 * JD-Core Version:    0.7.0.1
 */