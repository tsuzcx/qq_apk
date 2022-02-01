package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/CallbackHandler;", "T", "Ljava/lang/reflect/InvocationHandler;", "proxyInterface", "Ljava/lang/Class;", "ipcModule", "Leipc/EIPCModule;", "callbackId", "", "(Ljava/lang/Class;Leipc/EIPCModule;I)V", "getCallbackId", "()I", "token", "Lcom/tencent/mobileqq/apollo/ipc/TypeToken;", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "onCallbackResult", "", "ipcParams", "Landroid/os/Bundle;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CallbackHandler<T>
  implements InvocationHandler
{
  private final TypeToken a;
  private final Class<T> b;
  private final EIPCModule c;
  private final int d;
  
  public CallbackHandler(@NotNull Class<T> paramClass, @NotNull EIPCModule paramEIPCModule, int paramInt)
  {
    this.b = paramClass;
    this.c = paramEIPCModule;
    this.d = paramInt;
    this.a = TypeToken.a.a(this.b);
  }
  
  private final void a(Bundle paramBundle)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = paramBundle;
    this.c.callbackResult(this.d, localEIPCResult);
  }
  
  @Nullable
  public Object invoke(@NotNull Object paramObject, @NotNull Method paramMethod, @NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "proxy");
    Intrinsics.checkParameterIsNotNull(paramMethod, "method");
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    paramObject = (MethodToken)this.a.b().get(paramMethod);
    if (paramObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "token.methods[method] ?: return null");
      paramMethod = new StringBuilder();
      paramMethod.append(this.a.a());
      paramMethod.append(';');
      paramMethod.append(paramObject.c());
      paramMethod = paramMethod.toString();
      paramObject = ParamSerializer.a.a(paramObject, paramArrayOfObject);
      paramObject.putString("ipc_callback_", paramMethod);
      a(paramObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.CallbackHandler
 * JD-Core Version:    0.7.0.1
 */