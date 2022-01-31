public class anaw
{
  public float a;
  public int a;
  public String a;
  public float b = 0.0F;
  public float c = 0.0F;
  public float d = 0.0F;
  public float e = 0.0F;
  public float f = 1.0F;
  public float g = 0.0F;
  public float h = 1.0F;
  public float i = 0.0F;
  
  public anaw()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
  }
  
  public anaw(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyingParams {keyType: ").append(this.jdField_a_of_type_Int).append(", screenColorR: ").append(this.jdField_a_of_type_Float).append(", screenColorG: ").append(this.b).append(", screenColorB: ").append(this.c).append(", uA: ").append(this.d).append(", uD: ").append(this.e).append(", u_threshold: ").append(this.f).append(", u_clipBlack: ").append(this.g).append(", u_clipWhite: ").append(this.h).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anaw
 * JD-Core Version:    0.7.0.1
 */