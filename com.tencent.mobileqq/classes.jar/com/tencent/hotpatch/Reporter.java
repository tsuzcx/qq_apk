package com.tencent.hotpatch;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.util.QQDeviceInfo;
import com.tencent.util.QQDeviceInfo.Entity;
import java.util.HashMap;

public class Reporter
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = QQDeviceInfo.getDeviceInfo("406d43");
    int i;
    if ((!TextUtils.isEmpty(((QQDeviceInfo.Entity)localObject).a)) && (((QQDeviceInfo.Entity)localObject).a.startsWith("66666"))) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = Build.FINGERPRINT.contains("generic/vbox86tp/");
    if ((i != 0) || (bool))
    {
      HashMap localHashMap = new HashMap();
      String str = "1";
      if (i != 0) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("imei_match", localObject);
      if (bool) {
        localObject = str;
      } else {
        localObject = "0";
      }
      localHashMap.put("finger_print_match", localObject);
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "game_assist_vbox_stat", true, 0L, 0L, localHashMap, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hotpatch.Reporter
 * JD-Core Version:    0.7.0.1
 */