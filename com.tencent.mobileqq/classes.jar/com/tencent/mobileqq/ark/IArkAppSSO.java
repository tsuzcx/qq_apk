package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.BusinessObserver;

public abstract interface IArkAppSSO
{
  public abstract void a(String paramString, Object paramObject, IQueryPackageNameByAppIDCallback paramIQueryPackageNameByAppIDCallback);
  
  public abstract boolean a(String paramString, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver);
  
  public abstract boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.IArkAppSSO
 * JD-Core Version:    0.7.0.1
 */