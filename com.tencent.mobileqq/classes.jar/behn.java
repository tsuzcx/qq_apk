import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.1;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.2;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.3;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.4;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.HashMap;
import java.util.Map;

public class behn
  extends WebViewPlugin
{
  public static final String a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = behn.class.getSimpleName();
  }
  
  public behn()
  {
    this.mPluginNameSpace = jdField_a_of_type_JavaLangString;
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a(Intent paramIntent)
  {
    if (this.mRuntime == null) {}
    do
    {
      return;
      if (this.mRuntime.a() != null)
      {
        this.mRuntime.a().startActivity(paramIntent);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebViewJumpPlugin", 2, "Activity is null");
  }
  
  private void b(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {}
    do
    {
      return;
      ((Activity)localObject).finish();
      if (xxb.c(paramString))
      {
        localObject = new Intent((Context)localObject, JoinDiscussionActivity.class);
        ((Intent)localObject).putExtra("innerSig", paramString);
        a((Intent)localObject);
        return;
      }
      paramString = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)localObject, paramString);
    } while (paramString == null);
    paramString.c();
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if ((paramString.startsWith("mqqapi://armap_entry/map?src_type=web&version=1&from_type=0&service_id=1")) || (paramString.startsWith("mqqapi://personal_tag/tag_list"))) {}
      for (int i = 1; i != 0; i = 0)
      {
        new Handler().postDelayed(new WebViewJumpPlugin.4(this), 2000L);
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      paramBoolean = false;
      return paramBoolean;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_PID", String.valueOf(50079));
    localHashMap.put("KEY_EUSESTAT", String.valueOf(5));
    paramString = MttLoader.getValidQBUrl(this.mRuntime.a(), paramString);
    int i = MttLoader.loadUrl(this.mRuntime.a(), paramString, localHashMap, null);
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
      {
        QLog.d("WebViewJumpPlugin", 2, "webview is null");
        return true;
      }
      if (4 != i) {
        break label125;
      }
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
    }
    for (;;)
    {
      paramBoolean = bool;
      if (i == 0) {
        break;
      }
      return false;
      label125:
      if (5 == i) {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
      } else if (i != 0) {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
      }
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 2L) {
      this.c = true;
    }
    for (;;)
    {
      return false;
      if (paramLong == 8589934597L) {
        this.c = false;
      } else if (paramLong == 8589934601L)
      {
        if ((!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")))
        {
          if ((paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.a() != null))
          {
            if (!(this.mRuntime.a() instanceof IphoneTitleBarActivity)) {
              break label178;
            }
            ((IphoneTitleBarActivity)this.mRuntime.a()).setLeftViewName(2131720569);
          }
          while ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().canGoBack()))
          {
            this.mRuntime.a().goBack();
            return true;
            label178:
            if (((this.mRuntime.a() instanceof bebt)) && (!befr.a()))
            {
              paramString = this.mRuntime.a();
              if ((paramString != null) && (paramString.a.a != null)) {
                paramString.a.a.setText(2131720569);
              }
            }
          }
        }
      }
      else if ((paramLong == 8589934594L) && (!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")) && (paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.a() != null)) {
        if ((this.mRuntime.a() instanceof IphoneTitleBarActivity))
        {
          ((IphoneTitleBarActivity)this.mRuntime.a()).setLeftViewName(2131690623);
        }
        else if (((this.mRuntime.a() instanceof bebt)) && (!befr.a()))
        {
          paramString = this.mRuntime.a();
          if ((paramString != null) && (paramString.a.a != null)) {
            paramString.a.a.setText(2131690623);
          }
        }
      }
    }
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleSchemaRequest-->url:" + paramString1 + ",scheme:" + paramString2 + "mActive=" + this.c);
    }
    boolean bool1;
    if (!this.c) {
      bool1 = false;
    }
    Object localObject1;
    int i;
    long l1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return bool1;
                              if ((xxb.a(paramString1)) && (xwb.a(paramString1))) {
                                return false;
                              }
                              localObject1 = null;
                              Object localObject2 = a();
                              paramString2 = (String)localObject1;
                              if (localObject2 != null)
                              {
                                localObject2 = ((Activity)localObject2).getIntent();
                                paramString2 = (String)localObject1;
                                if (localObject2 != null) {
                                  paramString2 = ((Intent)localObject2).getStringExtra("big_brother_source_key");
                                }
                              }
                              if (paramString1.startsWith("tel:"))
                              {
                                paramString1 = new Intent("android.intent.action.DIAL", Uri.parse(paramString1));
                                paramString1.putExtra("big_brother_source_key", paramString2);
                                if ((!bdlz.jdField_a_of_type_Boolean) && (bdlw.a().a())) {
                                  bdlw.a().a(paramString1);
                                }
                                a(paramString1);
                                return true;
                              }
                              if (paramString1.startsWith("sms:"))
                              {
                                paramString2 = new Intent("android.intent.action.VIEW");
                                int j = paramString1.indexOf("?");
                                i = j;
                                if (j == -1) {
                                  i = paramString1.length();
                                }
                                paramString2.putExtra("address", paramString1.substring(paramString1.indexOf(":") + 1, i));
                                j = paramString1.indexOf("=");
                                i = j;
                                if (j == -1) {
                                  i = paramString1.length() - 1;
                                }
                                paramString2.putExtra("sms_body", paramString1.substring(i + 1, paramString1.length()));
                                paramString2.setType("vnd.android-dir/mms-sms");
                                a(paramString2);
                                return true;
                              }
                              if (paramString1.startsWith("mqqapi://avatar/update?"))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d(this.TAG, 2, "enter WebViewJumpPlugin classicHeadActivity url=" + paramString1);
                                }
                                localObject1 = paramString1.split("&");
                                if ((localObject1 == null) || (localObject1.length < 5)) {
                                  break label1506;
                                }
                                paramString2 = localObject1[2].split("=");
                                paramString1 = localObject1[3].split("=");
                                localObject1 = localObject1[4].split("=");
                                if ((paramString2 == null) || (paramString2.length != 2) || (paramString1 == null) || (paramString1.length != 2) || (localObject1 == null) || (localObject1.length != 2)) {
                                  break label1506;
                                }
                                paramString2 = paramString2[1];
                                l1 = Long.parseLong(localObject1[1]);
                                long l2 = Long.parseLong(paramString1[1]);
                                paramString1 = new Intent("com.tencent.qqhead.refreshheadreq");
                                paramString1.setPackage(this.mRuntime.a().getPackageName());
                                paramString1.putExtra("faceType", 1);
                                paramString1.putExtra("uin", paramString2);
                                paramString1.putExtra("headSystemId", l2);
                                paramString1.putExtra("faceFlag", l1);
                                this.mRuntime.a().sendBroadcast(paramString1);
                                return true;
                              }
                              if (!paramString1.startsWith("mqqapi://tenpay/pay?")) {
                                break;
                              }
                              i = getRequestCode((byte)3);
                              bool1 = bool2;
                            } while (i == -1);
                            bool1 = bool2;
                          } while (this.b);
                          this.b = true;
                          paramString1 = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
                          bool1 = bool2;
                        } while (paramString1 == null);
                        paramString1.a("webview");
                        paramString1.a("k_requestcode", String.valueOf(i));
                        paramString1.a("url_app_info", QWalletPayJsPlugin.getPayAppInfo());
                        paramString1.c();
                        this.jdField_a_of_type_Boolean = true;
                        this.b = false;
                        return true;
                        if ((!xxb.a(paramString1)) && (!paramString1.startsWith("mqqopensdkapi:"))) {
                          break;
                        }
                        paramString2 = this.mRuntime.a();
                        bool1 = bool2;
                      } while (paramString2 == null);
                      paramString2 = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1);
                      if (paramString2 != null)
                      {
                        paramString2.a("webview");
                        paramString2.c();
                      }
                      bool1 = bool2;
                    } while (!paramString1.startsWith("http:"));
                    new Handler().postDelayed(new WebViewJumpPlugin.1(this), 2000L);
                    return true;
                    if (!paramString1.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard")) {
                      break;
                    }
                    paramString1 = Uri.parse(paramString1).getQueryParameter("xq_uin");
                    if (TextUtils.isEmpty(paramString1)) {
                      return false;
                    }
                    paramString1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1;
                    paramString2 = this.mRuntime.a();
                    bool1 = bool2;
                  } while (paramString2 == null);
                  paramString1 = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1);
                  if (paramString1 != null)
                  {
                    paramString1.a("webview");
                    paramString1.c();
                  }
                  new Handler().postDelayed(new WebViewJumpPlugin.2(this), 2000L);
                  return true;
                  if (paramString1.startsWith("http://clientui.3g.qq.com/mqqapi/"))
                  {
                    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
                    {
                      QLog.d("WebViewJumpPlugin", 2, "webview is null");
                      return true;
                    }
                    localObject1 = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      paramString2 = ndq.b(paramString1, new String[0]);
                      paramString1 = paramString2;
                      if (paramString2.length() > 512) {
                        paramString1 = paramString2.substring(0, 512);
                      }
                      azmj.b(null, "P_CliOper", "BizTechReport", "", "webview_jump", "http_jumpaction", 0, 1, 0, ndq.b((String)localObject1, new String[0]), paramString1, "", "");
                    }
                    return false;
                  }
                  if (!paramString1.startsWith("mqqapi://readinjoy")) {
                    break;
                  }
                  paramString1 = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
                  bool1 = bool2;
                } while (paramString1 == null);
                paramString1.a("webview");
                paramString1.c();
                return true;
                if (!paramString1.startsWith("mqqapi://now/playmedia")) {
                  break;
                }
                paramString1 = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
                bool1 = bool2;
              } while (paramString1 == null);
              paramString1.a("webview");
              paramString1.c();
              return true;
              if (!paramString1.startsWith("mqqapi://now/playmedia")) {
                break;
              }
              paramString1 = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
              bool1 = bool2;
            } while (paramString1 == null);
            paramString1.a("webview");
            paramString1.a(this.mRuntime.a());
            paramString1.c();
            return true;
            if (!paramString1.startsWith("mqqapi://now/openSmallVideoRecord")) {
              break;
            }
            paramString1 = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
            bool1 = bool2;
          } while (paramString1 == null);
          paramString1.a("webview");
          paramString1.a(this.mRuntime.a());
          paramString1.c();
          return true;
          if ((paramString1.startsWith("mqqapi://")) || (paramString1.startsWith("qqfav://operation/")) || (paramString1.startsWith("nowmqqapi://now/openroom")))
          {
            localObject1 = new Intent(this.mRuntime.a(), JumpActivity.class);
            ((Intent)localObject1).setData(Uri.parse(paramString1));
            ((Intent)localObject1).putExtra("from", "webview");
            if (!TextUtils.isEmpty(paramString2)) {
              ((Intent)localObject1).putExtra("big_brother_source_key", paramString2);
            }
            a((Intent)localObject1);
            c(paramString1);
            return true;
          }
          if (!paramString1.startsWith("qb")) {
            break;
          }
          bool1 = bool2;
        } while (a(paramString1, false));
        bool1 = bool2;
      } while (this.mRuntime == null);
      bool1 = bool2;
    } while (this.mRuntime.a() == null);
    paramString1 = MttLoader.getValidQBUrl(this.mRuntime.a(), paramString1);
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
    {
      QLog.d("WebViewJumpPlugin", 2, "webview is null");
      return true;
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramString1);
    return true;
    if ((paramString1.startsWith("mqqflyticket://")) || (xxb.b(paramString1)))
    {
      b(paramString1);
      return true;
    }
    if (paramString1.startsWith("mqqwpa://im"))
    {
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      paramString1.addFlags(268435456);
      paramString1.putExtra("from", "webview");
      a(paramString1);
      return true;
    }
    if (paramString1.startsWith("mqqapi://pay_for_emosm_success"))
    {
      paramString1 = this.mRuntime.a();
      if (paramString1 != null)
      {
        paramString1.setResult(8213);
        paramString1.finish();
      }
    }
    for (;;)
    {
      label1506:
      return false;
      if (paramString1.startsWith("mqqapi://od"))
      {
        a(paramString1);
      }
      else
      {
        if (paramString1.startsWith("http://mp.qzone.qq.com/u/"))
        {
          paramString2 = bhos.a(paramString1);
          if (paramString2.containsKey("uin")) {
            paramString1 = (String)paramString2.get("uin");
          }
          for (;;)
          {
            try
            {
              l1 = Long.parseLong(paramString1);
              paramString1 = bizr.a();
              if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "handleJumpToFamousSpace-->famous uin:" + l1 + ",actionUrl:" + paramString1);
              }
              paramString2 = this.mRuntime.a();
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("qqid", l1);
              ((Intent)localObject1).putExtra("refer", "famous");
              ((Intent)localObject1).putExtra("famous_space_webview_url", paramString1);
              QzonePluginProxyActivity.a((Intent)localObject1, "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity");
              QzonePluginProxyActivity.a(paramString2, this.mRuntime.a().getAccount(), (Intent)localObject1, 0);
              new Handler().postDelayed(new WebViewJumpPlugin.3(this), 2000L);
              return true;
            }
            catch (NumberFormatException paramString1)
            {
              paramString1.printStackTrace();
            }
            break;
            i = paramString1.lastIndexOf('?');
            if (i != -1) {
              paramString1 = paramString1.substring("http://mp.qzone.qq.com/u/".length(), i);
            } else {
              paramString1 = paramString1.substring("http://mp.qzone.qq.com/u/".length());
            }
          }
        }
        if (paramString1.startsWith("mqqconferenceflyticket://"))
        {
          if (this.mRuntime.a() == null) {}
        }
        else if (paramString1.startsWith("mqqapi://groupvideo"))
        {
          paramString1 = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
          if (paramString1 != null) {
            paramString1.c();
          }
        }
        else if (paramString1.startsWith("mqqapi://stickynote"))
        {
          paramString1 = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
          if (paramString1 != null) {
            paramString1.c();
          }
        }
      }
    }
  }
  
  public void onActivityReady()
  {
    if ((this.mRuntime.a() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.mRuntime.a());
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this.mRuntime.a();
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 3)
    {
      if (paramInt != -1) {
        break label129;
      }
      if ((this.jdField_a_of_type_Boolean) && (paramIntent != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
      {
        str = paramIntent.getStringExtra("callback_type");
        if (!"javascript".equals(str)) {
          break label79;
        }
        callJs(paramIntent.getStringExtra("callback_name"), new String[] { paramIntent.getStringExtra("callback_data") });
      }
    }
    label79:
    while (paramInt != 0)
    {
      String str;
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        return;
        if ("url".equals(str))
        {
          if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
          {
            QLog.d("WebViewJumpPlugin", 2, "webview is null");
            return;
          }
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramIntent.getStringExtra("callback_url"));
        }
      }
    }
    label129:
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onCreate()
  {
    ymk.a().a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ymk.a().b();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramCustomWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behn
 * JD-Core Version:    0.7.0.1
 */