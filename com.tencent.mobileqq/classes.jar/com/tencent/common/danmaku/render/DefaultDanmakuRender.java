package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import android.text.TextPaint;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.WindowConfig;
import com.tencent.common.danmaku.util.ContentSize;
import com.tencent.common.danmaku.util.DrawUtils;

public class DefaultDanmakuRender
  extends BaseDanmakuRender
{
  private TextPaint a = new TextPaint();
  
  private String d(BaseDanmaku paramBaseDanmaku)
  {
    return String.valueOf(paramBaseDanmaku.r());
  }
  
  public boolean a(BaseDanmaku paramBaseDanmaku)
  {
    return true;
  }
  
  public ContentSize b(BaseDanmaku paramBaseDanmaku)
  {
    WindowConfig localWindowConfig = DanmakuContext.a();
    float f1 = DrawUtils.a(localWindowConfig.m(), d(paramBaseDanmaku)) + localWindowConfig.p() + localWindowConfig.p();
    float f2 = DrawUtils.a(localWindowConfig.m()) + localWindowConfig.o() * 2.0F;
    paramBaseDanmaku.a(f2);
    paramBaseDanmaku.b(f1);
    return new ContentSize(f1, f2);
  }
  
  public void b(Canvas paramCanvas, BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2)
  {
    paramDanmakuContext = DanmakuContext.a();
    this.a.setTextSize(paramDanmakuContext.m());
    this.a.setColor(-1);
    paramCanvas.drawText(d(paramBaseDanmaku), paramFloat1 + paramDanmakuContext.p(), paramFloat2 + paramDanmakuContext.o() - this.a.ascent(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.render.DefaultDanmakuRender
 * JD-Core Version:    0.7.0.1
 */