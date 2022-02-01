import android.annotation.TargetApi;

@TargetApi(11)
public class apfq
{
  public float a;
  public int a;
  public float b;
  public float c;
  public float d = 1.0F;
  public float e;
  public float f;
  public float g;
  public float h;
  
  public apfq(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramFloat4;
    this.jdField_a_of_type_Float = paramFloat5;
    this.b = paramFloat6;
    this.jdField_a_of_type_Int = 2;
  }
  
  public apfq(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public static apfq a(float paramFloat1, float paramFloat2)
  {
    return new apfq(1, paramFloat1, paramFloat2);
  }
  
  public static apfq a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return new apfq(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public static apfq b(float paramFloat1, float paramFloat2)
  {
    return new apfq(0, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfq
 * JD-Core Version:    0.7.0.1
 */