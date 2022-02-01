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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            a(paramBoolean);
            return;
          }
          b(paramBoolean, paramObject);
          return;
        }
        a();
        return;
      }
      a(paramObject);
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQObserver
 * JD-Core Version:    0.7.0.1
 */