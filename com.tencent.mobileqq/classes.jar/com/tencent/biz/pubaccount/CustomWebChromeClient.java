package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomWebChromeClient
  extends WebChromeClient
{
  QQCustomDialog a;
  public boolean b = false;
  int c = 0;
  long d = 0L;
  String e = "";
  
  private String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("data:")) {
      return paramContext.getString(2131891073);
    }
    try
    {
      paramContext = new URL(paramString).getHost();
      return paramContext;
    }
    catch (MalformedURLException paramContext) {}
    return paramString;
  }
  
  public void a()
  {
    QQCustomDialog localQQCustomDialog = this.a;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.a.cancel();
    }
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    super.onConsoleMessage(paramConsoleMessage);
    VipWebViewReportLog.a(paramConsoleMessage);
    if (((this.b) && (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR)) || (QLog.isColorLevel()))
    {
      Object localObject2 = "";
      try
      {
        if (paramConsoleMessage.messageLevel() != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append("messageLevel =");
          ((StringBuilder)localObject1).append(paramConsoleMessage.messageLevel().toString());
          localObject2 = ((StringBuilder)localObject1).toString();
        }
        Object localObject1 = localObject2;
        if (paramConsoleMessage.sourceId() != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(", sourceId=");
          ((StringBuilder)localObject1).append(paramConsoleMessage.sourceId());
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = localObject1;
        if (paramConsoleMessage.lineNumber() != 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(", lineNumber=");
          ((StringBuilder)localObject2).append(paramConsoleMessage.lineNumber());
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject1 = localObject2;
        if (paramConsoleMessage.message() != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(", message=");
          ((StringBuilder)localObject1).append(paramConsoleMessage.message());
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        paramConsoleMessage = paramConsoleMessage.messageLevel();
        localObject2 = ConsoleMessage.MessageLevel.ERROR;
        if (paramConsoleMessage == localObject2)
        {
          if ((System.currentTimeMillis() - this.d > 60000L) || (!((String)localObject1).equals(this.e)))
          {
            paramConsoleMessage = new StringBuilder();
            paramConsoleMessage.append("CustomWebChromeClient onConsoleMessage:");
            paramConsoleMessage.append((String)localObject1);
            QLog.e("WEBVIEWCHECK", 1, paramConsoleMessage.toString());
            this.e = ((String)localObject1);
            this.d = System.currentTimeMillis();
          }
        }
        else if ((System.currentTimeMillis() - this.d > 180000L) || (!((String)localObject1).equals(this.e)))
        {
          paramConsoleMessage = new StringBuilder();
          paramConsoleMessage.append("CustomWebChromeClient onConsoleMessage:");
          paramConsoleMessage.append((String)localObject1);
          QLog.d("WEBVIEWCHECK", 2, paramConsoleMessage.toString());
          this.e = ((String)localObject1);
          this.d = System.currentTimeMillis();
        }
      }
      catch (Exception paramConsoleMessage)
      {
        paramConsoleMessage.printStackTrace();
      }
    }
    return QLog.isColorLevel() ^ true;
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).isPaused)))
    {
      paramWebView = this.a;
      if ((paramWebView != null) && (paramWebView.isShowing())) {
        this.a.dismiss();
      }
      this.a = DialogUtil.a(localContext, 0);
      this.a.setTitle(a(localContext, paramString1));
      this.a.setMessage(paramString2);
      this.a.setPositiveButton(2131892267, new CustomWebChromeClient.1(this, paramJsResult));
      if (this.c > 2) {
        this.a.setNegativeButton(localContext.getString(2131887616), localContext.getResources().getColor(2131165591), new CustomWebChromeClient.2(this, paramJsResult, localContext));
      }
      this.a.setOnCancelListener(new CustomWebChromeClient.3(this, paramJsResult, localContext));
      this.a.show();
      this.c += 1;
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    paramString1 = paramWebView.getContext();
    if (((paramString1 instanceof Activity)) && (!((Activity)paramString1).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).isPaused)))
    {
      paramWebView = this.a;
      if ((paramWebView != null) && (paramWebView.isShowing())) {
        this.a.dismiss();
      }
      this.a = DialogUtil.a(paramString1, 0);
      this.a.setTitle(2131891072);
      this.a.setMessage(paramString2);
      this.a.setPositiveButton(2131887541, new CustomWebChromeClient.8(this, paramJsResult));
      if (this.c > 2) {
        this.a.setNegativeButton(paramString1.getString(2131887616), paramString1.getResources().getColor(2131165591), new CustomWebChromeClient.9(this, paramJsResult, paramString1));
      } else {
        this.a.setNegativeButton(2131887540, new CustomWebChromeClient.10(this, paramJsResult));
      }
      this.a.setOnCancelListener(new CustomWebChromeClient.11(this, paramJsResult, paramString1));
      this.a.show();
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).isPaused)))
    {
      paramWebView = this.a;
      if ((paramWebView != null) && (paramWebView.isShowing())) {
        this.a.dismiss();
      }
      this.a = DialogUtil.a(localContext, 0);
      this.a.setTitle(a(localContext, paramString1));
      this.a.setMessage(paramString2);
      this.a.setPositiveButton(2131892267, new CustomWebChromeClient.4(this, paramJsResult));
      if (this.c > 2) {
        this.a.setNegativeButton(localContext.getString(2131887616), localContext.getResources().getColor(2131165591), new CustomWebChromeClient.5(this, paramJsResult, localContext));
      } else {
        this.a.setNegativeButton(2131887648, new CustomWebChromeClient.6(this, paramJsResult));
      }
      this.a.setOnCancelListener(new CustomWebChromeClient.7(this, paramJsResult, localContext));
      this.a.show();
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    paramJsPromptResult.cancel();
    return true;
  }
  
  @Override
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebChromeClient
 * JD-Core Version:    0.7.0.1
 */