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
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  String jdField_a_of_type_JavaLangString = "";
  public boolean a;
  
  public CustomWebChromeClient()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("data:")) {
      return paramContext.getString(2131693519);
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
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    super.onConsoleMessage(paramConsoleMessage);
    VipWebViewReportLog.a(paramConsoleMessage);
    if (((this.jdField_a_of_type_Boolean) && (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR)) || (QLog.isColorLevel()))
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
          if ((System.currentTimeMillis() - this.jdField_a_of_type_Long > 60000L) || (!((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)))
          {
            paramConsoleMessage = new StringBuilder();
            paramConsoleMessage.append("CustomWebChromeClient onConsoleMessage:");
            paramConsoleMessage.append((String)localObject1);
            QLog.e("WEBVIEWCHECK", 1, paramConsoleMessage.toString());
            this.jdField_a_of_type_JavaLangString = ((String)localObject1);
            this.jdField_a_of_type_Long = System.currentTimeMillis();
          }
        }
        else if ((System.currentTimeMillis() - this.jdField_a_of_type_Long > 180000L) || (!((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)))
        {
          paramConsoleMessage = new StringBuilder();
          paramConsoleMessage.append("CustomWebChromeClient onConsoleMessage:");
          paramConsoleMessage.append((String)localObject1);
          QLog.d("WEBVIEWCHECK", 2, paramConsoleMessage.toString());
          this.jdField_a_of_type_JavaLangString = ((String)localObject1);
          this.jdField_a_of_type_Long = System.currentTimeMillis();
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
      paramWebView = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if ((paramWebView != null) && (paramWebView.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(localContext, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(a(localContext, paramString1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131694583, new CustomWebChromeClient.1(this, paramJsResult));
      if (this.jdField_a_of_type_Int > 2) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(localContext.getString(2131690697), localContext.getResources().getColor(2131165349), new CustomWebChromeClient.2(this, paramJsResult, localContext));
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new CustomWebChromeClient.3(this, paramJsResult, localContext));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      this.jdField_a_of_type_Int += 1;
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
      paramWebView = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if ((paramWebView != null) && (paramWebView.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramString1, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131693518);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131690630, new CustomWebChromeClient.8(this, paramJsResult));
      if (this.jdField_a_of_type_Int > 2) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramString1.getString(2131690697), paramString1.getResources().getColor(2131165349), new CustomWebChromeClient.9(this, paramJsResult, paramString1));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690629, new CustomWebChromeClient.10(this, paramJsResult));
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new CustomWebChromeClient.11(this, paramJsResult, paramString1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
      paramWebView = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if ((paramWebView != null) && (paramWebView.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(localContext, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(a(localContext, paramString1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131694583, new CustomWebChromeClient.4(this, paramJsResult));
      if (this.jdField_a_of_type_Int > 2) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(localContext.getString(2131690697), localContext.getResources().getColor(2131165349), new CustomWebChromeClient.5(this, paramJsResult, localContext));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, new CustomWebChromeClient.6(this, paramJsResult));
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new CustomWebChromeClient.7(this, paramJsResult, localContext));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebChromeClient
 * JD-Core Version:    0.7.0.1
 */