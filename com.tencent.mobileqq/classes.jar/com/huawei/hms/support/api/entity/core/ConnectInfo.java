package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

public class ConnectInfo
  implements IMessageEntity
{
  @Packed
  private List<String> apiNameList;
  @Packed
  private String fingerprint;
  @Packed
  private List<Scope> scopeList;
  @Packed
  private String subAppID;
  
  public ConnectInfo() {}
  
  public ConnectInfo(List<String> paramList, List<Scope> paramList1, String paramString1, String paramString2)
  {
    this.apiNameList = paramList;
    this.scopeList = paramList1;
    this.fingerprint = paramString1;
    this.subAppID = paramString2;
  }
  
  public List<String> getApiNameList()
  {
    return this.apiNameList;
  }
  
  public String getFingerprint()
  {
    return this.fingerprint;
  }
  
  public List<Scope> getScopeList()
  {
    return this.scopeList;
  }
  
  public String getSubAppID()
  {
    return this.subAppID;
  }
  
  public void setApiNameList(List<String> paramList)
  {
    this.apiNameList = paramList;
  }
  
  public void setFingerprint(String paramString)
  {
    this.fingerprint = paramString;
  }
  
  public void setScopeList(List<Scope> paramList)
  {
    this.scopeList = paramList;
  }
  
  public void setSubAppID(String paramString)
  {
    this.subAppID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.core.ConnectInfo
 * JD-Core Version:    0.7.0.1
 */