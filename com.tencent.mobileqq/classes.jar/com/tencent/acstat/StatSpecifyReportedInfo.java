package com.tencent.acstat;

public class StatSpecifyReportedInfo
{
  private String a = null;
  private String b = null;
  private String c = null;
  private boolean d = false;
  private boolean e = false;
  
  public String getAppKey()
  {
    return this.a;
  }
  
  public String getInstallChannel()
  {
    return this.b;
  }
  
  public String getVersion()
  {
    return this.c;
  }
  
  public boolean isImportant()
  {
    return this.e;
  }
  
  public boolean isSendImmediately()
  {
    return this.d;
  }
  
  public void setAppKey(String paramString)
  {
    this.a = paramString;
  }
  
  public void setImportant(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setInstallChannel(String paramString)
  {
    this.b = paramString;
  }
  
  public void setSendImmediately(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setVersion(String paramString)
  {
    this.c = paramString;
  }
  
  public String toString()
  {
    return "StatSpecifyReportedInfo [appKey=" + this.a + ", installChannel=" + this.b + ", version=" + this.c + ", sendImmediately=" + this.d + ", isImportant=" + this.e + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.StatSpecifyReportedInfo
 * JD-Core Version:    0.7.0.1
 */