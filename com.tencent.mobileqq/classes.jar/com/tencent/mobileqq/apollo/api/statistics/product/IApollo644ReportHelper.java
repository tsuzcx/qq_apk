package com.tencent.mobileqq.apollo.api.statistics.product;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/statistics/product/IApollo644ReportHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reportApolloRevAction", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "apollo", "Lcom/tencent/mobileqq/apollo/api/model/MessageForApollo;", "apolloManager", "Lcom/tencent/mobileqq/apollo/api/IApolloManagerService;", "reportApolloRevTroopMsg", "uMessageRecord", "Lcom/tencent/mobileqq/data/MessageRecord;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IApollo644ReportHelper
  extends QRouteApi
{
  public abstract void reportApolloRevAction(@NotNull QQAppInterface paramQQAppInterface, @NotNull MessageForApollo paramMessageForApollo, @NotNull IApolloManagerService paramIApolloManagerService);
  
  public abstract void reportApolloRevTroopMsg(@NotNull QQAppInterface paramQQAppInterface, @NotNull MessageRecord paramMessageRecord, @NotNull MessageForApollo paramMessageForApollo, @NotNull IApolloManagerService paramIApolloManagerService);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.statistics.product.IApollo644ReportHelper
 * JD-Core Version:    0.7.0.1
 */