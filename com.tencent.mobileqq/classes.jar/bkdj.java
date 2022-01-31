import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Region.Op;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.Clip.ClipConstant.Anchor;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView;

public class bkdj
{
  private float jdField_a_of_type_Float;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private bkcl jdField_a_of_type_Bkcl = new bkcl();
  private ClipConstant.Anchor jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiClipClipConstant$Anchor;
  public CropNewView a;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 0.0F;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_c_of_type_Boolean = true;
  private RectF jdField_d_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_d_of_type_Boolean;
  
  private void e(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_a_of_type_Bkcl.a(paramFloat1, paramFloat2);
    if (this.jdField_b_of_type_AndroidGraphicsRectF.isEmpty()) {}
    do
    {
      return;
      g();
      this.jdField_d_of_type_Boolean = true;
      h();
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView == null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.d();
  }
  
  private void f()
  {
    this.jdField_d_of_type_Boolean = false;
    a(this.jdField_d_of_type_AndroidGraphicsRectF.width(), this.jdField_d_of_type_AndroidGraphicsRectF.height());
    this.jdField_a_of_type_Bkcl.a(this.jdField_b_of_type_AndroidGraphicsRectF, a());
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_AndroidGraphicsRectF.isEmpty()) {
      return;
    }
    float f = Math.min(this.jdField_d_of_type_AndroidGraphicsRectF.width() / this.jdField_b_of_type_AndroidGraphicsRectF.width(), this.jdField_d_of_type_AndroidGraphicsRectF.height() / this.jdField_b_of_type_AndroidGraphicsRectF.height());
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f, f, this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_d_of_type_AndroidGraphicsRectF.centerX() - this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_d_of_type_AndroidGraphicsRectF.centerY() - this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Bkcl.a(this.jdField_b_of_type_AndroidGraphicsRectF, a());
  }
  
