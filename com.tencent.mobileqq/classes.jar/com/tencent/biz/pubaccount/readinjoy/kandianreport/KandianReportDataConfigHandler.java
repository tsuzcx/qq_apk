package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.text.TextUtils;
import bkwm;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import pbt;

public class KandianReportDataConfigHandler
  implements AladdinConfigHandler
{
  private static final String TAG = "kandianreport.KandianReportDataConfigHandler";
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("kandianreport.KandianReportDataConfigHandler", 2, "[onReceiveConfig] " + paramInt1 + " " + paramString);
    Map localMap = pbt.a(paramString);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)localMap.get(str1);
      QLog.d("kandianreport.KandianReportDataConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "kandian_feature_compute"))
      {
        if (TextUtils.equals(str2, "1")) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          bkwm.a("kandianreport_ON", Integer.valueOf(paramInt2));
          Aladdin.getConfig(paramInt1).update(paramString);
          break;
        }
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("kandianreport.KandianReportDataConfigHandler", 2, "wipeConfig: " + paramInt);
    bkwm.a("kandianreport_ON", Integer.valueOf(-1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.KandianReportDataConfigHandler
 * JD-Core Version:    0.7.0.1
 */