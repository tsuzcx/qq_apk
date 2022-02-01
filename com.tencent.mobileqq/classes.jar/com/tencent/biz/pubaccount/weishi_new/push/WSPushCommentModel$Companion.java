package com.tencent.biz.pubaccount.weishi_new.push;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/push/WSPushCommentModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/biz/pubaccount/weishi_new/push/WSPushCommentModel;", "parseJson", "jsonObject", "Lorg/json/JSONObject;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSPushCommentModel$Companion
{
  @JvmStatic
  @Nullable
  public final WSPushCommentModel a(@Nullable JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    WSPushCommentModel localWSPushCommentModel = new WSPushCommentModel();
    int i = paramJSONObject.optInt("isShowCommentPanel");
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    WSPushCommentModel.a(localWSPushCommentModel, bool);
    String str = paramJSONObject.optString("commentId");
    Intrinsics.checkExpressionValueIsNotNull(str, "jsonObject.optString(\"commentId\")");
    WSPushCommentModel.a(localWSPushCommentModel, str);
    paramJSONObject = paramJSONObject.optString("replyId");
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "jsonObject.optString(\"replyId\")");
    WSPushCommentModel.b(localWSPushCommentModel, paramJSONObject);
    return localWSPushCommentModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushCommentModel.Companion
 * JD-Core Version:    0.7.0.1
 */