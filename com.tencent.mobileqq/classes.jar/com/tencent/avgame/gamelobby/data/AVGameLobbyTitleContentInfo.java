package com.tencent.avgame.gamelobby.data;

import android.content.Context;
import androidx.annotation.NonNull;

public class AVGameLobbyTitleContentInfo
  extends AVGameBaseData
{
  private int a;
  private int b;
  
  public AVGameLobbyTitleContentInfo(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.a = paramInt2;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public String a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return paramContext.getString(2131690462);
    }
    return paramContext.getString(2131690461);
  }
  
  @NonNull
  public int b()
  {
    return 6;
  }
  
  public int c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyTitleContentInfo
 * JD-Core Version:    0.7.0.1
 */