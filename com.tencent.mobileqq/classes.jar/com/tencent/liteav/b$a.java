package com.tencent.liteav;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

class b$a
  extends Handler
{
  private int b = 300;
  private long c = 0L;
  
  public b$a(b paramb, Looper paramLooper, int paramInt, long paramLong)
  {
    super(paramLooper);
    this.b = paramInt;
    this.c = paramLong;
    paramb = b.c();
    paramLooper = new StringBuilder();
    paramLooper.append("bkgpush:init publish time delay:");
    paramLooper.append(this.b);
    paramLooper.append(", end:");
    paramLooper.append(this.c);
    TXCLog.w(paramb, paramLooper.toString());
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001) {
      try
      {
        b.a(this.a);
        if ((this.c >= 0L) && (System.currentTimeMillis() >= this.c))
        {
          TXCLog.w(b.c(), "bkgpush:stop background publish when timeout");
          if ((b.b(this.a) != null) && (b.c(this.a)))
          {
            paramMessage = (b.b)b.b(this.a).get();
            if (paramMessage != null) {
              paramMessage.a();
            }
            b.a(this.a, false);
          }
        }
        else
        {
          sendEmptyMessageDelayed(1001, this.b);
          return;
        }
      }
      catch (Exception paramMessage)
      {
        String str = b.c();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("publish image failed.");
        localStringBuilder.append(paramMessage.getMessage());
        TXCLog.e(str, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.b.a
 * JD-Core Version:    0.7.0.1
 */