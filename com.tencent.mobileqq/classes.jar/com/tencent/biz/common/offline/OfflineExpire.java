package com.tencent.biz.common.offline;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineExpire
{
  public static int a = 3;
  public static String a = "OfflineExpire";
  public static boolean a = false;
  private static int b;
  
  protected static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseExpire:");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      int j = paramString.length();
      while (i < j)
      {
        localObject = paramString.optJSONObject(i);
        if (localObject != null)
        {
          int k = ((JSONObject)localObject).optInt("bid");
          if (k > 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(k);
            ((StringBuilder)localObject).append("");
            localObject = OfflineEnvHelper.a(((StringBuilder)localObject).toString());
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(k);
              localObject = localStringBuilder.toString();
              if (new File((String)localObject).exists()) {
                Util.a((String)localObject);
              }
            }
          }
        }
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel())
      {
        localObject = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseExpire: ");
        localStringBuilder.append(QLog.getStackTraceString(paramString));
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  protected static void a(String paramString, AppRuntime paramAppRuntime, Context paramContext, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      paramContext = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parsePreDown:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i(paramContext, 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt == 1) {
      paramInt = 300000;
    } else {
      paramInt = 0;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("data");
      b = 0;
      paramContext = new WeakReference(paramAppRuntime);
      localObject1 = new ArrayList();
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramString.optJSONObject(i);
        if (localObject2 != null)
        {
          int k = ((JSONObject)localObject2).optInt("code");
          if ((k > 0) && (k < 10))
          {
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((JSONObject)localObject2).optInt("bid"));
            ((StringBuilder)localObject3).append("");
            String str1 = ((StringBuilder)localObject3).toString();
            String str2 = ((JSONObject)localObject2).optString("url");
            int m = ((JSONObject)localObject2).optInt("filesize", 0);
            localObject3 = new BidDownloader(str1, paramAppRuntime, new OfflineExpire.1(paramContext, str2, m, str1), true, k);
            ((BidDownloader)localObject3).d = ((JSONObject)localObject2).optInt("id");
            JSONObject localJSONObject = HtmlOffline.a(str1);
            if ((localJSONObject == null) || (localJSONObject.optInt("version", 0) < ((BidDownloader)localObject3).d))
            {
              boolean bool;
              if (((JSONObject)localObject2).optInt("network", 0) == 1) {
                bool = true;
              } else {
                bool = false;
              }
              ((BidDownloader)localObject3).f = bool;
              b += 1;
              ((BidDownloader)localObject3).jdField_c_of_type_JavaLangString = str2;
              ((BidDownloader)localObject3).jdField_c_of_type_Int = m;
              ((BidDownloader)localObject3).a = true;
              if ((paramAppRuntime instanceof BaseQQAppInterface))
              {
                localObject2 = new OfflineExpire.OfflinePreDownloadTask((BaseQQAppInterface)paramAppRuntime, str1, (BidDownloader)localObject3);
                if (((BidDownloader)localObject3).f) {
                  ((ArrayList)localObject1).add(localObject2);
                } else {
                  ((ArrayList)localObject1).add(0, localObject2);
                }
              }
            }
          }
        }
        i += 1;
      }
      ThreadManager.getSubThreadHandler().postDelayed(new OfflineExpire.2(paramContext, (ArrayList)localObject1), paramInt);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramAppRuntime = a;
        paramContext = new StringBuilder();
        paramContext.append("parsePreDown: ");
        paramContext.append(QLog.getStackTraceString(paramString));
        QLog.i(paramAppRuntime, 2, paramContext.toString());
      }
    }
  }
  
  private static String b(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.tmdownloader.exit");
    localStringBuilder.append(((Time)localObject).year);
    localStringBuilder.append(((Time)localObject).month + 1);
    localStringBuilder.append(((Time)localObject).monthDay);
    localStringBuilder.append(((Time)localObject).hour);
    if (paramBoolean) {
      localStringBuilder.append(((Time)localObject).minute - 1);
    } else {
      localStringBuilder.append(((Time)localObject).minute);
    }
    if (paramArrayList == null) {
      paramArrayList = "null";
    } else {
      paramArrayList = paramArrayList.toString();
    }
    localStringBuilder.append(paramArrayList);
    paramArrayList = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramArrayList);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return MD5.toMD5(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire
 * JD-Core Version:    0.7.0.1
 */