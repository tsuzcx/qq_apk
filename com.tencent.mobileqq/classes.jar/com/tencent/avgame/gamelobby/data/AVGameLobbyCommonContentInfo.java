package com.tencent.avgame.gamelobby.data;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class AVGameLobbyCommonContentInfo
  extends AVGameBaseData
{
  public int a;
  public String b;
  public String c;
  public int d;
  public List<Long> e = new ArrayList();
  public int f;
  public int g;
  public String h;
  public int i;
  private int j;
  
  public AVGameLobbyCommonContentInfo(int paramInt)
  {
    this.j = paramInt;
  }
  
  public int a()
  {
    return this.j;
  }
  
  @NonNull
  public int c()
  {
    return 2;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("actionId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append("titleUrl:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append("backgroudUrl:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append("playUserNum:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append("playerList:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("|");
    localStringBuilder.append("colorStart:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append("colorEnd:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("|");
    localStringBuilder.append("itemType:");
    localStringBuilder.append(this.i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyCommonContentInfo
 * JD-Core Version:    0.7.0.1
 */