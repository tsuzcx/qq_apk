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
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return "";
      }
      return paramContext.getString(2131887296);
    }
    return paramContext.getString(2131887297);
  }
  
  public int b()
  {
    return this.a;
  }
  
  @NonNull
  public int c()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyTitleContentInfo
 * JD-Core Version:    0.7.0.1
 */