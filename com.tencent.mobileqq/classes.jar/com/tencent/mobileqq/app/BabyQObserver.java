package com.tencent.mobileqq.app;

public class BabyQObserver
  implements BusinessObserver
{
  protected void a() {}
  
  protected void a(Object paramObject) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, paramObject);
      return;
    case 2: 
      a(paramObject);
      return;
    case 3: 
      a();
      return;
    case 4: 
      b(paramBoolean, paramObject);
      return;
    }
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQObserver
 * JD-Core Version:    0.7.0.1
 */