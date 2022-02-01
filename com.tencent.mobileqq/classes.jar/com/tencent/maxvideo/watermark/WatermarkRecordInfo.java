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
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      int j = paramList.size();
      for (;;)
      {
        if (i >= j)
        {
          localStringBuffer.append("]");
          break;
        }
        WatermarkRecordInfo localWatermarkRecordInfo = (WatermarkRecordInfo)paramList.get(i);
        if (i == 0)
        {
          localStringBuffer.append("[");
          localStringBuffer.append(localWatermarkRecordInfo.toJson());
        }
        else
        {
          localStringBuffer.append(",");
          localStringBuffer.append(localWatermarkRecordInfo.toJson());
        }
        i += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static WatermarkRecordInfo getWatermarkRecordInfo4Json(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        WatermarkRecordInfo localWatermarkRecordInfo = new WatermarkRecordInfo();
        localWatermarkRecordInfo.mStartIndex = paramString.getInt("start_index");
        localWatermarkRecordInfo.mEndIndex = paramString.getInt("end_index");
        localWatermarkRecordInfo.mDir = paramString.getString("root_path");
        return localWatermarkRecordInfo;
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
    do
    {
      try
      {
        paramString = new JSONArray(paramString);
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
    StringBuilder localStringBuilder = new StringBuilder("{\"start_index\":");
    localStringBuilder.append(this.mStartIndex);
    localStringBuilder.append(",\"end_index\":");
    localStringBuilder.append(this.mEndIndex);
    localStringBuilder.append(",\"root_path\":\"");
    localStringBuilder.append(this.mDir);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("WatermarkRecordInfo [mStartIndex=");
    localStringBuilder.append(this.mStartIndex);
    localStringBuilder.append(", mEndIndex=");
    localStringBuilder.append(this.mEndIndex);
    localStringBuilder.append(", mType=");
    localStringBuilder.append(this.mType);
    localStringBuilder.append(", mDir=");
    localStringBuilder.append(this.mDir);
    localStringBuilder.append(", mJsonFilePath=");
    localStringBuilder.append(this.mJsonFilePath);
    localStringBuilder.append(", mDesc=");
    localStringBuilder.append(this.mDesc);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.maxvideo.watermark.WatermarkRecordInfo
 * JD-Core Version:    0.7.0.1
 */