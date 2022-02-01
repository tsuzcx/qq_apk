package com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/plugin/jsMethodAction/TweetTopicEntranceShouldShowAction;", "Lcom/tencent/biz/pubaccount/readinjoy/plugin/jsMethodAction/JsMethodAction;", "()V", "jsCallback", "", "name", "getName", "()Ljava/lang/String;", "action", "", "client", "Lcom/tencent/biz/troop/TroopMemberApiClient;", "activity", "Landroid/app/Activity;", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/biz/troop/TroopMemberApiClient;Landroid/app/Activity;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "callBack", "", "resultCode", "", "msg", "data", "Lorg/json/JSONObject;", "shouldShowPublisherEntrance", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TweetTopicEntranceShouldShowAction
  implements JsMethodAction
{
  public static final TweetTopicEntranceShouldShowAction.Companion a;
  private String a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginJsMethodActionTweetTopicEntranceShouldShowAction$Companion = new TweetTopicEntranceShouldShowAction.Companion(null);
  }
  
  public TweetTopicEntranceShouldShowAction()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    int i = 1;
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    localJSONObject.put("entranceShouldShow", paramInt);
    if (paramInt == 1) {
      i = 0;
    }
    paramString = new JsMethodModel(i, paramString, localJSONObject);
    ReadInJoyJsMethodActionController.a.a(this.jdField_a_of_type_JavaLangString, paramString.a());
  }
  
  private final void a(TroopMemberApiClient paramTroopMemberApiClient)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", paramTroopMemberApiClient.a((TroopMemberApiClient.Callback)new TweetTopicEntranceShouldShowAction.shouldShowPublisherEntrance.callbackSeq.1(this)));
    paramTroopMemberApiClient.a(160, localBundle);
  }
  
  @NotNull
  public String a()
  {
    return "publisherEntranceShouldShow";
  }
  
  public boolean a(@NotNull TroopMemberApiClient paramTroopMemberApiClient, @Nullable Activity paramActivity, @Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String... paramVarArgs)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramTroopMemberApiClient, "client");
    Intrinsics.checkParameterIsNotNull(paramString2, "pkgName");
    Intrinsics.checkParameterIsNotNull(paramString3, "method");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (paramVarArgs.length == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        j = 1;
      }
      if (j != 0) {}
      try
      {
        paramActivity = new JSONObject(paramVarArgs[0]).optString("callback");
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "jobj.optString(\"callback\")");
        this.jdField_a_of_type_JavaLangString = paramActivity;
        if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString)) {
          a(paramTroopMemberApiClient);
        }
        return true;
      }
      catch (JSONException paramTroopMemberApiClient)
      {
        QLog.e("TweetTopicEntranceShouldShowAction", 1, paramTroopMemberApiClient.getMessage());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.TweetTopicEntranceShouldShowAction
 * JD-Core Version:    0.7.0.1
 */