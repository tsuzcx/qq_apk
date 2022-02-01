package com.tencent.mm.appbrand.v8;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.eclipsesource.mmv8.V8ScriptException;
import java.util.concurrent.BlockingDeque;

class h$a
  extends Handler
{
  h$a(h paramh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    try
    {
      super.dispatchMessage(paramMessage);
    }
    catch (V8ScriptException paramMessage)
    {
      h.a(this.a, paramMessage);
    }
    if (h.a(this.a).a) {
      h.a(this.a).b.pollFirst();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h.a
 * JD-Core Version:    0.7.0.1
 */