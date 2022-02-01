package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;

public abstract interface IDanmakuOverlayDrawer
{
  public abstract void a(Canvas paramCanvas, BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.render.IDanmakuOverlayDrawer
 * JD-Core Version:    0.7.0.1
 */