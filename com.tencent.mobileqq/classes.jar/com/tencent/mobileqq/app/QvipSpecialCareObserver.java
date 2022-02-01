package com.tencent.mobileqq.app;

public class QvipSpecialCareObserver
  implements BusinessObserver
{
  public void a(Object paramObject) {}
  
  public void b(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1000)
    {
      if (paramInt != 1001) {
        return;
      }
      b(paramObject);
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QvipSpecialCareObserver
 * JD-Core Version:    0.7.0.1
 */