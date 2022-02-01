package com.tencent.dbfix;

public class DBCheckResultItem
{
  public final String description;
  public final int errCode;
  
  public DBCheckResultItem(String paramString, int paramInt)
  {
    this.description = paramString;
    this.errCode = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DBIntegrityCheckResultItem{description='");
    localStringBuilder.append(this.description);
    localStringBuilder.append('\'');
    localStringBuilder.append(", errCode=");
    localStringBuilder.append(this.errCode);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.dbfix.DBCheckResultItem
 * JD-Core Version:    0.7.0.1
 */