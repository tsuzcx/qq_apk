package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class ArkAppSSO
{
  java.lang.ref.WeakReference a;
  
  public ArkAppSSO(QQAppInterface paramQQAppInterface)
  {
    this.a = new mqq.util.WeakReference(paramQQAppInterface);
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.b("ArkApp.SSO", "requestArkAppList, app is null, return false");
      return false;
    }
    return ((ArkAppHandler)localQQAppInterface.a(95)).a(paramString, paramInt1, paramInt2, paramBusinessObserver);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.b("ArkApp.SSO", "sendAppMsg, app is null, return false");
      return false;
    }
    return ((ArkAppHandler)localQQAppInterface.a(95)).a(paramString1, paramString2, paramInt1, paramInt2, paramBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppSSO
 * JD-Core Version:    0.7.0.1
 */