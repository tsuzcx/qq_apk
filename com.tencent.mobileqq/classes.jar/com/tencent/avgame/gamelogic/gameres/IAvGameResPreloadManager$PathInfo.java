package com.tencent.avgame.gamelogic.gameres;

public class IAvGameResPreloadManager$PathInfo
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mediaResPath: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("voiceRecogSoResPath: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", voiceRecogModelResPath: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\nvoiceRecogAILabSoResPath: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", voiceRecogAILabModelResPath: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.IAvGameResPreloadManager.PathInfo
 * JD-Core Version:    0.7.0.1
 */