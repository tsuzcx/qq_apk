package com.tencent.mobileqq.app;

public class SignatureObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject) {}
  
  protected void h(boolean paramBoolean, Object paramObject) {}
  
  protected void i(boolean paramBoolean, Object paramObject) {}
  
  protected void j(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 13: 
      j(paramBoolean, paramObject);
      return;
    case 12: 
      i(paramBoolean, paramObject);
      return;
    case 11: 
      h(paramBoolean, paramObject);
      return;
    case 10: 
      g(paramBoolean, paramObject);
      return;
    case 9: 
      f(paramBoolean, paramObject);
      return;
    case 8: 
      e(paramBoolean, paramObject);
      return;
    case 7: 
      b(paramBoolean, paramObject);
      return;
    case 6: 
      a(paramBoolean, paramObject);
      return;
    case 5: 
      c(paramBoolean, paramObject);
      return;
    }
    d(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureObserver
 * JD-Core Version:    0.7.0.1
 */