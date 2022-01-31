import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.FloatBuffer;

public abstract class bhgy
{
  protected int a;
  protected bhgr a;
  protected bhgz a;
  protected bhhc a;
  protected FloatBuffer a;
  protected boolean a;
  protected float[] a;
  protected float b;
  protected int b;
  protected FloatBuffer b;
  protected float[] b;
  protected float c;
  protected int c;
  protected float d;
  protected int d;
  protected float e;
  protected int e;
  protected float f;
  protected int f;
  protected int g = 1;
  protected int h;
  protected int i;
  
  public bhgy(boolean paramBoolean)
  {
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_b_of_type_ArrayOfFloat = new float[16];
    this.jdField_d_of_type_Float = 1.0F;
    this.jdField_f_of_type_Float = 360.0F;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public float a()
  {
    return this.jdField_f_of_type_Float;
  }
  
  public abstract int a();
  
  public FloatBuffer a()
  {
    return this.jdField_a_of_type_JavaNioFloatBuffer;
  }
  
  protected abstract void a();
  
  public void a(float paramFloat)
  {
    this.jdField_d_of_type_Float = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Float += paramFloat1;
    this.jdField_c_of_type_Float += paramFloat2;
  }
  
  public void a(int paramInt)
  {
    a();
    if ((this.jdField_a_of_type_JavaNioFloatBuffer == null) || (this.jdField_b_of_type_JavaNioFloatBuffer == null)) {
      b();
    }
    c(paramInt);
    e();
    f();
    g();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public void a(bhgr parambhgr)
  {
    this.jdField_a_of_type_Bhgr = parambhgr;
  }
  
  public void a(bhgz parambhgz)
  {
    this.jdField_a_of_type_Bhgz = parambhgz;
  }
  
  public void a(bhhc parambhhc)
  {
    this.jdField_a_of_type_Bhhc = parambhhc;
  }
  
  protected float[] a()
  {
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(arrayOfFloat, 0);
    Matrix.multiplyMM(arrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_ArrayOfFloat, 0);
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    return arrayOfFloat;
  }
  
  public abstract int b();
  
  public FloatBuffer b()
  {
    return this.jdField_b_of_type_JavaNioFloatBuffer;
  }
  
  protected abstract void b();
  
  public void b(float paramFloat)
  {
    this.jdField_e_of_type_Float = paramFloat;
    if (this.jdField_e_of_type_Int == 1)
    {
      if ((this instanceof bhgx)) {
        this.jdField_d_of_type_Float = 0.5228754F;
      }
    }
    else {
      return;
    }
    this.jdField_d_of_type_Float = 0.4142652F;
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract void c();
  
  protected void c(int paramInt)
  {
    this.jdField_b_of_type_Int = GLES20.glGetAttribLocation(paramInt, "aPosition");
    this.jdField_c_of_type_Int = GLES20.glGetUniformLocation(paramInt, "uProjectMatrix");
    this.jdField_d_of_type_Int = GLES20.glGetAttribLocation(paramInt, "aTextureCoord");
  }
  
  public int d()
  {
    return this.g;
  }
  
  public abstract void d();
  
  public void d(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  protected void e()
  {
    if (a() != null)
    {
      a().position(0);
      GLES20.glVertexAttribPointer(this.jdField_b_of_type_Int, a(), 5126, false, 0, a());
      GLES20.glEnableVertexAttribArray(this.jdField_b_of_type_Int);
    }
  }
  
  protected void f()
  {
    if (b() != null)
    {
      b().position(0);
      GLES20.glVertexAttribPointer(this.jdField_d_of_type_Int, b(), 5126, false, 0, b());
      GLES20.glEnableVertexAttribArray(this.jdField_d_of_type_Int);
    }
  }
  
  protected void g()
  {
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhgy
 * JD-Core Version:    0.7.0.1
 */