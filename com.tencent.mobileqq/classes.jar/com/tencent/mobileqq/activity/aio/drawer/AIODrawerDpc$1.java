package com.tencent.mobileqq.activity.aio.drawer;

import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.qphone.base.util.QLog;

final class AIODrawerDpc$1
  implements DPCObserver
{
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean) {
      AIODrawerDpc.a(true);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDpcPullFinished, hasChanged = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AIODrawerDpc", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.AIODrawerDpc.1
 * JD-Core Version:    0.7.0.1
 */