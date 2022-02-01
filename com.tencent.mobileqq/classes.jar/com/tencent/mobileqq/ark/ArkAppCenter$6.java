package com.tencent.mobileqq.ark;

import com.tencent.ark.ArkEnvironmentManager.LibraryLoader;

final class ArkAppCenter$6
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
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCenter.6
 * JD-Core Version:    0.7.0.1
 */