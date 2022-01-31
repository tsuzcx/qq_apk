package com.tencent.mobileqq.apollo.process.sso;

import com.tencent.mobileqq.app.BusinessObserver;

public class CmGameObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      a(paramBoolean, paramObject);
      return;
    }
    b(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.sso.CmGameObserver
 * JD-Core Version:    0.7.0.1
 */