package com.tencent.common.danmaku.core;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.WindowConfig;
import com.tencent.common.danmaku.render.BaseDanmakuRender;
import com.tencent.common.danmaku.util.ContentSize;
import com.tencent.common.danmaku.util.DanmakuUncaughtExceptionHandler;
import com.tencent.common.danmaku.util.DanmakuUtils;
import com.tencent.common.danmaku.util.Logger;
import java.util.List;

public class DanmakuMeasureManager
{
  private HandlerThread a;
  private Handler b;
  private DanmakuContext c;
  
  public DanmakuMeasureManager(DanmakuContext paramDanmakuContext)
  {
    this.c = paramDanmakuContext;
  }
  
  public static void a(DanmakuContext paramDanmakuContext, BaseDanmaku paramBaseDanmaku)
  {
    if (paramBaseDanmaku.n()) {
      return;
    }
    paramDanmakuContext = paramDanmakuContext.a(paramBaseDanmaku).b(paramBaseDanmaku);
    paramBaseDanmaku.d(paramDanmakuContext.a() + DanmakuContext.a().l() * 2);
    paramBaseDanmaku.e(paramDanmakuContext.b() + DanmakuContext.a().d() * 2);
    paramBaseDanmaku.o();
  }
  
  private Handler b()
  {
    HandlerThread localHandlerThread = this.a;
    if ((localHandlerThread == null) || (!localHandlerThread.isAlive())) {
      try
      {
        this.a = new HandlerThread("DanmakuMeasureThread");
        this.a.start();
        this.a.setUncaughtExceptionHandler(new DanmakuUncaughtExceptionHandler());
        this.b = new Handler(this.a.getLooper());
      }
      catch (Throwable localThrowable)
      {
        Logger.d("DanmakuMeasureManager", new Object[] { localThrowable });
      }
    }
    return this.b;
  }
  
  public void a()
  {
    HandlerThread localHandlerThread = this.a;
    if (localHandlerThread != null)
    {
      if (!localHandlerThread.isAlive()) {
        return;
      }
      if (DanmakuUtils.a())
      {
        this.a.quitSafely();
        return;
      }
      this.a.quit();
    }
  }
  
  public void a(BaseDanmaku paramBaseDanmaku, DanmakuMeasureManager.IMeasureCallback paramIMeasureCallback)
  {
    Handler localHandler = b();
    if (localHandler != null) {
      localHandler.post(new DanmakuMeasureManager.1(this, paramBaseDanmaku, paramIMeasureCallback));
    }
  }
  
  public void a(List<BaseDanmaku> paramList, DanmakuMeasureManager.IMeasureCallback paramIMeasureCallback)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Handler localHandler = b();
      if (localHandler != null) {
        localHandler.post(new DanmakuMeasureManager.2(this, paramList, paramIMeasureCallback));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.DanmakuMeasureManager
 * JD-Core Version:    0.7.0.1
 */