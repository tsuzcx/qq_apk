package com.tencent.mobileqq.ark.API;

import apiq;
import apir;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$1
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$1(apir paramapir, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = apiq.a.iterator();
    while (localIterator.hasNext())
    {
      apiq localapiq = (apiq)((WeakReference)localIterator.next()).get();
      if (localapiq != null) {
        localapiq.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.1
 * JD-Core Version:    0.7.0.1
 */