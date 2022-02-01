package com.tencent.hippy.qq.module.tkd;

import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.hippy.qq.tuwen.callback.ITKDTuWenHippyObserver;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/hippy/qq/module/tkd/TKDCommentBizModule$initialize$1", "Lcom/tencent/hippy/qq/tuwen/callback/ITKDTuWenHippyObserver;", "onDeleteMainComment", "", "mainCommentId", "", "onDeleteSubComment", "subCommentId", "onInsertSubComment", "repliedCommentId", "subCommentData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/SubCommentData;", "onLikeMainCommentChanged", "like", "", "onOpenCommentPublisher", "prepareSubCommentData", "sendCommentReadTime", "time", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentBizModule$initialize$1
  implements ITKDTuWenHippyObserver
{
  private final String prepareSubCommentData(SubCommentData paramSubCommentData)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("commentId", paramSubCommentData.commentId);
    localJSONObject.put("nickName", paramSubCommentData.nickName);
    localJSONObject.put("isAuthorReply", paramSubCommentData.isAuthorReply);
    localJSONObject.put("followStatus", paramSubCommentData.isFollowing);
    localJSONObject.put("repliedUserId", paramSubCommentData.repliedUserUin);
    localJSONObject.put("repliedUserNickName", paramSubCommentData.repliedUserNickname);
    localJSONObject.put("repliedUserHomepage", paramSubCommentData.repliedUserHomePage);
    localJSONObject.put("authorLike", paramSubCommentData.isAuthorLike);
    localJSONObject.put("content", paramSubCommentData.commentContent);
    paramSubCommentData = localJSONObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramSubCommentData, "jsonObj.toString()");
    return paramSubCommentData;
  }
  
  public void onDeleteMainComment(@Nullable String paramString)
  {
    QLog.d("TKDCommentBizModule", 1, "onDeleteMainComment commentId=" + paramString);
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("commentId", paramString);
    this.this$0.sendEventToJs("@comment:deleteLevel1Comment", localHippyMap);
  }
  
  public void onDeleteSubComment(@Nullable String paramString1, @Nullable String paramString2)
  {
    QLog.d("TKDCommentBizModule", 1, "onDeleteSubComment:mainCommentId=" + paramString1 + ',' + "subCommentId=" + paramString2);
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("commentId", paramString1);
    localHippyMap.pushString("subCommentId", paramString2);
    this.this$0.sendEventToJs("@comment:deleteLevel2Comment", localHippyMap);
  }
  
  public void onInsertSubComment(@Nullable String paramString1, @Nullable String paramString2, @Nullable SubCommentData paramSubCommentData)
  {
    QLog.d("TKDCommentBizModule", 1, "onInsertSubComment:mainCommentId=" + paramString1 + ',' + "repliedCommentId=" + paramString2 + ", subCommentData=" + paramSubCommentData);
    if (paramSubCommentData == null) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("commentId", paramString1);
    localHippyMap.pushString("repliedCommentId", paramString2);
    try
    {
      localHippyMap.pushString("subComment", prepareSubCommentData(paramSubCommentData));
      this.this$0.sendEventToJs("@comment:insertLevel2Comment", localHippyMap);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("TKDCommentBizModule", 1, (Throwable)paramString1, new Object[0]);
    }
  }
  
  public void onLikeMainCommentChanged(@Nullable String paramString, boolean paramBoolean)
  {
    QLog.d("TKDCommentBizModule", 1, "onLikeMainCommentChanged commentId=" + paramString + ", like=" + paramBoolean);
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("commentId", paramString);
    localHippyMap.pushBoolean("isLike", paramBoolean);
    this.this$0.sendEventToJs("@comment:toggleLevel1PraiseStatus", localHippyMap);
  }
  
  public void onOpenCommentPublisher()
  {
    QLog.d("TKDCommentBizModule", 1, "onOpenCommentPublisher");
    HippyMap localHippyMap = new HippyMap();
    this.this$0.sendEventToJs("@comment:openPublisher", localHippyMap);
  }
  
  public void sendCommentReadTime(long paramLong)
  {
    QLog.d("TKDCommentBizModule", 1, "sendCommentReadTime:time=" + paramLong);
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushLong("readTime", paramLong);
    this.this$0.sendEventToJs("@comment:reportCommentReadTime", localHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDCommentBizModule.initialize.1
 * JD-Core Version:    0.7.0.1
 */