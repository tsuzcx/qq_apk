package com.tencent.mobileqq.antiphing;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
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
import yjd;
import yje;
import yjf;

public class AntiphingHandler
  extends WebViewPlugin
  implements BusinessObserver
{
  private int jdField_a_of_type_Int = 1;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private AntiphishingUrlConfig jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig = new AntiphishingUrlConfig();
  BrowserAppInterface jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private AntiphingToast jdField_a_of_type_ComTencentMobileqqWidgetAntiphingToast = new AntiphingToast();
  private String jdField_a_of_type_JavaLangString = "Antiphishing";
  private boolean jdField_a_of_type_Boolean;
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
    if (this.mRuntime != null)
    {
      AppInterface localAppInterface = this.mRuntime.a();
      localObject = localAppInterface;
      if (localAppInterface == null) {
        localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      }
      if (localObject == null) {
        return null;
      }
    }
    for (Object localObject = ((AppInterface)localObject).getApplication().getFilesDir().getAbsolutePath() + File.separator + "antiphishingconfig.xml";; localObject = null) {
      return localObject;
    }
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
    if (QLog.isColorLevel()) {
      a(this.jdField_a_of_type_JavaLangString, 2, "Show Toast! yoffset =  " + paramInt);
    }
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout == null) && (this.mRuntime != null) && (this.mRuntime.a() != null)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.mRuntime.a().findViewById(2131366765));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAntiphingToast != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAntiphingToast.a(2131436533, 3000, this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAntiphingToast.a(paramString);
      return true;
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
      String str1 = new URL(paramString).getHost();
      if (QLog.isColorLevel()) {
        a(this.jdField_a_of_type_JavaLangString, 2, " Is QQ Domain, input url  : " + Util.b(paramString, new String[0]) + " Domain = " + str1);
      }
      if ((str1.endsWith("qq.com")) || (str1.endsWith("tencent.com")) || (str1.endsWith("imqq.com")) || (str1.endsWith("wanggou.com")) || (str1.endsWith("paipai.com")) || (str1.endsWith("tenpay.com")) || (str1.endsWith("yixun.com")) || (str1.endsWith("weiyun.com")) || (str1.endsWith("soso.com")) || (str1.endsWith("myapp.com")) || (str1.endsWith("wechat.com")) || (str1.endsWith("gaopeng.com")) || (str1.endsWith("pengyou.com")) || (str1.endsWith("51buy.com")) || (str1.endsWith("weishi.com")) || (str1.endsWith("qqumall.com")) || (str1.endsWith("vip.surex.cn")))
      {
        bool1 = true;
        if (!a())
        {
          bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            if (this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig != null)
            {
              ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig.a();
              bool2 = bool1;
              if (localArrayList != null)
              {
                bool2 = bool1;
                if (i < localArrayList.size())
                {
                  if (!str1.endsWith((String)localArrayList.get(i))) {
                    break label379;
                  }
                  if (QLog.isColorLevel()) {
                    a(this.jdField_a_of_type_JavaLangString, 2, " Is trust Domain, match config, input url  : " + paramString + " Domain = " + str1);
                  }
                  bool2 = true;
                }
              }
            }
          }
          return bool2;
        }
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        boolean bool1;
        String str2 = "";
        continue;
        label379:
        i += 1;
        continue;
        boolean bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Low Memory !");
          bool2 = bool1;
          continue;
          bool1 = false;
        }
      }
    }
  }
  
  private boolean a(String paramString, yjf paramyjf)
  {
    if (paramString == null) {
      return false;
    }
    String str = paramString.trim().toLowerCase().replace(" ", "");
    if (str.endsWith("@qq.com")) {}
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
      for (paramString = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;; paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)
      {
        if (paramString == null) {
          break label98;
        }
        paramString = paramString.getApplication().getAllAccounts();
        if ((paramString != null) && (paramString.size() != 0)) {
          break label100;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "uin number is zero!");
        return false;
      }
      label98:
      break;
      label100:
      int j = 0;
      label103:
      Object localObject;
      if (j < paramString.size())
      {
        localObject = (SimpleAccount)paramString.get(j);
        if (localObject != null) {
          break label158;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sAccount == null!");
        }
      }
      label158:
      do
      {
        do
        {
          j += 1;
          break label103;
          break;
          localObject = ((SimpleAccount)localObject).getUin();
        } while (localObject == null);
        if (((String)localObject).equalsIgnoreCase(str))
        {
          paramyjf.jdField_a_of_type_JavaLangString = ((String)localObject);
          paramyjf.jdField_a_of_type_Int = 1;
          return true;
        }
      } while ((i != 1) || (!str.contains((CharSequence)localObject)));
      paramyjf.jdField_a_of_type_JavaLangString = ((String)localObject);
      paramyjf.jdField_a_of_type_Int = 2;
      return true;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Send a Packet to Server!, xffset = " + paramInt1 + " yoffset = " + paramInt2 + " nWidth = " + paramInt3 + " nHeight = " + paramInt4 + " url=" + paramString + " uin=" + paramLong + " AccountType = " + paramInt5);
    }
    if ((paramLong.longValue() == 0L) || (paramString == null)) {}
    for (;;)
    {
      return;
      antiphishingAlertQuery.RequestPack localRequestPack = new antiphishingAlertQuery.RequestPack();
      localRequestPack.u32_app_type.set(2);
      localRequestPack.u64_input_uin.set(paramLong.longValue());
      localRequestPack.u32_account_type.set(paramInt5);
      localRequestPack.u32_ctrl_height.set(paramInt4);
      localRequestPack.u32_ctrl_width.set(paramInt3);
      localRequestPack.i32_xoffset.set(paramInt1);
      localRequestPack.i32_yoffset.set(paramInt2);
      localRequestPack.str_url.set(paramString);
      localRequestPack.u32_seq.set(this.jdField_a_of_type_Int);
      localRequestPack.u32_proto_ver.set(1);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
      for (paramString = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface; (paramString != null) && (this.mRuntime.a() != null); paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)
      {
        paramLong = new NewIntent(this.mRuntime.a().getApplicationContext(), ProtoServlet.class);
        paramLong.putExtra("uin", paramString.getAccount());
        paramLong.putExtra("data", localRequestPack.toByteArray());
        paramLong.putExtra("cmd", "SecuritySvc.UrlQuery");
        paramLong.setObserver(this);
        paramString.startServlet(paramLong);
        return;
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
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        a(this.jdField_a_of_type_JavaLangString, 2, "Dlg Already Shown! ");
      }
    }
    Activity localActivity;
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "On Show Dialog !");
      }
      localActivity = this.mRuntime.a();
    } while (localActivity == null);
    Object localObject1;
    if (paramString4.equals(""))
    {
      localObject1 = null;
      if (!paramString3.equals("")) {
        break label121;
      }
    }
    label121:
    for (Object localObject2 = null;; localObject2 = new yje(this))
    {
      DialogUtil.a(localActivity, 230, paramString1, paramString2, paramString3, paramString4, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject2).show();
      return;
      localObject1 = new yjd(this);
      break;
    }
  }
  
  public void a(String paramString, String... paramVarArgs)
  {
    if (paramVarArgs.length < 5) {
      if (QLog.isColorLevel()) {
        QLog.d("antiphishing", 2, "Parameter size < 5");
      }
    }
    String str1;
    String str2;
    String str3;
    CustomWebView localCustomWebView;
    do
    {
      return;
      paramString = paramVarArgs[0];
      str1 = paramVarArgs[1];
      str2 = paramVarArgs[2];
      str3 = paramVarArgs[3];
      paramVarArgs = paramVarArgs[4];
      if (QLog.isColorLevel()) {
        QLog.d("antiphishing", 2, "value:" + paramString + " xoffset:" + str1 + " yoffset:" + str2 + " xWidth:" + str3 + " yHeight:" + paramVarArgs);
      }
      localCustomWebView = this.mRuntime.a();
    } while (localCustomWebView == null);
    a(paramString, localCustomWebView.getUrl(), str1, str2, str3, paramVarArgs);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      a(this.jdField_a_of_type_JavaLangString, 2, "bShow =  " + paramBoolean);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface; localObject == null; localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) {
      return true;
    }
    localObject = (ActivityManager)((AppRuntime)localObject).getApplication().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.lowMemory;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (this.jdField_a_of_type_Boolean == true) {
      if (QLog.isColorLevel()) {
        a(this.jdField_a_of_type_JavaLangString, 2, "Already Shown Tips!!");
      }
    }
    yjf localyjf;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        a(this.jdField_a_of_type_JavaLangString, 2, "Js is call back!");
      }
      localyjf = new yjf(this);
      if (a(paramString1, localyjf)) {
        break;
      }
    } while (!QLog.isColorLevel());
    a(this.jdField_a_of_type_JavaLangString, 2, "The input value is not uin!");
    return false;
    try
    {
      long l = Long.parseLong(localyjf.jdField_a_of_type_JavaLangString);
      int i = (int)Float.parseFloat(paramString3);
      int j = (int)Float.parseFloat(paramString4);
      int k = (int)Float.parseFloat(paramString5);
      float f = Float.parseFloat(paramString6);
      a(i, j, k, (int)f, paramString2, Long.valueOf(l), localyjf.jdField_a_of_type_Int);
      return true;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934594L)
    {
      a();
      a(paramString);
    }
    do
    {
      return false;
      if (paramLong == 8589934597L)
      {
        a(false);
        return false;
      }
    } while ((paramLong == 8589934595L) || (paramLong != 2L));
    a(true);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApplication();; localObject = this.mRuntime.a())
    {
      localAntiphishingUrlConfig.a(str, (Context)localObject);
      return;
    }
  }
  
  public void onAppRuntimeReady(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
    }
    while (!(paramAppInterface instanceof BrowserAppInterface)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)paramAppInterface);
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Received AlertQuery Server Packet! type = " + paramInt);
    }
    if (!this.jdField_b_of_type_Boolean) {}
    Context localContext;
    String str;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (this.mRuntime.a() == null));
      localContext = this.mRuntime.a().getApplicationContext();
      str = localContext.getString(2131436549);
      localObject1 = localContext.getString(2131436545);
      localObject3 = localContext.getString(2131436546);
      localObject2 = localContext.getString(2131436548);
    } while ((!paramBoolean) || (paramBundle == null));
    antiphishingAlertQuery.ResponsePack localResponsePack = new antiphishingAlertQuery.ResponsePack();
    for (;;)
    {
      try
      {
        localResponsePack.mergeFrom(paramBundle.getByteArray("data"));
        paramInt = 0;
        int i = 0;
        if (localResponsePack.u32_alert_type.has()) {
          paramInt = localResponsePack.u32_alert_type.get();
        }
        if (localResponsePack.u32_default_wording.has()) {
          i = localResponsePack.u32_default_wording.get();
        }
        if (paramInt == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Safe Url! No ALert !");
          }
          paramInt = 0;
          paramBundle = null;
          localObject1 = null;
          if (localResponsePack.u32_svr_url_ver.has()) {
            paramInt = localResponsePack.u32_svr_url_ver.get();
          }
          if (localResponsePack.str_download_link.has()) {
            paramBundle = localResponsePack.str_download_link.get();
          }
          if (localResponsePack.str_hash.has()) {
            localObject1 = localResponsePack.str_hash.get();
          }
          if ((paramInt != 0) && (paramBundle != null) && (localObject1 != null)) {
            continue;
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d(this.jdField_a_of_type_JavaLangString, 4, "onReceive: types unknow !");
          return;
        }
        if (i == 2)
        {
          if ((paramInt == 2) && (localResponsePack.str_toast.has()))
          {
            localObject4 = localResponsePack.str_toast.get().toString();
            str = "";
            paramBundle = (Bundle)localObject2;
            localObject2 = str;
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "toasttext:" + (String)localObject4 + "strDialogTitle" + (String)localObject1 + "strDialogText" + (String)localObject3 + " strDialogLeftBtnText:" + (String)localObject2 + " StrDialogRightBtnText:" + paramBundle);
            }
            i = 0;
            if (localResponsePack.u32_seq.has()) {
              i = localResponsePack.u32_seq.get();
            }
            if (i != this.jdField_a_of_type_Int) {
              continue;
            }
            if (paramInt == 2)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onReceive: Show Tips");
              }
              a(localContext, (String)localObject4, 104);
            }
          }
          else
          {
            if (paramInt != 3) {
              break label753;
            }
            paramBundle = (Bundle)localObject1;
            if (localResponsePack.str_dialog_title.has()) {
              paramBundle = localResponsePack.str_dialog_title.get().toString();
            }
            localObject1 = localObject3;
            if (localResponsePack.str_dialog_text.has()) {
              localObject1 = localResponsePack.str_dialog_text.get().toString();
            }
            if (localResponsePack.str_dialog_btn_left.has())
            {
              localObject2 = localResponsePack.str_dialog_btn_left.get().toString();
              if (localResponsePack.str_dialog_btn_right.has())
              {
                localObject3 = localResponsePack.str_dialog_btn_right.get().toString();
                localObject4 = paramBundle;
                paramBundle = (Bundle)localObject3;
                localObject3 = localObject1;
                localObject1 = localObject4;
                localObject4 = str;
              }
            }
            else
            {
              localObject2 = "";
              continue;
            }
            localObject4 = paramBundle;
            paramBundle = "";
            localObject3 = localObject1;
            localObject1 = localObject4;
            localObject4 = str;
            continue;
          }
          if (paramInt == 3)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onReceive: Show Dlg");
            }
            a((String)localObject1, (String)localObject3, (String)localObject2, paramBundle);
            continue;
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d(this.jdField_a_of_type_JavaLangString, 4, "onReceive: UnknowType ");
          continue;
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d(this.jdField_a_of_type_JavaLangString, 4, "onReceive: Sequence Changed!");
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAntiphingAntiphishingUrlConfig.a(paramInt, paramBundle, (String)localObject1, localContext);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        return;
      }
      label753:
      Object localObject4 = "";
      paramBundle = (Bundle)localObject2;
      localObject2 = localObject4;
      localObject4 = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphingHandler
 * JD-Core Version:    0.7.0.1
 */