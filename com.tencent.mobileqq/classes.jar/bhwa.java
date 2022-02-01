import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;

public final class bhwa
{
  @NonNull
  public static final bhwa a;
  @NonNull
  public static final bhwa b;
  @NonNull
  public static final bhwa c;
  @NonNull
  public static final bhwa d;
  @NonNull
  public static final bhwa e;
  @NonNull
  public static final bhwa f;
  boolean jdField_a_of_type_Boolean = true;
  final float[] jdField_a_of_type_ArrayOfFloat = new float[3];
  final float[] b;
  final float[] c;
  
  static
  {
    jdField_a_of_type_Bhwa = new bhwa();
    c(jdField_a_of_type_Bhwa);
    d(jdField_a_of_type_Bhwa);
    jdField_b_of_type_Bhwa = new bhwa();
    b(jdField_b_of_type_Bhwa);
    d(jdField_b_of_type_Bhwa);
    jdField_c_of_type_Bhwa = new bhwa();
    a(jdField_c_of_type_Bhwa);
    d(jdField_c_of_type_Bhwa);
    d = new bhwa();
    c(d);
    e(d);
    e = new bhwa();
    b(e);
    e(e);
    f = new bhwa();
    a(f);
    e(f);
  }
  
  bhwa()
  {
    this.jdField_b_of_type_ArrayOfFloat = new float[3];
    this.jdField_c_of_type_ArrayOfFloat = new float[3];
    a(this.jdField_a_of_type_ArrayOfFloat);
    a(this.jdField_b_of_type_ArrayOfFloat);
    b();
  }
  
  private static void a(bhwa parambhwa)
  {
    parambhwa.jdField_b_of_type_ArrayOfFloat[1] = 0.26F;
    parambhwa.jdField_b_of_type_ArrayOfFloat[2] = 0.45F;
  }
  
  private static void a(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = 0.0F;
    paramArrayOfFloat[1] = 0.5F;
    paramArrayOfFloat[2] = 1.0F;
  }
  
  private void b()
  {
    this.jdField_c_of_type_ArrayOfFloat[0] = 0.24F;
    this.jdField_c_of_type_ArrayOfFloat[1] = 0.52F;
    this.jdField_c_of_type_ArrayOfFloat[2] = 0.24F;
  }
  
  private static void b(bhwa parambhwa)
  {
    parambhwa.jdField_b_of_type_ArrayOfFloat[0] = 0.3F;
    parambhwa.jdField_b_of_type_ArrayOfFloat[1] = 0.5F;
    parambhwa.jdField_b_of_type_ArrayOfFloat[2] = 0.7F;
  }
  
  private static void c(bhwa parambhwa)
  {
    parambhwa.jdField_b_of_type_ArrayOfFloat[0] = 0.55F;
    parambhwa.jdField_b_of_type_ArrayOfFloat[1] = 0.74F;
  }
  
  private static void d(bhwa parambhwa)
  {
    parambhwa.jdField_a_of_type_ArrayOfFloat[0] = 0.35F;
    parambhwa.jdField_a_of_type_ArrayOfFloat[1] = 1.0F;
  }
  
  private static void e(bhwa parambhwa)
  {
    parambhwa.jdField_a_of_type_ArrayOfFloat[1] = 0.3F;
    parambhwa.jdField_a_of_type_ArrayOfFloat[2] = 0.4F;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float a()
  {
    return this.jdField_a_of_type_ArrayOfFloat[0];
  }
  
  void a()
  {
    int j = 0;
    int k = this.jdField_c_of_type_ArrayOfFloat.length;
    int i = 0;
    float f2;
    for (float f1 = 0.0F; i < k; f1 = f2)
    {
      float f3 = this.jdField_c_of_type_ArrayOfFloat[i];
      f2 = f1;
      if (f3 > 0.0F) {
        f2 = f1 + f3;
      }
      i += 1;
    }
    if (f1 != 0.0F)
    {
      k = this.jdField_c_of_type_ArrayOfFloat.length;
      i = j;
      while (i < k)
      {
        if (this.jdField_c_of_type_ArrayOfFloat[i] > 0.0F)
        {
          float[] arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
          arrayOfFloat[i] /= f1;
        }
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float b()
  {
    return this.jdField_a_of_type_ArrayOfFloat[1];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float c()
  {
    return this.jdField_a_of_type_ArrayOfFloat[2];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float d()
  {
    return this.jdField_b_of_type_ArrayOfFloat[0];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float e()
  {
    return this.jdField_b_of_type_ArrayOfFloat[1];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float f()
  {
    return this.jdField_b_of_type_ArrayOfFloat[2];
  }
  
  public float g()
  {
    return this.jdField_c_of_type_ArrayOfFloat[0];
  }
  
  public float h()
  {
    return this.jdField_c_of_type_ArrayOfFloat[1];
  }
  
  public float i()
  {
    return this.jdField_c_of_type_ArrayOfFloat[2];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhwa
 * JD-Core Version:    0.7.0.1
 */