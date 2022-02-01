package com.tencent.mobileqq.ark.core;

import android.os.HandlerThread;
import com.tencent.ark.ArkEnvironmentManager.ThreadCreater;
import com.tencent.mobileqq.app.ThreadManager;

final class ArkEnvironment$2
  implements ArkEnvironmentManager.ThreadCreater
{
  public HandlerThread createHandlerThread(String paramString)
  {
    return ThreadManager.newFreeHandlerThread(paramString, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkEnvironment.2
 * JD-Core Version:    0.7.0.1
 */