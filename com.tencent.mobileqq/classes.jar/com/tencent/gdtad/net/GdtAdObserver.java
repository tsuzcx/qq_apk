package com.tencent.gdtad.net;

import com.tencent.mobileqq.app.BusinessObserver;

public class GdtAdObserver
  implements BusinessObserver
{
  public void a(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.net.GdtAdObserver
 * JD-Core Version:    0.7.0.1
 */