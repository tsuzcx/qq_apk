package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult;
import com.tencent.qphone.base.util.QLog;

public abstract class ARLBSObserver
  implements BusinessObserver
{
  public abstract void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult);
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARLBSObserver", 2, "type=" + paramInt + ", isSuccess=" + paramBoolean);
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    try
    {
      a((ARCloudLBSLocationCheckResult)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      a(new ARCloudLBSLocationCheckResult());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARLBSObserver
 * JD-Core Version:    0.7.0.1
 */