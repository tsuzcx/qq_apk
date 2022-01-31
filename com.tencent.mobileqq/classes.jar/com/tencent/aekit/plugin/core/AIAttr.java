package com.tencent.aekit.plugin.core;

public class AIAttr
{
  private AIAttrProvider aiAttrProvider;
  private long mNextSurfaceTime;
  private long mSurfaceTime;
  private int outTexture = -1;
  
  public AIAttr(AIAttrProvider paramAIAttrProvider)
  {
    this.aiAttrProvider = paramAIAttrProvider;
  }
  
  public Object getAvailableData(String paramString)
  {
    if (this.aiAttrProvider == null) {
      return null;
    }
    return this.aiAttrProvider.getAvailableData(paramString);
  }
  
  public Object getFaceAttr()
  {
    return getRealtimeData(AEDetectorType.FACE.value);
  }
  
  public long getNextSurfaceTime()
  {
    return this.mNextSurfaceTime;
  }
  
  public int getOutTexture()
  {
    return this.outTexture;
  }
  
  public Object getRealtimeData(String paramString)
  {
    if (this.aiAttrProvider == null) {
      return null;
    }
    return this.aiAttrProvider.getRealtimeData(paramString);
  }
  
  public float[] getRotationMatrix()
  {
    if (this.aiAttrProvider == null) {
      return null;
    }
    return this.aiAttrProvider.getRotationMatrix();
  }
  
  public long getSurfaceTime()
  {
    return this.mSurfaceTime;
  }
  
  public void setFaceAttr(Object paramObject)
  {
    if (this.aiAttrProvider != null) {
      this.aiAttrProvider.setFaceAttr(paramObject);
    }
  }
  
  public void setNextSurfaceTime(long paramLong)
  {
    this.mNextSurfaceTime = paramLong;
  }
  
  public void setOutTexture(int paramInt)
  {
    this.outTexture = paramInt;
  }
  
  public void setSurfaceTime(long paramLong)
  {
    this.mSurfaceTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIAttr
 * JD-Core Version:    0.7.0.1
 */