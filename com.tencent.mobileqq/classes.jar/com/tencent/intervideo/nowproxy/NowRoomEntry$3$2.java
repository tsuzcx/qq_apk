package com.tencent.intervideo.nowproxy;

import java.util.ArrayList;
import java.util.Iterator;

class NowRoomEntry$3$2
  implements Runnable
{
  NowRoomEntry$3$2(NowRoomEntry.3 param3) {}
  
  public void run()
  {
    Iterator localIterator = Global.getPluginObservers().iterator();
    while (localIterator.hasNext()) {
      ((NowPluginObserver)localIterator.next()).onCloseLoadingView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.NowRoomEntry.3.2
 * JD-Core Version:    0.7.0.1
 */