  public float a()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public RectF a()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF;
  }
  
  public bkdg a(float paramFloat1, float paramFloat2)
  {
    RectF localRectF = this.jdField_a_of_type_Bkcl.a(paramFloat1, paramFloat2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(-b(), this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF, localRectF);
    return new bkdg(this.jdField_b_of_type_AndroidGraphicsRectF.centerX() - localRectF.centerX() + paramFloat1, this.jdField_b_of_type_AndroidGraphicsRectF.centerY() - localRectF.centerY() + paramFloat2, c(), b());
  }
  
  public bkdg a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_Bkcl.d(false);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiClipClipConstant$Anchor != null)
    {
      this.jdField_a_of_type_Bkcl.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiClipClipConstant$Anchor, paramFloat3, paramFloat4);
      RectF localRectF1 = new RectF();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(b(), this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF1, this.jdField_a_of_type_AndroidGraphicsRectF);
      RectF localRectF2 = this.jdField_a_of_type_Bkcl.a(paramFloat1, paramFloat2);
      bkdg localbkdg = new bkdg(paramFloat1, paramFloat2, c(), a());
      localbkdg.a(bkck.b(localRectF2, localRectF1, this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY()));
      return localbkdg;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Float = b();
    this.jdField_c_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_AndroidGraphicsRectF);
    float f = 1.0F / c();
    this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-this.jdField_a_of_type_AndroidGraphicsRectF.left, -this.jdField_a_of_type_AndroidGraphicsRectF.top);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f, f);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 == 0.0F) || (paramFloat2 == 0.0F)) {
      return;
    }
    this.jdField_d_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    if (!this.jdField_d_of_type_Boolean) {
      e(paramFloat1, paramFloat2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkcl.a(paramFloat1, paramFloat2);
      return;
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(this.jdField_d_of_type_AndroidGraphicsRectF.centerX() - this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_d_of_type_AndroidGraphicsRectF.centerY() - this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    b(paramFloat1 / c(), paramFloat2, paramFloat3);
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Float = (Math.round((this.jdField_b_of_type_Float + paramInt) / 90.0F) * 90 % 360);
    this.jdField_a_of_type_Bkcl.a(this.jdField_b_of_type_AndroidGraphicsRectF, a());
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    b(0.0F);
    a(0.0F);
    f();
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bkcl.c()) {}
    for (RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;; localRectF = this.jdField_b_of_type_AndroidGraphicsRectF)
    {
      paramCanvas.clipRect(localRectF);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRectF, null);
      return;
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Bkcl.a(paramCanvas);
  }
  
  public void a(CropNewView paramCropNewView)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView = paramCropNewView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bkcl.a();
  }
  
  public boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Bkcl.a(false);
      this.jdField_a_of_type_Bkcl.b(true);
      this.jdField_a_of_type_Bkcl.c(false);
      return paramBoolean;
    }
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public bkdg b(float paramFloat1, float paramFloat2)
  {
    return new bkdg(paramFloat1, paramFloat2, c(), b());
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(c(), c());
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_AndroidGraphicsRectF.left, this.jdField_a_of_type_AndroidGraphicsRectF.top);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_AndroidGraphicsRectF);
    a(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiClipClipConstant$Anchor = this.jdField_a_of_type_Bkcl.a(paramFloat1, paramFloat2);
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 == 1.0F) {
      return;
    }
    float f = paramFloat1;
    if (Math.min(this.jdField_b_of_type_AndroidGraphicsRectF.width(), this.jdField_b_of_type_AndroidGraphicsRectF.height()) <= 500.0F) {
      f = paramFloat1 + (1.0F - paramFloat1) / 2.0F;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f, f, paramFloat2, paramFloat3);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
  }
  
  public void b(Canvas paramCanvas)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF.left, this.jdField_a_of_type_AndroidGraphicsRectF.top, this.jdField_a_of_type_AndroidGraphicsRectF.right, this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
      paramCanvas.clipRect(this.jdField_b_of_type_AndroidGraphicsRectF, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(-872415232);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bkcl.c(paramBoolean);
  }
  
  public float c()
  {
    return 1.0F * this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
  }
  
  public bkdg c(float paramFloat1, float paramFloat2)
  {
    bkdg localbkdg = new bkdg(paramFloat1, paramFloat2, c(), a());
    RectF localRectF1 = new RectF(this.jdField_a_of_type_Bkcl.a());
    localRectF1.offset(paramFloat1, paramFloat2);
    if (this.jdField_a_of_type_Bkcl.d())
    {
      localRectF2 = new RectF();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(a(), this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF2, this.jdField_b_of_type_AndroidGraphicsRectF);
      localbkdg.a(bkck.a(localRectF1, localRectF2));
      return localbkdg;
    }
    RectF localRectF2 = new RectF();
    if (this.jdField_a_of_type_Bkcl.b())
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(a() - b(), this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF2, this.jdField_a_of_type_Bkcl.a(paramFloat1, paramFloat2));
      localbkdg.a(bkck.a(localRectF1, localRectF2, this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY()));
      return localbkdg;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(a(), this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF2, this.jdField_a_of_type_AndroidGraphicsRectF);
    localbkdg.a(bkck.b(localRectF1, localRectF2, this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY()));
    return localbkdg;
  }
  
  public void c()
  {
    a(b() - b() % 360.0F);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_a_of_type_Bkcl.a(this.jdField_b_of_type_AndroidGraphicsRectF, a());
  }
  
  public void c(float paramFloat)
  {
    a(paramFloat, this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
  }
  
  public void c(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiClipClipConstant$Anchor != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiClipClipConstant$Anchor = null;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d() {}
  
  public void d(float paramFloat)
  {
    this.jdField_a_of_type_Bkcl.a(paramFloat);
  }
  
  public void d(float paramFloat1, float paramFloat2)
  {
    this.jdField_c_of_type_Boolean = true;
    a();
    this.jdField_a_of_type_Bkcl.d(true);
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkdj
 * JD-Core Version:    0.7.0.1
 */