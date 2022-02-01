package com.tencent.mobileqq.antiphing;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.AppInterface;
import com.tencent.ims.antiphishingAlertQuery.RequestPack;
import com.tencent.ims.antiphishingAlertQuery.ResponsePack;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.AntiphingToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class AntiphingHandler
  extends WebViewPlugin
  implements BusinessObserver
{
  private int jdField_a_of_type_Int = 1;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = null;
  private AntiphishingUrlConfig jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig = null;
  BrowserAppInterface jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private AntiphingToast jdField_a_of_type_ComTencentMobileqqWidgetAntiphingToast = null;
  private String jdField_a_of_type_JavaLangString = "Antiphishing";
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 1;
  private boolean jdField_b_of_type_Boolean = true;
  private final int c = 0;
  private final int d = 1;
  
  public AntiphingHandler()
  {
    this.mPluginNameSpace = "InputClickEvent";
  }
  
  private String a()
  {
    Object localObject2 = this.mRuntime;
    Object localObject1 = null;
    if (localObject2 != null)
    {
      localObject2 = this.mRuntime.a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      }
      if (localObject1 == null) {
        return null;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((AppInterface)localObject1).getApplication().getFilesDir().getAbsolutePath());
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("antiphishingconfig.xml");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    return localObject1;
  }
  
  private void a(int paramInt)
  {
    try
    {
      ReportController.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "UserChoose", 0, paramInt, "", "", "", "");
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, paramInt, paramString2);
    }
  }
  
  private boolean a(Context paramContext, String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        a(this.jdField_a_of_type_JavaLangString, 2, "Toast Already Shown! yoffset ");
      }
      return false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramContext = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Show Toast! yoffset =  ");
      ((StringBuilder)localObject).append(paramInt);
      a(paramContext, 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout == null) && (this.mRuntime != null) && (this.mRuntime.a() != null)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.mRuntime.a().findViewById(2131362722));
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqWidgetAntiphingToast;
    if (paramContext != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (localObject != null)
      {
        paramContext.a(2131719708, 3000, (FrameLayout)localObject);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAntiphingToast.a(paramString);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return false;
    }
    paramString.toLowerCase();
    try
    {
      str = new URL(paramString).getHost();
    }
    catch (MalformedURLException localMalformedURLException)
    {
      String str;
      label29:
      Object localObject;
      StringBuilder localStringBuilder;
      boolean bool;
      break label29;
    }
    str = "";
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" Is QQ Domain, input url  : ");
      localStringBuilder.append(Util.b(paramString, new String[0]));
      localStringBuilder.append(" Domain = ");
      localStringBuilder.append(str);
      a((String)localObject, 2, localStringBuilder.toString());
    }
    if ((!str.endsWith("qq.com")) && (!str.endsWith("tencent.com")) && (!str.endsWith("imqq.com")) && (!str.endsWith("wanggou.com")) && (!str.endsWith("paipai.com")) && (!str.endsWith("tenpay.com")) && (!str.endsWith("yixun.com")) && (!str.endsWith("weiyun.com")) && (!str.endsWith("soso.com")) && (!str.endsWith("myapp.com")) && (!str.endsWith("wechat.com")) && (!str.endsWith("gaopeng.com")) && (!str.endsWith("pengyou.com")) && (!str.endsWith("51buy.com")) && (!str.endsWith("weishi.com")) && (!str.endsWith("qqumall.com")) && (!str.endsWith("vip.surex.cn"))) {
      bool = false;
    } else {
      bool = true;
    }
    if (!a())
    {
      if (!bool)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig;
        if (localObject != null)
        {
          localObject = ((AntiphishingUrlConfig)localObject).a();
          if (localObject != null) {
            while (i < ((ArrayList)localObject).size())
            {
              if (str.endsWith((String)((ArrayList)localObject).get(i)))
              {
                if (QLog.isColorLevel())
                {
                  localObject = this.jdField_a_of_type_JavaLangString;
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(" Is trust Domain, match config, input url  : ");
                  localStringBuilder.append(paramString);
                  localStringBuilder.append(" Domain = ");
                  localStringBuilder.append(str);
                  a((String)localObject, 2, localStringBuilder.toString());
                }
                return true;
              }
              i += 1;
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Low Memory !");
    }
    return bool;
  }
  
  private boolean a(String paramString, AntiphingHandler.InfoData paramInfoData)
  {
    if (paramString == null) {
      return false;
    }
    String str = paramString.trim().toLowerCase().replace(" ", "");
    boolean bool = str.endsWith("@qq.com");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;
    }
    if (paramString == null) {
      return false;
    }
    paramString = paramString.getApplication().getAllAccounts();
    if ((paramString != null) && (paramString.size() != 0))
    {
      int i = 0;
      while (i < paramString.size())
      {
        localObject = (SimpleAccount)paramString.get(i);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sAccount == null!");
          }
        }
        else
        {
          localObject = ((SimpleAccount)localObject).getUin();
          if (localObject != null)
          {
            if (((String)localObject).equalsIgnoreCase(str))
            {
              paramInfoData.jdField_a_of_type_JavaLangString = ((String)localObject);
              paramInfoData.jdField_a_of_type_Int = 1;
              return true;
            }
            if ((bool == true) && (str.contains((CharSequence)localObject)))
            {
              paramInfoData.jdField_a_of_type_JavaLangString = ((String)localObject);
              paramInfoData.jdField_a_of_type_Int = 2;
              return true;
            }
          }
        }
        i += 1;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "uin number is zero!");
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    if (i > 1000000) {
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, Long paramLong, int paramInt5)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Send a Packet to Server!, xffset = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" yoffset = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" nWidth = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" nHeight = ");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(" url=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" uin=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" AccountType = ");
      localStringBuilder.append(paramInt5);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramLong.longValue() != 0L)
    {
      if (paramString == null) {
        return;
      }
      localObject = new antiphishingAlertQuery.RequestPack();
      ((antiphishingAlertQuery.RequestPack)localObject).u32_app_type.set(2);
      ((antiphishingAlertQuery.RequestPack)localObject).u64_input_uin.set(paramLong.longValue());
      ((antiphishingAlertQuery.RequestPack)localObject).u32_account_type.set(paramInt5);
      ((antiphishingAlertQuery.RequestPack)localObject).u32_ctrl_height.set(paramInt4);
      ((antiphishingAlertQuery.RequestPack)localObject).u32_ctrl_width.set(paramInt3);
      ((antiphishingAlertQuery.RequestPack)localObject).i32_xoffset.set(paramInt1);
      ((antiphishingAlertQuery.RequestPack)localObject).i32_yoffset.set(paramInt2);
      ((antiphishingAlertQuery.RequestPack)localObject).str_url.set(paramString);
      ((antiphishingAlertQuery.RequestPack)localObject).u32_seq.set(this.jdField_a_of_type_Int);
      ((antiphishingAlertQuery.RequestPack)localObject).u32_proto_ver.set(1);
      paramLong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramString = paramLong;
      if (paramLong == null) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;
      }
      if (paramString == null) {
        return;
      }
      if (this.mRuntime.a() != null)
      {
        paramLong = new NewIntent(this.mRuntime.a().getApplicationContext(), ProtoServlet.class);
        paramLong.putExtra("uin", paramString.getAccount());
        paramLong.putExtra("data", ((antiphishingAlertQuery.RequestPack)localObject).toByteArray());
        paramLong.putExtra("cmd", "SecuritySvc.UrlQuery");
        paramLong.setObserver(this);
        paramString.startServlet(paramLong);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (a(paramString))
    {
      if (QLog.isColorLevel()) {
        a(this.jdField_a_of_type_JavaLangString, 2, "IS QQ Domain! ");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      a(this.jdField_a_of_type_JavaLangString, 2, "The url is not QQ Domain and load js into webview");
    }
    callJs("(function(){var objs = document.getElementsByTagName(\"input\");for(var i=0;i<objs.length;i++){if(objs[i].type!='password'){objs[i].addEventListener('blur',function(e){  var valText =e.srcElement.value;var rect  = this.getBoundingClientRect();  var xoffset = rect.left + (document.documentElement.scrollLeft || document.body.scrollLeft || 0 ); var yoffset = rect.top + (document.documentElement.scrollTop || document.body.scrollTop || 0 ); var xWidth = rect.right - rect.left; var yHeight = rect.bottom -rect.top; valText = valText.replace(\"/\", \"_\"); if(valText.indexOf(\"/\") == -1){ var para = \"jsbridge://InputClickEvent/onClickInputCtrl/0/\" + valText + \"/\" + xoffset + \"/\" + yoffset + \"/\" + xWidth + \"/\" + yHeight;  window.open(para);}}, false);}}})();");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        a(this.jdField_a_of_type_JavaLangString, 2, "Dlg Already Shown! ");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "On Show Dialog !");
    }
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {
      return;
    }
    AntiphingHandler.1 local1;
    if (paramString4.equals("")) {
      local1 = null;
    } else {
      local1 = new AntiphingHandler.1(this);
    }
    AntiphingHandler.2 local2;
    if (paramString3.equals("")) {
      local2 = null;
    } else {
      local2 = new AntiphingHandler.2(this);
    }
    DialogUtil.a(localActivity, 230, paramString1, paramString2, paramString3, paramString4, local1, local2).show();
  }
  
  public void a(String paramString, String... paramVarArgs)
  {
    if (paramVarArgs.length < 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("antiphishing", 2, "Parameter size < 5");
      }
      return;
    }
    paramString = paramVarArgs[0];
    String str1 = paramVarArgs[1];
    String str2 = paramVarArgs[2];
    String str3 = paramVarArgs[3];
    paramVarArgs = paramVarArgs[4];
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("value:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" xoffset:");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" yoffset:");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(" xWidth:");
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append(" yHeight:");
      ((StringBuilder)localObject).append(paramVarArgs);
      QLog.d("antiphishing", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mRuntime.a();
    if (localObject != null) {
      a(paramString, ((WebView)localObject).getUrl(), str1, str2, str3, paramVarArgs);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bShow =  ");
      localStringBuilder.append(paramBoolean);
      a(str, 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;
    }
    if (localObject1 == null) {
      return true;
    }
    localObject1 = (ActivityManager)((AppRuntime)localObject1).getApplication().getSystemService("activity");
    localObject2 = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
    return ((ActivityManager.MemoryInfo)localObject2).lowMemory;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (this.jdField_a_of_type_Boolean == true)
    {
      if (QLog.isColorLevel()) {
        a(this.jdField_a_of_type_JavaLangString, 2, "Already Shown Tips!!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      a(this.jdField_a_of_type_JavaLangString, 2, "Js is call back!");
    }
    AntiphingHandler.InfoData localInfoData = new AntiphingHandler.InfoData(this);
    if (!a(paramString1, localInfoData))
    {
      if (QLog.isColorLevel()) {
        a(this.jdField_a_of_type_JavaLangString, 2, "The input value is not uin!");
      }
      return false;
    }
    try
    {
      long l = Long.parseLong(localInfoData.jdField_a_of_type_JavaLangString);
      int i = (int)Float.parseFloat(paramString3);
      int j = (int)Float.parseFloat(paramString4);
      int k = (int)Float.parseFloat(paramString5);
      float f = Float.parseFloat(paramString6);
      a(i, j, k, (int)f, paramString2, Long.valueOf(l), localInfoData.jdField_a_of_type_Int);
      return true;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 2L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934594L)
    {
      a();
      a(paramString);
      return false;
    }
    if (paramLong == 8589934597L)
    {
      a(false);
      return false;
    }
    if (paramLong == 8589934595L) {
      return false;
    }
    if (paramLong == 2L) {
      a(true);
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("InputClickEvent".equalsIgnoreCase(paramString2)) && ("onClickInputCtrl".equalsIgnoreCase(paramString3)))
    {
      a(paramString1, paramVarArgs);
      return true;
    }
    return false;
  }
  
  public void onActivityReady()
  {
    AntiphishingUrlConfig localAntiphishingUrlConfig = this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig;
    String str = a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;
    if (localObject != null) {
      localObject = ((BrowserAppInterface)localObject).getApplication();
    } else {
      localObject = this.mRuntime.a();
    }
    localAntiphishingUrlConfig.a(str, (Context)localObject);
  }
  
  public void onAppRuntimeReady(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppRuntime);
      return;
    }
    if ((paramAppRuntime instanceof BrowserAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)paramAppRuntime);
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Received AlertQuery Server Packet! type = ");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (!paramBoolean) {
      return;
    }
    if (this.mRuntime.a() == null) {
      return;
    }
    Context localContext = this.mRuntime.a().getApplicationContext();
    Object localObject3 = localContext.getString(2131718646);
    Object localObject4 = localContext.getString(2131718645);
    Object localObject2 = localContext.getString(2131718644);
    Object localObject1 = localContext.getString(2131718643);
    antiphishingAlertQuery.ResponsePack localResponsePack;
    if ((paramBoolean) && (paramBundle != null)) {
      localResponsePack = new antiphishingAlertQuery.ResponsePack();
    }
    try
    {
      localResponsePack.mergeFrom(paramBundle.getByteArray("data"));
      paramBoolean = localResponsePack.u32_alert_type.has();
      int j = 0;
      if (paramBoolean) {
        paramInt = localResponsePack.u32_alert_type.get();
      } else {
        paramInt = 0;
      }
      int i;
      if (localResponsePack.u32_default_wording.has()) {
        i = localResponsePack.u32_default_wording.get();
      } else {
        i = 0;
      }
      if (paramInt == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Safe Url! No ALert !");
        }
      }
      else
      {
        paramBundle = (Bundle)localObject3;
        if (i == 2) {
          if ((paramInt == 2) && (localResponsePack.str_toast.has()))
          {
            paramBundle = localResponsePack.str_toast.get().toString();
          }
          else
          {
            paramBundle = (Bundle)localObject3;
            if (paramInt == 3)
            {
              paramBundle = (Bundle)localObject4;
              if (localResponsePack.str_dialog_title.has()) {
                paramBundle = localResponsePack.str_dialog_title.get().toString();
              }
              localObject1 = localObject2;
              if (localResponsePack.str_dialog_text.has()) {
                localObject1 = localResponsePack.str_dialog_text.get().toString();
              }
              if (localResponsePack.str_dialog_btn_left.has()) {
                localObject2 = localResponsePack.str_dialog_btn_left.get().toString();
              } else {
                localObject2 = "";
              }
              if (localResponsePack.str_dialog_btn_right.has())
              {
                str = localResponsePack.str_dialog_btn_right.get().toString();
                localObject4 = paramBundle;
                localObject5 = localObject1;
                localObject6 = localObject2;
                localObject1 = str;
                break label444;
              }
              String str = "";
              localObject4 = paramBundle;
              localObject5 = localObject1;
              localObject6 = localObject2;
              localObject1 = str;
              break label444;
            }
          }
        }
        Object localObject6 = "";
        Object localObject5 = localObject2;
        localObject3 = paramBundle;
        label444:
        if (QLog.isColorLevel())
        {
          paramBundle = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("toasttext:");
          ((StringBuilder)localObject2).append((String)localObject3);
          ((StringBuilder)localObject2).append("strDialogTitle");
          ((StringBuilder)localObject2).append((String)localObject4);
          ((StringBuilder)localObject2).append("strDialogText");
          ((StringBuilder)localObject2).append(localObject5);
          ((StringBuilder)localObject2).append(" strDialogLeftBtnText:");
          ((StringBuilder)localObject2).append((String)localObject6);
          ((StringBuilder)localObject2).append(" StrDialogRightBtnText:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d(paramBundle, 2, ((StringBuilder)localObject2).toString());
        }
        if (localResponsePack.u32_seq.has()) {
          i = localResponsePack.u32_seq.get();
        } else {
          i = 0;
        }
        if (i == this.jdField_a_of_type_Int)
        {
          if (paramInt == 2)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onReceive: Show Tips");
            }
            a(localContext, (String)localObject3, 104);
          }
          else if (paramInt == 3)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onReceive: Show Dlg");
            }
            a((String)localObject4, localObject5, (String)localObject6, (String)localObject1);
          }
          else if (QLog.isDevelopLevel())
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 4, "onReceive: UnknowType ");
          }
        }
        else if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 4, "onReceive: Sequence Changed!");
        }
      }
      paramInt = j;
      if (localResponsePack.u32_svr_url_ver.has()) {
        paramInt = localResponsePack.u32_svr_url_ver.get();
      }
      paramBoolean = localResponsePack.str_download_link.has();
      localObject1 = null;
      if (paramBoolean) {
        paramBundle = localResponsePack.str_download_link.get();
      } else {
        paramBundle = null;
      }
      if (localResponsePack.str_hash.has()) {
        localObject1 = localResponsePack.str_hash.get();
      }
      if ((paramInt != 0) && (paramBundle != null) && (localObject1 != null))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig;
        if (localObject2 != null) {
          ((AntiphishingUrlConfig)localObject2).a(paramInt, paramBundle, (String)localObject1, localContext);
        }
      }
      else if (QLog.isDevelopLevel())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 4, "onReceive: types unknow !");
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphingHandler
 * JD-Core Version:    0.7.0.1
 */