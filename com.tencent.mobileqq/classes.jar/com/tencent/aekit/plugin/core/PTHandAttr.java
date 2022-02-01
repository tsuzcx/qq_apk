package com.tencent.aekit.plugin.core;

import android.graphics.PointF;
import java.util.List;

public class PTHandAttr
{
  public static final int FORE_FINGER = 2;
  public static final int HAND_LABEL_EIGHT = 211;
  public static final int HAND_LABEL_FINGER = 220;
  public static final int HAND_LABEL_FIST = 204;
  public static final int HAND_LABEL_HAND = 200;
  public static final int HAND_LABEL_HEART = 201;
  public static final int HAND_LABEL_LIFT = 212;
  public static final int HAND_LABEL_LIKE = 207;
  public static final int HAND_LABEL_LOVE = 206;
  public static final int HAND_LABEL_OK = 208;
  public static final int HAND_LABEL_ONE = 205;
  public static final int HAND_LABEL_PAPER = 202;
  public static final int HAND_LABEL_ROCK = 209;
  public static final int HAND_LABEL_SCISSOR = 203;
  public static final int HAND_LABEL_SIX = 210;
  public static final int HAND_LABEL_ST_BLESS = 214;
  public static final int HAND_LABEL_ST_CONGRATULATE = 213;
  public static final int HAND_LABEL_ST_ILOVEYOU = 215;
  public static final int LITTLE_FINGER = 5;
  public static final int MIDDLE_FINGER = 3;
  public static final int RING_FINGER = 4;
  public static final int THUMB_FINGER = 1;
  public static final int[] handTypes = { 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215 };
  protected float confidence = 0.0F;
  private int detectHeight;
  private int detectWidth;
  private long gestureTime = 0L;
  private List<PointF> handPointList = null;
  protected int handType = 0;
  
  public float getConfidence()
  {
    return this.confidence;
  }
  
  public int getDetectHeight()
  {
    return this.detectHeight;
  }
  
  public int getDetectWidth()
  {
    return this.detectWidth;
  }
  
  public long getGestureDetectTime()
  {
    return this.gestureTime;
  }
  
  public List<PointF> getHandPointList()
  {
    return this.handPointList;
  }
  
  public int getHandType()
  {
    return this.handType;
  }
  
  public int getHandTypeIndex()
  {
    if (this.handType >= 201) {
      return this.handType - 201;
    }
    return -1;
  }
  
  public void setConfidence(float paramFloat)
  {
    this.confidence = paramFloat;
  }
  
  public void setDetectHeight(int paramInt)
  {
    this.detectHeight = paramInt;
  }
  
  public void setDetectWidth(int paramInt)
  {
    this.detectWidth = paramInt;
  }
  
  public void setGestureTime(long paramLong)
  {
    this.gestureTime = paramLong;
  }
  
  public void setHandPointList(List<PointF> paramList)
  {
    this.handPointList = paramList;
  }
  
  public void setHandType(int paramInt)
  {
    this.handType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.PTHandAttr
 * JD-Core Version:    0.7.0.1
 */