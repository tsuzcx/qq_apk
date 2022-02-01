public abstract class aruj<DATA, CONFIG extends aruw>
  extends aruc<DATA, CONFIG>
{
  private float[] a;
  private float d;
  private float e = -1.0F;
  private float f;
  
  public aruj(arul paramarul)
  {
    super(paramarul);
  }
  
  public float a()
  {
    return -this.f;
  }
  
  protected float a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    return f() - (float)(paramLong - l) * this.f;
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
  {
    if (!a(paramLong1))
    {
      arwe.c("BaseDanmaku", "onLayout, Y = " + paramFloat2 + ", danmaku = " + toString());
      this.d = a(paramLong2);
      if (!c())
      {
        this.e = paramFloat2;
        a(true);
      }
      return;
    }
    a(false);
  }
  
  public void a(long paramLong)
  {
    this.d = a(paramLong);
  }
  
  public float[] a(long paramLong)
  {
    if (!b()) {
      return null;
    }
    float f1 = a(paramLong);
    if (this.jdField_a_of_type_ArrayOfFloat == null) {
      this.jdField_a_of_type_ArrayOfFloat = new float[4];
    }
    this.jdField_a_of_type_ArrayOfFloat[0] = (f1 - arul.a().b());
    this.jdField_a_of_type_ArrayOfFloat[1] = this.e;
    this.jdField_a_of_type_ArrayOfFloat[2] = (f1 + this.jdField_a_of_type_Float + this.c);
    this.jdField_a_of_type_ArrayOfFloat[3] = (this.e + this.b);
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public float b()
  {
    return this.d;
  }
  
  public float[] b(long paramLong)
  {
    if (!b()) {
      return null;
    }
    float f1 = a(paramLong);
    if (this.jdField_a_of_type_ArrayOfFloat == null) {
      this.jdField_a_of_type_ArrayOfFloat = new float[4];
    }
    this.jdField_a_of_type_ArrayOfFloat[0] = f1;
    this.jdField_a_of_type_ArrayOfFloat[1] = this.e;
    this.jdField_a_of_type_ArrayOfFloat[2] = (f1 + this.jdField_a_of_type_Float);
    this.jdField_a_of_type_ArrayOfFloat[3] = (this.e + this.b);
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public float c()
  {
    return this.e;
  }
  
  public float d()
  {
    return this.d + this.jdField_a_of_type_Float;
  }
  
  public float e()
  {
    return this.e + this.b;
  }
  
  public void g()
  {
    super.g();
    this.f = ((int)(f() + this.jdField_a_of_type_Float) / (float)this.jdField_a_of_type_Arvu.a());
  }
  
  public void g(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public void h(float paramFloat)
  {
    this.e = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aruj
 * JD-Core Version:    0.7.0.1
 */