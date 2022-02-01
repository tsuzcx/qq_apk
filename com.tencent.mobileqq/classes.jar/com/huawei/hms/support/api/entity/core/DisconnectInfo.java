package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

public class DisconnectInfo
  implements IMessageEntity
{
  @Packed
  public List<String> apiNameList;
  @Packed
  public List<Scope> scopeList;
  
  public DisconnectInfo() {}
  
  public DisconnectInfo(List<Scope> paramList, List<String> paramList1)
  {
    this.scopeList = paramList;
    this.apiNameList = paramList1;
  }
  
  public List<String> getApiNameList()
  {
    return this.apiNameList;
  }
  
  public List<Scope> getScopeList()
  {
    return this.scopeList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.core.DisconnectInfo
 * JD-Core Version:    0.7.0.1
 */