package com.tencent.ilivesdk.qualityreportservice;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceAdapter;
import com.tencent.ilivesdk.qualityreportservice_interface.VideoRateQualityInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VideoRateQualityService
  implements VideoRateQualityInterface
{
  private static final String REPORT_URL = "https://h.trace.qq.com/kv?attaid=04a00034451&token=5388276298";
  private static final String TAG = "VideoRateQualityService";
  private QualityReportServiceAdapter mAdapter;
  private HttpInterface mHttp;
  
  public VideoRateQualityService(QualityReportServiceAdapter paramQualityReportServiceAdapter)
  {
    this.mAdapter = paramQualityReportServiceAdapter;
    if (this.mAdapter != null) {
      this.mHttp = this.mAdapter.getHttpInterface();
    }
  }
  
  private void doSend(Map<String, String> paramMap)
  {
    send(getUrl(paramMap));
  }
  
  private String getUrl(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://h.trace.qq.com/kv?attaid=04a00034451&token=5388276298");
    localStringBuilder.append("&");
    localStringBuilder.append("_dc=");
    localStringBuilder.append(Math.random());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append("&");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
    }
    paramMap = localStringBuilder.toString();
    Log.d("VideoRateQualityService", "url=" + paramMap);
    return paramMap;
  }
  
  private Map<String, String> putCommonParam(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("s_room_id", "" + paramLong1);
    localHashMap.put("s_anchor_uid", "" + paramLong2);
    localHashMap.put("s_uid", "" + paramLong3);
    return localHashMap;
  }
  
  private void send(String paramString)
  {
    if ((this.mHttp != null) && (!TextUtils.isEmpty(paramString)))
    {
      Log.d("VideoRateQualityService", "send " + paramString);
      this.mHttp.get(paramString, new VideoRateQualityService.1(this));
    }
  }
  
  public void anchorAutoSwitchHigh(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("s_act_type", "8");
    localHashMap.put("act_desc", "anchorAutoSwitchHigh");
    localHashMap.putAll(putCommonParam(paramLong1, paramLong2, paramLong3));
    doSend(localHashMap);
  }
  
  public void anchorCaton(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("s_act_type", "1");
    localHashMap.put("act_desc", "anchorCaton");
    localHashMap.putAll(putCommonParam(paramLong1, paramLong2, paramLong3));
    doSend(localHashMap);
  }
  
  public void anchorNetDetectHigher(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("s_act_type", "3");
    localHashMap.put("act_desc", "anchorNetDetectHigher");
    localHashMap.putAll(putCommonParam(paramLong1, paramLong2, paramLong3));
    doSend(localHashMap);
  }
  
  public void anchorNetDetectLower(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("s_act_type", "5");
    localHashMap.put("act_desc", "anchorNetDetectLower");
    localHashMap.putAll(putCommonParam(paramLong1, paramLong2, paramLong3));
    doSend(localHashMap);
  }
  
  public void anchorStartNetDetect(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("s_act_type", "2");
    localHashMap.put("act_desc", "anchorStartNetDetect");
    localHashMap.putAll(putCommonParam(paramLong1, paramLong2, paramLong3));
    doSend(localHashMap);
  }
  
  public void anchorSwitchLevel(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("s_act_type", "6");
    localHashMap.put("act_desc", "anchorSwitchLevel");
    localHashMap.putAll(putCommonParam(paramLong1, paramLong2, paramLong3));
    doSend(localHashMap);
  }
  
  public void audCaton(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("s_act_type", "9");
    localHashMap.put("act_desc", "audCaton");
    localHashMap.putAll(putCommonParam(paramLong1, paramLong2, paramLong3));
    doSend(localHashMap);
  }
  
  public void audNetDetectHigher(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("s_act_type", "11");
    localHashMap.put("act_desc", "audNetDetectHigher");
    localHashMap.putAll(putCommonParam(paramLong1, paramLong2, paramLong3));
    doSend(localHashMap);
  }
  
  public void audNetDetectLower(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("s_act_type", "13");
    localHashMap.put("act_desc", "audNetDetectLower");
    localHashMap.putAll(putCommonParam(paramLong1, paramLong2, paramLong3));
    doSend(localHashMap);
  }
  
  public void audStartNetDetect(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("s_act_type", "10");
    localHashMap.put("act_desc", "audStartNetDetect");
    localHashMap.putAll(putCommonParam(paramLong1, paramLong2, paramLong3));
    doSend(localHashMap);
  }
  
  public void audSwitchLevel(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("s_act_type", "14");
    localHashMap.put("act_desc", "audSwitchLevel");
    localHashMap.putAll(putCommonParam(paramLong1, paramLong2, paramLong3));
    doSend(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.qualityreportservice.VideoRateQualityService
 * JD-Core Version:    0.7.0.1
 */