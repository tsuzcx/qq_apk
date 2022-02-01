package com.huawei.hms.api;

import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Collections;
import java.util.List;

public abstract class Api$Options<O>
{
  public List<PermissionInfo> getPermissionInfoList(O paramO)
  {
    return Collections.emptyList();
  }
  
  public List<Scope> getScopeList(O paramO)
  {
    return Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.Api.Options
 * JD-Core Version:    0.7.0.1
 */