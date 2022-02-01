package com.tencent.mobileqq.ark.API;

import apwg;
import apwh;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$1
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$1(apwh paramapwh, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = apwg.a.iterator();
    while (localIterator.hasNext())
    {
      apwg localapwg = (apwg)((WeakReference)localIterator.next()).get();
      if (localapwg != null) {
        localapwg.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.1
 * JD-Core Version:    0.7.0.1
 */