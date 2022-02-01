package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.appstorage.n;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig$Constants;", "", "()V", "COMMON_JS_NAME", "", "TAG", "WEBVIEW_APP_JS_NAME", "supportLazyCodeLoading", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class s$a
{
  @JvmStatic
  public final boolean a(@NotNull n paramn)
  {
    Intrinsics.checkParameterIsNotNull(paramn, "$this$supportLazyCodeLoading");
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "lazyCodeLoading";
    arrayOfString[1] = "lazyCodeLoading2";
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      CharSequence localCharSequence = (CharSequence)paramn.b(arrayOfString[i]);
      int j;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        j = 0;
      } else {
        j = 1;
      }
      if (j == 0) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s.a
 * JD-Core Version:    0.7.0.1
 */