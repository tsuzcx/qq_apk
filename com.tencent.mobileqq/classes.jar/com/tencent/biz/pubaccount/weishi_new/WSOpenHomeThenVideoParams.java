package com.tencent.biz.pubaccount.weishi_new;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/WSOpenHomeThenVideoParams;", "Ljava/io/Serializable;", "feedId", "", "feedJson", "autoShowCommentParams", "Lcom/tencent/biz/pubaccount/weishi_new/WSAutoShowCommentParams;", "playScene", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/weishi_new/WSAutoShowCommentParams;Ljava/lang/String;)V", "getAutoShowCommentParams", "()Lcom/tencent/biz/pubaccount/weishi_new/WSAutoShowCommentParams;", "getFeedId", "()Ljava/lang/String;", "getFeedJson", "getPlayScene", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSOpenHomeThenVideoParams
  implements Serializable
{
  @NotNull
  private final WSAutoShowCommentParams autoShowCommentParams;
  @Nullable
  private final String feedId;
  @Nullable
  private final String feedJson;
  @NotNull
  private final String playScene;
  
  public WSOpenHomeThenVideoParams(@Nullable String paramString1, @Nullable String paramString2, @NotNull WSAutoShowCommentParams paramWSAutoShowCommentParams, @NotNull String paramString3)
  {
    this.feedId = paramString1;
    this.feedJson = paramString2;
    this.autoShowCommentParams = paramWSAutoShowCommentParams;
    this.playScene = paramString3;
  }
  
  @NotNull
  public final WSAutoShowCommentParams getAutoShowCommentParams()
  {
    return this.autoShowCommentParams;
  }
  
  @Nullable
  public final String getFeedId()
  {
    return this.feedId;
  }
  
  @Nullable
  public final String getFeedJson()
  {
    return this.feedJson;
  }
  
  @NotNull
  public final String getPlayScene()
  {
    return this.playScene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSOpenHomeThenVideoParams
 * JD-Core Version:    0.7.0.1
 */