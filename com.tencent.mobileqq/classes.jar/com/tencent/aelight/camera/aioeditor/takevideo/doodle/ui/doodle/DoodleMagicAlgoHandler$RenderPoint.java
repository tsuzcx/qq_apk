package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import java.io.Serializable;

public class DoodleMagicAlgoHandler$RenderPoint
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public float[] aList;
  public float[] xList;
  public float[] yList;
  
  public DoodleMagicAlgoHandler$RenderPoint() {}
  
  public DoodleMagicAlgoHandler$RenderPoint(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, int paramInt)
  {
    this.xList = new float[paramInt];
    this.yList = new float[paramInt];
    this.aList = new float[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      this.xList[i] = paramArrayOfFloat1[i];
      this.yList[i] = paramArrayOfFloat2[i];
      this.aList[i] = paramArrayOfFloat3[i];
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleMagicAlgoHandler.RenderPoint
 * JD-Core Version:    0.7.0.1
 */