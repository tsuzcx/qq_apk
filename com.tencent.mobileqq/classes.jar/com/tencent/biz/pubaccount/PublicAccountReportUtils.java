package com.tencent.biz.pubaccount;

import android.content.Intent;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import lbi;
import mqq.app.AppRuntime;

public class PublicAccountReportUtils
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, AccountDetail paramAccountDetail)
  {
    if ((paramQQAppInterface == null) && (paramAccountDetail == null)) {}
    Object localObject;
    do
    {
      return 1;
      localObject = paramAccountDetail;
      if (paramAccountDetail == null)
      {
        paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
        localObject = paramAccountDetail;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramString);
          localObject = paramQQAppInterface;
          if (QLog.isColorLevel())
          {
            QLog.d("PublicAccountReportUtils", 2, "getReportAccountType--> input accountdetail null");
            localObject = paramQQAppInterface;
          }
        }
      }
    } while (localObject == null);
    int i;
    if (((AccountDetail)localObject).accountFlag < 0)
    {
      i = -9;
      switch (i)
      {
      case -8: 
      case -7: 
      default: 
        i = 1;
      }
    }
    for (;;)
    {
      return i;
      i = PublicAccountUtil.a(((AccountDetail)localObject).accountFlag);
      break;
      i = 3;
      continue;
      i = 4;
      if (PublicAccountUtil.a(((AccountDetail)localObject).accountFlag2) == -8L)
      {
        i = 8;
        continue;
        i = 5;
        continue;
        i = 6;
        continue;
        i = 7;
        continue;
        i = 9;
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      try
      {
        String str = URLEncoder.encode(paramString, "UTF-8");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return paramString;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int i = a(paramQQAppInterface, String.valueOf(paramString), null);
    if ((i != 2) && (PublicAccountUtil.a(paramQQAppInterface, paramString) != -7)) {
      a(null, paramString, "0X800827B", "0X800827B", 0, 0, "" + paramInt, "" + i, "", "", false);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramString4 = a(paramString4);
    paramString5 = a(paramString5);
    paramString6 = a(paramString6);
    paramString7 = a(paramString7);
    ReportController.b(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", paramString1, paramString2.toUpperCase(), paramString3.toUpperCase(), paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
      return;
    }
    ReportController.b(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", paramString1, paramString2.toUpperCase(), paramString3.toUpperCase(), paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    paramString6 = a(paramString6);
    paramString7 = a(paramString7);
    paramString8 = a(paramString8);
    paramString9 = a(paramString9);
    ReportController.b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    ReportController.b(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", paramString3, paramString4.toUpperCase(), paramString5.toUpperCase(), paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
      return;
    }
    ReportController.b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    ReportController.b(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", paramString3, paramString4.toUpperCase(), paramString5.toUpperCase(), paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = "kandian_" + paramString1;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    HashMap localHashMap = new HashMap();
    localHashMap.put("department", "publicaccount");
    localHashMap.put("fromuin", str);
    localHashMap.put("touin", paramString2);
    localHashMap.put("d1", paramString3);
    localHashMap.put("d2", paramString4);
    localHashMap.put("d3", paramString5);
    localHashMap.put("d4", paramString6);
    StatisticCollector.a(BaseApplication.getContext()).a(str, paramString1, true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.d("reportPAinfoToLighthouse", 2, new Object[] { "reportPAinfoToLighthouse-->", "kandianT" + paramString1 + ", fromuin:" + str + ", touin:" + paramString2 + ", d1:" + paramString3 + ", d2:" + paramString4 + ", d3:" + paramString5 + ", d4:" + paramString6 });
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      c(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7, paramBoolean);
      return;
    }
    paramQQAppInterface = new Intent("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO");
    paramQQAppInterface.putExtra("VIDEO_REPORT_TOUIN", paramString1);
    paramQQAppInterface.putExtra("VIDEO_REPORT_SUBACTION", paramString2);
    paramQQAppInterface.putExtra("VIDEO_REPORT_ACTION_NAME", paramString3);
    paramQQAppInterface.putExtra("VIDEO_REPORT_FROM_TYPE", paramInt1);
    paramQQAppInterface.putExtra("VIDEO_REPORT_RESULT", paramInt2);
    paramQQAppInterface.putExtra("VIDEO_REPORT_R2", paramString4);
    paramQQAppInterface.putExtra("VIDEO_REPORT_R3", paramString5);
    paramQQAppInterface.putExtra("VIDEO_REPORT_R4", paramString6);
    paramQQAppInterface.putExtra("VIDEO_REPORT_R5", paramString7);
    paramQQAppInterface.putExtra("VIDEO_REPORT_SHOULD_ENCODE", paramBoolean);
    BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    ThreadManager.post(new lbi(paramString7, paramString1, paramQQAppInterface, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramBoolean), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountReportUtils
 * JD-Core Version:    0.7.0.1
 */