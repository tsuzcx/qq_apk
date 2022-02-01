package com.tencent.common.danmaku.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.WindowConfig;
import com.tencent.common.danmaku.render.BaseDanmakuRender;
import com.tencent.common.danmaku.tool.BitmapCacheManager;
import com.tencent.common.danmaku.util.DanmakuUtils;

public class CacheDrawManager
{
  private final BitmapCacheManager a = new BitmapCacheManager();
  private HandlerThread b;
  
  public void a()
  {
    HandlerThread localHandlerThread = this.b;
    if (localHandlerThread != null)
    {
      if (!localHandlerThread.isAlive()) {
        return;
      }
      if (DanmakuUtils.a())
      {
        this.b.quitSafely();
        return;
      }
      this.b.quit();
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.a.a(paramBitmap);
  }
  
  public void a(BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext) {}
  
  public int b()
  {
    return this.a.b();
  }
  
  public Bitmap b(BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext)
  {
    if (paramBaseDanmaku != null) {
      try
      {
        if (paramBaseDanmaku.L())
        {
          Object localObject2 = paramBaseDanmaku.K();
          Object localObject1;
          if (localObject2 == null)
          {
            localObject1 = this.a.a((int)paramBaseDanmaku.A(), (int)paramBaseDanmaku.B());
          }
          else if (((Bitmap)localObject2).getWidth() >= (int)paramBaseDanmaku.A())
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() >= (int)paramBaseDanmaku.B()) {}
          }
          else
          {
            this.a.a((Bitmap)localObject2);
            localObject1 = this.a.a((int)paramBaseDanmaku.A(), (int)paramBaseDanmaku.B());
          }
          paramBaseDanmaku.a((Bitmap)localObject1);
          if (localObject1 == null) {
            return null;
          }
          localObject2 = paramBaseDanmaku.N();
          if (localObject2 == null)
          {
            localObject2 = new Canvas((Bitmap)localObject1);
            paramBaseDanmaku.a((Canvas)localObject2);
          }
          else
          {
            ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
          }
          ((Bitmap)localObject1).eraseColor(0);
          paramBaseDanmaku.c(false);
          paramDanmakuContext.a(paramBaseDanmaku).a((Canvas)localObject2, paramBaseDanmaku, paramDanmakuContext, DanmakuContext.a().l(), DanmakuContext.a().d());
          return localObject1;
        }
        paramBaseDanmaku = paramBaseDanmaku.K();
        return paramBaseDanmaku;
      }
      finally {}
    }
    throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
  }
  
  public int c()
  {
    return this.a.d();
  }
  
  public int d()
  {
    return this.a.c();
  }
  
  public void e()
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.CacheDrawManager
 * JD-Core Version:    0.7.0.1
 */