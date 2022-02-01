package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.AppConf.ServiceProtocolSerializable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QQIdentiferUtil
{
  public static int a(String paramString)
  {
    int i = paramString.hashCode();
    int j = 6;
    switch (i)
    {
    default: 
      break;
    case 1764164264: 
      if (paramString.equals("deleteFace")) {
        i = 0;
      }
      break;
    case 1386901826: 
      if (paramString.equals("loginVerify")) {
        i = 3;
      }
      break;
    case 1095415352: 
      if (paramString.equals("studyModeIdentify")) {
        i = 6;
      }
      break;
    case 873317756: 
      if (paramString.equals("identifyNoLogin")) {
        i = 5;
      }
      break;
    case -80575799: 
      if (paramString.equals("changeSecureMobile")) {
        i = 1;
      }
      break;
    case -135762164: 
      if (paramString.equals("identify")) {
        i = 4;
      }
      break;
    case -1809423831: 
      if (paramString.equals("setFaceData")) {
        i = 2;
      }
      break;
    }
    i = -1;
    switch (i)
    {
    default: 
      return 101;
    case 6: 
      return 7;
    case 4: 
      return 5;
    case 3: 
      return 4;
    case 2: 
      return 3;
    case 1: 
      return 2;
    case 0: 
      j = 1;
    }
    return j;
  }
  
  public static void a(AppConf paramAppConf, String paramString)
  {
    if ((paramAppConf != null) && (!paramAppConf.serviceProtocols.isEmpty()))
    {
      paramAppConf = (AppConf.ServiceProtocolSerializable)paramAppConf.serviceProtocols.get(0);
      if ((!TextUtils.isEmpty(paramAppConf.name)) && (!TextUtils.isEmpty(paramAppConf.url)))
      {
        QLog.d("QQIdentiferUtil", 1, new Object[] { "report action=", paramString, ", auto save" });
        ReportController.b(null, "dc00898", "", "", paramString, paramString, 2, 0, "", "", "", "");
        return;
      }
      QLog.d("QQIdentiferUtil", 1, new Object[] { "report action=", paramString, ", sp.name || sp.url empty, not save" });
      ReportController.b(null, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
      return;
    }
    QLog.d("QQIdentiferUtil", 1, new Object[] { "report action=", paramString, ", appConf.serviceProtocols.isEmpty, not save" });
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferUtil
 * JD-Core Version:    0.7.0.1
 */