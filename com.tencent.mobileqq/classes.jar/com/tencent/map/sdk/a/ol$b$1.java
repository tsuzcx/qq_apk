package com.tencent.map.sdk.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Set;

final class ol$b$1
  extends Handler
{
  ol$b$1(ol.b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    ol.b.a locala;
    if ((paramMessage.obj instanceof ol.b.a))
    {
      locala = (ol.b.a)paramMessage.obj;
      if (locala.b != null) {
        locala.e = locala.b.a(locala.c);
      }
      os.a("DispatchUtil").a();
      if (locala.e != null)
      {
        ol.b.a(this.a).add(locala);
        if (locala.h == null) {
          break label96;
        }
      }
    }
    label96:
    for (Handler localHandler = locala.h;; localHandler = ol.a())
    {
      locala.a(paramMessage, localHandler, 0L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.ol.b.1
 * JD-Core Version:    0.7.0.1
 */