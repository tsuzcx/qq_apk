package com.huawei.hms.support.api.client;

import com.huawei.hms.core.aidl.d;
import java.util.List;

public abstract interface AidlApiClient
  extends ApiClient
{
  public abstract List<String> getApiNameList();
  
  public abstract d getService();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.client.AidlApiClient
 * JD-Core Version:    0.7.0.1
 */