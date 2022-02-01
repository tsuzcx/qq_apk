package com.tencent.luggage.scanner.qbar;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import java.util.concurrent.ExecutorService;

class LuggageScanDecodeQueue$a
  implements Runnable
{
  private long b;
  private byte[] c;
  private Point d;
  private Rect e;
  private int f;
  
  LuggageScanDecodeQueue$a(LuggageScanDecodeQueue paramLuggageScanDecodeQueue, long paramLong, byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
  {
    this.b = paramLong;
    this.c = paramArrayOfByte;
    this.d = paramPoint;
    this.f = paramInt;
    this.e = paramRect;
  }
  
  public void run()
  {
    int[] arrayOfInt = new int[2];
    synchronized (LuggageScanDecodeQueue.a(this.a))
    {
      LuggageScanDecodeQueue.a(this.a, true);
      byte[] arrayOfByte = LuggageScanDecodeQueue.a(this.a).a(this.c, this.d, this.f, this.e, arrayOfInt);
      LuggageScanDecodeQueue.a(this.a, false);
      this.c = null;
      this.d = null;
      this.e = null;
      ??? = LuggageScanDecodeQueue.b(this.a);
      if (arrayOfByte != null) {}
      try
      {
        if (this.b == LuggageScanDecodeQueue.c(this.a))
        {
          LuggageScanDecodeQueue.d(this.a).put("param_gray_data", arrayOfByte);
          LuggageScanDecodeQueue.d(this.a).put("param_out_size", new Point(arrayOfInt[0], arrayOfInt[1]));
          if (!LuggageScanDecodeQueue.e(this.a))
          {
            o.d("Luggage.WxScanDecodeQueue", "%d submit decode gray", new Object[] { Long.valueOf(LuggageScanDecodeQueue.c(this.a)) });
            if (LuggageScanDecodeQueue.f(this.a) != null) {
              LuggageScanDecodeQueue.f(this.a).execute(new LuggageScanDecodeQueue.b(this.a, this.b));
            } else {
              o.b("Luggage.WxScanDecodeQueue", "do crop gray task, but decode thread not init yet");
            }
          }
          if (LuggageScanDecodeQueue.g(this.a) != null) {
            LuggageScanDecodeQueue.g(this.a).postTakeShot(LuggageScanDecodeQueue.c(this.a), 10L);
          }
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue.a
 * JD-Core Version:    0.7.0.1
 */