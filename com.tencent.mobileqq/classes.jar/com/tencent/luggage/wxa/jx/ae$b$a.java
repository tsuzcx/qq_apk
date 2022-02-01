package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jj.s;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatch", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "attrList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "eventCallbackId", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class ae$b$a
{
  public final void a(@Nullable b paramb, @Nullable List<s> paramList, @Nullable String paramString)
  {
    if (paramb != null)
    {
      Object localObject = (CharSequence)paramString;
      int i;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return;
      }
      localObject = new ae.b();
      if (paramList != null) {
        ((ae.b)localObject).a("contactList", ae.c().a(paramList));
      }
      ((ae.b)localObject).a("callbackId", paramString);
      paramb.a((ah)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ae.b.a
 * JD-Core Version:    0.7.0.1
 */