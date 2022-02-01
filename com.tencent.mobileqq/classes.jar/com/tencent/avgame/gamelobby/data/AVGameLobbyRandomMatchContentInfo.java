package com.tencent.avgame.gamelobby.data;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class AVGameLobbyRandomMatchContentInfo
  extends AVGameBaseData
{
  public int a;
  public List<Long> b = new ArrayList();
  public int c = 0;
  public String d = null;
  public String e = null;
  public String f = null;
  public int g = 0;
  private int h;
  
  public AVGameLobbyRandomMatchContentInfo(int paramInt)
  {
    this.h = paramInt;
  }
  
  public int a()
  {
    return this.h;
  }
  
  @NonNull
  public int c()
  {
    return 7;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("titleUrl:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append("backgroudUrl:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("|");
    localStringBuilder.append("playersNum:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append("playerList:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append("itemType:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyRandomMatchContentInfo
 * JD-Core Version:    0.7.0.1
 */