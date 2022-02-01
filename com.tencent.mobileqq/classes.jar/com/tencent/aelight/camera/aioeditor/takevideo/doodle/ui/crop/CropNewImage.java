package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip.ClipConstant.Anchor;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip.ClipUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip.ClipWindow;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.CropHomeing;

public class CropNewImage
{
  public CropNewView a;
  private Bitmap b;
  private RectF c = new RectF();
  private RectF d = new RectF();
  private RectF e = new RectF();
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 0.0F;
  private boolean i = false;
  private boolean j = false;
  private ClipConstant.Anchor k;
  private boolean l = true;
  private ClipWindow m = new ClipWindow();
  private RectF n = new RectF();
  private boolean o = false;
  private Matrix p = new Matrix();
  
  private void h(float paramFloat1, float paramFloat2)
  {
    this.c.set(0.0F, 0.0F, this.b.getWidth(), this.b.getHeight());
    this.d.set(this.c);
    this.m.a(paramFloat1, paramFloat2);
    if (this.d.isEmpty()) {
      return;
    }
    l();
    this.o = true;
    m();
    CropNewView localCropNewView = this.a;
    if (localCropNewView != null) {
      localCropNewView.h();
    }
  }
  
  private void k()
  {
    this.o = false;
    d(this.n.width(), this.n.height());
    this.m.a(this.d, g());
  }
  
  private void l()
  {
    if (this.d.isEmpty()) {
      return;
    }
    float f1 = Math.min(this.n.width() / this.d.width(), this.n.height() / this.d.height());
    this.p.setScale(f1, f1, this.d.centerX(), this.d.centerY());
    this.p.postTranslate(this.n.centerX() - this.d.centerX(), this.n.centerY() - this.d.centerY());
    this.p.mapRect(this.c);
    this.p.mapRect(this.d);
  }
  
  private void m()
  {
    this.m.a(this.d, g());
  }
  
  public CropHomeing a(float paramFloat1, float paramFloat2)
  {
    RectF localRectF = this.m.b(paramFloat1, paramFloat2);
    this.p.setRotate(-h(), this.d.centerX(), this.d.centerY());
    this.p.mapRect(this.d, localRectF);
    return new CropHomeing(paramFloat1 + (this.d.centerX() - localRectF.centerX()), paramFloat2 + (this.d.centerY() - localRectF.centerY()), i(), h());
  }
  
