import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class bfyj
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private bfyf jdField_a_of_type_Bfyf;
  private bfyn jdField_a_of_type_Bfyn;
  private bfyr jdField_a_of_type_Bfyr;
  private bfyu jdField_a_of_type_Bfyu;
  private int b;
  private int c;
  private int d;
  
  public bfyj(bfyu parambfyu, bfyf parambfyf)
  {
    this.jdField_a_of_type_Bfyu = parambfyu;
    this.jdField_a_of_type_Int = parambfyu.b();
    this.jdField_a_of_type_Bfyn = parambfyu.a();
    this.d = parambfyu.a();
    this.jdField_a_of_type_Bfyf = parambfyf;
  }
  
  public void a()
  {
    bfyw.a(this.c);
    bfyw.a(this.jdField_a_of_type_Bfyr);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Bfyn != null) {
      this.jdField_a_of_type_Bfyn.a(paramFloat);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bfyn != null) {
      this.jdField_a_of_type_Bfyn.a(paramFloat1, paramFloat2);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.jdField_a_of_type_Bfyu != null) && (this.jdField_a_of_type_Bfyu.f()))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_Bfyu.a();
      bfyw.a(this.c);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.c = bfyw.a(((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap(), false);
      }
      if (this.jdField_a_of_type_Bfyf != null) {
        this.jdField_a_of_type_Bfyf.b();
      }
    }
    if ((this.jdField_a_of_type_Bfyu != null) && (this.jdField_a_of_type_Bfyu.a() != null))
    {
      this.jdField_a_of_type_Bfyu.a().d();
      this.jdField_a_of_type_Bfyr = this.jdField_a_of_type_Bfyu.a().a();
      this.jdField_a_of_type_Bfyn.a(this.jdField_a_of_type_Bfyr);
    }
    if (this.jdField_a_of_type_Bfyn != null)
    {
      this.jdField_a_of_type_Bfyn.b(this.c);
      this.jdField_a_of_type_Bfyn.c();
      this.jdField_a_of_type_Bfyn.d();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glEnable(2884);
    float f = paramInt1 / paramInt2;
    if (this.jdField_a_of_type_Bfyn != null) {
      this.jdField_a_of_type_Bfyn.b(f);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.b = bfyv.a();
    GLES20.glUseProgram(this.b);
    if (this.jdField_a_of_type_Bfyn != null) {
      this.jdField_a_of_type_Bfyn.a(this.b);
    }
    paramGL10 = this.jdField_a_of_type_Bfyu.a();
    if ((paramGL10 != null) && (this.jdField_a_of_type_Bfyn != null)) {
      paramGL10.b(this.jdField_a_of_type_Bfyn.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfyj
 * JD-Core Version:    0.7.0.1
 */