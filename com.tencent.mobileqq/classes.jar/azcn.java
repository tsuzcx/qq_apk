import android.graphics.Matrix;

public class azcn
{
  protected float a;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  protected float b;
  private float c = 1.0F;
  private float d;
  
  public static int a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2 + 0.001F) {
      return 1;
    }
    if (paramFloat1 < paramFloat2 - 0.001F) {
      return -1;
    }
    return 0;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ArrayOfFloat[2];
    this.b = this.jdField_a_of_type_ArrayOfFloat[5];
    if (paramBoolean1) {
      this.c = ((float)Math.hypot(this.jdField_a_of_type_ArrayOfFloat[1], this.jdField_a_of_type_ArrayOfFloat[4]));
    }
    if (paramBoolean2) {
      this.d = ((float)Math.toDegrees(Math.atan2(this.jdField_a_of_type_ArrayOfFloat[3], this.jdField_a_of_type_ArrayOfFloat[4])));
    }
  }
  
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 >= paramFloat2 - 0.001F) && (paramFloat1 <= paramFloat2 + 0.001F);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public Matrix a()
  {
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public azcn a()
  {
    azcn localazcn = new azcn();
    localazcn.a(this);
    return localazcn;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat1, paramFloat2);
    a(false, false);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    a(true, false);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f;
    for (;;)
    {
      f = paramFloat4;
      if (paramFloat4 >= -180.0F) {
        break;
      }
      paramFloat4 += 360.0F;
    }
    while (f > 180.0F) {
      f -= 360.0F;
    }
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = f;
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (paramFloat3 != 1.0F) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(paramFloat3, paramFloat3);
    }
    if (f != 0.0F) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(f);
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat1, paramFloat2);
  }
  
  public void a(Matrix paramMatrix)
  {
    paramMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  public void a(azcn paramazcn)
  {
    this.jdField_a_of_type_Float = paramazcn.jdField_a_of_type_Float;
    this.b = paramazcn.b;
    this.c = paramazcn.c;
    this.d = paramazcn.d;
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramazcn.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  public float b()
  {
    return this.b;
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(-this.jdField_a_of_type_Float + paramFloat1, -this.b + paramFloat2);
    a(false, false);
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(paramFloat1 / this.c, paramFloat1 / this.c, paramFloat2, paramFloat3);
    a(true, false);
  }
  
  public float c()
  {
    return this.c;
  }
  
  public void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(paramFloat1, paramFloat2, paramFloat3);
    a(false, true);
  }
  
  public float d()
  {
    return this.d;
  }
  
  public void d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(-this.d + paramFloat1, paramFloat2, paramFloat3);
    a(false, true);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (azcn)paramObject;
    } while ((a(paramObject.jdField_a_of_type_Float, this.jdField_a_of_type_Float)) && (a(paramObject.b, this.b)) && (a(paramObject.c, this.c)) && (a(paramObject.d, this.d)));
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    int i;
    int j;
    if (this.jdField_a_of_type_Float != 0.0F)
    {
      i = Float.floatToIntBits(this.jdField_a_of_type_Float);
      if (this.b == 0.0F) {
        break label95;
      }
      j = Float.floatToIntBits(this.b);
      label37:
      if (this.c == 0.0F) {
        break label100;
      }
    }
    label95:
    label100:
    for (int k = Float.floatToIntBits(this.c);; k = 0)
    {
      if (this.d != 0.0F) {
        m = Float.floatToIntBits(this.d);
      }
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label37;
    }
  }
  
  public String toString()
  {
    return "{x=" + this.jdField_a_of_type_Float + ",y=" + this.b + ",zoom=" + this.c + ",rotation=" + this.d + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcn
 * JD-Core Version:    0.7.0.1
 */