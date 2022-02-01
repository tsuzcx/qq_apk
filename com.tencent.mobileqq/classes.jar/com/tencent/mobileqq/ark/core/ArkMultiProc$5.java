package com.tencent.mobileqq.ark.core;

import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.base.DefaultApplicationCallback;

final class ArkMultiProc$5
  extends DefaultApplicationCallback
{
  protected boolean a(String paramString)
  {
    if (!super.a(paramString)) {
      return false;
    }
    if (ArkEnvironment.a != null) {
      return ArkEnvironment.a.shouldCheckURLDomain();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkMultiProc.5
 * JD-Core Version:    0.7.0.1
 */