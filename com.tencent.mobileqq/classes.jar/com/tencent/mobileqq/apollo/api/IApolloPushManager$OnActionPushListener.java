package com.tencent.mobileqq.apollo.api;

import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/IApolloPushManager$OnActionPushListener;", "", "onActionPush", "", "aioType", "", "pushData", "Lcom/tencent/mobileqq/apollo/model/ApolloActionPush;", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloPushManager$OnActionPushListener
{
  public abstract void a(int paramInt, @Nullable ApolloActionPush paramApolloActionPush);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.IApolloPushManager.OnActionPushListener
 * JD-Core Version:    0.7.0.1
 */