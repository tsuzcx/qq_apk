import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class bjiw
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private bjis jdField_a_of_type_Bjis;
  private bjja jdField_a_of_type_Bjja;
  private bjje jdField_a_of_type_Bjje;
  private bjjh jdField_a_of_type_Bjjh;
  private int b;
  private int c;
  private int d;
  
  public bjiw(bjjh parambjjh, bjis parambjis)
  {
    this.jdField_a_of_type_Bjjh = parambjjh;
    this.jdField_a_of_type_Int = parambjjh.b();
    this.jdField_a_of_type_Bjja = parambjjh.a();
    this.d = parambjjh.a();
    this.jdField_a_of_type_Bjis = parambjis;
  }
  
  public void a()
  {
    bjjj.a(this.c);
    bjjj.a(this.jdField_a_of_type_Bjje);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Bjja != null) {
      this.jdField_a_of_type_Bjja.a(paramFloat);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bjja != null) {
      this.jdField_a_of_type_Bjja.a(paramFloat1, paramFloat2);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.jdField_a_of_type_Bjjh != null) && (this.jdField_a_of_type_Bjjh.f()))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_Bjjh.a();
      bjjj.a(this.c);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.c = bjjj.a(((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap(), false);
      }
      if (this.jdField_a_of_type_Bjis != null) {
        this.jdField_a_of_type_Bjis.b();
      }
    }
    if ((this.jdField_a_of_type_Bjjh != null) && (this.jdField_a_of_type_Bjjh.a() != null))
    {
      this.jdField_a_of_type_Bjjh.a().d();
      this.jdField_a_of_type_Bjje = this.jdField_a_of_type_Bjjh.a().a();
      this.jdField_a_of_type_Bjja.a(this.jdField_a_of_type_Bjje);
    }
    if (this.jdField_a_of_type_Bjja != null)
    {
      this.jdField_a_of_type_Bjja.b(this.c);
      this.jdField_a_of_type_Bjja.c();
      this.jdField_a_of_type_Bjja.d();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glEnable(2884);
    float f = paramInt1 / paramInt2;
    if (this.jdField_a_of_type_Bjja != null) {
      this.jdField_a_of_type_Bjja.b(f);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.b = bjji.a();
    GLES20.glUseProgram(this.b);
    if (this.jdField_a_of_type_Bjja != null) {
      this.jdField_a_of_type_Bjja.a(this.b);
    }
    paramGL10 = this.jdField_a_of_type_Bjjh.a();
    if ((paramGL10 != null) && (this.jdField_a_of_type_Bjja != null)) {
      paramGL10.b(this.jdField_a_of_type_Bjja.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjiw
 * JD-Core Version:    0.7.0.1
 */