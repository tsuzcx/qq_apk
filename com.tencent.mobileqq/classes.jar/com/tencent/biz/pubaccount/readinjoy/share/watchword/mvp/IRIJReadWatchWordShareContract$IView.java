package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IView;", "", "jumpToTargetPage", "", "jumpUrl", "", "type", "", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$UserInfo;", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$VideoInfo;", "topicInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$TopicInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJReadWatchWordShareContract$IView
{
  public abstract void a(@NotNull String paramString, int paramInt, @Nullable RIJReadWatchWordModel.UserInfo paramUserInfo, @Nullable RIJReadWatchWordModel.VideoInfo paramVideoInfo, @Nullable RIJReadWatchWordModel.TopicInfo paramTopicInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.IRIJReadWatchWordShareContract.IView
 * JD-Core Version:    0.7.0.1
 */