package com.tencent.mobileqq.ark.API;

import apsu;
import apsv;
import com.tencent.mobileqq.music.SongInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$2
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$2(apsv paramapsv, SongInfo paramSongInfo) {}
  
  public void run()
  {
    Iterator localIterator = apsu.a.iterator();
    while (localIterator.hasNext())
    {
      apsu localapsu = (apsu)((WeakReference)localIterator.next()).get();
      if (localapsu != null) {
        localapsu.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.2
 * JD-Core Version:    0.7.0.1
 */