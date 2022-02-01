public class bdhf
{
  public araj[] a = new araj[0];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SoLoadConfBean:");
    if (this.a != null)
    {
      araj[] arrayOfaraj = this.a;
      int j = arrayOfaraj.length;
      int i = 0;
      while (i < j)
      {
        araj localaraj = arrayOfaraj[i];
        if (localaraj != null) {
          localStringBuilder.append("confItem ").append(localaraj.jdField_a_of_type_Int).append(":").append(localaraj.jdField_a_of_type_JavaLangString).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhf
 * JD-Core Version:    0.7.0.1
 */