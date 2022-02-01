package com.tencent.ark;

final class ArkEnvironmentManager$LoadLibraryTask
  implements Runnable
{
  public void run()
  {
    ArkEnvironmentManager.getInstance().loadLibraryImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkEnvironmentManager.LoadLibraryTask
 * JD-Core Version:    0.7.0.1
 */