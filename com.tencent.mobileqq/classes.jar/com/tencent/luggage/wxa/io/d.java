package com.tencent.luggage.wxa.io;

import android.os.Handler;
import android.os.Message;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.a;

public final class d
  extends Handler
{
  private final WheelView a;
  
  public d(WheelView paramWheelView)
  {
    this.a = paramWheelView;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1000)
    {
      if (i != 2000)
      {
        if (i != 3000) {
          return;
        }
        this.a.b();
        return;
      }
      this.a.a(WheelView.a.b);
      return;
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.io.d
 * JD-Core Version:    0.7.0.1
 */