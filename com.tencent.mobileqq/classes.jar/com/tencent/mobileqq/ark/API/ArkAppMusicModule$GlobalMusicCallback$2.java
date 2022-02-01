package com.tencent.mobileqq.ark.API;

import apiq;
import apir;
import com.tencent.mobileqq.music.SongInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$2
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$2(apir paramapir, SongInfo paramSongInfo) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.2
 * JD-Core Version:    0.7.0.1
 */