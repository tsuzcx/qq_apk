package com.tencent.mobileqq.app.readinjoy;

import com.tencent.mobileqq.app.BusinessObserver;

public class ReadInJoyObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramObject == null);
      if (!paramBoolean) {
        break;
      }
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 2);
    a(true, ((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue());
    return;
    a(false, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.readinjoy.ReadInJoyObserver
 * JD-Core Version:    0.7.0.1
 */