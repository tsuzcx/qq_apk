package com.tencent.mobileqq.app;

public class SignatureObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
  public void d(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 7: 
      a(paramBoolean, paramObject);
      return;
    case 5: 
      b(paramBoolean, paramObject);
      return;
    case 6: 
      d(paramBoolean, paramObject);
      return;
    }
    c(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureObserver
 * JD-Core Version:    0.7.0.1
 */