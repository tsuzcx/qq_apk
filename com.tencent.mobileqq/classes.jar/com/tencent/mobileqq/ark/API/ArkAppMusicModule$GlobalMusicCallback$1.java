package com.tencent.mobileqq.ark.API;

import aopt;
import aopu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$1
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$1(aopu paramaopu, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = aopt.a.iterator();
    while (localIterator.hasNext())
    {
      aopt localaopt = (aopt)((WeakReference)localIterator.next()).get();
      if (localaopt != null) {
        localaopt.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.1
 * JD-Core Version:    0.7.0.1
 */