package com.tencent.avgame.gamelobby.data;

import androidx.annotation.NonNull;

public class AVGameLobbyFixedContentInfo
  extends AVGameBaseData
{
  private static boolean a = false;
  private String b;
  private int c;
  private int d;
  private int e;
  private String f;
  private String[] g;
  private int h;
  
  public AVGameLobbyFixedContentInfo(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String[] paramArrayOfString, int paramInt4)
  {
    this.b = paramString1;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramString2;
    this.g = paramArrayOfString;
    this.h = paramInt4;
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static boolean k()
  {
    return a;
  }
  
  public int a()
  {
    return this.h;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.g = paramArrayOfString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  @NonNull
  public int c()
  {
    return 4;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public String g()
  {
    return this.f;
  }
  
  public String[] h()
  {
    return this.g;
  }
  
  public int i()
  {
    return this.h;
  }
  
  public boolean j()
  {
    return this.h == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyFixedContentInfo
 * JD-Core Version:    0.7.0.1
 */