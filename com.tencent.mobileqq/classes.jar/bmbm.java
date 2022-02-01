import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class bmbm
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private bmbi jdField_a_of_type_Bmbi;
  private bmbq jdField_a_of_type_Bmbq;
  private bmbu jdField_a_of_type_Bmbu;
  private bmbx jdField_a_of_type_Bmbx;
  private int b;
  private int c;
  private int d;
  
  public bmbm(bmbx parambmbx, bmbi parambmbi)
  {
    this.jdField_a_of_type_Bmbx = parambmbx;
    this.jdField_a_of_type_Int = parambmbx.b();
    this.jdField_a_of_type_Bmbq = parambmbx.a();
    this.d = parambmbx.a();
    this.jdField_a_of_type_Bmbi = parambmbi;
  }
  
  public void a()
  {
    bmbz.a(this.c);
    bmbz.a(this.jdField_a_of_type_Bmbu);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Bmbq != null) {
      this.jdField_a_of_type_Bmbq.a(paramFloat);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bmbq != null) {
      this.jdField_a_of_type_Bmbq.a(paramFloat1, paramFloat2);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.jdField_a_of_type_Bmbx != null) && (this.jdField_a_of_type_Bmbx.f()))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_Bmbx.a();
      bmbz.a(this.c);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.c = bmbz.a(((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap(), false);
      }
      if (this.jdField_a_of_type_Bmbi != null) {
        this.jdField_a_of_type_Bmbi.b();
      }
    }
    if ((this.jdField_a_of_type_Bmbx != null) && (this.jdField_a_of_type_Bmbx.a() != null))
    {
      this.jdField_a_of_type_Bmbx.a().d();
      this.jdField_a_of_type_Bmbu = this.jdField_a_of_type_Bmbx.a().a();
      this.jdField_a_of_type_Bmbq.a(this.jdField_a_of_type_Bmbu);
    }
    if (this.jdField_a_of_type_Bmbq != null)
    {
      this.jdField_a_of_type_Bmbq.b(this.c);
      this.jdField_a_of_type_Bmbq.c();
      this.jdField_a_of_type_Bmbq.d();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glEnable(2884);
    float f = paramInt1 / paramInt2;
    if (this.jdField_a_of_type_Bmbq != null) {
      this.jdField_a_of_type_Bmbq.b(f);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.b = bmby.a();
    GLES20.glUseProgram(this.b);
    if (this.jdField_a_of_type_Bmbq != null) {
      this.jdField_a_of_type_Bmbq.a(this.b);
    }
    paramGL10 = this.jdField_a_of_type_Bmbx.a();
    if ((paramGL10 != null) && (this.jdField_a_of_type_Bmbq != null)) {
      paramGL10.b(this.jdField_a_of_type_Bmbq.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbm
 * JD-Core Version:    0.7.0.1
 */