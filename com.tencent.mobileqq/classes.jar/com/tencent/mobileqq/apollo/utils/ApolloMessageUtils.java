package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/ApolloMessageUtils;", "", "()V", "send", "", "chatPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "actionId", "", "textType", "peerUin", "", "type", "from", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloMessageUtils
{
  public static final ApolloMessageUtils a = new ApolloMessageUtils();
  
  public final void a(@Nullable BaseChatPie paramBaseChatPie, int paramInt1, int paramInt2, @Nullable String paramString, int paramInt3, int paramInt4)
  {
    if (paramBaseChatPie == null) {}
    QQAppInterface localQQAppInterface;
    ApolloInfo localApolloInfo;
    Object localObject;
    do
    {
      do
      {
        return;
        localQQAppInterface = paramBaseChatPie.a;
      } while (localQQAppInterface == null);
      localApolloInfo = (ApolloInfo)new ApolloMainInfo(localQQAppInterface.getCurrentUin());
      localObject = localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl");
      }
      localObject = ((ApolloDaoManagerServiceImpl)localObject).findActionById(paramInt1);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "adm.findActionById(actionId)");
    } while (localObject == null);
    ((ApolloActionData)localObject).peerUin = paramString;
    ((ApolloActionData)localObject).isForPlayerAction = 1;
    localApolloInfo.mAction = ((ApolloActionData)localObject);
    localApolloInfo.mAction.personNum = paramInt3;
    localApolloInfo.mTextType = paramInt2;
    localApolloInfo.mSendSrc = paramInt4;
    localApolloInfo.mPackageId = 9;
    paramString = localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(paramString, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
    ((IApolloManagerService)paramString).getApolloPanelManager().b(paramBaseChatPie, localApolloInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloMessageUtils
 * JD-Core Version:    0.7.0.1
 */