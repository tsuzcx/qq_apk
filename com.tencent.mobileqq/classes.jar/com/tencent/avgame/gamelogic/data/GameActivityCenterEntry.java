package com.tencent.avgame.gamelogic.data;

import android.text.TextUtils;

public class GameActivityCenterEntry
{
  public int a = 0;
  public String b = null;
  public String c = null;
  
  public boolean a()
  {
    return TextUtils.isEmpty(this.c) ^ true;
  }
  
  public boolean b()
  {
    return (a()) && (this.a == 1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{redPoint: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", iconUrl: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", jumpUrl: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.GameActivityCenterEntry
 * JD-Core Version:    0.7.0.1
 */