package com.tencent.mobileqq.ark.API;

import albg;
import albh;
import com.tencent.mobileqq.music.SongInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkAppMusicModule$GlobalMusicCallback$2
  implements Runnable
{
  public ArkAppMusicModule$GlobalMusicCallback$2(albh paramalbh, SongInfo paramSongInfo) {}
  
  public void run()
  {
    Iterator localIterator = albg.a.iterator();
    while (localIterator.hasNext())
    {
      albg localalbg = (albg)((WeakReference)localIterator.next()).get();
      if (localalbg != null) {
        localalbg.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.2
 * JD-Core Version:    0.7.0.1
 */