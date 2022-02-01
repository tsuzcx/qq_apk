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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isSuccess=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ARLBSObserver", 2, localStringBuilder.toString());
    }
    if (paramInt != 1) {
      return;
    }
    try
    {
      a((ARCloudLBSLocationCheckResult)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      label71:
      break label71;
    }
    a(new ARCloudLBSLocationCheckResult());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARLBSObserver
 * JD-Core Version:    0.7.0.1
 */