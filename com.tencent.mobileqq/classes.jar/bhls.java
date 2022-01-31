public class bhls
{
  private int jdField_a_of_type_Int;
  private final float[] jdField_a_of_type_ArrayOfFloat;
  
  public bhls(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfFloat = new float[paramInt];
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfFloat.length) {}
    for (int i = this.jdField_a_of_type_Int; i == 0; i = this.jdField_a_of_type_ArrayOfFloat.length) {
      return 0.0F;
    }
    int j = 0;
    float f1 = 0.0F;
    while (j < i)
    {
      f1 += this.jdField_a_of_type_ArrayOfFloat[j];
      j += 1;
    }
    float f2 = f1 / i;
    f1 = 0.0F;
    j = 0;
    while (j < i)
    {
      float f3 = this.jdField_a_of_type_ArrayOfFloat[j] - f2;
      f1 += f3 * f3;
      j += 1;
    }
    return f1 / i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ArrayOfFloat[(this.jdField_a_of_type_Int % this.jdField_a_of_type_ArrayOfFloat.length)] = paramFloat;
    this.jdField_a_of_type_Int += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhls
 * JD-Core Version:    0.7.0.1
 */