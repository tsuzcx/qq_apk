package com.tencent.biz.pubaccount.weishi_new;

import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/WSAutoShowCommentParams;", "Ljava/io/Serializable;", "extJson", "", "(Ljava/lang/String;)V", "isShowCommentPanel", "", "commentId", "replyId", "(ZLjava/lang/String;Ljava/lang/String;)V", "TAG", "<set-?>", "getCommentId", "()Ljava/lang/String;", "()Z", "getReplyId", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSAutoShowCommentParams
  implements Serializable
{
  public static final WSAutoShowCommentParams.Companion Companion = new WSAutoShowCommentParams.Companion(null);
  @NotNull
  public static final String KEY_COMMENT = "comment";
  @NotNull
  public static final String KEY_COMMENT_ID = "commentId";
  @NotNull
  public static final String KEY_IS_SHOW_COMMENT_PANEL = "isShowCommentPanel";
  @NotNull
  public static final String KEY_REPLY_ID = "replyId";
  private final String TAG = "WSAutoShowCommentParams";
  @NotNull
  private String commentId = "";
  private boolean isShowCommentPanel;
  @NotNull
  private String replyId = "";
  
  public WSAutoShowCommentParams(@Nullable String paramString)
  {
    Object localObject = (CharSequence)paramString;
    boolean bool = false;
    int i;
    if ((localObject != null) && (!StringsKt.isBlank((CharSequence)localObject))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      paramString = paramString.optJSONObject("comment");
      if (paramString != null)
      {
        if (paramString.optInt("isShowCommentPanel") == 1) {
          bool = true;
        }
        this.isShowCommentPanel = bool;
        localObject = paramString.optString("commentId");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "commentObject.optString(KEY_COMMENT_ID)");
        this.commentId = ((String)localObject);
        paramString = paramString.optString("replyId");
        Intrinsics.checkExpressionValueIsNotNull(paramString, "commentObject.optString(KEY_REPLY_ID)");
        this.replyId = paramString;
      }
      return;
    }
    catch (JSONException paramString)
    {
      WSLog.e(this.TAG, Log.getStackTraceString((Throwable)paramString));
    }
  }
  
  public WSAutoShowCommentParams(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2)
  {
    this.isShowCommentPanel = paramBoolean;
    this.commentId = paramString1;
    this.replyId = paramString2;
  }
  
  @NotNull
  public final String getCommentId()
  {
    return this.commentId;
  }
  
  @NotNull
  public final String getReplyId()
  {
    return this.replyId;
  }
  
  public final boolean isShowCommentPanel()
  {
    return this.isShowCommentPanel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSAutoShowCommentParams
 * JD-Core Version:    0.7.0.1
 */