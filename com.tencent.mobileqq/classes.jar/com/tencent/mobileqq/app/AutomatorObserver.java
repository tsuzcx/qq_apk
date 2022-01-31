package com.tencent.mobileqq.app;

public class AutomatorObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b() {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      a(paramBoolean, paramObject);
      return;
    case 2: 
      b();
      return;
    case 3: 
      a(((Integer)paramObject).intValue());
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.AutomatorObserver
 * JD-Core Version:    0.7.0.1
 */