  public CropHomeing a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.m.d(false);
    Object localObject = this.k;
    if (localObject != null)
    {
      this.m.a((ClipConstant.Anchor)localObject, paramFloat3, paramFloat4);
      localObject = new RectF();
      this.p.setRotate(h(), this.d.centerX(), this.d.centerY());
      this.p.mapRect((RectF)localObject, this.c);
      RectF localRectF = this.m.b(paramFloat1, paramFloat2);
      CropHomeing localCropHomeing = new CropHomeing(paramFloat1, paramFloat2, i(), g());
      localCropHomeing.a(ClipUtils.b(localRectF, (RectF)localObject, this.d.centerX(), this.d.centerY()));
      return localCropHomeing;
    }
    return null;
  }
  
  public void a()
  {
    this.f = h();
    this.e.set(this.d);
    float f1 = 1.0F / i();
    this.p.setTranslate(-this.c.left, -this.c.top);
    this.p.postScale(f1, f1);
    this.p.mapRect(this.e);
  }
  
  public void a(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    b(paramFloat1 / i(), paramFloat2, paramFloat3);
  }
  
  public void a(int paramInt)
  {
    this.h = (Math.round((this.g + paramInt) / 90.0F) * 90 % 360);
    this.m.a(this.d, g());
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return;
      }
      this.b = paramBitmap;
      b(0.0F);
      a(0.0F);
      k();
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    RectF localRectF;
    if (this.m.c()) {
      localRectF = this.c;
    } else {
      localRectF = this.d;
    }
    paramCanvas.clipRect(localRectF);
    if (!this.b.isRecycled()) {
      paramCanvas.drawBitmap(this.b, null, this.c, null);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    this.m.a(paramCanvas);
  }
  
  public void a(CropNewView paramCropNewView)
  {
    this.a = paramCropNewView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = false;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    paramBoolean = this.j;
    this.m.a(false);
    this.m.b(true);
    this.m.c(false);
    return paramBoolean ^ true;
  }
  
  public RectF b()
  {
    return this.d;
  }
  
  public CropHomeing b(float paramFloat1, float paramFloat2)
  {
    return new CropHomeing(paramFloat1, paramFloat2, i(), h());
  }
  
  public void b(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 == 1.0F) {
      return;
    }
    float f1 = paramFloat1;
    if (Math.min(this.d.width(), this.d.height()) <= 500.0F) {
      f1 = paramFloat1 + (1.0F - paramFloat1) / 2.0F;
    }
    this.p.setScale(f1, f1, paramFloat2, paramFloat3);
    this.p.mapRect(this.c);
    this.p.mapRect(this.d);
  }
  
  public void b(Canvas paramCanvas)
  {
    if (this.l)
    {
      paramCanvas.clipRect(this.c.left, this.c.top, this.c.right, this.c.bottom);
      paramCanvas.clipRect(this.d, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(-872415232);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.m.c(paramBoolean);
  }
  
  public CropHomeing c(float paramFloat1, float paramFloat2)
  {
    CropHomeing localCropHomeing = new CropHomeing(paramFloat1, paramFloat2, i(), g());
    RectF localRectF1 = new RectF(this.m.e());
    localRectF1.offset(paramFloat1, paramFloat2);
    if (this.m.d())
    {
      localRectF2 = new RectF();
      this.p.setRotate(g(), this.d.centerX(), this.d.centerY());
      this.p.mapRect(localRectF2, this.d);
      localCropHomeing.a(ClipUtils.b(localRectF1, localRectF2));
      return localCropHomeing;
    }
    RectF localRectF2 = new RectF();
    if (this.m.b())
    {
      this.p.setRotate(g() - h(), this.d.centerX(), this.d.centerY());
      this.p.mapRect(localRectF2, this.m.b(paramFloat1, paramFloat2));
      localCropHomeing.a(ClipUtils.a(localRectF1, localRectF2, this.d.centerX(), this.d.centerY()));
      return localCropHomeing;
    }
    this.p.setRotate(g(), this.d.centerX(), this.d.centerY());
    this.p.mapRect(localRectF2, this.c);
    localCropHomeing.a(ClipUtils.b(localRectF1, localRectF2, this.d.centerX(), this.d.centerY()));
    return localCropHomeing;
  }
  
  public void c()
  {
    this.p.setScale(i(), i());
    this.p.postTranslate(this.c.left, this.c.top);
    this.p.mapRect(this.d, this.e);
    a(this.f);
    this.i = true;
  }
  
  public void c(float paramFloat)
  {
    a(paramFloat, this.d.centerX(), this.d.centerY());
  }
  
  public void c(boolean paramBoolean)
  {
    this.j = true;
  }
  
  public void d()
  {
    a(h() - h() % 360.0F);
    this.d.set(this.c);
    this.m.a(this.d, g());
  }
  
  public void d(float paramFloat)
  {
    this.m.a(paramFloat);
  }
  
  public void d(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 != 0.0F)
    {
      if (paramFloat2 == 0.0F) {
        return;
      }
      this.n.set(0.0F, 0.0F, paramFloat1, paramFloat2);
      if (!this.o)
      {
        h(paramFloat1, paramFloat2);
      }
      else
      {
        this.p.setTranslate(this.n.centerX() - this.d.centerX(), this.n.centerY() - this.d.centerY());
        this.p.mapRect(this.c);
        this.p.mapRect(this.d);
      }
      this.m.a(paramFloat1, paramFloat2);
    }
  }
  
  public void e(float paramFloat1, float paramFloat2)
  {
    this.l = false;
    this.k = this.m.c(paramFloat1, paramFloat2);
  }
  
  public boolean e()
  {
    return this.m.a();
  }
  
  public void f() {}
  
  public void f(float paramFloat1, float paramFloat2)
  {
    if (this.k != null) {
      this.k = null;
    }
  }
  
  public float g()
  {
    return this.h;
  }
  
  public void g(float paramFloat1, float paramFloat2)
  {
    this.l = true;
    e();
    this.m.d(true);
  }
  
  public float h()
  {
    return this.g;
  }
  
  public float i()
  {
    return this.c.width() * 1.0F / this.b.getWidth();
  }
  
  public void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewImage
 * JD-Core Version:    0.7.0.1
 */