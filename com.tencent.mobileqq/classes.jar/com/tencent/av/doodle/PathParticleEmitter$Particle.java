package com.tencent.av.doodle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

public class PathParticleEmitter$Particle
  extends BitmapDrawable
{
  private float A = 0.0F;
  private Matrix B = new Matrix();
  protected int a;
  protected int b;
  protected float c;
  protected float d;
  protected float e;
  protected float f;
  protected float g;
  protected float h;
  protected float i;
  protected float j;
  protected float k;
  protected float l;
  protected float m;
  protected float n;
  protected float o;
  protected float p;
  protected float q;
  protected float r;
  protected float[] s;
  private float t = 0.0F;
  private float u = 0.0F;
  private float v = 0.0F;
  private float w = 1.0F;
  private float x = 0.0F;
  private float y = 0.0F;
  private float z = 0.0F;
  
  public PathParticleEmitter$Particle(BitmapDrawable paramBitmapDrawable)
  {
    super(paramBitmapDrawable.getBitmap());
  }
  
  private void a()
  {
    this.B.reset();
    this.B.preRotate(this.v, this.t, this.u);
    Matrix localMatrix = this.B;
    float f1 = this.w;
    localMatrix.preScale(f1, f1, this.t, this.u);
  }
  
  public void a(float paramFloat)
  {
    if (this.v != paramFloat)
    {
      this.v = paramFloat;
      a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(this.x + paramFloat1, this.y + paramFloat2, this.z, this.A);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Rect localRect1 = getBounds();
    Rect localRect2 = new Rect();
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.A = paramFloat4;
    paramFloat1 = this.x;
    localRect2.left = ((int)paramFloat1);
    paramFloat2 = this.y;
    localRect2.top = ((int)paramFloat2);
    localRect2.right = ((int)(paramFloat1 + this.z));
    localRect2.bottom = ((int)(paramFloat2 + this.A));
    if (!localRect1.equals(localRect2)) {
      setBounds(localRect2);
    }
  }
  
  public void b(float paramFloat)
  {
    if (this.w != paramFloat)
    {
      this.w = paramFloat;
      a();
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setColorFilter(Color.argb(255, (int)(paramFloat1 * 255.0F), (int)(paramFloat2 * 255.0F), (int)(paramFloat3 * 255.0F)), PorterDuff.Mode.SRC_ATOP);
    setAlpha((int)(paramFloat4 * 255.0F));
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.B);
    super.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    float f1 = (paramInt1 + paramInt3) / 2;
    float f2 = (paramInt2 + paramInt4) / 2;
    if (this.t != f1)
    {
      this.t = f1;
      paramInt1 = 1;
    }
    else
    {
      paramInt1 = 0;
    }
    if (this.u != f2)
    {
      this.u = f2;
      paramInt1 = 1;
    }
    if (paramInt1 != 0) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.Particle
 * JD-Core Version:    0.7.0.1
 */