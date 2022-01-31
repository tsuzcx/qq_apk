package com.tencent.mobileqq.ark.API;

import ankt;
import anku;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$1
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$1(anku paramanku, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = ankt.a.iterator();
    while (localIterator.hasNext())
    {
      ankt localankt = (ankt)((WeakReference)localIterator.next()).get();
      if (localankt != null) {
        localankt.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.1
 * JD-Core Version:    0.7.0.1
 */