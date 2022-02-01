package com.tencent.avgame.gamelogic.data;

import androidx.annotation.NonNull;
import java.io.Serializable;

public class GameRecordInfo
  implements Serializable
{
  public String extraJsonData;
  public int gameType = 0;
  public String photoFilePath;
  public long startGameTimeMills;
  public String videoFilePath;
  
  public void copyFrom(GameRecordInfo paramGameRecordInfo)
  {
    if (paramGameRecordInfo != null)
    {
      this.gameType = paramGameRecordInfo.gameType;
      this.videoFilePath = paramGameRecordInfo.videoFilePath;
      this.photoFilePath = paramGameRecordInfo.photoFilePath;
      this.startGameTimeMills = paramGameRecordInfo.startGameTimeMills;
      this.extraJsonData = paramGameRecordInfo.extraJsonData;
    }
  }
  
  public void reset()
  {
    this.gameType = 0;
    this.videoFilePath = null;
    this.photoFilePath = null;
    this.startGameTimeMills = 0L;
    this.extraJsonData = null;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gameType").append("=").append(this.gameType).append("|");
    localStringBuilder.append("videoFilePath").append("=").append(this.videoFilePath).append("|");
    localStringBuilder.append("photoFilePath").append("=").append(this.photoFilePath).append("|");
    localStringBuilder.append("startGameTimeMills").append("=").append(this.startGameTimeMills).append("|");
    localStringBuilder.append("extraJsonData").append("=").append(this.extraJsonData).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.GameRecordInfo
 * JD-Core Version:    0.7.0.1
 */