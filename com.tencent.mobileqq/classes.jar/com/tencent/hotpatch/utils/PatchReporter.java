package com.tencent.hotpatch.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.MTAReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

public class PatchReporter
{
  private static SimpleDateFormat a = new SimpleDateFormat("yyyyMMddHH");
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    for (;;)
    {
      String str1;
      HashMap localHashMap;
      Object localObject;
      try
      {
        str1 = String.valueOf(paramInt);
        localHashMap = new HashMap();
        localHashMap.put("resultCode", str1);
        localHashMap.put("patchName", paramString3);
        if (!TextUtils.isEmpty(paramString1)) {
          break label511;
        }
        localObject = BaseApplicationImpl.sApplication.getFirstSimpleAccount();
        if (localObject == null) {
          break label511;
        }
        paramString1 = ((SimpleAccount)localObject).getUin();
        QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent curUin=" + paramString1 + ", event=" + paramString2 + ", result=" + paramInt + ", patchName=" + paramString3);
        if (paramInt % 100 != 0) {
          break label515;
        }
        bool = true;
        if (("actPatchConfig".equals(paramString2)) || ("actPatchDownload".equals(paramString2)) || ("actPatchResolve".equals(paramString2)) || ("actPatchUnzip".equals(paramString2)))
        {
          StatisticCollector.a(paramContext).a(paramString1, paramString2, bool, 0L, 0L, localHashMap, null);
          QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent " + paramString2);
          return;
        }
        paramString3 = paramString2 + paramString1 + paramString3;
        localObject = PatchSharedPreUtil.b(paramContext, paramString3);
        if ("actPatchCheck".equals(paramString2))
        {
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str1))) {
            break label514;
          }
          StatisticCollector.a(paramContext).a(paramString1, paramString2, bool, 0L, 0L, localHashMap, null);
          PatchSharedPreUtil.b(paramContext, paramString3, str1);
          QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent actPatchCheck");
          return;
        }
      }
      catch (Throwable paramContext)
      {
        QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent throwable=" + paramContext);
        return;
      }
      if ("actPatchInstall".equals(paramString2))
      {
        String str2 = a.format(new Date(System.currentTimeMillis()));
        str1 = str1 + str2.substring(0, 8) + Integer.parseInt(str2.substring(8)) / 8;
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(str1)))
        {
          StatisticCollector.a(paramContext).a(paramString1, paramString2, bool, 0L, 0L, localHashMap, null);
          try
          {
            localHashMap.put("uin", paramString1);
            localHashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
            paramString1 = new Properties();
            paramString1.putAll(localHashMap);
            MTAReportController.a(paramContext).reportKVEvent("actPatchInstall", paramString1);
            PatchSharedPreUtil.b(paramContext, paramString3, str1);
            QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent actPatchInstall");
            return;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              QLog.d("PatchLogTag", 1, "PatchReporter reportKVEvent actPatchInstall exception=" + paramString1);
            }
          }
          label511:
          continue;
        }
      }
      label514:
      return;
      label515:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.utils.PatchReporter
 * JD-Core Version:    0.7.0.1
 */