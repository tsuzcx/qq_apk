package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.app.BusinessObserver;

public class EcShopObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      g(paramBoolean, paramObject);
      return;
    case 5: 
      f(paramBoolean, paramObject);
      return;
    case 4: 
      e(paramBoolean, paramObject);
      return;
    case 3: 
      d(paramBoolean, paramObject);
      return;
    case 2: 
      c(paramBoolean, paramObject);
      return;
    case 1: 
      b(paramBoolean, paramObject);
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopObserver
 * JD-Core Version:    0.7.0.1
 */