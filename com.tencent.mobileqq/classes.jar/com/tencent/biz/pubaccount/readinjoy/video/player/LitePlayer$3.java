package com.tencent.biz.pubaccount.readinjoy.video.player;

import java.util.Iterator;
import java.util.List;
import sss;
import ssw;

public class LitePlayer$3
  implements Runnable
{
  public LitePlayer$3(sss paramsss) {}
  
  public void run()
  {
    Iterator localIterator = sss.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((ssw)localIterator.next()).onVideoStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.3
 * JD-Core Version:    0.7.0.1
 */