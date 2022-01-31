package com.tencent.common.app;

import bfpr;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ToolRuntimePeak
  extends ToolRuntimeBase
{
  public static final String a = ToolAppRuntime.class.getSimpleName();
  
  public AppRuntime onGetSubRuntime(String paramString)
  {
    Object localObject = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if ("peak".equals(paramString)) {
      localObject = new PeakAppInterface(localBaseApplicationImpl, "peak");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "ToolRuntimePeak.onGetSubRuntime() moduleId " + paramString + " appInstance = " + localObject);
      }
      return localObject;
      if ("Photoplus.apk".equals(paramString)) {
        localObject = bfpr.a(localBaseApplicationImpl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.ToolRuntimePeak
 * JD-Core Version:    0.7.0.1
 */