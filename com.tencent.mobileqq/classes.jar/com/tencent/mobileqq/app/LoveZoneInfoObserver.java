package com.tencent.mobileqq.app;

public class LoveZoneInfoObserver
  implements BusinessObserver
{
  public void a(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      a(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.LoveZoneInfoObserver
 * JD-Core Version:    0.7.0.1
 */