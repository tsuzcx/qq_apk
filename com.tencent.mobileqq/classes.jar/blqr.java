import android.support.annotation.FloatRange;

public class blqr
{
  private float jdField_a_of_type_Float = 1.0F;
  private blqq jdField_a_of_type_Blqq = new blqq();
  
  public blqq a()
  {
    blqq.b(this.jdField_a_of_type_Blqq, this.jdField_a_of_type_Float - blqq.a(this.jdField_a_of_type_Blqq));
    return this.jdField_a_of_type_Blqq;
  }
  
  public blqr a(@FloatRange(from=0.01D) float paramFloat)
  {
    blqq.a(this.jdField_a_of_type_Blqq, paramFloat);
    return this;
  }
  
  public blqr b(@FloatRange(from=0.01D) float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqr
 * JD-Core Version:    0.7.0.1
 */