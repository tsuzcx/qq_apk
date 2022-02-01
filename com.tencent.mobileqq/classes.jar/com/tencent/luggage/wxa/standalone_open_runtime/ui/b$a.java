package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onTerminate"}, k=3, mv={1, 1, 16})
final class b$a<T>
  implements e.c<String>
{
  b$a(WxaEnterWechatInvokeManager.invoke.invokeContext.1 param1) {}
  
  public final void a(@Nullable String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    paramString = (CharSequence)paramString;
    Object localObject = (CharSequence)"ok";
    int i = 0;
    if (StringsKt.contains$default(paramString, (CharSequence)localObject, false, 2, null))
    {
      paramString = (CharSequence)this.a.b();
      if ((paramString == null) || (paramString.length() == 0)) {
        i = 1;
      }
      if (i == 0)
      {
        paramString = r.a();
        localObject = new Intent();
        Context localContext = r.a();
        String str = this.a.b();
        if (str == null) {
          Intrinsics.throwNpe();
        }
        ((Intent)localObject).setClassName(localContext, str);
        ((Intent)localObject).putExtra("com.tencent.luggage.container.BaseContainerActivity.INTENT_KEY_BRING_TO_FRONT", true);
        ((Intent)localObject).addFlags(268435456);
        paramString.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.b.a
 * JD-Core Version:    0.7.0.1
 */