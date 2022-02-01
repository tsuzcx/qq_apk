package com.huawei.updatesdk.service.otaupdate;

import java.util.List;

public class UpdateParams
{
  private String appStorePkgName = "com.huawei.appmarket";
  private boolean isShowImmediate = false;
  private int minIntervalDay = 0;
  private boolean mustBtnOne = false;
  private List<String> packageList;
  private String serviceZone;
  private String targetPkgName;
  
  private UpdateParams(UpdateParams.Builder paramBuilder)
  {
    this.serviceZone = UpdateParams.Builder.access$000(paramBuilder);
    this.appStorePkgName = UpdateParams.Builder.access$100(paramBuilder);
    this.targetPkgName = UpdateParams.Builder.access$200(paramBuilder);
    this.isShowImmediate = UpdateParams.Builder.access$300(paramBuilder);
    this.minIntervalDay = UpdateParams.Builder.access$400(paramBuilder);
    this.mustBtnOne = UpdateParams.Builder.access$500(paramBuilder);
    this.packageList = UpdateParams.Builder.access$600(paramBuilder);
  }
  
  public String getAppStorePkgName()
  {
    return this.appStorePkgName;
  }
  
  public int getMinIntervalDay()
  {
    return this.minIntervalDay;
  }
  
  public List<String> getPackageList()
  {
    return this.packageList;
  }
  
  public String getServiceZone()
  {
    return this.serviceZone;
  }
  
  public String getTargetPkgName()
  {
    return this.targetPkgName;
  }
  
  public boolean isMustBtnOne()
  {
    return this.mustBtnOne;
  }
  
  public boolean isShowImmediate()
  {
    return this.isShowImmediate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.UpdateParams
 * JD-Core Version:    0.7.0.1
 */