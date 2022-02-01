package com.tencent.biz.qqcircle.bizparts.danmaku.entity;

import com.tencent.biz.qqcircle.bizparts.danmaku.config.PhotoDanmakuConfig;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer;

public class R2LPhotoDanmaku
  extends AbsDanmaku
{
  protected float ak = 0.0F;
  protected float al = -1.0F;
  protected int am;
  protected float[] an = null;
  protected float ao;
  private R2LPhotoDanmaku.IR2LDanmakuInterface ap;
  
  public R2LPhotoDanmaku(PhotoDanmakuConfig paramPhotoDanmakuConfig, Duration paramDuration, PhotoDanmakuTimer paramPhotoDanmakuTimer)
  {
    super(paramPhotoDanmakuConfig, paramDuration, paramPhotoDanmakuTimer);
  }
  
  public void a(R2LPhotoDanmaku.IR2LDanmakuInterface paramIR2LDanmakuInterface)
  {
    this.ap = paramIR2LDanmakuInterface;
  }
  
  public float b()
  {
    return -this.ao;
  }
  
  public void b(PhotoDanmakuDrawer paramPhotoDanmakuDrawer)
  {
    super.b(paramPhotoDanmakuDrawer);
    this.am = ((int)(this.K + this.P));
    this.ao = (this.am / (float)this.f.a());
    this.ak = this.K;
  }
  
  public void b(PhotoDanmakuDrawer paramPhotoDanmakuDrawer, float paramFloat1, float paramFloat2)
  {
    if (this.e != null)
    {
      if (!g())
      {
        this.ak = e(this.e.a());
        if (!f())
        {
          this.al = paramFloat2;
          a(true);
        }
        return;
      }
      a(false);
    }
    this.ak = this.K;
  }
  
  public float[] b(long paramLong)
  {
    if (!e()) {
      return null;
    }
    float f = e(paramLong);
    if (this.an == null) {
      this.an = new float[4];
    }
    float[] arrayOfFloat = this.an;
    arrayOfFloat[0] = f;
    arrayOfFloat[1] = this.al;
    arrayOfFloat[2] = (f + this.P);
    this.an[3] = (this.al + this.Q);
    return this.an;
  }
  
  public float[] c(long paramLong)
  {
    if (!e()) {
      return null;
    }
    float f = e(paramLong);
    if (this.an == null) {
      this.an = new float[4];
    }
    float[] arrayOfFloat = this.an;
    arrayOfFloat[0] = f;
    arrayOfFloat[1] = this.al;
    arrayOfFloat[2] = (f + this.P);
    this.an[3] = (this.al + this.Q);
    return this.an;
  }
  
  protected float e(long paramLong)
  {
    long l = this.g;
    return this.K - (float)(paramLong - l) * this.ao;
  }
  
  protected void h()
  {
    R2LPhotoDanmaku.IR2LDanmakuInterface localIR2LDanmakuInterface = this.ap;
    if (localIR2LDanmakuInterface != null) {
      localIR2LDanmakuInterface.a();
    }
  }
  
  public void j()
  {
    this.ak = e(this.e.a());
  }
  
  public int k()
  {
    return 1;
  }
  
  public float l()
  {
    return this.ak;
  }
  
  public void l(float paramFloat)
  {
    this.ao = paramFloat;
  }
  
  public float m()
  {
    return this.al;
  }
  
  public float n()
  {
    return this.ak + this.P;
  }
  
  public float o()
  {
    return this.al + this.Q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.entity.R2LPhotoDanmaku
 * JD-Core Version:    0.7.0.1
 */