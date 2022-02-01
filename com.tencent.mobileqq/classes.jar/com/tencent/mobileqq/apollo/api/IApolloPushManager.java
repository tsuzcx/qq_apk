package com.tencent.mobileqq.apollo.api;

import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Service(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/IApolloPushManager;", "Lmqq/app/api/IRuntimeService;", "onReceiveAioPush", "", "msgElem", "", "onReceiveApolloPush", "onReceiveDrawerHirePush", "onRecvActionPush", "aioType", "", "setActionPushListener", "lis", "Lcom/tencent/mobileqq/apollo/api/IApolloPushManager$OnActionPushListener;", "triggerAction", "pushData", "Lcom/tencent/mobileqq/apollo/model/ApolloActionPush;", "Constant", "OnActionPushListener", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloPushManager
  extends IRuntimeService
{
  public static final IApolloPushManager.Constant Constant = IApolloPushManager.Constant.a;
  @NotNull
  public static final String KEY_HIRE_ACTION = "hire_action";
  @NotNull
  public static final String KEY_HIRE_BUBBLE_CLICK = "hire_bubble_click";
  @NotNull
  public static final String KEY_HIRE_END = "hire_end";
  @NotNull
  public static final String KEY_HIRE_FOR = "hire_for";
  @NotNull
  public static final String KEY_HIRE_PRIORITY = "hire_priority";
  @NotNull
  public static final String KEY_HIRE_WORD = "hire_word";
  @NotNull
  public static final String TAG = "ApolloPushManager";
  
  public abstract void onReceiveAioPush(@Nullable Object paramObject);
  
  public abstract void onReceiveApolloPush(@Nullable Object paramObject);
  
  public abstract void onReceiveDrawerHirePush(@Nullable Object paramObject);
  
  public abstract void onRecvActionPush(int paramInt, @Nullable Object paramObject);
  
  public abstract void setActionPushListener(@Nullable IApolloPushManager.OnActionPushListener paramOnActionPushListener);
  
  public abstract void triggerAction(@Nullable ApolloActionPush paramApolloActionPush);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.IApolloPushManager
 * JD-Core Version:    0.7.0.1
 */