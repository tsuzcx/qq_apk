public class axhu
{
  private double a;
  public int a;
  public int b;
  
  public axhu() {}
  
  public axhu(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Double = (paramInt1 / paramInt2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof axhu)) {
        return false;
      }
      paramObject = (axhu)paramObject;
    } while ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.b == paramObject.b));
    return false;
  }
  
  public String toString()
  {
    return "CustomSize[width=" + this.jdField_a_of_type_Int + ", height=" + this.b + ", scaleWH='" + this.jdField_a_of_type_Double + ']';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axhu
 * JD-Core Version:    0.7.0.1
 */