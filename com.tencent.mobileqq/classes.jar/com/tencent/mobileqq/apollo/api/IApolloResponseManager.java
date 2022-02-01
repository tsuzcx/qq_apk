package com.tencent.mobileqq.apollo.api;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.script.callback.ISpriteTaskStatusCallback;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

@Service(needUin=false, process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/IApolloResponseManager;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/mobileqq/apollo/script/callback/ISpriteTaskStatusCallback;", "removeResponseView", "", "updateQuickResponseView", "pie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "actionData", "Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;", "srcId", "", "senderUin", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloResponseManager
  extends ISpriteTaskStatusCallback, IRuntimeService
{
  public abstract void removeResponseView();
  
  public abstract void updateQuickResponseView(@Nullable BaseChatPie paramBaseChatPie, @Nullable ApolloActionData paramApolloActionData, int paramInt, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.IApolloResponseManager
 * JD-Core Version:    0.7.0.1
 */