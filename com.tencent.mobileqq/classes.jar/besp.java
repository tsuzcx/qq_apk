public class besp
{
  public alzs[] a = new alzs[0];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SoLoadConfBean:");
    if (this.a != null)
    {
      alzs[] arrayOfalzs = this.a;
      int j = arrayOfalzs.length;
      int i = 0;
      while (i < j)
      {
        alzs localalzs = arrayOfalzs[i];
        if (localalzs != null) {
          localStringBuilder.append("confItem ").append(localalzs.jdField_a_of_type_Int).append(":").append(localalzs.jdField_a_of_type_JavaLangString).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     besp
 * JD-Core Version:    0.7.0.1
 */