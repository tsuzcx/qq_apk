package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.reflect.Reflect;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "result", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
final class RemoteInvokeHandler$invoke$1
  implements EIPCResultCallback
{
  RemoteInvokeHandler$invoke$1(Ref.ObjectRef paramObjectRef1, Ref.ObjectRef paramObjectRef2) {}
  
  public final void onCallback(EIPCResult paramEIPCResult)
  {
    if ((TypeToken)this.a.element == null) {
      return;
    }
    Object localObject = paramEIPCResult.data.getString("ipc_callback_");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "cbActionName");
    localObject = ((String)localObject).substring(((String)StringsKt.split$default((CharSequence)localObject, new char[] { ';' }, false, 0, 6, null).get(0)).length() + 1);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).substring(startIndex)");
    localObject = ((TypeToken)this.a.element).b((String)localObject);
    if (localObject != null)
    {
      paramEIPCResult = paramEIPCResult.data;
      Intrinsics.checkExpressionValueIsNotNull(paramEIPCResult, "result.data");
      paramEIPCResult = ParamDeserializer.a((MethodToken)localObject, paramEIPCResult);
      Reflect.a(this.b.element).a(((MethodToken)localObject).b(), Arrays.copyOf(paramEIPCResult, paramEIPCResult.length));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.RemoteInvokeHandler.invoke.1
 * JD-Core Version:    0.7.0.1
 */