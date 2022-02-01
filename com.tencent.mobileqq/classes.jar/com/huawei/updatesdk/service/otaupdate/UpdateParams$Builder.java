package com.huawei.updatesdk.service.otaupdate;

import java.util.List;

public final class UpdateParams$Builder
{
  private String appStorePkgName = "com.huawei.appmarket";
  private boolean isShowImmediate;
  private int minIntervalDay;
  private boolean mustBtnOne;
  private List<String> packageList;
  private String serviceZone;
  private String targetPkgName;
  
  public UpdateParams build()
  {
    return new UpdateParams(this, null);
  }
  
  public Builder setAppStorePkgName(String paramString)
  {
    this.appStorePkgName = paramString;
    return this;
  }
  
  public Builder setIsShowImmediate(boolean paramBoolean)
  {
    this.isShowImmediate = paramBoolean;
    return this;
  }
  
  public Builder setMinIntervalDay(int paramInt)
  {
    this.minIntervalDay = paramInt;
    return this;
  }
  
  public Builder setMustBtnOne(boolean paramBoolean)
  {
    this.mustBtnOne = paramBoolean;
    return this;
  }
  
  public Builder setPackageList(List<String> paramList)
  {
    this.packageList = paramList;
    return this;
  }
  
  public Builder setServiceZone(String paramString)
  {
    this.serviceZone = paramString;
    return this;
  }
  
  public Builder setTargetPkgName(String paramString)
  {
    this.targetPkgName = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.UpdateParams.Builder
 * JD-Core Version:    0.7.0.1
 */