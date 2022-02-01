package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkAppLifeEvent;
import com.tencent.mobileqq.ark.event.ArkAppCenterEvent;
import com.tencent.mobileqq.ark.event.IArkAppLifeEventCallback;

public class ArkAppLifeEventImpl
  implements IArkAppLifeEvent
{
  public void attachEvent(String paramString1, String paramString2, IArkAppLifeEventCallback paramIArkAppLifeEventCallback)
  {
    ArkAppCenterEvent.a(paramString1, paramString2, paramIArkAppLifeEventCallback);
  }
  
  public void detachEvent(String paramString1, String paramString2)
  {
    ArkAppCenterEvent.a(paramString1, paramString2);
  }
  
  public void doAction(int paramInt, String paramString, Object paramObject)
  {
    ArkAppCenterEvent.a(paramInt, paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkAppLifeEventImpl
 * JD-Core Version:    0.7.0.1
 */