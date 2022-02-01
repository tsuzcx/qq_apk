package com.tencent.aekit.plugin.core;

public class AIAttr
{
  private AIAttrProvider aiAttrProvider;
  private long mNextSurfaceTime;
  private long mSurfaceTime;
  private int outTexture = -1;
  private int texHeight;
  private int texWidth;
  
  public AIAttr(AIAttrProvider paramAIAttrProvider)
  {
    this.aiAttrProvider = paramAIAttrProvider;
  }
  
  public Object getAvailableData(String paramString)
  {
    AIAttrProvider localAIAttrProvider = this.aiAttrProvider;
    if (localAIAttrProvider == null) {
      return null;
    }
    return localAIAttrProvider.getAvailableData(paramString);
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
    AIAttrProvider localAIAttrProvider = this.aiAttrProvider;
    if (localAIAttrProvider == null) {
      return null;
    }
    return localAIAttrProvider.getRealtimeData(paramString);
  }
  
  public float[] getRotationMatrix()
  {
    AIAttrProvider localAIAttrProvider = this.aiAttrProvider;
    if (localAIAttrProvider == null) {
      return null;
    }
    return localAIAttrProvider.getRotationMatrix();
  }
  
  public long getSurfaceTime()
  {
    return this.mSurfaceTime;
  }
  
  public int getTexHeight()
  {
    return this.texHeight;
  }
  
  public int getTexWidth()
  {
    return this.texWidth;
  }
  
  public void setFaceAttr(Object paramObject)
  {
    AIAttrProvider localAIAttrProvider = this.aiAttrProvider;
    if (localAIAttrProvider != null) {
      localAIAttrProvider.setFaceAttr(paramObject);
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
  
  public void setTexHeight(int paramInt)
  {
    this.texHeight = paramInt;
  }
  
  public void setTexWidth(int paramInt)
  {
    this.texWidth = paramInt;
  }
  
  public void setTexWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.texWidth = paramInt1;
    this.texHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIAttr
 * JD-Core Version:    0.7.0.1
 */