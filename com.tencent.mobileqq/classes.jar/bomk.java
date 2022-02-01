import android.support.annotation.FloatRange;

public class bomk
{
  private float jdField_a_of_type_Float = 1.0F;
  private bomj jdField_a_of_type_Bomj = new bomj();
  
  public bomj a()
  {
    bomj.b(this.jdField_a_of_type_Bomj, this.jdField_a_of_type_Float - bomj.a(this.jdField_a_of_type_Bomj));
    return this.jdField_a_of_type_Bomj;
  }
  
  public bomk a(@FloatRange(from=0.01D) float paramFloat)
  {
    bomj.a(this.jdField_a_of_type_Bomj, paramFloat);
    return this;
  }
  
  public bomk b(@FloatRange(from=0.01D) float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomk
 * JD-Core Version:    0.7.0.1
 */