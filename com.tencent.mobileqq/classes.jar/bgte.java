import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import cooperation.qzone.report.lp.LpReportInfo_dc04171;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneStringMatcher;
import java.io.ByteArrayInputStream;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bgte
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString = null;
  nmg jdField_a_of_type_Nmg;
  zon jdField_a_of_type_Zon;
  boolean jdField_a_of_type_Boolean = true;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  
  public bgte()
  {
    this.mPluginNameSpace = "UrlSaveVerifyV2";
  }
  
  private Object a(String paramString)
  {
    Object localObject3 = null;
    if (this.mRuntime != null)
    {
      localObject1 = this.mRuntime.a();
      if (localObject1 == null) {
        break label91;
      }
      localObject1 = ((Activity)localObject1).getIntent();
      label27:
      if (localObject1 == null) {
        break label96;
      }
    }
    label91:
    label96:
    for (Object localObject1 = ((Intent)localObject1).getStringExtra("url");; localObject1 = null)
    {
      Object localObject2 = localObject3;
      if (a((String)localObject1))
      {
        localObject2 = localObject3;
        if (b(paramString)) {
          localObject2 = new WebResourceResponse("text/javascript", "utf-8", new ByteArrayInputStream("if(1===1){};".getBytes()));
        }
      }
      return localObject2;
      localObject1 = null;
      break;
      localObject1 = null;
      break label27;
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Nmg == null)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        this.jdField_a_of_type_Nmg = new nmg(localCustomWebView, new bgtg(this));
      }
    }
  }
  
  private String[] a()
  {
    Object localObject = nko.a().a("ban_domain", "douyin.com,huoshan.com,changba.com,toutiao.com,xiguaapp.cn,xiguashipin.cn,365yg.com,snssdk.com,ixigua.com,toutiaocdn.net,music.163.com,weibo.cn,autohome.com.cn");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return null;
      localObject = ((String)localObject).split(",");
    } while (localObject == null);
    int i = 0;
    if (i < localObject.length)
    {
      if (TextUtils.isEmpty(localObject[i])) {
        localObject[i] = "";
      }
      for (;;)
      {
        i += 1;
        break;
        localObject[i] = localObject[i].trim();
      }
    }
    return localObject;
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
  
  private boolean c(String paramString)
  {
    return nko.a().c(paramString);
  }
  
  private boolean d(String paramString)
  {
    return nko.a().d(paramString);
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
    } while (this.jdField_a_of_type_Zon == null);
    try
    {
      localObject3 = bgxd.a((String)localObject1);
      ((Bundle)localObject3).putString("uin", this.mRuntime.a().getCurrentAccountUin());
      if (localObject2 != null)
      {
        localObject2 = ((CustomWebView)localObject2).getTitle();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((Bundle)localObject3).putString("title", (String)localObject2);
        }
      }
      this.jdField_a_of_type_Zon.a(1, str, (String)localObject1, (Bundle)localObject3);
      return;
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("WebSecurityPluginV2", 1, localThrowable2, new Object[0]);
    }
  }
  
  boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str1;
    String[] arrayOfString;
    do
    {
      do
      {
        return false;
        str1 = Utils.getDomin(paramString);
      } while (TextUtils.isEmpty(str1));
      str1 = str1.toLowerCase();
      arrayOfString = a();
    } while ((arrayOfString == null) || (arrayOfString.length == 0));
    int j = arrayOfString.length;
    int i = 0;
    label53:
    String str2;
    if (i < j)
    {
      str2 = arrayOfString[i];
      if (!TextUtils.isEmpty(str2)) {
        break label79;
      }
    }
    label79:
    do
    {
      i += 1;
      break label53;
      break;
      str2 = str2.toLowerCase();
      if (str1.endsWith("." + str2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebSecurityPluginV2", 2, "match domain:" + str1 + ",webviewUrl=" + paramString);
        }
        return true;
      }
    } while (!str1.equals(str2));
    if (QLog.isColorLevel()) {
      QLog.d("WebSecurityPluginV2", 2, "match domain:" + str1 + ",webviewUrl=" + paramString);
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    Object localObject = nko.a().a("call_app", "['https?://intent\\.music\\.163\\.com.+orpheus.*','^https?://([^/]+\\.)?thefatherofsalmon\\.com[/:].+','^https?://127\\.0\\.0\\.1[/:].+','^https?://0:0:0:0:0:0:0:1[/:].+','^https?://::1[/:].+']");
    if (TextUtils.isEmpty(paramString)) {}
    while (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONArray((String)localObject);
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break;
        }
        String str = ((JSONArray)localObject).optString(i);
        if ((!TextUtils.isEmpty(str)) && (QzoneStringMatcher.isMatch(paramString, str)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebSecurityPluginV2", 2, "isUrlInRegList match url:" + paramString + " ,reg=" + str);
          }
          return true;
        }
      }
      catch (JSONException paramString)
      {
        QZLog.e("WebSecurityPluginV2", "isUrlInRegList json error.", paramString);
        return false;
      }
      i += 1;
    }
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      return a(paramString);
    }
    return super.handleEvent(paramString, paramLong);
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
              QLog.d("WebSecurityPluginV2", 2, "continueVisit url=" + npn.b(paramJsBridgeListener, new String[0]));
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
      bool2 = c(paramString1);
      if (!d(paramString1))
      {
        bool1 = true;
        this.jdField_a_of_type_Boolean = bool1;
        this.jdField_b_of_type_Boolean = false;
        paramString2 = this.mRuntime.a();
        if ((paramString2 != null) && (paramString2.mStatistics != null))
        {
          paramString2 = paramString2.mStatistics;
          if (bool2) {
            break label475;
          }
          bool1 = true;
          paramString2.B = bool1;
        }
        bool1 = true;
        if (!bool1) {
          break label502;
        }
        QLog.i("UrlCheckLog", 1, "now check url=" + npn.b(paramString1, new String[0]) + ", async=" + bool2);
        if (this.jdField_a_of_type_Zon == null)
        {
          this.jdField_a_of_type_Zon = zon.a();
          this.jdField_a_of_type_Zon.a();
        }
        localIntent = this.mRuntime.a().getIntent();
        str4 = "";
        str1 = "";
        str2 = "";
        str3 = "";
        paramString2 = str1;
        if (localIntent == null) {
          break label632;
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
          break label510;
        }
        str1 = "mqq.qrcode";
        i = 0;
        j = k;
        label392:
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Zon.a(paramString1, j, i, str2, str3, str1, paramString2, new bgtf(this, paramString1, bool2));
        if (QLog.isColorLevel()) {
          QLog.d("WebSecurityPluginV2", 1, "sendSecurityCheck url=" + paramString1);
        }
        if (bool2) {
          break label814;
        }
      }
    }
    label814:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break label169;
      label475:
      bool1 = false;
      break label212;
      if (!d(paramString1)) {}
      for (bool1 = true;; bool1 = false)
      {
        this.jdField_a_of_type_Boolean = bool1;
        bool2 = true;
        break label221;
        label502:
        break;
      }
      label510:
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
        label632:
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
    if (this.jdField_a_of_type_Zon != null)
    {
      this.jdField_a_of_type_Zon.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Zon.b();
    }
    if (this.jdField_a_of_type_Nmg != null) {
      this.jdField_a_of_type_Nmg.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgte
 * JD-Core Version:    0.7.0.1
 */