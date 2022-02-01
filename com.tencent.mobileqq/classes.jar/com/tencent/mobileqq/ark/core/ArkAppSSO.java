package com.tencent.mobileqq.ark.core;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.IArkAppSSO;
import com.tencent.mobileqq.ark.IQueryPackageNameByAppIDCallback;
import com.tencent.mobileqq.ark.base.ArkAppCenter;
import mqq.app.AppRuntime;

public class ArkAppSSO
  implements IArkAppSSO
{
  private final ArkAppCenter a;
  
  public ArkAppSSO(ArkAppCenter paramArkAppCenter)
  {
    this.a = paramArkAppCenter;
  }
  
  AppInterface a()
  {
    AppRuntime localAppRuntime = this.a.a();
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(String paramString, Object paramObject, IQueryPackageNameByAppIDCallback paramIQueryPackageNameByAppIDCallback)
  {
    this.a.a(paramString, paramObject, new ArkAppSSO.1(this, paramIQueryPackageNameByAppIDCallback));
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    AppInterface localAppInterface = a();
    if (localAppInterface != null) {
      return ((ArkAppHandler)localAppInterface.getBusinessHandler(ArkAppHandler.class.getName())).a(paramString, paramInt1, paramInt2, paramBusinessObserver);
    }
    throw new RuntimeException("no app interface");
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    AppInterface localAppInterface = a();
    if (localAppInterface != null) {
      return ((ArkAppHandler)localAppInterface.getBusinessHandler(ArkAppHandler.class.getName())).a(paramString1, paramString2, paramInt1, paramInt2, paramBusinessObserver);
    }
    throw new RuntimeException("no app interface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppSSO
 * JD-Core Version:    0.7.0.1
 */