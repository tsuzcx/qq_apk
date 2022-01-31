package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import java.net.MalformedURLException;
import java.net.URL;
import kwa;
import kwb;
import kwc;
import kwd;
import kwe;
import kwf;
import kwg;
import kwh;
import kwi;
import kwj;
import kwk;

public class CustomWebChromeClient
  extends WebChromeClient
{
  QQCustomDialog a;
  public boolean a;
  
  private String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("data:")) {
      return paramContext.getString(2131435666);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    super.onConsoleMessage(paramConsoleMessage);
    VipWebViewReportLog.a(paramConsoleMessage);
    Object localObject2;
    if (((this.jdField_a_of_type_Boolean) && (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR)) || (QLog.isColorLevel())) {
      localObject2 = "";
    }
    for (;;)
    {
      try
      {
        if (paramConsoleMessage.messageLevel() != null) {
          localObject2 = "" + "messageLevel =" + paramConsoleMessage.messageLevel().toString();
        }
        localObject1 = localObject2;
        if (paramConsoleMessage.sourceId() != null) {
          localObject1 = (String)localObject2 + ", sourceId=" + paramConsoleMessage.sourceId();
        }
        localObject2 = localObject1;
        if (paramConsoleMessage.lineNumber() != 0) {
          localObject2 = (String)localObject1 + ", lineNumber=" + paramConsoleMessage.lineNumber();
        }
        localObject1 = localObject2;
        if (paramConsoleMessage.message() != null) {
          localObject1 = (String)localObject2 + ", message=" + paramConsoleMessage.message();
        }
        if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
          continue;
        }
        QLog.e("WEBVIEWCHECK", 1, "CustomWebChromeClient onConsoleMessage:" + (String)localObject1);
      }
      catch (Exception paramConsoleMessage)
      {
        Object localObject1;
        paramConsoleMessage.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        break label281;
      }
      return true;
      QLog.d("WEBVIEWCHECK", 2, "CustomWebChromeClient onConsoleMessage:" + (String)localObject1);
    }
    label281:
    return false;
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).jdField_a_of_type_Boolean)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(localContext, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(a(localContext, paramString1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131432999, new kwa(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new kwd(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    paramString1 = paramWebView.getContext();
    if (((paramString1 instanceof Activity)) && (!((Activity)paramString1).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).jdField_a_of_type_Boolean)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramString1, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131435667);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131435668, new kwk(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131435669, new kwb(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new kwc(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).jdField_a_of_type_Boolean)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(localContext, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(a(localContext, paramString1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131432999, new kwe(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131432998, new kwf(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new kwg(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).jdField_a_of_type_Boolean)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(localContext, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(a(localContext, paramString1));
      paramWebView = LayoutInflater.from(localContext).inflate(2130969036, null);
      paramString1 = (EditText)paramWebView.findViewById(2131364801);
      paramString1.setText(paramString3);
      ((TextView)paramWebView.findViewById(2131363966)).setText(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setView(paramWebView);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131432999, new kwh(this, paramJsPromptResult, paramString1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131432998, new kwi(this, paramJsPromptResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new kwj(this, paramJsPromptResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return true;
    }
    paramJsPromptResult.cancel();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebChromeClient
 * JD-Core Version:    0.7.0.1
 */