package com.tencent.avgame.business.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class NetObserver
  implements BusinessObserver
{
  public void a(int paramInt1, int paramInt2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.observer.NetObserver
 * JD-Core Version:    0.7.0.1
 */