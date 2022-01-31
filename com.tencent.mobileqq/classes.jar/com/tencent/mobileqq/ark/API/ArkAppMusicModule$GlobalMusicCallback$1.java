package com.tencent.mobileqq.ark.API;

import alpt;
import alpu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$1
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$1(alpu paramalpu, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = alpt.a.iterator();
    while (localIterator.hasNext())
    {
      alpt localalpt = (alpt)((WeakReference)localIterator.next()).get();
      if (localalpt != null) {
        localalpt.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.1
 * JD-Core Version:    0.7.0.1
 */