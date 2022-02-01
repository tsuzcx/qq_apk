package com.tencent.mars.ilink.xlog;

import android.os.Handler;
import android.os.Looper;

final class Log$1
  implements Log.LogImp
{
  private Handler handler = new Handler(Looper.getMainLooper());
  
  public void appenderClose() {}
  
  public void appenderFlush(boolean paramBoolean) {}
  
  public int getLogLevel()
  {
    return Log.access$000();
  }
  
  public void logD(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    if (Log.access$000() <= 1) {
      android.util.Log.d(paramString1, paramString4);
    }
  }
  
  public void logE(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    if (Log.access$000() <= 4) {
      android.util.Log.e(paramString1, paramString4);
    }
  }
  
  public void logF(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    if (Log.access$000() > 5) {
      return;
    }
    android.util.Log.e(paramString1, paramString4);
    if (Log.toastSupportContext != null) {
      this.handler.post(new Log.1.1(this, paramString4));
    }
  }
  
  public void logI(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    if (Log.access$000() <= 2) {
      android.util.Log.i(paramString1, paramString4);
    }
  }
  
  public void logV(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    if (Log.access$000() <= 0) {
      android.util.Log.v(paramString1, paramString4);
    }
  }
  
  public void logW(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    if (Log.access$000() <= 3) {
      android.util.Log.w(paramString1, paramString4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.ilink.xlog.Log.1
 * JD-Core Version:    0.7.0.1
 */