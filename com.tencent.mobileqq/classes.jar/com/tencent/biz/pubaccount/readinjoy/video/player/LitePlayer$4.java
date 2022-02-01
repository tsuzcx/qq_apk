package com.tencent.biz.pubaccount.readinjoy.video.player;

import java.util.Iterator;
import java.util.List;
import rzj;
import rzn;

public class LitePlayer$4
  implements Runnable
{
  public LitePlayer$4(rzj paramrzj) {}
  
  public void run()
  {
    Iterator localIterator = rzj.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((rzn)localIterator.next()).onVideoPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.4
 * JD-Core Version:    0.7.0.1
 */