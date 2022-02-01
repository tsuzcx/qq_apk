package com.tencent.biz.qqcircle;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class QCircleJsUrlConfig
{
  public static final String a = ;
  public static final HashSet<String> b = new HashSet();
  
  static
  {
    b.add("_wwv");
    b.add("_proxy");
    b.add("_wv");
  }
  
  public static String a(List<FeedCloudCommon.Entry> paramList, String paramString)
  {
    return QCirclePluginUtil.a(paramList, paramString, "");
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      URI localURI = new URI(paramString);
      String str = localURI.getHost();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" domain:");
      localStringBuilder.append(str);
      QLog.d("QCircleJsUrlConfig", 1, localStringBuilder.toString());
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (str.endsWith(".qq.com"))
        {
          boolean bool3 = localURI.getScheme().equals("https");
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static HashMap<String, String> b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = Uri.parse(paramString);
        if (paramString != null)
        {
          HashMap localHashMap = new HashMap();
          Iterator localIterator = paramString.getQueryParameterNames().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localHashMap.put(str, paramString.getQueryParameter(str));
          }
          return localHashMap;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleJsUrlConfig
 * JD-Core Version:    0.7.0.1
 */