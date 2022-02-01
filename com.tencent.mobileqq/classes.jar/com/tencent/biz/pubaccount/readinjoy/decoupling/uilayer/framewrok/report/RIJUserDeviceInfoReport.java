package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class RIJUserDeviceInfoReport
{
  public static String a()
  {
    if (TextUtils.isEmpty(ReadInJoyUtils.a))
    {
      Object localObject2 = RIJAppSetting.b();
      String str = RIJAppSetting.c();
      if ((!((String)localObject2).equals("null")) && (!str.equals("null")))
      {
        ReadInJoyUtils.a = "0," + (String)localObject2 + "," + str;
        return ReadInJoyUtils.a;
      }
      Object localObject1 = localObject2;
      if (((String)localObject2).equals("null")) {
        localObject1 = "0";
      }
      localObject2 = str;
      if (str.equals("null")) {
        localObject2 = "0";
      }
      return "0," + (String)localObject1 + "," + (String)localObject2;
    }
    return ReadInJoyUtils.a;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramQQAppInterface.getAccount());
    localHashMap.put("param_cpu", String.valueOf(DeviceInfoUtil.b()));
    localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.a()));
    localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.e()));
    localHashMap.put("param_version", "8.5.5");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actUserDeviceInfoReport", true, 100L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJUserDeviceInfoReport
 * JD-Core Version:    0.7.0.1
 */