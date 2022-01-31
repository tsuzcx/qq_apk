public class bffe
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  
  public float a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return 0.0F;
    }
    return this.jdField_a_of_type_Float / this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float += paramFloat;
    this.jdField_a_of_type_Int += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bffe
 * JD-Core Version:    0.7.0.1
 */