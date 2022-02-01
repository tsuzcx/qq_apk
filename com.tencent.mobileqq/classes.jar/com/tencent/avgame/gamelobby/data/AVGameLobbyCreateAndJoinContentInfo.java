package com.tencent.avgame.gamelobby.data;

import androidx.annotation.NonNull;

public class AVGameLobbyCreateAndJoinContentInfo
  extends AVGameBaseData
{
  public String a = null;
  public String b = null;
  public String c = null;
  public String d = null;
  public boolean e = false;
  private int f;
  
  public AVGameLobbyCreateAndJoinContentInfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.f = paramInt;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public int a()
  {
    return this.f;
  }
  
  @NonNull
  public int c()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyCreateAndJoinContentInfo
 * JD-Core Version:    0.7.0.1
 */