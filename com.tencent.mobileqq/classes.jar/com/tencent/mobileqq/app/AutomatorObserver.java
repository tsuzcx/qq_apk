package com.tencent.mobileqq.app;

public class AutomatorObserver
  implements BusinessObserver
{
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b() {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          a();
          return;
        }
        a(((Integer)paramObject).intValue());
        return;
      }
      b();
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.AutomatorObserver
 * JD-Core Version:    0.7.0.1
 */