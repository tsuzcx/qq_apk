package com.tencent.luggage.wxa.fd;

import com.tencent.luggage.wxa.fi.a.b;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.ka.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxa/standalone_open_runtime/jsapi/auth/JsApiAuthorizeWithTransferAction$unhandledCgiException$1", "Lcom/tencent/luggage/wxa/standalone_open_runtime/permission/jsauth/JsAuthTransferLogic$TransferResultCallback;", "onAuthorized", "", "onCanceled", "onExecuteResultReceived", "message", "", "onInterrupted", "e", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$a
  implements a.b
{
  a$a(b paramb, int paramInt, e parame) {}
  
  public void a() {}
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Throwable))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fail ");
      ((StringBuilder)localObject).append(((Throwable)paramObject).getMessage());
      paramObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fail ");
      ((StringBuilder)localObject).append(paramObject);
      paramObject = ((StringBuilder)localObject).toString();
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((b)localObject).a(this.c, this.a.b(paramObject));
    }
    paramObject = this.d;
    if (paramObject != null) {
      paramObject.a();
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    this.b.a(this.c, paramString);
    paramString = this.d;
    if (paramString != null) {
      paramString.a();
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fd.a.a
 * JD-Core Version:    0.7.0.1
 */