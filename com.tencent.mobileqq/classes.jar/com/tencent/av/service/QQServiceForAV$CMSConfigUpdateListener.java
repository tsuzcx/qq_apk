package com.tencent.av.service;

import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import java.lang.ref.WeakReference;

class QQServiceForAV$CMSConfigUpdateListener
  implements ConditionSearchManager.IConfigListener
{
  private WeakReference<QQServiceForAV.QQServiceForAVBinder> a = null;
  private WeakReference<ConditionSearchManager> b = null;
  private WeakReference<IQQServiceLocationCallback> c = null;
  
  public QQServiceForAV$CMSConfigUpdateListener(QQServiceForAV.QQServiceForAVBinder paramQQServiceForAVBinder, ConditionSearchManager paramConditionSearchManager, IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    this.a = new WeakReference(paramQQServiceForAVBinder);
    this.b = new WeakReference(paramConditionSearchManager);
    this.c = new WeakReference(paramIQQServiceLocationCallback);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ConditionSearchManager)this.b.get();
    if (localObject != null) {
      ((ConditionSearchManager)localObject).d(this);
    }
    localObject = (QQServiceForAV.QQServiceForAVBinder)this.a.get();
    IQQServiceLocationCallback localIQQServiceLocationCallback = (IQQServiceLocationCallback)this.c.get();
    if ((localObject != null) && (localIQQServiceLocationCallback != null)) {
      ((QQServiceForAV.QQServiceForAVBinder)localObject).a(paramBoolean, localIQQServiceLocationCallback);
    }
  }
  
  public void a(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    this.c = new WeakReference(paramIQQServiceLocationCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.CMSConfigUpdateListener
 * JD-Core Version:    0.7.0.1
 */