package com.qq.ac.sdk.d;

import android.text.TextUtils;
import com.b.a.j;
import com.qq.ac.sdk.g.b;
import com.tencent.acstat.StatConfig;
import com.tencent.acstat.StatServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.json.JSONArray;

public final class a
{
  private static volatile boolean a = false;
  private static volatile boolean b = false;
  
  public static void a()
  {
    if ((j.c() != null) && (!TextUtils.isEmpty(j.a())))
    {
      if (TextUtils.isEmpty(j.b())) {
        return;
      }
      if (!a)
      {
        StatConfig.setAppKey(j.c(), "AHA4U59MR8DD");
        StatConfig.setImei(j.c(), j.i());
        StatConfig.setDebugEnable(false);
        StatConfig.setAppVersion(com.qq.ac.sdk.g.a.d);
        StatConfig.setInstallChannel(j.c(), j.b());
        b.a("MtaReport", "initMTA");
        a = true;
      }
      if ((!TextUtils.isEmpty(j.f())) && (!b))
      {
        Properties localProperties = new Properties();
        localProperties.put("uin", j.f());
        localProperties.put("uin_type", j.g());
        localProperties.put("sex", j.h());
        StatServiceImpl.trackCustomKVEvent(j.c(), "OnComicBase", localProperties, null);
        b.a("MtaReport", "reportBaseInfo");
        b = true;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    a(paramString1, localArrayList);
  }
  
  public static void a(String paramString, List<String> paramList)
  {
    Properties localProperties = new Properties();
    localProperties.put("comic_id", paramString);
    localProperties.put("chapter_id", new JSONArray(paramList));
    StatServiceImpl.trackCustomKVEvent(j.c(), "OnReadingSDK", localProperties, null);
    paramString = new StringBuilder("OnReadingSDK");
    paramString.append(localProperties);
    b.a("MtaReport", paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.ac.sdk.d.a
 * JD-Core Version:    0.7.0.1
 */