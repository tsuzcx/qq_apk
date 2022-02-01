public class bdgp
{
  public aqxa[] a = new aqxa[0];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SoLoadConfBean:");
    if (this.a != null)
    {
      aqxa[] arrayOfaqxa = this.a;
      int j = arrayOfaqxa.length;
      int i = 0;
      while (i < j)
      {
        aqxa localaqxa = arrayOfaqxa[i];
        if (localaqxa != null) {
          localStringBuilder.append("confItem ").append(localaqxa.jdField_a_of_type_Int).append(":").append(localaqxa.jdField_a_of_type_JavaLangString).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgp
 * JD-Core Version:    0.7.0.1
 */