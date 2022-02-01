package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QQNotifyHelper
{
  public static String a(int paramInt)
  {
    String str = HardCodeUtil.a(2131717256);
    if (paramInt == 1) {
      str = HardCodeUtil.a(2131717257);
    }
    return str;
  }
  
  public static String a(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg == null) {
      return null;
    }
    if (paramAcsMsg.type == 0) {
      return paramAcsMsg.msg_id;
    }
    return paramAcsMsg.msg_id + "-" + paramAcsMsg.sub_time;
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    String str = HardCodeUtil.a(2131717337);
    if ((paramInt1 == 0) || (paramInt1 == 6)) {
      str = a(paramInt2);
    }
    for (;;)
    {
      QQToast.a(paramContext, 2, str, 0).a();
      return;
      if (paramInt1 == -1) {
        str = HardCodeUtil.a(2131717337);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyHelper", 1, "doReport app is null");
      }
      return;
    }
    HashMap localHashMap = new HashMap(12);
    localHashMap.put("time_stamp", String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    localHashMap.put("bussiness_id", paramString2);
    localHashMap.put("remind_id", paramString3);
    localHashMap.put("uin", paramAppInterface.getCurrentAccountUin());
    if (paramString4 != null) {
      localHashMap.put("flag1", paramString4);
    }
    if (paramString5 != null) {
      localHashMap.put("flag2", paramString5);
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", paramString1, true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifyHelper
 * JD-Core Version:    0.7.0.1
 */