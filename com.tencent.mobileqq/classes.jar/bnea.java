import android.support.annotation.FloatRange;

public class bnea
{
  private float jdField_a_of_type_Float = 1.0F;
  private bndz jdField_a_of_type_Bndz = new bndz();
  
  public bndz a()
  {
    bndz.b(this.jdField_a_of_type_Bndz, this.jdField_a_of_type_Float - bndz.a(this.jdField_a_of_type_Bndz));
    return this.jdField_a_of_type_Bndz;
  }
  
  public bnea a(@FloatRange(from=0.01D) float paramFloat)
  {
    bndz.a(this.jdField_a_of_type_Bndz, paramFloat);
    return this;
  }
  
  public bnea b(@FloatRange(from=0.01D) float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnea
 * JD-Core Version:    0.7.0.1
 */