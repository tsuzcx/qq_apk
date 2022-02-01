package com.tencent.featuretoggle.models;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.featuretoggle.utils.LogUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeatureResult
  extends JceStruct
{
  public static final String DATASET = "dataset";
  public static final String END_TIME = "endTime";
  public static final String EXTEND_FIELD = "extendField";
  public static final String ID = "id";
  public static final String IS_ABT_FIRST = "isAbtFirst";
  public static final String NAME = "name";
  public static final String REFRESH_TYPE = "refreshType";
  public static final String RESULT = "result";
  public static final String START_TIME = "startTime";
  public static final String TIME_LIMITS = "timeLimits";
  public static final String TIME_LIMIT_TYPE = "timeLimitType";
  static DatasetEntity cache_dataset = new DatasetEntity();
  static Map<String, String> cache_extendField = new HashMap();
  static ArrayList<TimeLimit> cache_timeLimits;
  public DatasetEntity dataset = null;
  public Map<String, String> extendField = null;
  public int id = 0;
  public boolean isAbtFirst = true;
  public String name = "";
  public int refreshType = 1;
  public String result = "";
  public int timeLimitType = 1;
  public ArrayList<TimeLimit> timeLimits = null;
  
  static
  {
    cache_extendField.put("", "");
    cache_timeLimits = new ArrayList();
    TimeLimit localTimeLimit = new TimeLimit();
    cache_timeLimits.add(localTimeLimit);
  }
  
  public FeatureResult() {}
  
  public FeatureResult(int paramInt, String paramString1, String paramString2)
  {
    this.id = paramInt;
    this.name = paramString1;
    this.result = paramString2;
    this.extendField = new HashMap();
    this.dataset = new DatasetEntity();
  }
  
  public FeatureResult(int paramInt1, String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean, int paramInt2, ArrayList<TimeLimit> paramArrayList, int paramInt3, DatasetEntity paramDatasetEntity)
  {
    this.id = paramInt1;
    this.name = paramString1;
    this.result = paramString2;
    this.extendField = paramMap;
    this.isAbtFirst = paramBoolean;
    this.timeLimitType = paramInt2;
    this.timeLimits = paramArrayList;
    this.refreshType = paramInt3;
    this.dataset = paramDatasetEntity;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (FeatureResult)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.id, paramObject.id))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.name, paramObject.name))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.result, paramObject.result))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.extendField, paramObject.extendField))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.isAbtFirst, paramObject.isAbtFirst))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.timeLimitType, paramObject.timeLimitType))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.timeLimits, paramObject.timeLimits))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.refreshType, paramObject.refreshType))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.dataset, paramObject.dataset)) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public DatasetEntity getDataset()
  {
    return this.dataset;
  }
  
  public Map<String, String> getExtendField()
  {
    return this.extendField;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public boolean getIsAbtFirst()
  {
    return this.isAbtFirst;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getRefreshType()
  {
    return this.refreshType;
  }
  
  public String getResult()
  {
    return this.result;
  }
  
  public int getTimeLimitType()
  {
    return this.timeLimitType;
  }
  
  public ArrayList<TimeLimit> getTimeLimits()
  {
    return this.timeLimits;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.result = paramJceInputStream.readString(2, false);
    this.extendField = ((Map)paramJceInputStream.read(cache_extendField, 3, false));
    this.isAbtFirst = paramJceInputStream.read(this.isAbtFirst, 4, false);
    this.timeLimitType = paramJceInputStream.read(this.timeLimitType, 5, false);
    this.timeLimits = ((ArrayList)paramJceInputStream.read(cache_timeLimits, 6, false));
    this.refreshType = paramJceInputStream.read(this.refreshType, 7, false);
    this.dataset = ((DatasetEntity)paramJceInputStream.read(cache_dataset, 8, false));
  }
  
  public void setDataset(DatasetEntity paramDatasetEntity)
  {
    this.dataset = paramDatasetEntity;
  }
  
  public void setExtendField(Map<String, String> paramMap)
  {
    this.extendField = paramMap;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIsAbtFirst(boolean paramBoolean)
  {
    this.isAbtFirst = paramBoolean;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setRefreshType(int paramInt)
  {
    this.refreshType = paramInt;
  }
  
  public void setResult(String paramString)
  {
    this.result = paramString;
  }
  
  public void setTimeLimitType(int paramInt)
  {
    this.timeLimitType = paramInt;
  }
  
  public void setTimeLimits(ArrayList<TimeLimit> paramArrayList)
  {
    this.timeLimits = paramArrayList;
  }
  
  public String toJsonString()
  {
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("id", this.id);
      ((JSONObject)localObject1).put("name", this.name);
      ((JSONObject)localObject1).put("result", this.result);
      ((JSONObject)localObject1).put("extendField", this.extendField);
      ((JSONObject)localObject1).put("isAbtFirst", this.isAbtFirst);
      ((JSONObject)localObject1).put("timeLimitType", this.timeLimitType);
      Object localObject2 = new JSONArray();
      if (this.timeLimits != null)
      {
        Iterator localIterator = this.timeLimits.iterator();
        while (localIterator.hasNext())
        {
          TimeLimit localTimeLimit = (TimeLimit)localIterator.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("startTime", localTimeLimit.startTime);
          localJSONObject.put("endTime", localTimeLimit.endTime);
          ((JSONArray)localObject2).put(localJSONObject);
        }
      }
      ((JSONObject)localObject1).put("timeLimits", localObject2);
      ((JSONObject)localObject1).put("refreshType", this.refreshType);
      if (this.dataset != null)
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("datasetId", this.dataset.datasetId);
        ((JSONObject)localObject2).put("versionId", this.dataset.versionId);
        ((JSONObject)localObject2).put("weight", this.dataset.weight);
        if (this.dataset.data != null) {
          ((JSONObject)localObject2).put("data", new JSONObject(this.dataset.data));
        }
        if (this.dataset.type != null) {
          ((JSONObject)localObject2).put("type", this.dataset.type);
        }
        if (this.dataset.value != null) {
          ((JSONObject)localObject2).put("value", this.dataset.value);
        }
        ((JSONObject)localObject1).put("dataset", localObject2);
      }
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      if (!LogUtils.a(localJSONException)) {
        localJSONException.printStackTrace();
      }
    }
    return null;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    Object localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.result;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.extendField;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    paramJceOutputStream.write(this.isAbtFirst, 4);
    paramJceOutputStream.write(this.timeLimitType, 5);
    localObject = this.timeLimits;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
    paramJceOutputStream.write(this.refreshType, 7);
    localObject = this.dataset;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.models.FeatureResult
 * JD-Core Version:    0.7.0.1
 */