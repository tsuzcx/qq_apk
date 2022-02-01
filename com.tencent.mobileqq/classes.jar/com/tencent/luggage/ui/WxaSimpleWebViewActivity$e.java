package com.tencent.luggage.ui;

import android.webkit.URLUtil;
import com.tencent.xweb.WebView;
import com.tencent.xweb.u;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/ui/WxaSimpleWebViewActivity$onPostCreate$5", "Lcom/tencent/xweb/WebChromeClient;", "onReceivedTitle", "", "view", "Lcom/tencent/xweb/WebView;", "title", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaSimpleWebViewActivity$e
  extends u
{
  public void a(@Nullable WebView paramWebView, @Nullable String paramString)
  {
    paramWebView = (CharSequence)paramString;
    int i;
    if ((paramWebView != null) && (paramWebView.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (!URLUtil.isAboutUrl(paramString))) {
      this.a.setTitle(paramWebView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaSimpleWebViewActivity.e
 * JD-Core Version:    0.7.0.1
 */