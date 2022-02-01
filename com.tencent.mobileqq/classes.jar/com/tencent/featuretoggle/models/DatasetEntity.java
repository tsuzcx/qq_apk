package com.tencent.featuretoggle.models;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public final class DatasetEntity
  extends JceStruct
  implements Cloneable
{
  public static final String DATA = "data";
  public static final String DATASETID = "datasetId";
  public static final String TYPE = "type";
  public static final String VALUE = "value";
  public static final String VERSIONID = "versionId";
  public static final String WEIGHT = "weight";
  static Map<String, String> cache_data = new HashMap();
  public Map<String, String> data = null;
  public int datasetId = 0;
  public String type = "";
  public String value = "";
  public int versionId = 0;
  public int weight = 0;
  
  static
  {
    cache_data.put("", "");
  }
  
  public DatasetEntity() {}
  
  public DatasetEntity(int paramInt1, int paramInt2, Map<String, String> paramMap, int paramInt3, String paramString1, String paramString2)
  {
    this.datasetId = paramInt1;
    this.versionId = paramInt2;
    this.data = paramMap;
    this.weight = paramInt3;
    this.type = paramString1;
    this.value = paramString2;
  }
  
  public String className()
  {
    return "dto.DatasetEntity";
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.datasetId, "datasetId");
    paramStringBuilder.display(this.versionId, "versionId");
    paramStringBuilder.display(this.data, "data");
    paramStringBuilder.display(this.weight, "weight");
    paramStringBuilder.display(this.type, "type");
    paramStringBuilder.display(this.value, "value");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.datasetId, true);
    paramStringBuilder.displaySimple(this.versionId, true);
    paramStringBuilder.displaySimple(this.data, true);
    paramStringBuilder.displaySimple(this.weight, false);
    paramStringBuilder.displaySimple(this.type, true);
    paramStringBuilder.displaySimple(this.value, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (DatasetEntity)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.datasetId, paramObject.datasetId))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.versionId, paramObject.versionId))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.data, paramObject.data))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.weight, paramObject.weight))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.type, paramObject.type))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.value, paramObject.value)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "com.tencent.featuretoggle.models.dto.DatasetEntity";
  }
  
  public Map<String, String> getData()
  {
    return this.data;
  }
  
  public int getDatasetId()
  {
    return this.datasetId;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public int getVersionId()
  {
    return this.versionId;
  }
  
  public int getWeight()
  {
    return this.weight;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.datasetId = paramJceInputStream.read(this.datasetId, 0, false);
    this.versionId = paramJceInputStream.read(this.versionId, 1, false);
    this.data = ((Map)paramJceInputStream.read(cache_data, 2, false));
    this.weight = paramJceInputStream.read(this.weight, 3, false);
    this.type = paramJceInputStream.readString(4, false);
    this.value = paramJceInputStream.readString(5, false);
  }
  
  public void setData(Map<String, String> paramMap)
  {
    this.data = paramMap;
  }
  
  public void setDatasetId(int paramInt)
  {
    this.datasetId = paramInt;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public void setVersionId(int paramInt)
  {
    this.versionId = paramInt;
  }
  
  public void setWeight(int paramInt)
  {
    this.weight = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.datasetId, 0);
    paramJceOutputStream.write(this.versionId, 1);
    Object localObject = this.data;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
    paramJceOutputStream.write(this.weight, 3);
    localObject = this.type;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.value;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.models.DatasetEntity
 * JD-Core Version:    0.7.0.1
 */