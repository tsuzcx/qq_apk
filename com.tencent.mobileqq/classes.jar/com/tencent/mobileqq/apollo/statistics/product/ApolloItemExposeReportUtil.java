package com.tencent.mobileqq.apollo.statistics.product;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/product/ApolloItemExposeReportUtil;", "", "()V", "TAG", "", "exposeMessage", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "addExposeMessage", "", "uinseq", "clear", "hasExpose", "", "report", "sessionInfo", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "message", "Lcom/tencent/mobileqq/apollo/api/model/MessageForApollo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloItemExposeReportUtil
{
  public static final ApolloItemExposeReportUtil a;
  private static ArrayList<Long> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloStatisticsProductApolloItemExposeReportUtil = new ApolloItemExposeReportUtil();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public final void a()
  {
    jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public final void a(long paramLong)
  {
    jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
  }
  
  public final void a(@NotNull SessionInfo paramSessionInfo, @NotNull MessageForApollo paramMessageForApollo)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramSessionInfo, "sessionInfo");
    Intrinsics.checkParameterIsNotNull(paramMessageForApollo, "message");
    if (a(paramMessageForApollo.uniseq))
    {
      if (paramMessageForApollo.is3dAction()) {}
      for (i = paramMessageForApollo.mApollo3DMessage.actionID_3D;; i = paramMessageForApollo.mApolloMessage.id)
      {
        QLog.d("ApolloItemExposeReportUtil", 3, i + " has expose return");
        return;
      }
    }
    a(paramMessageForApollo.uniseq);
    ApolloDtReportUtil.DtReportParamsBuilder localDtReportParamsBuilder = new ApolloDtReportUtil.DtReportParamsBuilder();
    if (paramMessageForApollo.is3dAction())
    {
      i = 1;
      localDtReportParamsBuilder = localDtReportParamsBuilder.a(i).b(ApolloDtReportUtil.a(paramSessionInfo.jdField_a_of_type_Int));
      if (!paramMessageForApollo.isNewAnimation()) {
        break label254;
      }
      i = 1;
      label131:
      localDtReportParamsBuilder = localDtReportParamsBuilder.c(i);
      if (!paramMessageForApollo.is3dAction()) {
        break label259;
      }
      i = paramMessageForApollo.mApollo3DMessage.actionID_3D;
      label154:
      localDtReportParamsBuilder = localDtReportParamsBuilder.c(String.valueOf(i));
      if (!paramMessageForApollo.isSend()) {
        break label270;
      }
      i = 0;
      label174:
      localDtReportParamsBuilder = localDtReportParamsBuilder.d(i);
      if (!paramMessageForApollo.isDoubleAction()) {
        break label275;
      }
      i = j;
      label192:
      paramSessionInfo = localDtReportParamsBuilder.e(ApolloDtReportUtil.a(i, paramMessageForApollo.actionType)).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (!paramMessageForApollo.is3dAction()) {
        break label280;
      }
    }
    label259:
    label270:
    label275:
    label280:
    for (int i = paramMessageForApollo.mApollo3DMessage.actionID_3D;; i = paramMessageForApollo.mApolloMessage.id)
    {
      ApolloDtReportUtil.a("aio_bubble", "apollo_msg", "expose", (Map)paramSessionInfo.g(i).a());
      return;
      i = 0;
      break;
      label254:
      i = 0;
      break label131;
      i = paramMessageForApollo.mApolloMessage.id;
      break label154;
      i = 1;
      break label174;
      i = 0;
      break label192;
    }
  }
  
  public final boolean a(long paramLong)
  {
    return jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloItemExposeReportUtil
 * JD-Core Version:    0.7.0.1
 */