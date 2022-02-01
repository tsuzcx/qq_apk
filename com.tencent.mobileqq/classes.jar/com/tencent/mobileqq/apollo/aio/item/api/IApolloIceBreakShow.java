package com.tencent.mobileqq.apollo.aio.item.api;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/aio/item/api/IApolloIceBreakShow;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getView", "Landroid/view/View;", "init", "", "context", "Landroid/content/Context;", "width", "", "height", "app", "Lcom/tencent/common/app/AppInterface;", "isPlaying", "", "isReady", "onSend", "baseAIOContext", "Lcom/tencent/mobileqq/activity/aio/core/BaseAIOContext;", "pause", "play", "resume", "setJson", "jsonObject", "Lorg/json/JSONObject;", "sessionInfo", "Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;", "stop", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloIceBreakShow
  extends QRouteApi
{
  @Nullable
  public abstract View getView();
  
  public abstract void init(@NotNull Context paramContext, int paramInt1, int paramInt2, @NotNull AppInterface paramAppInterface);
  
  public abstract boolean isPlaying();
  
  public abstract boolean isReady();
  
  public abstract void onSend(@NotNull AppInterface paramAppInterface, @Nullable BaseAIOContext paramBaseAIOContext);
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void resume();
  
  public abstract void setJson(@Nullable JSONObject paramJSONObject, @Nullable BaseSessionInfo paramBaseSessionInfo);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.api.IApolloIceBreakShow
 * JD-Core Version:    0.7.0.1
 */