package com.tencent.av.ui.funchat.zimu;

import android.os.Handler;
import android.os.Message;
import com.tencent.av.AVLog;
import java.lang.ref.WeakReference;

class ZimuItemViewFilm$myHander
  extends Handler
{
  final String a;
  WeakReference<ZimuItemViewFilm> b;
  
  ZimuItemViewFilm$myHander(String paramString, ZimuItemViewFilm paramZimuItemViewFilm)
  {
    this.a = paramString;
    this.b = new WeakReference(paramZimuItemViewFilm);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ZimuItemViewFilm localZimuItemViewFilm = (ZimuItemViewFilm)this.b.get();
    if (localZimuItemViewFilm != null)
    {
      if (paramMessage.what != 0) {
        return;
      }
      ZimuItemViewFilm.a(localZimuItemViewFilm);
      AVLog.printColorLog(this.a, "ITEM_DISPEAR");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuItemViewFilm.myHander
 * JD-Core Version:    0.7.0.1
 */