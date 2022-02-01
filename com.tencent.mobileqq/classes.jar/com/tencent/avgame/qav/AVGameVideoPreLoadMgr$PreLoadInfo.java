package com.tencent.avgame.qav;

class AVGameVideoPreLoadMgr$PreLoadInfo
{
  public int a;
  public String b;
  
  public AVGameVideoPreLoadMgr$PreLoadInfo(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTaskId[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], mUrl[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameVideoPreLoadMgr.PreLoadInfo
 * JD-Core Version:    0.7.0.1
 */