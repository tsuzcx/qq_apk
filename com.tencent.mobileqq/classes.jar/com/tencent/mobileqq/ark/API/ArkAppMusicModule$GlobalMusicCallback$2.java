package com.tencent.mobileqq.ark.API;

import alpu;
import alpv;
import com.tencent.mobileqq.music.SongInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$2
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$2(alpv paramalpv, SongInfo paramSongInfo) {}
  
  public void run()
  {
    Iterator localIterator = alpu.a.iterator();
    while (localIterator.hasNext())
    {
      alpu localalpu = (alpu)((WeakReference)localIterator.next()).get();
      if (localalpu != null) {
        localalpu.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.2
 * JD-Core Version:    0.7.0.1
 */