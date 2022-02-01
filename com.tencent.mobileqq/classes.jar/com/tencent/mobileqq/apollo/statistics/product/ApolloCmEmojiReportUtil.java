package com.tencent.mobileqq.apollo.statistics.product;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/product/ApolloCmEmojiReportUtil;", "", "()V", "needReport", "", "report", "", "baseChatPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "setNeedReport", "need", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloCmEmojiReportUtil
{
  public static final ApolloCmEmojiReportUtil a;
  private static boolean a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloStatisticsProductApolloCmEmojiReportUtil = new ApolloCmEmojiReportUtil();
  }
  
  public final void a(@Nullable BaseChatPie paramBaseChatPie)
  {
    jdField_a_of_type_Boolean = false;
    if (paramBaseChatPie != null)
    {
      ApolloDtReportUtil.DtReportParamsBuilder localDtReportParamsBuilder = new ApolloDtReportUtil.DtReportParamsBuilder();
      QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "baseChatPie.app");
      localDtReportParamsBuilder = localDtReportParamsBuilder.a(ApolloDtReportUtil.a(localQQAppInterface)).b(ApolloDtReportUtil.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
      localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "baseChatPie.app");
      ApolloDtReportUtil.a("aio", "cm_emoji", "expose", (Map)localDtReportParamsBuilder.f(ApolloDtReportUtil.b(localQQAppInterface)).b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloCmEmojiReportUtil
 * JD-Core Version:    0.7.0.1
 */