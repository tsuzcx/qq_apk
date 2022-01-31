import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class bhgu
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private bhgq jdField_a_of_type_Bhgq;
  private bhgy jdField_a_of_type_Bhgy;
  private bhhc jdField_a_of_type_Bhhc;
  private bhhf jdField_a_of_type_Bhhf;
  private int b;
  private int c;
  private int d;
  
  public bhgu(bhhf parambhhf, bhgq parambhgq)
  {
    this.jdField_a_of_type_Bhhf = parambhhf;
    this.jdField_a_of_type_Int = parambhhf.b();
    this.jdField_a_of_type_Bhgy = parambhhf.a();
    this.d = parambhhf.a();
    this.jdField_a_of_type_Bhgq = parambhgq;
  }
  
  public void a()
  {
    bhhh.a(this.c);
    bhhh.a(this.jdField_a_of_type_Bhhc);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Bhgy != null) {
      this.jdField_a_of_type_Bhgy.a(paramFloat);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bhgy != null) {
      this.jdField_a_of_type_Bhgy.a(paramFloat1, paramFloat2);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.jdField_a_of_type_Bhhf != null) && (this.jdField_a_of_type_Bhhf.f()))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_Bhhf.a();
      bhhh.a(this.c);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.c = bhhh.a(((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap(), false);
      }
      if (this.jdField_a_of_type_Bhgq != null) {
        this.jdField_a_of_type_Bhgq.b();
      }
    }
    if ((this.jdField_a_of_type_Bhhf != null) && (this.jdField_a_of_type_Bhhf.a() != null))
    {
      this.jdField_a_of_type_Bhhf.a().d();
      this.jdField_a_of_type_Bhhc = this.jdField_a_of_type_Bhhf.a().a();
      this.jdField_a_of_type_Bhgy.a(this.jdField_a_of_type_Bhhc);
    }
    if (this.jdField_a_of_type_Bhgy != null)
    {
      this.jdField_a_of_type_Bhgy.b(this.c);
      this.jdField_a_of_type_Bhgy.c();
      this.jdField_a_of_type_Bhgy.d();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glEnable(2884);
    float f = paramInt1 / paramInt2;
    if (this.jdField_a_of_type_Bhgy != null) {
      this.jdField_a_of_type_Bhgy.b(f);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.b = bhhg.a();
    GLES20.glUseProgram(this.b);
    if (this.jdField_a_of_type_Bhgy != null) {
      this.jdField_a_of_type_Bhgy.a(this.b);
    }
    paramGL10 = this.jdField_a_of_type_Bhhf.a();
    if ((paramGL10 != null) && (this.jdField_a_of_type_Bhgy != null)) {
      paramGL10.b(this.jdField_a_of_type_Bhgy.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhgu
 * JD-Core Version:    0.7.0.1
 */