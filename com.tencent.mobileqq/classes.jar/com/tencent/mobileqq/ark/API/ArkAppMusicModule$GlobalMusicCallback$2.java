package com.tencent.mobileqq.ark.API;

import angk;
import angl;
import com.tencent.mobileqq.music.SongInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$2
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$2(angl paramangl, SongInfo paramSongInfo) {}
  
  public void run()
  {
    Iterator localIterator = angk.a.iterator();
    while (localIterator.hasNext())
    {
      angk localangk = (angk)((WeakReference)localIterator.next()).get();
      if (localangk != null) {
        localangk.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.2
 * JD-Core Version:    0.7.0.1
 */