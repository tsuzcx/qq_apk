import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class bdyr
  extends bdyp
  implements bdxk<SpriteGLView>
{
  protected bdxm a;
  protected bdyu a;
  protected FloatBuffer a;
  protected ShortBuffer a;
  protected final float[] a;
  protected final short[] a;
  protected FloatBuffer b;
  protected float[] b;
  private final float[] c;
  
  public bdyr()
  {
    this.jdField_c_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F };
    this.jdField_a_of_type_ArrayOfShort = new short[] { 0, 1, 2, 3, 4, 5 };
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.jdField_b_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_Bdxm = new bdxm(0.0F, 0.0F);
    f();
  }
  
  public bdyr(SpriteGLView paramSpriteGLView)
  {
    this.jdField_c_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F };
    this.jdField_a_of_type_ArrayOfShort = new short[] { 0, 1, 2, 3, 4, 5 };
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.jdField_b_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_Bdxm = new bdxm(0.0F, 0.0F);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    f();
  }
  
  public bdyr(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.jdField_c_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F };
    this.jdField_a_of_type_ArrayOfShort = new short[] { 0, 1, 2, 3, 4, 5 };
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.jdField_b_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_Bdxm = new bdxm(0.0F, 0.0F);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_Bdyu = new bdyu(paramSpriteGLView, paramBitmap);
    g();
    f();
  }
  
  public bdyu a()
  {
    return this.jdField_a_of_type_Bdyu;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdyu != null) {
      this.jdField_a_of_type_Bdyu.c();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_c_of_type_Float = paramFloat1;
    this.d = paramFloat2;
  }
  
  public void a(bdyu parambdyu)
  {
    this.jdField_a_of_type_Bdyu = parambdyu;
    g();
  }
  
  public void a(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_Bdyu = new bdyu(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, paramBitmap);
    g();
  }
  
  protected void aK_()
  {
    super.aK_();
    if (this.jdField_a_of_type_Bdyu != null) {
      this.jdField_a_of_type_Bdyu.b = false;
    }
  }
  
  public int c()
  {
    this.jdField_a_of_type_Bdyu.b();
    return this.jdField_a_of_type_Bdyu.jdField_a_of_type_Int;
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    if (this.jdField_a_of_type_Bdyu == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null) {
      GLES20.glUseProgram(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.c);
    }
    GLES20.glBindTexture(3553, c());
    GLES20.glEnableVertexAttribArray(paramInt3);
    GLES20.glVertexAttribPointer(paramInt3, 3, 5126, false, 0, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glEnableVertexAttribArray(paramInt4);
    GLES20.glVertexAttribPointer(paramInt4, 2, 5126, false, 0, this.jdField_b_of_type_JavaNioFloatBuffer);
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    Matrix.translateM(this.jdField_b_of_type_ArrayOfFloat, 0, 0.0F, 0.0F, -1.0E-004F);
    a(this.jdField_a_of_type_Bdxm);
    float f2 = paramInt1 / paramInt2;
    float f3 = paramInt1 / this.jdField_a_of_type_Float / (this.e * b());
    float f4 = (2.0F * this.jdField_a_of_type_Bdxm.jdField_a_of_type_Float * b() - paramInt1) / paramInt2;
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b)) {}
    for (float f1 = (-paramInt2 + 2.0F * this.jdField_a_of_type_Bdxm.jdField_b_of_type_Float * b()) / paramInt2;; f1 = (paramInt2 - 2.0F * this.jdField_a_of_type_Bdxm.jdField_b_of_type_Float * b()) / paramInt2)
    {
      Matrix.translateM(this.jdField_b_of_type_ArrayOfFloat, 0, f4, f1, 0.0F);
      Matrix.rotateM(this.jdField_b_of_type_ArrayOfFloat, 0, -this.g, 0.0F, 0.0F, 1.0F);
      Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, f2 / f3, f2 / f3 * (this.jdField_b_of_type_Float / this.jdField_a_of_type_Float), 1.0F);
      float[] arrayOfFloat = new float[16];
      Matrix.multiplyMM(arrayOfFloat, 0, paramArrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0);
      GLES20.glUniformMatrix4fv(paramInt5, 1, false, arrayOfFloat, 0);
      GLES20.glUniform1i(paramInt6, 0);
      GLES20.glUniform1f(paramInt7, this.jdField_a_of_type_Int * b() / 255.0F / 255.0F);
      GLES20.glDrawElements(4, this.jdField_a_of_type_ArrayOfShort.length, 5123, this.jdField_a_of_type_JavaNioShortBuffer);
      GLES20.glDisableVertexAttribArray(paramInt3);
      GLES20.glDisableVertexAttribArray(paramInt4);
      return;
    }
  }
  
  public int d()
  {
    if ((this.jdField_a_of_type_Bdyu == null) || (this.jdField_a_of_type_Bdyu.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_Bdyu.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      return (int)this.jdField_a_of_type_Float;
    }
    return this.jdField_a_of_type_Bdyu.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
  }
  
  public int e()
  {
    if ((this.jdField_a_of_type_Bdyu == null) || (this.jdField_a_of_type_Bdyu.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_Bdyu.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      return (int)this.jdField_b_of_type_Float;
    }
    return this.jdField_a_of_type_Bdyu.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(this.jdField_c_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.jdField_c_of_type_ArrayOfFloat);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    this.jdField_a_of_type_JavaNioShortBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfShort.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer().put(this.jdField_a_of_type_ArrayOfShort);
    this.jdField_a_of_type_JavaNioShortBuffer.position(0);
    this.jdField_b_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_Bdyu == null) || (this.jdField_a_of_type_Bdyu.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      return;
    }
    this.jdField_a_of_type_Float = this.jdField_a_of_type_Bdyu.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    this.jdField_b_of_type_Float = this.jdField_a_of_type_Bdyu.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyr
 * JD-Core Version:    0.7.0.1
 */