package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.apollo.utils.ProcessUtil;
import com.tencent.mobileqq.apollo.utils.reflect.Reflect;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/ApolloIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "name", "", "(Ljava/lang/String;)V", "mServiceLocks", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "", "mServlets", "mTypeTokens", "", "Lcom/tencent/mobileqq/apollo/ipc/TypeToken;", "addReturnData", "", "result", "data", "Landroid/os/Bundle;", "methodToken", "Lcom/tencent/mobileqq/apollo/ipc/MethodToken;", "api", "T", "clazz", "(Ljava/lang/Class;)Ljava/lang/Object;", "className", "(Ljava/lang/String;)Ljava/lang/Object;", "onCall", "Leipc/EIPCResult;", "action", "params", "callbackId", "", "onReceive", "register", "ApolloClientClass", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloIPCModule
  extends QIPCModule
{
  public static final ApolloIPCModule.Companion a = new ApolloIPCModule.Companion(null);
  private final ConcurrentHashMap<Class<?>, Object> b = new ConcurrentHashMap();
  private final ConcurrentHashMap<Class<?>, Object> c = new ConcurrentHashMap();
  private final Map<String, TypeToken> d = (Map)new HashMap();
  
  private ApolloIPCModule(String paramString)
  {
    super(paramString);
  }
  
  @JvmStatic
  public static final <T> T a(@NotNull Class<T> paramClass)
  {
    return a.a(paramClass);
  }
  
  private final <T> T a(String paramString)
  {
    try
    {
      ClassLoader localClassLoader = getClass().getClassLoader();
      if (localClassLoader == null) {
        Intrinsics.throwNpe();
      }
      paramString = localClassLoader.loadClass(paramString);
      if (paramString != null) {
        return c(paramString);
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }
    catch (ClassNotFoundException paramString)
    {
      throw ((Throwable)new RuntimeException(paramString.getMessage()));
    }
  }
  
  private final void a(Object paramObject, Bundle paramBundle, MethodToken paramMethodToken)
  {
    paramMethodToken = Reflect.a(paramMethodToken.e());
    ParamSerializer localParamSerializer = ParamSerializer.a;
    Intrinsics.checkExpressionValueIsNotNull(paramMethodToken, "type");
    localParamSerializer.a(paramMethodToken, paramBundle, "ipc_ret_data", paramObject, -100);
  }
  
  private final <T> T b(Class<T> paramClass)
  {
    Object localObject2 = (ServletImpl)paramClass.getAnnotation(ServletImpl.class);
    if (localObject2 == null) {}
    try
    {
      Intrinsics.throwNpe();
      localObject1 = ((ServletImpl)localObject2).a().newInstance();
      localObject2 = ((ServletImpl)localObject2).a().getInterfaces();
      m = localObject2.length;
      k = 0;
      i = 0;
    }
    catch (InstantiationException paramClass)
    {
      Object localObject1;
      int m;
      int k;
      int j;
      String str;
      throw ((Throwable)new RuntimeException(paramClass.getMessage()));
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        int i;
        paramClass = (Throwable)new RuntimeException(paramClass.getMessage());
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
      if (!Intrinsics.areEqual(paramClass, localObject2[i])) {
        break label209;
      }
      j = 1;
    }
    if (j != 0)
    {
      localObject2 = this.d;
      str = paramClass.getName();
      Intrinsics.checkExpressionValueIsNotNull(str, "clazz.name");
      ((Map)localObject2).put(str, TypeToken.a.a(paramClass));
      localObject2 = (Map)this.c;
      if (localObject1 != null)
      {
        ((Map)localObject2).put(paramClass, localObject1);
        return localObject1;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
    }
    throw ((Throwable)new RuntimeException("please check you implement setting !"));
  }
  
  private final <T> T c(Class<T> paramClass)
  {
    if (this.c.get(paramClass) != null) {
      return this.c.get(paramClass);
    }
    if (this.b.get(paramClass) == null) {
      synchronized (this.b)
      {
        if (this.b.get(paramClass) == null) {
          ((Map)this.b).put(paramClass, new Object());
        }
        localObject2 = Unit.INSTANCE;
      }
    }
    Object localObject2 = this.b.get(paramClass);
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "mServiceLocks[clazz]!!");
    try
    {
      if (this.c.get(paramClass) != null)
      {
        paramClass = this.c.get(paramClass);
        return paramClass;
      }
      if (ProcessUtil.a())
      {
        paramClass = b(paramClass);
      }
      else
      {
        ??? = paramClass.getClassLoader();
        Object localObject3 = (InvocationHandler)new RemoteInvokeHandler(paramClass);
        ??? = Proxy.newProxyInstance((ClassLoader)???, new Class[] { paramClass }, (InvocationHandler)localObject3);
        localObject3 = (Map)this.c;
        if (??? == null) {
          break label209;
        }
        ((Map)localObject3).put(paramClass, ???);
        paramClass = (Class<T>)???;
      }
      return paramClass;
      label209:
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
    }
    finally {}
  }
  
  @NotNull
  public final Bundle a(@NotNull String paramString, @Nullable Bundle paramBundle, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    Bundle localBundle = new Bundle();
    Object localObject1 = ((Collection)StringsKt.split$default((CharSequence)paramString, new String[] { ";" }, false, 0, 6, null)).toArray(new String[0]);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = (String[])localObject1;
      if (localObject2.length < 3) {
        return localBundle;
      }
      localObject3 = localObject2[0];
      localObject1 = a((String)localObject3);
      localObject2 = localObject2[1];
      paramString = paramString.substring(((String)localObject3).length() + 1);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
      localObject3 = (TypeToken)this.d.get(localObject3);
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      paramString = ((TypeToken)localObject3).b(paramString);
      if (paramString != null)
      {
        if (paramBundle == null) {
          Intrinsics.throwNpe();
        }
        paramBundle = ParamDeserializer.a(paramString, paramBundle);
        if (paramString.g() == null) {}
      }
    }
    try
    {
      localObject3 = getClass().getClassLoader();
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      Object localObject4 = paramString.g();
      if (localObject4 == null) {
        Intrinsics.throwNpe();
      }
      localObject3 = ((ClassLoader)localObject3).loadClass(((TypeToken)localObject4).a());
      int i = paramString.h();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "clazz");
      localObject4 = ((Class)localObject3).getClassLoader();
      InvocationHandler localInvocationHandler = (InvocationHandler)new CallbackHandler((Class)localObject3, (EIPCModule)this, paramInt);
      paramBundle[i] = Proxy.newProxyInstance((ClassLoader)localObject4, new Class[] { localObject3 }, localInvocationHandler);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label270:
      break label270;
    }
    paramBundle = Reflect.a(localObject1).a((String)localObject2, Arrays.copyOf(paramBundle, paramBundle.length));
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "result");
    a(paramBundle, localBundle, paramString);
    return localBundle;
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  @NotNull
  public EIPCResult onCall(@NotNull String paramString, @NotNull Bundle paramBundle, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    Intrinsics.checkParameterIsNotNull(paramBundle, "params");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, action : ");
      localStringBuilder.append(paramString);
      QLog.i("[cmshow][scripted]ApolloIPCModule", 2, localStringBuilder.toString());
    }
    paramString = EIPCResult.createSuccessResult(a(paramString, paramBundle, paramInt));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "EIPCResult.createSuccessResult(result)");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ApolloIPCModule
 * JD-Core Version:    0.7.0.1
 */