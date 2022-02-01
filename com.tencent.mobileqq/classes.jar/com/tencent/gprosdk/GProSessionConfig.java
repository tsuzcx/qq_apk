package com.tencent.gprosdk;

public final class GProSessionConfig
{
  final String mClientVer;
  final String mDbPath;
  final long mPSqlite3;
  
  public GProSessionConfig(String paramString1, String paramString2, long paramLong)
  {
    this.mDbPath = paramString1;
    this.mClientVer = paramString2;
    this.mPSqlite3 = paramLong;
  }
  
  public String getClientVer()
  {
    return this.mClientVer;
  }
  
  public String getDbPath()
  {
    return this.mDbPath;
  }
  
  public long getPSqlite3()
  {
    return this.mPSqlite3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProSessionConfig{mDbPath=");
    localStringBuilder.append(this.mDbPath);
    localStringBuilder.append(",mClientVer=");
    localStringBuilder.append(this.mClientVer);
    localStringBuilder.append(",mPSqlite3=");
    localStringBuilder.append(this.mPSqlite3);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProSessionConfig
 * JD-Core Version:    0.7.0.1
 */