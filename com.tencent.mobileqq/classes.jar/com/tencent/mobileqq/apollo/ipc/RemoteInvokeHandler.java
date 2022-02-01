package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.reflect.Reflect;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/RemoteInvokeHandler;", "T", "Ljava/lang/reflect/InvocationHandler;", "proxyInterface", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getProxyInterface", "()Ljava/lang/Class;", "token", "Lcom/tencent/mobileqq/apollo/ipc/TypeToken;", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class RemoteInvokeHandler<T>
  implements InvocationHandler
{
  private final TypeToken a;
  @NotNull
  private final Class<T> b;
  
  public RemoteInvokeHandler(@NotNull Class<T> paramClass)
  {
    this.b = paramClass;
    this.a = TypeToken.a.a(this.b);
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
      Bundle localBundle = ParamSerializer.a.a(paramObject, paramArrayOfObject);
      if (paramObject.a())
      {
        paramMethod = QIPCClientHelper.getInstance().callServer("apollo_client_module", paramMethod, localBundle);
        Intrinsics.checkExpressionValueIsNotNull(paramMethod, "result");
        if (paramMethod.isSuccess())
        {
          paramObject = Reflect.a(paramObject.e());
          paramArrayOfObject = ParamDeserializer.a;
          Intrinsics.checkExpressionValueIsNotNull(paramObject, "type");
          paramMethod = paramMethod.data;
          Intrinsics.checkExpressionValueIsNotNull(paramMethod, "result.data");
          paramArrayOfObject.a(paramObject, -100, paramMethod, "ipc_ret_data");
          return null;
        }
      }
      else
      {
        Ref.ObjectRef localObjectRef1 = new Ref.ObjectRef();
        localObjectRef1.element = paramObject.g();
        Ref.ObjectRef localObjectRef2 = new Ref.ObjectRef();
        if ((TypeToken)localObjectRef1.element == null) {
          paramObject = Integer.valueOf(-1);
        } else {
          paramObject = paramArrayOfObject[paramObject.h()];
        }
        localObjectRef2.element = paramObject;
        QIPCClientHelper.getInstance().callServer("apollo_client_module", paramMethod, localBundle, (EIPCResultCallback)new RemoteInvokeHandler.invoke.1(localObjectRef1, localObjectRef2));
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.RemoteInvokeHandler
 * JD-Core Version:    0.7.0.1
 */