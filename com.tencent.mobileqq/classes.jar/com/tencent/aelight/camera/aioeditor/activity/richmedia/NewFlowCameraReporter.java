package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.GapDataCollector;
import com.tencent.mobileqq.camera.adapter.DeviceInstance;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class NewFlowCameraReporter
{
  public static long a = 0L;
  public static long b = 0L;
  public static String c = "";
  public static Map<String, GapDataCollector> d = new ConcurrentHashMap();
  public static String e = ".photo";
  public static String f = ".openCamera";
  public static boolean g = true;
  public static boolean h = true;
  public static long i = 0L;
  private static long j = 0L;
  private static long k = 0L;
  
  public static void a()
  {
    a("custom photo send", "sv_custom_photo_send", null);
  }
  
  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("start_intent_time", a);
  }
  
  public static void a(String paramString)
  {
    a(paramString, a);
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      String str = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(";");
      localStringBuilder.append(l - paramLong);
      QLog.d(str, 2, localStringBuilder.toString());
      a = l;
    }
  }
  
  private static void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (QLog.isColorLevel())) {
      QLog.d("open_custom_camera", 2, paramString1);
    }
    paramString1 = paramHashMap;
    if (paramHashMap == null) {
      paramString1 = new HashMap();
    }
    paramString1.put("MANUFACTURER", Build.MANUFACTURER);
    paramString1.put("MODEL", Build.MODEL);
    paramString1.put("DEVICE_TYPE_NAME", DeviceInstance.a().b());
    a(paramString1, "open_custom_camera", paramString2);
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, paramString2, true, 0L, 0L, paramString1, null);
  }
  
  private static void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = new StringBuilder();
    paramMap.append("事件Code : ");
    paramMap.append(paramString2);
    paramMap.append("   上报内容 ----------  \n");
    for (paramMap = paramMap.toString(); localIterator.hasNext(); paramMap = paramString2.toString())
    {
      paramString2 = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMap);
      localStringBuilder.append((String)paramString2.getKey());
      paramMap = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMap);
      localStringBuilder.append("   :   ");
      paramMap = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMap);
      localStringBuilder.append((String)paramString2.getValue());
      paramMap = localStringBuilder.toString();
      paramString2 = new StringBuilder();
      paramString2.append(paramMap);
      paramString2.append("\n");
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramMap);
    }
  }
  
  public static long b(Intent paramIntent)
  {
    return paramIntent.getLongExtra("start_intent_time", 0L);
  }
  
  public static void b()
  {
    a("capture photo send", "sv_capture_photo_send", null);
  }
  
  public static void c()
  {
    a("system photo send", "sv_system_photo_send", null);
  }
  
  public static void d()
  {
    a("photo taken by custom", "sv_photo_taken_by_custom", null);
  }
  
  public static void e()
  {
    a("photo taken by capture", "sv_photo_taken_by_capture", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.NewFlowCameraReporter
 * JD-Core Version:    0.7.0.1
 */