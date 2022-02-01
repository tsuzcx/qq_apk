package com.tencent.hippy.qq.module.tkd;

import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import pqp;

public class TKDSearchStatManager
{
  private static final String BEACON_COMMON_PARAM_QUA2 = "qua2";
  private static final String MTT_STAT_COMMON_EVENT = "MTT_STAT_COMMON_EVENT";
  private static final String MTT_STAT_COMMON_EVENT_S = "MTT_STAT_COMMON_EVENT_S";
  private static final String MTT_STAT_PROTOCOL = "MTT_STAT_PROTOCOL";
  private static final String MTT_STAT_PROTOCOL_RN = "MTT_STAT_PROTOCOL_RN";
  
  @NotNull
  private String getCommonEventDetail(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Set localSet = paramMap.keySet();
    Iterator localIterator = localSet.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!TextUtils.isEmpty(str))
      {
        int j = i + 1;
        localStringBuilder.append(str).append("=").append((String)paramMap.get(str));
        i = j;
        if (j < localSet.size())
        {
          localStringBuilder.append("&");
          i = j;
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static TKDSearchStatManager getInstance()
  {
    return TKDSearchStatManager.Holder.INSTANCE;
  }
  
  private boolean isBeaconEventParamInvalid(String paramString, Map<String, String> paramMap)
  {
    return (TextUtils.isEmpty(paramString)) || (paramMap == null) || (paramMap.isEmpty()) || (paramMap.keySet().isEmpty());
  }
  
  public void statBeaconCommonEvent(String paramString1, Map<String, String> paramMap, String paramString2, boolean paramBoolean)
  {
    if (isBeaconEventParamInvalid(paramString1, paramMap)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (!paramMap.containsKey("qua2")) {
      localHashMap.put("qua2", pqp.c());
    }
    localHashMap.put("event_name", paramString1);
    localHashMap.put("event_details", getCommonEventDetail(paramMap));
    localHashMap.put("event_url", paramString2);
    if (paramBoolean) {}
    for (paramString1 = "MTT_STAT_COMMON_EVENT_S";; paramString1 = "MTT_STAT_COMMON_EVENT")
    {
      statWithBeacon(paramString1, localHashMap, false);
      return;
    }
  }
  
  public void statWithBeacon(String paramString, Map<String, String> paramMap)
  {
    statWithBeacon(paramString, paramMap, false);
  }
  
  public void statWithBeacon(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    UserAction.onUserAction(paramString, true, -1L, -1L, paramMap, paramBoolean);
  }
  
  public void userBehaviorStat(String paramString)
  {
    userBehaviorStat(paramString, 1, null);
  }
  
  public void userBehaviorStat(String paramString1, int paramInt, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("protocal", paramString1 + "," + paramInt + ";");
    localHashMap.put("loginTime", System.currentTimeMillis() + "");
    if (TextUtils.isEmpty(paramString2))
    {
      UserAction.onUserAction("MTT_STAT_PROTOCOL", true, -1L, -1L, localHashMap, false);
      return;
    }
    localHashMap.put("rn_info", paramString2);
    UserAction.onUserAction("MTT_STAT_PROTOCOL_RN", true, -1L, -1L, localHashMap, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDSearchStatManager
 * JD-Core Version:    0.7.0.1
 */