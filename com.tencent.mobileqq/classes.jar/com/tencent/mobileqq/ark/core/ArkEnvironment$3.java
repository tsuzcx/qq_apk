package com.tencent.mobileqq.ark.core;

import com.tencent.ark.ArkEnvironmentManager.LibraryLoader;

final class ArkEnvironment$3
  implements ArkEnvironmentManager.LibraryLoader
{
  public boolean Load()
  {
    ArkEnvironment.a();
    return ArkEnvironment.b;
  }
  
  public boolean isLibraryLoad()
  {
    return ArkEnvironment.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkEnvironment.3
 * JD-Core Version:    0.7.0.1
 */