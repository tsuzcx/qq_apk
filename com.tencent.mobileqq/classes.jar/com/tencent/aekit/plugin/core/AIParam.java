package com.tencent.aekit.plugin.core;

import java.util.HashMap;
import java.util.Map;

public class AIParam
{
  public static final String BYTES_DATA_SIZE_HEIGHT = "bytesDataSizeHeight";
  public static final String BYTES_DATA_SIZE_WIDTH = "bytesDataSizeWidth";
  public static final String NEED_DETECT_HAND_BONE = "needDetectHandBone";
  public static final String SCALE = "scale";
  private AIAttr aiAttr;
  private Map<String, Map<String, Object>> aiModuleParams = new HashMap();
  private int height;
  private float[] mRotationMatrix = new float[16];
  private int rotation;
  private long surfaceTime;
  private int width;
  
  public AIAttr getAIAttr()
  {
    return this.aiAttr;
  }
  
  public Integer getBytesDataSizeHeight(String paramString)
  {
    if (this.aiModuleParams.get(paramString) == null) {
      return null;
    }
    if ((((Map)this.aiModuleParams.get(paramString)).get("bytesDataSizeHeight") != null) && ((((Map)this.aiModuleParams.get(paramString)).get("bytesDataSizeHeight") instanceof Integer))) {
      return (Integer)((Map)this.aiModuleParams.get(paramString)).get("bytesDataSizeHeight");
    }
    return Integer.valueOf(0);
  }
  
  public Integer getBytesDataSizeWidth(String paramString)
  {
    if (this.aiModuleParams.get(paramString) == null) {
      return null;
    }
    if ((((Map)this.aiModuleParams.get(paramString)).get("bytesDataSizeWidth") != null) && ((((Map)this.aiModuleParams.get(paramString)).get("bytesDataSizeWidth") instanceof Integer))) {
      return (Integer)((Map)this.aiModuleParams.get(paramString)).get("bytesDataSizeWidth");
    }
    return Integer.valueOf(0);
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public Map<String, Object> getModuleParam(String paramString)
  {
    return (Map)this.aiModuleParams.get(paramString);
  }
  
  public int getRotation()
  {
    return this.rotation;
  }
  
  public float[] getRotationMatrix()
  {
    return this.mRotationMatrix;
  }
  
  public Float getScale(String paramString)
  {
    if (this.aiModuleParams.get(paramString) == null) {
      return null;
    }
    if ((((Map)this.aiModuleParams.get(paramString)).get("scale") != null) && ((((Map)this.aiModuleParams.get(paramString)).get("scale") instanceof Float))) {
      return (Float)((Map)this.aiModuleParams.get(paramString)).get("scale");
    }
    return null;
  }
  
  public long getSurfaceTime()
  {
    return this.surfaceTime;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setAIAttr(AIAttr paramAIAttr)
  {
    this.aiAttr = paramAIAttr;
  }
  
  public void setModuleParam(String paramString1, String paramString2, Object paramObject)
  {
    if (this.aiModuleParams.get(paramString1) == null) {
      this.aiModuleParams.put(paramString1, new HashMap());
    }
    ((Map)this.aiModuleParams.get(paramString1)).put(paramString2, paramObject);
  }
  
  public void setRotationMatrix(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.mRotationMatrix, 0, 16);
  }
  
  public void setSurfaceTime(long paramLong)
  {
    this.surfaceTime = paramLong;
  }
  
  public void update(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.rotation = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIParam
 * JD-Core Version:    0.7.0.1
 */