package com.tencent.maxvideo.watermark;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WatermarkRecordInfo
  extends WatermarkInfo
{
  public int mEndIndex;
  public int mStartIndex;
  
  public static String getJson(List<WatermarkRecordInfo> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int j = paramList.size();
      i = 0;
      if (i >= j) {
        localStringBuffer.append("]");
      }
    }
    else
    {
      return localStringBuffer.toString();
    }
    WatermarkRecordInfo localWatermarkRecordInfo = (WatermarkRecordInfo)paramList.get(i);
    if (i == 0)
    {
      localStringBuffer.append("[");
      localStringBuffer.append(localWatermarkRecordInfo.toJson());
    }
    for (;;)
    {
      i += 1;
      break;
      localStringBuffer.append(",");
      localStringBuffer.append(localWatermarkRecordInfo.toJson());
    }
  }
  
  public static WatermarkRecordInfo getWatermarkRecordInfo4Json(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString != null)
        {
          WatermarkRecordInfo localWatermarkRecordInfo = new WatermarkRecordInfo();
          localWatermarkRecordInfo.mStartIndex = paramString.getInt("start_index");
          localWatermarkRecordInfo.mEndIndex = paramString.getInt("end_index");
          localWatermarkRecordInfo.mDir = paramString.getString("root_path");
          return localWatermarkRecordInfo;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static List<WatermarkRecordInfo> getWatermarkRecordInfo4Jsons(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    ArrayList localArrayList;
    int j;
    int i;
    label116:
    do
    {
      try
      {
        paramString = new JSONArray(paramString);
        if (paramString == null) {
          break label116;
        }
        localArrayList = new ArrayList();
        j = paramString.length();
        i = 0;
      }
      catch (JSONException paramString)
      {
        JSONObject localJSONObject;
        WatermarkRecordInfo localWatermarkRecordInfo;
        paramString.printStackTrace();
      }
      localJSONObject = paramString.getJSONObject(i);
      if (localJSONObject != null)
      {
        localWatermarkRecordInfo = new WatermarkRecordInfo();
        localWatermarkRecordInfo.mStartIndex = localJSONObject.getInt("start_index");
        localWatermarkRecordInfo.mEndIndex = localJSONObject.getInt("end_index");
        localWatermarkRecordInfo.mDir = localJSONObject.getString("root_path");
        localArrayList.add(localWatermarkRecordInfo);
      }
      i += 1;
      continue;
      return null;
    } while (i < j);
    return localArrayList;
  }
  
  public String toJson()
  {
    return "{\"start_index\":" + this.mStartIndex + ",\"end_index\":" + this.mEndIndex + ",\"root_path\":\"" + this.mDir + "\"}";
  }
  
  public String toString()
  {
    return "WatermarkRecordInfo [mStartIndex=" + this.mStartIndex + ", mEndIndex=" + this.mEndIndex + ", mType=" + this.mType + ", mDir=" + this.mDir + ", mJsonFilePath=" + this.mJsonFilePath + ", mDesc=" + this.mDesc + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.maxvideo.watermark.WatermarkRecordInfo
 * JD-Core Version:    0.7.0.1
 */