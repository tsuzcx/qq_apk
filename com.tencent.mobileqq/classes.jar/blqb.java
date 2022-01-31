import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Region.Op;
import dov.com.qq.im.aeeditor.view.ClipConstant.Anchor;
import dov.com.qq.im.aeeditor.view.EditorClipView;

public class blqb
{
  private static double jdField_a_of_type_Double = 1.0D;
  private float jdField_a_of_type_Float;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private blqa jdField_a_of_type_Blqa = new blqa();
  private ClipConstant.Anchor jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor;
  public EditorClipView a;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 0.0F;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_c_of_type_Boolean;
  private RectF d = new RectF();
  
  public static void a(double paramDouble)
  {
    if (paramDouble > 0.0D) {
      jdField_a_of_type_Double = paramDouble;
    }
  }
  
  private void d(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_a_of_type_Blqa.a(paramFloat1, paramFloat2);
    if (this.jdField_b_of_type_AndroidGraphicsRectF.isEmpty()) {}
    do
    {
      return;
      f();
      this.jdField_c_of_type_Boolean = true;
      g();
    } while (this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView == null);
    this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView.a();
  }
  
  private void e()
  {
    this.jdField_c_of_type_Boolean = false;
    a(this.d.width(), this.d.height());
    this.jdField_a_of_type_Blqa.a(this.jdField_b_of_type_AndroidGraphicsRectF, a());
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_AndroidGraphicsRectF.isEmpty()) {
      return;
    }
    float f1 = this.d.width() / this.jdField_b_of_type_AndroidGraphicsRectF.width();
    float f2 = (float)(this.d.width() / jdField_a_of_type_Double) / this.jdField_b_of_type_AndroidGraphicsRectF.height();
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f2, this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.d.centerX() - this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.d.centerY() - this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
    f1 = Math.max(this.jdField_b_of_type_AndroidGraphicsRectF.width() / this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_b_of_type_AndroidGraphicsRectF.height() / this.jdField_a_of_type_AndroidGraphicsRectF.height());
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY());
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.d.centerX() - this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.d.centerY() - this.jdField_a_of_type_AndroidGraphicsRectF.centerY());
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_a_of_type_AndroidGraphicsRectF);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Blqa.a(this.jdField_b_of_type_AndroidGraphicsRectF, a());
  }
  
  public float a()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public RectF a()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF;
  }
  
  public bmtc a(float paramFloat1, float paramFloat2)
  {
    RectF localRectF = this.jdField_a_of_type_Blqa.a(paramFloat1, paramFloat2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(-b(), this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF, localRectF);
    return new bmtc(this.jdField_b_of_type_AndroidGraphicsRectF.centerX() - localRectF.centerX() + paramFloat1, this.jdField_b_of_type_AndroidGraphicsRectF.centerY() - localRectF.centerY() + paramFloat2, c(), b());
  }
  
  public bmtc a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_Blqa.d(false);
    if (this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor != null)
    {
      this.jdField_a_of_type_Blqa.a(this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor, paramFloat3, paramFloat4);
      RectF localRectF1 = new RectF();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(b(), this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF1, this.jdField_a_of_type_AndroidGraphicsRectF);
      RectF localRectF2 = this.jdField_a_of_type_Blqa.a(paramFloat1, paramFloat2);
      bmtc localbmtc = new bmtc(paramFloat1, paramFloat2, c(), a());
      localbmtc.a(bmsg.b(localRectF2, localRectF1, this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY()));
      return localbmtc;
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
    this.d.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    if (!this.jdField_c_of_type_Boolean) {
      d(paramFloat1, paramFloat2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Blqa.a(paramFloat1, paramFloat2);
      return;
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(this.d.centerX() - this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.d.centerY() - this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    b(paramFloat1 / c(), paramFloat2, paramFloat3);
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    if (paramBoolean) {
      this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor = this.jdField_a_of_type_Blqa.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor = ClipConstant.Anchor.valueOf(paramInt);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    b(0.0F);
    a(0.0F);
    e();
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Blqa.c()) {}
    for (RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;; localRectF = this.jdField_b_of_type_AndroidGraphicsRectF)
    {
      paramCanvas.clipRect(localRectF);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRectF, null);
      return;
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Blqa.a(paramCanvas);
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    RectF localRectF = this.jdField_a_of_type_Blqa.a(paramInt1, paramInt2);
    paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF.left, this.jdField_a_of_type_AndroidGraphicsRectF.top, this.jdField_a_of_type_AndroidGraphicsRectF.right, this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
    paramCanvas.clipRect(localRectF, Region.Op.DIFFERENCE);
    paramCanvas.drawColor(-872415232);
  }
  
  public void a(EditorClipView paramEditorClipView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView = paramEditorClipView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Blqa.a();
  }
  
  public boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Blqa.a(false);
      this.jdField_a_of_type_Blqa.b(true);
      this.jdField_a_of_type_Blqa.c(false);
      return paramBoolean;
    }
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public RectF b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public bmtc b(float paramFloat1, float paramFloat2)
  {
    return new bmtc(paramFloat1, paramFloat2, c(), b());
  }
  
  public void b() {}
  
  public void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor = null;
    }
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
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public float c()
  {
    return 1.0F * this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
  }
  
  public bmtc c(float paramFloat1, float paramFloat2)
  {
    bmtc localbmtc = new bmtc(paramFloat1, paramFloat2, c(), a());
    RectF localRectF1 = new RectF(this.jdField_a_of_type_Blqa.a());
    localRectF1.offset(paramFloat1, paramFloat2);
    if (this.jdField_a_of_type_Blqa.d())
    {
      localRectF2 = new RectF();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(a(), this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF2, this.jdField_b_of_type_AndroidGraphicsRectF);
      localbmtc.a(bmsg.a(localRectF1, localRectF2));
      return localbmtc;
    }
    RectF localRectF2 = new RectF();
    if (this.jdField_a_of_type_Blqa.b())
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(a() - b(), this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF2, this.jdField_a_of_type_Blqa.a(paramFloat1, paramFloat2));
      localbmtc.a(bmsg.a(localRectF1, localRectF2, this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY()));
      return localbmtc;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(a(), this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF2, this.jdField_a_of_type_AndroidGraphicsRectF);
    localbmtc.a(bmsg.b(localRectF1, localRectF2, this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY()));
    return localbmtc;
  }
  
  public void c() {}
  
  public void c(float paramFloat)
  {
    a(paramFloat, this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
  }
  
  public void c(float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Boolean = true;
    a();
    this.jdField_a_of_type_Blqa.d(true);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor = null;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d(float paramFloat)
  {
    this.jdField_a_of_type_Blqa.a(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqb
 * JD-Core Version:    0.7.0.1
 */