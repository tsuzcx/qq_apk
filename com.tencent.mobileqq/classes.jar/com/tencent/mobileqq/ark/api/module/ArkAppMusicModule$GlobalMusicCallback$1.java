package com.tencent.mobileqq.ark.api.module;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class ArkAppMusicModule$GlobalMusicCallback$1
  implements Runnable
{
  ArkAppMusicModule$GlobalMusicCallback$1(ArkAppMusicModule.GlobalMusicCallback paramGlobalMusicCallback, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = ArkAppMusicModule.a.iterator();
    while (localIterator.hasNext())
    {
      ArkAppMusicModule localArkAppMusicModule = (ArkAppMusicModule)((WeakReference)localIterator.next()).get();
      if (localArkAppMusicModule != null) {
        localArkAppMusicModule.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppMusicModule.GlobalMusicCallback.1
 * JD-Core Version:    0.7.0.1
 */