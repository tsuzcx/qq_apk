package com.tencent.aekit.plugin.core;

import android.util.Log;

public class AIAttrProvider
{
  private static final int DETECT_WAIT_TIMEOUT = 500;
  private static final String TAG = "AIAttrProvider";
  private AIDataSet aiDataSet;
  private Object mFaceAttr;
  private float[] mRotationMatrix = new float[16];
  
  public AIAttrProvider(AIDataSet paramAIDataSet)
  {
    this.aiDataSet = paramAIDataSet;
  }
  
  public void clear()
  {
    this.mFaceAttr = null;
    this.aiDataSet.clear();
    this.aiDataSet = null;
  }
  
  public Object getAvailableData(String paramString)
  {
    ??? = this.aiDataSet;
    if (??? == null) {
      return null;
    }
    paramString = ((AIDataSet)???).getAIData(paramString);
    if (paramString == null) {
      return null;
    }
    synchronized (paramString.getLock())
    {
      if (paramString.getAttr() != null) {
        paramString = paramString.getAttr();
      } else {
        paramString = paramString.getLastAttr();
      }
      return paramString;
    }
  }
  
  public Object getFaceAttr()
  {
    return this.mFaceAttr;
  }
  
  public Object getRealtimeData(String paramString)
  {
    ??? = this.aiDataSet;
    if (??? == null)
    {
      if (paramString.equals(AEDetectorType.FACE.value)) {
        return this.mFaceAttr;
      }
      return null;
    }
    AIData localAIData = ((AIDataSet)???).getAIData(paramString);
    if (localAIData == null) {
      return null;
    }
    synchronized (localAIData.getLock())
    {
      for (;;)
      {
        Object localObject2 = localAIData.getAttr();
        if (localObject2 != null) {
          break;
        }
        try
        {
          localAIData.getLock().wait(500L);
        }
        catch (InterruptedException localInterruptedException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("getRealtimeData failed : ");
          localStringBuilder.append(localInterruptedException.getMessage());
          Log.e("AIAttrProvider", localStringBuilder.toString());
        }
      }
      if ((localAIData.getAttr() == null) && (paramString.equals(AEDetectorType.FACE.value))) {
        return this.mFaceAttr;
      }
      return localAIData.getAttr();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public float[] getRotationMatrix()
  {
    return this.mRotationMatrix;
  }
  
  public void setFaceAttr(Object paramObject)
  {
    this.mFaceAttr = paramObject;
  }
  
  public void setRotationMatrix(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.mRotationMatrix, 0, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIAttrProvider
 * JD-Core Version:    0.7.0.1
 */