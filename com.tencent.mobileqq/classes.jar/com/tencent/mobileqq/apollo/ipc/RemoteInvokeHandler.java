package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
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
  private final TypeToken jdField_a_of_type_ComTencentMobileqqApolloIpcTypeToken;
  @NotNull
  private final Class<T> jdField_a_of_type_JavaLangClass;
  
  public RemoteInvokeHandler(@NotNull Class<T> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_ComTencentMobileqqApolloIpcTypeToken = TypeToken.a.a(this.jdField_a_of_type_JavaLangClass);
  }
  
  @Nullable
  public Object invoke(@NotNull Object paramObject, @NotNull Method paramMethod, @NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "proxy");
    Intrinsics.checkParameterIsNotNull(paramMethod, "method");
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    paramObject = (MethodToken)this.jdField_a_of_type_ComTencentMobileqqApolloIpcTypeToken.a().get(paramMethod);
    if (paramObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "token.methods[method] ?: return null");
      paramMethod = new StringBuilder();
      paramMethod.append(this.jdField_a_of_type_ComTencentMobileqqApolloIpcTypeToken.a());
      paramMethod.append(';');
      paramMethod.append(paramObject.b());
      paramMethod = paramMethod.toString();
      Bundle localBundle = ParamSerializer.a.a(paramObject, paramArrayOfObject);
      if (paramObject.a())
      {
        QIPCClientHelper.getInstance().callServer("apollo_client_module", paramMethod, localBundle);
        return null;
      }
      Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
      localObjectRef.element = paramArrayOfObject[paramObject.a()];
      paramArrayOfObject = new Ref.ObjectRef();
      paramArrayOfObject.element = paramObject.a();
      QIPCClientHelper.getInstance().callServer("apollo_client_module", paramMethod, localBundle, (EIPCResultCallback)new RemoteInvokeHandler.invoke.1(paramArrayOfObject, localObjectRef));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.RemoteInvokeHandler
 * JD-Core Version:    0.7.0.1
 */