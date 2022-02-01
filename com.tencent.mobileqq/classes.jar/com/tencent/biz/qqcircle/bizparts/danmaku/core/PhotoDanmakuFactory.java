package com.tencent.biz.qqcircle.bizparts.danmaku.core;

import android.content.Context;
import com.tencent.biz.qqcircle.bizparts.danmaku.config.PhotoDanmakuConfig;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.Duration;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.PhotoDanmakuTimer;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.R2LPhotoDanmaku;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PhotoDanmakuFactory
{
  private final Duration a;
  private final PhotoDanmakuConfig b;
  private final PhotoDanmakuDrawer c;
  private final PhotoDanmakuTimer d;
  private final BlockingQueue<AbsDanmaku> e;
  private final BlockingQueue<AbsDanmaku> f;
  
  public PhotoDanmakuFactory(Context paramContext, PhotoDanmakuTimer paramPhotoDanmakuTimer, int paramInt)
  {
    this.d = paramPhotoDanmakuTimer;
    this.b = PhotoDanmakuConfig.a(paramContext, 1, paramInt);
    this.c = new PhotoDanmakuDrawer(paramContext, null);
    this.a = new Duration(this.b.d);
    this.e = new LinkedBlockingQueue();
    this.f = new LinkedBlockingQueue();
  }
  
  public AbsDanmaku a(int paramInt)
  {
    if (paramInt != 1) {
      return null;
    }
    AbsDanmaku localAbsDanmaku = (AbsDanmaku)this.e.poll();
    Object localObject = localAbsDanmaku;
    if (localAbsDanmaku == null) {
      localObject = new R2LPhotoDanmaku(this.b, this.a.b(), this.d);
    }
    return localObject;
  }
  
  public AbsDanmaku a(int paramInt1, long paramLong, String paramString, CharSequence paramCharSequence, int paramInt2, float paramFloat, int paramInt3)
  {
    AbsDanmaku localAbsDanmaku = a(paramInt1);
    if (localAbsDanmaku != null)
    {
      localAbsDanmaku.d(paramLong);
      localAbsDanmaku.c(paramString);
      localAbsDanmaku.a(paramCharSequence);
      localAbsDanmaku.d(paramFloat);
      localAbsDanmaku.e(paramInt3);
      localAbsDanmaku.b(paramInt2);
    }
    return localAbsDanmaku;
  }
  
  public AbsDanmaku a(AbsDanmaku paramAbsDanmaku)
  {
    if (paramAbsDanmaku.k() != 1) {
      return paramAbsDanmaku;
    }
    if (!paramAbsDanmaku.e()) {
      paramAbsDanmaku.b(this.c);
    }
    return paramAbsDanmaku;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuFactory
 * JD-Core Version:    0.7.0.1
 */