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
import kvl;
import kvm;
import kvn;
import kvo;
import kvp;
import kvq;
import kvr;
import kvs;
import kvt;
import kvu;
import kvv;

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
      return paramContext.getString(2131435683);
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131433016, new kvl(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new kvo(this, paramJsResult));
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131435684);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131435685, new kvv(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131435686, new kvm(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new kvn(this, paramJsResult));
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131433016, new kvp(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131433015, new kvq(this, paramJsResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new kvr(this, paramJsResult));
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
      paramWebView = LayoutInflater.from(localContext).inflate(2130969035, null);
      paramString1 = (EditText)paramWebView.findViewById(2131364823);
      paramString1.setText(paramString3);
      ((TextView)paramWebView.findViewById(2131363990)).setText(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setView(paramWebView);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131433016, new kvs(this, paramJsPromptResult, paramString1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131433015, new kvt(this, paramJsPromptResult));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new kvu(this, paramJsPromptResult));
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