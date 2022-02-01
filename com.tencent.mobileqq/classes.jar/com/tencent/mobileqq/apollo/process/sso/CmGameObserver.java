package com.tencent.mobileqq.apollo.process.sso;

import com.tencent.mobileqq.app.BusinessObserver;

public class CmGameObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      a(paramBoolean, paramObject);
      return;
    case 1: 
      b(paramBoolean, paramObject);
      return;
    }
    c(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.sso.CmGameObserver
 * JD-Core Version:    0.7.0.1
 */