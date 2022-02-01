package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.u;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"queryAttrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke", "com/tencent/luggage/wxa/standalone_open_runtime/ui/WxaProfileActivity$fillData$1$1$1$1$1"}, k=3, mv={1, 1, 16})
final class WxaProfileActivity$fillData$$inlined$let$lambda$1$1$1$1
  extends Lambda
  implements Function0<s>
{
  WxaProfileActivity$fillData$$inlined$let$lambda$1$1$1$1(WxaProfileActivity.fillData..inlined.let.lambda.1.1.1 param1)
  {
    super(0);
  }
  
  @Nullable
  public final s invoke()
  {
    s locals = u.a().b(this.a.b.e.c, new String[] { "appId", "username", "nickname", "signature", "brandIconURL", "dynamicInfo", "versionInfo", "appInfo", "registerSource", "bindWxaInfo" });
    if (locals != null)
    {
      WxaProfileActivity localWxaProfileActivity = this.a.b.e.d;
      String str = locals.c;
      Intrinsics.checkExpressionValueIsNotNull(str, "it.field_username");
      WxaProfileActivity.b(localWxaProfileActivity, str);
      localWxaProfileActivity = this.a.b.e.d;
      str = locals.d;
      Intrinsics.checkExpressionValueIsNotNull(str, "it.field_appId");
      WxaProfileActivity.a(localWxaProfileActivity, str);
    }
    return locals;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity.fillData..inlined.let.lambda.1.1.1.1
 * JD-Core Version:    0.7.0.1
 */