import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class bjnd
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private bjmz jdField_a_of_type_Bjmz;
  private bjnh jdField_a_of_type_Bjnh;
  private bjnl jdField_a_of_type_Bjnl;
  private bjno jdField_a_of_type_Bjno;
  private int b;
  private int c;
  private int d;
  
  public bjnd(bjno parambjno, bjmz parambjmz)
  {
    this.jdField_a_of_type_Bjno = parambjno;
    this.jdField_a_of_type_Int = parambjno.b();
    this.jdField_a_of_type_Bjnh = parambjno.a();
    this.d = parambjno.a();
    this.jdField_a_of_type_Bjmz = parambjmz;
  }
  
  public void a()
  {
    bjnq.a(this.c);
    bjnq.a(this.jdField_a_of_type_Bjnl);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Bjnh != null) {
      this.jdField_a_of_type_Bjnh.a(paramFloat);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bjnh != null) {
      this.jdField_a_of_type_Bjnh.a(paramFloat1, paramFloat2);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.jdField_a_of_type_Bjno != null) && (this.jdField_a_of_type_Bjno.f()))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_Bjno.a();
      bjnq.a(this.c);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.c = bjnq.a(((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap(), false);
      }
      if (this.jdField_a_of_type_Bjmz != null) {
        this.jdField_a_of_type_Bjmz.b();
      }
    }
    if ((this.jdField_a_of_type_Bjno != null) && (this.jdField_a_of_type_Bjno.a() != null))
    {
      this.jdField_a_of_type_Bjno.a().d();
      this.jdField_a_of_type_Bjnl = this.jdField_a_of_type_Bjno.a().a();
      this.jdField_a_of_type_Bjnh.a(this.jdField_a_of_type_Bjnl);
    }
    if (this.jdField_a_of_type_Bjnh != null)
    {
      this.jdField_a_of_type_Bjnh.b(this.c);
      this.jdField_a_of_type_Bjnh.c();
      this.jdField_a_of_type_Bjnh.d();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glEnable(2884);
    float f = paramInt1 / paramInt2;
    if (this.jdField_a_of_type_Bjnh != null) {
      this.jdField_a_of_type_Bjnh.b(f);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.b = bjnp.a();
    GLES20.glUseProgram(this.b);
    if (this.jdField_a_of_type_Bjnh != null) {
      this.jdField_a_of_type_Bjnh.a(this.b);
    }
    paramGL10 = this.jdField_a_of_type_Bjno.a();
    if ((paramGL10 != null) && (this.jdField_a_of_type_Bjnh != null)) {
      paramGL10.b(this.jdField_a_of_type_Bjnh.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjnd
 * JD-Core Version:    0.7.0.1
 */