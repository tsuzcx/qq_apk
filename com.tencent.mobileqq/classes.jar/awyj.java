public class awyj
{
  public int a;
  public final int[] a;
  
  public awyj()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = new int[6];
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(this.jdField_a_of_type_Int);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      localStringBuilder.append('#').append(i).append('_').append(this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awyj
 * JD-Core Version:    0.7.0.1
 */