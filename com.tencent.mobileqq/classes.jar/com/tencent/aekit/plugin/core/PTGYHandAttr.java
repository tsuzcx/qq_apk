package com.tencent.aekit.plugin.core;

public class PTGYHandAttr
  extends PTHandAttr
{
  public static final int HAND_LABEL_FOUR = 216;
  public static final int HAND_LABEL_OTHERS = 213;
  public static final int HAND_LABEL_THREE = 215;
  public static final int HAND_LABEL_UNKOWN = 214;
  public static final int NO_HAND_DETECT = -1;
  
  public void setHandType(int paramInt)
  {
    this.handType = (paramInt + 201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.PTGYHandAttr
 * JD-Core Version:    0.7.0.1
 */