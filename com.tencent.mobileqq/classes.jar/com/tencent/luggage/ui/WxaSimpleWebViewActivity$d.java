package com.tencent.luggage.ui;

import com.tencent.xweb.WebView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "newUrl", "invoke"}, k=3, mv={1, 1, 16})
final class WxaSimpleWebViewActivity$d
  extends Lambda
  implements Function2<String, String, Unit>
{
  WxaSimpleWebViewActivity$d(WxaSimpleWebViewActivity paramWxaSimpleWebViewActivity)
  {
    super(2);
  }
  
  public final void a(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "<anonymous parameter 0>");
    if ((!this.a.isFinishing()) && (!this.a.isDestroyed()))
    {
      paramString1 = (CharSequence)paramString2;
      int i;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        WxaSimpleWebViewActivity.a(this.a).stopLoading();
        WxaSimpleWebViewActivity.a(this.a).clearHistory();
        WxaSimpleWebViewActivity.a(this.a).loadUrl(paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaSimpleWebViewActivity.d
 * JD-Core Version:    0.7.0.1
 */