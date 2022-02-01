import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import cooperation.qzone.report.lp.LpReportInfo_dc04171;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class bimw
  extends WebViewPlugin
{
  aasb jdField_a_of_type_Aasb;
  String jdField_a_of_type_JavaLangString = null;
  nkr jdField_a_of_type_Nkr;
  boolean jdField_a_of_type_Boolean = true;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  
  public bimw()
  {
    this.mPluginNameSpace = "UrlSaveVerifyV2";
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Nkr == null)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        this.jdField_a_of_type_Nkr = new nkr(localCustomWebView, new bimy(this));
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return niz.a().c(paramString);
  }
  
  private void b()
  {
    int m = -1;
    int k = 2;
    int n = 0;
    if ((this.mRuntime == null) || (this.mRuntime.a() == null))
    {
      QLog.e("WebSecurityPluginV2", 1, "reportSoftKeyboardToggled mRuntime empty");
      return;
    }
    Intent localIntent = this.mRuntime.a().getIntent();
    String str3 = "";
    Object localObject = this.mRuntime.a();
    if (localObject != null) {
      str3 = ((CustomWebView)localObject).getOriginalUrl();
    }
    String str4 = "";
    String str5 = "";
    String str6 = "";
    localObject = str4;
    int i = m;
    int j = n;
    String str1 = str5;
    String str2 = str6;
    if (localIntent != null)
    {
      if (!localIntent.getBooleanExtra("fromQrcode", false)) {
        break label245;
      }
      localObject = "mqq.qrcode";
      str2 = str6;
      str1 = str5;
      j = n;
      i = m;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSecurityPluginV2", 1, "reportSoftKeyboardToggled-- referer:" + str3 + " ,url:" + this.jdField_b_of_type_JavaLangString + " ,msgType:" + i + ",msgFrom:" + j + ",senderUin:" + str1 + ",chatId:" + str2 + ",urlSource:" + (String)localObject);
      }
      LpReportInfo_dc04171.report(this.jdField_b_of_type_JavaLangString, str3, (String)localObject, i, j, str1, str2);
      return;
      label245:
      if (localIntent.getBooleanExtra("key_isFromQZone", false))
      {
        localObject = "mqq.qzone";
        i = m;
        j = n;
        str1 = str5;
        str2 = str6;
      }
      else
      {
        j = localIntent.getIntExtra("uinType", -1);
        i = j;
        if (j == -1) {
          i = localIntent.getIntExtra("curtype", -1);
        }
        switch (i)
        {
        default: 
          QLog.d("WebSecurityPluginV2", 4, "reportSoftKeyboardToggled:unknow uinType");
          localObject = str4;
          i = m;
          j = n;
          str1 = str5;
          str2 = str6;
          break;
        case 0: 
          localObject = "mqq.c2c";
          str2 = localIntent.getStringExtra("friend_uin");
          str1 = localIntent.getStringExtra("friendUin");
          if (localIntent.getBooleanExtra("is_send", false)) {
            k = 1;
          }
          i = 0;
          j = k;
          break;
        case 1: 
          str2 = localIntent.getStringExtra("groupUin");
          str1 = localIntent.getStringExtra("friendUin");
          if (localIntent.getBooleanExtra("is_send", false)) {}
          for (i = 1;; i = 2)
          {
            j = i;
            localObject = "mqq.group";
            i = 2;
            break;
          }
        case 3000: 
          localObject = "mqq.discussion";
          i = 3;
          str2 = localIntent.getStringExtra("dicussgroup_uin");
          str1 = localIntent.getStringExtra("friendUin");
          if (localIntent.getBooleanExtra("is_send", false)) {
            k = 1;
          }
          j = k;
          break;
        case 1000: 
        case 1001: 
        case 1004: 
        case 1005: 
          str2 = localIntent.getStringExtra("friend_uin");
          str1 = localIntent.getStringExtra("friendUin");
          if (localIntent.getBooleanExtra("is_send", false)) {
            k = 1;
          }
          j = k;
          i = 1;
          localObject = str4;
        }
      }
    }
  }
  
  private boolean b(String paramString)
  {
    return niz.a().d(paramString);
  }
  
  void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebSecurityPluginV2", 2, new Object[] { "checkOperationBit ", Long.valueOf(paramLong) });
    }
    CustomWebView localCustomWebView;
    if ((1L & paramLong) != 0L)
    {
      localCustomWebView = this.mRuntime.a();
      if (localCustomWebView == null) {}
    }
    Object localObject1;
    Object localObject3;
    String str;
    Object localObject2;
    do
    {
      do
      {
        try
        {
          if (localCustomWebView.getX5WebViewExtension() != null)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("forbid-input", "*");
            localCustomWebView.getX5WebViewExtension().setFakeLoginParams((Bundle)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("WebSecurityPluginV2", 2, "checkOperationBit success");
            }
          }
          return;
        }
        catch (Throwable localThrowable1)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e("WebSecurityPluginV2", 2, "initWebviewExtension e:", localThrowable1);
          return;
        }
      } while ((0x4 & paramLong) == 0L);
      localObject3 = this.mRuntime.a().getIntent();
      localObject1 = "";
      str = "";
      localObject2 = this.mRuntime.a();
      if (localObject2 != null) {
        str = ((CustomWebView)localObject2).getUrl();
      }
      if (localObject3 != null) {
        localObject1 = ((Intent)localObject3).getStringExtra("url");
      }
    } while (this.jdField_a_of_type_Aasb == null);
    try
    {
      localObject3 = biqx.a((String)localObject1);
      ((Bundle)localObject3).putString("uin", this.mRuntime.a().getCurrentAccountUin());
      if (localObject2 != null)
      {
        localObject2 = ((CustomWebView)localObject2).getTitle();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((Bundle)localObject3).putString("title", (String)localObject2);
        }
      }
      this.jdField_a_of_type_Aasb.a(1, str, (String)localObject1, (Bundle)localObject3);
      return;
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("WebSecurityPluginV2", 1, localThrowable2, new Object[0]);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("UrlSaveVerifyV2".equals(paramString2)) && ("continueVisit".equals(paramString3)) && (paramVarArgs.length > 0)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("url");
        if (!TextUtils.isEmpty(paramJsBridgeListener))
        {
          paramString1 = this.mRuntime.a();
          if (paramString1 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("WebSecurityPluginV2", 2, "continueVisit url=" + noe.b(paramJsBridgeListener, new String[0]));
            }
            this.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
            paramString1.loadUrl(paramJsBridgeListener);
            return false;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("WebSecurityPluginV2", 2, "jump url is null");
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        QLog.e("WebSecurityPluginV2", 1, paramJsBridgeListener.toString());
      }
    }
    return false;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    int k = -1;
    int i = 2;
    boolean bool3 = true;
    if (("http".equals(paramString2)) || ("https".equals(paramString2)))
    {
      if ((this.mRuntime != null) && (this.mRuntime.a() != null)) {
        break label56;
      }
      QLog.e("WebSecurityPluginV2", 1, "handleSchemaRequest mRuntime empty");
    }
    label56:
    do
    {
      return false;
      a();
      paramString2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramString2 != null) && (!paramString2.isLogin()))
      {
        QLog.e("WebSecurityPluginV2", 1, "appRuntime.isLogin() is false!");
        return false;
      }
      if (!AppNetConnInfo.isNetSupport())
      {
        QLog.e("WebSecurityPluginV2", 1, "no network");
        return false;
      }
      this.jdField_b_of_type_JavaLangString = paramString1;
      if (!paramString1.equals(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = null;
    } while (!QLog.isColorLevel());
    QLog.i("WebSecurityPluginV2", 2, "should pass check");
    return false;
    boolean bool2;
    label169:
    label212:
    label221:
    Intent localIntent;
    String str4;
    String str1;
    String str2;
    String str3;
    int j;
    if (this.jdField_b_of_type_Boolean)
    {
      bool2 = a(paramString1);
      if (!b(paramString1))
      {
        bool1 = true;
        this.jdField_a_of_type_Boolean = bool1;
        this.jdField_b_of_type_Boolean = false;
        paramString2 = this.mRuntime.a();
        if ((paramString2 != null) && (paramString2.mStatistics != null))
        {
          paramString2 = paramString2.mStatistics;
          if (bool2) {
            break label471;
          }
          bool1 = true;
          paramString2.B = bool1;
        }
        bool1 = true;
        if (!bool1) {
          break label498;
        }
        QLog.i("UrlCheckLog", 1, "now check url=" + noe.b(paramString1, new String[0]) + ", async=" + bool2);
        if (this.jdField_a_of_type_Aasb == null)
        {
          this.jdField_a_of_type_Aasb = aasb.a();
          this.jdField_a_of_type_Aasb.a();
        }
        localIntent = this.mRuntime.a().getIntent();
        str4 = "";
        str1 = "";
        str2 = "";
        str3 = "";
        paramString2 = str1;
        if (localIntent == null) {
          break label628;
        }
        CustomWebView localCustomWebView = this.mRuntime.a();
        paramString2 = str1;
        if (localCustomWebView != null)
        {
          str1 = localCustomWebView.getUrl();
          paramString2 = str1;
          if (TextUtils.isEmpty(str1)) {
            paramString2 = localIntent.getStringExtra("url");
          }
        }
        if (!localIntent.getBooleanExtra("fromQrcode", false)) {
          break label506;
        }
        str1 = "mqq.qrcode";
        i = 0;
        j = k;
        label392:
        this.jdField_a_of_type_Aasb.a(paramString1, j, i, str2, str3, str1, paramString2, new bimx(this, paramString1, bool2));
        if (QLog.isColorLevel()) {
          QLog.d("WebSecurityPluginV2", 1, "sendSecurityCheck url=" + paramString1);
        }
        if (bool2) {
          break label810;
        }
      }
    }
    label810:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break label169;
      label471:
      bool1 = false;
      break label212;
      if (!b(paramString1)) {}
      for (bool1 = true;; bool1 = false)
      {
        this.jdField_a_of_type_Boolean = bool1;
        bool2 = true;
        break label221;
        label498:
        break;
      }
      label506:
      if (localIntent.getBooleanExtra("key_isFromQZone", false))
      {
        str1 = "mqq.qzone";
        i = 0;
        j = k;
        break label392;
      }
      int m = localIntent.getIntExtra("uinType", -1);
      j = m;
      if (m == -1) {
        j = localIntent.getIntExtra("curtype", -1);
      }
      switch (j)
      {
      default: 
        i = 0;
        j = k;
        str1 = str4;
        break;
      case 0: 
        str1 = "mqq.c2c";
        str3 = localIntent.getStringExtra("friend_uin");
        str2 = localIntent.getStringExtra("friendUin");
        if (localIntent.getBooleanExtra("is_send", false)) {
          i = 1;
        }
        j = 0;
        break;
      case 1: 
        str1 = "mqq.group";
        str3 = localIntent.getStringExtra("groupUin");
        str2 = localIntent.getStringExtra("friendUin");
        if (localIntent.getBooleanExtra("is_send", false)) {}
        for (i = 1;; i = 2)
        {
          j = 2;
          break;
        }
      case 3000: 
        str1 = "mqq.discussion";
        j = 3;
        str3 = localIntent.getStringExtra("dicussgroup_uin");
        str2 = localIntent.getStringExtra("friendUin");
        if (localIntent.getBooleanExtra("is_send", false)) {
          i = 1;
        }
        break;
      case 1000: 
      case 1001: 
      case 1004: 
      case 1005: 
        label628:
        str3 = localIntent.getStringExtra("friend_uin");
        str2 = localIntent.getStringExtra("friendUin");
        if (localIntent.getBooleanExtra("is_send", false)) {
          i = 1;
        }
        j = 1;
        str1 = str4;
        break;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aasb != null) {
      this.jdField_a_of_type_Aasb.b();
    }
    if (this.jdField_a_of_type_Nkr != null) {
      this.jdField_a_of_type_Nkr.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimw
 * JD-Core Version:    0.7.0.1
 */