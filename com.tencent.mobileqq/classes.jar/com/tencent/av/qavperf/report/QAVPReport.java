package com.tencent.av.qavperf.report;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.qavperf.QAVPLogger;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QAVPReport
{
  private static final HashMap<String, String> a = new HashMap();
  private static final ExecutorService b = Executors.newSingleThreadExecutor();
  private static int c = 0;
  private static int d = 0;
  
  private static Map<String, String> a(SessionInfo paramSessionInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", b(paramSessionInfo));
    return localHashMap;
  }
  
  private static Map<String, String> a(VideoAppInterface paramVideoAppInterface, SessionInfo paramSessionInfo)
  {
    paramSessionInfo = new HashMap();
    if (paramVideoAppInterface.d(2))
    {
      if (((EffectPendantTools)paramVideoAppInterface.c(2)).c() != null) {
        paramSessionInfo.put("open_widgets", String.valueOf(1));
      } else {
        paramSessionInfo.put("open_widgets", String.valueOf(0));
      }
    }
    else {
      paramSessionInfo.put("open_widgets", String.valueOf(0));
    }
    if (paramVideoAppInterface.d(1))
    {
      EffectFilterTools localEffectFilterTools = (EffectFilterTools)paramVideoAppInterface.c(1);
      if ((localEffectFilterTools.c() != null) && (((FilterItem)localEffectFilterTools.c()).getFiltertype() != 0)) {
        paramSessionInfo.put("open_filter", String.valueOf(1));
      } else {
        paramSessionInfo.put("open_filter", String.valueOf(0));
      }
    }
    else
    {
      paramSessionInfo.put("open_filter", String.valueOf(0));
    }
    if (paramVideoAppInterface.d(16))
    {
      if (((EffectAvatar2dManager)paramVideoAppInterface.c(16)).c() != null)
      {
        paramSessionInfo.put("open_virtual_avatar", String.valueOf(1));
        return paramSessionInfo;
      }
      paramSessionInfo.put("open_virtual_avatar", String.valueOf(0));
      return paramSessionInfo;
    }
    paramSessionInfo.put("open_virtual_avatar", String.valueOf(0));
    return paramSessionInfo;
  }
  
  private static void a()
  {
    a.clear();
    c = 0;
    d = 0;
  }
  
  private static void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 17)
    {
      if (paramInt1 != 34) {
        return;
      }
      d = paramInt2;
      return;
    }
    c = paramInt2;
  }
  
  public static void a(SessionInfo paramSessionInfo, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    a(paramInt1, paramInt2);
    if ((paramMap != null) && (paramMap.size() > 0)) {
      a.putAll(paramMap);
    }
    if (d != 0)
    {
      if (c == 0) {
        return;
      }
      if (a.size() <= 0)
      {
        a();
        QAVPLogger.a("Empty Data , No-Report");
        return;
      }
      a.putAll(a(paramSessionInfo));
      paramSessionInfo = a.keySet().iterator();
      while (paramSessionInfo.hasNext())
      {
        paramMap = (String)paramSessionInfo.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("market-key:");
        localStringBuilder.append(paramMap);
        localStringBuilder.append(", market-value:");
        localStringBuilder.append((String)a.get(paramMap));
        QAVPLogger.a(localStringBuilder.toString());
      }
      QAVPLogger.a("----- ----- ----- -----");
      QQBeaconReport.a("0AND0U1I7C4PAMM0", "", "market_data", true, a, true);
      a();
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, SessionInfo paramSessionInfo, Map<String, String> paramMap)
  {
    paramMap.putAll(a(paramSessionInfo));
    paramMap.putAll(a(paramVideoAppInterface, paramSessionInfo));
    paramVideoAppInterface = paramMap.keySet().iterator();
    while (paramVideoAppInterface.hasNext())
    {
      paramSessionInfo = (String)paramVideoAppInterface.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sample-key:");
      localStringBuilder.append(paramSessionInfo);
      localStringBuilder.append(", sample-value:");
      localStringBuilder.append((String)paramMap.get(paramSessionInfo));
      QAVPLogger.a(localStringBuilder.toString());
    }
    QAVPLogger.a("----- ----- ----- -----");
    QQBeaconReport.a("0AND0U1I7C4PAMM0", "", "sample_data", true, paramMap, true);
  }
  
  public static void a(Runnable paramRunnable)
  {
    b.execute(paramRunnable);
  }
  
  private static String b(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return "unknown";
    }
    if (paramSessionInfo.aK) {
      return "audio";
    }
    if (paramSessionInfo.H)
    {
      if (paramSessionInfo.I) {
        return "video";
      }
      return "local_video_only";
    }
    if (paramSessionInfo.I) {
      return "remote_video_only";
    }
    return "audio";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qavperf.report.QAVPReport
 * JD-Core Version:    0.7.0.1
 */