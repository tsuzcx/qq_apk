package com.tencent.biz.pubaccount.readinjoy.view.proteus.utils;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusCDNUtils
{
  public static String a(String paramString)
  {
    return "sp_key_readinjoy_cdn_url_" + paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QLog.i("ProteusCDNUtils", 1, "[updateCDNUrl], bid = " + paramString1 + ", cdn url = " + paramString2);
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ReadInJoyHelper.a(a(paramString1), paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    QLog.i("ProteusCDNUtils", 1, "[checkUpdate], bid = " + paramString1 + ", retStr = " + paramString2 + ", retCode = " + paramInt);
    try
    {
      if (a(paramString2)) {
        b(paramString1);
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("ProteusCDNUtils", 1, "[checkUpdate], e = " + paramString1);
    }
  }
  
  private static boolean a(String paramString)
  {
    bool2 = false;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("ProteusCDNUtils", 1, "[shouldDownloadByCDN], retStr is null, no need download by CDN.");
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("data");
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.length() > 0)
        {
          paramString = paramString.optJSONObject(0);
          bool1 = bool2;
          if (paramString != null)
          {
            int i = paramString.optInt("code");
            if (i < 10)
            {
              bool1 = bool2;
              if (i > 0) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("ProteusCDNUtils", 1, "[shouldDownloadByCDN] parse json exception, e = " + paramString);
        bool1 = bool2;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("ProteusCDNUtils", 1, "[shouldDownloadByCDN], e = " + paramString);
        boolean bool1 = bool2;
      }
    }
    QLog.i("ProteusCDNUtils", 1, "[shouldDownloadByCDN], ret = " + bool1);
    return bool1;
  }
  
  private static String b(String paramString)
  {
    String str = (String)ReadInJoyHelper.a(a(paramString), "");
    QLog.i("ProteusCDNUtils", 1, "[getCDNUrl], bid = " + paramString + ", cdnUrl = " + str);
    return str;
  }
  
  private static void b(String paramString)
  {
    if (!b(paramString))
    {
      QLog.i("ProteusCDNUtils", 1, "[downloadByCDN], no need to download by cdn, bid = " + paramString);
      return;
    }
    String str1 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH_READINJOY_OFFLINE_TEMP_FOLDER + paramString + ".7z");
    String str2 = b(paramString);
    QLog.i("ProteusCDNUtils", 1, "[downloadByCDN], bid = " + paramString + ", localPath = " + str1 + ", cdnUrl = " + str2);
    ThreadManager.excute(new ProteusCDNUtils.1(str1, paramString, str2), 128, null, false);
    c("0X800ABFE", paramString);
  }
  
  private static boolean b(String paramString)
  {
    long l2 = 0L;
    Object localObject = b(paramString);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.equals("0", (CharSequence)localObject)))
    {
      QLog.i("ProteusCDNUtils", 1, "[isAbleToDownloadByCDN], cdn url is null or 0.");
      return false;
    }
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("/");
        if (localObject.length > 0)
        {
          localObject = Pattern.compile("\\d+").matcher(localObject[(localObject.length - 1)]);
          if (((Matcher)localObject).find())
          {
            localObject = ((Matcher)localObject).group();
            try
            {
              l1 = Long.valueOf((String)localObject).longValue();
              paramString = HtmlOffline.a(paramString);
              if (paramString != null) {
                l2 = paramString.optLong("version", 0L);
              }
              QLog.i("ProteusCDNUtils", 1, "[isAbleToDownloadByCDN], urlVersion = " + l1 + ", localVersion = " + l2);
              if (l1 <= l2) {
                break label216;
              }
              return true;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              QLog.e("ProteusCDNUtils", 1, "[isAbleToDownloadByCDN], e = " + localNumberFormatException);
            }
          }
        }
      }
      catch (Exception localException)
      {
        long l1;
        QLog.e("ProteusCDNUtils", 1, "[isAbleToDownloadByCDN], e = " + localException);
        continue;
      }
      l1 = 0L;
    }
    label216:
    return false;
  }
  
  private static void c(String paramString)
  {
    ThreadManager.excute(new ProteusCDNUtils.2(paramString), 64, null, false);
  }
  
  private static void c(String paramString1, String paramString2)
  {
    QLog.i("ProteusCDNUtils", 1, "[reportData], eventType = " + paramString1 + ", bid = " + paramString2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bid", paramString2);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString1, paramString1, 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        QLog.e("ProteusCDNUtils", 1, "[reportData], e = " + paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.ProteusCDNUtils
 * JD-Core Version:    0.7.0.1
 */