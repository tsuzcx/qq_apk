package com.tencent.av.config;

import android.text.TextUtils;
import com.tencent.av.HardWareCodecSSO.ConfigRsp;
import com.tencent.av.HardWareCodecSSO.PowerInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaCodecChipConfigInfo
{
  public static final long[] a = { 2L, 1L, 8L, 4L };
  public final ArrayList<MediaCodecChipConfigInfo.ChipAbilityInfo> b = new ArrayList();
  
  public static MediaCodecChipConfigInfo a(HardWareCodecSSO.ConfigRsp paramConfigRsp)
  {
    MediaCodecChipConfigInfo localMediaCodecChipConfigInfo = new MediaCodecChipConfigInfo();
    paramConfigRsp = paramConfigRsp.codec_info.get().iterator();
    while (paramConfigRsp.hasNext())
    {
      HardWareCodecSSO.PowerInfo localPowerInfo = (HardWareCodecSSO.PowerInfo)paramConfigRsp.next();
      MediaCodecChipConfigInfo.ChipAbilityInfo localChipAbilityInfo = new MediaCodecChipConfigInfo.ChipAbilityInfo();
      localChipAbilityInfo.c = localPowerInfo.support.get();
      localChipAbilityInfo.b = localPowerInfo.mark.get();
      localChipAbilityInfo.e = ((int)localPowerInfo.max_height.get());
      localChipAbilityInfo.d = ((int)localPowerInfo.max_width.get());
      localMediaCodecChipConfigInfo.b(localChipAbilityInfo);
    }
    if (localMediaCodecChipConfigInfo.a().isEmpty()) {
      localMediaCodecChipConfigInfo.b(MediaCodecChipConfigInfo.ChipAbilityInfo.a);
    }
    return localMediaCodecChipConfigInfo;
  }
  
  public static MediaCodecChipConfigInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = new MediaCodecChipConfigInfo();
      JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("cpuConfig");
      if (((JSONObject)localObject1).has("cpuConfig"))
      {
        int j = localJSONArray.length();
        if (j > 0)
        {
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localJSONArray.getJSONObject(i);
            localObject1 = new MediaCodecChipConfigInfo.ChipAbilityInfo();
            if (((JSONObject)localObject2).has("descriptionName")) {
              ((MediaCodecChipConfigInfo.ChipAbilityInfo)localObject1).b = b(((JSONObject)localObject2).optString("descriptionName"));
            }
            if (((JSONObject)localObject2).has("support")) {
              ((MediaCodecChipConfigInfo.ChipAbilityInfo)localObject1).c = ((JSONObject)localObject2).optBoolean("support");
            }
            if (((JSONObject)localObject2).has("max_width")) {
              ((MediaCodecChipConfigInfo.ChipAbilityInfo)localObject1).d = ((JSONObject)localObject2).optInt("max_width");
            }
            if (((JSONObject)localObject2).has("max_height")) {
              ((MediaCodecChipConfigInfo.ChipAbilityInfo)localObject1).e = ((JSONObject)localObject2).optInt("max_height");
            }
            paramString.b((MediaCodecChipConfigInfo.ChipAbilityInfo)localObject1);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("MediaCodecChipConfigInfo parseJson index: ");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(",");
              ((StringBuilder)localObject2).append(((MediaCodecChipConfigInfo.ChipAbilityInfo)localObject1).toString());
              QLog.d("MediaCodecChipConfigInfo", 2, ((StringBuilder)localObject2).toString());
            }
            i += 1;
          }
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.d("MediaCodecChipConfigInfo", 1, String.format("parseJson, Exception\n%s", new Object[] { paramString }));
    }
    return null;
  }
  
  private static JSONObject a(MediaCodecChipConfigInfo.ChipAbilityInfo paramChipAbilityInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("descriptionName", b(paramChipAbilityInfo.b));
      localJSONObject.put("support", paramChipAbilityInfo.c);
      localJSONObject.put("max_width", paramChipAbilityInfo.d);
      localJSONObject.put("max_height", paramChipAbilityInfo.e);
      return localJSONObject;
    }
    catch (JSONException paramChipAbilityInfo)
    {
      paramChipAbilityInfo.printStackTrace();
    }
    return null;
  }
  
  private static long b(String paramString)
  {
    if ("h264_encode".equalsIgnoreCase(paramString)) {
      return 1L;
    }
    if ("h265_encode".equalsIgnoreCase(paramString)) {
      return 4L;
    }
    if ("h264_decode".equalsIgnoreCase(paramString)) {
      return 2L;
    }
    if ("h265_decode".equalsIgnoreCase(paramString)) {
      return 8L;
    }
    return 0L;
  }
  
  private static String b(long paramLong)
  {
    if (1L == paramLong) {
      return "h264_encode";
    }
    if (4L == paramLong) {
      return "h265_encode";
    }
    if (2L == paramLong) {
      return "h264_decode";
    }
    if (8L == paramLong) {
      return "h265_decode";
    }
    return "";
  }
  
  private void b(MediaCodecChipConfigInfo.ChipAbilityInfo paramChipAbilityInfo)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      MediaCodecChipConfigInfo.ChipAbilityInfo localChipAbilityInfo = (MediaCodecChipConfigInfo.ChipAbilityInfo)localIterator.next();
      if (localChipAbilityInfo.b == paramChipAbilityInfo.b)
      {
        localChipAbilityInfo.c = paramChipAbilityInfo.c;
        localChipAbilityInfo.e = paramChipAbilityInfo.e;
        localChipAbilityInfo.d = paramChipAbilityInfo.d;
        return;
      }
    }
    this.b.add(paramChipAbilityInfo);
  }
  
  public ArrayList<MediaCodecChipConfigInfo.ChipAbilityInfo> a()
  {
    return this.b;
  }
  
  public String b()
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(a((MediaCodecChipConfigInfo.ChipAbilityInfo)localIterator.next()));
    }
    try
    {
      localJSONObject.put("cpuConfig", localJSONArray);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("MediaCodecChipConfigInfo{");
    localStringBuffer.append("content = '");
    localStringBuffer.append(Arrays.toString(this.b.toArray()));
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.MediaCodecChipConfigInfo
 * JD-Core Version:    0.7.0.1
 */