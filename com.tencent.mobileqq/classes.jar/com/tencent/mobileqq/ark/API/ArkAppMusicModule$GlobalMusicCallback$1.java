package com.tencent.mobileqq.ark.API;

import albg;
import albh;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$1
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$1(albh paramalbh, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = albg.a.iterator();
    while (localIterator.hasNext())
    {
      albg localalbg = (albg)((WeakReference)localIterator.next()).get();
      if (localalbg != null) {
        localalbg.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.1
 * JD-Core Version:    0.7.0.1
 */