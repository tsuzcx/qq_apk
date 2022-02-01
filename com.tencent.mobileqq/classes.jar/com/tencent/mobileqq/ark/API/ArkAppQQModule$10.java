package com.tencent.mobileqq.ark.API;

import agpq;
import apix;
import com.tencent.ark.ark;
import java.lang.ref.WeakReference;

public class ArkAppQQModule$10
  implements Runnable
{
  public ArkAppQQModule$10(apix paramapix, long paramLong) {}
  
  public void run()
  {
    agpq localagpq = (agpq)agpq.a(ark.arkGetContainer(this.a)).get();
    if (localagpq != null) {
      localagpq.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.10
 * JD-Core Version:    0.7.0.1
 */