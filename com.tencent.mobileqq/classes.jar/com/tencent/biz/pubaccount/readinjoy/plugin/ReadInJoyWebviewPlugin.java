package com.tencent.biz.pubaccount.readinjoy.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.base.ReadInJoyCommentEntrance;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.JsMethodAction;
import com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.OpenTKPublisherAction;
import com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.ReadInJoyJsMethodActionController;
import com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.TweetTopicEntranceShouldShowAction;
import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyWebviewPlugin
  extends WebViewPlugin
{
  public Bundle a;
  ReadInjoyWebShareHelper jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  private String jdField_a_of_type_JavaLangString = null;
  
  public ReadInJoyWebviewPlugin()
  {
    this.mPluginNameSpace = "readinjoy";
    ReadInJoyJsMethodActionController.a.a(this);
    b();
  }
  
  /* Error */
  private void a(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: ldc 39
    //   8: invokevirtual 45	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 4
    //   13: aload_2
    //   14: ldc 47
    //   16: invokevirtual 45	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: ifnull +64 -> 85
    //   24: new 49	org/json/JSONObject
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull -30 -> 4
    //   37: iload_1
    //   38: iconst_m1
    //   39: if_icmpeq +63 -> 102
    //   42: aload_3
    //   43: ldc 54
    //   45: iconst_m1
    //   46: invokevirtual 58	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   49: pop
    //   50: aload_3
    //   51: ldc 60
    //   53: iconst_0
    //   54: invokevirtual 58	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload_0
    //   59: aload 4
    //   61: iconst_1
    //   62: anewarray 62	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: aload_3
    //   68: invokevirtual 66	org/json/JSONObject:toString	()Ljava/lang/String;
    //   71: aastore
    //   72: invokevirtual 70	com/tencent/biz/pubaccount/readinjoy/plugin/ReadInJoyWebviewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   75: return
    //   76: astore_3
    //   77: ldc 72
    //   79: iconst_1
    //   80: ldc 74
    //   82: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aconst_null
    //   86: astore_3
    //   87: goto -54 -> 33
    //   90: astore_2
    //   91: ldc 72
    //   93: iconst_1
    //   94: ldc 82
    //   96: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: goto -41 -> 58
    //   102: aload_2
    //   103: ldc 84
    //   105: invokevirtual 88	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   108: astore 5
    //   110: aload_0
    //   111: getfield 17	com/tencent/biz/pubaccount/readinjoy/plugin/ReadInJoyWebviewPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   114: aload_3
    //   115: aload 5
    //   117: new 90	com/tencent/biz/pubaccount/readinjoy/plugin/ReadInJoyWebviewPlugin$7
    //   120: dup
    //   121: aload_0
    //   122: iload_1
    //   123: aload_2
    //   124: aload 4
    //   126: invokespecial 93	com/tencent/biz/pubaccount/readinjoy/plugin/ReadInJoyWebviewPlugin$7:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/plugin/ReadInJoyWebviewPlugin;ILandroid/content/Intent;Ljava/lang/String;)V
    //   129: invokevirtual 98	com/tencent/biz/troop/TroopMemberApiClient:a	(Lorg/json/JSONObject;Landroid/os/Parcelable;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   132: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	ReadInJoyWebviewPlugin
    //   0	133	1	paramInt	int
    //   0	133	2	paramIntent	Intent
    //   19	49	3	localObject	Object
    //   76	1	3	localJSONException	JSONException
    //   86	29	3	localJSONObject	JSONObject
    //   11	114	4	str	String
    //   108	8	5	localParcelable	android.os.Parcelable
    // Exception table:
    //   from	to	target	type
    //   24	33	76	org/json/JSONException
    //   42	58	90	org/json/JSONException
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    callJs(paramString1, new String[] { RIJJumpUtils.a(paramInt, paramString2).toString() });
  }
  
  private void a(String paramString, Exception paramException)
  {
    if (QLog.isColorLevel())
    {
      paramException.printStackTrace();
      QLog.e("ReadInJoyWebviewPlugin", 2, paramException.getMessage());
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 1);
      localJSONObject.put("msg", paramException.getMessage());
      super.callJs(paramString + "(" + localJSONObject.toString() + ");");
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoyWebviewPlugin", 2, paramException.getMessage());
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    RIJJumpUtils.a(this.mRuntime.a(), paramJSONObject, new ReadInJoyWebviewPlugin.1(this, paramJSONObject.optString("callback")));
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle.clear();
    long l = new BigInteger(paramJSONObject.getString("feeds_id")).longValue();
    this.jdField_a_of_type_AndroidOsBundle.putLong("feeds_id", Long.valueOf(l).longValue());
    int i = paramJSONObject.optInt("feeds_type", 1);
    this.jdField_a_of_type_AndroidOsBundle.putInt("feeds_type", Integer.valueOf(i).intValue());
    a(DataFactory.a("ipc_kandian_socialfeeds_update", paramString, 0, this.jdField_a_of_type_AndroidOsBundle), false, false);
  }
  
  private boolean a(String paramString, int paramInt, Intent paramIntent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    try
    {
      paramString = new JSONObject(paramString);
      bool1 = bool3;
      int i = paramString.optInt("errorCode");
      bool1 = bool3;
      paramString = paramString.optString("comment");
      bool1 = bool2;
      if (i == -4097)
      {
        bool1 = true;
        bool2 = true;
        ReadInJoyCommentEntrance.a(new ReadInJoyWebviewPlugin.8(this, paramInt, paramIntent, paramString));
        bool1 = bool2;
      }
      return bool1;
    }
    catch (JSONException paramString) {}
    return bool1;
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper = new ReadInjoyWebShareHelper(this, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient);
    }
    if (paramArrayOfString == null) {
      return true;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper.a(paramArrayOfString[0]);
    return false;
  }
  
  private void b()
  {
    Object localObject = new TweetTopicEntranceShouldShowAction();
    ReadInJoyJsMethodActionController.a.a((JsMethodAction)localObject);
    localObject = new OpenTKPublisherAction();
    ReadInJoyJsMethodActionController.a.a((JsMethodAction)localObject);
  }
  
  private void b(@NotNull JSONObject paramJSONObject)
  {
    if (this.mRuntime.a() == null) {
      return;
    }
    String str2 = paramJSONObject.optString("callback");
    boolean bool1 = paramJSONObject.optBoolean("enableAnonymous", false);
    boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
    int i = paramJSONObject.optInt("maxLength", -1);
    int j = paramJSONObject.optInt("commentType", 0);
    int k = paramJSONObject.optInt("sourceType", 0);
    int m = paramJSONObject.optInt("openAt", 0);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("defaultCommentAtLevel");
    localObject1 = paramJSONObject.optString("placeholder");
    try
    {
      localObject2 = new String(Base64Util.decode((String)localObject1, 0));
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject2;
        QLog.e("ReadInJoyWebviewPlugin", 1, "showCommentEditorNative | comment_placeholder decode error! | comment_placeholder: " + (String)localObject1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyWebviewPlugin", 2, "showCommentEditorNative | comment_placeholder after decode: " + (String)localObject1);
    }
    localObject2 = paramJSONObject.optString("defaultTxt");
    try
    {
      str1 = new String(Base64Util.decode((String)localObject2, 0));
      localObject2 = str1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        String str1;
        String str3;
        int n;
        int i1;
        String str6;
        String str4;
        long l;
        String str5;
        Intent localIntent;
        QLog.e("ReadInJoyWebviewPlugin", 1, "showCommentEditorNative | defaultTxt decode error! | defaultTxt: " + localException1);
        continue;
        paramJSONObject = new SubCommentCreateData(i1, str6);
        paramJSONObject.a(str4);
        paramJSONObject.b(localException2);
        paramJSONObject.c(str3);
        paramJSONObject.a(l);
        paramJSONObject.e(str5);
        paramJSONObject.b(n);
        localIntent.putExtra("comment_create_data", paramJSONObject);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyWebviewPlugin", 2, "showCommentEditorNative | defaultTxt after decode: " + (String)localObject2);
    }
    str1 = paramJSONObject.optString("rowkey");
    str3 = paramJSONObject.optString("articleId");
    n = paramJSONObject.optInt("scene");
    i1 = paramJSONObject.optInt("entry");
    str6 = paramJSONObject.optString("businessInfo");
    str4 = paramJSONObject.optString("firstCommentId");
    l = paramJSONObject.optLong("repliedSubAuthorId");
    str5 = paramJSONObject.optString("repliedSubCommentId");
    localIntent = new Intent();
    if (paramJSONObject.has("isPgcAuthor")) {
      localIntent.putExtra("comment_is_pgc_author", paramJSONObject.optBoolean("isPgcAuthor"));
    }
    localIntent.putExtra("comment_to_reply_contain_link", paramJSONObject.optInt("report_comment_link_reply", 2));
    localIntent.putExtra("comment_type", false);
    localIntent.putExtra("arg_comment_enable_anonymous", bool1);
    localIntent.putExtra("arg_comment_placeholder", (String)localObject1);
    localIntent.putExtra("arg_comment_default_txt", (String)localObject2);
    localIntent.putExtra("arg_comment_max_length", i);
    localIntent.putExtra("arg_comment_comment_type", j);
    localIntent.putExtra("arg_comment_source_type", k);
    localIntent.putExtra("arg_callback", str2);
    localIntent.putExtra("arg_comment_open_at", m);
    localIntent.putExtra("comment_can_biu", bool2);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("need_intercept", false);
    if (localJSONArray != null) {
      localIntent.putExtra("arg_comment_default_comment_at", localJSONArray.toString());
    }
    if (str4.isEmpty())
    {
      paramJSONObject = new FirstCommentCreateData(i1, str6);
      paramJSONObject.b(str1);
      paramJSONObject.c(str3);
      paramJSONObject.b(n);
      localIntent.putExtra("comment_create_data", paramJSONObject);
      ReadInJoyCommentEntrance.a(this.mRuntime.a(), localIntent, SwiftWebViewUtils.a(10, WebViewUtil.a(this)));
      return;
    }
  }
  
  private void c()
  {
    Intent localIntent = new Intent(this.mRuntime.a(), ReadInJoyMessagesActivity.class);
    localIntent.setFlags(67108864);
    startActivityForResult(localIntent, (byte)0);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("callback");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramJSONObject, new ReadInJoyWebviewPlugin.2(this, str));
  }
  
  private void d(JSONObject paramJSONObject)
  {
    localObject = null;
    try
    {
      str2 = paramJSONObject.getString("callback");
      String str3;
      String str1;
      long l1;
      long l2;
      long l3;
      int i;
      QLog.w("ReadInJoyWebviewPlugin", 1, "setSkinAndSound error " + paramJSONObject.toString());
    }
    catch (Exception paramJSONObject)
    {
      try
      {
        str3 = paramJSONObject.getString("skinId");
        localObject = "";
        if (paramJSONObject.has("skinUrl")) {
          localObject = paramJSONObject.optString("skinUrl");
        }
        str1 = "";
        if (paramJSONObject.has("skinName")) {
          str1 = paramJSONObject.optString("skinName");
        }
        l1 = 0L;
        if (paramJSONObject.has("seq")) {
          l1 = paramJSONObject.optLong("seq");
        }
        l2 = 0L;
        if (paramJSONObject.has("startTime")) {
          l2 = paramJSONObject.optLong("startTime");
        }
        l3 = 0L;
        if (paramJSONObject.has("endTime")) {
          l3 = paramJSONObject.optLong("endTime");
        }
        i = 0;
        if (paramJSONObject.has("volumeIsOn")) {
          i = paramJSONObject.optInt("volumeIsOn");
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(str3, l1, (String)localObject, str1, l2, l3, i, new ReadInJoyWebviewPlugin.3(this, str2));
        QLog.d("ReadInJoyWebviewPlugin", 4, "send set skin cmd to service");
        return;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          String str2;
          localObject = str2;
        }
      }
      paramJSONObject = paramJSONObject;
    }
    callJs((String)localObject, new String[] { "{\"retCode\":-1}" });
  }
  
  private void e(JSONObject paramJSONObject)
  {
    String str2 = null;
    try
    {
      str1 = paramJSONObject.getString("callback");
      String str3;
      String str4;
      long l1;
      long l2;
      long l3;
      QLog.w("ReadInJoyWebviewPlugin", 1, "notifyLoadSkin error " + paramJSONObject.toString());
    }
    catch (JSONException paramJSONObject)
    {
      try
      {
        str2 = paramJSONObject.getString("skinId");
        str3 = paramJSONObject.getString("skinUrl");
        str4 = paramJSONObject.getString("skinName");
        l1 = paramJSONObject.getLong("seq");
        l2 = paramJSONObject.getLong("startTime");
        l3 = paramJSONObject.getLong("endTime");
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(str2, l1, str3, str4, l2, l3, new ReadInJoyWebviewPlugin.4(this, str1));
        QLog.d("ReadInJoyWebviewPlugin", 4, "send notifyLoadSkin cmd to service");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        String str1;
        break label107;
      }
      paramJSONObject = paramJSONObject;
      str1 = str2;
    }
    label107:
    callJs(str1, new String[] { "{\"retCode\":-1}" });
  }
  
  private void f(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = null;
    try
    {
      paramJSONObject = paramJSONObject.getString("callback");
      localJSONObject = paramJSONObject;
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.h(new ReadInJoyWebviewPlugin.5(this, paramJSONObject));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.w("ReadInJoyWebviewPlugin", 1, "readSkinAndSound error " + paramJSONObject.toString());
      callJs(localJSONObject, new String[] { "{\"retCode\":-1}" });
    }
  }
  
  private void g(JSONObject paramJSONObject)
  {
    Object localObject = null;
    try
    {
      String str2 = paramJSONObject.getString("callback");
      localObject = str2;
      String str3 = paramJSONObject.getString("skinId");
      String str1 = "";
      localObject = str2;
      if (paramJSONObject.has("skinUrl"))
      {
        localObject = str2;
        str1 = paramJSONObject.optString("skinUrl");
      }
      localObject = str2;
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.e(str3, str1, new ReadInJoyWebviewPlugin.6(this, str2));
      localObject = str2;
      QLog.d("ReadInJoyWebviewPlugin", 4, "send cancelLoadSkin cmd to service");
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.w("ReadInJoyWebviewPlugin", 1, "cancelLoadSkin error " + paramJSONObject.toString());
      callJs(localObject, new String[] { "{\"retCode\":-1}" });
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyWebviewPlugin", 2, "do updateSocialFeedsInfo all");
    }
    this.jdField_a_of_type_AndroidOsBundle.putLong("feeds_id", -1L);
    this.jdField_a_of_type_AndroidOsBundle.putLong("feeds_type", 1L);
    a(DataFactory.a("ipc_kandian_socialfeeds_update", "", 0, this.jdField_a_of_type_AndroidOsBundle), false, false);
  }
  
  protected void a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!WebIPCOperator.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(this.mRuntime.a().getApplicationContext(), HardCodeUtil.a(2131712790), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      WebIPCOperator.a().b(paramBundle);
      return;
    }
    WebIPCOperator.a().a(paramBundle);
  }
  
  public boolean a(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = null;
    String str;
    try
    {
      str = paramJSONObject.optString("callback");
      if (str == null)
      {
        localObject = str;
        throw new Exception("need callback");
      }
    }
    catch (Exception paramString)
    {
      a(localObject, paramString);
    }
    for (;;)
    {
      return true;
      localObject = str;
      if (TextUtils.equals("socialize_feeds_update", paramString))
      {
        localObject = str;
        a(paramJSONObject, str);
      }
      else
      {
        localObject = str;
        if (TextUtils.equals("openPrivateLetter", paramString))
        {
          localObject = str;
          this.jdField_a_of_type_JavaLangString = str;
          localObject = str;
          c();
        }
      }
    }
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    super.callJs(paramString, paramVarArgs);
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 16777216L;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyWebviewPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"readinjoy".equals(paramString2)) || (paramString3 == null)) {}
    do
    {
      return false;
      if (!"showShareReadInJoyMenu".equals(paramString3)) {
        break;
      }
    } while (a(paramVarArgs));
    for (;;)
    {
      return true;
      JSONObject localJSONObject = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (localJSONObject == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyWebviewPlugin", 2, "handleJsRequest JSON = " + localJSONObject.toString());
      }
      if ((TextUtils.equals("socialize_feeds_update", paramString3)) || (TextUtils.equals("openPrivateLetter", paramString3))) {
        return a(paramString3, localJSONObject);
      }
      JsMethodAction localJsMethodAction = ReadInJoyJsMethodActionController.a.a(paramString3);
      if (localJsMethodAction != null) {
        return localJsMethodAction.a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.mRuntime.a(), paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
      if ("readSkinAndSound".equals(paramString3)) {
        f(localJSONObject);
      } else if ("notifyLoadSkin".equals(paramString3)) {
        e(localJSONObject);
      } else if ("cancelLoadSkin".equals(paramString3)) {
        g(localJSONObject);
      } else if ("setSkinAndSound".equals(paramString3)) {
        d(localJSONObject);
      } else if ("showCommentEditorNative".equals(paramString3)) {
        b(localJSONObject);
      } else if ("getALDConfig".equals(paramString3)) {
        c(localJSONObject);
      } else if ("showLevelDialog".equalsIgnoreCase(paramString3)) {
        a(localJSONObject);
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    Log.d("ReadInJoyWebviewPlugin", "onActivityResult()");
    if ((paramByte == 0) && (paramIntent != null))
    {
      paramInt = paramIntent.getIntExtra("extra_private_letter_count", 0);
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { Integer.toString(paramInt) });
    }
    do
    {
      do
      {
        return;
        if ((paramByte != 1) && (paramByte != 2)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper == null);
      this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper.a(paramIntent, paramByte, paramInt);
      return;
    } while (paramByte != 10);
    a(paramInt, paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.plugin.ReadInJoyWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */