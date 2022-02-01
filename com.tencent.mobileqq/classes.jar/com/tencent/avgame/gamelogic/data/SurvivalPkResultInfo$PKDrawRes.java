package com.tencent.avgame.gamelogic.data;

import androidx.annotation.NonNull;
import java.io.Serializable;

public class SurvivalPkResultInfo$PKDrawRes
  implements Serializable
{
  public boolean isDraw;
  public int peerCost;
  public int selfCost;
  
  public SurvivalPkResultInfo$PKDrawRes(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.isDraw = paramBoolean;
    this.selfCost = paramInt1;
    this.peerCost = paramInt2;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isDraw:");
    localStringBuilder.append(this.isDraw);
    localStringBuilder.append("|selfCost:");
    localStringBuilder.append(this.selfCost);
    localStringBuilder.append("|peerCost:");
    localStringBuilder.append(this.peerCost);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.PKDrawRes
 * JD-Core Version:    0.7.0.1
 */