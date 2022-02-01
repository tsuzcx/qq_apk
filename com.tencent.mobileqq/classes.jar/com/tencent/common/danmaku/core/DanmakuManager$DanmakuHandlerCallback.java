package com.tencent.common.danmaku.core;

import android.os.Handler.Callback;
import android.os.Message;
import java.lang.ref.WeakReference;

class DanmakuManager$DanmakuHandlerCallback
  implements Handler.Callback
{
  private WeakReference<DanmakuManager> a;
  
  private DanmakuManager$DanmakuHandlerCallback(DanmakuManager paramDanmakuManager)
  {
    this.a = new WeakReference(paramDanmakuManager);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    DanmakuManager localDanmakuManager = (DanmakuManager)this.a.get();
    if (localDanmakuManager == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 11: 
      DanmakuManager.i(localDanmakuManager);
      return false;
    case 10: 
      DanmakuManager.h(localDanmakuManager);
      return false;
    case 9: 
      DanmakuManager.g(localDanmakuManager);
      return false;
    case 8: 
      localDanmakuManager.s();
      return false;
    case 7: 
      DanmakuManager.f(localDanmakuManager);
      return false;
    case 6: 
      DanmakuManager.e(localDanmakuManager);
      return false;
    case 5: 
      localDanmakuManager.a(paramMessage);
      return false;
    case 4: 
      localDanmakuManager.r();
      return false;
    case 3: 
      DanmakuManager.d(localDanmakuManager);
      return false;
    case 2: 
      DanmakuManager.c(localDanmakuManager);
      return false;
    }
    DanmakuManager.a(localDanmakuManager, paramMessage);
    DanmakuManager.c(localDanmakuManager);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.DanmakuManager.DanmakuHandlerCallback
 * JD-Core Version:    0.7.0.1
 */