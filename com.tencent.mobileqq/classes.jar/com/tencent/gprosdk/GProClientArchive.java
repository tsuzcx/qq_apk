package com.tencent.gprosdk;

public final class GProClientArchive
{
  final String mArchiveName;
  final int mClientId;
  final GProSmobaArchiveTemplate mTemplate1;
  final int mTemplateId;
  
  public GProClientArchive(int paramInt1, String paramString, int paramInt2, GProSmobaArchiveTemplate paramGProSmobaArchiveTemplate)
  {
    this.mClientId = paramInt1;
    this.mArchiveName = paramString;
    this.mTemplateId = paramInt2;
    this.mTemplate1 = paramGProSmobaArchiveTemplate;
  }
  
  public String getArchiveName()
  {
    return this.mArchiveName;
  }
  
  public int getClientId()
  {
    return this.mClientId;
  }
  
  public GProSmobaArchiveTemplate getTemplate1()
  {
    return this.mTemplate1;
  }
  
  public int getTemplateId()
  {
    return this.mTemplateId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProClientArchive{mClientId=");
    localStringBuilder.append(this.mClientId);
    localStringBuilder.append(",mArchiveName=");
    localStringBuilder.append(this.mArchiveName);
    localStringBuilder.append(",mTemplateId=");
    localStringBuilder.append(this.mTemplateId);
    localStringBuilder.append(",mTemplate1=");
    localStringBuilder.append(this.mTemplate1);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProClientArchive
 * JD-Core Version:    0.7.0.1
 */