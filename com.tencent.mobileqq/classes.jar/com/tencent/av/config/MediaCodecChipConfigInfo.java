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
  public static final long[] a;
  public final ArrayList<MediaCodecChipConfigInfo.ChipAbilityInfo> a;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[] { 2L, 1L, 8L, 4L };
  }
  
  public MediaCodecChipConfigInfo()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private static long a(String paramString)
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
  
  public static MediaCodecChipConfigInfo a(HardWareCodecSSO.ConfigRsp paramConfigRsp)
  {
    MediaCodecChipConfigInfo localMediaCodecChipConfigInfo = new MediaCodecChipConfigInfo();
    paramConfigRsp = paramConfigRsp.codec_info.get().iterator();
    while (paramConfigRsp.hasNext())
    {
      HardWareCodecSSO.PowerInfo localPowerInfo = (HardWareCodecSSO.PowerInfo)paramConfigRsp.next();
      MediaCodecChipConfigInfo.ChipAbilityInfo localChipAbilityInfo = new MediaCodecChipConfigInfo.ChipAbilityInfo();
      localChipAbilityInfo.jdField_a_of_type_Boolean = localPowerInfo.support.get();
      localChipAbilityInfo.jdField_a_of_type_Long = localPowerInfo.mark.get();
      localChipAbilityInfo.b = ((int)localPowerInfo.max_height.get());
      localChipAbilityInfo.jdField_a_of_type_Int = ((int)localPowerInfo.max_width.get());
      localMediaCodecChipConfigInfo.a(localChipAbilityInfo);
    }
    if (localMediaCodecChipConfigInfo.a().isEmpty()) {
      localMediaCodecChipConfigInfo.a(MediaCodecChipConfigInfo.ChipAbilityInfo.jdField_a_of_type_ComTencentAvConfigMediaCodecChipConfigInfo$ChipAbilityInfo);
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
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = new MediaCodecChipConfigInfo();
      JSONArray localJSONArray = localJSONObject.getJSONArray("cpuConfig");
      if (localJSONObject.has("cpuConfig"))
      {
        int j = localJSONArray.length();
        if (j > 0)
        {
          int i = 0;
          while (i < j)
          {
            localJSONObject = localJSONArray.getJSONObject(i);
            MediaCodecChipConfigInfo.ChipAbilityInfo localChipAbilityInfo = new MediaCodecChipConfigInfo.ChipAbilityInfo();
            if (localJSONObject.has("descriptionName")) {
              localChipAbilityInfo.jdField_a_of_type_Long = a(localJSONObject.optString("descriptionName"));
            }
            if (localJSONObject.has("support")) {
              localChipAbilityInfo.jdField_a_of_type_Boolean = localJSONObject.optBoolean("support");
            }
            if (localJSONObject.has("max_width")) {
              localChipAbilityInfo.jdField_a_of_type_Int = localJSONObject.optInt("max_width");
            }
            if (localJSONObject.has("max_height")) {
              localChipAbilityInfo.b = localJSONObject.optInt("max_height");
            }
            paramString.a(localChipAbilityInfo);
            if (QLog.isColorLevel()) {
              QLog.d("MediaCodecChipConfigInfo", 2, "MediaCodecChipConfigInfo parseJson index: " + i + "," + localChipAbilityInfo.toString());
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
      localJSONObject.put("descriptionName", b(paramChipAbilityInfo.jdField_a_of_type_Long));
      localJSONObject.put("support", paramChipAbilityInfo.jdField_a_of_type_Boolean);
      localJSONObject.put("max_width", paramChipAbilityInfo.jdField_a_of_type_Int);
      localJSONObject.put("max_height", paramChipAbilityInfo.b);
      return localJSONObject;
    }
    catch (JSONException paramChipAbilityInfo)
    {
      paramChipAbilityInfo.printStackTrace();
    }
    return null;
  }
  
  private void a(MediaCodecChipConfigInfo.ChipAbilityInfo paramChipAbilityInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      MediaCodecChipConfigInfo.ChipAbilityInfo localChipAbilityInfo = (MediaCodecChipConfigInfo.ChipAbilityInfo)localIterator.next();
      if (localChipAbilityInfo.jdField_a_of_type_Long == paramChipAbilityInfo.jdField_a_of_type_Long)
      {
        localChipAbilityInfo.jdField_a_of_type_Boolean = paramChipAbilityInfo.jdField_a_of_type_Boolean;
        localChipAbilityInfo.b = paramChipAbilityInfo.b;
        localChipAbilityInfo.jdField_a_of_type_Int = paramChipAbilityInfo.jdField_a_of_type_Int;
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramChipAbilityInfo);
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
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  public ArrayList<MediaCodecChipConfigInfo.ChipAbilityInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("MediaCodecChipConfigInfo{");
    localStringBuffer.append("content = '").append(Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray())).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.config.MediaCodecChipConfigInfo
 * JD-Core Version:    0.7.0.1
 */