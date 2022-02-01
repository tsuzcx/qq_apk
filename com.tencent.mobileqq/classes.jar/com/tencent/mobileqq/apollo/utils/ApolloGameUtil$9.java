package com.tencent.mobileqq.apollo.utils;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.impl.listener.ApolloInitCallback;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class ApolloGameUtil$9
  implements ApolloInitCallback
{
  ApolloGameUtil$9(Context paramContext, AppInterface paramAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong) {}
  
  public void a()
  {
    ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentContext, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
    localHashMap.put("param_src", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
    StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "cmgame_data_init_duration", true, l, 0L, localHashMap, "", false);
    QLog.d("CmGameStat", 1, new Object[] { "cmgame_data_init_duration=", Long.valueOf(l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.9
 * JD-Core Version:    0.7.0.1
 */