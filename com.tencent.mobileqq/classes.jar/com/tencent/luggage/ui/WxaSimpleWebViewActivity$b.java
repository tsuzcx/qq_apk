package com.tencent.luggage.ui;

import android.content.Context;
import com.tencent.xweb.WebView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/ui/WxaSimpleWebViewActivity$onPostCreate$1", "Lcom/tencent/xweb/WebView;", "loadUrl", "", "url", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaSimpleWebViewActivity$b
  extends WebView
{
  WxaSimpleWebViewActivity$b(Context paramContext)
  {
    super(localContext);
  }
  
  public void loadUrl(@Nullable String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (!WxaSimpleWebViewActivity.a(this.a, paramString)) {
      super.loadUrl(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaSimpleWebViewActivity.b
 * JD-Core Version:    0.7.0.1
 */