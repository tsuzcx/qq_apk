package com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/plugin/jsMethodAction/OpenTKPublisherAction;", "Lcom/tencent/biz/pubaccount/readinjoy/plugin/jsMethodAction/JsMethodAction;", "()V", "callback", "", "name", "getName", "()Ljava/lang/String;", "action", "", "client", "Lcom/tencent/biz/troop/TroopMemberApiClient;", "activity", "Landroid/app/Activity;", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/biz/troop/TroopMemberApiClient;Landroid/app/Activity;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "checkTopicVideoUploadNum", "", "json", "Lorg/json/JSONObject;", "dealResult", "resultCode", "", "msg", "parseVideoCoverPath", "filePath", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class OpenTKPublisherAction
  implements JsMethodAction
{
  public static final OpenTKPublisherAction.Companion a;
  private String a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginJsMethodActionOpenTKPublisherAction$Companion = new OpenTKPublisherAction.Companion(null);
  }
  
  public OpenTKPublisherAction()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private final void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 1)
    {
      QQToast.a((Context)BaseApplicationImpl.getContext(), 1, (CharSequence)paramString1, 0).a();
      ReadInJoyJsMethodActionController.a(ReadInJoyJsMethodActionController.a, this.jdField_a_of_type_JavaLangString, 1, paramString1, null, 8, null);
      return;
    }
    a(paramString2);
  }
  
  private final void a(TroopMemberApiClient paramTroopMemberApiClient, JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", paramTroopMemberApiClient.a((TroopMemberApiClient.Callback)new OpenTKPublisherAction.checkTopicVideoUploadNum.callbackSeq.1(this)));
    localBundle.putString("extra", paramJSONObject.toString());
    paramTroopMemberApiClient.a(161, localBundle);
  }
  
  private final void a(String paramString)
  {
    if (((CharSequence)paramString).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ReadInJoyJsMethodActionController localReadInJoyJsMethodActionController = ReadInJoyJsMethodActionController.a;
      String str = this.jdField_a_of_type_JavaLangString;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramString);
      localReadInJoyJsMethodActionController.a(str, 0, "success", localJSONObject);
      return;
    }
    ReadInJoyJsMethodActionController.a(ReadInJoyJsMethodActionController.a, this.jdField_a_of_type_JavaLangString, 1, "url is empty", null, 8, null);
  }
  
  @NotNull
  public String a()
  {
    return "openTKPublisher";
  }
  
  public boolean a(@NotNull TroopMemberApiClient paramTroopMemberApiClient, @Nullable Activity paramActivity, @Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String... paramVarArgs)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramTroopMemberApiClient, "client");
    Intrinsics.checkParameterIsNotNull(paramString2, "pkgName");
    Intrinsics.checkParameterIsNotNull(paramString3, "method");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (paramActivity == null) {
      return false;
    }
    if (paramVarArgs.length == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        j = 1;
      }
      if (j != 0) {
        try
        {
          paramActivity = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramActivity.optString("callback");
          Intrinsics.checkExpressionValueIsNotNull(paramJsBridgeListener, "jobj.optString(\"callback\")");
          this.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
          paramActivity = paramActivity.optJSONObject("eventInfo");
          if (paramActivity != null) {}
          for (;;)
          {
            a(paramTroopMemberApiClient, paramActivity);
            break;
            paramActivity = new JSONObject();
          }
          return true;
        }
        catch (JSONException paramTroopMemberApiClient) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.OpenTKPublisherAction
 * JD-Core Version:    0.7.0.1
 */