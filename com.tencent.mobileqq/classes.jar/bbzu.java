public class bbzu
{
  public aptx[] a = new aptx[0];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SoLoadConfBean:");
    if (this.a != null)
    {
      aptx[] arrayOfaptx = this.a;
      int j = arrayOfaptx.length;
      int i = 0;
      while (i < j)
      {
        aptx localaptx = arrayOfaptx[i];
        if (localaptx != null) {
          localStringBuilder.append("confItem ").append(localaptx.jdField_a_of_type_Int).append(":").append(localaptx.jdField_a_of_type_JavaLangString).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzu
 * JD-Core Version:    0.7.0.1
 */