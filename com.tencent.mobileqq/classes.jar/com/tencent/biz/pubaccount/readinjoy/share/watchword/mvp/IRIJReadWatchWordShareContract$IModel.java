package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IModel;", "", "requestWatchWordUrl", "", "watchWord", "", "callback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "jumpUrl", "", "type", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$UserInfo;", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$VideoInfo;", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$TopicInfo;", "topicInfo", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJReadWatchWordShareContract$IModel
{
  public abstract void a(@NotNull String paramString, @Nullable Function5<? super String, ? super Integer, ? super RIJReadWatchWordModel.UserInfo, ? super RIJReadWatchWordModel.VideoInfo, ? super RIJReadWatchWordModel.TopicInfo, Unit> paramFunction5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.IRIJReadWatchWordShareContract.IModel
 * JD-Core Version:    0.7.0.1
 */