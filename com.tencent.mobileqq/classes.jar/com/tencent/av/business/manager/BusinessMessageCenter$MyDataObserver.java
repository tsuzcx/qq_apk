package com.tencent.av.business.manager;

import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class BusinessMessageCenter$MyDataObserver
  implements Observer
{
  private WeakReference<BusinessMessageCenter> a;
  
  BusinessMessageCenter$MyDataObserver(BusinessMessageCenter paramBusinessMessageCenter)
  {
    this.a = new WeakReference(paramBusinessMessageCenter);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    BusinessMessageCenter localBusinessMessageCenter = (BusinessMessageCenter)this.a.get();
    if (localBusinessMessageCenter == null) {
      return;
    }
    BusinessMessageCenter.a(localBusinessMessageCenter, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.BusinessMessageCenter.MyDataObserver
 * JD-Core Version:    0.7.0.1
 */