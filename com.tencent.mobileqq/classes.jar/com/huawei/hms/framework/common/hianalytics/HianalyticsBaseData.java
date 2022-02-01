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
  private static final String SDK_NAME = "sdk_name";
  private static final String SDK_TYPE = "sdk_type";
  private static final String SDK_VERSION = "sdk_version";
  private static final String TAG = "HianalyticsBaseData";
  private LinkedHashMap<String, String> data = new LinkedHashMap();
  
  public HianalyticsBaseData()
  {
    this.data.put("sdk_type", "UxPP");
    this.data.put("sdk_name", "Restclient");
    this.data.put("sdk_version", "4.0.2.300");
  }
  
  public LinkedHashMap<String, String> get()
  {
    return this.data;
  }
  
  public HianalyticsBaseData put(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      Logger.v("HianalyticsBaseData", "key = " + paramString + " : value = " + paramLong);
      return this;
    }
    this.data.put(paramString, "" + paramLong);
    return this;
  }
  
  public HianalyticsBaseData put(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      Logger.v("HianalyticsBaseData", "key = " + paramString1 + " : value = " + paramString2);
      return this;
    }
    this.data.put(paramString1, paramString2);
    return this;
  }
  
  public HianalyticsBaseData put(LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if ((paramLinkedHashMap == null) || (paramLinkedHashMap.isEmpty()))
    {
      Logger.v("HianalyticsBaseData", "data is null");
      return this;
    }
    this.data.putAll(paramLinkedHashMap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData
 * JD-Core Version:    0.7.0.1
 */