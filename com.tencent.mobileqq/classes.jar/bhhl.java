import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class bhhl
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private bhhh jdField_a_of_type_Bhhh;
  private bhhp jdField_a_of_type_Bhhp;
  private bhht jdField_a_of_type_Bhht;
  private bhhw jdField_a_of_type_Bhhw;
  private int b;
  private int c;
  private int d;
  
  public bhhl(bhhw parambhhw, bhhh parambhhh)
  {
    this.jdField_a_of_type_Bhhw = parambhhw;
    this.jdField_a_of_type_Int = parambhhw.b();
    this.jdField_a_of_type_Bhhp = parambhhw.a();
    this.d = parambhhw.a();
    this.jdField_a_of_type_Bhhh = parambhhh;
  }
  
  public void a()
  {
    bhhy.a(this.c);
    bhhy.a(this.jdField_a_of_type_Bhht);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Bhhp != null) {
      this.jdField_a_of_type_Bhhp.a(paramFloat);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bhhp != null) {
      this.jdField_a_of_type_Bhhp.a(paramFloat1, paramFloat2);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.jdField_a_of_type_Bhhw != null) && (this.jdField_a_of_type_Bhhw.f()))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_Bhhw.a();
      bhhy.a(this.c);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.c = bhhy.a(((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap(), false);
      }
      if (this.jdField_a_of_type_Bhhh != null) {
        this.jdField_a_of_type_Bhhh.b();
      }
    }
    if ((this.jdField_a_of_type_Bhhw != null) && (this.jdField_a_of_type_Bhhw.a() != null))
    {
      this.jdField_a_of_type_Bhhw.a().d();
      this.jdField_a_of_type_Bhht = this.jdField_a_of_type_Bhhw.a().a();
      this.jdField_a_of_type_Bhhp.a(this.jdField_a_of_type_Bhht);
    }
    if (this.jdField_a_of_type_Bhhp != null)
    {
      this.jdField_a_of_type_Bhhp.b(this.c);
      this.jdField_a_of_type_Bhhp.c();
      this.jdField_a_of_type_Bhhp.d();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glEnable(2884);
    float f = paramInt1 / paramInt2;
    if (this.jdField_a_of_type_Bhhp != null) {
      this.jdField_a_of_type_Bhhp.b(f);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.b = bhhx.a();
    GLES20.glUseProgram(this.b);
    if (this.jdField_a_of_type_Bhhp != null) {
      this.jdField_a_of_type_Bhhp.a(this.b);
    }
    paramGL10 = this.jdField_a_of_type_Bhhw.a();
    if ((paramGL10 != null) && (this.jdField_a_of_type_Bhhp != null)) {
      paramGL10.b(this.jdField_a_of_type_Bhhp.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhhl
 * JD-Core Version:    0.7.0.1
 */