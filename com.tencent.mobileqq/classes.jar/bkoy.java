import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public abstract class bkoy
{
  protected double a;
  protected int a;
  private long jdField_a_of_type_Long;
  protected SurfaceTexture a;
  private bkog jdField_a_of_type_Bkog;
  protected bkox a;
  protected volatile boolean a;
  protected final float[] a;
  protected int[] a;
  protected double b;
  protected int b;
  private long jdField_b_of_type_Long = ((Long)yuh.a().a("SmartCutPicSpacing", Long.valueOf(500L))).longValue();
  private boolean jdField_b_of_type_Boolean;
  protected float[] b;
  protected int c;
  private boolean c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l = 90;
  protected final int m = 1080;
  
  public bkoy()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_b_of_type_ArrayOfFloat = new float[16];
  }
  
  public SurfaceTexture a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    }
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.k = arrayOfInt[0];
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.k);
    this.jdField_b_of_type_Boolean = true;
    return this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  }
  
  protected abstract void a();
  
  public abstract void a(float paramFloat);
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_b_of_type_Double = (paramInt1 / paramInt2);
    if ((paramInt3 > 0) && (paramInt4 > 0))
    {
      this.g = paramInt3;
      this.h = paramInt4;
      this.jdField_a_of_type_Double = (this.g / this.h);
    }
    this.e = paramInt5;
    this.f = ((int)(this.e / this.jdField_b_of_type_Double));
    this.jdField_c_of_type_Int = paramInt5;
    this.d = ((int)(this.jdField_c_of_type_Int / this.jdField_b_of_type_Double));
    this.jdField_a_of_type_Int = 1080;
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Int / this.jdField_b_of_type_Double));
  }
  
  public void a(bkog parambkog)
  {
    this.jdField_a_of_type_Bkog = parambkog;
  }
  
  public abstract void a(boolean paramBoolean);
  
  public void a(boolean paramBoolean, int paramInt, bkox parambkox)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.l = paramInt;
    this.jdField_a_of_type_Bkox = parambkox;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
        System.arraycopy(paramArrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0, 16);
      }
      return;
    }
    catch (Exception paramArrayOfFloat)
    {
      paramArrayOfFloat.printStackTrace();
    }
  }
  
  public int[] a()
  {
    return new int[] { this.jdField_c_of_type_Int, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int };
  }
  
  public abstract int[] a(int paramInt1, int paramInt2, boolean paramBoolean);
  
  protected abstract void b();
  
  public abstract void c();
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bkog != null)
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.jdField_a_of_type_Long >= this.jdField_b_of_type_Long)
      {
        this.jdField_a_of_type_Bkog.a(GlUtil.captureFrame(paramInt, this.e, this.f, 0));
        this.jdField_a_of_type_Long = l1;
      }
    }
  }
  
  public void d()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      a();
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.k;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
      this.jdField_b_of_type_Boolean = false;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      b();
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public boolean e()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkoy
 * JD-Core Version:    0.7.0.1
 */