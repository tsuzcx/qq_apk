package com.tencent.mobileqq.ark.base;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;

public class ArkLogicThread
{
  public static ArkDispatchTask a()
  {
    ArkMultiProcUtil.a();
    return ArkDispatchTask.getInstance();
  }
  
  public static void a(Runnable paramRunnable)
  {
    a().post("logicqueue", paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    a().postDelayed("logicqueue", paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.base.ArkLogicThread
 * JD-Core Version:    0.7.0.1
 */