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
    if (QLog.isColorLevel()) {
      QLog.d("AIODrawerDpc", 2, "onDpcPullFinished, hasChanged = " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.AIODrawerDpc.1
 * JD-Core Version:    0.7.0.1
 */