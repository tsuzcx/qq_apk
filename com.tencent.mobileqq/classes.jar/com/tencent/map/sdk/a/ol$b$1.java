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
    if ((paramMessage.obj instanceof ol.b.a))
    {
      ol.b.a locala = (ol.b.a)paramMessage.obj;
      if (locala.b != null) {
        locala.e = locala.b.a(locala.c);
      }
      os.a("DispatchUtil").a();
      if (locala.e != null)
      {
        ol.b.a(this.a).add(locala);
        Handler localHandler;
        if (locala.h != null) {
          localHandler = locala.h;
        } else {
          localHandler = ol.a();
        }
        locala.a(paramMessage, localHandler, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ol.b.1
 * JD-Core Version:    0.7.0.1
 */