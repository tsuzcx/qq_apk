package com.tencent.luggage.ui;

import com.tencent.luggage.wxa.cv.i;
import com.tencent.xweb.WebView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/ui/WxaSimpleWebViewActivity$onPostCreate$3", "Lcom/tencent/luggage/jsapi/webview/model/WebViewController;", "currentUrl", "", "getCurrentUrl", "()Ljava/lang/String;", "getA8keyScene", "", "getGetA8keyScene", "()I", "hostWxaAppId", "getHostWxaAppId", "webViewID", "getWebViewID", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaSimpleWebViewActivity$c
  implements i
{
  private final int b;
  @Nullable
  private final String c;
  private final int d;
  @Nullable
  private final String e;
  
  WxaSimpleWebViewActivity$c()
  {
    this.b = WxaSimpleWebViewActivity.a(localWxaSimpleWebViewActivity).hashCode();
    this.e = WxaSimpleWebViewActivity.a(localWxaSimpleWebViewActivity).getUrl();
  }
  
  public int a()
  {
    return this.b;
  }
  
  @Nullable
  public String b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  @Nullable
  public String d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaSimpleWebViewActivity.c
 * JD-Core Version:    0.7.0.1
 */