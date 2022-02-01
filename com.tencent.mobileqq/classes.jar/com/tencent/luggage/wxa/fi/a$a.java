package com.tencent.luggage.wxa.fi;

import com.tencent.luggage.opensdk.f.a;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.oo.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/permission/jsauth/JsAuthTransferLogic$OpenSdkBridgedCallbackIMPL;", "Lcom/tencent/luggage/opensdk/OpenSDKBridgedJsApi$Callback;", "context", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/JsAuthExecuteContext;", "authCallback", "Lcom/tencent/luggage/wxa/standalone_open_runtime/permission/jsauth/JsAuthTransferLogic$TransferResultCallback;", "(Lcom/tencent/mm/plugin/appbrand/permission/jsauth/JsAuthExecuteContext;Lcom/tencent/luggage/wxa/standalone_open_runtime/permission/jsauth/JsAuthTransferLogic$TransferResultCallback;)V", "getAuthCallback", "()Lcom/tencent/luggage/wxa/standalone_open_runtime/permission/jsauth/JsAuthTransferLogic$TransferResultCallback;", "getContext", "()Lcom/tencent/mm/plugin/appbrand/permission/jsauth/JsAuthExecuteContext;", "callback", "", "result", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
final class a$a
  implements f.a
{
  @NotNull
  private final d a;
  @Nullable
  private final a.b b;
  
  public a$a(@NotNull d paramd, @Nullable a.b paramb)
  {
    this.a = paramd;
    this.b = paramb;
  }
  
  public void a(@Nullable String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      this.a.a().a(this.a.d(), paramString);
    }
    paramString = this.b;
    if (paramString != null) {
      paramString.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fi.a.a
 * JD-Core Version:    0.7.0.1
 */