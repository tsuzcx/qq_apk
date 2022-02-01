package com.tencent.ark;

class ArkPerfMonitor$PerfRecordKey
{
  public final String appID;
  public final String view;
  
  ArkPerfMonitor$PerfRecordKey(String paramString1, String paramString2)
  {
    this.appID = paramString1;
    this.view = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (PerfRecordKey)paramObject;
      if ((this.appID.equals(paramObject.appID)) && (this.view.equals(paramObject.view))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.appID.hashCode() + this.view.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkPerfMonitor.PerfRecordKey
 * JD-Core Version:    0.7.0.1
 */