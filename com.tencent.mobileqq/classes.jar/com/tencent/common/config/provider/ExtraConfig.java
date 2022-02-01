package com.tencent.common.config.provider;

import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExtraConfig
{
  public static String a = "EXTRA_DATAV1";
  private static Map<String, String> a;
  static String b = "wns_share_data";
  private static String c = "com.tencent.common.config.provider.ExtraConfig";
  
  public static int a()
  {
    int j = 0;
    try
    {
      Map localMap = QZConfigProviderUtil.a();
      if (localMap == null) {
        return 0;
      }
      Object localObject;
      if (NetworkState.isWifiConn()) {
        localObject = WiFiDash.getBSSID();
      } else {
        localObject = NetworkState.getAPN();
      }
      int i = j;
      if (localObject != null)
      {
        localObject = (String)localMap.get(localObject);
        if (localObject == null) {
          return 0;
        }
        localObject = ((String)localObject).split(":");
        i = j;
        if (localObject != null)
        {
          i = j;
          if (localObject.length > 0) {
            i = Integer.valueOf(localObject[0]).intValue();
          }
        }
      }
      return i;
    }
    catch (Exception localException)
    {
      QLog.e(c, 2, "read wifi operator by bssid fail", localException);
    }
    return 0;
  }
  
  public static void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    String str;
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 8) {
            str = "";
          } else {
            str = "1";
          }
        }
        else {
          str = "2";
        }
      }
      else {
        str = "0";
      }
    }
    else {
      str = "3";
    }
    if (!TextUtils.isEmpty(str)) {
      a(str);
    }
  }
  
  public static void a(String paramString)
  {
    String str;
    Object localObject;
    if (NetworkState.isWifiConn())
    {
      str = WiFiDash.getBSSID();
      if (str != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        a(str, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("save bssid=");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(",value=");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("QzoneIPStracyConfig", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      str = NetworkState.getAPN();
      if (str != null)
      {
        localObject = str.toLowerCase();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(":");
        localStringBuilder.append(System.currentTimeMillis());
        a((String)localObject, localStringBuilder.toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("save apn=");
        ((StringBuilder)localObject).append(str.toLowerCase());
        ((StringBuilder)localObject).append(",value=");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("QzoneIPStracyConfig", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a = QZConfigProviderUtil.a();
    Map localMap = a;
    if (localMap != null)
    {
      localMap.put(paramString1, paramString2);
    }
    else
    {
      a = new HashMap();
      a.put(paramString1, paramString2);
    }
    a(a);
    QZConfigProviderUtil.a(a);
  }
  
  private static void a(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (true == paramMap.isEmpty()) {
        return;
      }
      if (BaseApplication.getContext() != null)
      {
        long l = QZConfigProviderUtil.a();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("last_check_time:");
        ((StringBuilder)localObject).append(l);
        QLog.d("ConfigProvider", 2, ((StringBuilder)localObject).toString());
        if (System.currentTimeMillis() - l > 86400000L)
        {
          localObject = new ArrayList();
          Iterator localIterator = paramMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            String[] arrayOfString = ((String)paramMap.get(str)).split(":");
            if ((arrayOfString != null) && (arrayOfString.length >= 2) && (System.currentTimeMillis() - Long.parseLong(arrayOfString[1]) > 2592000000L)) {
              ((List)localObject).add(str);
            }
          }
          localIterator = ((List)localObject).iterator();
          while (localIterator.hasNext()) {
            paramMap.remove((String)localIterator.next());
          }
          ((List)localObject).clear();
          paramMap = new StringBuilder();
          paramMap.append(" last_check_time:");
          paramMap.append(System.currentTimeMillis());
          QLog.e("ConfigProvider", 2, paramMap.toString());
          QZConfigProviderUtil.a(System.currentTimeMillis());
        }
      }
    }
  }
  
  public static boolean a(Map<String, byte[]> paramMap, boolean paramBoolean)
  {
    if (paramMap == null) {
      return false;
    }
    Object localObject1 = paramMap.keySet();
    Iterator localIterator = ((Set)localObject1).iterator();
    boolean bool2;
    for (boolean bool1 = false; localIterator.hasNext(); bool1 = bool2)
    {
      Object localObject3 = (String)localIterator.next();
      bool2 = bool1;
      Object localObject2 = localObject1;
      if (localObject3 != null)
      {
        bool2 = bool1;
        localObject2 = localObject1;
        if (((String)localObject3).equals("ExtraConfig"))
        {
          localObject2 = (byte[])paramMap.get(localObject3);
          localObject3 = new UniAttribute();
          ((UniAttribute)localObject3).decode((byte[])localObject2);
          Object localObject4 = ((UniAttribute)localObject3).getKeySet();
          bool2 = bool1;
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject4 = ((Set)localObject4).iterator();
            for (;;)
            {
              bool2 = bool1;
              localObject2 = localObject1;
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              Object localObject5 = (String)((Iterator)localObject4).next();
              localObject2 = (String)((UniAttribute)localObject3).get((String)localObject5);
              if ((localObject5 != null) && (((String)localObject5).equals("WifiCarrierType")) && (localObject2 != null))
              {
                Object localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append((String)localObject5);
                ((StringBuilder)localObject6).append("=");
                ((StringBuilder)localObject6).append((String)localObject2);
                QLog.d("QzoneIPStracyConfig", 2, ((StringBuilder)localObject6).toString());
                try
                {
                  if (Integer.valueOf((String)localObject2).intValue() < 0)
                  {
                    localObject5 = new StringBuilder();
                    ((StringBuilder)localObject5).append("receive WiFiOperator error,value=");
                    ((StringBuilder)localObject5).append((String)localObject2);
                    QLog.i("ConfigProvider", 2, ((StringBuilder)localObject5).toString());
                    bool1 = true;
                  }
                  else
                  {
                    if (NetworkState.isWifiConn())
                    {
                      if (!paramBoolean) {
                        WiFiDash.updateBSSID();
                      }
                      localObject5 = WiFiDash.getBSSID();
                      if (localObject5 != null)
                      {
                        localObject6 = new StringBuilder();
                        ((StringBuilder)localObject6).append((String)localObject2);
                        ((StringBuilder)localObject6).append(":");
                        ((StringBuilder)localObject6).append(System.currentTimeMillis());
                        a((String)localObject5, ((StringBuilder)localObject6).toString());
                        localObject6 = new StringBuilder();
                        ((StringBuilder)localObject6).append("save bssid=");
                        ((StringBuilder)localObject6).append((String)localObject5);
                        ((StringBuilder)localObject6).append(",value=");
                        ((StringBuilder)localObject6).append((String)localObject2);
                        ((StringBuilder)localObject6).append(":");
                        ((StringBuilder)localObject6).append(System.currentTimeMillis());
                        QLog.d("QzoneIPStracyConfig", 2, ((StringBuilder)localObject6).toString());
                      }
                    }
                    else
                    {
                      if (!paramBoolean) {
                        NetworkState.isNetSupport();
                      }
                      localObject5 = NetworkState.getAPN();
                      if (localObject5 != null)
                      {
                        localObject6 = ((String)localObject5).toLowerCase();
                        StringBuilder localStringBuilder = new StringBuilder();
                        localStringBuilder.append((String)localObject2);
                        localStringBuilder.append(":");
                        localStringBuilder.append(System.currentTimeMillis());
                        a((String)localObject6, localStringBuilder.toString());
                        localObject6 = new StringBuilder();
                        ((StringBuilder)localObject6).append("save apn=");
                        ((StringBuilder)localObject6).append(((String)localObject5).toLowerCase());
                        ((StringBuilder)localObject6).append(",value=");
                        ((StringBuilder)localObject6).append((String)localObject2);
                        ((StringBuilder)localObject6).append(":");
                        ((StringBuilder)localObject6).append(System.currentTimeMillis());
                        QLog.d("QzoneIPStracyConfig", 2, ((StringBuilder)localObject6).toString());
                      }
                    }
                    bool1 = false;
                  }
                }
                catch (Exception localException)
                {
                  localObject6 = new StringBuilder();
                  ((StringBuilder)localObject6).append("receive WiFiOperator error,value=");
                  ((StringBuilder)localObject6).append((String)localObject2);
                  QLog.i("ConfigProvider", 2, ((StringBuilder)localObject6).toString(), localException);
                  bool1 = true;
                }
              }
            }
          }
        }
      }
      localObject1 = localObject2;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.config.provider.ExtraConfig
 * JD-Core Version:    0.7.0.1
 */