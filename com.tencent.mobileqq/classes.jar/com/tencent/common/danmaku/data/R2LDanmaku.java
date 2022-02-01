package com.tencent.common.danmaku.data;

import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.IDanmakuUIConfig;
import com.tencent.common.danmaku.inject.WindowConfig;
import com.tencent.common.danmaku.tool.Duration;
import com.tencent.common.danmaku.util.Logger;

public abstract class R2LDanmaku<DATA, CONFIG extends IDanmakuUIConfig>
  extends BaseDanmaku<DATA, CONFIG>
{
  private float A;
  private float x = 0.0F;
  private float y = -1.0F;
  private float[] z = null;
  
  public R2LDanmaku(DanmakuContext paramDanmakuContext)
  {
    super(paramDanmakuContext);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
  {
    if (!a(paramLong1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLayout, Y = ");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append(", danmaku = ");
      localStringBuilder.append(toString());
      Logger.c("BaseDanmaku", localStringBuilder.toString());
      this.x = i(paramLong2);
      if (!p())
      {
        this.y = paramFloat2;
        a(true);
      }
      return;
    }
    a(false);
  }
  
  public void d(long paramLong)
  {
    this.x = i(paramLong);
  }
  
  public float[] e(long paramLong)
  {
    if (!n()) {
      return null;
    }
    float f = i(paramLong);
    if (this.z == null) {
      this.z = new float[4];
    }
    this.z[0] = (f - DanmakuContext.a().h());
    float[] arrayOfFloat = this.z;
    arrayOfFloat[1] = this.y;
    arrayOfFloat[2] = (f + this.i + this.k);
    this.z[3] = (this.y + this.j);
    return this.z;
  }
  
  public float[] f(long paramLong)
  {
    if (!n()) {
      return null;
    }
    float f = i(paramLong);
    if (this.z == null) {
      this.z = new float[4];
    }
    float[] arrayOfFloat = this.z;
    arrayOfFloat[0] = f;
    arrayOfFloat[1] = this.y;
    arrayOfFloat[2] = (f + this.i);
    this.z[3] = (this.y + this.j);
    return this.z;
  }
  
  public void g(float paramFloat)
  {
    this.A = paramFloat;
  }
  
  public void h(float paramFloat)
  {
    this.x = paramFloat;
  }
  
  public float i()
  {
    return -this.A;
  }
  
  protected float i(long paramLong)
  {
    long l = this.c;
    return H() - (float)(paramLong - l) * this.A;
  }
  
  public void i(float paramFloat)
  {
    this.y = paramFloat;
  }
  
  public void o()
  {
    super.o();
    this.A = ((int)(H() + this.i) / (float)this.d.a());
  }
  
  public float s()
  {
    return this.x;
  }
  
  public float t()
  {
    return this.y;
  }
  
  public float u()
  {
    return this.x + this.i;
  }
  
  public float v()
  {
    return this.y + this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.data.R2LDanmaku
 * JD-Core Version:    0.7.0.1
 */