package com.tencent.common.app;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.MSFInterfaceAdapter;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MSFInterfaceAdapterImpl
  extends MSFInterfaceAdapter
{
  public void clearStartupPatchFailCount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFInterfaceAdapterImpl", 2, "clearStartupPatchFailCount");
    }
    ThreadManager.getSubThreadHandler().post(new MSFInterfaceAdapterImpl.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.MSFInterfaceAdapterImpl
 * JD-Core Version:    0.7.0.1
 */