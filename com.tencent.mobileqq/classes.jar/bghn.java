import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.vip.manager.MonitorManager;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bghn
  extends bgix
{
  public static String a;
  public static boolean a;
  private BroadcastReceiver a;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(long paramLong, int paramInt)
  {
    bgbz.a().a().a(paramLong, paramInt);
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    QLog.d("QZoneFeedActionJsPlugin", 2, "action : " + paramIntent.getAction());
    if ("FeedActionPanelActivity.content".equals(paramIntent.getAction())) {
      d(paramIntent);
    }
    do
    {
      return;
      if ("FeedActionPanelActivity.inputpanel_height".equals(paramIntent.getAction()))
      {
        b(paramIntent);
        return;
      }
      if ("FeedActionPanelActivity.inputpanel_closed".equals(paramIntent.getAction()))
      {
        c(paramIntent);
        return;
      }
    } while (!"FeedActionPanelActivity.font_select".equals(paramIntent.getAction()));
    a(paramIntent);
  }
  
  private void a(Intent paramIntent)
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (paramIntent == null))
    {
      QLog.e("QZoneFeedActionJsPlugin", 1, "notifyH5FontSelect error callback = null");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("font_id", paramIntent.getIntExtra("extra_key_font_id", -1));
      localJSONObject.put("font_type", paramIntent.getIntExtra("extra_key_font_format_type", -1));
      localJSONObject.put("font_url", paramIntent.getStringExtra("extra_key_font_url"));
      paramIntent = "window." + this.jdField_b_of_type_JavaLangString + "(" + localJSONObject.toString() + ");";
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFeedActionJsPlugin", 2, "invoke callback js:" + paramIntent);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().callJs(paramIntent);
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent("action_h5pay_callback");
    localIntent.putExtra("h5pay_callback_json", paramString);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().sendBroadcast(localIntent);
  }
  
  private void a(String... paramVarArgs)
  {
    if (LocalMultiProcConfig.getBool("FeedAction#isActive", false)) {
      return;
    }
    LocalMultiProcConfig.putBool("FeedAction#isActive", true);
    String str2 = "";
    String str3 = "";
    int i2 = 0;
    int i19 = 0;
    int i3 = 0;
    int i18 = 0;
    int i4 = 0;
    int i17 = 0;
    int i5 = 0;
    int i16 = 0;
    int i6 = 0;
    int i15 = 0;
    String str1 = "";
    int i7 = 0;
    int i14 = 0;
    int i8 = 0;
    int i13 = 0;
    boolean bool4 = false;
    boolean bool12 = false;
    boolean bool5 = false;
    boolean bool11 = false;
    boolean bool6 = false;
    boolean bool10 = false;
    boolean bool7 = false;
    boolean bool9 = false;
    int i12 = -1;
    int i11 = i12;
    boolean bool2 = bool7;
    boolean bool1 = bool6;
    boolean bool3 = bool5;
    boolean bool8 = bool4;
    Object localObject5 = str3;
    Object localObject6 = str2;
    int i10 = i6;
    int i1 = i3;
    int n = i2;
    int m = i4;
    int k = i5;
    Object localObject4 = str1;
    int j = i7;
    int i = i8;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i9;
    if (paramVarArgs != null)
    {
      i11 = i12;
      bool2 = bool7;
      bool1 = bool6;
      bool3 = bool5;
      bool8 = bool4;
      localObject5 = str3;
      localObject6 = str2;
      i10 = i6;
      i1 = i3;
      n = i2;
      m = i4;
      k = i5;
      localObject4 = str1;
      j = i7;
      i = i8;
      if (paramVarArgs.length > 0)
      {
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = str3;
        localObject2 = str2;
        i3 = i15;
        i4 = i18;
        i5 = i19;
        i6 = i17;
        i7 = i16;
        localObject3 = str1;
        i8 = i14;
        i9 = i13;
      }
    }
    for (;;)
    {
      try
      {
        localObject6 = new JSONObject(paramVarArgs[0]);
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = str3;
        localObject2 = str2;
        i3 = i15;
        i4 = i18;
        i5 = i19;
        i6 = i17;
        i7 = i16;
        localObject3 = str1;
        i8 = i14;
        i9 = i13;
        paramVarArgs = ((JSONObject)localObject6).optString("content");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = str2;
        i3 = i15;
        i4 = i18;
        i5 = i19;
        i6 = i17;
        i7 = i16;
        localObject3 = str1;
        i8 = i14;
        i9 = i13;
        localObject5 = ((JSONObject)localObject6).optString("placeholder");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = i15;
        i4 = i18;
        i5 = i19;
        i6 = i17;
        i7 = i16;
        localObject3 = str1;
        i8 = i14;
        i9 = i13;
        i = ((JSONObject)localObject6).optInt("needEmoticonBtn");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = i15;
        i4 = i18;
        i5 = i;
        i6 = i17;
        i7 = i16;
        localObject3 = str1;
        i8 = i14;
        i9 = i13;
        j = ((JSONObject)localObject6).optInt("needAtBtn");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = i15;
        i4 = j;
        i5 = i;
        i6 = i17;
        i7 = i16;
        localObject3 = str1;
        i8 = i14;
        i9 = i13;
        m = ((JSONObject)localObject6).optInt("needPrivateBtn");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = i15;
        i4 = j;
        i5 = i;
        i6 = m;
        i7 = i16;
        localObject3 = str1;
        i8 = i14;
        i9 = i13;
        i1 = ((JSONObject)localObject6).optInt("isReply");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = i15;
        i4 = j;
        i5 = i;
        i6 = m;
        i7 = i1;
        localObject3 = str1;
        i8 = i14;
        i9 = i13;
        k = ((JSONObject)localObject6).optInt("privateCommentStatus");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = k;
        i4 = j;
        i5 = i;
        i6 = m;
        i7 = i1;
        localObject3 = str1;
        i8 = i14;
        i9 = i13;
        jdField_a_of_type_JavaLangString = ((JSONObject)localObject6).optString("callback");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = k;
        i4 = j;
        i5 = i;
        i6 = m;
        i7 = i1;
        localObject3 = str1;
        i8 = i14;
        i9 = i13;
        this.jdField_b_of_type_Boolean = ((JSONObject)localObject6).optBoolean("acceptEncoded");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = k;
        i4 = j;
        i5 = i;
        i6 = m;
        i7 = i1;
        localObject3 = str1;
        i8 = i14;
        i9 = i13;
        jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = k;
        i4 = j;
        i5 = i;
        i6 = m;
        i7 = i1;
        localObject3 = str1;
        i8 = i14;
        i9 = i13;
        localObject4 = ((JSONObject)localObject6).optString("btntext");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = k;
        i4 = j;
        i5 = i;
        i6 = m;
        i7 = i1;
        localObject3 = localObject4;
        i8 = i14;
        i9 = i13;
        i10 = ((JSONObject)localObject6).optInt("maxTextLength");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = k;
        i4 = j;
        i5 = i;
        i6 = m;
        i7 = i1;
        localObject3 = localObject4;
        i8 = i10;
        i9 = i13;
        i11 = ((JSONObject)localObject6).optInt("groupdId");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool12;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = k;
        i4 = j;
        i5 = i;
        i6 = m;
        i7 = i1;
        localObject3 = localObject4;
        i8 = i10;
        i9 = i11;
        bool3 = ((JSONObject)localObject6).optBoolean("disableAutoClose");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool11;
        bool7 = bool3;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = k;
        i4 = j;
        i5 = i;
        i6 = m;
        i7 = i1;
        localObject3 = localObject4;
        i8 = i10;
        i9 = i11;
        bool8 = ((JSONObject)localObject6).optBoolean("catchHeightChange");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool10;
        bool6 = bool8;
        bool7 = bool3;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = k;
        i4 = j;
        i5 = i;
        i6 = m;
        i7 = i1;
        localObject3 = localObject4;
        i8 = i10;
        i9 = i11;
        bool2 = ((JSONObject)localObject6).optBoolean("catchClosePanel");
        i2 = i12;
        bool4 = bool9;
        bool5 = bool2;
        bool6 = bool8;
        bool7 = bool3;
        localObject1 = paramVarArgs;
        localObject2 = localObject5;
        i3 = k;
        i4 = j;
        i5 = i;
        i6 = m;
        i7 = i1;
        localObject3 = localObject4;
        i8 = i10;
        i9 = i11;
        if (((JSONObject)localObject6).optInt("isFromDIY") == 1)
        {
          bool1 = true;
          i2 = i12;
          bool4 = bool1;
          bool5 = bool2;
          bool6 = bool8;
          bool7 = bool3;
          localObject1 = paramVarArgs;
          localObject2 = localObject5;
          i3 = k;
          i4 = j;
          i5 = i;
          i6 = m;
          i7 = i1;
          localObject3 = localObject4;
          i8 = i10;
          i9 = i11;
          n = ((JSONObject)localObject6).optInt("curDIYSelectId", -1);
          i2 = n;
          bool4 = bool1;
          bool5 = bool2;
          bool6 = bool8;
          bool7 = bool3;
          localObject1 = paramVarArgs;
          localObject2 = localObject5;
          i3 = k;
          i4 = j;
          i5 = i;
          i6 = m;
          i7 = i1;
          localObject3 = localObject4;
          i8 = i10;
          i9 = i11;
          this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject6).optString("switchFontCallback");
          bool4 = bool8;
          i4 = i10;
          i3 = i1;
          i2 = i;
          i1 = j;
          i10 = k;
          bool8 = bool3;
          bool3 = bool2;
          bool2 = bool1;
          i5 = n;
          if (QLog.isDevelopLevel()) {
            QLog.d("QZoneFeedActionJsPlugin", 4, new Object[] { "handleFeedActionPanel hint is: " + (String)localObject5 + "\t autofill:" + paramVarArgs + ",needEmoticonBtn: " + i2 + ",needAtBtn: " + i1 + ",needPrivateBtn: " + m + ",isReply: " + i3 + ",privateCommentStatus: " + i10 + ",maxLen: " + i4 + ",troopid: " + i11, "acceptEncoded:" + this.jdField_b_of_type_Boolean + " disableAutoClose:" + bool8 + " cachePanelHeight:" + bool4 + " cahcePanelClose:" + bool3 });
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("disableAutoClose", bool8);
          ((Bundle)localObject1).putBoolean("catchHeightChange", bool4);
          ((Bundle)localObject1).putBoolean("catchClosePanel", bool3);
          ((Bundle)localObject1).putBoolean("isFromDIY", bool2);
          ((Bundle)localObject1).putInt("extra_key_font_id", i5);
          i = bgij.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, 2);
          bfpr.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), bfpy.a(), i, (String)localObject5, paramVarArgs, "", "", i10, false, i1, i2, 0, m, i3, (String)localObject4, i4, i11, false, "", false, (Bundle)localObject1);
          b();
          return;
        }
        bool1 = false;
        continue;
        paramVarArgs = (String[])localObject5;
      }
      catch (JSONException paramVarArgs)
      {
        i11 = i2;
        bool2 = bool4;
        bool1 = bool5;
        bool3 = bool6;
        bool8 = bool7;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i10 = i3;
        i1 = i4;
        n = i5;
        m = i6;
        k = i7;
        localObject4 = localObject3;
        j = i8;
        i = i9;
        if (QLog.isColorLevel())
        {
          QLog.d("QZoneFeedActionJsPlugin", 2, "handleFeedActionPanel: ", paramVarArgs);
          i = i9;
          j = i8;
          localObject4 = localObject3;
          k = i7;
          m = i6;
          n = i5;
          i1 = i4;
          i10 = i3;
          localObject6 = localObject2;
          localObject5 = localObject1;
          bool8 = bool7;
          bool3 = bool6;
          bool1 = bool5;
          bool2 = bool4;
          i11 = i2;
        }
      }
      bool4 = bool3;
      i5 = i11;
      bool3 = bool1;
      localObject5 = localObject6;
      i2 = n;
      i3 = k;
      i4 = j;
      i11 = i;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bgho(this);
    }
    if (!this.c)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("FeedActionPanelActivity.content");
      localIntentFilter.addAction("FeedActionPanelActivity.inputpanel_height");
      localIntentFilter.addAction("FeedActionPanelActivity.inputpanel_closed");
      localIntentFilter.addAction("FeedActionPanelActivity.font_select");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void b(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("panel_height", -1);
    QLog.d("QZoneFeedActionJsPlugin", 2, "Input FeedActionPanel totalHeight : " + i);
    if (i == -1) {}
    do
    {
      return;
      try
      {
        paramIntent = "{event_type:\"HEIGHT_CHANGED\",height:\"" + i + "\"}";
        paramIntent = "window." + jdField_a_of_type_JavaLangString + "(" + paramIntent + ");";
        if (QLog.isColorLevel()) {
          QLog.d("QZoneFeedActionJsPlugin", 2, "invoke callback js:" + paramIntent);
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().callJs(paramIntent);
        return;
      }
      catch (Throwable paramIntent) {}
    } while (!QLog.isColorLevel());
    QLog.d("QZoneFeedActionJsPlugin", 2, "notifyPanelHeightChanged: ", paramIntent);
  }
  
  private void b(String paramString)
  {
    Object localObject1 = new Intent("action_js2qzone");
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("cmd", "H5PayCallSucess");
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFeedActionJsPlugin", 2, "handleWriteBlog actionString: " + ((Intent)localObject1).getAction());
    }
    bfpr.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), bfpy.a(), (Intent)localObject1);
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localObject1 = new JSONObject();
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("vipType", paramString);
      ((JSONObject)localObject1).put("type", "YellowInfo");
      ((JSONObject)localObject1).put("data", localObject2);
      localObject2 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("*.qzone.qq.com");
      ((JSONObject)localObject2).put("echo", true);
      ((JSONObject)localObject2).put("broadcast", true);
      ((JSONObject)localObject2).put("domains", localJSONArray);
      a("openVipInfo", (JSONObject)localObject1, (JSONObject)localObject2);
      if (("normalVip".equals(paramString)) || ("highVip".equals(paramString)))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
        if (paramString != null) {
          paramString.finish();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest: ", localException);
        }
      }
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.c)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    this.c = false;
  }
  
  private void c(Intent paramIntent)
  {
    QLog.d("QZoneFeedActionJsPlugin", 2, "notifyInputPanelClosed");
    try
    {
      paramIntent = "window." + jdField_a_of_type_JavaLangString + "(" + "{event_type:\"PANEL_CLOSED\"}" + ");";
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFeedActionJsPlugin", 2, "invoke callback js:" + paramIntent);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().callJs(paramIntent);
      return;
    }
    catch (Throwable paramIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QZoneFeedActionJsPlugin", 2, "notifyInputPanelClosed: ", paramIntent);
    }
  }
  
  private void d(Intent paramIntent)
  {
    int i = 0;
    boolean bool = paramIntent.getBooleanExtra("extraPrivateComment", false);
    String str2 = paramIntent.getStringExtra("contentIntentKey");
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_Boolean)
        {
          str1 = URLEncoder.encode(str2, "utf-8");
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("content", str1);
          if (bool) {
            i = 1;
          }
          localJSONObject.put("privateComment", i);
          localJSONObject.put("font_id", paramIntent.getIntExtra("extra_key_font_id", -1));
          localJSONObject.put("font_type", paramIntent.getIntExtra("extra_key_font_format_type", -1));
          localJSONObject.put("font_url", paramIntent.getStringExtra("extra_key_font_url"));
          paramIntent = "window." + jdField_a_of_type_JavaLangString + "(" + localJSONObject.toString() + ");";
          if (QLog.isColorLevel()) {
            QLog.d("QZoneFeedActionJsPlugin", 2, "invoke callback js:" + paramIntent);
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().callJs(paramIntent);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QZoneFeedActionJsPlugin", 2, "content:" + str2, paramIntent);
        return;
      }
      String str1 = str2;
    }
  }
  
  public void a()
  {
    LocalMultiProcConfig.putBool("FeedAction#isActive", false);
    c();
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    default: 
      return;
    }
    if (paramInt == -1) {
      d(paramIntent);
    }
    c();
  }
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    super.a(paramWebViewPlugin);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest \n url: " + paramString1 + "\n pkgName:" + paramString2 + "\n method:" + paramString3);
    }
    if ("TopicComment".equalsIgnoreCase(paramString3))
    {
      a(paramVarArgs);
      return true;
    }
    if ("H5PayCallBack".equalsIgnoreCase(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        MonitorManager.a().a(1, 4, "js 通知native 黄钻支付结果", "" + paramVarArgs[0]);
        a(paramVarArgs[0]);
        if ((paramJsBridgeListener.has("status")) && ("success".equalsIgnoreCase(paramJsBridgeListener.getString("status"))))
        {
          b(paramJsBridgeListener.optString("vipType", null));
          return true;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest: ", paramJsBridgeListener);
        }
      }
    }
    for (;;)
    {
      return false;
      if ("hasClickedWeiShiMedelSwitch".equalsIgnoreCase(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          if ((!paramJsBridgeListener.has("uin")) || (!paramJsBridgeListener.has("ishide"))) {
            continue;
          }
          a(paramJsBridgeListener.getLong("uin"), paramJsBridgeListener.getInt("ishide"));
          return true;
        }
        catch (Exception paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest: ", paramJsBridgeListener);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bghn
 * JD-Core Version:    0.7.0.1
 */