package com.tencent.liteav.screencapture;

import android.media.projection.MediaProjection.Callback;
import com.tencent.liteav.basic.log.TXCLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class c$1
  extends MediaProjection.Callback
{
  c$1(c paramc) {}
  
  public void onStop()
  {
    TXCLog.e("VirtualDisplayManager", "MediaProjection session is no longer valid");
    Object localObject = new HashMap(c.a(this.a));
    c.a(this.a).clear();
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      c.a locala = (c.a)((Iterator)localObject).next();
      if (locala.d != null) {
        if (locala.e != null) {
          locala.d.a();
        } else {
          locala.d.a(false, false);
        }
      }
    }
    c.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.screencapture.c.1
 * JD-Core Version:    0.7.0.1
 */