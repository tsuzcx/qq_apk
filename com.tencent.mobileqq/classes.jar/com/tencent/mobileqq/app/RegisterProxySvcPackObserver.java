package com.tencent.mobileqq.app;

public class RegisterProxySvcPackObserver
  implements BusinessObserver
{
  protected void a(int paramInt) {}
  
  protected void a(int paramInt1, int paramInt2) {}
  
  protected void b(int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        if (paramObject != null)
        {
          paramObject = (Object[])paramObject;
          if (paramObject.length >= 1) {
            a(((Integer)paramObject[0]).intValue());
          }
        }
      }
      else if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 1) {
          b(((Integer)paramObject[0]).intValue());
        }
      }
    }
    else if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RegisterProxySvcPackObserver
 * JD-Core Version:    0.7.0.1
 */