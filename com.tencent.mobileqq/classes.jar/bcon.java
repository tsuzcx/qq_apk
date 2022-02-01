public class bcon
{
  public aqlg[] a = new aqlg[0];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SoLoadConfBean:");
    if (this.a != null)
    {
      aqlg[] arrayOfaqlg = this.a;
      int j = arrayOfaqlg.length;
      int i = 0;
      while (i < j)
      {
        aqlg localaqlg = arrayOfaqlg[i];
        if (localaqlg != null) {
          localStringBuilder.append("confItem ").append(localaqlg.jdField_a_of_type_Int).append(":").append(localaqlg.jdField_a_of_type_JavaLangString).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcon
 * JD-Core Version:    0.7.0.1
 */