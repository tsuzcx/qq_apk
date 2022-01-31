public class axnn
{
  public ampi[] a = new ampi[0];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SoLoadConfBean:");
    if (this.a != null)
    {
      ampi[] arrayOfampi = this.a;
      int j = arrayOfampi.length;
      int i = 0;
      while (i < j)
      {
        ampi localampi = arrayOfampi[i];
        if (localampi != null) {
          localStringBuilder.append("confItem ").append(localampi.jdField_a_of_type_Int).append(":").append(localampi.jdField_a_of_type_JavaLangString).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnn
 * JD-Core Version:    0.7.0.1
 */