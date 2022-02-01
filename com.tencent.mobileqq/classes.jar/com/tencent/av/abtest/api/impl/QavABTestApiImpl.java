package com.tencent.av.abtest.api.impl;

import com.tencent.av.abtest.api.IQavABTestApi;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class QavABTestApiImpl
  implements IQavABTestApi
{
  private static final String TAG = "QavABTestApiImpl";
  private ExpEntityInfo mCurrentExpInfo = null;
  
  public Map<String, String> getParams()
  {
    return this.mCurrentExpInfo.a();
  }
  
  public boolean isContrast()
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    return (localExpEntityInfo != null) && (localExpEntityInfo.g());
  }
  
  public boolean isExpHit(String paramString)
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    return (localExpEntityInfo != null) && (localExpEntityInfo.d(paramString));
  }
  
  public boolean isExpOnline()
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    return (localExpEntityInfo != null) && (localExpEntityInfo.i());
  }
  
  public boolean isExperiment()
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    return (localExpEntityInfo != null) && (localExpEntityInfo.f());
  }
  
  public IQavABTestApi loadExperiment(String paramString)
  {
    this.mCurrentExpInfo = ABTestController.a().a(paramString);
    Object localObject = this.mCurrentExpInfo;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((ExpEntityInfo)localObject).k();
    }
    QLog.d("QavABTestApiImpl", 1, new Object[] { "[loadExperiment] expTagName: ", paramString, " | expInfo: ", localObject });
    return this;
  }
  
  public void registerExpConfigInfo(String paramString)
  {
    ABTestController.a().c(paramString);
  }
  
  public void reportEvent(int paramInt, String paramString)
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    if (localExpEntityInfo == null) {
      return;
    }
    localExpEntityInfo.a(paramInt, paramString);
  }
  
  public void reportExpExposure()
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    if (localExpEntityInfo == null) {
      return;
    }
    localExpEntityInfo.h();
  }
  
  public void reportExposure(String paramString)
  {
    paramString = this.mCurrentExpInfo;
    if (paramString == null) {
      return;
    }
    paramString.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.abtest.api.impl.QavABTestApiImpl
 * JD-Core Version:    0.7.0.1
 */