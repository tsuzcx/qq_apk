package com.tencent.featuretoggle.models;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

public class QueryFeatureResp
  extends JceStruct
{
  static ArrayList<FeatureResult> cache_data = new ArrayList();
  static ArrayList<Integer> cache_deletedFeatures;
  public int code = 0;
  public ArrayList<FeatureResult> data = null;
  public ArrayList<Integer> deletedFeatures = null;
  public boolean increment = true;
  public String msg = "";
  public int nextTime = 0;
  public long serverTime = 0L;
  public String setName = "";
  public long timestamp = 0L;
  
  static
  {
    FeatureResult localFeatureResult = new FeatureResult();
    cache_data.add(localFeatureResult);
    cache_deletedFeatures = new ArrayList();
    cache_deletedFeatures.add(Integer.valueOf(0));
  }
  
  public QueryFeatureResp() {}
  
  public QueryFeatureResp(int paramInt1, String paramString1, int paramInt2, String paramString2, ArrayList<FeatureResult> paramArrayList, long paramLong1, ArrayList<Integer> paramArrayList1, boolean paramBoolean, long paramLong2)
  {
    this.code = paramInt1;
    this.msg = paramString1;
    this.nextTime = paramInt2;
    this.setName = paramString2;
    this.data = paramArrayList;
    this.timestamp = paramLong1;
    this.deletedFeatures = paramArrayList1;
    this.increment = paramBoolean;
    this.serverTime = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (QueryFeatureResp)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.code, paramObject.code))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.msg, paramObject.msg))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.nextTime, paramObject.nextTime))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.setName, paramObject.setName))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.data, paramObject.data))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.timestamp, paramObject.timestamp))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.deletedFeatures, paramObject.deletedFeatures))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.increment, paramObject.increment))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.serverTime, paramObject.serverTime)) {
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
  
  public int getCode()
  {
    return this.code;
  }
  
  public ArrayList<FeatureResult> getData()
  {
    return this.data;
  }
  
  public ArrayList<Integer> getDeletedFeatures()
  {
    return this.deletedFeatures;
  }
  
  public boolean getIncrement()
  {
    return this.increment;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public int getNextTime()
  {
    return this.nextTime;
  }
  
  public long getServerTime()
  {
    return this.serverTime;
  }
  
  public String getSetName()
  {
    return this.setName;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, true);
    this.msg = paramJceInputStream.readString(1, true);
    this.nextTime = paramJceInputStream.read(this.nextTime, 2, false);
    this.setName = paramJceInputStream.readString(3, false);
    this.data = ((ArrayList)paramJceInputStream.read(cache_data, 4, false));
    this.timestamp = paramJceInputStream.read(this.timestamp, 5, false);
    this.deletedFeatures = ((ArrayList)paramJceInputStream.read(cache_deletedFeatures, 6, false));
    this.increment = paramJceInputStream.read(this.increment, 7, false);
    this.serverTime = paramJceInputStream.read(this.serverTime, 8, false);
  }
  
  public void setCode(int paramInt)
  {
    this.code = paramInt;
  }
  
  public void setData(ArrayList<FeatureResult> paramArrayList)
  {
    this.data = paramArrayList;
  }
  
  public void setDeletedFeatures(ArrayList<Integer> paramArrayList)
  {
    this.deletedFeatures = paramArrayList;
  }
  
  public void setIncrement(boolean paramBoolean)
  {
    this.increment = paramBoolean;
  }
  
  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }
  
  public void setNextTime(int paramInt)
  {
    this.nextTime = paramInt;
  }
  
  public void setServerTime(long paramLong)
  {
    this.serverTime = paramLong;
  }
  
  public void setSetName(String paramString)
  {
    this.setName = paramString;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    paramJceOutputStream.write(this.msg, 1);
    paramJceOutputStream.write(this.nextTime, 2);
    Object localObject = this.setName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.data;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    paramJceOutputStream.write(this.timestamp, 5);
    localObject = this.deletedFeatures;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
    paramJceOutputStream.write(this.increment, 7);
    paramJceOutputStream.write(this.serverTime, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.models.QueryFeatureResp
 * JD-Core Version:    0.7.0.1
 */