import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class bnco
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private bnck jdField_a_of_type_Bnck;
  private bncs jdField_a_of_type_Bncs;
  private bncw jdField_a_of_type_Bncw;
  private bncz jdField_a_of_type_Bncz;
  private int b;
  private int c;
  private int d;
  
  public bnco(bncz parambncz, bnck parambnck)
  {
    this.jdField_a_of_type_Bncz = parambncz;
    this.jdField_a_of_type_Int = parambncz.b();
    this.jdField_a_of_type_Bncs = parambncz.a();
    this.d = parambncz.a();
    this.jdField_a_of_type_Bnck = parambnck;
  }
  
  public void a()
  {
    bndb.a(this.c);
    bndb.a(this.jdField_a_of_type_Bncw);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Bncs != null) {
      this.jdField_a_of_type_Bncs.a(paramFloat);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bncs != null) {
      this.jdField_a_of_type_Bncs.a(paramFloat1, paramFloat2);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.jdField_a_of_type_Bncz != null) && (this.jdField_a_of_type_Bncz.f()))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_Bncz.a();
      bndb.a(this.c);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.c = bndb.a(((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap(), false);
      }
      if (this.jdField_a_of_type_Bnck != null) {
        this.jdField_a_of_type_Bnck.b();
      }
    }
    if ((this.jdField_a_of_type_Bncz != null) && (this.jdField_a_of_type_Bncz.a() != null))
    {
      this.jdField_a_of_type_Bncz.a().d();
      this.jdField_a_of_type_Bncw = this.jdField_a_of_type_Bncz.a().a();
      this.jdField_a_of_type_Bncs.a(this.jdField_a_of_type_Bncw);
    }
    if (this.jdField_a_of_type_Bncs != null)
    {
      this.jdField_a_of_type_Bncs.b(this.c);
      this.jdField_a_of_type_Bncs.c();
      this.jdField_a_of_type_Bncs.d();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glEnable(2884);
    float f = paramInt1 / paramInt2;
    if (this.jdField_a_of_type_Bncs != null) {
      this.jdField_a_of_type_Bncs.b(f);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.b = bnda.a();
    GLES20.glUseProgram(this.b);
    if (this.jdField_a_of_type_Bncs != null) {
      this.jdField_a_of_type_Bncs.a(this.b);
    }
    paramGL10 = this.jdField_a_of_type_Bncz.a();
    if ((paramGL10 != null) && (this.jdField_a_of_type_Bncs != null)) {
      paramGL10.b(this.jdField_a_of_type_Bncs.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnco
 * JD-Core Version:    0.7.0.1
 */