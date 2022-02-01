package com.tencent.av.service;

import android.os.RemoteException;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class QQServiceForAV$LocationListener
  extends LBSObserver
{
  private List<IQQServiceLocationCallback> a = null;
  
  public int a()
  {
    return this.a.size();
  }
  
  public void a(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    if (paramIQQServiceLocationCallback != null) {
      this.a.add(paramIQQServiceLocationCallback);
    }
  }
  
  public void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      IQQServiceLocationCallback localIQQServiceLocationCallback = (IQQServiceLocationCallback)localIterator.next();
      try
      {
        localIQQServiceLocationCallback.a(paramBoolean, paramLBSInfo);
      }
      catch (RemoteException localRemoteException) {}
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "Call onGetUserLocation fail", localRemoteException);
      }
    }
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.LocationListener
 * JD-Core Version:    0.7.0.1
 */