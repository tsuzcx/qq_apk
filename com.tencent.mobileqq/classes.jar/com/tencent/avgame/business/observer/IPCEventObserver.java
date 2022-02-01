package com.tencent.avgame.business.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class IPCEventObserver
  implements BusinessObserver
{
  public void a(int paramInt, boolean paramBoolean, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (((paramObject instanceof String)) || (paramObject == null)) {
      a(paramInt, paramBoolean, (String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.business.observer.IPCEventObserver
 * JD-Core Version:    0.7.0.1
 */