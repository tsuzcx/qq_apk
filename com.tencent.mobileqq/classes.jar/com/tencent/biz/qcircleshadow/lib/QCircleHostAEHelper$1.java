package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.qcircle.tempapi.interfaces.IAEKitResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.TAVCut.Callback;

final class QCircleHostAEHelper$1
  implements TAVCut.Callback
{
  QCircleHostAEHelper$1(IAEKitResult paramIAEKitResult) {}
  
  public void onDone(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[upload2]TAVCut init ret code = ");
    localStringBuilder.append(paramInt);
    QLog.d("QCircleHostAEHelper", 1, localStringBuilder.toString());
    this.val$callback.onDone(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostAEHelper.1
 * JD-Core Version:    0.7.0.1
 */