package com.tencent.mobileqq.apollo.api.statistics.product.impl;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.statistics.product.IApollo644ReportHelper;
import com.tencent.mobileqq.apollo.statistics.product.Apollo644ReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/statistics/product/impl/Apollo644ReportHelperImpl;", "Lcom/tencent/mobileqq/apollo/api/statistics/product/IApollo644ReportHelper;", "()V", "reportApolloRevAction", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "apollo", "Lcom/tencent/mobileqq/apollo/api/model/MessageForApollo;", "apolloManager", "Lcom/tencent/mobileqq/apollo/api/IApolloManagerService;", "reportApolloRevTroopMsg", "uMessageRecord", "Lcom/tencent/mobileqq/data/MessageRecord;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class Apollo644ReportHelperImpl
  implements IApollo644ReportHelper
{
  public void reportApolloRevAction(@NotNull QQAppInterface paramQQAppInterface, @NotNull MessageForApollo paramMessageForApollo, @NotNull IApolloManagerService paramIApolloManagerService)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramMessageForApollo, "apollo");
    Intrinsics.checkParameterIsNotNull(paramIApolloManagerService, "apolloManager");
    Apollo644ReportUtil.a(paramQQAppInterface, paramMessageForApollo, paramIApolloManagerService);
  }
  
  public void reportApolloRevTroopMsg(@NotNull QQAppInterface paramQQAppInterface, @NotNull MessageRecord paramMessageRecord, @NotNull MessageForApollo paramMessageForApollo, @NotNull IApolloManagerService paramIApolloManagerService)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "uMessageRecord");
    Intrinsics.checkParameterIsNotNull(paramMessageForApollo, "apollo");
    Intrinsics.checkParameterIsNotNull(paramIApolloManagerService, "apolloManager");
    Apollo644ReportUtil.a(paramQQAppInterface, paramMessageRecord, paramMessageForApollo, paramIApolloManagerService);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.statistics.product.impl.Apollo644ReportHelperImpl
 * JD-Core Version:    0.7.0.1
 */