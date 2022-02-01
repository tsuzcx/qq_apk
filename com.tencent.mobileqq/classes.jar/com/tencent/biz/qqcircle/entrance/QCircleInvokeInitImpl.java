package com.tencent.biz.qqcircle.entrance;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.proxy.QCircleInvokeModule;

public class QCircleInvokeInitImpl
  implements QCircleInvokeModule
{
  public void invoke(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if (paramInt2 == 1)
    {
      QLog.d("QCircleInvokeInitImpl", 1, "init_by_vsnetwork_helper");
      RFThreadManager.getSerialThreadHandler().postDelayed(new QCircleInvokeInitImpl.1(this), 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.entrance.QCircleInvokeInitImpl
 * JD-Core Version:    0.7.0.1
 */