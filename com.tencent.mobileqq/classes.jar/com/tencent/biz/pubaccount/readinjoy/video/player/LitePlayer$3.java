package com.tencent.biz.pubaccount.readinjoy.video.player;

import java.util.Iterator;
import java.util.List;
import sgn;
import sgr;

public class LitePlayer$3
  implements Runnable
{
  public LitePlayer$3(sgn paramsgn) {}
  
  public void run()
  {
    Iterator localIterator = sgn.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((sgr)localIterator.next()).onVideoStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.3
 * JD-Core Version:    0.7.0.1
 */