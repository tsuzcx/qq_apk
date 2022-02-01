package com.tencent.mobileqq.app.message;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MessageStatisticHelper
{
  private static List<MessageStatisticHelper.DelayMsgReportItem> jdField_a_of_type_JavaUtilList = new ArrayList(32);
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MessageStatisticHelper.DelayMsgReportItem localDelayMsgReportItem = (MessageStatisticHelper.DelayMsgReportItem)localIterator.next();
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", String.valueOf(localDelayMsgReportItem.jdField_a_of_type_Int));
        localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        localHashMap.put("msgType", String.valueOf(localDelayMsgReportItem.b));
        localHashMap.put("uinType", String.valueOf(localDelayMsgReportItem.c));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(localDelayMsgReportItem.jdField_a_of_type_JavaLangString, "actBelatedMsg", false, localDelayMsgReportItem.jdField_a_of_type_Long, 0L, localHashMap, "");
      }
      MessageStatisticHelper.DelayMsgReportItem.a(jdField_a_of_type_JavaUtilList);
      jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (!paramQQAppInterface.getCurrentUin().endsWith("7")) {
      return;
    }
    paramQQAppInterface = new HashMap();
    paramQQAppInterface.put(BaseConstants.RDM_NoChangeFailCode, "");
    paramQQAppInterface.put("uinType", String.valueOf(paramInt));
    paramQQAppInterface.put("convUin", String.valueOf(paramString));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actNoCachedLastMsg", true, 0L, 0L, paramQQAppInterface, "");
  }
  
  public static void a(MessageRecord arg0, AppInterface paramAppInterface)
  {
    if (!paramAppInterface.getCurrentUin().endsWith("77")) {
      return;
    }
    long l = NetConnInfoCenter.getServerTime() - ???.time;
    if (l < 30L) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
    if ((localQQAppInterface.mLoginTime != 0L) && (???.time < localQQAppInterface.mLoginTime)) {
      return;
    }
    int i;
    if (???.time < localQQAppInterface.mRegisterPushTime) {
      i = 1;
    } else {
      i = 2;
    }
    paramAppInterface = MessageStatisticHelper.DelayMsgReportItem.a(i, paramAppInterface.getCurrentUin(), l, ???.msgtype, ???.istroop);
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      jdField_a_of_type_JavaUtilList.add(paramAppInterface);
      if (jdField_a_of_type_JavaUtilList.size() >= 32) {
        a();
      }
      return;
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (Math.abs(jdField_a_of_type_JavaUtilRandom.nextInt() % 10000) < 10)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, true, paramLong, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MessageStatisticHelper
 * JD-Core Version:    0.7.0.1
 */