package com.tencent.mobileqq.ark.multiproc;

import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ArkMultiProcUtil
{
  public static void a()
  {
    QLog.i("ArkApp.ArkMultiProcUtil", 1, "initArkEnv");
    ((IArkEnvironment)QRoute.api(IArkEnvironment.class)).initMultiProcEnv((IArkEnvDelegate)QRoute.api(IArkEnvDelegate.class));
  }
  
  @Deprecated
  public static void a(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil
 * JD-Core Version:    0.7.0.1
 */