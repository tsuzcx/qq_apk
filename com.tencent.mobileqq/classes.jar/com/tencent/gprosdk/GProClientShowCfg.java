package com.tencent.gprosdk;

public final class GProClientShowCfg
{
  final boolean mShowArchives;
  final boolean mShowPresence;
  
  public GProClientShowCfg(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mShowPresence = paramBoolean1;
    this.mShowArchives = paramBoolean2;
  }
  
  public boolean getShowArchives()
  {
    return this.mShowArchives;
  }
  
  public boolean getShowPresence()
  {
    return this.mShowPresence;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProClientShowCfg{mShowPresence=");
    localStringBuilder.append(this.mShowPresence);
    localStringBuilder.append(",mShowArchives=");
    localStringBuilder.append(this.mShowArchives);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProClientShowCfg
 * JD-Core Version:    0.7.0.1
 */