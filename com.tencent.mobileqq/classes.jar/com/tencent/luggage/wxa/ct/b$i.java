package com.tencent.luggage.wxa.ct;

import com.tencent.xweb.WebView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/luggage/jsapi/webview/HTMLWebViewJsRuntimeImpl;", "invoke"}, k=3, mv={1, 1, 16})
final class b$i
  extends Lambda
  implements Function0<d>
{
  b$i(b paramb)
  {
    super(0);
  }
  
  @NotNull
  public final d a()
  {
    WebView localWebView = this.a.l().getWebView();
    if (localWebView == null) {
      Intrinsics.throwNpe();
    }
    return new d(localWebView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.b.i
 * JD-Core Version:    0.7.0.1
 */