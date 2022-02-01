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
  public static final String VERSIONID = "versionId";
  public static final String WEIGHT = "weight";
  static Map<String, String> cache_data = new HashMap();
  public Map<String, String> data = null;
  public int datasetId = 0;
  public int versionId = 0;
  public int weight = 0;
  
  static
  {
    cache_data.put("", "");
  }
  
  public DatasetEntity() {}
  
  public DatasetEntity(int paramInt1, int paramInt2, Map<String, String> paramMap, int paramInt3)
  {
    this.datasetId = paramInt1;
    this.versionId = paramInt2;
    this.data = paramMap;
    this.weight = paramInt3;
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
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.datasetId, true);
    paramStringBuilder.displaySimple(this.versionId, true);
    paramStringBuilder.displaySimple(this.data, true);
    paramStringBuilder.displaySimple(this.weight, false);
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
          if (JceUtil.equals(this.weight, paramObject.weight)) {
            bool1 = true;
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
  }
  
  public void setData(Map<String, String> paramMap)
  {
    this.data = paramMap;
  }
  
  public void setDatasetId(int paramInt)
  {
    this.datasetId = paramInt;
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
    Map localMap = this.data;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 2);
    }
    paramJceOutputStream.write(this.weight, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.models.DatasetEntity
 * JD-Core Version:    0.7.0.1
 */