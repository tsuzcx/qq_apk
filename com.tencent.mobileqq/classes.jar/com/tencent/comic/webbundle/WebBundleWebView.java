package com.tencent.comic.webbundle;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.comic.config.QQComicConfBean;
import com.tencent.comic.config.QQComicConfBean.WebBundleConfig;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.webbundle.sdk.IWebBundleWebView;
import com.tencent.webbundle.sdk.IWebBundleWebView.OnPageFinishedListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class WebBundleWebView
  extends TouchWebView
  implements IWebBundleWebView
{
  public WebBundleWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WebBundleWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean canGoBack()
  {
    Object localObject = copyBackForwardList();
    if ((localObject != null) && (((WebBackForwardList)localObject).getSize() > 0))
    {
      localObject = ((WebBackForwardList)localObject).getItemAtIndex(0);
      if (localObject != null)
      {
        localObject = ((WebHistoryItem)localObject).getUrl();
        QQComicConfBean localQQComicConfBean = (QQComicConfBean)QConfigManager.b().b(534);
        if ((localQQComicConfBean != null) && (localQQComicConfBean.a.b.equals(localObject))) {
          return super.canGoBackOrForward(-2);
        }
      }
    }
    return super.canGoBack();
  }
  
  public void dispatchJsEvent(@NotNull String paramString, @NotNull JSONObject paramJSONObject1, @Nullable JSONObject paramJSONObject2)
  {
    callJs(WebViewPlugin.toJsScript(paramString, paramJSONObject1, paramJSONObject2));
  }
  
  public void enableJavaScript(boolean paramBoolean)
  {
    getSettings().setJavaScriptEnabled(paramBoolean);
  }
  
  public void setOnPageFinishedListener(@NotNull IWebBundleWebView.OnPageFinishedListener paramOnPageFinishedListener)
  {
    setWebViewClient(new WebBundleWebView.1(this, paramOnPageFinishedListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.webbundle.WebBundleWebView
 * JD-Core Version:    0.7.0.1
 */