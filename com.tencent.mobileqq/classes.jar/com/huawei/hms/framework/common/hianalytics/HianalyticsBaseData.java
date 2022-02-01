package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HianalyticsBaseData
{
  protected static final String SDK_NAME = "sdk_name";
  private static final String SDK_TYPE = "sdk_type";
  private static final String TAG = "HianalyticsBaseData";
  private LinkedHashMap<String, String> data = new LinkedHashMap();
  
  public HianalyticsBaseData()
  {
    this.data.put("sdk_type", "UxPP");
    this.data.put("sdk_name", "Restclient");
  }
  
  public LinkedHashMap<String, String> get()
  {
    return this.data;
  }
  
  public HianalyticsBaseData put(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("key = null : value = ");
      paramString.append(paramLong);
      Logger.v("HianalyticsBaseData", paramString.toString());
      return this;
    }
    LinkedHashMap localLinkedHashMap = this.data;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    localLinkedHashMap.put(paramString, localStringBuilder.toString());
    return this;
  }
  
  public HianalyticsBaseData put(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      this.data.put(paramString1, paramString2);
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" : value = ");
    localStringBuilder.append(paramString2);
    Logger.v("HianalyticsBaseData", localStringBuilder.toString());
    return this;
  }
  
  public HianalyticsBaseData put(LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if ((paramLinkedHashMap != null) && (!paramLinkedHashMap.isEmpty()))
    {
      this.data.putAll(paramLinkedHashMap);
      return this;
    }
    Logger.v("HianalyticsBaseData", "data is null");
    return this;
  }
  
  public String toString()
  {
    localJSONObject = new JSONObject();
    Object localObject = get();
    try
    {
      localObject = ((LinkedHashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      Logger.w("HianalyticsBaseData", "catch JSONException", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData
 * JD-Core Version:    0.7.0.1
 */