package com.tencent.luggage.wxa.fi;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.oo.a.c;
import com.tencent.luggage.wxa.oo.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxa/standalone_open_runtime/permission/jsauth/JsAuthTransferLogic$cgiTransferActionHandler$1$1", "Lcom/tencent/luggage/wxa/standalone_open_runtime/permission/jsauth/JsAuthTransferLogic$TransferResultCallback;", "onAuthorized", "", "onCanceled", "onExecuteResultReceived", "message", "", "onInterrupted", "e", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$c$1
  implements a.b
{
  a$c$1(d paramd, a.c paramc) {}
  
  public void a()
  {
    a.c localc = this.b;
    if (localc != null) {
      localc.a();
    }
  }
  
  public void a(@Nullable Object paramObject)
  {
    paramObject = this.b;
    if (paramObject != null) {
      paramObject.b();
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    d locald = this.a;
    if (locald == null) {
      Intrinsics.throwNpe();
    }
    locald.a().a(this.a.d(), paramString);
    paramString = this.b;
    if (paramString != null) {
      paramString.b();
    }
  }
  
  public void b()
  {
    a.c localc = this.b;
    if (localc != null) {
      localc.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fi.a.c.1
 * JD-Core Version:    0.7.0.1
 */