package com.tencent.mobileqq.ark.multiproc;

import com.tencent.ark.ArkEnvironmentManager.LibraryLoader;
import com.tencent.mobileqq.ark.ArkAppCenter;

final class ArkMultiProcUtil$3
  implements ArkEnvironmentManager.LibraryLoader
{
  public boolean Load()
  {
    ArkAppCenter.f();
    return ArkAppCenter.b;
  }
  
  public boolean isLibraryLoad()
  {
    return ArkAppCenter.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil.3
 * JD-Core Version:    0.7.0.1
 */