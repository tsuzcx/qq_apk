package com.tencent.mobileqq.app;

public class QvipSpecialCareObserver
  implements BusinessObserver
{
  public void a(Object paramObject) {}
  
  public void b(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1000: 
      a(paramObject);
      return;
    }
    b(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QvipSpecialCareObserver
 * JD-Core Version:    0.7.0.1
 */